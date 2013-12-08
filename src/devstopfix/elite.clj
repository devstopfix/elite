(ns devstopfix.elite
	[:require [devstopfix.elite [galaxy :as galaxy]
	                            [planets :as planets]]]
	[:import java.util.Random])

(defn planets-in-elite-galaxy [galaxy-number]
	"Get a lazy, infinite sequence of planet names in one of the original eight Elite galaxies. 
	 Be sure to limit the sequence with (take 256 ...) although more planets can be taken."
	(planets/planet-names (galaxy/elite-galaxy-seed galaxy-number)))

(defn planets-in-elite-universe
	"Lazy-seq of all planets in the original 8 galaxies. Defaults to 256 planets per galaxy."
	([] (planets-in-elite-universe 256))
	([planets-per-galaxy] (flatten 
		(concat 
			(map #(take planets-per-galaxy (planets-in-elite-galaxy %)) (range 1 9))))))

(defn planets-in-random-galaxy []
	"Lazy-seq of planet names from a random galaxy"
	(planets/planet-names (galaxy/random-galaxy-seed)))

(defn planets-in-seeded-galaxy [^Random pseudo-random]
	"Lazy-seq of planet names from a galaxy derived from pseudo-random seed"
	(planets/planet-names (galaxy/pseudo-random-galaxy-seed pseudo-random)))

(defn galactic-set [galaxy-seed]
	"The set of all possible planet names in a galaxy."
	(into (sorted-set) (take galaxy/twists-per-galaxy (planets/planet-names galaxy-seed))))