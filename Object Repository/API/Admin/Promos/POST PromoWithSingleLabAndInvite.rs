<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>POST PromoWithSingleLabAndInvite</name>
   <tag></tag>
   <elementGuidId>c547df63-4166-470d-83c2-021a89924e94</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;isRevDoc\&quot;: ${promoData.isRevDoc},\n  \&quot;isInfluencer\&quot;: ${promoData.isInfluencer},\n  \&quot;promoCodeType\&quot;: \&quot;${promoData.promoCodeType}\&quot;,\n  \&quot;revBasic\&quot;: ${promoData.revBasic},\n  \&quot;revPlus\&quot;: ${promoData.revPlus},\n  \&quot;revPrivate\&quot;: ${promoData.revPrivate},\n  \&quot;showTo\&quot;: ${promoData.showTo},\n  \&quot;userType\&quot;: \&quot;${promoData.userType}\&quot;,\n  \&quot;promoCode\&quot;: \&quot;${promoData.promoCode}\&quot;,\n  \&quot;promoTitle\&quot;: \&quot;${promoData.promoTitle}\&quot;,\n  \&quot;description\&quot;: \&quot;${promoData.description}\&quot;,\n  \&quot;promoCodeImage\&quot;: \&quot;${imageId}\&quot;,\n  \&quot;isRegionDependent\&quot;: \&quot;${promoData.isRegionDependent}\&quot;,\n  \&quot;isStackable\&quot;: \&quot;${promoData.isStackable}\&quot;,\n  \&quot;redemptionLimitType\&quot;: \&quot;${promoData.redemptionLimitType}\&quot;,\n  \&quot;durationInHours\&quot;: ${promoData.durationInHours},\n  \&quot;durationDateRange\&quot;: \&quot;${promoData.durationDateRange}\&quot;,\n  \&quot;untilAllRedemptionsFilled\&quot;: \&quot;${promoData.untilAllRedemptionsFilled}\&quot;,\n  \&quot;influencerMemberIds\&quot;: [\n    {\n      \&quot;influencerMemberId\&quot;: \&quot;${promoData.influencerMemberIds.influencerMemberId}\&quot;,\n      \&quot;demographics.firstName\&quot;: \&quot;${promoData.influencerMemberIds.firstName}\&quot;,\n      \&quot;demographics.lastName\&quot;: \&quot;${promoData.influencerMemberIds.lastName}\&quot;,\n      \&quot;mobilePhoneNumber\&quot;: \&quot;${promoData.influencerMemberIds.mobilePhoneNumber}\&quot;\n    }\n  ],\n  \&quot;discountType\&quot;: \&quot;${promoData.discountType}\&quot;,\n  \&quot;amountOffValue\&quot;: \&quot;${promoData.amountOffValue}\&quot;,\n  \&quot;percentageOffValue\&quot;: \&quot;${promoData.percentageOffValue}\&quot;,\n  \&quot;labs\&quot;: [\n    {\n      \&quot;id\&quot;: \&quot;65d51368c051dcbe96c02dee\&quot;,\n      \&quot;labName\&quot;: \&quot;SingleLab Limited Promo - Rev1\&quot;,\n      \&quot;labVendorName\&quot;: \&quot;imaware\&quot;,\n      \&quot;vendorLabId\&quot;: \&quot;ef8442ce-c828-48c3-86fb-8463d263631b\&quot;,\n      \&quot;typeOfTest\&quot;: \&quot;Self Administered\&quot;,\n      \&quot;description\&quot;: \&quot;TestAutomation\&quot;,\n      \&quot;labBiomarkers\&quot;: [\n        {\n          \&quot;id\&quot;: \&quot;65684f3f3da6239cea683ea6\&quot;,\n          \&quot;labBiomarkerName\&quot;: \&quot;Cholesterol\&quot;,\n          \&quot;vendorLabBiomarkerId\&quot;: \&quot;123\&quot;,\n          \&quot;description\&quot;: \&quot;Cholesterol testing\&quot;,\n          \&quot;typeOfTest\&quot;: \&quot;range\&quot;,\n          \&quot;unit\&quot;: \&quot;nmol/L\&quot;,\n          \&quot;dependsOnGender\&quot;: true,\n          \&quot;dependsOnRace\&quot;: false,\n          \&quot;referenceRanges\&quot;: [\n            {\n              \&quot;gender\&quot;: \&quot;Female\&quot;,\n              \&quot;low\&quot;: 1,\n              \&quot;high\&quot;: 100,\n              \&quot;id\&quot;: \&quot;65684f3fad03bb00017b6be2\&quot;\n            },\n            {\n              \&quot;gender\&quot;: \&quot;Male\&quot;,\n              \&quot;low\&quot;: 1,\n              \&quot;high\&quot;: 100,\n              \&quot;id\&quot;: \&quot;65684f3fad03bb00017b6be3\&quot;\n            }\n          ],\n          \&quot;reportableLowRange\&quot;: 1,\n          \&quot;reportableHighRange\&quot;: 100,\n          \&quot;deletedInfoField\&quot;: {\n            \&quot;isDeleted\&quot;: false\n          },\n          \&quot;createdAt\&quot;: \&quot;2023-11-30T09:00:47.928Z\&quot;,\n          \&quot;updatedAt\&quot;: \&quot;2024-06-20T14:27:39.176Z\&quot;,\n          \&quot;effectiveDate\&quot;: \&quot;2023-11-29T17:38:48.966Z\&quot;\n        }\n      ],\n      \&quot;effectiveDate\&quot;: \&quot;2024-02-13T06:43:27.197Z\&quot;,\n      \&quot;hsaEligible\&quot;: true,\n      \&quot;labPrice\&quot;: 10,\n      \&quot;basicMembershipAppFee\&quot;: 25,\n      \&quot;plusMembershipAppFee\&quot;: 10,\n      \&quot;deletedInfoField\&quot;: {\n        \&quot;isDeleted\&quot;: false\n      },\n      \&quot;createdAt\&quot;: \&quot;2024-02-20T21:02:32.802Z\&quot;,\n      \&quot;updatedAt\&quot;: \&quot;2024-07-18T10:44:39.209Z\&quot;,\n      \&quot;labImage\&quot;: {\n        \&quot;id\&quot;: \&quot;6698c507dee3b370108146f9\&quot;,\n        \&quot;mediaType\&quot;: \&quot;At-Home Lab Image\&quot;,\n        \&quot;deletedInfoField\&quot;: {\n          \&quot;isDeleted\&quot;: false\n        },\n        \&quot;ownerId\&quot;: \&quot;d60897b2-c527-4ec3-b686-f29d9df50970\&quot;,\n        \&quot;filename\&quot;: \&quot;labImage-220.png\&quot;,\n        \&quot;mimeType\&quot;: \&quot;image/png\&quot;,\n        \&quot;filesize\&quot;: 40798,\n        \&quot;width\&quot;: 167,\n        \&quot;height\&quot;: 148,\n        \&quot;createdAt\&quot;: \&quot;2024-07-18T07:32:23.758Z\&quot;,\n        \&quot;updatedAt\&quot;: \&quot;2024-07-18T07:32:23.758Z\&quot;,\n        \&quot;url\&quot;: \&quot;https://d2hq8lgymb4gmu.cloudfront.net/labImage-220.png\&quot;\n      },\n      \&quot;termDate\&quot;: null,\n      \&quot;labPdf\&quot;: null,\n      \&quot;labVideo\&quot;: null,\n      \&quot;totalBasicMembershipPrice\&quot;: 12.5,\n      \&quot;totalPlusMembershipPrice\&quot;: 11,\n      \&quot;totalPrivateMembershipPrice\&quot;: 10,\n      \&quot;finalBasicMembershipPrice\&quot;: 13.13,\n      \&quot;finalPlusMembershipPrice\&quot;: 11.55,\n      \&quot;finalPrivateMembershipPrice\&quot;: 10.5,\n      \&quot;amountEligibleForRevcash\&quot;: 0\n    }\n  ],\n  \&quot;maxRedemptions\&quot;: \&quot;${promoData.maxRedemptions}\&quot;,\n  \&quot;effectiveDate\&quot;: \&quot;${promoData.effectiveDate}\&quot;,\n  \&quot;termDate\&quot;: \&quot;${promoData.termDate}\&quot;,\n  \&quot;discountValue\&quot;: \&quot;${promoData.discountValue}\&quot;,\n  \&quot;durationType\&quot;: \&quot;${promoData.durationType}\&quot;,\n  \&quot;remainingRedemptions\&quot;: \&quot;${promoData.remainingRedemptions}\&quot;,\n  \&quot;procedures\&quot;: [],\n  \&quot;_status\&quot;: \&quot;${promoData._status}\&quot;\n}&quot;,
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
