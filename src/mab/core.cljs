(ns mab.core
    (:require [reagent.core :as r]))

(enable-console-print!)

(def weather-icons
  {:sunny "http://icons.iconarchive.com/icons/icons-land/weather/256/Sunny-icon.png"
   :cloudy "http://icons.iconarchive.com/icons/oxygen-icons.org/oxygen/256/Status-weather-clouds-icon.png"})

(defn weather
  [city temp low high conditions]
  [:div.weather-widget
   [:div.container
    [:div.row
     [:div.col-md-8
      [:div.row
       [:div.col-md-12
        [:div.city
          [:h2 city]]]]
      [:div.row
       [:div.col-md-8
        [:div.current-temp
         [:h3 (str temp "˚")]]]]
      [:div.row
       [:div.col-md-6.low-temp
        [:h2 "Low"]
        [:h3 (str low "˚")]]
       [:div.col-md-6.hi-temp
        [:h2 "High"]
        [:h3 (str high "˚")]]]]

     [:div.col-md-4
      [:div.conditions
       [:img {:width 200 :src (get weather-icons conditions)}]]]]]])

(defn weather-pane
  [& weather-data]
  [:div.weather-pane weather-data])

(defn main
  []
  [:div.container
   [:section
    [:div.container
     [weather-pane
      [weather "Dallas" 35 23 73 :cloudy]
      [weather "Austin" 76 30 105 :sunny]
      [weather "Chicago" 20 10 30 :cloudy]]]]])

(r/render [main] (js/document.getElementById "app"))
