(defproject com.excelsiorsoft.clj-xml "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://com.excelsiorsoft/clj-xml"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :main ^:skip-aot com.excelsiorsoft.clj-xml.validation
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
