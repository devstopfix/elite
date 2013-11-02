(ns devstopfix.elite-galaxy-test
  (:require [clojure.test :refer :all]
            [devstopfix.elite.galaxy :refer :all]))

(deftest galaxy-1
	(is (= [0x5A4A 0x0248 0xB753] (elite-galaxy-seed 1))))

(deftest galaxy-2
	(is (= [0xB494 0x0490 0x6FA6] (elite-galaxy-seed 2))))

(deftest test-rlc8
	(is (= 0x00 (rlc8 0x00)))
	(is (= 0x02 (rlc8 0x01)))
	(is (= 0x08 (rlc8 0x04)))
	(is (= 0x01 (rlc8 0x80))))
