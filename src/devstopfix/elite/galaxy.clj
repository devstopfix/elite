(ns devstopfix.elite.galaxy
	(import java.util.Random))
;
; A galaxy is defined by a Vector of three 16-bit Integers.
(def elite-galaxy-1-seed [0x5A4A 0x0248 0xB753])


(def twists-per-galaxy 131072)

; http://www.z80.info/z80syntx.htm#RLC
(defn rlc8 [x]
    "Rotate-left circular of lowest 8 bits. 
     (see http://www.z80.info/gfx/zrlc.gif)"
    (+ (bit-shift-left (bit-and x 0x7F) 1) (bit-shift-right (bit-and x 0x80) 7)))

(defn twist [x]
	"Apply RLC to the high and low bytes separately."
	(+ (bit-shift-left (rlc8 (bit-shift-right x 8)) 8) 
	   (rlc8 (bit-and x 255))))

(defn next-galaxy [galactic-seed]
	"Can only be used 8 times before the galaxies repeat"
	(map twist galactic-seed))

(defn elite-galaxy-seed [galaxy-n]
	"Generate seeds for the original Elite galaxies 1 though 8"
	 (if (> galaxy-n 1)
		(last 
			(take galaxy-n 
				(iterate next-galaxy elite-galaxy-1-seed)))
		elite-galaxy-1-seed))

(defn random-galaxy-seed []
	"Generate the seed for a random galaxy"
	(vec (for [i (range 3)] (rand-int 65536))))

(defn pseudo-random-galaxy-seed [^Random pseudo-random]
	"Generate the seed for a galaxy from a seeded pseudo-random number generator"
	(vec (for [i (range 3)] (.nextInt pseudo-random 65536))))

(defn format-galaxy-seed [galaxy]
	"Format the three Words as hexadecimal."
	(map #(format "0x%04x" %) galaxy))
