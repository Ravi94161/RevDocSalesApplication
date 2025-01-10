<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>POST Member Labs</name>
   <tag></tag>
   <elementGuidId>8a67e098-c772-48d0-8b16-c311d5a64aa5</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\t\&quot;vendorLabId\&quot;: \&quot;12345\&quot;,\n\t\&quot;typeOfTest\&quot;: \&quot;Self Administered\&quot;,\n\t\&quot;labVendorName\&quot;: \&quot;imaware\&quot;,\n\t\&quot;labName\&quot;: \&quot;${labName}\&quot;,\n\t\&quot;description\&quot;: \&quot;TestAutomation\&quot;,\n\t\&quot;effectiveDate\&quot;: \&quot;2024-02-13T06:43:27.197Z\&quot;,\n\t\&quot;labBiomarkers\&quot;: [\n\t\t\&quot;65684f3f3da6239cea683ea6\&quot;\n\t],\n    \&quot;labImage\&quot;: \&quot;${mediaId}\&quot;,\n\t\&quot;hsaEligible\&quot;: true,\n\t\&quot;labPrice\&quot;: \&quot;10\&quot;,\n\t\&quot;plusMembershipAppFee\&quot;: \&quot;10\&quot;,\n\t\&quot;basicMembershipAppFee\&quot;: \&quot;25\&quot;\n}&quot;,
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
      <webElementGuid>ab92c41f-a274-488b-8061-6637fdb73fb4</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${GlobalVariable.token}</value>
      <webElementGuid>3258c9d7-b71a-4653-9006-80196590b503</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.8</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.baseUrl}payload/api/labs</restUrl>
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
