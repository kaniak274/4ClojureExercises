(def x '[[1 0 0 1] [0 1 1 0] [0 1 1 0] [1 0 0 1]])
(def y '[[1 0 0 1] [0 1 1 0] [0 1 0 0] [1 0 0 0]])
(def z '[[1 1 1 1] [0 0 1 0] [0 1 0 0] [1 1 1 1]])

(def choices '["x" "y" "z"])

(def input_letter '[[1 0 0 1] [0 1 1 0] [0 1 1 0] [1 0 0 1]])

(defn zip [x y] (vec (map vector x y)))

(defn count_black [coll] (Math/sqrt (reduce + coll)))

(def letters [(vec (flatten x)) (vec (flatten y)) (vec (flatten z))])
(def blacks (vec (map count_black letters)))

(defn calc_weights []
  (partition
    16
    (flatten
      (map-indexed
        (fn [idx, letter]
          (map
            (fn [part] (if (= part 0) 0 (/ part (get blacks idx))))
            letter))
        letters))))

(def letters_weights (vec (calc_weights)))

(def input_vector (flatten input_letter))
(def input_weights
  (let [input_blacks (count_black input_vector)]
    (map
      (fn [part] (if (= part 0) 0 (/ part input_blacks)))
      input_vector)))

(defn calc_wanted_output [coll, weights]
  (reduce
    +
    (reduce
      (fn [x y] (conj x (* (get y 0) (get y 1))))
      '[]
      (zip coll weights))))

(defn calc_output_letters [coll weights]
  (map-indexed
    (fn [idx letter] (calc_wanted_output letter (get weights idx)))
    coll))

; get index of min value from calculated differents and then return choice at specific index
(defn decide_letter [letters_output wanted_output]
  (get
    choices
    (first
      (apply
        min-key
        second
        (map-indexed
          vector
          (map
            (fn [output] (Math/abs (- output wanted_output)))
            letters_output))))))

(print (decide_letter
         (calc_output_letters letters letters_weights)
         (calc_wanted_output input_vector input_weights)))
