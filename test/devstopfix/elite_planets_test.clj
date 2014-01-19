(ns devstopfix.elite-planets-test
  (:use [devstopfix.elite.planets :as planets])
  (:require [clojure.test :refer :all]
            [simple-check.clojure-test :as ct :refer (defspec)]
            [simple-check.core :as sc]
			[simple-check.generators :as gen]
			[simple-check.properties :as prop]))

(defn is-planet-name? [candidate]
  (or
    (.matches candidate "[ABCDEGILMNOQRSTUVXZabcdegilmnoqrstuvxz]{2,8}")
    (.isEmpty candidate)))

(defn no-zero-components? [seed]
  "Check that all components of the seed are not zero, otherwise we get empty planet names."
  (every? #(> % 0) seed))

(defspec test-planet-names-from-seed
  131072
  (prop/for-all [seed-triple (gen/such-that no-zero-components? (gen/vector gen/pos-int 3))]
     (is-planet-name? (planets/planet-name seed-triple))))
