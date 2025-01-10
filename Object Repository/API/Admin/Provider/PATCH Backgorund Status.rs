<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>PATCH Backgorund Status</name>
   <tag></tag>
   <elementGuidId>7f68f8dd-1a62-4d17-b5d1-fd18e2ef2c2f</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;verificationChecklist\&quot;: {\n    \&quot;backgroundCheck\&quot;: {\n      \&quot;verified\&quot;: true,\n      \&quot;verifiedById\&quot;: \&quot;${prmId}\&quot;,\n      \&quot;timestamp\&quot;: \&quot;2024-06-16T09:10:50.692Z\&quot;\n    },\n    \&quot;boardCertification\&quot;: {\n      \&quot;verified\&quot;: true,\n      \&quot;verifiedById\&quot;: \&quot;${prmId}\&quot;,\n      \&quot;timestamp\&quot;: \&quot;2024-06-10T09:11:11.324Z\&quot;\n    },\n    \&quot;supervisorCheck\&quot;: {\n      \&quot;verified\&quot;: true,\n      \&quot;verifiedById\&quot;: \&quot;${prmId}\&quot;,\n      \&quot;timestamp\&quot;: \&quot;2024-06-16T09:11:13.853Z\&quot;\n    },\n    \&quot;availabilityCreated\&quot;: {\n      \&quot;verified\&quot;: true,\n      \&quot;verifiedById\&quot;: \&quot;${prmId}\&quot;,\n      \&quot;timestamp\&quot;: \&quot;2024-06-09T09:11:16.425Z\&quot;\n    },\n    \&quot;meetAndGreet\&quot;: {\n      \&quot;verified\&quot;: true,\n      \&quot;verifiedById\&quot;: \&quot;${prmId}\&quot;,\n      \&quot;timestamp\&quot;: \&quot;2024-06-09T09:11:20.887Z\&quot;\n    }\n  },\n  \&quot;backgroundCheck\&quot;: {\n    \&quot;passedCountyCriminalByPrm\&quot;: true,\n    \&quot;passedCountyCriminalByPrmUpdatedDate\&quot;: \&quot;2024-06-17T09:10:55.820Z\&quot;,\n    \&quot;passedNationalCriminalSexOffenderByPrm\&quot;: true,\n    \&quot;passedNationalCriminalSexOffenderByPrmUpdatedDate\&quot;: \&quot;2024-06-10T09:10:57.772Z\&quot;,\n    \&quot;passedFacisLevelThreeByPrm\&quot;: true,\n    \&quot;passedFacisLevelThreeByPrmUpdatedDate\&quot;: \&quot;2024-06-10T09:10:59.992Z\&quot;,\n    \&quot;medicalLicenses\&quot;: [\n      {\n        \&quot;stateCode\&quot;: \&quot;${providerDetails.backgroundCheck.medicalLicenses[0].stateCode}\&quot;,\n        \&quot;passedMedicalLicense\&quot;: false,\n        \&quot;id\&quot;: \&quot;${providerDetails.backgroundCheck.medicalLicenses[0].id}\&quot;,\n        \&quot;passedMedicalLicenseByPrm\&quot;: true,\n        \&quot;passedMedicalLicenseByPrmUpdatedDate\&quot;: \&quot;2024-06-17T09:11:02.536Z\&quot;\n      }\n    ],\n    \&quot;education\&quot;: [\n      {\n        \&quot;universityName\&quot;: \&quot;${providerDetails.backgroundCheck.education[0].universityName}\&quot;,\n        \&quot;passedEducation\&quot;: false,\n        \&quot;id\&quot;: \&quot;${providerDetails.backgroundCheck.education[0].id}\&quot;,\n        \&quot;passedEducationByPrm\&quot;: true,\n        \&quot;passedEducationByPrmUpdatedDate\&quot;: \&quot;2024-06-23T09:11:04.894Z\&quot;\n      },\n      {\n        \&quot;universityName\&quot;: \&quot;${providerDetails.backgroundCheck.education[1].universityName}\&quot;,\n        \&quot;passedEducation\&quot;: false,\n        \&quot;id\&quot;: \&quot;${providerDetails.backgroundCheck.education[1].id}\&quot;,\n        \&quot;passedEducationByPrm\&quot;: true,\n        \&quot;passedEducationByPrmUpdatedDate\&quot;: \&quot;2024-06-23T09:11:08.992Z\&quot;\n      }\n    ]\n  },\n \&quot;manualVerification\&quot;: true,\n \&quot;providerStatus\&quot;: \&quot;${providerStatus}\&quot;\n}&quot;,
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
      <webElementGuid>b929f38e-15e6-48cb-8145-bef820e72c3b</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${GlobalVariable.token}</value>
      <webElementGuid>e00980d7-1713-4911-830e-d4babbe18749</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.8</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>PATCH</restRequestMethod>
   <restUrl>https://api.stage.us-east-2.api.revdoc.link/v1/payload/api/providers/${ownerId}</restUrl>
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
