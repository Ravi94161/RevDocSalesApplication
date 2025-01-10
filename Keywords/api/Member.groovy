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
import com.kms.katalon.core.webservice.verification.WSResponseManager
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import groovy.json.JsonSlurper
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable
import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone

public class Member {

	Provider provider = new Provider();

	@Keyword
	def getMemberLabs() {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/GET Member Labs'))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def postAtHomeLabsImage() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Admin/AtHomeLabs/POST AtHomeLab Image'))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postMemberLab(labName) {
		def image = postAtHomeLabsImage()
		def mediaId = image.doc.id
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/POST Member Labs',['labName':labName, 'mediaId': mediaId]))
		WS.verifyResponseStatusCode(responseProviderID, 201)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		//println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def patchMemberLab(id,labName) {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Member AtHomeLabs/PATCH Member Labs',['id':id,'labName':labName]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		//println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def patchMemberLabTermDate(id, termDate = "2024-07-11T04:54:50.257Z") {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/Member AtHomeLabs/PATCH Member Labs termDate',['id': id, 'termDate': termDate]))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)

		return jsonResponseBody
	}

	@Keyword
	def getMemberCategories() {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/GET Member Categories'))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def getMemberProcedures() {
		def responseProcedures = WS.sendRequest(findTestObject('Object Repository/API/GET Member Procedures'))
		WS.verifyResponseStatusCode(responseProcedures, 200)

		String responseBody = responseProcedures.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		// println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def postMemberSignUp(phoneNumber, user_input_code = GlobalVariable.MemberOTP) {
		phoneNumber = "+1${phoneNumber}"
		def signUpCodeRes = postMemberSignUpCode(phoneNumber)
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/MemberSignUp/MemberSignUp',['phone': phoneNumber, 'signUpCodeRes':signUpCodeRes, 'user_input_code': user_input_code]))
		WS.verifyResponseStatusCode(tokenResponse, 200)
		GlobalVariable.token = tokenResponse.getHeaderField("St-Access-Token");

		String responseBody = tokenResponse.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postMemberSignUpCode(phoneNumber) {
		phoneNumber = "+1${phoneNumber}"
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/MemberSignUp/POST signUpCode',['phone': phoneNumber]))
		WS.verifyResponseStatusCode(tokenResponse, 200)
		GlobalVariable.token = tokenResponse.getHeaderField("St-Access-Token");

		String responseBody = tokenResponse.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postUpdateMemberSignUpMetaData(id, email, phoneNumber) {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/MemberSignUp/UpdateSignUpMetadata',['id': id, 'email': email, 'phoneNumber': phoneNumber]))
		WS.verifyResponseStatusCode(tokenResponse, 200)
		String responseBody = tokenResponse.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postMemberDataSignUp() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/MemberSignUp/MemberDepthData'))
		WS.verifyResponseStatusCode(tokenResponse, 201)
		String responseBody = tokenResponse.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def patchFindSomeLocalProviders(id, email, homeZipCode ='48867', homeState = "MI", textMessageMarketingOptInStatus = "OptedOut", marketingConsent = false) {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/MemberSignUp/PATCH FindSomeLocalProviders', ['id': id, 'email': email, 'homeZipCode': homeZipCode, 'homeState': homeState, 'textMessageMarketingOptInStatus': textMessageMarketingOptInStatus, "marketingConsent": marketingConsent]))
		WS.verifyResponseStatusCode(tokenResponse, 200)
		String responseBody = tokenResponse.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def patchFillInitialMemberSignUpDetails(id, email, firstName = "Member", lastName = "user", middleName = "R") {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/MemberSignUp/MemberFillIntitalDetails', ['id': id, 'firstName': firstName, 'lastName': lastName, 'middleName': middleName, 'email': email]))
		WS.verifyResponseStatusCode(tokenResponse, 200)
		String responseBody = tokenResponse.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postDeliveryAddress() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Member/Cart/POST DeliveryAddresses'))
		WS.verifyResponseStatusCode(tokenResponse, 201)
		String responseBody = tokenResponse.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}


	@Keyword
	def patchSkipInviteCodeSignUp(id) {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/MemberSignUp/SkipInviteCodeWhileSignup', ['id': id]))
		WS.verifyResponseStatusCode(tokenResponse, 200)

		String responseBody = tokenResponse.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postSignUpAccetTermsAndConditions() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/MemberSignUp/AcceptTermsAndConditions'))
		WS.verifyResponseStatusCode(tokenResponse, 200)

		String responseBody = tokenResponse.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postMemberSignIn(phoneNumber, user_input_code = GlobalVariable.MemberOTP) {
		//		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/MemberSignUp/MemberSignin', ['email': email, 'password': password]))
		//		WS.verifyResponseStatusCode(tokenResponse, 200)
		//		GlobalVariable.token = tokenResponse.getHeaderField("St-Access-Token");
		//		GlobalVariable.refreshToken = tokenResponse.getHeaderField("St-Refresh-Token");
		//		String responseBody = tokenResponse.getResponseBodyContent()
		//		JsonSlurper parser = new JsonSlurper()
		//		def jsonResponseBody = parser.parseText(responseBody)
		//		println "jsonResponseBody: " + jsonResponseBody
		//		return jsonResponseBody
		return postMemberSignUp(phoneNumber, user_input_code);
	}

	@Keyword
	def getMemberInsurance() {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/GET Member Insurance'))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def getMemberData() {
		def responseProviderID = WS.sendRequest(findTestObject('Object Repository/API/MemberSignUp/GET MemberData'))
		WS.verifyResponseStatusCode(responseProviderID, 200)

		String responseBody = responseProviderID.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody

		return jsonResponseBody
	}

	@Keyword
	def getMemberDetails(phoneNumber, otp = GlobalVariable.MemberOTP) {
		postMemberSignIn(phoneNumber, otp);
		def res = getMemberData()
		return [
			'firstName': res.user.demographics.firstName,
			'lastName': res.user.demographics.lastName,
			'fullName': res.user.demographics.fullName,
			'firstAndLastName': res.user.demographics.firstName + " " + res.user.demographics.lastName,
			'res': res
		]
	}

	@Keyword
	def loadAlerts(memberId, pageNum = 0) {
		def response = WS.sendRequest(findTestObject('Object Repository/API/Provider/Inbox/loadInbox', ['providerId': memberId, 'pageIndex': pageNum]))
		WS.verifyResponseStatusCode(response, 200)

		String responseBody = response.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "alertsResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def sendMessage(memberId, providerId, encounterId, textMessage) {
		def temporaryId = UUID.randomUUID().toString()
		println "-----temporaryId: " + temporaryId
		def response = WS.sendRequest(findTestObject('Object Repository/API/MemberAlerts/sendMessage', ['providerId': providerId, 'memberId': memberId, 'encounterId': encounterId, 'textMessage': textMessage, 'temporaryId': temporaryId]))
		WS.verifyResponseStatusCode(response, 201)

		String responseBody = response.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def signOut() {
		def response = WS.sendRequest(findTestObject('Object Repository/API/MemberSignUp/SignOut'))
		WS.verifyResponseStatusCode(response, 200)
	}

	@Keyword
	def getEncounterIdOfConversation(String memberId, String providerId) {

		int pageNum=0
		String actualProvId
		int conversationsCount
		def encounterId
		boolean encounterIdFound = false
		boolean nextPage = true

		while(!encounterIdFound && pageNum<20 && nextPage) {
			def responseBody = loadAlerts(memberId, pageNum)
			conversationsCount = responseBody.docs.size()
			nextPage = responseBody.hasNextPage

			for(int j=0; j<conversationsCount; j++) {

				def relation = responseBody.docs[j].participants[0].relationTo
				if(relation == "providers") {
					actualProvId = responseBody.docs[j].participants[0].participantId
				}
				else {
					actualProvId = responseBody.docs[j].participants[1].participantId
				}
				println '----- actualProvId = ' + actualProvId
				if(actualProvId == providerId) {
					encounterId = responseBody.docs[j].encounter.id
					encounterIdFound = true
					break
				}
			}
			pageNum++
		}
		if(!encounterIdFound) {
			KeywordUtil.markFailedAndStop("Conversation not present in the alerts-Encounter Id is not found")
		}
		println '----- encounterId = ' + encounterId
		return encounterId
	}

	@Keyword
	def postGovernmentIdInDemographics() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Member/Registration/POSTMemberGovernmentId'))
		WS.verifyResponseStatusCode(tokenResponse, 201)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def postGovernmentIdImagesInDemographics(userId, imageId) {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Member/Registration/POSTMemberGovernemnetIdImages', ['id': userId, 'imageId': imageId]))
		WS.verifyResponseStatusCode(tokenResponse, 200)

		//		String responseBody = tokenResponse.getResponseBodyContent()
		//
		//		JsonSlurper parser = new JsonSlurper()
		//		def jsonResponseBody = parser.parseText(responseBody)
		//		println "jsonResponseBody: " + jsonResponseBody
		//		return jsonResponseBody
	}

	@Keyword
	def patchDemographics(userId, firstName, lastName, middleName = "J") {
		def res = postGovernmentIdInDemographics()
		postGovernmentIdImagesInDemographics(userId, res.doc.id)
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/Member/Registration/PATCH Demographics', ['id': userId, 'firstName': firstName, 'lastName': firstName, 'middleName': middleName]))
		WS.verifyResponseStatusCode(tokenResponse, 200)

		String responseBody = tokenResponse.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		return jsonResponseBody
	}

	@Keyword
	def removeItemsInCart(memberId) {

		def getCartResponse = WS.sendRequest(findTestObject('Object Repository/API/Member/Cart/getCartId',['user_id': memberId]))
		WS.verifyResponseStatusCode(getCartResponse, 200)

		String responseBody = getCartResponse.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		def cartId = jsonResponseBody.id
		println "----- cart id: " + cartId

		def removeItemsInCartResponse = WS.sendRequest(findTestObject('Object Repository/API/Member/Cart/removeItemsInCart',['cart_id': cartId]))
		WS.verifyResponseStatusCode(removeItemsInCartResponse, 200)
		String deleteResponseBody = removeItemsInCartResponse.getResponseBodyContent()
		def jsonResponseBodyAfterDeletion = parser.parseText(deleteResponseBody)
		def itemsCount = jsonResponseBodyAfterDeletion.cartItems.size()

		Mobile.verifyEqual(itemsCount, "0")
	}

	@Keyword
	def removeItemsInSaveForLater() {
		def getSaveForLaterResponse = WS.sendRequest(findTestObject('Object Repository/API/Member/Cart/getSaveForLaterId'))
		WS.verifyResponseStatusCode(getSaveForLaterResponse, 200)

		String responseBody = getSaveForLaterResponse.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: " + jsonResponseBody
		def saveForLaterId = jsonResponseBody.id
		println "----- save for later id: " + saveForLaterId

		def removeItemsInSaveForLaterResponse = WS.sendRequest(findTestObject('Object Repository/API/Member/Cart/removeItemsInSaveForLater',['save_for_later_id': saveForLaterId]))
		WS.verifyResponseStatusCode(removeItemsInSaveForLaterResponse, 200)
		String deleteResponseBody = removeItemsInSaveForLaterResponse.getResponseBodyContent()
		def jsonResponseBodyAfterDeletion = parser.parseText(deleteResponseBody)
		def itemsCount = jsonResponseBodyAfterDeletion.cartItems.size()

		Mobile.verifyEqual(itemsCount, "0", FailureHandling.OPTIONAL)
	}

	@Keyword
	def removeItemsInCartAndSaveForLater(memberPhoneNum) {
		def retryCount = 2
		def success = false

		def signInResponseMember = postMemberSignIn(memberPhoneNum)
		def memberId = signInResponseMember.user_id

		for (int i = 0; i < retryCount; i++) {
			try {
				removeItemsInCart(memberId)
				removeItemsInSaveForLater()
				signOut()

				// If successful, set success to true and break the loop
				success = true
				break
			} catch (Exception e) {
				println "Attempt ${i + 1} failed: ${e.message}"

				// If it's the last attempt, rethrow the exception
				if (i == retryCount - 1) {
					throw e
				}
			}
		}

	}

	@Keyword
	def getCart(memberPhoneNum) {

		def signInResponseMember = postMemberSignIn(memberPhoneNum)
		def memberId = signInResponseMember.user_id

		def cartResponse = WS.sendRequest(findTestObject('Object Repository/API/Member/Cart/getCartId',['user_id': memberId]))
		WS.verifyResponseStatusCode(cartResponse, 200)

		String cartResponseBody = cartResponse.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(cartResponseBody)
		println "jsonResponseBody: " + jsonResponseBody
		// signOut()
		def cartDetails =  jsonResponseBody
		return [
			'totalCartPriceBeforeDiscount': cartDetails.finalPrice, // for all types of users
			'totalResponse': cartDetails,
			'cartId': cartDetails.id
		]
	}

	@Keyword
	def getProcedureIdByProcedureName(procedureName) {
		new Payload().getToken();
		def memberProceduresList = getMemberProcedures();
		def procedureId = null;
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
	def sendReprivateRequest(memberPhoneNum, providerConciergeId, isPaymentQuarterly = true) {
		def signInResponseMember = postMemberSignIn(memberPhoneNum)
		def membershipId

		def memberDetails = getMemberData()

		if(memberDetails.user?.privatePracticeMember || memberDetails.user?.plusMember) {
			KeywordUtil.markFailedAndStop("Member Already a revprivate/revplus user please check.")
		}

		def requestDetails = WS.sendRequest(findTestObject('Object Repository/API/Member/Revprivate/sendRevPrivateRequest',['concierge_id': providerConciergeId]))
		WS.verifyResponseStatusCode(requestDetails, 201)

		String requestDetailsBody = requestDetails.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def responseBody = parser.parseText(requestDetailsBody)
		// println "jsonResponseBody: " + jsonResponseBody

		def requestId = responseBody.doc.id

		if(isPaymentQuarterly) {
			// quaterly payment
			membershipId = responseBody.doc.privatePractice.membershipPrices[0].membershipPrice.id
		}
		else {
			// yearly payment
			membershipId = responseBody.doc.privatePractice.membershipPrices[1].membershipPrice.id
		}
		println "----- requestId: " + requestId
		println "----- membershipId: " + membershipId

		signOut()
		return [
			'requestId': requestId,
			'membershipId': membershipId
		]
	}

	@Keyword
	def addRevprivateToCart(memberPhoneNum, membershipId, requestId) {

		def cartDetails = getCart(memberPhoneNum)
		def cartId = cartDetails.cartId

		def cartResponse = WS.sendRequest(findTestObject('Object Repository/API/Member/Cart/updateCartWithRevprivateMembership',['cart_id': cartId,'membership_id': membershipId, 'request_id': requestId]))
		WS.verifyResponseStatusCode(cartResponse, 200)

		//String cartResponseBody = cartResponse.getResponseBodyContent()
		//JsonSlurper parser = new JsonSlurper()
		//def jsonResponseBody = parser.parseText(cartResponseBody)
		//println "jsonResponseBody: " + jsonResponseBody
		return cartId
	}

	@Keyword
	def makePayment(cartId) {
		def cartResponse = WS.sendRequest(findTestObject('Object Repository/API/Member/Payment/paymentSheet',['cart_id': cartId]))
		WS.verifyResponseStatusCode(cartResponse, 200)

		String cartResponseBody = cartResponse.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonCartResponseBody = parser.parseText(cartResponseBody)
		// println "jsonCartResponseBody: " + jsonCartResponseBody

		if(jsonCartResponseBody?.paymentIntent != null) {
			def paymentIntent = jsonCartResponseBody.paymentIntent
			println "-----paymentIntent-----:" + paymentIntent
			def paymentId = paymentIntent.split("_")[1]
			println "----- paymentId: " + paymentId
			def stripeResponse = WS.sendRequest(findTestObject('Object Repository/API/Member/Payment/stripePayment',['payment_intent': paymentIntent,'payment_id': paymentId]))
			WS.verifyResponseStatusCode(stripeResponse, 200)

			String stripeResponseBody = stripeResponse.getResponseBodyContent()
			def jsonstripeResponseBody = parser.parseText(stripeResponseBody)
		} else {
			def setupIntent = jsonCartResponseBody.setupIntent
			println "-----setupIntent-----:" + setupIntent
			def paymentId = setupIntent.split("_")[1]
			println "----- paymentId: " + paymentId
			def stripeResponse = WS.sendRequest(findTestObject('Object Repository/API/Member/Payment/stripePaymentWithZeroPrice',['setupIntent': setupIntent,'payment_id': paymentId]))
			WS.verifyResponseStatusCode(stripeResponse, 200)

			String stripeResponseBody = stripeResponse.getResponseBodyContent()
			def jsonstripeResponseBody = parser.parseText(stripeResponseBody)

			cartResponse = WS.sendRequest(findTestObject('Object Repository/API/Member/Payment/paymentSheet',['cart_id': cartId]))
			WS.verifyResponseStatusCode(cartResponse, 200)

			cartResponseBody = cartResponse.getResponseBodyContent()

			jsonCartResponseBody = parser.parseText(cartResponseBody)

			//			 println "jsonCartResponseBody: " + jsonCartResponseBody

		}
	}

	@Keyword
	def upgradeToRevPrivate(existedMemberPhoneNum, isPaymentQuarterly = true, revprivatePracticeProviderEmail = GlobalVariable.providerForRevprivateApi, providerPassword = GlobalVariable.fullyCompletedUserPass) {

		// get provider revprivate id
		def conciergeId = provider.getProviderConciergeId(revprivatePracticeProviderEmail)

		// member send revprivate request
		def requestDetails = sendReprivateRequest(existedMemberPhoneNum, conciergeId, isPaymentQuarterly)
		def requestId = requestDetails.requestId
		def membershipId = requestDetails.membershipId

		// provider accept revprivate request
		provider.acceptRevprivateRequest(revprivatePracticeProviderEmail, providerPassword = GlobalVariable.fullyCompletedUserPass, requestId)

		// member add revprivate to cart
		def cartId = addRevprivateToCart(existedMemberPhoneNum, membershipId, requestId)
		// make payment
		makePayment(cartId)
		signOut()
		WS.delay(5)
		// verify revprivate purchase success
		verifyRevprivatePurchaseSuccess(existedMemberPhoneNum, true)
	}

	@Keyword
	def verifyRevprivatePurchaseSuccess(memberPhoneNum, requireSignIn = false) {

		def retryCount = 3
		def success = false
		def memberDetails
		JsonSlurper parser = new JsonSlurper()

		// login with member
		if(requireSignIn) {
			def signInResponseMember = postMemberSignIn(memberPhoneNum)
		}

		for (int i = 0; i < retryCount; i++) {
			try {
				memberDetails = getMemberData()
				memberDetails.user.privatePracticeMember

				if(memberDetails.user?.privatePracticeMember) {
					success = true
					break
				}

			} catch (Exception e) {
				println "---- Attempt ${i + 1} failed: ${e.message}"
				println "memberDetails: " + memberDetails
				// If it's the last attempt, rethrow the exception
				if (i == retryCount - 1) {
					throw e
				}
			}
		}
		if(requireSignIn) {
			signOut()
		}
	}

	@Keyword
	def getRevplusMemberhipId(isPaymentMonthly = true) {

		// get membership product
		def membershipProducts = WS.sendRequest(findTestObject('Object Repository/API/Member/Revplus/getMembershipProducts'))
		WS.verifyResponseStatusCode(membershipProducts, 200)
		WS.containsString(membershipProducts, 'plus', false)

		String membershipProductsResponseBody = membershipProducts.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def membershipProductDetails = parser.parseText(membershipProductsResponseBody)
		// println "membershipProductDetails: " + membershipProductDetails

		def membershipProductId = 	membershipProductDetails.docs[0].id

		// Create a date format for UTC in the desired format
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"))

		// Get the current date and time formatted as a UTC string
		String currentDateTimeISO = dateFormat.format(new Date())
		println("----- currentDateTimeISO: " + currentDateTimeISO)

		// get membership id
		def membershipPrices = WS.sendRequest(findTestObject('Object Repository/API/Member/Revplus/getMembershipPrices',['membership_product_id': membershipProductId, 'current_date_time_ISO': currentDateTimeISO]))
		WS.verifyResponseStatusCode(membershipPrices, 200)

		String membershipPricesResponseBody = membershipPrices.getResponseBodyContent()
		def membershipPricesDetails = parser.parseText(membershipPricesResponseBody)
		// println "membershipPricesDetails: " + membershipPricesDetails

		def membershipId
		if(isPaymentMonthly) {
			// monthly payment
			membershipId = membershipPricesDetails.data.MembershipPrices.docs[1].id
		}
		else {
			// yearly payment
			membershipId = membershipPricesDetails.data.MembershipPrices.docs[0].id
		}
		return membershipId
	}

	@Keyword
	def addRevplusToCart(memberPhoneNum, membershipId) {

		def cartDetails = getCart(memberPhoneNum)
		def cartId = cartDetails.cartId

		def cartResponse = WS.sendRequest(findTestObject('Object Repository/API/Member/Cart/updateCartWithRevplusMembership',['cart_id': cartId,'membership_id': membershipId]))
		WS.verifyResponseStatusCode(cartResponse, 200)

		//String cartResponseBody = cartResponse.getResponseBodyContent()
		//JsonSlurper parser = new JsonSlurper()
		//def jsonResponseBody = parser.parseText(cartResponseBody)
		//println "jsonResponseBody: " + jsonResponseBody
		return cartId
	}

	@Keyword
	def selectPlusProvider(memberId, providerId) {

		def memberData = WS.sendRequest(findTestObject('Object Repository/API/Member/getMemberDetailsById',['member_id': memberId]))
		WS.verifyResponseStatusCode(memberData, 200)

		String memberDataResponseBody = memberData.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def memberDetails = parser.parseText(memberDataResponseBody)
		// println "memberDetails: " + memberDetails

		def plusMemberId = memberDetails.plusMember.id

		def selectProviderData = WS.sendRequest(findTestObject('Object Repository/API/Member/Revplus/selectProvider',['plus_member_Id': plusMemberId, 'provider_id': providerId]))
		WS.verifyResponseStatusCode(selectProviderData, 200)
		WS.containsString(selectProviderData, 'Updated successfully', false)

		String selectProviderDataResponseBody = selectProviderData.getResponseBodyContent()
		def selecteProviderDetails = parser.parseText(selectProviderDataResponseBody)
		// println "selecteProviderDetails: " + selecteProviderDetails
	}

	@Keyword
	def upgradeToRevPlus(existedMemberPhoneNum, isPaymentMonthly = true, providerEmail = GlobalVariable.providerForRevplusApi, providerPassword = GlobalVariable.fullyCompletedUserPass) {

		// get provider id
		def providerSignInResponse = provider.postProviderSignIn(providerEmail, providerPassword)
		def providerId = providerSignInResponse.user.id
		println "----- providerId: " + providerId
		provider.signOut()

		// login with member
		def signInResponseMember = postMemberSignIn(existedMemberPhoneNum)
		def memberId = signInResponseMember.user_id

		def memberDetails = getMemberData()
		if(memberDetails.user?.privatePracticeMember || memberDetails.user?.plusMember) {
			KeywordUtil.markFailedAndStop("Member Already a revprivate/revplus user please check.")
		}

		def membershipId = getRevplusMemberhipId(isPaymentMonthly)

		// member add revplus to cart
		def cartId = addRevplusToCart(existedMemberPhoneNum, membershipId)
		// make payment
		makePayment(cartId)
		WS.delay(5)
		// verify revplus success
		verifyRevplusPurchaseSuccess(existedMemberPhoneNum, false, memberId)
		// select revplus provider
		selectPlusProvider(memberId, providerId)
		signOut()
		verifyRevplusSuccess(existedMemberPhoneNum, providerId, true)
	}

	@Keyword
	def verifyRevplusPurchaseSuccess(memberPhoneNum, requireSignIn = false, memberId = '1') {

		def retryCount = 3
		def success = false
		def memberDetails
		JsonSlurper parser = new JsonSlurper()

		// login with member
		if(requireSignIn) {
			def signInResponseMember = postMemberSignIn(memberPhoneNum)
			memberId = signInResponseMember.user_id
		}

		for (int i = 0; i < retryCount; i++) {
			try {
				def memberData = WS.sendRequest(findTestObject('Object Repository/API/Member/getMemberDetailsById',['member_id': memberId]))
				WS.verifyResponseStatusCode(memberData, 200)

				String memberDataResponseBody = memberData.getResponseBodyContent()
				memberDetails = parser.parseText(memberDataResponseBody)
				//println "memberDetails: " + memberDetails

				memberDetails.plusMember.id

				if(memberDetails?.plusMember) {
					success = true
					break
				}

			} catch (Exception e) {
				println "---- Attempt ${i + 1} failed: ${e.message}"
				println "memberDetails: " + memberDetails
				Mobile.delay(7)
				// If it's the last attempt, rethrow the exception
				if (i == retryCount - 1) {
					throw e
				}
			}
		}

		if(requireSignIn) {
			signOut()
		}
		return memberDetails.plusMember.id
	}

	@Keyword
	def verifyRevplusSuccess(memberPhoneNum, providerId, requireSignIn = false, memberId = '1') {

		WS.delay(3)
		// login with member
		if(requireSignIn) {
			def signInResponseMember = postMemberSignIn(memberPhoneNum)
			memberId = signInResponseMember.user_id
		}

		def memberData = WS.sendRequest(findTestObject('Object Repository/API/Member/getMemberDetailsById',['member_id': memberId]))
		WS.verifyResponseStatusCode(memberData, 200)

		String memberDataResponseBody = memberData.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def memberDetails = parser.parseText(memberDataResponseBody)
		// println "memberDetails: " + memberDetails

		if(memberDetails.plusMember.plusProvider != providerId) {
			KeywordUtil.markFailedAndStop("Revplus provider is not assigned please check.")
		}

		if(requireSignIn) {
			signOut()
		}

	}


	// ----- END ----
}
