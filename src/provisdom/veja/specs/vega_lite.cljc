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

(s/def ::Angle (s/double-in :min -360 :max 360))
(s/def ::Overlap (s/or :boolean boolean? :enum #{:parity :greedy}))
(s/def ::Size (s/double-in :min 0))
(s/def ::Opacity (s/double-in :min 0 :max 1))

(s/def :Axis/domain boolean?)
(s/def :Axis/format string?)
(s/def :Axis/grid boolean?)
(s/def :Axis/labelAngle ::Angle)
(s/def :Axis/labelBound (s/or :boolean boolean? :number number?))
(s/def :Axis/labelFlush (s/or :boolean boolean? :number number?))
(s/def :Axis/labelOverlap ::Overlap)
(s/def :Axis/labelPadding number?)
(s/def :Axis/labels boolean?)
(s/def :Axis/maxExtent number?)
(s/def :Axis/minExtent number?)
(s/def :Axis/offset number?)
(s/def :Axis/orient ::AxisOrient)
(s/def :Axis/position number?)
(s/def :Axis/tickCount number?)
(s/def :Axis/tickSize ::Size)
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

(s/def :AxisConfig/bandPosition number?)
(s/def :AxisConfig/domain boolean?)
(s/def :AxisConfig/domainColor string?)
(s/def :AxisConfig/domainWidth number?)
(s/def :AxisConfig/grid boolean?)
(s/def :AxisConfig/gridColor string?)
(s/def :AxisConfig/gridDash (s/coll-of number?))
(s/def :AxisConfig/gridOpacity ::Opacity)
(s/def :AxisConfig/gridWidth ::Size)
(s/def :AxisConfig/labelAngle ::Angle)
(s/def :AxisConfig/labelBound (s/or :boolean boolean? :number number?))
(s/def :AxisConfig/labelColor string?)
(s/def :AxisConfig/labelFlush (s/or :boolean boolean? :number number?))
(s/def :AxisConfig/labelFont string?)
(s/def :AxisConfig/labelFontSize ::Size)
(s/def :AxisConfig/labelLimit number?)
(s/def :AxisConfig/labelOverlap ::Overlap)
(s/def :AxisConfig/labelPadding number?)
(s/def :AxisConfig/labels boolean?)
(s/def :AxisConfig/maxExtent number?)
(s/def :AxisConfig/minExtent number?)
(s/def :AxisConfig/shortTimeLabels boolean?)
(s/def :AxisConfig/tickColor string?)
(s/def :AxisConfig/tickRound boolean?)
(s/def :AxisConfig/tickSize ::Size)
(s/def :AxisConfig/tickWidth ::Size)
(s/def :AxisConfig/ticks boolean?)
(s/def :AxisConfig/titleAlign string?)
(s/def :AxisConfig/titleAngle number?)
(s/def :AxisConfig/titleBaseline string?)
(s/def :AxisConfig/titleColor string?)
(s/def :AxisConfig/titleFont string?)
(s/def :AxisConfig/titleFontSize ::Size)
(s/def :AxisConfig/titleFontWeight ::FontWeight)
(s/def :AxisConfig/titleLimit number?)
(s/def :AxisConfig/titleMaxLength number?)
(s/def :AxisConfig/titlePadding number?)
(s/def :AxisConfig/titleX number?)
(s/def :AxisConfig/titleY number?)
(s/def ::AxisConfig (s/keys :opt-un [:AxisConfig/bandPosition :AxisConfig/domain :AxisConfig/domainColor
                                     :AxisConfig/domainColor :AxisConfig/grid :AxisConfig/gridColor
                                     :AxisConfig/gridDash :AxisConfig/gridOpacity :AxisConfig/gridWidth
                                     :AxisConfig/gridWidth :AxisConfig/labelAngle :AxisConfig/labelBound
                                     :AxisConfig/labelColor :AxisConfig/labelFlush :AxisConfig/labelFont
                                     :AxisConfig/labelFontSize :AxisConfig/labelLimit :AxisConfig/labelOverlap
                                     :AxisConfig/labelPadding :AxisConfig/labels :AxisConfig/maxExtent
                                     :AxisConfig/maxExtent :AxisConfig/minExtent :AxisConfig/shortTimeLabels
                                     :AxisConfig/tickColor :AxisConfig/tickRound :AxisConfig/tickSize
                                     :AxisConfig/tickWidth :AxisConfig/ticks :AxisConfig/titleAlign
                                     :AxisConfig/titleAngle :AxisConfig/titleBaseline :AxisConfig/titleColor
                                     :AxisConfig/titleColor :AxisConfig/titleFont :AxisConfig/titleFontSize
                                     :AxisConfig/titleFontWeight :AxisConfig/titleLimit :AxisConfig/titleMaxLength
                                     :AxisConfig/titlePadding :AxisConfig/titleMaxLength :AxisConfig/titlePadding
                                     :AxisConfig/titleX :AxisConfig/titleY]))

(s/def ::AxisOrient #{:top :left :right :bottom})

(s/def :AxisResolveMap/x ::ResolveMode)
(s/def :AxisResolveMap/y ::ResolveMode)
(s/def ::AxisResolveMap (s/keys :opt-un [:AxisResolveMap/x :AxisResolveMap/y]))

(s/def :BarConfig/align ::HorizontalAlign)
(s/def :BarConfig/angle (s/double-in :min 0 :max 360))
(s/def :BarConfig/baseline ::VerticalAlign)
(s/def :BarConfig/binSpacing ::Size)
(s/def :BarConfig/color string?)
(s/def :BarConfig/continuousBandSize ::Size)
(s/def :BarConfig/cursor #{:auto :default :none :context-menu :help :pointer :progress
                           :wait :cell :crosshair :text :vertical-text :alias :copy
                           :move :no-drop :not-allowed :e-resize :n-resize :ne-resize
                           :nw-resize :s-resize :se-resize :sw-resize :w-resize
                           :ew-resize :ns-resize :nesw-resize :nwse-resize :col-resize
                           :row-resize :all-scroll :zoom-in :zoom-out :grab :grabbing})
(s/def :BarConfig/discreteBandSize ::Size)
(s/def :BarConfig/dx number?)
(s/def :BarConfig/dy number?)
(s/def :BarConfig/fill string?)
(s/def :BarConfig/fillOpacity ::Opacity)
(s/def :BarConfig/filled boolean?)
(s/def :BarConfig/font string?)
(s/def :BarConfig/fontSize ::Size)
(s/def :BarConfig/fontStyle ::FontStyle)
(s/def :BarConfig/fontWeight ::FontWeight)
(s/def :BarConfig/href string?)
(s/def :BarConfig/interpolate ::Interpolate)
(s/def :BarConfig/limit number?)
(s/def :BarConfig/opacity ::Opacity)
(s/def :BarConfig/orient ::Orient)
(s/def :BarConfig/radius ::Size)
(s/def :BarConfig/shape string?)
(s/def :BarConfig/size ::Size)
(s/def :BarConfig/stroke string?)
(s/def :BarConfig/strokeDash (s/coll-of number?))
(s/def :BarConfig/strokeDashOffset number?)
(s/def :BarConfig/strokeOpacity ::Opacity)
(s/def :BarConfig/strokeWidth ::Size)
(s/def :BarConfig/tension (s/double-in :min 0 :max 1))
(s/def :BarConfig/text string?)
(s/def :BarConfig/theta number?)
(s/def ::BarConfig (s/keys :opt-in [:BarConfig/discreteBandSize :BarConfig/dx :BarConfig/dy
                                    :BarConfig/fill :BarConfig/fillOpacity :BarConfig/filled
                                    :BarConfig/font :BarConfig/fontSize :BarConfig/fontStyle
                                    :BarConfig/href :BarConfig/interpolate :BarConfig/limit
                                    :BarConfig/opacity :BarConfig/orient :BarConfig/radius
                                    :BarConfig/shape :BarConfig/size :BarConfig/stroke
                                    :BarConfig/strokeDash :BarConfig/strokeDashOffset
                                    :BarConfig/strokeOpacity :BarConfig/strokeWidth
                                    :BarConfig/tension :BarConfig/text :BarConfig/theta]))

(s/def ::BasicType #{:quantitative :ordinal :temporal :nominal})

(s/def :BinParams/base (s/int-in 2 17))
(s/def :BinParams/divide (s/coll-of number?))
(s/def :BinParams/extent (s/tuple number? number?))
(s/def :BinParams/maxbins (s/double-in :min 2))
(s/def :BinParams/minstep number?)
(s/def :BinParams/nice boolean?)
(s/def :BinParams/step number?)
(s/def :BinParams/steps (s/coll-of number? :min-count 1))
(s/def ::BinParams (s/keys :opt-in [:BinParams/base :BinParams/divide :BinParams/extent
                                    :BinParams/maxbins :BinParams/minstep :BinParams/nice
                                    :BinParams/step :BinParams/steps]))

(s/def :BinTransform/as string?)
(s/def :BinTransform/bin (s/or :boolean boolean? :bin-params ::BinParams))
(s/def :BinTransform/field string?)
(s/def ::BinTransform (s/keys :req-un [:BinTransform/as :BinTransform/bin :BinTransform/field]))

(s/def :BrushConfig/fill string?)
(s/def :BrushConfig/fillOpacity ::Opacity)
(s/def :BrushConfig/stroke string?)
(s/def :BrushConfig/strokeDash (s/coll-of number?))
(s/def :BrushConfig/strokeDashOffset number?)
(s/def :BrushConfig/strokeOpacity ::Opacity)
(s/def :BrushConfig/strokeWidth number?)
(s/def ::BrushConfig (s/keys :opt-un [:BrushConfig/fill :BrushConfig/fillOpacity :BrushConfig/stroke
                                      :BrushConfig/strokeDash :BrushConfig/strokeDashOffset
                                      :BrushConfig/strokeOpacity :BrushConfig/strokeWidth]))

(s/def :CalculateTransform/as string?)
(s/def :CalculateTransform/calculate string?)
(s/def ::CalculateTransform (s/keys :req-un [:CalculateTransform/as :CalculateTransform/calculate]))

(s/def ::CompositeUnitSpec ::CompositeUnitSpecAlias)

(s/def ::Conditional<FieldDef> (s/or :predicate ::ConditionalPredicate<FieldDef>
                                     :selection ::ConditionalSelection<FieldDef>))
(s/def ::Conditional<MarkPropFieldDef> (s/or :predicate ::ConditionalPredicate<MarkPropFieldDef>
                                             :selection ::ConditionalSelection<MarkPropFieldDef>))
(s/def ::Conditional<TextFieldDef> (s/or :predicate ::ConditionalPredicate<TextFieldDef>
                                         :selection ::ConditionalSelection<TextFieldDef>))
(s/def ::Conditional<ValueDef> (s/or :predicate ::ConditionalPredicate<ValueDef>
                                     :selection ::ConditionalSelection<ValueDef>))

(s/def :ConditionalPredicate/aggregate ::Aggregate)
(s/def :ConditionalPredicate/bin (s/or :boolean boolean? :bin-params ::BinParams))
(s/def :ConditionalPredicate/field (s/or :string string? :repeat-ref ::RepeatRef))
(s/def :ConditionalPredicate/format string?)
(s/def :ConditionalPredicate/legend (s/nilable? ::Legend))
(s/def :ConditionalPredicate/scale ::Scale)
(s/def :ConditionalPredicate/sort (s/nilable? (s/or :order ::SortOrder :field ::SortField)))
(s/def :ConditionalPredicate/test ::LogicalOperand<Predicate>)
(s/def :ConditionalPredicate/timeUnit ::TimeUnit)
(s/def :ConditionalPredicate/type ::Type)
(s/def :ConditionalPredicate/value (s/or :number number? :string string? :boolean boolean?))
(s/def ::ConditionalPredicate<FieldDef> (s/keys :req-un [:ConditionalPredicate/test :ConditionalPredicate/type]
                                                :opt-un [:ConditionalPredicate/aggregate :ConditionalPredicate/bin
                                                         :ConditionalPredicate/timeUnit]))
(s/def ::ConditionalPredicate<MarkPropFieldDef>
       (s/keys [:req-un [:ConditionalPredicate/test :ConditionalPredicate/type]
                :opt-un [:ConditionalPredicate/aggregate :ConditionalPredicate/bin
                         :ConditionalPredicate/field :ConditionalPredicate/legend
                         :ConditionalPredicate/scale :ConditionalPredicate/sort
                         :ConditionalPredicate/timeUnit]]))
(s/def ::ConditionalPredicate<TextFieldDef> (s/keys :req-un [:ConditionalPredicate/test :ConditionalPredicate/type]
                                                    :opt-un [:ConditionalPredicate/aggregate :ConditionalPredicate/bin
                                                             :ConditionalPredicate/field :ConditionalPredicate/format
                                                             :ConditionalPredicate/timeUnit]))
(s/def ::ConditionalPredicate<ValueDef> (s/keys :req-un [:ConditionalPredicate/test :ConditionalPredicate/value]))

(s/def :ConditionalSelection/selection ::SelectionOperand)
(s/def ::ConditionalSelection<FieldDef> (s/keys :req-un [:ConditionalPredicate/selection :ConditionalPredicate/type]
                                                :opt-un [:ConditionalPredicate/aggregate :ConditionalPredicate/bin
                                                         :ConditionalPredicate/timeUnit]))
(s/def ::ConditionalSelection<MarkPropFieldDef>
       (s/keys [:req-un [:ConditionalPredicate/selection :ConditionalPredicate/type]
                :opt-un [:ConditionalPredicate/aggregate :ConditionalPredicate/bin
                         :ConditionalPredicate/field :ConditionalPredicate/legend
                         :ConditionalPredicate/scale :ConditionalPredicate/sort
                         :ConditionalPredicate/timeUnit]]))
(s/def ::ConditionalSelection<TextFieldDef> (s/keys :req-un [:ConditionalPredicate/selection :ConditionalPredicate/type]
                                                    :opt-un [:ConditionalPredicate/aggregate :ConditionalPredicate/bin
                                                             :ConditionalPredicate/field :ConditionalPredicate/format
                                                             :ConditionalPredicate/timeUnit]))
(s/def ::ConditionalSelection<ValueDef> (s/keys :req-un [:ConditionalPredicate/selection :ConditionalPredicate/value]))
