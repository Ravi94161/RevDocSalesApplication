<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>POST PromoWithMultipleLabs</name>
   <tag></tag>
   <elementGuidId>bd66c3fc-f0db-42bb-9b10-0396f5c33661</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;isRevDoc\&quot;: ${promoData.isRevDoc},\n  \&quot;isInfluencer\&quot;: ${promoData.isInfluencer},\n  \&quot;promoCodeType\&quot;: \&quot;${promoData.promoCodeType}\&quot;,\n  \&quot;revBasic\&quot;: ${promoData.revBasic},\n  \&quot;revPlus\&quot;: ${promoData.revPlus},\n  \&quot;revPrivate\&quot;: ${promoData.revPrivate},\n  \&quot;showTo\&quot;: ${promoData.showTo},\n  \&quot;userType\&quot;: \&quot;${promoData.userType}\&quot;,\n  \&quot;promoCode\&quot;: \&quot;${promoData.promoCode}\&quot;,\n  \&quot;promoTitle\&quot;: \&quot;${promoData.promoTitle}\&quot;,\n  \&quot;description\&quot;: \&quot;${promoData.description}\&quot;,\n  \&quot;promoCodeImage\&quot;: \&quot;${imageId}\&quot;,\n  \&quot;isRegionDependent\&quot;: \&quot;${promoData.isRegionDependent}\&quot;,\n  \&quot;deliveryMethods\&quot;: [\n    \&quot;64dbc7977c524ff621491dbd\&quot;,\n    \&quot;64dbc79b7c524ff621491dc5\&quot;,\n    \&quot;64dbc7a37c524ff621491dcd\&quot;,\n    \&quot;64dbc7a97c524ff621491dd5\&quot;\n  ],\n  \&quot;isStackable\&quot;: \&quot;${promoData.isStackable}\&quot;,\n  \&quot;redemptionLimitType\&quot;: \&quot;${promoData.redemptionLimitType}\&quot;,\n  \&quot;durationInHours\&quot;: ${promoData.durationInHours},\n  \&quot;durationDateRange\&quot;: \&quot;${promoData.durationDateRange}\&quot;,\n  \&quot;untilAllRedemptionsFilled\&quot;: \&quot;${promoData.untilAllRedemptionsFilled}\&quot;,\n  \&quot;discountType\&quot;: \&quot;${promoData.discountType}\&quot;,\n  \&quot;amountOffValue\&quot;: \&quot;${promoData.amountOffValue}\&quot;,\n  \&quot;percentageOffValue\&quot;: \&quot;${promoData.percentageOffValue}\&quot;,\n  \&quot;labs\&quot;: [\n    {\n      \&quot;id\&quot;: \&quot;66a76466454b4707d71b3dce\&quot;,\n      \&quot;labName\&quot;: \&quot;Auto Promo Multiple Lab - 1\&quot;,\n      \&quot;labVendorName\&quot;: \&quot;imaware\&quot;,\n      \&quot;vendorLabId\&quot;: \&quot;Auto-c828-48c3-86fb-8463d263631z\&quot;,\n      \&quot;typeOfTest\&quot;: \&quot;Self Administered\&quot;,\n      \&quot;description\&quot;: \&quot;This lab is created for multiple labs Promo TC-1883\&quot;,\n      \&quot;labBiomarkers\&quot;: [\n        \&quot;65684f3f3da6239cea683ea6\&quot;,\n        \&quot;6560ae363387d4dde2c3bbed\&quot;,\n        \&quot;656e486cf5695ddd7dcb6426\&quot;\n      ],\n      \&quot;labImage\&quot;: \&quot;66a7646568235f427f9d38af\&quot;,\n      \&quot;effectiveDate\&quot;: \&quot;2024-07-28T09:41:25.437Z\&quot;,\n      \&quot;termDate\&quot;: \&quot;2027-07-31T09:41:28.841Z\&quot;,\n      \&quot;hsaEligible\&quot;: true,\n      \&quot;labPrice\&quot;: 80,\n      \&quot;basicMembershipAppFee\&quot;: 13,\n      \&quot;plusMembershipAppFee\&quot;: 10,\n      \&quot;deletedInfoField\&quot;: {\n        \&quot;isDeleted\&quot;: false\n      },\n      \&quot;createdAt\&quot;: \&quot;2024-07-29T09:44:06.192Z\&quot;,\n      \&quot;updatedAt\&quot;: \&quot;2024-07-29T09:44:06.192Z\&quot;,\n      \&quot;totalBasicMembershipPrice\&quot;: 90.4,\n      \&quot;totalPlusMembershipPrice\&quot;: 88,\n      \&quot;totalPrivateMembershipPrice\&quot;: 80,\n      \&quot;finalBasicMembershipPrice\&quot;: 94.92,\n      \&quot;finalPlusMembershipPrice\&quot;: 92.4,\n      \&quot;finalPrivateMembershipPrice\&quot;: 84,\n      \&quot;amountEligibleForRevcash\&quot;: 0\n    },\n    {\n      \&quot;id\&quot;: \&quot;66a764da50d5980596c6289b\&quot;,\n      \&quot;labName\&quot;: \&quot;Auto Promo Multiple Lab - 2\&quot;,\n      \&quot;labVendorName\&quot;: \&quot;imaware\&quot;,\n      \&quot;vendorLabId\&quot;: \&quot;Auto-c828-48c3-86fb-8463d263631x\&quot;,\n      \&quot;typeOfTest\&quot;: \&quot;Self Administered\&quot;,\n      \&quot;description\&quot;: \&quot;THis lab is created for multiple lab promo TC-1883\&quot;,\n      \&quot;labBiomarkers\&quot;: [\n        \&quot;65684f3f3da6239cea683ea6\&quot;,\n        \&quot;6560ae363387d4dde2c3bbed\&quot;,\n        \&quot;656e486cf5695ddd7dcb6426\&quot;\n      ],\n      \&quot;labImage\&quot;: \&quot;66a764d9afad93558e04fe3d\&quot;,\n      \&quot;effectiveDate\&quot;: \&quot;2024-07-28T09:44:30.742Z\&quot;,\n      \&quot;termDate\&quot;: \&quot;2027-10-29T09:44:31.791Z\&quot;,\n      \&quot;hsaEligible\&quot;: true,\n      \&quot;labPrice\&quot;: 100,\n      \&quot;basicMembershipAppFee\&quot;: 20,\n      \&quot;plusMembershipAppFee\&quot;: 12,\n      \&quot;deletedInfoField\&quot;: {\n        \&quot;isDeleted\&quot;: false\n      },\n      \&quot;createdAt\&quot;: \&quot;2024-07-29T09:46:02.303Z\&quot;,\n      \&quot;updatedAt\&quot;: \&quot;2024-07-29T09:46:02.303Z\&quot;,\n      \&quot;totalBasicMembershipPrice\&quot;: 120,\n      \&quot;totalPlusMembershipPrice\&quot;: 112,\n      \&quot;totalPrivateMembershipPrice\&quot;: 100,\n      \&quot;finalBasicMembershipPrice\&quot;: 126,\n      \&quot;finalPlusMembershipPrice\&quot;: 117.6,\n      \&quot;finalPrivateMembershipPrice\&quot;: 105,\n      \&quot;amountEligibleForRevcash\&quot;: 0\n    }\n  ],\n  \&quot;maxRedemptions\&quot;: \&quot;${promoData.maxRedemptions}\&quot;,\n  \&quot;effectiveDate\&quot;: \&quot;${promoData.effectiveDate}\&quot;,\n  \&quot;termDate\&quot;: \&quot;${promoData.termDate}\&quot;,\n  \&quot;discountValue\&quot;: \&quot;${promoData.discountValue}\&quot;,\n  \&quot;durationType\&quot;: \&quot;${promoData.durationType}\&quot;,\n  \&quot;remainingRedemptions\&quot;: \&quot;${promoData.remainingRedemptions}\&quot;,\n  \&quot;_status\&quot;: \&quot;${promoData._status}\&quot;\n}&quot;,
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
