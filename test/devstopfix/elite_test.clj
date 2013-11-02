(ns devstopfix.elite-test
  (:require [clojure.test :refer :all]
            [devstopfix.elite :refer :all]))

(deftest first-planet-of-seq
  (testing "The first planet of the first Elite galaxy"
	(is (= "Tibedied" (first (planets-in-elite-galaxy 1))))))

(deftest planet-lave
  (testing "The eigth planet of the first Elite galaxy is Lave"
	(is (= "Lave" (nth (planets-in-elite-galaxy 1) 7)))))

(deftest test-last-planet
  (testing "The last planet of the eigth Elite galaxy"
	(is (= "Intiso" (last (take 256 (planets-in-elite-galaxy 8)))))))
