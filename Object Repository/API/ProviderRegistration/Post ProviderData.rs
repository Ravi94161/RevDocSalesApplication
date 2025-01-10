<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Post ProviderData</name>
   <tag></tag>
   <elementGuidId>a3fef4cf-1d17-4258-80de-9ee3f04da151</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\t\&quot;hasGoneLive\&quot;: false,\n\t\&quot;primaryCounty\&quot;: \&quot;6509c006f64a1f58bead5db8\&quot;,\n\t\&quot;firstName\&quot;: \&quot;${firstName}\&quot;,\n\t\&quot;middleName\&quot;: \&quot;G\&quot;,\n\t\&quot;lastName\&quot;: \&quot;${lastName}\&quot;,\n\t\&quot;dateOfBirth\&quot;: \&quot;1994-03-19\&quot;,\n\t\&quot;faxNumber\&quot;: 9876543210,\n\t\&quot;socialSecurityNumber\&quot;: \&quot;998877665\&quot;,\n\t\&quot;patientAgeLow\&quot;: 1,\n\t\&quot;patientAgeHigh\&quot;: 99,\n\t\&quot;governmentIdImage\&quot;: \&quot;${govtImageId}\&quot;,\n\t\&quot;npiNumber\&quot;: \&quot;1003001660\&quot;,\n\t\&quot;providerType\&quot;: \&quot;64dbc5d214d9e622cbc0d9d0\&quot;,\n\t\&quot;country\&quot;: \&quot;65be4d720f902a3722b2a6eb\&quot;,\n\t\&quot;homeAddress\&quot;: {\n\t\t\&quot;addressName\&quot;: \&quot;${data.homeAddress.addressName}\&quot;,\n\t\t\&quot;addressLine1\&quot;: \&quot;${data.homeAddress.addressLine1}\&quot;,\n\t\t\&quot;addressLine2\&quot;: \&quot;${data.homeAddress.addressLine2}\&quot;,\n\t\t\&quot;city\&quot;: \&quot;${data.homeAddress.city}\&quot;,\n\t\t\&quot;location\&quot;: ${data.homeAddress.location},\n\t\t\&quot;stateCode\&quot;: \&quot;${data.homeAddress.stateCode}\&quot;,\n\t\t\&quot;postalCode\&quot;: \&quot;${data.homeAddress.postalCode}\&quot;,\n\t\t\&quot;timezoneId\&quot;: \&quot;\&quot;\n\t},\n\t\&quot;providerSpecialty\&quot;: [\n\t\t\&quot;65cb508dc1a911aa77d1a54e\&quot;\n\t],\n\t\&quot;providerRelationshipManager\&quot;: \&quot;228a7723-85e1-42d9-9e94-ea918211f5e9\&quot;,\n\t\&quot;undergraduateEducation\&quot;: {\n\t\t\&quot;diplomaImage\&quot;: \&quot;${underGraduateImageId}\&quot;,\n\t\t\&quot;universityName\&quot;: \&quot;UG\&quot;,\n\t\t\&quot;stateCode\&quot;: \&quot;MI\&quot;,\n\t\t\&quot;graduationYear\&quot;: 2014,\n\t\t\&quot;degree\&quot;: \&quot;Degree2\&quot;,\n\t\t\&quot;graduationMonth\&quot;: 5\n\t},\n\t\&quot;graduateEducation\&quot;: {\n\t\t\&quot;diplomaImage\&quot;: \&quot;${graduateImageId}\&quot;,\n\t\t\&quot;universityName\&quot;: \&quot;Graduate\&quot;,\n\t\t\&quot;stateCode\&quot;: \&quot;MI\&quot;,\n\t\t\&quot;graduationYear\&quot;: 2014,\n\t\t\&quot;degree\&quot;: \&quot;Degree2\&quot;,\n\t\t\&quot;graduationMonth\&quot;: 5\n\t},\n\t\&quot;fellowship\&quot;: {\n\t\t\&quot;yearOfFellowship\&quot;: 2013,\n\t\t\&quot;fellowshipName\&quot;: \&quot;Fellowshipo\&quot;,\n\t\t\&quot;stateCode\&quot;: \&quot;ME\&quot;\n\t},\n\t\&quot;residency\&quot;: {\n\t\t\&quot;residencyName\&quot;: \&quot;Residensy\&quot;,\n\t\t\&quot;stateCode\&quot;: \&quot;KY\&quot;,\n\t\t\&quot;yearOfResidency\&quot;: 2015\n\t},\n\t\&quot;certifications\&quot;: [],\n\t\&quot;licenses\&quot;: {\n\t\t\&quot;${data.licenseState}\&quot;: {\n\t\t\t\&quot;licenseImage\&quot;: \&quot;${data.licenseImage}\&quot;,\n\t\t\t\&quot;licenseExpirationDate\&quot;: \&quot;${data.licenseExpirationDate}\&quot;,\n\t\t\t\&quot;licenseNumber\&quot;: \&quot;${data.licenseNumber}\&quot;,\n\t\t\t\&quot;licenseType\&quot;: \&quot;${data.licenseType}\&quot;\n\t\t}\n\t},\n   \&quot;deaLicense\&quot;: {\n      \&quot;deaRegistrationNumber\&quot;: \&quot;345365634\&quot;,\n      \&quot;deaExpirationDate\&quot;: \&quot;2028-05-01T00:00:00.000Z\&quot;,\n      \&quot;deaLicenseImageOrPdf\&quot;: \&quot;${deaLicenceImageId}\&quot;\n  \t},\n\t\&quot;workHistories\&quot;: [\n\t\t{\n\t\t\t\&quot;employerAddress\&quot;: {\n\t\t\t\t\&quot;addressName\&quot;: \&quot;${data.employerAddress.addressName}\&quot;,\n\t\t\t\t\&quot;addressLine1\&quot;: \&quot;${data.employerAddress.addressLine1}\&quot;,\n\t\t\t\t\&quot;addressLine2\&quot;: \&quot;${data.employerAddress.addressLine2}\&quot;,\n\t\t\t\t\&quot;city\&quot;: \&quot;${data.employerAddress.city}\&quot;,\n\t\t\t\t\&quot;location\&quot;: ${data.employerAddress.location},\n\t\t\t\t\&quot;stateCode\&quot;: \&quot;${data.employerAddress.stateCode}\&quot;,\n\t\t\t\t\&quot;postalCode\&quot;: \&quot;${data.employerAddress.postalCode}\&quot;,\n\t\t\t\t\&quot;timezoneId\&quot;: \&quot;\&quot;\n\t\t\t},\n\t\t\t\&quot;employerName\&quot;: \&quot;Kishore Tester\&quot;,\n\t\t\t\&quot;startDate\&quot;: \&quot;2024-03-19\&quot;\n\t\t}\n\t],\n\t\&quot;completedHipaaTrainingDates\&quot;: [],\n\t\&quot;signature\&quot;: \&quot;${signatureImageId}\&quot;,\n    \&quot;dateEmpowerConsentFormSigned\&quot;: \&quot;2024-05-01T00:00:00.000+00:00\&quot;\n}&quot;,
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
      <webElementGuid>5222d6c2-650c-4ea1-9df0-987d177ee196</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${GlobalVariable.token}</value>
      <webElementGuid>61ffd0e0-8269-4d95-be73-f758ec209fa9</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.8</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.baseUrl}payload/api/providers?depth=1</restUrl>
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
