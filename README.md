# Get leverage with Clojure!

This code accompanied a talk given at Tech4Africa on the 9th of October 2013 in Sandton, South Africa.

It demonstrates a bare minimum sample that shares code between server and client, with Clojure and ClojureScript respectively.

It also demonstrates a basic Datomic query.

## Usage

* Clone the repo.
* Install leiningen from (leiningen.org)[leiningen.org].
* Run `lein cljsbuild once`.
* Run `lein repl`.
* At the repl, enter the following two commands:
  * `(require '[leverage.server])`
  * `(leverage.server/start-web!)`
* Visit `localhost:3333`.

## License

Copyright © 2013 Robert Stuttaford

Distributed under the Eclipse Public License either version 1.0 or any later version.
