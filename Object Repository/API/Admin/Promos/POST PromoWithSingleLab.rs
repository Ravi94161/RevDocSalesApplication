<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>POST PromoWithSingleLab</name>
   <tag></tag>
   <elementGuidId>fbd589d4-3b31-44fd-8ac0-449dfbf0384f</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;isRevDoc\&quot;: ${promoData.isRevDoc},\n  \&quot;isInfluencer\&quot;: ${promoData.isInfluencer},\n  \&quot;promoCodeType\&quot;: \&quot;${promoData.promoCodeType}\&quot;,\n  \&quot;revBasic\&quot;: ${promoData.revBasic},\n  \&quot;revPlus\&quot;: ${promoData.revPlus},\n  \&quot;revPrivate\&quot;: ${promoData.revPrivate},\n  \&quot;showTo\&quot;: ${promoData.showTo},\n  \&quot;userType\&quot;: \&quot;${promoData.userType}\&quot;,\n  \&quot;promoCode\&quot;: \&quot;${promoData.promoCode}\&quot;,\n  \&quot;promoTitle\&quot;: \&quot;${promoData.promoTitle}\&quot;,\n  \&quot;description\&quot;: \&quot;${promoData.description}\&quot;,\n  \&quot;promoCodeImage\&quot;: \&quot;${imageId}\&quot;,\n  \&quot;isRegionDependent\&quot;: \&quot;${promoData.isRegionDependent}\&quot;,\n  \&quot;isStackable\&quot;: \&quot;${promoData.isStackable}\&quot;,\n  \&quot;redemptionLimitType\&quot;: \&quot;${promoData.redemptionLimitType}\&quot;,\n  \&quot;durationInHours\&quot;: ${promoData.durationInHours},\n  \&quot;durationDateRange\&quot;: \&quot;${promoData.durationDateRange}\&quot;,\n  \&quot;untilAllRedemptionsFilled\&quot;: \&quot;${promoData.untilAllRedemptionsFilled}\&quot;,\n  \&quot;discountType\&quot;: \&quot;${promoData.discountType}\&quot;,\n  \&quot;amountOffValue\&quot;: \&quot;${promoData.amountOffValue}\&quot;,\n  \&quot;percentageOffValue\&quot;: \&quot;${promoData.percentageOffValue}\&quot;,\n   \&quot;labs\&quot;: [\n    {\n      \&quot;id\&quot;: \&quot;672e66d82314e1fd04bc9999\&quot;,\n      \&quot;labName\&quot;: \&quot;Auto lab for promo dynamic\&quot;,\n      \&quot;labVendorName\&quot;: \&quot;imaware\&quot;,\n      \&quot;vendorLabId\&quot;: \&quot;12345\&quot;,\n      \&quot;typeOfTest\&quot;: \&quot;Self Administered\&quot;,\n      \&quot;description\&quot;: \&quot;TestAutomation\&quot;,\n      \&quot;labBiomarkers\&quot;: [\n        \&quot;65684f3f3da6239cea683ea6\&quot;\n      ],\n      \&quot;labImage\&quot;: \&quot;672e66d79e492e5b69beb219\&quot;,\n      \&quot;effectiveDate\&quot;: \&quot;2024-02-13T06:43:27.197Z\&quot;,\n      \&quot;hsaEligible\&quot;: true,\n      \&quot;labPrice\&quot;: 47,\n      \&quot;basicMembershipAppFee\&quot;: 23,\n      \&quot;plusMembershipAppFee\&quot;: 0,\n      \&quot;deletedInfoField\&quot;: {\n        \&quot;isDeleted\&quot;: false\n      },\n      \&quot;createdAt\&quot;: \&quot;2024-11-08T19:30:32.166Z\&quot;,\n      \&quot;updatedAt\&quot;: \&quot;2024-11-25T12:12:10.562Z\&quot;,\n      \&quot;labPdf\&quot;: null,\n      \&quot;labVideo\&quot;: null,\n      \&quot;totalBasicMembershipPrice\&quot;: 57.81,\n      \&quot;totalPlusMembershipPrice\&quot;: 47,\n      \&quot;totalPrivateMembershipPrice\&quot;: 47,\n      \&quot;finalBasicMembershipPrice\&quot;: 60.7,\n      \&quot;finalPlusMembershipPrice\&quot;: 49.35,\n      \&quot;finalPrivateMembershipPrice\&quot;: 49.35,\n      \&quot;amountEligibleForRevcash\&quot;: 0\n    }\n  ],\n  \&quot;maxRedemptions\&quot;: \&quot;${promoData.maxRedemptions}\&quot;,\n  \&quot;effectiveDate\&quot;: \&quot;${promoData.effectiveDate}\&quot;,\n  \&quot;termDate\&quot;: \&quot;${promoData.termDate}\&quot;,\n  \&quot;discountValue\&quot;: \&quot;${promoData.discountValue}\&quot;,\n  \&quot;durationType\&quot;: \&quot;${promoData.durationType}\&quot;,\n  \&quot;remainingRedemptions\&quot;: \&quot;${promoData.remainingRedemptions}\&quot;,\n  \&quot;_status\&quot;: \&quot;${promoData._status}\&quot;\n}&quot;,
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
      <webElementGuid>6386313f-bd6b-462f-8af0-c379fe281745</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${GlobalVariable.token}</value>
      <webElementGuid>ad5ec23a-502e-4f81-abfa-01962472d2b6</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.9</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.baseUrl}payload/api/promo-codes/</restUrl>
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
