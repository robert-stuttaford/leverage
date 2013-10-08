(defproject leverage "0.1.0-SNAPSHOT"
  :description "Get leverage with Clojure! A demonstration of Clojure and ClojureScript"

  :url "https://github.com/robert-stuttaford/leverage"
  
  :dependencies
  [;; Clojure
   [org.clojure/clojure "1.5.1"]
   ;; ClojureScript
   [org.clojure/clojurescript "0.0-1909"]
   ;; Web server
   [ring-server "0.2.8"]
   ;; HTTP Routing
   [compojure "1.1.5"]
   ;; Server-side HTML Templating
   [hiccup "1.0.4"]
   ;; Client-side HTML Templating and DOM
   [prismatic/dommy "0.1.1"]]
  
  :repl-options
  {;; Predictable REPL port
   :port 9991
   ;; Start the REPL here
   :init-ns leverage.server}
  
  :plugins
  [ ;; ClojureScript compiler
   [lein-cljsbuild "0.3.3"]
   ;; ClojureScript browser-connected REPL
   [com.cemerick/austin "0.1.0"]]
  
  ;; ClojureScript -> JavaScript compilation
  :cljsbuild
  { ;; Clojure namespaces to include in ClojureScript
   :crossovers [leverage.domain]
   ;; produce a .js file
   :builds
   [{:id "dev"
     :source-paths ["src-cljs"]
     :compiler
     {:pretty-print true
      :output-to "resources/public/js/leverage.js"
      :optimizations :whitespace}}]})
