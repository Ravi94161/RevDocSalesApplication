<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>GET procedure - ID</name>
   <tag></tag>
   <elementGuidId>4b8bc1f4-8278-4663-a6fc-3193b1b3e816</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>true</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer eyJraWQiOiJkLTE3MDU5MjY1MjcxMzkiLCJ0eXAiOiJKV1QiLCJ2ZXJzaW9uIjoiNCIsImFsZyI6IlJTMjU2In0.eyJpYXQiOjE3MDYwNzQxNDEsImV4cCI6MTcwNjA3Nzc0MCwic3ViIjoiZTcxMzljYjEtMjM3My00MzJhLWEyMmMtNzFlOTk4N2IxM2Y4IiwidElkIjoicHVibGljIiwic2Vzc2lvbkhhbmRsZSI6ImVlZGYyN2U5LWU4ODItNGI2ZC1hM2RmLTg4NTYyYzZlN2Y4MiIsInJlZnJlc2hUb2tlbkhhc2gxIjoiMTJlNmVkZmQ5Zjk3Y2JmMTE0OTI1MzI0YmFlOTYzMDBjZTI4N2VhOGMzOWM1NzEwMTg1OTU3ZDQyZWQzOTEzMCIsInBhcmVudFJlZnJlc2hUb2tlbkhhc2gxIjpudWxsLCJhbnRpQ3NyZlRva2VuIjpudWxsLCJpc3MiOiJodHRwczovL2FwaS5zdGFnZS51cy1lYXN0LTIuYXBpLnJldmRvYy5saW5rL3YxL3Byb3ZpZGVyL2F1dGgiLCJzdC1yb2xlIjp7InYiOlsicHJvdmlkZXIiXSwidCI6MTcwNjA3NDEzOTM3M30sInN0LXBlcm0iOnsidiI6WyJwcm92aWRlciJdLCJ0IjoxNzA2MDc0MTM5NzYwfSwiZW1haWwiOiJicm9uY2hvc2NvcHl1c2VyQGdtYWlsLmNvbSIsInBob25lIjoiOTE0MzIxNDU3OSIsIm1mYSI6ZmFsc2UsIjJmYS1jb21wbGV0ZWQiOnsidiI6ZmFsc2UsInQiOjE3MDYwNzQxNDAzNTl9fQ.GXvW9oLc1uY0KILBcFZhkYpHHX-bPN5c_0ukRFFZ_uxAlhSSIDVsswyZl653wb67mbcFrKwsD1B1UMc6eLeD7JFAApulEVV1I9MXElCg3vQavlMVG7dU93RgoYqYWWL2fBzXboqVkfWAGweUFojkxumO4rZD5gerWzJo-AvlhRASdVfYFtt8tVcSB_6O0s7G8PmZ25oYN_AXUkwnEI_ZOO1kASLtY6FVebAWT02am7tbjzmcUY1vC2pekNxtGXO7_RnAOtzpGZ8b9szB6mc_a8PgyLTiCFjXki8_c_PfqB_8FkVOx_lppInXYa0KdKTEwIK3UpUrDRjTLXBIyEL_7A</value>
      <webElementGuid>3d98082b-694b-40e2-87bd-75ca85bb4ff3</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.8</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://api.stage.us-east-2.api.revdoc.link/v1/payload/api/providers/e7139cb1-2373-432a-a22c-71e9987b13f8</restUrl>
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
