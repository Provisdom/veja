(ns provisdom.veja.specs.vega-lite
  (:require [clojure.spec.alpha :as s]))

(s/def ::AggregateOp #{:argmax
                       :argmin
                       :average
                       :count
                       :distinct
                       :max
                       :mean
                       :median
                       :min
                       :missing
                       :q1
                       :q3
                       :ci0
                       :ci1
                       :stdev
                       :stdevp
                       :sum
                       :valid
                       :values
                       :variance
                       :variancep})

(s/def ::Aggregate ::AggregateOp)

(s/def :AggregateFieldDef/as string?)
(s/def :AggregateFieldDef/field string?)
(s/def :AggregateFieldDef/op string?)

(s/def ::AggregateFieldDef (s/keys :req-un [:AggregateFieldDef/as :AggregateFieldDef/field :AggregateFieldDef/op]))

(s/def :AggregateTransform/aggregate (s/coll-of ::AggregateFieldDef))
(s/def :AggregateTransform/groupBy (s/coll-of string?))

(s/def ::AggregateTransform (s/keys :req-un [:AggregateTransform/aggregate] :opt-un [:AggregateTransform/group-by]))

(s/def ::Anchor #{:start :middle :end})

(s/def ::AnyMark (s/or :mark ::Mark :mark-def ::MarkDef))

(s/def ::AutosizeType #{:pad :fit :none})

(s/def :AutoSizeParams/contains #{:content :padding})
(s/def :AutoSizeParams/resize boolean?)
(s/def :AutoSizeParams/type ::autosize-type)
(s/def ::AutoSizeParams (s/keys :opt-un [:AutoSizeParams/contains :AutoSizeParams/resize :AutoSizeParams/type]))

(s/def :Axis/domain boolean?)
(s/def :Axis/format string?)
(s/def :Axis/grid boolean?)
(s/def :Axis/labelAngle (s/double-in :min -360 :max 360))
(s/def :Axis/labelBound (s/or :boolean boolean? :number number?))
(s/def :Axis/labelFlush (s/or :boolean boolean? :number number?))
(s/def :Axis/labelOverlap (s/or :boolean boolean? :enum #{:parity :greedy}))
(s/def :Axis/labelPadding number?)
(s/def :Axis/labels boolean?)
(s/def :Axis/maxExtent number?)
(s/def :Axis/minExtent number?)
(s/def :Axis/offset number?)
(s/def :Axis/orient ::AxisOrient)
(s/def :Axis/position number?)
(s/def :Axis/tickCount number?)
(s/def :Axis/tickSize (s/double-in :min 0))
(s/def :Axis/ticks boolean?)
(s/def :Axis/title (s/nilable? string?))
(s/def :Axis/titleMaxLength number?)
(s/def :Axis/titlePadding number?)
(s/def :Axis/values (s/or :numbers (s/coll-of number?) :times (s/coll-of ::DateTime)))
(s/def :Axis/zindex (s/double-in :min 0))
(s/def ::Axis (s/keys :opt-un [:Axis/domain :Axis/format :Axis/grid :Axis/labelAngle
                               :Axis/labelBound :Axis/labelFlush :Axis/labelOverlap
                               :Axis/labelPadding :Axis/labels :Axis/maxExtent
                               :Axis/minExtent :Axis/offset :Axis/orient :Axis/position
                               :Axis/tickCount :Axis/tickSize :Axis/ticks :Axis/title
                               :Axis/titleMaxLength :Axis/titlePadding :Axis/values
                               :Axis/zindex]))
