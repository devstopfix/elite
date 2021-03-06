Planet Name Generator
=====================

A [Clojure](http://clojure.org/) library that generates a lazy sequence of [planet](http://en.wikipedia.org/wiki/Planet) names from the orginal [Elite video game][1].

Samples:
* Lave
* Isinor
* Zaonce

## Credits

The algorithm for the planet name generation is © 1984 [Ian Bell](http://www.iancgbell.clara.net/)  and [David Braben](https://twitter.com/DavidBraben). The Clojure source is a conversion of the [Elite C sources](http://www.iancgbell.clara.net/elite/text/index.htm).

## Usage

```clj
(require ['devstopfix.elite :as 'elite])

(take 256 (elite/planets-in-elite-galaxy 1))

(nth (elite/planets-in-elite-galaxy 1) 7)
; "Lave"

(take 256 (elite/planets-in-random-galaxy))
```

## Bugs

Some seeds (e.g. [0x00d2 0x669d 0x0d37]) will create a galaxy containing a planet with no letters in the name.

## License

The algorithm is Copyright 1984/1999 of Ian Bell and David Braben. This clojure code is Copyright © 2013 J Every and distributed under the GNU GENERAL PUBLIC LICENSE version 3.0.

 [1]: http://en.wikipedia.org/wiki/Elite_(video_game)