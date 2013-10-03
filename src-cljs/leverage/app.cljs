(ns leverage.app
  (:require [dommy.core :as dommy]
            [leverage.domain :as domain])
  (:use-macros [dommy.macros :only [node sel1 deftemplate]]))

(deftemplate make-html-table
  [data]
  (domain/make-table data))

(defn ^:export start
  []
  (dommy/append! (sel1 :#content) 
                 (domain/make-html-table domain/sample-data)))
