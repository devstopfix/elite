(ns devstopfix.elite-test
  (:require [clojure.test :refer :all]
            [devstopfix.elite :refer :all])
  (:import java.util.Random))

(deftest first-planet-of-seq
  (testing "The first planet of the first Elite galaxy"
	(is (= "Tibedied" (first (planets-in-elite-galaxy 1))))))

(deftest planet-lave
  (testing "The eighth planet of the first Elite galaxy is Lave"
	(is (= "Lave" (nth (planets-in-elite-galaxy 1) (dec 8))))))

(deftest test-last-planet
  (testing "The last planet of the eigth Elite galaxy"
	(is (= "Intiso" (last (take 256 (planets-in-elite-galaxy 8)))))))

(deftest test-random-planet-from-seed
 	(testing "Using a seeded Java Random generates a known planet"
		(is (= "Retiraqu" (first (planets-in-seeded-galaxy (Random. 42)))))))
