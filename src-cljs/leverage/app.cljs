(ns leverage.app
  (:require [dommy.core :as dommy]
            [clojure.browser.repl]
            [leverage.domain :as domain])
  (:use-macros [dommy.macros :only [node sel1 deftemplate]]))

(deftemplate make-html-table
  [data]
  (domain/make-table data))

(defn render-table!
  [table-data]
  (let [html-table (domain/make-html-table table-data)]
    (.log js/console html-table)
    (dommy/replace-contents! (sel1 :#content) html-table)))

(defn ^:export start
  []
  (render-table! domain/processed-sample-data))

(comment
  (js/alert "test")
  
  (render-table! domain/processed-sample-data)
  
  (render-table! domain/sample-data))
