(ns provisdom.veja.core
  (:require [clojupyter.protocol.mime-convertible :as mc]))

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
  [vega-data]
  (Vega. vega-data))

(defn vega-lite
  [vega-data]
  (VegaLite. vega-data))
