<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Get Provider Details - Admin</name>
   <tag></tag>
   <elementGuidId>1ad2a324-6eae-4c69-be76-9112bfeef8c8</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;operationName\&quot;: \&quot;getProviderById\&quot;,\n  \&quot;variables\&quot;: {\n    \&quot;id\&quot;: \&quot;${providerId}\&quot;\n  },\n  \&quot;query\&quot;: \&quot;query getProviderById($id: String!) { Provider(id: $id) { backgroundCheck{backgroundCheckOrder{iProspectReportId id consentDocument{filename} webhookRequests{requestBody}} passedCountyCriminal passedNationalCriminalSexOffender passedFacisLevelThree passedNationalCriminalSexOffenderByPrm passedNationalCriminalSexOffenderByPrmUpdatedDate passedCountyCriminalByPrm passedCountyCriminalByPrmUpdatedDate passedFacisLevelThreeByPrm passedFacisLevelThreeByPrmUpdatedDate medicalLicenses{ id passedMedicalLicense passedMedicalLicenseByPrm passedMedicalLicenseByPrmUpdatedDate stateCode }} biography{ gender selfDescription languagesSpoken{ name deletedInfoField{ isDeleted } updatedAt createdAt } providerPhoto{ url deletedInfoField{ isDeleted } updatedAt createdAt } providerVideo{ url deletedInfoField{ isDeleted } updatedAt createdAt }} certifications{ certificationName certificationImage{ url }} completedHipaaTrainingDates{ date } conciergePractice{ maxMembers id approvedForPrivatePractices approvedForPrivatePracticesDate } defaultDeliveryMethods{ active deliveryMethod{internalIdentifier}address{id addressName addressLine1 city stateCode postalCode location}} deliveryAddresses{ hsAccountNumber updatedAt createdAt } fellowship{ fellowshipName stateCode } firstName fullName graduateEducation{ degree universityName graduationYear stateCode diplomaImage{ url }} homeAddress{ addressLine1 addressName postalCode location city stateCode } insurancePlan{ planName id } id internship{ internshipName stateCode } lastName licensedStateCodes licenses{ MI{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} TX{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} DE{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} ME{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} MS{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} AL{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} HI{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} AZ{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} PA{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} OK{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} VT{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} ND{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} TN{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} ID{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} OH{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} CT{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} RI{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} IA{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} IL{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} MD{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} WA{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} SD{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} NY{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} NC{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} FL{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} OR{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} CO{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} NE{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} NH{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} NJ{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} IN{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} MN{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} KS{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} AK{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} WV{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} AR{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} NM{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} DC{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} WY{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} MA{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} CA{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} GA{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} VA{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} MT{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} UT{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} KY{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} WI{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} LA{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} NV{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} MO{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}} SC{ requireSupervision licenseExpirationDate licenseType{licenseTypeName} licenseNumber licenseImage{url}}} manualVerification middleName patientAgeHigh patientAgeLow primaryCounty{ countyName stateName } providerRelationshipManager{ profilePhoto{url} firstName lastName middleName counties{ countyName stateCode } startDate} providerStatus providerStartDate providerType{ canCreatePrivatePractice canSupervise providerTypeName} rating ratingCount residency{ residencyName stateCode} undergraduateEducation{ degree universityName universityName graduationYear stateCode diplomaImage{url}} verificationChecklist{ backgroundCheck{ verified verifiedById{ id } timestamp } boardCertification{ verified verifiedById{ id } timestamp } supervisorCheck{ verified verifiedById{ id } timestamp } profileComplete{ verified verifiedById{ id } timestamp  } availabilityCreated{ verified verifiedById{ id } timestamp  } hipaaTraining{ verified verifiedById{ id } timestamp  } henryScheinOrderSetup{ verified verifiedById{ id } timestamp  } meetAndGreet{ verified verifiedById{ id } timestamp  }} workHistories{ startDate employerName endDate employerAddress{ addressLine1 addressLine2 city stateCode postalCode }}}}\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;text/plain&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>d03980aa-a39c-4ddd-8f32-83adca45f3b7</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${GlobalVariable.token}</value>
      <webElementGuid>f9bf33f1-3fdb-43d3-affd-e4b34e320c61</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.9</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://api.stage.us-east-2.api.revdoc.link/v1/payload/api/graphql</restUrl>
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
