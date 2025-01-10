<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>PATCH Demographics</name>
   <tag></tag>
   <elementGuidId>df2d0ab7-1229-42f9-a46e-98be287f2537</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\&quot;demographics\&quot;:{\&quot;dateOfBirth\&quot;:\&quot;2005-05-27T00:00:00.000+00:00\&quot;,\&quot;addresses\&quot;:[{\&quot;addressName\&quot;:\&quot;Home\&quot;,\&quot;addressLine1\&quot;:\&quot;509 River Street\&quot;,\&quot;addressLine2\&quot;:\&quot;\&quot;,\&quot;city\&quot;:\&quot;Owosso\&quot;,\&quot;location\&quot;:[-84.177477,42.999253],\&quot;stateCode\&quot;:\&quot;MI\&quot;,\&quot;postalCode\&quot;:\&quot;48867\&quot;,\&quot;timezoneId\&quot;:\&quot;\&quot;}],\&quot;emergencyContacts\&quot;:[{\&quot;mobilePhoneNumber\&quot;:\&quot;9866037741\&quot;,\&quot;name\&quot;:\&quot;sreeni\&quot;,\&quot;relationship\&quot;:\&quot;Friend\&quot;}],\&quot;firstName\&quot;:\&quot;Kishore\&quot;,\&quot;lastName\&quot;:\&quot;Reddy\&quot;,\&quot;gender\&quot;:\&quot;Male\&quot;,\&quot;identifiesAs\&quot;:\&quot;male\&quot;,\&quot;languagesSpoken\&quot;:[\&quot;6509c006f64a1f58bead5cdf\&quot;],\&quot;maritalStatus\&quot;:\&quot;Married\&quot;,\&quot;middleName\&quot;:\&quot;R\&quot;,\&quot;race\&quot;:\&quot;asian\&quot;,\&quot;country\&quot;:\&quot;65be4d720f902a3722b2a6eb\&quot;}}&quot;,
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
      <webElementGuid>f39f9e47-2f0b-4943-883e-49bf79e7d9de</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${GlobalVariable.token}</value>
      <webElementGuid>87d9a9a3-c74a-428b-9753-9db6fa24e253</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.8</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>PATCH</restRequestMethod>
   <restUrl>${GlobalVariable.baseUrl}payload/api/members/${id}</restUrl>
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
