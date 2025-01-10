<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>PATCH Go Live</name>
   <tag></tag>
   <elementGuidId>dbff919a-ac61-4d1a-96ec-720d755fc33c</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;contentType&quot;: &quot;multipart/form-data&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;,
  &quot;parameters&quot;: [
    {
      &quot;name&quot;: &quot;_payload&quot;,
      &quot;value&quot;: &quot;{\&quot;providerStatus\&quot;:\&quot;active\&quot;,\&quot;backgroundCheck\&quot;:{\&quot;status\&quot;:\&quot;passed\&quot;,\&quot;passedCountyCriminal\&quot;:true,\&quot;passedFacisLevelThree\&quot;:true,\&quot;passedCountyCriminalByPrm\&quot;:true,\&quot;passedFacisLevelThreeByPrm\&quot;:true,\&quot;passedNationalCriminalSexOffenderByPrm\&quot;:true},\&quot;verificationChecklist\&quot;:{\&quot;meetAndGreet\&quot;:{\&quot;verified\&quot;:true},\&quot;hipaaTraining\&quot;:{\&quot;verified\&quot;:true},\&quot;backgroundCheck\&quot;:{\&quot;verified\&quot;:true},\&quot;supervisorCheck\&quot;:{\&quot;verified\&quot;:true},\&quot;profileComplete\&quot;:{\&quot;verified\&quot;:true},\&quot;boardCertification\&quot;:{\&quot;verified\&quot;:true},\&quot;availabilityCreated\&quot;:{\&quot;verified\&quot;:true},\&quot;henryScheinOrderSetup\&quot;:{\&quot;verified\&quot;:true}}}&quot;,
      &quot;type&quot;: &quot;Text&quot;,
      &quot;contentType&quot;: &quot;&quot;
    }
  ]
}</httpBodyContent>
   <httpBodyType>form-data</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>multipart/form-data</value>
      <webElementGuid>94b98d51-d9f3-4e7a-aece-61814a8bd697</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Cookie</name>
      <type>Main</type>
      <value>payload-token=${GlobalVariable.token}</value>
      <webElementGuid>8d53d0a9-638c-419e-8e0e-a54ce69e9651</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.2.5</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>PATCH</restRequestMethod>
   <restUrl>https://api.stage.us-east-2.api.revdoc.link//v1/payload/api/providers/${providerID}?locale=en</restUrl>
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
