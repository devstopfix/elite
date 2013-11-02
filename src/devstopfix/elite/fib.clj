(ns devstopfix.elite.fib)

(defn int-16-bits [i]
	"Keep a number within 16 bits"
	(let [mask (dec (bit-shift-left 1 16))]
		(bit-and i mask)))

; http://en.wikipedia.org/wiki/Fibonacci_number
(defn next-fib-triple [triple]
	"Use a Fibonacci algorithm to generate the next triple"
	(let [[w0 w1 w2] triple]
		[w1 w2 (int-16-bits (+ w0 w1 w2))]))

(defn quadruple-seed [initial-seed]
	"Make a list of the given seed and it's next 4 iterations"
	(loop [seeds (vector initial-seed)
		   remaining 4]
		   (if (zero? remaining)
		   	seeds
		   	(recur (conj seeds (next-fib-triple (last seeds))) (dec remaining)))))
