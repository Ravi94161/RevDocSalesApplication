<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>PATCH Backgorund Status - RevPrivate</name>
   <tag></tag>
   <elementGuidId>bf88b24e-c697-45f5-9d22-6a73a23a1624</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;verificationChecklist\&quot;: {\n    \&quot;backgroundCheck\&quot;: {\n      \&quot;verified\&quot;: true,\n      \&quot;timestamp\&quot;: \&quot;2024-06-01T08:21:33.254Z\&quot;\n    },\n    \&quot;boardCertification\&quot;: {\n      \&quot;verified\&quot;: true,\n      \&quot;timestamp\&quot;: \&quot;2024-06-01T08:21:51.989Z\&quot;\n    },\n    \&quot;supervisorCheck\&quot;: {\n      \&quot;verified\&quot;: true,\n      \&quot;timestamp\&quot;: \&quot;2024-06-01T08:21:53.609Z\&quot;\n    },\n    \&quot;availabilityCreated\&quot;: {\n      \&quot;verified\&quot;: true,\n      \&quot;timestamp\&quot;: \&quot;2024-06-01T08:21:56.883Z\&quot;\n    },\n    \&quot;meetAndGreet\&quot;: {\n      \&quot;verified\&quot;: true,\n      \&quot;timestamp\&quot;: \&quot;2024-06-01T08:22:01.023Z\&quot;\n    }\n  },\n  \&quot;backgroundCheck\&quot;: {\n    \&quot;passedCountyCriminalByPrm\&quot;: true,\n    \&quot;passedCountyCriminalByPrmUpdatedDate\&quot;: \&quot;2024-06-01T08:21:35.450Z\&quot;,\n    \&quot;passedNationalCriminalSexOffenderByPrm\&quot;: true,\n    \&quot;passedNationalCriminalSexOffenderByPrmUpdatedDate\&quot;: \&quot;2024-06-01T08:21:37.667Z\&quot;,\n    \&quot;passedFacisLevelThreeByPrm\&quot;: true,\n    \&quot;passedFacisLevelThreeByPrmUpdatedDate\&quot;: \&quot;2024-06-01T08:21:39.555Z\&quot;,\n    \&quot;medicalLicenses\&quot;: [\n      {\n        \&quot;stateCode\&quot;: \&quot;MI\&quot;,\n        \&quot;passedMedicalLicense\&quot;: true,\n        \&quot;id\&quot;: \&quot;667e13fcd9fc8600018568c3\&quot;,\n        \&quot;passedMedicalLicenseByPrmUpdatedDate\&quot;: \&quot;2024-06-01T08:21:42.344Z\&quot;,\n        \&quot;passedMedicalLicenseByPrm\&quot;: true\n      }\n    ],\n    \&quot;education\&quot;: [\n      {\n        \&quot;universityName\&quot;: \&quot;UG\&quot;,\n        \&quot;passedEducation\&quot;: false,\n        \&quot;id\&quot;: \&quot;667e13fcd9fc8600018568c4\&quot;,\n        \&quot;passedEducationByPrmUpdatedDate\&quot;: \&quot;2024-06-01T08:21:44.340Z\&quot;,\n        \&quot;passedEducationByPrm\&quot;: true\n      },\n      {\n        \&quot;universityName\&quot;: \&quot;Graduate\&quot;,\n        \&quot;passedEducation\&quot;: false,\n        \&quot;id\&quot;: \&quot;667e13fcd9fc8600018568c5\&quot;,\n        \&quot;passedEducationByPrm\&quot;: true,\n        \&quot;passedEducationByPrmUpdatedDate\&quot;: \&quot;2024-06-01T08:21:49.620Z\&quot;\n      }\n    ]\n  },\n  \&quot;conciergePractice\&quot;: {\n    \&quot;approvedForPrivatePractices\&quot;: true,\n    \&quot;approvedForPrivatePracticesDate\&quot;: \&quot;2024-06-01T08:21:19.881Z\&quot;\n  },\n  \&quot;providerStatus\&quot;: \&quot;active\&quot;\n}&quot;,
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
