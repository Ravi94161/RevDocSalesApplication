<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>POST Procedure</name>
   <tag></tag>
   <elementGuidId>39c91d45-9e0f-4329-ab01-196eae8a9443</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;procedureName\&quot;: \&quot;${procedureName}\&quot;,\n  \&quot;procedureCategory\&quot;: [\n    \&quot;658024c08d62184b7bc90735\&quot;,\n    \&quot;6602e8a689cc3ee40952891a\&quot;\n  ],\n  \&quot;cptCode\&quot;: \&quot;23422333\&quot;,\n  \&quot;procedureImage\&quot;: \&quot;${mediaId}\&quot;,\n  \&quot;aboutText\&quot;: \&quot;Automation procedure - do not delete\&quot;,\n  \&quot;procedureStepsText\&quot;: \&quot;Automation procedure - do not delete\&quot;,\n  \&quot;procedureSymptoms\&quot;: [\n    \&quot;6529826b797139895939316e\&quot;,\n    \&quot;65298a3765c74335f0e6023b\&quot;\n  ],\n  \&quot;procedureTime\&quot;: \&quot;15\&quot;,\n  \&quot;groupProcedure\&quot;: false,\n  \&quot;postCareInstructionsText\&quot;: \&quot;Automation procedure - do not delete\&quot;,\n  \&quot;orderingDependent\&quot;: false,\n  \&quot;deliveryTime\&quot;: \&quot;30\&quot;,\n  \&quot;procedureEffectiveDate\&quot;: \&quot;2024-05-21T07:42:24.428Z\&quot;,\n  \&quot;providerTypes\&quot;: [\n    \&quot;655e2fabc4476b513f8d4bfc\&quot;,\n    \&quot;64dbc5d214d9e622cbc0d9d0\&quot;,\n    \&quot;655e2f5cc4476b513f8d4bfa\&quot;,\n    \&quot;64dbc5e014d9e622cbc0d9d8\&quot;,\n    \&quot;64dbc5f014d9e622cbc0d9e0\&quot;,\n    \&quot;64dbc5f914d9e622cbc0d9e8\&quot;,\n    \&quot;64dbc60114d9e622cbc0d9f0\&quot;,\n    \&quot;65022a52462b67ed989dc046\&quot;,\n    \&quot;650de7739c7984604397496f\&quot;,\n    \&quot;651312c6c5977ccf874eecf5\&quot;,\n    \&quot;652d3b2d50161ec366ec3b31\&quot;,\n    \&quot;655ba98bf19122b5b4c588c5\&quot;,\n    \&quot;655ba9abf19122b5b4c588ca\&quot;,\n    \&quot;655e2f5cc4476b513f8d4bf9\&quot;\n  ],\n  \&quot;deliveryMethods\&quot;: [\n    \&quot;64dbc7977c524ff621491dbd\&quot;,\n    \&quot;64dbc79b7c524ff621491dc5\&quot;,\n    \&quot;64dbc7a37c524ff621491dcd\&quot;,\n    \&quot;64dbc7a97c524ff621491dd5\&quot;\n  ],\n  \&quot;hsaEligible\&quot;: true,\n  \&quot;competitivePrice\&quot;: 43,\n  \&quot;materialPrice\&quot;: 34,\n  \&quot;materialMarkup\&quot;: 24,\n  \&quot;pharmaceuticalPrice\&quot;: 50,\n  \&quot;pharmaceuticalMarkup\&quot;: 20,\n  \&quot;procedurePrice\&quot;: 130,\n  \&quot;memberAppFee\&quot;: 0,\n  \&quot;nonMemberAppFee\&quot;: 0,\n  \&quot;isRevPrivate\&quot;: true,\n  \&quot;addOnProcedures\&quot;: []\n}&quot;,
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
      <webElementGuid>f6e9d413-fe67-4445-85c8-95a514b3aae9</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${GlobalVariable.token}</value>
      <webElementGuid>e091861a-35e6-44b2-9e74-62ddbc3afb44</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.9</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.baseUrl}payload/api/procedures/</restUrl>
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
