<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>GET Provider ID</name>
   <tag></tag>
   <elementGuidId>aa75ad75-1440-4a45-99dc-e245f1dbd868</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>true</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\t\&quot;providerStatus\&quot;: \&quot;active\&quot;,\n\t\n\t\t\n\t\&quot;backgroundCheck\&quot;: {\n\t\t\&quot;status\&quot;: \&quot;passed\&quot;,\n\t\t\&quot;medicalLicenses\&quot;: 0,\n\t\t\&quot;passedCountyCriminal\&quot;: true,\n\t\t\&quot;passedFacisLevelThree\&quot;: true,\n\t\t\&quot;passedNationalCriminalSexOffender\&quot;: true\n\t},\n\t\n\t\&quot;verificationChecklist\&quot;: {\n\t\t\&quot;meetAndGreet\&quot;: {\n\t\t\t\&quot;verified\&quot;: true\n\t\t},\n\t\t\&quot;stateLicenses\&quot;: {\n\t\t\t\&quot;verified\&quot;: true\n\t\t},\n\t\t\&quot;hipaaTraining\&quot;: {\n\t\t\t\&quot;verified\&quot;: true\n\t\t},\n\t\t\&quot;backgroundCheck\&quot;: {\n\t\t\t\&quot;verified\&quot;: true\n\t\t},\n\t\t\&quot;supervisorCheck\&quot;: {\n\t\t\t\&quot;verified\&quot;: true\n\t\t},\n\t\t\&quot;profileComplete\&quot;: {\n\t\t\t\&quot;verified\&quot;: true\n\t\t},\n\t\t\&quot;boardCertification\&quot;: {\n\t\t\t\&quot;verified\&quot;: true\n\t\t},\n\t\t\&quot;availabilityCreated\&quot;: {\n\t\t\t\&quot;verified\&quot;: true\n\t\t}\n\t}\n}&quot;,
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
      <webElementGuid>c54505d4-415d-4434-b528-f43553680f74</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Cookie</name>
      <type>Main</type>
      <value>payload-token=${GlobalVariable.token}</value>
      <webElementGuid>f1c652ac-fa6a-497d-a726-72e50bad66f7</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.2.5</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://api.stage.us-east-2.api.revdoc.link/v1/payload/api/providers?locale=en&amp;depth=0&amp;draft=true&amp;page=1&amp;where[or][0][and][0][email][equals]=${email}&amp;limit=10&amp;invoke=4dbc1785-f329-4ce7-b123-68f4c687c375</restUrl>
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
