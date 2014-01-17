(ns devstopfix.elite-fib-test
  (:require [clojure.test :refer :all]
            [devstopfix.elite.fib :refer :all]
            [simple-check.clojure-test :as ct :refer (defspec)]
            [simple-check.core :as sc]
			[simple-check.generators :as gen]
			[simple-check.properties :as prop]))

(deftest fib-series
	(is (= [3 5 8] (next-fib-triple [0 3 5]))))

(deftest test-quadruple-seed
	(is (= [[0 3 5] [3 5 8] [5 8 16] [8 16 29] [16 29 53]] (quadruple-seed [0 3 5]))))

(defn is-word? [i]
	(and (>= i 0) (<= i 65535 )))

(defspec test-int-16-bits 
    65536 
    (prop/for-all [i gen/int]
        (is-word? (int-16-bits i))))
