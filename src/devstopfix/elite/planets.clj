(ns devstopfix.elite.planets
	[:use [devstopfix.elite.fib :only [quadruple-seed]]]
	[:require [devstopfix.elite [galaxy :as galaxy]]]
	[:import java.lang.Character])


(defn is-long-name? [seed]
	"If bit 6 of the first word is set then we have a four-pair name,
	 otherwise we have a three-pair name"
	 (bit-test (first seed) 6))

(defn letter-pair [index]
	"Return a list of 1 or 2 letters at given index in the planet name pairs string. 
	 The character '.' means no character and is dropped."
	(let [planet-name-pairs "..LEXEGEZACEBISOUSESARMAINDIREA.ERATENBERALAVETIEDORQUANTEISRION"]
		(filter #(Character/isLetter %)
			[ (.charAt planet-name-pairs index) 
			  (.charAt planet-name-pairs (inc index)) ])))

(defn pair-index-of-seed [seed]
	"Use the lower 5 bits of the high byte of the last word as an index into the letter pairs.
	 The index is multiplied by 2 to align to pairs of words. 5 bits * 2 gives a maximum of 62, 
	 and the letter pair string is 64 letters long."
	(* 2 (bit-and (bit-shift-right (last seed) 8) 0x1F)))

(defn title-case-chars [chars]
	"Convert a list of Characters into a string into Title case."
	(apply str 
		(Character/toUpperCase (first chars)) 
		(map #(Character/toLowerCase %) (rest chars))))

(defn planet-name-and-next-seed [seed]
	"Generate the planet name from the seed, and return the name and the seed to be used for the next planet"
	(let [seeds  (quadruple-seed seed)
		  pseeds (if (is-long-name? seed) (drop-last seeds) (drop-last 2 seeds))]
		[(title-case-chars (flatten (map (comp letter-pair pair-index-of-seed) pseeds)))
		  (last seeds)]))

(defn planet-name [seed]
	"Generate the planet name String from the seed"
	(let [[planet next-seed] (planet-name-and-next-seed seed)]
		planet))

(defn planet-names [seed]
	"Return a lazy seq of planet names starting with the given seed"
	(let [[planet next-seed] (planet-name-and-next-seed seed)]
    	(cons planet (lazy-seq (planet-names next-seed)))))
