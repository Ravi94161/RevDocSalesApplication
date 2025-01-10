<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>Post deliery address</description>
   <name>getMembershipPrices</name>
   <tag></tag>
   <elementGuidId>c8895a14-7971-45f1-a30c-73f4de07fb79</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\&quot;query\&quot;:\&quot;\\n  query getMembershipPrices($where: MembershipPrice_where) {\\n    MembershipPrices(where: $where) {\\n      docs {\\n        \\nid\\naffiliation {\\n  id,\\n  effectiveDate,\\n  termDate,\\n  affiliationName,\\n  affiliationType,\\n  affiliationCoverPhoto{\\n    url\\n    mediaType\\n    id\\n  }\\n}\\nmembershipProduct {\\n  type\\n}\\nprice\\nrecurringInterval\\neffectiveMonthPrice\\n\\n      }\\n                  \\ntotalDocs\\noffset\\nlimit\\ntotalPages\\ntotalDocs\\npage\\npagingCounter\\nhasPrevPage\\nhasNextPage\\nprevPage\\nnextPage\\n\\n    }\\n  }\\n  \&quot;,\&quot;variables\&quot;:{\&quot;where\&quot;:{\&quot;OR\&quot;:[{\&quot;membershipProduct\&quot;:{\&quot;equals\&quot;:\&quot;${membership_product_id}\&quot;},\&quot;termDate\&quot;:{\&quot;exists\&quot;:false},\&quot;affiliationType\&quot;:{\&quot;equals\&quot;:\&quot;revPlus\&quot;}},{\&quot;membershipProduct\&quot;:{\&quot;equals\&quot;:\&quot;${membership_product_id}\&quot;},\&quot;termDate\&quot;:{\&quot;greater_than\&quot;:\&quot;${current_date_time_ISO}\&quot;},\&quot;affiliationType\&quot;:{\&quot;equals\&quot;:\&quot;revPlus\&quot;}}]}},\&quot;operationName\&quot;:\&quot;getMembershipPrices\&quot;}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>e41a1dc7-1bc1-4221-89af-b1289a88d073</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${GlobalVariable.token}</value>
      <webElementGuid>0e08de02-2432-439b-8576-fcc2f817a628</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.8</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.baseUrl}payload/api/graphql</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
