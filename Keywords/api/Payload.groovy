package api

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import groovy.json.JsonSlurper

import internal.GlobalVariable
import api.Provider
import mobile.Generic

public class Payload {
	Generic gen = new Generic()
	Provider pro = new Provider()

	@Keyword
	def getToken(email = GlobalVariable.adminEmail, password = GlobalVariable.adminPassword) {
		def responseLogin = WS.sendRequest(findTestObject('Object Repository/API/POST Login',['email':email, 'password':password]))
		WS.verifyResponseStatusCode(responseLogin, 200)

		String responseBody = responseLogin.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		GlobalVariable.token = responseLogin.getHeaderField("St-Access-Token");
		println "providerToken: " +  GlobalVariable.token
		return jsonResponseBody.user.id
	}

	@Keyword
	def getProviderID(email) {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/GET Provider ID',['email': email]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody.docs[0].id
	}

	@Keyword
	def postAndGetPayloadLoginToken() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Payload/POST PayloadLogin'))
		WS.verifyResponseStatusCode(tokenResponse, 200)

		String responseBody = tokenResponse.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		GlobalVariable.token = jsonResponseBody.token
		return jsonResponseBody.token
	}

	@Keyword
	def patchGoLive(id) {
		def responseGoLive = WS.sendRequest(findTestObject('Object Repository/API/PATCH Go Live', ['providerID': id]))
		WS.verifyResponseStatusCode(responseGoLive, 200)
	}


	@Keyword
	def postProviderLoginAndSetToken(username = GlobalVariable.providerUserName, password = GlobalVariable.providerPassword) {
		if(GlobalVariable.providerToken == ""){
			def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/POST Login Auth', ["username": username, "password": password]))
			WS.verifyResponseStatusCode(tokenResponse, 200)

			GlobalVariable.providerToken =     tokenResponse.getHeaderField("St-Access-Token");

			String responseBody = tokenResponse.getResponseBodyContent()
			JsonSlurper parser = new JsonSlurper()
			def jsonResponseBody = parser.parseText(responseBody)
			GlobalVariable.providerId = jsonResponseBody.user.id

			println "providerToken: " +  GlobalVariable.providerToken

			println "providerId: " + GlobalVariable.providerId
		}
	}

	@Keyword
	def patchDeliveryAddress(deliveryAddressId, ownerId, addressId) {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Payload/PATCH DeliveryAddress', ['deliveryAddressId': deliveryAddressId, 'ownerId': ownerId, 'addressId': addressId]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def updateApptEncounterTimeForSignNote(id, hoursToRemoveForStartTime, hoursToRemoveForEndTime) {
		postAndGetPayloadLoginToken();
		def providerEncounterList = pro.getProviderEncounterDetails(id)
		println(providerEncounterList)
		def firstEncounterId = providerEncounterList.docs[0].id
		println(firstEncounterId)
		def encounterStartTime = gen.convertAndFormatToSignNoteEncounterTime(hoursToRemoveForStartTime)
		def encounterEndTime = gen.convertAndFormatToSignNoteEncounterTime(hoursToRemoveForEndTime)
		postAndGetPayloadLoginToken();
		pro.updateEncounterTime(firstEncounterId, encounterStartTime.formattedTime, encounterEndTime.formattedTime)
		return ['encounterStartTime': encounterStartTime, 'encounterEndTime': encounterEndTime]
	}
}
