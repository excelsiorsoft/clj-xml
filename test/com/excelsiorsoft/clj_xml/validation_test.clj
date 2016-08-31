(ns com.excelsiorsoft.clj-xml.validation-test
  (:require [clojure.test :refer :all]
            [com.excelsiorsoft.clj-xml.validation :refer :all]))

(def validate (validate-against "resources/test.xsd"))

(deftest inline-xml
  (testing "valid xml is  passed in as as string")
  (is (= true (validate "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<addresses xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n xsi:noNamespaceSchemaLocation='test.xsd'>\n\n <address>\n <name>Joe Tester</name>\n <street>Baker street 5</street>\n </address>\n\n</addresses>"))))
