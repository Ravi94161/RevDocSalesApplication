package member

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat
import java.time.Duration

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject

import api.Admin
import internal.GlobalVariable
import io.appium.java_client.TouchAction
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.ElementOption
import member360.Demographics
import mobile.Generic
import mobile.MobileActions

public class RevTogether {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	MobileActions mobile = new MobileActions();
	Generic gen = new Generic()
	Demographics dem = new Demographics()
	Admin admin = new Admin();

	@Keyword
	def tapOnBookRevTogetherEventBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/RevTogether/bookRevTogetherEventBtn_android'), defaultTime);
	}

	@Keyword
	def verifyBookRevTogetherEventBtnExist(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevTogether/bookRevTogetherEventBtn_android'), defaultTime, onFailure);
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/RevTogether/bookRevTogetherEventBtn_android'), defaultTime, onFailure);
		}
	}

	@Keyword
	def getNumberOfPeopleCount() {
		return Mobile.getText(findTestObject('Object Repository/Member/RevTogether/getNumberOfPeopleCount_android'), defaultTime);
	}

	@Keyword
	def setNumberOfPeopleCount(text) {
		Mobile.clearText(findTestObject('Object Repository/Member/RevTogether/getNumberOfPeopleCount_android'), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Member/RevTogether/getNumberOfPeopleCount_android'), text, defaultTime);
	}

	@Keyword
	def moveSliderAndVerifyCount(targetSliderValue, startPeopleCount, endPeopleCount) {
		// Get slider and people count objects
		TestObject slider = findTestObject('Object Repository/Member/RevTogether/sliderSeekBar_android')
		TestObject peopleCount = findTestObject('Object Repository/Member/RevTogether/getNumberOfPeopleCount_android')

		// Define the slider range (assuming it starts at 0 and ends at 6)
		int startSliderValue = 0
		int endSliderValue = 6

		// Calculate slider movement positions
		int sliderWidth = Mobile.getElementWidth(slider, 10)  // Get the total width of the slider
		int startX = (int) (sliderWidth * 0.1)  // Start at 10% of the width
		int endX = (int) (sliderWidth * (targetSliderValue / (double) endSliderValue))  // Calculate the target position based on slider value
		int yAxis = Mobile.getElementTopPosition(slider, 10) + (Mobile.getElementHeight(slider, 10) / 2)  // Center vertically

		// Move the slider using TouchAction
		TouchAction action = new TouchAction(MobileDriverFactory.getDriver())
		action.press(ElementOption.point(startX, yAxis))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))  // Wait for 1 second before sliding
				.moveTo(ElementOption.point(endX, yAxis))
				.release()
				.perform()

		// Get updated slider value and people count
		String updatedSliderValue = Mobile.getAttribute(slider, 'text', 10)
		String updatedPeopleCount = Mobile.getText(peopleCount, 10)

		// Calculate expected people count dynamically based on the slider value
		int currentSliderValue = Math.round(Float.parseFloat(updatedSliderValue))  // Convert updated slider value to an integer
		int expectedPeopleCount = startPeopleCount + ((currentSliderValue - startSliderValue) * (endPeopleCount - startPeopleCount) / (endSliderValue - startSliderValue))

		// Verify if the people count matches the expected count
		assert Integer.parseInt(updatedPeopleCount) == expectedPeopleCount :
		"People count is incorrect after moving the slider. Expected: $expectedPeopleCount, but got: $updatedPeopleCount."
	}

	@Keyword
	def verifyHowPaymentsWorkBtnExist(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevTogether/howPaymentsWorksBtn_android'), defaultTime, onFailure);
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/RevTogether/howPaymentsWorksBtn_android'), defaultTime, onFailure);
		}
	}

	@Keyword
	def tapOnHowPaymentsWorkBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/RevTogether/howPaymentsWorksBtn_android'), defaultTime);
	}

	@Keyword
	def verifyHowPaymentsWorkScreenDetails() {
		mobile.verifyElementPresentByText("Payment Details")
		mobile.verifyElementPresentByText("Pay for Myself")
		mobile.verifyElementPresentByText("In this option you will pay the amount for your own care. You will receive a refund for the free host amount if the terms are met.")
		mobile.verifyElementPresentByText("Pay for Entire Party")
		mobile.verifyElementPresentByText("In this option you will pay the amount for all invited members including yourself. You will receive a refund for the free host amount if the terms are met.")
	}

	@Keyword
	def verifyThankYouScreenDetails(providerName, deliveryMethod, address) {
		mobile.verifyElementPresentByText("Thank you for booking an appointment")
		mobile.verifyElementPresentByText("Please allow a few minutes for your RevTogether appointment to appear under the Appointments tab.")
		mobile.verifyElementPresentByText("How to Manage Invites")
		mobile.verifyElementPresentByText("Continue to Invite Friends")
		mobile.verifyElementPresentByText("Payment collected on behalf of")
		mobile.verifyElementPresentByText("${providerName}")
		mobile.verifyElementPresentByText(deliveryMethod)
		mobile.verifyElementPresentByText("Appointment Address")
		mobile.verifyElementPresentByText(address)
	}

	@Keyword
	def verifyInviteScreenDetails(friendsCount, minPatientsForFreeHost, procedureName, providerfirstName, providerlastNameWithTitle, memberFirstName,
			datePart, timePart, apptAddress, pricePerAdditionalPatient, formattedDate) {
		mobile.verifyElementPresentByText("Invite up to ${friendsCount} friends to join your RevTogether event.")
		mobile.verifyElementPresentByText(" Remember, as long as ${minPatientsForFreeHost} invitees pay, this event is FREE for the host.")
		mobile.verifyElementPresentByText("Include a Message to Invitees *")
		verifyInviteMessageTextField();
		mobile.verifyElementPresentByText("Add Photos *")
		mobile.verifyElementPresentByText("Add any photos that you would like to include on your RevTogether page.")
		verifyAddBtn();
		verifyKeyValuePair("Include a Message to Invitees *", "Required");
		gen.swipeUp();
		verifyKeyValuePair("Procedure", procedureName);
		verifyKeyValuePair("Providers", providerfirstName);
		verifyKeyValuePair("Providers", providerlastNameWithTitle);
		verifyKeyValuePair("Invited by", memberFirstName);
		mobile.verifyElementPresentByText("Date & Time")
		verifyKeyValuePair("Date & Time", datePart);
		verifyKeyValuePair("Date & Time", timePart);
		verifyKeyValuePair("Event Address", apptAddress.split(",")[0]);
		verifyKeyValuePair("Total", "\$${pricePerAdditionalPatient} per person");
		verifyDatewithPencilGreyBtn(formattedDate);
		verifyPreviewBtn();
		verifySendInviteBtn();
	}

	@Keyword
	def verifyPayForMySelfOptionExist(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevTogether/payForMySelfOption_android'), defaultTime, onFailure)
		}else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/RevTogether/payForMySelfOption_android'), defaultTime, onFailure)
		}
	}

	@Keyword
	def verifyPayForTheEntirePartyOptionExist(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevTogether/payForTheEntireParty_android'), defaultTime, onFailure)
		}else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/RevTogether/payForTheEntireParty_android'), defaultTime, onFailure)
		}
	}

	@Keyword
	def tapOnPayForTheEntirePartyOption() {
		Mobile.tap(findTestObject('Object Repository/Member/RevTogether/payForTheEntireParty_android'), defaultTime);
	}

	@Keyword
	def verifyContinuetoInviteFriendsBtnExist(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevTogether/Continue to invite friends/continuetoInviteFriendsBtn_android'), defaultTime, onFailure)
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/RevTogether/Continue to invite friends/continuetoInviteFriendsBtn_android'), defaultTime, onFailure)
		}
	}

	@Keyword
	def tapOnContinuetoInviteFriendsBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/RevTogether/Continue to invite friends/continuetoInviteFriendsBtn_android'), defaultTime)
	}

	@Keyword
	def verifyCloseIcon(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/closeIcon_android'), defaultTime, onFailure)
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/closeIcon_android'), defaultTime, onFailure)
		}
	}

	@Keyword
	def verifyPreviewBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevTogether/Continue to invite friends/previewBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnPreviewBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/RevTogether/Continue to invite friends/previewBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifySendInviteBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevTogether/Continue to invite friends/sendInviteBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnSendInviteBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/RevTogether/Continue to invite friends/sendInviteBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyAddBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevTogether/Continue to invite friends/photosAddBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnAddBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/RevTogether/Continue to invite friends/photosAddBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyInviteMessageTextField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevTogether/Continue to invite friends/inviteMessageTextField_android'), defaultTime, onFailure)
	}

	@Keyword
	def setTextInInviteMessageTextField(text) {
		Mobile.clearText(findTestObject('Object Repository/Member/RevTogether/Continue to invite friends/inviteMessageTextField_android'), defaultTime, FailureHandling.OPTIONAL)
		Mobile.setText(findTestObject('Object Repository/Member/RevTogether/Continue to invite friends/inviteMessageTextField_android'), text, defaultTime)
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}

	@Keyword
	def setTextInThanksMessageTextField(text) {
		Mobile.clearText(findTestObject('Object Repository/Member/RevTogether/thanksMsgTxtBx_android'), defaultTime, FailureHandling.OPTIONAL)
		Mobile.setText(findTestObject('Object Repository/Member/RevTogether/thanksMsgTxtBx_android'), text, defaultTime)
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}

	@Keyword
	def verifyTextInInviteMessageTextField(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/RevTogether/Continue to invite friends/inviteMessageTextField_android'), text, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verifyKeyValuePair(key, value, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevTogether/Continue to invite friends/verifyKeyValuePair_android', ["key":key, "value":value]), defaultTime, onFailure)
	}

	@Keyword
	def verifyDatewithPencilGreyBtn(date, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevTogether/Continue to invite friends/datewithPencilGrey_android', ['date':date]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnPencilGreyBtnWithDate(date, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/RevTogether/Continue to invite friends/datewithPencilGrey_android', ['date':date]), defaultTime, onFailure)
	}

	@Keyword
	def verifyTrashGreyBtn(index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevTogether/trashGreyBtn_android',['index':index]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnTrashGreyBtn(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/RevTogether/trashGreyBtn_android',['index':index]), defaultTime);
	}

	@Keyword
	def verifyAddedImageExist(isExist = true, index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevTogether/addedImagewithTrash_android',['index':index]), defaultTime, onFailure);
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/RevTogether/addedImagewithTrash_android',['index':index]), defaultTime, onFailure);
		}
	}

	//------------------------------------------capture Image ---------------------------------------------

	@Keyword
	def tapOnAddImagePlusBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/RevTogether/Capture Image/addImagePlusBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnSaveImagesBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/RevTogether/Capture Image/saveImagesBtn_android'), defaultTime);
	}

	//------------------------------------------End - capture Image ---------------------------------------------

	//------------------------------------------ preview --------------------------------------------------------

	@Keyword
	def tapOnEditBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/RevTogether/Preview/editBtn_android'), defaultTime);
	}

	@Keyword
	def verifyCalendarIconWithDate(date, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevTogether/Preview/calendarIconWithDate_android', ["date":date]), defaultTime, onFailure)
	}

	@Keyword
	def verifyTimeIconWithTime(time, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevTogether/Preview/timeIconWithTime_android', ["time":time]), defaultTime, onFailure)
	}

	@Keyword
	def verifyLocationIconWithAddress(address, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevTogether/Preview/locationIconWithAddress_android', ["address":address]), defaultTime, onFailure)
	}
	//------------------------------------------ End - preview---------------------------------------------------

	@Keyword
	def selectAndAdjustDate(daysToAddOrSubtract = 0) {
		// Initialize the calendar with the current date
		Calendar calendar = Calendar.getInstance()

		// Adjust the day by increasing or decreasing it
		calendar.add(Calendar.DAY_OF_MONTH, daysToAddOrSubtract)

		// Format month as full name (e.g., "Oct")
		def newMonth = new SimpleDateFormat('MMM').format(calendar.getTime())

		// Get day (without leading zero)
		def newDay = calendar.get(Calendar.DAY_OF_MONTH)

		// Get year
		def newYear = calendar.get(Calendar.YEAR)

		// Return the values as a map
		return [newMonth: newMonth, newDay: newDay, newYear: newYear]
	}

	@Keyword
	def tapOnNoThanksBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/RevTogether/noThanksBtn_android'), defaultTime)
	}

	@Keyword
	def verifyPreviewScreenDetails(MessageText, memberFirstName, memberLastName, pricePerAdditionalPatient, formattedDate, resultArray, apptAddress, procedureName, providerfirstName, providerlastNameWithTitle) {
		mobile.verifyElementPresentByText("You have been invited to a RevTogether event!");
		mobile.verifyElementPresentByText("RevDoc brings the doctor to your doorstep. ");
		mobile.verifyElementPresentByText(MessageText);
		mobile.verifyElementPresentByText("- ${memberFirstName}");
		mobile.verifyElementPresentByText(memberLastName);
		mobile.verifyElementPresentByText("Event Snapshot");
		mobile.verifyElementPresentByText("\$${pricePerAdditionalPatient}");
		mobile.verifyElementPresentByText("per person");

		//verify date, time, location on preview Screen
		verifyCalendarIconWithDate(formattedDate);
		verifyTimeIconWithTime("${resultArray[2][0]}");
		verifyLocationIconWithAddress(apptAddress);
		gen.swipeUp();
		mobile.verifyElementPresentByText("Additional Event Details");
		verifyKeyValuePair("Procedure", procedureName);
		verifyKeyValuePair("Providers", providerfirstName);
		verifyKeyValuePair("Providers", providerlastNameWithTitle);
		verifyKeyValuePair("Invited by", memberFirstName);
		verifyKeyValuePair("Invited by", memberLastName);
		verifyKeyValuePair("RSVP By", formattedDate);
	}

	@Keyword
	def addImageToTheInviteScreen() {
		tapOnAddBtn();
		tapOnAddImagePlusBtn();
		dem.tapOnChooseFromLibraryBtn();
		dem.tapOnSelectPic(1);
		Mobile.delay(30);
		tapOnSaveImagesBtn();
	}

	@Keyword
	def verifyPopUpScreenAndAddTextMessage(MessageText) {
		Mobile.delay(8)
		mobile.verifyElementPresentByText("Close");
		mobile.verifyElementPresentByText("RSVP Note");
		mobile.verifyElementPresentByText("You can include a message to host with your RSVP.");
		mobile.verifyElementPresentByText("Include a Message to the Host");
		mobile.verifyElementPresentByText("We will let the host know that you will attend.");
		setTextInThanksMessageTextField(MessageText);
	}

	@Keyword
	def tapOnViewPatientsBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/RevTogether/viewPatientsBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def calculateProviderActualRevenueForMemberApptOfRevtogether( procedureId,  deliveryPrice) {
		// Initialize variables to accumulate fees from multiple procedures
		double totalProcedurePrice = 0.0
		double totalMaterialFee = 0.0
		double totalPharmaceuticalFee = 0.0
		def procedureDetails = null

		// Loop through each procedure name, calling the API method to get prices
		procedureDetails = admin.getProcedureById(procedureId)

		// Accumulate the prices for each procedure
		totalProcedurePrice += procedureDetails.procedurePrice
		totalMaterialFee += procedureDetails.materialPrice
		totalPharmaceuticalFee += procedureDetails.pharmaceuticalPrice


		// Define constants for various fees
		double providerAdminFee = 0.1625
		double creditCardFee = 0.05
		double prmFee = 0.03

		// Calculate Subtotal Revenue based on delivery method
		double subtotalRevenue
		double providerAdminCost
		double creditCardCost
		double prmCost
		double deliveryAndProcedureCost = deliveryPrice + totalProcedurePrice

		// House Call, Van Call, Facility calculation
		subtotalRevenue = deliveryPrice + totalMaterialFee + totalPharmaceuticalFee + totalProcedurePrice

		// Calculate costs
		providerAdminCost = providerAdminFee * subtotalRevenue
		creditCardCost = creditCardFee * subtotalRevenue
		prmCost = prmFee * deliveryAndProcedureCost


		// Calculate Actual Revenue
		int actualRevenue = (int) Math.round(subtotalRevenue - providerAdminCost - creditCardCost - prmCost)

		return actualRevenue
	}

	@Keyword
	def verifyInviteAdditionalFriendsBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevTogether/inviteAdditionalFriendsBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnManageBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/RevTogether/manageBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnInviteAdditionalFriendsBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/RevTogether/inviteAdditionalFriendsBtn_android'), defaultTime)
	}

	@Keyword
	def verifyDeclinedIcon(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevTogether/declinedIcon_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnDeleteIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/RevTogether/Continue to invite friends/deleteIcon_android'), defaultTime)
	}

}
