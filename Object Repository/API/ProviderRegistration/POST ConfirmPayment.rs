<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>POST ConfirmPayment</name>
   <tag></tag>
   <elementGuidId>ce2e15f2-ea65-4dc6-a15c-f42124f2f56a</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;contentType&quot;: &quot;application/x-www-form-urlencoded&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;,
  &quot;parameters&quot;: [
    {
      &quot;name&quot;: &quot;expand[]&quot;,
      &quot;value&quot;: &quot;payment_method&quot;
    },
    {
      &quot;name&quot;: &quot;payment_method_data[muid]&quot;,
      &quot;value&quot;: &quot;cb561e80-d389-4cd1-9c8f-331119f50fe96d9b27&quot;
    },
    {
      &quot;name&quot;: &quot;payment_method_data[billing_details][address][postal_code]&quot;,
      &quot;value&quot;: &quot;48867&quot;
    },
    {
      &quot;name&quot;: &quot;payment_method_data[billing_details][address][country]&quot;,
      &quot;value&quot;: &quot;US&quot;
    },
    {
      &quot;name&quot;: &quot;payment_method_data[payment_user_agent]&quot;,
      &quot;value&quot;: &quot;stripe-android/20.34.4;PaymentSheet&quot;
    },
    {
      &quot;name&quot;: &quot;payment_method_data[guid]&quot;,
      &quot;value&quot;: &quot;e3432a8e-c158-4174-8f8f-bfc5fd5f4079833881&quot;
    },
    {
      &quot;name&quot;: &quot;payment_method_data[type]&quot;,
      &quot;value&quot;: &quot;card&quot;
    },
    {
      &quot;name&quot;: &quot;payment_method_data[card][number]&quot;,
      &quot;value&quot;: &quot;4111111111111111&quot;
    },
    {
      &quot;name&quot;: &quot;payment_method_data[card][cvc]&quot;,
      &quot;value&quot;: &quot;344&quot;
    },
    {
      &quot;name&quot;: &quot;payment_method_data[card][exp_month]&quot;,
      &quot;value&quot;: &quot;10&quot;
    },
    {
      &quot;name&quot;: &quot;payment_method_data[card][exp_year]&quot;,
      &quot;value&quot;: &quot;2056&quot;
    },
    {
      &quot;name&quot;: &quot;payment_method_data[sid]&quot;,
      &quot;value&quot;: &quot;46974320-7a85-4d3b-a4a3-89b896b530d7c56e3f&quot;
    },
    {
      &quot;name&quot;: &quot;return_url&quot;,
      &quot;value&quot;: &quot;stripesdk://payment_return_url/com.revdoc.provider&quot;
    },
    {
      &quot;name&quot;: &quot;client_secret&quot;,
      &quot;value&quot;: &quot;${client_secret}&quot;
    },
    {
      &quot;name&quot;: &quot;use_stripe_sdk&quot;,
      &quot;value&quot;: &quot;true&quot;
    }
  ]
}</httpBodyContent>
   <httpBodyType>x-www-form-urlencoded</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/x-www-form-urlencoded</value>
      <webElementGuid>365b1097-1897-414e-80a2-d737ec3cd1a5</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer pk_test_51NiL51DAb0SOy5kRSoV3dmq0iEru7VHKE0acpRCNLV5Z33ynhPMkx3eXvxoh3TZNe8uvcZOgsHy84VyK6qPRHNS200XHHZViWW</value>
      <webElementGuid>cc6728df-1d78-4ce0-9aee-63736e0b60cf</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.8</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://api.stripe.com/v1/payment_intents/${key}/confirm</restUrl>
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
