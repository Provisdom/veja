(ns provisdom.veja.core
  (:require [clojupyter.protocol.mime-convertible :as mc]
            [clojure.java.io :as io]
            [scjsv.core :as v]
            [clojure.pprint :refer [pprint]]))

(def vega-defs {:vega-lite {:validator (v/validator (slurp (io/resource "vega-lite.json")))
                            :schema "https://vega.github.io/schema/vega-lite/v1.json"
                            :mime-type "application/vnd.vegalite.v1+json"}
                :vega-lite2 {:validator (v/validator (slurp (io/resource "vega-lite-v2.json")))
                             :schema "https://vega.github.io/schema/vega-lite/v2.json"
                             :mime-type "application/vnd.vegalite.v2+json"}
                :vega {:validator (v/validator (slurp (io/resource "vega-v2.json")))
                       :schema "https://vega.github.io/schema/vega/v2.json"
                       :mime-type "application/vnd.vega.v2+json"}
                :vega3 {:validator (v/validator (slurp (io/resource "vega-v3.json")))
                        :schema "https://vega.github.io/schema/vega/v3.json"
                        :mime-type "application/vnd.vega.v3+json"}})



(defrecord Vega [vega-data vega-type]
  mc/PMimeConvertible
  (to-mime [_]
    (mc/stream-to-string
      {(-> vega-defs vega-type :mime-type) (assoc vega-data :$schema (-> vega-defs vega-type :schema))})))

(defn vega
  ([vega-type vega-data] (vega vega-type vega-data false))
  ([vega-type vega-data print-validation-result]
   (when-let [error (and print-validation-result ((-> vega-defs vega-type :validator) vega-data))]
     (pprint error))
   (Vega. vega-data vega-type)))
