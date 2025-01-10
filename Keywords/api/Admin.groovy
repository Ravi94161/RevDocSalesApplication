package api

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import java.util.UUID

import mobile.Generic

public class Admin {
	Payload payload = new Payload();
	Member memberApi = new Member();
	Generic gen = new Generic();

	def deliveryMethodsList = ["HouseCall": '\"64dbc7a37c524ff621491dcd\"', "Telemedicine": '\"64dbc7a97c524ff621491dd5\"',
		"Van": '\"64dbc79b7c524ff621491dc5\"', "Facility": '\"64dbc7977c524ff621491dbd\"' ]


	@Keyword
	def getSupplies() {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/GET OrderSupplies'))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def postSymptoms(symptomName, effectiveDate) {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/POST Symptoms', ['symptomName': symptomName, 'effectiveDate': effectiveDate]))
		WS.verifyResponseStatusCode(responseProviderID, 201)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}


	@Keyword
	def getProcedureById(id) {
		payload.getToken();
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/GET procedure - ID', ['id': id]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def patchProcedure(id, data) {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/PATCH Procedure - ID', ['id': id, 'data': data]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def postInsurance(InsuranceName,id) {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/POST Insurance', ['InsuranceName': InsuranceName, 'id':id]))
		WS.verifyResponseStatusCode(responseProviderID, 201)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def postInsurancePlanName(PlanName,effectiveDate) {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/POST InsurancePlanName', ['PlanName': PlanName,'effectiveDate':effectiveDate]))
		WS.verifyResponseStatusCode(responseProviderID, 201)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def postSpeciality(speciality,effectiveDate) {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/POST Speciality', ['speciality': speciality,'effectiveDate':effectiveDate]))
		WS.verifyResponseStatusCode(responseProviderID, 201)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def patchProcedureSymptom(id, jsonBody) {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/PATCH Procedure - ID Symptom', ['id': id, 'body': jsonBody]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def getSpecialities() {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Member Specialty/GET Specialities'))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def postCategories(procedureCategoryName, effectiveDate, icon ='house-down-fill') {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/POST Categories', ['procedureCategoryName': procedureCategoryName,'procedureCategoryEffectiveDate': effectiveDate, 'icon': icon]))
		WS.verifyResponseStatusCode(responseProviderID, 201)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def patchCategories(id, procedureCategoryName, effectiveDate, termDate) {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/PATCH Categories', ['id': id, 'procedureCategoryName': procedureCategoryName,'procedureCategoryEffectiveDate': effectiveDate, 'procedureCategoryTermDate': termDate]))
		WS.verifyResponseStatusCode(responseProviderID, 200, FailureHandling.OPTIONAL)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def setProcedureTermDate(id, date) {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/PATCH Procedure - Term Date', ['id': id, 'isoFormateDate': date]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		def successMessage =  jsonResponseBody.message
		WS.verifyEqual(successMessage, "Updated successfully.")

		return jsonResponseBody
	}

	@Keyword
	def patchProcedureAddOn(id, value) {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/PATCH Procedure - ID Add-On', ['id': id, 'value': value]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def patchProcedureisDeaOnly(id, value) {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/PATCH Procedure - ID IsDeaOnly', ['id': id, 'value': value]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def patchProcedureCategory(id, jsonBody) {
		def response = WS.sendRequest(findTestObject('Object Repository/API/Admin/Procedure/PATCH Procedure - ID Category', ['id': id, 'body': jsonBody]))
		WS.verifyResponseStatusCode(response, 200)

		String responseBody = response.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def postProcedureImage() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Admin/Procedure/POST Procedure Image'))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postProcedure(procedureName) {
		def image = postProcedureImage()
		def mediaId = image.doc.id
		def response = WS.sendRequest(findTestObject('Object Repository/API/Admin/Procedure/POST Procedure', ['procedureName': procedureName,'mediaId':mediaId]))
		WS.verifyResponseStatusCode(response, 201)

		String responseBody = response.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def patchProcedureProviderType(id, jsonBody) {
		def response = WS.sendRequest(findTestObject('Object Repository/API/Admin/Procedure/PATCH Procedure - ID Provider Types', ['id': id, 'body': jsonBody]))
		WS.verifyResponseStatusCode(response, 200)

		String responseBody = response.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def patchAddAddOnToProcedure(id, value) {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/PATCH Procedure - AddAddOnToProcedure', ['id': id, 'value': value]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def getProcedureIdByName(procedureName) {
		payload.getToken();
		def procedureId = null
		def memberProceduresList = memberApi.getMemberProcedures();
		for (def i = 0; i < memberProceduresList.docs.size(); i++) {
			def doc = memberProceduresList.docs[i]
			if (doc.procedureName == procedureName) {
				procedureId = doc.id
				break
			}
		}
		return procedureId;
	}

	@Keyword
	def updateDeliveryMethodsOfProcedure(procedureId, List deliveryMethodNames) {
		List deliveryMethodsToUpdate = []

		for(int i=0; i<deliveryMethodNames.size(); i++) {
			deliveryMethodsToUpdate[i] = deliveryMethodsList[deliveryMethodNames[i]]
		}

		println "----- deliveryMethodsToUpdate = " + deliveryMethodsToUpdate
		def response = WS.sendRequest(findTestObject('Object Repository/API/Admin/Procedure/UpdateDeliveryMethods', ['id': procedureId, 'deliveryMethodIdsList': deliveryMethodsToUpdate]))
		WS.verifyResponseStatusCode(response, 200)

		String responseBody = response.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "updateDeliveryMethodJsonResponseBody: " + jsonResponseBody

		WS.verifyEqual(jsonResponseBody.message, "Updated successfully.")
		WS.verifyEqual(jsonResponseBody.doc.deliveryMethods.size(), deliveryMethodNames.size())

		return jsonResponseBody
	}

	@Keyword
	def getProviderDetails(ownerId) {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/Provider/GET ProviderDetails', ['ownerId': ownerId]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def patchBackGroundStatus(ownerId, prmId, providerDetails, providerStatus = 'active') {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/Provider/PATCH Backgorund Status', ['ownerId': ownerId, 'prmId': prmId, 'providerDetails': providerDetails, 'providerStatus': providerStatus]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def completeBackGroundStatus(ownerId, providerStatus = 'active') {
		def adminUserId = payload.getToken();
		println(adminUserId);

		def providerDetails = getProviderDetails(ownerId)
		payload.postAndGetPayloadLoginToken();
		payload.patchDeliveryAddress(providerDetails.deliveryAddresses[0].id, ownerId, providerDetails.deliveryAddresses[0].address.id)
		payload.getToken();
		patchBackGroundStatus(ownerId, adminUserId, providerDetails, providerStatus)
	}

	@Keyword
	def patchBackGroundStatusRevPrivate(ownerId) {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/ProviderRevPrivate/PATCH Backgorund Status - RevPrivate', ['ownerId': ownerId]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def patchConciergePracticeRevPrivate(conciergePractice) {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/ProviderRevPrivate/PATCH ConciergePractice - RevPrivate', ['conciergePractice': conciergePractice]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
	}

	@Keyword
	def postPromoImage() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Admin/Promos/POST Promo Image'))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postProcedurePromo(promoData) {
		def dates = gen.getEffectiveAndTermDates()
		def image = postPromoImage()
		def imageId = image.doc.id

		def data1 = [
			"isRevDoc": true,
			"isInfluencer": false,
			"promoCodeType": "procedures",
			"revBasic": false,
			"revPlus": true,
			"revPrivate": false,
			"showTo": ['\"revBasic\"'],
			"userType": "allUsers",
			"promoCode": gen.generateRandomString(10).toUpperCase(),
			"promoTitle": "Procedure Promo",
			"description": "promo description",
			"promoCodeImage": imageId,
			"isRegionDependent": false,
			"deliveryMethods": [
				'\"64dbc7977c524ff621491dbd\"',
				'\"64dbc79b7c524ff621491dc5\"',
				'\"64dbc7a37c524ff621491dcd\"',
				'\"64dbc7a97c524ff621491dd5\"'
			],
			"isStackable": false,
			"redemptionLimitType": "specificNumber",
			"durationInHours": null,
			"durationDateRange": true,
			"untilAllRedemptionsFilled": false,
			"discountType": "percentageOff",
			"amountOffValue": null,
			"percentageOffValue": "10",
			"freeMonthsValue": null,
			"discountValue": "10",
			"durationType": "durationDateRange",
			"maxRedemptions": 2,
			"remainingRedemptions": 2,
			"effectiveDate": dates.effectiveDate,
			"termDate": dates.termDate,
			"_status": "published"
		]

		promoData.each { key, value -> data1[key] = value}

		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Admin/Promos/POST Procedure Promo', ['promoData': data1,'imageId':imageId]))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postPromos(promoData) {
		def dates = gen.getEffectiveAndTermDates()
		def image = postPromoImage()
		def imageId = image.doc.id

		def data = [
			"isRevDoc": true,
			"isInfluencer": false,
			"promoCodeType": "membershipFees",
			"revBasic": false,
			"revPlus": true,
			"revPrivate": false,
			"showTo": ['\"revBasic\"'],
			"userType": "allUsers",
			"promoCode": gen.generateRandomString(10).toUpperCase(),
			"promoTitle": "Auto Membership promo${gen.generateRandomNumericString(5)}",
			"description": "promo description",
			"promoCodeImage": imageId,
			"isRegionDependent": false,
			"isStackable": false,
			"redemptionLimitType": "once",
			"durationInHours": null,
			"durationDateRange": false,
			"untilAllRedemptionsFilled": true,
			"discountType": "percentageOff",
			"amountOffValue": null,
			"percentageOffValue": "10",
			"freeMonthsValue": null,
			"additionalAmountOffWithMembership": false,
			"discountValue": "10",
			"durationType": "untilAllRedemptionsFilled",
			"maxRedemptions": 1,
			"remainingRedemptions": 1,
			"procedures": [],
			"effectiveDate": dates.effectiveDate,
			"termDate": "\"${dates.termDate}\"",
			"_status": "published"
		]

		promoData.each { key, value -> data[key] = value}

		def response = WS.sendRequest(findTestObject('Object Repository/API/Admin/Promos/POST Promos', ['promoData': data,'imageId':imageId]))
		WS.verifyResponseStatusCode(response, 201)

		String responseBody = response.getResponseBodyContent()
		println(responseBody:responseBody)
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return [res: jsonResponseBody, data: data]
	}

	@Keyword
	def postOffCartPromos(promoData) {
		def dates = gen.getEffectiveAndTermDates()
		def image = postPromoImage()
		def imageId = image.doc.id

		def data = [
			"isRevDoc": true,
			"isInfluencer": false,
			"promoCodeType": "offCart",
			"revBasic": true,
			"revPlus": true,
			"revPrivate": true,
			"showTo": [
				"revBasic",
				"revPlus",
				"revPrivate"
			],
			"userType": "madePurchaseBefore",
			"promoCode": gen.generateRandomString(10).toUpperCase(),
			"promoTitle": "Auto Membership promo${gen.generateRandomNumericString(5)}",
			"description": "promo description",
			"promoCodeImage": imageId,
			"isRegionDependent": false,
			"isStackable": false,
			"redemptionLimitType": "specificNumber",
			"durationInHours": null,
			"durationDateRange": true,
			"untilAllRedemptionsFilled": false,
			"discountType": "percentageOff",
			"amountOffValue": null,
			"percentageOffValue": "50",
			"effectiveDate": dates.effectiveDate,
			"termDate": "\"${dates.termDate}\"",
			"maxRedemptions": "100",
			"discountValue": "50",
			"durationType": "durationDateRange",
			"additionalAmountOffWithMembership": null,
			"remainingRedemptions": "100",
			"procedures": [],
			"_status": "published"
		]

		promoData.each { key, value -> data[key] = value}

		def response = WS.sendRequest(findTestObject('Object Repository/API/Admin/Promos/POST Promos', ['promoData': data,'imageId':imageId]))
		WS.verifyResponseStatusCode(response, 201)

		String responseBody = response.getResponseBodyContent()
		println(responseBody:responseBody)
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return [res: jsonResponseBody, data: data]
	}

	@Keyword
	def postPromosWithInvite(promoData) {
		def dates = gen.getEffectiveAndTermDates()
		def image = postPromoImage()
		def imageId = image.doc.id

		def data = [
			"isRevDoc": true,
			"isInfluencer": true,
			"promoCodeType": "membershipFees",
			"revBasic": true,
			"revPlus": true,
			"revPrivate": false,
			"showTo": ['\"revBasic\"'],
			"userType": "allUsers",
			"promoCode": gen.generateRandomString(10).toUpperCase(),
			"promoTitle": "Auto Membership promo${gen.generateRandomNumericString(5)}",
			"description": "promo code with invite",
			"promoCodeImage": imageId,
			"isRegionDependent": false,
			"isStackable": false,
			"redemptionLimitType": "unlimited",
			"durationInHours": null,
			"durationDateRange": true,
			"untilAllRedemptionsFilled": false,
			"discountType": "amountOff",
			"amountOffValue": "15",
			"percentageOffValue": null,
			"influencerMemberIds": [
				"influencerMemberId": "REVSCC3ZJ",
				"firstName": "",
				"lastName": "",
				"mobilePhoneNumber": "+16363636363"
			],
			"freeMonthsValue": null,
			"effectiveDate": dates.effectiveDate,
			"termDate": "\"${dates.termDate}\"",
			"discountValue": "15",
			"durationType": "durationDateRange",
			"maxRedemptions": 0,
			"remainingRedemptions": 0,
			"procedures": [],
			"_status": "published"
		]

		promoData.each { key, value -> data[key] = value}

		def response = WS.sendRequest(findTestObject('Object Repository/API/Admin/Promos/POST PromoWithInvite', ['promoData': data,'imageId':imageId]))
		WS.verifyResponseStatusCode(response, 201)

		String responseBody = response.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return [res: jsonResponseBody, data: data]
	}

	@Keyword
	def postPromosWithAdditionalDiscount(promoData) {
		def dates = gen.getEffectiveAndTermDates()
		def image = postPromoImage()
		def imageId = image.doc.id

		def data = [
			"isRevDoc": true,
			"isInfluencer": false,
			"promoCodeType": "membershipFees",
			"revBasic": false,
			"revPlus": true,
			"revPrivate": false,
			"showTo": ['\"revBasic\"'],
			"userType": "allUsers",
			"promoCode": gen.generateRandomString(10).toUpperCase(),
			"promoTitle": "Auto Membership promo${gen.generateRandomNumericString(5)}",
			"description": "promo description",
			"promoCodeImage": imageId,
			"isRegionDependent": false,
			"isStackable": false,
			"redemptionLimitType": "once",
			"durationInHours": null,
			"durationDateRange": false,
			"untilAllRedemptionsFilled": true,
			"discountType": "percentageOff",
			"amountOffValue": null,
			"percentageOffValue": "10",
			"freeMonthsValue": null,
			"additionalAmountOffWithMembership": false,
			"additionalAmountOff": "15",
			"discountValue": "10",
			"durationType": "untilAllRedemptionsFilled",
			"maxRedemptions": 1,
			"remainingRedemptions": 1,
			"procedures": [],
			"effectiveDate": dates.effectiveDate,
			"termDate": "\"${dates.termDate}\"",
			"_status": "published"
		]

		promoData.each { key, value -> data[key] = value}

		def response = WS.sendRequest(findTestObject('Object Repository/API/Admin/Promos/POST PromosWithAdditionalDiscount', ['promoData': data,'imageId':imageId]))
		WS.verifyResponseStatusCode(response, 201)

		String responseBody = response.getResponseBodyContent()
		println(responseBody:responseBody)
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return [res: jsonResponseBody, data: data]
	}

	@Keyword
	def postPromosForRegion(promoData) {
		def dates = gen.getEffectiveAndTermDates()
		def image = postPromoImage()
		def imageId = image.doc.id

		def data = [
			"isRevDoc": true,
			"isInfluencer": false,
			"promoCodeType": "membershipFees",
			"revBasic": false,
			"revPlus": true,
			"revPrivate": false,
			"showTo": ['\"revBasic\"'],
			"userType": "allUsers",
			"promoCode": gen.generateRandomString(10).toUpperCase(),
			"promoTitle": "Auto Membership promo${gen.generateRandomNumericString(5)}",
			"description": "promo description",
			"promoCodeImage": imageId,
			"isRegionDependent": false,
			"isStackable": false,
			"redemptionLimitType": "once",
			"durationInHours": null,
			"durationDateRange": false,
			"untilAllRedemptionsFilled": true,
			"discountType": "percentageOff",
			"amountOffValue": null,
			"percentageOffValue": "10",
			"freeMonthsValue": null,
			"additionalAmountOffWithMembership": false,
			"discountValue": "10",
			"durationType": "untilAllRedemptionsFilled",
			"maxRedemptions": 1,
			"regions": [
				"stateCode": "MI",
				"city": "Owosso",
				"postalCode": "48867"
			],
			"remainingRedemptions": 1,
			"procedures": [],
			"effectiveDate": dates.effectiveDate,
			"termDate": "\"${dates.termDate}\"",
			"_status": "published"
		]

		promoData.each { key, value -> data[key] = value}

		def response = WS.sendRequest(findTestObject('Object Repository/API/Admin/Promos/POST PromosForRegion', ['promoData': data,'imageId':imageId]))
		WS.verifyResponseStatusCode(response, 201)

		String responseBody = response.getResponseBodyContent()
		println(responseBody:responseBody)
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return [res: jsonResponseBody, data: data]
	}

	@Keyword
	def patchCancelPromo(promoId) {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/Promos/PATCH CancelPromo', ['id': promoId]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
	}

	@Keyword
	def postPromosForTwoProcedures(promoData) {
		def image = postPromoImage()
		def imageId = image.doc.id

		def data2 = [
			"isRevDoc": true,
			"isInfluencer": false,
			"promoCodeType": "procedures",
			"revBasic": true,
			"revPlus": true,
			"revPrivate": true,
			"showTo": ['\"revBasic\"'],
			"userType": "allUsers",
			"promoCode": gen.generateRandomString(10).toUpperCase(),
			"promoTitle": "Auto Multi Procedure promo${gen.generateRandomNumericString(5)}",
			"description": "promo description",
			"promoCodeImage": imageId,
			"isRegionDependent": false,
			"deliveryMethods": [
				'\"64dbc7977c524ff621491dbd\"',
				'\"64dbc79b7c524ff621491dc5\"',
				'\"64dbc7a37c524ff621491dcd\"',
				'\"64dbc7a97c524ff621491dd5\"'
			],
			"isStackable": false,
			"redemptionLimitType": "once",
			"durationInHours": null,
			"durationDateRange": false,
			"untilAllRedemptionsFilled": true,
			"discountType": "percentageOff",
			"amountOffValue": null,
			"percentageOffValue": "10",
			"additionalAmountOffWithMembership": false,
			"discountValue": "10",
			"durationType": "untilAllRedemptionsFilled",
			"maxRedemptions": 2,
			"remainingRedemptions": 2,
			"effectiveDate": "2024-07-16T07:34:12",
			"termDate": null,
			"_status": "published"
		]

		promoData.each { key, value -> data2[key] = value}

		def response = WS.sendRequest(findTestObject('Object Repository/API/Admin/Promos/POST PromosWithTwoProcedures', ['promoData': data2,'imageId':imageId]))
		WS.verifyResponseStatusCode(response, 201)

		String responseBody = response.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return [res: jsonResponseBody, data: data2]
	}

	@Keyword
	def postSingleLabPromo(promoData) {
		def dates = gen.getEffectiveAndTermDates()
		def image = postPromoImage()
		def imageId = image.doc.id

		def data1 = [
			"isRevDoc": true,
			"isInfluencer": false,
			"promoCodeType": "labs",
			"revBasic": true,
			"revPlus": false,
			"revPrivate": false,
			"showTo": ['\"revBasic\"'],
			"userType": "allUsers",
			"promoCode": gen.generateRandomString(10).toUpperCase(),
			"promoTitle": "Single Lab Promo",
			"description": "promo description",
			"promoCodeImage": imageId,
			"isRegionDependent": false,
			"isStackable": false,
			"redemptionLimitType": "specificNumber",
			"durationInHours": null,
			"durationDateRange": true,
			"untilAllRedemptionsFilled": true,
			"discountType": "percentageOff",
			"amountOffValue": null,
			"percentageOffValue": "10",
			"freeMonthsValue": null,
			"discountValue": "10",
			"durationType": "untilAllRedemptionsFilled",
			"maxRedemptions": 2,
			"remainingRedemptions": 2,
			"effectiveDate": dates.effectiveDate,
			"termDate": dates.termDate,
			"_status": "published"
		]

		promoData.each { key, value -> data1[key] = value}

		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Admin/Promos/POST PromoWithSingleLab', ['promoData': data1,'imageId':imageId]))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postMultiLabPromo(promoData) {
		def dates = gen.getEffectiveAndTermDates()
		def image = postPromoImage()
		def imageId = image.doc.id

		def data1 = [
			"isRevDoc": true,
			"isInfluencer": false,
			"promoCodeType": "labs",
			"revBasic": true,
			"revPlus": false,
			"revPrivate": false,
			"showTo": ['\"revBasic\"'],
			"userType": "allUsers",
			"promoCode": gen.generateRandomString(10).toUpperCase(),
			"promoTitle": "Multi Lab Promo",
			"description": "promo description",
			"promoCodeImage": imageId,
			"isRegionDependent": false,
			"isStackable": false,
			"redemptionLimitType": "specificNumber",
			"durationInHours": null,
			"durationDateRange": true,
			"untilAllRedemptionsFilled": true,
			"discountType": "percentageOff",
			"amountOffValue": null,
			"percentageOffValue": "10",
			"freeMonthsValue": null,
			"discountValue": "10",
			"durationType": "untilAllRedemptionsFilled",
			"maxRedemptions": 2,
			"remainingRedemptions": 2,
			"effectiveDate": dates.effectiveDate,
			"termDate": dates.termDate,
			"_status": "published"
		]

		promoData.each { key, value -> data1[key] = value}

		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Admin/Promos/POST PromoWithMultipleLabs', ['promoData': data1,'imageId':imageId]))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postSingleLabPromoWithInvite(promoData) {
		def dates = gen.getEffectiveAndTermDates()
		def image = postPromoImage()
		def imageId = image.doc.id

		def data1 = [
			"isRevDoc": true,
			"isInfluencer": true,
			"promoCodeType": "labs",
			"revBasic": true,
			"revPlus": true,
			"revPrivate": true,
			"showTo": ['\"revBasic\"'],
			"userType": "allUsers",
			"promoCode": gen.generateRandomString(10).toUpperCase(),
			"promoTitle": "Single Lab Promo",
			"description": "promo description",
			"promoCodeImage": "66acbf9df52183e10fdb57c0",
			"isRegionDependent": false,
			"isStackable": false,
			"redemptionLimitType": "unlimited",
			"durationInHours": null,
			"durationDateRange": true,
			"untilAllRedemptionsFilled": false,
			"influencerMemberIds": [
				"influencerMemberId": "REVSCC3ZJ",
				"demographics.firstName": "",
				"demographics.lastName": "",
				"mobilePhoneNumber": "+16363636363"
			],
			"discountType": "amountOff",
			"amountOffValue": "10",
			"percentageOffValue": null,
			"effectiveDate": dates.effectiveDate,
			"termDate": dates.termDate,
			"discountValue": "10",
			"durationType": "durationDateRange",
			"maxRedemptions": 0,
			"remainingRedemptions": 0,
			"_status": "published"
		]
		promoData.each { key, value -> data1[key] = value}

		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Admin/Promos/POST PromoWithSingleLabAndInvite', ['promoData': data1,'imageId':imageId]))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def singleProcedureSpecificRegPromo(promoData) {
		def dates = gen.getEffectiveAndTermDates()
		def image = postPromoImage()
		def imageId = image.doc.id

		def data = [
			"isRevDoc": true,
			"isInfluencer": false,
			"promoCodeType": "procedures",
			"revBasic": false,
			"revPlus": false,
			"revPrivate": true,
			"showTo": ['\"revPrivate\"'],
			"userType": "allUsers",
			"promoCode": gen.generateRandomString(10).toUpperCase(),
			"promoTitle": "Auto Membership promo${gen.generateRandomNumericString(5)}",
			"description": "promo description",
			"promoCodeImage": imageId,
			"isRegionDependent": true,
			"isStackable": false,
			"redemptionLimitType": "unlimited",
			"durationDateRange": true,
			"untilAllRedemptionsFilled": false,
			"discountType": "percentageOff",
			"amountOffValue": null,
			"percentageOffValue": "10",
			"discountValue": "10",
			"durationType": "durationDateRange",
			"durationInHours": null,
			"maxRedemptions": 0,
			"regions": [
				"stateCode": "MI",
				"city": "Owosso",
				"postalCode": "48867"
			],
			"remainingRedemptions": 0,
			"procedures": [],
			"effectiveDate": dates.effectiveDate,
			"termDate": dates.termDate,
			"_status": "published"
		]
		promoData.each { key, value -> data[key] = value}

		def response = WS.sendRequest(findTestObject('Object Repository/API/Admin/Promos/POST PromoProcForSpecificRegion', ['promoData': data,'imageId':imageId]))
		WS.verifyResponseStatusCode(response, 201)

		String responseBody = response.getResponseBodyContent()
		println(responseBody:responseBody)
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return [res: jsonResponseBody, data: data]
	}

	@Keyword
	def createPromo(promoData) {
		def dates = gen.getEffectiveAndTermDates()
		def image = postPromoImage()
		def imageId = image.doc.id
		promoData.promoCodeImage = imageId
		def requestBody = JsonOutput.toJson(promoData)
		println requestBody

		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Admin/Procedure/POST Promo - CREATE', ['body': requestBody]))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		Mobile.comment("${jsonResponseBody}")
		return jsonResponseBody
	}

	@Keyword
	def getProgramDetails(programName) {
		payload.getToken();
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/Programs/GET Programs', ['programName': programName]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		// Mobile.comment("${jsonResponseBody}")

		return jsonResponseBody
	}

	@Keyword
	def patchProgram(programId, status = 'cancelled') {
		payload.getToken();
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/Programs/PATCH UpdateProgram-Cancel', ['id': programId, 'status': status]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		// Mobile.comment("${jsonResponseBody}")
		return jsonResponseBody
	}

	@Keyword
	def postProgramImage() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Admin/Programs/POST ProgramImage'))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		Mobile.comment("${jsonResponseBody}")
		return jsonResponseBody
	}

	@Keyword
	def createProgram(promoData) {
		payload.getToken();
		def dates = gen.getEffectiveAndTermDates(0)
		def image = postProgramImage()
		def imageId = image.doc.id
		Mobile.comment("imageId: ${imageId}")

		promoData.programImage = imageId;

		def requestBody = JsonOutput.toJson(promoData)
		// Mobile.comment("${requestBody}")

		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Admin/Programs/POST Program', ['body': requestBody]))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		// Mobile.comment("${jsonResponseBody}")
		return jsonResponseBody
	}

	@Keyword
	def createAndPublishProgram(promoData) {
		def data = createProgram(promoData)
		patchProgram(data.doc.id, 'published')

		return data
	}

	@Keyword
	def createPublishProgramWithStaff(promoData, providerId) {

		def data = createProgram(promoData)
		def programId = data.doc.id
		patchProgram(programId, 'published')

		def inviteProviderData = WS.sendRequest(findTestObject('Object Repository/API/Admin/Programs/add provider to program', ['provider_id': providerId, 'program_id':programId]))
		WS.verifyResponseStatusCode(inviteProviderData, 201)

		String responseBody = inviteProviderData.getResponseBodyContent()
		// println(responseBody:responseBody)
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		// Mobile.comment("${jsonResponseBody}")

		def successMessage =  jsonResponseBody.message
		WS.verifyEqual(successMessage, "Program Provider successfully created.")

		return data
	}

	@Keyword
	def getProcedureDetails(procedureName) {
		payload.getToken();
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/Procedure/GET Procedure', ['procedureName': procedureName]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		println(responseBody:responseBody)
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		Mobile.comment("${jsonResponseBody}")

		return jsonResponseBody
	}

	@Keyword
	def getMemberHomeScreenDetails() {
		payload.getToken();
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/MemberHomeScreen/GET MemberHomeScreen',))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		Mobile.comment("${jsonResponseBody}")

		return jsonResponseBody
	}

	@Keyword
	def postProcedureHomeScreenSubtitle(id, homeScreenSubtitle) {
		payload.getToken();
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/Procedure/PATCH Procedure - ID Home Screen Subtitle',['id':id,'homeScreenSubtitle': homeScreenSubtitle]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		Mobile.comment("${jsonResponseBody}")

		return jsonResponseBody
	}

	@Keyword
	def getProgramNameByIndex(id) {
		payload.getToken();
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/Programs/GET Program name By ID',['id':id]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		Mobile.comment("${jsonResponseBody}")
		return jsonResponseBody
	}

	@Keyword
	def postAffiliationImage() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Admin/Affiliation/POST AffiliationImage'))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		Mobile.comment("${jsonResponseBody}")
		return jsonResponseBody
	}

	@Keyword
	def createAffiliation(affiliationData) {
		payload.getToken();
		def dates = gen.getEffectiveAndTermDates(0)
		def image = postAffiliationImage()
		def imageId = image.doc.id
		Mobile.comment("imageId: ${imageId}")

		affiliationData.affiliationImage = imageId;

		def requestBody = JsonOutput.toJson(affiliationData)
		Mobile.comment("${requestBody}")

		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Admin/Affiliation/POST Affiliation', ['body': requestBody]))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		Mobile.comment("${jsonResponseBody}")
		return jsonResponseBody
	}

	@Keyword
	def patchAffiliation(id, affiliationData) {
		payload.getToken();
		def requestBody = JsonOutput.toJson(affiliationData)
		Mobile.comment("${requestBody}")

		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Admin/Affiliation/PATCH Affiliation', ['body': requestBody, 'id': id]))
		WS.verifyResponseStatusCode(tokenResponse, 200)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		Mobile.comment("${jsonResponseBody}")
		return jsonResponseBody
	}

	@Keyword
	def getAffiliationDetails(id) {
		payload.getToken();
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/Affiliation/GET Affiliation',['id': id]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		Mobile.comment("${jsonResponseBody}")

		return jsonResponseBody
	}

	@Keyword
	def createEmployerBasedProgram(promoData) {
		payload.getToken();
		def dates = gen.getEffectiveAndTermDates(0)
		def image = postProgramImage()
		def imageId = image.doc.id
		Mobile.comment("imageId: ${imageId}")

		promoData.programImage = imageId;

		def requestBody = JsonOutput.toJson(promoData)
		Mobile.comment("${requestBody}")

		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Admin/Programs/POST Program - Employer based', ['body': requestBody]))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		Mobile.comment("${jsonResponseBody}")
		return jsonResponseBody
	}

	@Keyword
	def createAndPublishEmployerProgram(promoData) {
		def data = createEmployerBasedProgram(promoData)
		patchProgram(data.doc.id, 'published')

		return data
	}

	@Keyword
	def postEmployerProgramMember(data) {
		payload.getToken();
		def requestBody = JsonOutput.toJson(data)
		println requestBody
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Admin/Programs/POST Program Members', ['body': requestBody]))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		Mobile.comment("${jsonResponseBody}")
		return jsonResponseBody
	}

	@Keyword
	def patchEmployerProgramMember(data, id) {
		payload.getToken();
		def requestBody = JsonOutput.toJson(data)
		println requestBody
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Admin/Programs/PATCH Program Members', ['body': requestBody, 'id': id]))
		WS.verifyResponseStatusCode(tokenResponse, 200)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		Mobile.comment("${jsonResponseBody}")
		return jsonResponseBody
	}

	@Keyword
	def getGiveawayDetails(giveawayName) {
		payload.getToken();
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/Giveaways/GET GiveawaysByName', ['name': giveawayName]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		Mobile.comment("${jsonResponseBody}")

		return jsonResponseBody
	}

	@Keyword
	def getLabDetailsById(id) {
		payload.getToken();
		def responseLabDetails = WS.sendRequest(findTestObject('Object Repository/API/GET Lab Details by ID', ['id': id]))
		WS.verifyResponseStatusCode(responseLabDetails, 200)

		String responseBody = responseLabDetails.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def getHomePageTopIcons() {
		payload.getToken();
		def response = WS.sendRequest(findTestObject('Object Repository/API/Admin/Home Page Top/GET HomePageIcons'))
		WS.verifyResponseStatusCode(response, 200)

		String responseBody = response.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def patchHomePageTopIconsSwapIcons(data) {
		JsonSlurper parser = new JsonSlurper()
		def jsonObject = getHomePageTopIcons()
		def jsonObjectBackUp = jsonObject.icons
		def icons = jsonObject.icons
		def numberOfIcons = icons.size()

		// Swap the first and second objects
		def temp = icons[0]
		icons[0] = icons[1]
		icons[1] = temp

		// Modify fields in the first object (original second object)
		icons[0].order = '1'

		// Modify fields in the second object (original first object)
		icons[1].iconName = "Automation ${icons[1].iconName}"
		icons[1].order = '2'
		def dataUpdated = parser.parseText(data)
		icons[1].procedureCategory = dataUpdated

		// Convert back to JSON string
		def updatedJsonString = JsonOutput.prettyPrint(JsonOutput.toJson(icons))

		// Print the updated JSON
		println(updatedJsonString)
		Mobile.comment("${updatedJsonString}")

		payload.getToken();
		def response = WS.sendRequest(findTestObject('Object Repository/API/Admin/Home Page Top/POST HomePageIcons - Update',['data':updatedJsonString])) //
		WS.verifyResponseStatusCode(response, 200)

		String responseBody = response.getResponseBodyContent()

		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return ['jsonObjectBackUp':jsonObjectBackUp, 'jsonResponseBody':jsonResponseBody, 'iconsData':icons]
	}

	@Keyword
	def revertBackHomePageTopIcons(data) {
		def updatedJsonString = JsonOutput.prettyPrint(JsonOutput.toJson(data))

		payload.getToken();
		def response = WS.sendRequest(findTestObject('Object Repository/API/Admin/Home Page Top/POST HomePageIcons - Update',['data':updatedJsonString]))
		WS.verifyResponseStatusCode(response, 200)

		String responseBody = response.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return ['jsonResponseBody':jsonResponseBody]
	}

	@Keyword
	def postHomePageIconImage() {
		payload.getToken();
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Admin/Home Page Top/POST Icon Image'))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody.doc
	}

	@Keyword
	def postHomePageTopIcons(newIcon) {
		JsonSlurper parser = new JsonSlurper()
		def jsonObject = getHomePageTopIcons()
		def jsonObjectBackUp = jsonObject
		def icons = jsonObject.icons

		def iconsCount = icons.size()
		newIcon.order = iconsCount+1
		icons << newIcon

		//		def sortedIcons = icons.sort { [it.rowNumber, it.order ?: 0] }
		//
		//		// Adjust the order
		//		sortedIcons.eachWithIndex { icon, idx ->
		//			icon.order = idx + 1
		//		}

		def iconsDataNew = JsonOutput.toJson(icons)

		// Convert back to JSON string
		//		def updatedJsonString = JsonOutput.prettyPrint(JsonOutput.toJson(icons))

		// Print the updated JSON
		//		println(updatedJsonString)
		//		Mobile.comment("${updatedJsonString}")

		payload.getToken();
		def response = WS.sendRequest(findTestObject('Object Repository/API/Admin/Home Page Top/POST HomePageIcons',['data':iconsDataNew])) //
		WS.verifyResponseStatusCode(response, 200)

		String responseBody = response.getResponseBodyContent()

		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return ['jsonObjectBackUp':jsonObjectBackUp, 'jsonResponseBody':jsonResponseBody]
	}

	@Keyword
	def patchUpdateTheProgram(programId, body) {
		payload.getToken();
		def requestBody = JsonOutput.toJson(body)
		Mobile.comment("${requestBody}")
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/Programs/PATCH UpdateProgramDetails', ['id': programId, 'body': requestBody]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		Mobile.comment("${jsonResponseBody}")
		return jsonResponseBody
	}
	
	@Keyword
	def getProviderDetailsByAdmin(providerId) {
		payload.getToken();
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Admin/Get Provider Details - Admin', ['providerId': providerId]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		Mobile.comment("${jsonResponseBody}")
		return jsonResponseBody
	}
}
