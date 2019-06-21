;; Answers for 4clojure.com first 100 questions.

; 1. Nothing but the Truth
true

; 2. Simple Math
4

; 3. Intro to Strings
"HELLO WORLD"

; 4. Intro to Lists
:a :b :c

; 5. Lists: conj
'(1 2 3 4)

; 6. Intro to Vectors
:a :b :c

; 7. Vectors: conj
'[1 2 3 4]

; 8. Intro to Sets
#{:a :b :c :d}

; 9. Sets: conj
1 4 3 2

; 10. Intro to Maps
20

; 11. Maps: conj
{:b 2}

; 12. Intro to Sequences
3

; 13. Sequences: rest
'(20 30 40)

; 14. Intro to Functions
8

; 15. Double Down
(partial * 2)

; 16. Hello World
(fn [name] (str "Hello, " name "!"))

; 17. Sequences: map
'(6 7 8)

; 18. Sequences: filter
'(6 7)

; 19. Local bindings
7

; 20. Let it Be
[x 7 y 3 z 1]

; 21. Regular Expressions
"ABC"

; 22. Intro to Reduce
+

; 23. Simple Recursion
'(5 4 3 2 1)

; 24. Rearranging Code
last

; 25. Recurring Theme
[7 6 5 4 3]

; 26. Rearranging Code: ->>
reduce +

; 27. A nil key
(fn [key dct] (and (contains? dct key) (not (get dct key))))

; 28. For the win
'(1 5 9 13 17 21 25 29 33 37)

; 29. Logical falsity and truth
1

; 30. Intro to Destructuring
[c e]

; 31. Subset and Superset
#{1 2}

; 32. Map Defaults
(fn [default keys] (reduce (fn [x y] (assoc x y default)) {} keys))

; 33. Last Element
(fn [x] (nth (seq x) (- (count x) 1)))

; 34. Penultimate Element
(fn [x] (nth (seq x) (- (count x) 2)))

; 35. Nth Element
(fn [x y] (last (take (+ y 1) x)))

; 36. Count a Sequence
(fn [coll] (reduce (fn [x y] (+ 1 x)) 0 coll))

; 37. Sum It All Up
(fn [x] (reduce + x))

; 38. Find the odd numbers
(fn [x] (filter odd? x))

; 39. Reverse a Sequence
(fn [coll] (reduce (fn [x y] (conj x y)) '() coll))

; 40. Palindrome Detector
(fn [coll] 
  (if (string? coll)
    (if (= coll (reduce (fn [x y] (str y x)) "" coll)) true false)
    (if (= coll (reduce (fn [x y] (conj x y)) '() coll)) true false)))

; 41. Fibonacci Sequence
(fn [x] 
  (loop [i 0 fib 1 fib2 1 result [1]] 
    (if (= i (- x 1)) (seq result) 
      (recur (+ i 1) fib2 (+ fib fib2) (conj result fib2)))))

; 42. Maximum value
(fn [& args]
  (loop [i 0 result 0]
    (if (= i (dec (count args)))
      result
      (recur (inc i)
             (if (< result (nth args i))
               (nth args i)
               result)))))

; 43. Get the Caps
(fn [string]
  (reduce
    (fn [x y] (if (re-find #"[A-Z]" (str y)) (str x y) x))
   ""
   string))

; 44. Duplicate a Sequence
(fn [coll] 
  (seq (reduce (fn [x y] (conj x y y)) [] coll)))

; 45. Intro to some
6

; 46. Compress a Sequence
(fn [x]
  (loop [i 0 result []]
    (if (= i (count x))
      (seq result)
      (recur (inc i)
             (if (= i 0)
               (conj result (get x i))
               (if (= (get x i) (get result (dec (count result))))
                 result
                 (conj result (get x i))))))))

; 47. Implement range
(fn [start end]
  (loop [i start result []]
    (if (= i end)
      (seq result)
      (recur (inc i) (conj result i)))))

; 48. Factorial Fun
(fn [n]
  (loop [i n result 1]
    (if (= i 1)
      result
      (recur (dec i) (* result i)))))

; 49. Interleave Two Seqs
(fn [x y]
  (loop [i 0 result []]
    (if (or (= i (count x)) (= i (count y)))
      (seq result)
      (recur (inc i) (conj result (get x i) (get y i))))))

; 50. Flatten

; 51. Replicate a Sequence
(fn [coll n] (loop [i 0 result []]
  (if (= i (count coll))
    (seq result)
    (recur (inc i)
           (loop [j 0 result2 result]
             (if (= j n)
               result2
               (recur (inc j) (conj result2 (get coll i)))))))))

; 52. Intro to Iterate
'(1 4 7 10 13)

; 53. Contain Yourself
4

; 54. Interpose a Seq
(fn [separator coll]
  (loop [i 0 result []]
    (if (= i (dec (count coll)))
      (seq (conj result (get coll i)))
      (recur (inc i) (conj result (get coll i) separator)))))

; 55. Pack a Sequence

; 56. Drop Every Nth Item
(fn [coll n]
  (loop [i 0 result []]
    (if (= i (count coll))
      (seq result)
      (recur (inc i)
             (if (= (rem (inc i) n) 0)
               result
               (conj result (get coll i)))))))

; 57. Split a sequence
(fn [n coll]
  (loop [i 0 part1 [] part2 []]
    (if (= i (count coll))
      (seq (conj [] part1 part2))
      (recur (inc i)
             (if (>= i n) part1 (conj part1 (get coll i)))
             (if (>= i n) (conj part2 (get coll i)) part2)))))

; 58. Advanced Destructuring
[1 2 3 4 5]

; 59. A Half-Truth
(fn [& args]
  (if (every? true? args)
    false
    (if (some true? args)
      true
      false)))


; 60. Map Construction
(fn [coll1 coll2]
  (loop [i 0 result {}]
    (if (or (= i (count coll1)) (= i (count coll2)))
      result
      (recur (inc i) (assoc result (get coll1 i) (get coll2 i))))))

; 61. Greatest Common Divisor
(fn [a b]
  (loop [a a b b]
    (cond
      (= a 0) b
      (= b 0) a
      :else (recur b (rem a b)))))

; 62. Set Intersection
(fn [set1 set2]
  (set (reduce
    (fn [x y] (if (contains? set2 y) (conj x y) x))
    []
    set1)))

; 63. Simple closures
(fn [n]
  (fn [x]
    (if (= n 0)
      1
      (loop [i n result x]
      (if (= i 1) result (recur (dec i) (* result x)))))))

; 64. Re-implement Iterate

; 65. Comparisons
(fn [operator a b]
  (cond
    (operator a b) :lt
    (operator b a) :gt
    :else :eq))

; 66. Cartesian Product
(fn [set1 set2]
  (set
    (apply concat
           (reduce
             (fn [x y]
               (conj x (reduce (fn [l n] (conj l [n y])) [] set1)))
             #{}
             set2))))

; 67. Product Digits
(fn [a b]
  (reduce
    (fn [x y] (conj x y))
    []
    (map (fn [n] (read-string (str n))) (str (* a b)))))

; 68. Group a Sequence
(fn [f s]
  (reduce
    (fn [x y]
      (let [result (f y)]
        (if (get x result)
          (assoc-in x [result] (conj (get x result) y))
          (assoc x result [y]))))
    {}
    s))

; 69. Symmetric Difference
(fn [set1 set2]
  (if (= (count set1) 0)
    set2
    (reduce
      (fn [x y]
        (if (contains? x y)
          (disj x y)
          (conj x y)))
      set2
      set1)))

; 70. dot product
(fn [coll1 coll2]
  (reduce + (loop [i 0 result []]
    (if (= i (count coll1))
      result
      (recur (inc i) (conj result (* (get coll1 i) (get coll2 i))))))))

; 71. Read a binary number
(fn [number]
  (if (= 0 (read-string number))
    0
    (int (reduce + (loop [i 0 result [] number (reverse number)]
      (if (= i (count number))
        result
        (if (= (str (nth number i)) "0")
          (recur (inc i) result number)
          (recur (inc i) (conj result (Math/pow 2 i)) number))))))))

; 72. Through the Looking Class
Class

; 73. Infix Calculator

; 74. Indexing Sequences
(fn [coll]
  (loop [i 0 result []]
    (if (= i (count coll))
      (seq result)
      (recur (inc i) (conj result [(get coll i) i])))))

; 75. Pascal's Triangle
(fn [row]
  (get
    (loop [i 1 result []]
      (if (= i (inc row))
        result
        (recur (inc i)
               (conj result (loop [column 0 result2 []]
                              (if (= column i)
                                result2
                                (recur (inc column)
                                       (if (or (= column 0) (= column (- i 1)))
                                         (conj result2 1)
                                         (conj result2
                                               (+ (get (get result (- i 2)) column)
                                                  (get (get result (- i 2)) (dec column))))))))))))
    (dec row)))

; 76. Re-implement Map



; Reverse Interleave
(fn [n coll]
  (apply map vector (partition coll n)))


