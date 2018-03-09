(ns provisdom.veja.core
  (:require [clojupyter.protocol.mime-convertible :as mc]
            [clojure.java.io :as io]
            [scjsv.core :as v]
            [clojure.pprint :refer [pprint]]))

(def validate-vega-lite (v/validator (slurp (io/resource "vega-lite-v2.json"))))
(def validate-vega (v/validator (slurp (io/resource "vega-v3.json"))))

(defrecord VegaLite [vega-data]
  mc/PMimeConvertible
  (to-mime [_]
    (mc/stream-to-string
      {:application/vnd.vegalite.v2+json (assoc vega-data :$schema "https://vega.github.io/schema/vega-lite/v2.json")})))

(defrecord Vega [vega-data]
  mc/PMimeConvertible
  (to-mime [_]
    (mc/stream-to-string
      {:application/vnd.vega.v3+json (assoc vega-data :$schema "https://vega.github.io/schema/vega/v3.json")})))

(defn vega
  ([vega-data] (vega vega-data false))
  ([vega-data print-validation-result]
   (when-let [error (and print-validation-result (validate-vega vega-data))]
     (pprint error))
   (Vega. vega-data)))

(defn vega-lite
  ([vega-data] (vega-lite vega-data false))
  ([vega-data print-validation-result]
   (when-let [error (and print-validation-result (validate-vega-lite vega-data))]
     (pprint error))
   (VegaLite. vega-data)))
