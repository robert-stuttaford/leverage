(ns leverage.domain)

(defn make-html-table
  [{:keys [cols rows]}]
  [:table.ui.table.segment
   [:thead
    [:tr
     (for [col cols]
       [:th col])]]
   [:tbody
    (for [cells rows]
      [:tr
       (for [cell cells]
         [:td cell])])]])

(def sample-data
  {:cols ["One" "Two" "Three"]
   :rows [[1 2 3]
          [4 5 6]
          [7 8 9]]})
