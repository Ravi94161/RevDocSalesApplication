<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>PATCH Procedure - ID</name>
   <tag></tag>
   <elementGuidId>4b8bc1f4-8278-4663-a6fc-3193b1b3e816</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;aboutText\&quot;:\&quot;${data.aboutText}\&quot;,\n  \&quot;procedureTime\&quot;:\&quot;${data.procedureTime}\&quot;,\n  \&quot;competitivePrice\&quot;:\&quot;${data.competitivePrice}\&quot;,\n  \&quot;materialPrice\&quot;:\&quot;${data.materialPrice}\&quot;, \n  \&quot;materialMarkup\&quot;:\&quot;${data.materialMarkup}\&quot;,\n  \&quot;pharmaceuticalPrice\&quot;:\&quot;${data.pharmaceuticalPrice}\&quot;,\n  \&quot;pharmaceuticalMarkup\&quot;:\&quot;${data.pharmaceuticalMarkup}\&quot;,\n  \&quot;procedurePrice\&quot;:\&quot;${data.procedurePrice}\&quot;,\n  \&quot;memberAppFee\&quot;:\&quot;${data.memberAppFee}\&quot;,\n  \&quot;nonMemberAppFee\&quot;:\&quot;${data.nonMemberAppFee}\&quot;,\n  \&quot;deliveryTime\&quot;:\&quot;${data.deliveryTime}\&quot;,\n  \&quot;procedureStepsText\&quot;:\&quot;${data.procedureStepsText}\&quot;,\n  \&quot;postCareInstructionsText\&quot;:\&quot;${data.postCareInstructionsText}\&quot;\n}&quot;,
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
      <webElementGuid>d0962488-b14a-427a-8bd2-07c29151e5a4</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${GlobalVariable.token}</value>
      <webElementGuid>3d98082b-694b-40e2-87bd-75ca85bb4ff3</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.8</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>PATCH</restRequestMethod>
   <restUrl>${GlobalVariable.baseUrl}payload/api/procedures/${id}</restUrl>
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
