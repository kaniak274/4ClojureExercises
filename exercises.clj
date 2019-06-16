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
   (fn [x y]
     (if (re-find #"[A-Z]" (str y))
       (str x y)
       x)
     )
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


















