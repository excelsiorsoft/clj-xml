(ns com.excelsiorsoft.clj-xml.validation-test
  (:require [clojure.test :refer :all]
            [com.excelsiorsoft.clj-xml.validation :refer :all]))

(def validate (validate-against "resources/test.xsd"))

(deftest inline-xml
  (testing "valid xml is  passed in as as string")
  (is (= true (validate "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<addresses xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n xsi:noNamespaceSchemaLocation='test.xsd'>\n\n <address>\n <name>Joe Tester</name>\n <street>Baker street 5</street>\n </address>\n\n</addresses>"))))

(deftest inline-wrong-xml
  (testing "valid xml is  passed in as as string")
  (is (= false (validate "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<addresses xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n xsi:noNamespaceSchemaLocation='test.xsd'>\n\n <address>\n <abc/><name>Joe Tester</name>\n <street>Baker street 5</street>\n </address>\n\n</addresses>"))))


(deftest ouside-xml
  (testing "valid xml is  passed in as as an external file")
  (is (= true (validate (slurp "resources/valid.xml")))))

(deftest ouside-xml
  (testing "valid xml is  passed (twice) in as as an external file")
  (is (= true (validate (slurp "resources/valid.xml"))))
  (is (= true (validate (slurp "resources/valid.xml")))))

