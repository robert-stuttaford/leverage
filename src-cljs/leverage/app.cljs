(ns leverage.app
  (:require [dommy.core :as dommy]
            [leverage.domain :as domain])
  (:use-macros [dommy.macros :only [node sel1]]))

(defn render-table!
  [table-data]
  (let [html-data (domain/make-html-table table-data)]
    
    (.log js/console (pr-str html-data))
    
    (dommy/replace-contents!
     ;; find #content in the page
     (sel1 :#content)
     ;; convert html data into DOM nodes
     (node html-data))))

(defn ^:export sample
  []
  (render-table! domain/sample-data))

(defn ^:export processed
  []
  (render-table! domain/processed-sample-data))
