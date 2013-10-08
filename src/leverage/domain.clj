(ns leverage.domain)

;; Define and inspect some data

(def sample-data
  {:cols ["One" "Two" "Three"]
   :rows [[1 2 3]
          [4 5 6]
          [7 8 9]]})

(comment
  sample-data

  

  (get sample-data :cols)
  (:cols sample-data)

  
  
  (get-in sample-data [:rows 1 1])
  
  
  )

;; Process some data

(defn row-with-sum
  [row]
  (conj row (apply + row)))

(comment
  (row-with-sum [1 2 3])

  
  )

(defn process-row-sums
  [rows]
  (map row-with-sum rows))

(def processed-sample-data
  (-> sample-data
      (update-in [:cols] conj "Sum")
      (update-in [:rows] process-row-sums)))

(comment
  processed-sample-data

  

  sample-data

  
  )

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

(comment
  (make-html-table sample-data)

  
)
