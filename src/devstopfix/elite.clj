(ns devstopfix.elite
	[:use [devstopfix.elite.fib :only [quadruple-seed]]]
	[:require [devstopfix.elite [galaxy :as galaxy]
	                            [planets :as planets]]]
	[:import java.lang.Character])

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
	(planets/planet-names (galaxy/random-galaxy-seed)))