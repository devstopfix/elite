devstopfix.elite
================

A [Clojure](http://clojure.org/) library that generates a lazy sequence of [planet](http://en.wikipedia.org/wiki/Planet) names from the orginal [Elite video game](http://en.wikipedia.org/wiki/Elite_(video_game)).

## Credits

The algorithm for the planet name generation is © 1984 [Ian Bell](http://www.iancgbell.clara.net/)  and [David Braben](https://twitter.com/DavidBraben). The Clojure source is a conversion of the [Elite C sources](http://www.iancgbell.clara.net/elite/text/index.htm).

## Usage

    (require ['devstopfix.elite :as 'elite])

    (take 256 
      (elite/planets-in-elite-galaxy 1))

    (take 256 
      (elite/planets-in-random-galaxy))

## Learning

I wrote this to learn how to use a [lazy-seq](http://clojure.github.io/clojure/clojure.core-api.html#clojure.core/lazy-seq) and discovered the [iterate](http://clojure.github.io/clojure/clojure.core-api.html#clojure.core/iterate) function. 

## License

This clojure code is Copyright © 2013 J Every and distributed under the Eclipse Public License version 1.0.