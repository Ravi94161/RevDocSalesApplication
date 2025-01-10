<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>POST PromoWithInvite</name>
   <tag></tag>
   <elementGuidId>f8a7d491-3e82-4ca6-839b-aadfd8908d49</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;isRevDoc\&quot;: ${promoData.isRevDoc},\n  \&quot;isInfluencer\&quot;: ${promoData.isInfluencer},\n  \&quot;promoCodeType\&quot;: \&quot;${promoData.promoCodeType}\&quot;,\n  \&quot;revBasic\&quot;: ${promoData.revBasic},\n  \&quot;revPlus\&quot;: ${promoData.revPlus},\n  \&quot;revPrivate\&quot;: ${promoData.revPrivate},\n  \&quot;showTo\&quot;: ${promoData.showTo},\n  \&quot;userType\&quot;: \&quot;${promoData.userType}\&quot;,\n  \&quot;promoCode\&quot;: \&quot;${promoData.promoCode}\&quot;,\n  \&quot;promoTitle\&quot;: \&quot;${promoData.promoTitle}\&quot;,\n  \&quot;description\&quot;: \&quot;${promoData.description}\&quot;,\n  \&quot;promoCodeImage\&quot;: \&quot;${imageId}\&quot;,\n  \&quot;isRegionDependent\&quot;: \&quot;${promoData.isRegionDependent}\&quot;,\n  \&quot;isStackable\&quot;: \&quot;${promoData.isStackable}\&quot;,\n  \&quot;redemptionLimitType\&quot;: \&quot;${promoData.redemptionLimitType}\&quot;,\n  \&quot;durationInHours\&quot;: ${promoData.durationInHours},\n  \&quot;durationDateRange\&quot;: \&quot;${promoData.durationDateRange}\&quot;,\n  \&quot;untilAllRedemptionsFilled\&quot;: \&quot;${promoData.untilAllRedemptionsFilled}\&quot;,\n  \&quot;discountType\&quot;: \&quot;${promoData.discountType}\&quot;,\n  \&quot;amountOffValue\&quot;: \&quot;${promoData.amountOffValue}\&quot;,\n  \&quot;percentageOffValue\&quot;: \&quot;${promoData.percentageOffValue}\&quot;,\n  \&quot;influencerMemberIds\&quot;: [\n    {\n      \&quot;influencerMemberId\&quot;: \&quot;${promoData.influencerMemberIds.influencerMemberId}\&quot;,\n      \&quot;demographics.firstName\&quot;: \&quot;${promoData.influencerMemberIds.firstName}\&quot;,\n      \&quot;demographics.lastName\&quot;: \&quot;${promoData.influencerMemberIds.lastName}\&quot;,\n      \&quot;mobilePhoneNumber\&quot;: \&quot;${promoData.influencerMemberIds.mobilePhoneNumber}\&quot;\n    }\n  ],\n  \&quot;freeMonthsValue\&quot;: \&quot;${promoData.freeMonthsValue}\&quot;,\n  \&quot;discountValue\&quot;: \&quot;${promoData.discountValue}\&quot;,\n  \&quot;durationType\&quot;: \&quot;${promoData.durationType}\&quot;,\n  \&quot;maxRedemptions\&quot;: \&quot;${promoData.maxRedemptions}\&quot;,\n  \&quot;remainingRedemptions\&quot;: \&quot;${promoData.remainingRedemptions}\&quot;,\n  \&quot;procedures\&quot;: [],\n  \&quot;effectiveDate\&quot;: \&quot;${promoData.effectiveDate}\&quot;,\n  \&quot;termDate\&quot;: ${promoData.termDate},\n  \&quot;_status\&quot;: \&quot;${promoData._status}\&quot;\n}&quot;,
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
      <webElementGuid>d2078b55-1192-4894-93f6-265908891c8e</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${GlobalVariable.token}</value>
      <webElementGuid>242f1cbd-69cf-4c9c-9e21-38235c80ded2</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.8</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.baseUrl}payload/api/promo-codes</restUrl>
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
