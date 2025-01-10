<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>deliveryMethod</name>
   <tag></tag>
   <elementGuidId>c4582fbb-07b0-40a6-bcfd-87c2a31a6cf7</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\t\&quot;defaultDeliveryMethods\&quot;: [\n\t\t{\n\t\t\t\&quot;address\&quot;: \&quot;65abb835d5eb03f4afb19493\&quot;,\n\t\t\t\&quot;radius\&quot;: 54,\n\t\t\t\&quot;rateModifier\&quot;: 20,\n\t\t\t\&quot;deliveryMethod\&quot;: \&quot;64dbc7a37c524ff621491dcd\&quot;\n\t\t},\n\t\t{\n\t\t\t\&quot;address\&quot;: \&quot;65abb835d5eb03f4afb19493\&quot;,\n\t\t\t\&quot;rateModifier\&quot;: 20,\n\t\t\t\&quot;insuranceAccepted\&quot;: ${insurance},\n\t\t\t\&quot;selfPayAccepted\&quot;: ${cash},\n\t\t\t\&quot;deliveryMethod\&quot;: \&quot;64dbc7977c524ff621491dbd\&quot;\n\t\t},\n\t\t{\n\t\t\t\&quot;rateModifier\&quot;: 39,\n\t\t\t\&quot;deliveryMethod\&quot;: \&quot;64dbc7a97c524ff621491dd5\&quot;\n\t\t},\n\t\t{\n\t\t\t\&quot;address\&quot;: \&quot;65abb835d5eb03f4afb19493\&quot;,\n\t\t\t\&quot;radius\&quot;: 10,\n\t\t\t\&quot;rateModifier\&quot;: 20,\n\t\t\t\&quot;deliveryMethod\&quot;: \&quot;64dbc79b7c524ff621491dc5\&quot;\n\t\t}\n\t]}&quot;,
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
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${GlobalVariable.providerToken}</value>
   </httpHeaderProperties>
   <katalonVersion>8.2.5</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>PATCH</restRequestMethod>
   <restUrl>https://api.stage.us-east-2.api.revdoc.link/v1/payload/api/providers/${GlobalVariable.providerId}</restUrl>
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
