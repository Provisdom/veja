# veja

A Clojure library for displaying [Vega](https://vega.github.io/vega/) and [Vega Lite](https://vega.github.io/vega-lite/) 
visualizations in [JupyterLab](https://github.com/jupyterlab/jupyterlab). Simply attaches the appropriate MIME
type to the Vega(Lite) definition, defined as Clojure maps/vectors matching the JSON schema.

*NOTE* - this may work with Jupyter notebooks as well, with the right plugin. We haven't tried it.

## Usage

Run JupyterLab using the [lein-jupyter](https://github.com/Provisdom/lein-jupyter) plug-in. Version 0.1.16 and above should 
have JupyterLab support.

```clojure
(require '[provisdom.veja.core :as veja])

(def bar {:data {:values [{:a "A" :b 28} {:a "B" :b 55} {:a "C" :b 43}
                          {:a "D" :b 91} {:a "E" :b 81} {:a "F" :b 53}
                          {:a "G" :b 19} {:a "H" :b 87} {:a "I" :b 52}]}
          :mark :bar
          :encoding {:x {:field :a, :type :ordinal}
                     :y {:field :b :type :quantitative}}})
                     
(veja/vega-lite bar)
```
<img src="https://github.com/Provisdom/veja/blob/master/doc/visualization.png"/>

The `provisdom.veja.core` namespace contains two functions: `vega` and `vega-lite`. Each takes Vega data defined as Clojure
data-structures corresponding to the JSON definition. Both functions also accept an optional second argument,
`print-validation-result`, which will additionally pretty-print the results of JSON schema validation against your
Vega definition. 

## License

Copyright © 2018 Provisdom Corp.

Distributed under the MIT License.
