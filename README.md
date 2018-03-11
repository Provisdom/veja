# veja

A Clojure library for displaying [Vega](https://vega.github.io/vega/) and [Vega Lite](https://vega.github.io/vega-lite/) 
visualizations in [JupyterLab](https://github.com/jupyterlab/jupyterlab). Simply attaches the appropriate MIME
type to the Vega(Lite) definition, defined as Clojure maps/vectors matching the JSON schema.

*NOTE* - this may work with Jupyter notebook as well, with the right plugin. We haven't tried it.

## Usage

Use dependency `[provisdom/veja "0.2.0"]`

Run JupyterLab using the [lein-jupyter](https://github.com/clojupyter/lein-jupyter) plug-in. Version 0.1.16 and above should 
have JupyterLab support. Use of older versions of Vega (Vega 2/Vega Lite 1) will require the [vega2-extension](https://github.com/jupyterlab/jupyter-renderers/tree/master/packages/vega2-extension).

```clojure
(require '[provisdom.veja.core :as veja])

(def bar {:data {:values [{:a "A" :b 28} {:a "B" :b 55} {:a "C" :b 43}
                          {:a "D" :b 91} {:a "E" :b 81} {:a "F" :b 53}
                          {:a "G" :b 19} {:a "H" :b 87} {:a "I" :b 52}]}
          :mark :bar
          :encoding {:x {:field :a, :type :ordinal}
                     :y {:field :b :type :quantitative}}})
                     
(veja/vega :vega-lite bar)
```
<img src="https://github.com/Provisdom/veja/blob/master/doc/visualization.png"/>

The `vega` function handles plotting for the various Vega flavors. It has two required arguments: `vega-type` and `vega-data`. 
`vega-data` is the Vega plot defined as EDN, following the appropriate JSON schema for `vega-type`. Valid values of
`vega-type` are:
* :vega - Vega version 2
* :vega3 - Vega version 3
* :vega-lite - Vega Lite version 1
* :vega-lite2 - Vega LIte version 2

The `vega` function also accepts an optional second argument,
`print-validation-result`, which will additionally pretty-print the results of JSON schema validation against your
Vega definition. 

*NOTE* - Vega may still produce a plot even if JSON schema validation fails, which is why the `print-validation-result`
simply adds to the output and does not throw an exception. Schema validation output can be very verbose in the case of
a failure, so unless there's an obvious problem with the chart output, you'll want to leave `print-validation-result`
as the default of `false`.

## License

Copyright © 2018 Provisdom Corp.

Distributed under the MIT License.
