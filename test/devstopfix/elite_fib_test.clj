(ns devstopfix.elite-fib-test
  (:require [clojure.test :refer :all]
            [devstopfix.elite.fib :refer :all]))

(deftest fib-series
	(is (= [3 5 8] (next-fib-triple [0 3 5]))))

(deftest test-quadruple-seed
	(is (= [[0 3 5] [3 5 8] [5 8 16] [8 16 29] [16 29 53]] (quadruple-seed [0 3 5]))))