(ns leverage.server
  (:require [ring.server.standalone :as ring-server]
            [compojure.core :refer [defroutes GET routes]]
            [compojure.handler :refer [site]]
            [compojure.route :as compojure]
            [hiccup.core :as hiccup]
            [hiccup.element :as element]
            [hiccup.page :as page]
            [cemerick.austin :as austin]
            [cemerick.austin.repls :as austin-repls]
            [leverage.domain :as domain]))

;; HTML layout

(defn layout
  [& content]
  (hiccup/html
   (page/html5
    [:head
     [:title "Get leverage with Clojure!"]
     [:link {:rel "icon" :href "/images/favicon.png"}]
     (page/include-css "/css/semantic.min.css"
                       "/css/leverage.css")]
    [:body
     [:div.ui.one.column.page.grid
      [:div.column
       [:h1.ui.header
        [:img.ui.floated.left.image {:src "/images/clojure-icon.gif" :width "100" :height "100"}]
        [:div.content "Get leverage with Clojure!"]]
       [:div.ui.compact.menu
        [:a.item {:href "/"} "Clojure"]
        [:a.item {:href "/cljs"} "ClojureScript"]]
       [:div#content
        content]]]])))

(comment
  (layout "Hello, Tech4Africa!")

  
)

;; Pages

(defroutes app-routes
  (GET "/" []
       (layout (domain/make-html-table domain/processed-sample-data)))
  
  (GET "/cljs" []
       (layout
        (page/include-js "/js/leverage.js")
        (element/javascript-tag "leverage.app.start();")
        (element/javascript-tag (austin-repls/browser-connected-repl-js)))))

;; Static files, 404, request/response parsing, etc

(def app (-> (routes app-routes
                     (compojure/resources "/")
                     (compojure/not-found "Not found!"))
             site))

(comment
  (app {:request-method :get :uri "/"})


  
  (app {:request-method :get :uri "/cljs"})

  
  )

;; Web Server

(def web-process (atom nil))

(comment
  @web-process

  
  )

(defn stop-web!
  []
  (when-let [server @web-process]
    (.stop server))
  (reset! web-process nil))

(defn start-web!
  []
  (stop-web!)
  (let [server (ring-server/serve app {:port 3333 :open-browser? false :join? false})]
    (reset! web-process server)))

;; ClojureScript browser-connected REPL

(defn start-cljs-repl!
  []
  (austin-repls/cljs-repl (reset! austin-repls/browser-repl-env (austin/repl-env))))
