<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>PATCH DeliveryMethods</name>
   <tag></tag>
   <elementGuidId>5422c51c-81d8-45bf-a46b-375be36fb530</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\t\&quot;defaultDeliveryMethods\&quot;: [\n\t\t{\n\t\t\t\&quot;address\&quot;: \&quot;${addressId}\&quot;,\n\t\t\t\&quot;radius\&quot;: 10,\n\t\t\t\&quot;rateModifier\&quot;: 20,\n\t\t\t\&quot;deliveryMethod\&quot;: \&quot;${houseCallId}\&quot;\n\t\t},\n\t\t{\n\t\t\t\&quot;address\&quot;: \&quot;${addressId}\&quot;,\n\t\t\t\&quot;rateModifier\&quot;: 20,\n\t\t\t\&quot;insuranceAccepted\&quot;: true,\n\t\t\t\&quot;selfPayAccepted\&quot;: true,\n\t\t\t\&quot;deliveryMethod\&quot;: \&quot;${facilityId}\&quot;\n\t\t},\n\t\t{\n\t\t\t\&quot;address\&quot;: \&quot;${addressId}\&quot;,\n\t\t\t\&quot;rateModifier\&quot;: 39,\n\t\t\t\&quot;deliveryMethod\&quot;: \&quot;${telemedicineId}\&quot;\n\t\t},\n\t\t{\n\t\t\t\&quot;address\&quot;: \&quot;${addressId}\&quot;,\n\t\t\t\&quot;radius\&quot;: 10,\n\t\t\t\&quot;rateModifier\&quot;: 20,\n\t\t\t\&quot;deliveryMethod\&quot;: \&quot;${vanId}\&quot;\n\t\t}\n\t]\n}\n&quot;,
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
      <webElementGuid>f407301b-8547-4dc8-beb8-db020b0dcba7</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${GlobalVariable.token}</value>
      <webElementGuid>57a3b882-98a8-4c35-996c-c035830cb226</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.8</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>PATCH</restRequestMethod>
   <restUrl>${GlobalVariable.baseUrl}payload/api/providers/${ownerId}?depth=1</restUrl>
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
