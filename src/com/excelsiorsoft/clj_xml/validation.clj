(ns com.excelsiorsoft.clj-xml.validation
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(import 'javax.xml.XMLConstants)
(import 'org.xml.sax.SAXException)
(import 'javax.xml.validation.SchemaFactory)
(import 'java.io.File)
(import 'java.io.StringReader)
(import 'javax.xml.transform.stream.StreamSource)

(defn validate-against [& schemas]
  (let [sources (into-array StreamSource (map #(-> (File. %)
                                                   (StreamSource.)) schemas))
        validator (-> (SchemaFactory/newInstance XMLConstants/W3C_XML_SCHEMA_NS_URI)
                      (.newSchema sources)
                      (.newValidator))]
    (fn [xmldoc]
      (try
        (.validate validator (StreamSource. (StringReader. xmldoc)))
        true
        (catch SAXException e false)))))

;;(def is-valid-xml? (validate-against "resources/test.xsd"))
;;=> #'com.excelsiorsoft.clj-xml.validation/is-valid-xml?
;;(is-valid-xml? "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<addresses xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n           xsi:noNamespaceSchemaLocation='test.xsd'>\n\n    <address>\n        <name>Joe Tester</name>\n        <street>Baker street 5</street>\n    </address>\n\n</addresses>")
;;=> true