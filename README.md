# clj-xml

Clojure wrapper around Java XML schema validation libraries.
validate-against takes a path to an .xsd schema (or a collection thereof) 
and produces a fn which takes an XML string and responds with 'true' (if XML is valid against that schema) 
or 'false' otherwise


## Usage
```
(require '[com.excelsiorsoft.clj-xml.validation :as xmlv])
(def is-valid-xml? (xmlv/validate-against "resources/schema.xsd"))
(is-valid-xml? "<foo><bar/></foo>")
```


## License

Copyright © 2016 Excelsior Software Ltd.

Distributed under the Eclipse Public License.
