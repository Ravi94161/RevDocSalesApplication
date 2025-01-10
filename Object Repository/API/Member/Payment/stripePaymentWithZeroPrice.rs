<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>stripePaymentWithZeroPrice</name>
   <tag></tag>
   <elementGuidId>b5b14db5-681d-473f-af61-1786c43a2c56</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;payment_method_data%5Bmuid%5D\u003d0c4cc75d-f2cf-4544-8bc3-0241b55cd492d53603\u0026payment_method_data%5Bbilling_details%5D%5Baddress%5D%5Bpostal_code%5D\u003d48867\u0026payment_method_data%5Bbilling_details%5D%5Baddress%5D%5Bcountry%5D\u003dUS\u0026payment_method_data%5Bpayment_user_agent%5D\u003dstripe-android%2F20.40.4%3BPaymentSheet\u0026payment_method_data%5Bguid%5D\u003d96960649-757b-4237-8981-b611270d35a525938d\u0026payment_method_data%5Btype%5D\u003dcard\u0026payment_method_data%5Bcard%5D%5Bnumber%5D\u003d4111111111111111\u0026payment_method_data%5Bcard%5D%5Bcvc%5D\u003d223\u0026payment_method_data%5Bcard%5D%5Bexp_month%5D\u003d11\u0026payment_method_data%5Bcard%5D%5Bexp_year%5D\u003d2045\u0026payment_method_data%5Bsid%5D\u003dadb897e6-f964-4905-b0a9-3870f6c3cbd018f077\u0026return_url\u003dstripesdk%3A%2F%2Fpayment_return_url%2Fcom.revdoc.member\u0026expand%5B%5D\u003dpayment_method\u0026client_secret\u003d${setupIntent}\u0026use_stripe_sdk\u003dtrue&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/x-www-form-urlencoded</value>
      <webElementGuid>471ef4c0-09e1-463b-ac07-d1d4f6882499</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer pk_test_51NiL51DAb0SOy5kRSoV3dmq0iEru7VHKE0acpRCNLV5Z33ynhPMkx3eXvxoh3TZNe8uvcZOgsHy84VyK6qPRHNS200XHHZViWW</value>
      <webElementGuid>aa56b7fc-ce8f-44de-98ee-bbee01b03e56</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.2.5</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://api.stripe.com/v1/setup_intents/seti_${payment_id}/confirm</restUrl>
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
