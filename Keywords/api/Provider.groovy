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
import java.util.UUID
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable

public class Provider {

	@Keyword
	def signUpViaApi(email, phoneNumber) {
		def signUpData = postProviderSignUp(email, phoneNumber);
		GlobalVariable.providerRegistrationuser = email;
		postUpdateMemberSignUpMetaData(signUpData.user.id, email, phoneNumber);
		postSignUpAccetTermsAndConditions();
		return signUpData
	}

	@Keyword
	def getProviderByID() {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/GET Provider by ID'))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def postProviderSignIn(email, password = GlobalVariable.fullyCompletedUserPass) {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/ProviderSignUp/SignIn',['email':email, 'password': password]))
		WS.verifyResponseStatusCode(tokenResponse, 200)
		GlobalVariable.token = tokenResponse.getHeaderField("St-Access-Token");
		GlobalVariable.refreshToken = tokenResponse.getHeaderField("St-Refresh-Token");

		String responseBody = tokenResponse.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "signInResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def getProviderDetails() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/ProviderSignUp/Get ProviderDetails'))
		WS.verifyResponseStatusCode(tokenResponse, 200)
		String responseBody = tokenResponse.getResponseBodyContent()
		println(responseBody:responseBody)
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def getProviderEncounterDetails(id) {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Payload/Get ProviderEncounterDetails',['id': id]))
		WS.verifyResponseStatusCode(tokenResponse, 200)
		String responseBody = tokenResponse.getResponseBodyContent()
		println(responseBody:responseBody)
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def updateEncounterTime(encounterID, formattedStartTime, formattedEndTime) {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Payload/PATCH UpdateEncounterStartTime', ['encounterID': encounterID, 'formattedStartTime': formattedStartTime, 'formattedEndTime': formattedEndTime]))
		WS.verifyResponseStatusCode(tokenResponse, 200)
		String responseBody = tokenResponse.getResponseBodyContent()
		//println(responseBody:responseBody)
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		//println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postProviderSignUp(email, phoneNumber, password = GlobalVariable.fullyCompletedUserPass) {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/ProviderSignUp/SignUp',['email':email, 'password': password, 'phoneNumber': phoneNumber]))
		WS.verifyResponseStatusCode(tokenResponse, 200)
		GlobalVariable.token = tokenResponse.getHeaderField("St-Access-Token");
		GlobalVariable.refreshToken = tokenResponse.getHeaderField("St-Refresh-Token");

		String responseBody = tokenResponse.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postUpdateMemberSignUpMetaData(id, email, phoneNumber) {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/ProviderSignUp/UpdateSignUpMetadata',['id': id, 'email': email, 'phoneNumber': phoneNumber]))
		WS.verifyResponseStatusCode(tokenResponse, 200)
		String responseBody = tokenResponse.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postSignUpAccetTermsAndConditions() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/ProviderSignUp/AcceptTermsAndConditions'))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postGovernmentIdInDemographics() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/ProviderRegistration/POSTProviderGovernmentId'))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postUnderGraduateDiplomaImage() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/ProviderRegistration/POST ProviderUnderGraduateDiplomaId'))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postGraduateDiplomaImage() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/ProviderRegistration/POST ProviderGraduateDiplomaImage'))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postMedicalLicenseImage() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/ProviderRegistration/POST ProviderMedicalLicenseImage'))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postProviderSessionRefreshToken() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/ProviderRegistration/POST ProviderSessionRefresh'))
		WS.verifyResponseStatusCode(tokenResponse, 200)
		GlobalVariable.token = tokenResponse.getHeaderField("St-Access-Token");
		GlobalVariable.refreshToken = tokenResponse.getHeaderField("St-Refresh-Token");
		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postProviderDEALicenseImage() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/ProviderRegistration/POST ProvderDEALicenseImage'))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postProviderSignatureImage() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/ProviderRegistration/POST ProvderSignatureImage'))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def getProviderEmpowerConsent() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/ProviderRegistration/Get EmpowerConsent'))
		WS.verifyResponseStatusCode(tokenResponse, 304)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def getProviderEmpowerPdf() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/ProviderRegistration/GET ProviderEmpowePdf'))
		WS.verifyResponseStatusCode(tokenResponse, 200)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postSignProviderEmpowerDoc() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/ProviderRegistration/POST SignProviderEmpowerDoc'))
		WS.verifyResponseStatusCode(tokenResponse, 200)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postProviderData(regData = null, govtImageId, underGraduateImageId, graduateImageId, medicalLicenceImageId, signatureImageId, deaLicenceImageId) {
		def firstName1 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 4);
		def firstName =  "Auto${firstName1}"

		def lastName1 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 4);
		def lastName =  "last${lastName1}"

		def data = [
			"homeAddress": [
				"addressName": "Home",
				"addressLine1": "509 River st",
				"addressLine2": "",
				"city": "Owosso",
				"location": [-84.177477, 42.999253],
				"stateCode": "MI",
				"postalCode": "48867",
				"timezoneId": ""
			],
			"licenseState": "MI",
			"licenseImage": "${medicalLicenceImageId}",
			"licenseExpirationDate": "2026-03-19T00:00:00.000Z",
			"licenseNumber": "wter345",
			"licenseType": "658497efd1e3debd5aaa4eb8",
			"employerAddress": [
				"addressName": "Work",
				"addressLine1": "509 River st",
				"addressLine2": "",
				"city": "Owosso",
				"location": [-84.177477, 42.999253],
				"stateCode": "MI",
				"postalCode": "48867",
				"timezoneId": ""
			],
		]

		if(regData != null) {
			regData.each { key, value -> data[key] = value}
		}

		println("data": data)
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/ProviderRegistration/Post ProviderData', ['data': data, 'govtImageId': govtImageId, 'underGraduateImageId': underGraduateImageId, 'graduateImageId': graduateImageId, 'medicalLicenceImageId': medicalLicenceImageId, 'signatureImageId': signatureImageId, 'deaLicenceImageId': deaLicenceImageId, 'firstName': firstName, 'lastName': lastName]))
		WS.verifyResponseStatusCode(tokenResponse, 201)
		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postSignDocument() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/ProviderRegistration/POST ProviderSignDoc'))
		WS.verifyResponseStatusCode(tokenResponse, 200)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postPaymentSheet(signDocId) {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/ProviderRegistration/POST ProviderPaymentSheet', ['signDocId': signDocId]))
		WS.verifyResponseStatusCode(tokenResponse, 200)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postConfirmPayment(paymentIntent) {
		def key = paymentIntent.split("_secret_")[0]
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/ProviderRegistration/POST ConfirmPayment', ['client_secret': paymentIntent, 'key': key]))
		WS.verifyResponseStatusCode(tokenResponse, 200)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def signUpAndCompleteRegistrationViaApi(email, phoneNumber, data = null) {
		def signUpData = postProviderSignUp(email, phoneNumber);
		GlobalVariable.providerRegistrationuser = email;
		postUpdateMemberSignUpMetaData(signUpData.user.id, email, phoneNumber);
		postSignUpAccetTermsAndConditions();
		def govId;
		try {
			govId = postGovernmentIdInDemographics();
		} catch (Exception e) {
			govId = postGovernmentIdInDemographics();
		}
		println("govId": govId.doc.id)

		def underGraduateImageId = postUnderGraduateDiplomaImage();
		println("underGraduateImageId": underGraduateImageId.doc.id)
		def graduateImageId;
		try {
			graduateImageId = postGraduateDiplomaImage();
		} catch (Exception e) {
			graduateImageId = postGraduateDiplomaImage();
		}
		println("GraduateImageId": graduateImageId.doc.id)

		def medicalLicenceImageId;
		try {
			medicalLicenceImageId = postMedicalLicenseImage();
		} catch (Exception e) {
			medicalLicenceImageId = postMedicalLicenseImage();
		}

		println("medicalLicenceImageId": medicalLicenceImageId.doc.id)

		def deaLicenceImageId = postProviderDEALicenseImage();
		println("deaLicenceImageId": deaLicenceImageId.doc.id)

		postProviderSessionRefreshToken();
		def signatureImageId = postProviderSignatureImage();
		println("signatureImageId": signatureImageId.doc.id)

		//		def signedEmpowerDocId = postSignProviderEmpowerDoc()
		//		println("signedEmpowerDocId": signedEmpowerDocId.doc.id)

		postProviderData(data, govId.doc.id, underGraduateImageId.doc.id, graduateImageId.doc.id, medicalLicenceImageId.doc.id, signatureImageId.doc.id, deaLicenceImageId.doc.id)

		def signDocId = postSignDocument();
		println("signDoc": signDocId.doc.id)

		def payment = postPaymentSheet(signDocId.doc.id)
		println("signDoc": payment.paymentIntent)

		postConfirmPayment(payment.paymentIntent)
		println("data": signDocId)
		return signDocId
	}

	@Keyword
	def signUpAndCompleteRegistrationWithoutDEALicenseViaApi(email, phoneNumber, data = null) {
		def signUpData = postProviderSignUp(email, phoneNumber);
		GlobalVariable.providerRegistrationuser = email;
		postUpdateMemberSignUpMetaData(signUpData.user.id, email, phoneNumber);
		postSignUpAccetTermsAndConditions();
		def govId = postGovernmentIdInDemographics();
		println("govId": govId.doc.id)

		def underGraduateImageId = postUnderGraduateDiplomaImage();
		println("underGraduateImageId": underGraduateImageId.doc.id)

		def graduateImageId = postGraduateDiplomaImage();
		println("GraduateImageId": graduateImageId.doc.id)

		def medicalLicenceImageId = postMedicalLicenseImage();
		println("medicalLicenceImageId": medicalLicenceImageId.doc.id)

		//		def deaLicenceImageId = postProviderDEALicenseImage();
		//		println("deaLicenceImageId": deaLicenceImageId.doc.id)

		postProviderSessionRefreshToken();
		def signatureImageId = postProviderSignatureImage();
		println("signatureImageId": signatureImageId.doc.id)

		//		def signedEmpowerDocId = postSignProviderEmpowerDoc()
		//		println("signedEmpowerDocId": signedEmpowerDocId.doc.id)

		postProviderData(data, govId.doc.id, underGraduateImageId.doc.id, graduateImageId.doc.id, medicalLicenceImageId.doc.id, signatureImageId.doc.id, null)

		def signDocId = postSignDocument();
		println("signDoc": signDocId.doc.id)

		def payment = postPaymentSheet(signDocId.doc.id)
		println("signDoc": payment.paymentIntent)

		postConfirmPayment(payment.paymentIntent)
		println("data": signDocId)
		return signDocId
	}

	@Keyword
	def postProviderProfilePic() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Provider/ProfileBiography/POST ProviderProfilePic'))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def getProviderProfileVideoUploadURL() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Provider/ProfileBiography/GET ProfileVideoUploadURL'))
		WS.verifyResponseStatusCode(tokenResponse, 200)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def putProviderProfileVideoToAWS(url) {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Provider/ProfileBiography/PUT ProfileVideo', ['profileVideoUrl': url]))
		WS.verifyResponseStatusCode(tokenResponse, 200)
	}

	@Keyword
	def postRegisterProviderProfileVideo(url) {

		def parts = url.split(/[\/?]/)
		def videoId = parts[-2] // Get the second last element
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Provider/ProfileBiography/POST RegisterProfileVideo', ['videoId': videoId]))
		WS.verifyResponseStatusCode(tokenResponse, 200)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def patchProviderProfileBiograpy(ownerId, profilePicId, videoId) {

		println("videoId": videoId)
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Provider/ProfileBiography/PATCH ProfileBiography', ['ownerId': ownerId, 'profilePicId': profilePicId, 'videoId': videoId]))
		WS.verifyResponseStatusCode(tokenResponse, 200)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def getProviderAddress(ownerId) {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Provider/DeliveryMethods/GET OwnerAddress', ['ownerId': ownerId]))
		WS.verifyResponseStatusCode(tokenResponse, 200)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def getDeliveryMethods(ownerId) {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Provider/DeliveryMethods/GET DeliveryMethods'))
		WS.verifyResponseStatusCode(tokenResponse, 200)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def patchProviderDeliveryMethods(ownerId) {
		def addresses = getProviderAddress(ownerId)
		def addressId = addresses.docs[0].id;
		def deliveryMethods = getDeliveryMethods(ownerId)

		def houseCallId = deliveryMethods.docs.find { it.internalIdentifier == 'house-call' }?.id
		def facilityId = deliveryMethods.docs.find { it.internalIdentifier == 'facility' }?.id
		def vanId = deliveryMethods.docs.find { it.internalIdentifier == 'van' }?.id
		def telemedicineId = deliveryMethods.docs.find { it.internalIdentifier == 'telemedicine' }?.id

		println "houseCallId ID: $houseCallId"
		println "facilityId ID: $facilityId"
		println "vanId ID: $vanId"
		println "Telemedicine ID: $telemedicineId"

		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Provider/DeliveryMethods/PATCH DeliveryMethods', ['ownerId': ownerId, 'addressId': addressId, 'houseCallId': houseCallId, 'facilityId': facilityId, 'vanId': vanId, 'telemedicineId': telemedicineId]))
		WS.verifyResponseStatusCode(tokenResponse, 200)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def getProviderDetails(email, password) {
		postProviderSignIn(email, password);
		def res = getProviderDetails()
		return [
			'firstName': res.user.firstName,
			'lastName': res.user.lastName,
			'fullName': res.user.fullName,
			'firstAndLastName': res.user.firstName + " " + res.user.lastName,
			'res': res
		]
	}

	@Keyword
	def loadProviderInbox(providerId, pageNum = 0) {
		def response = WS.sendRequest(findTestObject('Object Repository/API/Provider/Inbox/loadInbox', ['providerId': providerId, 'pageIndex': pageNum]))
		WS.verifyResponseStatusCode(response, 200)

		String responseBody = response.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "inboxResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def sendMessage(providerId, memberId, encounterId, textMessage) {
		def temporaryId = UUID.randomUUID().toString()
		println "-----temporaryId: " + temporaryId
		def response = WS.sendRequest(findTestObject('Object Repository/API/Provider/Inbox/sendMessage', ['providerId': providerId, 'memberId': memberId, 'encounterId': encounterId, 'textMessage': textMessage, 'temporaryId': temporaryId]))
		WS.verifyResponseStatusCode(response, 201)

		String responseBody = response.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def signOut() {
		def response = WS.sendRequest(findTestObject('Object Repository/API/ProviderSignUp/SignOut'))
		WS.verifyResponseStatusCode(response, 200)
	}

	@Keyword
	def getEncounterIdOfConversation(String providerId, String memberId) {

		int pageNum=0
		String actualMemId
		int conversationsCount
		def encounterId
		boolean encounterIdFound = false
		boolean nextPage = true

		while(!encounterIdFound && pageNum<20 && nextPage) {
			def responseBody = loadProviderInbox(providerId, pageNum)
			conversationsCount = responseBody.docs.size()
			nextPage = responseBody.hasNextPage

			for(int j=0; j<conversationsCount; j++) {

				def relation = responseBody.docs[j].participants[0].relationTo
				if(relation == "members") {
					actualMemId = responseBody.docs[j].participants[0].participantId
				}
				else {
					actualMemId = responseBody.docs[j].participants[1].participantId
				}
				println 'actualMemId = ' + actualMemId
				if(actualMemId == memberId) {
					encounterId = responseBody.docs[j].encounter.id
					encounterIdFound = true
					break
				}
			}
			pageNum++
		}
		if(!encounterIdFound) {
			KeywordUtil.markFailedAndStop("Conversation not present in the inbox-Encounter Id is not found")
		}
		println '----- encounterId = ' + encounterId
		return encounterId
	}
	
	@Keyword
	def getProviderConciergeId(revprivatePracticeProviderEmail, providerPassword = GlobalVariable.fullyCompletedUserPass) {

		postProviderSignIn(revprivatePracticeProviderEmail, providerPassword)

		def providerDetails = WS.sendRequest(findTestObject('Object Repository/API/Provider/getDetails'))
		WS.verifyResponseStatusCode(providerDetails, 200)
		String providerDetailsResponse = providerDetails.getResponseBodyContent()
		// println(responseBody:providerDetailsResponse)
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(providerDetailsResponse)

		def conciergeId = jsonResponseBody.provider.conciergePractice.id
		println '----- ConciergeId = ' + conciergeId
		signOut()

		return conciergeId
	}

	@Keyword
	def acceptRevprivateRequest(revprivatePracticeProviderEmail, providerPassword = GlobalVariable.fullyCompletedUserPass, requestId) {

		postProviderSignIn(revprivatePracticeProviderEmail, providerPassword)

		String todayDate = new Date().format("yyyy-MM-dd")
		// println("----- Today's date: " + formattedDate)

		def acceptDetails = WS.sendRequest(findTestObject('Object Repository/API/Provider/acceptRevprivateRequest',['request_id': requestId, 'revprivateStartDate': todayDate]))
		WS.verifyResponseStatusCode(acceptDetails, 200)
		String providerAcceptResponse = acceptDetails.getResponseBodyContent()
		// println(responseBody:providerDetailsResponse)
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(providerAcceptResponse)

		def successMessage =  jsonResponseBody.message
		WS.verifyEqual(successMessage, "Updated successfully.")
		signOut()
	}
}
