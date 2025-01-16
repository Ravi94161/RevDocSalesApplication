package memberAppEvents

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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import member.HomePage
import member.Login
import memberSignUp.SignUp
import mobile.Generic
import mobile.MobileActions
import provider.InvitePatients

public class MemberApplictionEvents {

	@Keyword
	def memberRegistration() {

		Generic generic = new Generic()
		Login login = new Login()
		InvitePatients invitePatients = new InvitePatients()
		SignUp signUp = new SignUp()
		MobileActions mobileActions = new MobileActions()
		HomePage homepage = new HomePage()
		GlobalVariable.eventType ='Member Registration'


		def salesDeepLink = GlobalVariable.parentUserInviteLink
		def iterations = 1

		List<List<String>> data = [["Email", "PhoneNumber", "FirstName", "LastName"]]

		for (int i = 1; i <= iterations; i++) {
			try {
				def randomNumber = generic.generateRandomNumericString(3)
				def firstName = "salesRevPlusMember${randomNumber}";
				def middleName = "U";
				def lastName = "user${randomNumber}"
				def fullAddress = GlobalVariable.searchAddress
				def race = "Asian"
				def zipCode = "48867"
				//login.launchMemberAppAndroid()
				Mobile.pressHome()
				invitePatients.sendDeepLinkThroughMsgs(salesDeepLink)

				def phoneNumber = generic.generateRandomMobileNumber("22903")

				def randomEmail = generic.generateRandomEmail();
				def memberDetails = login.newMemberLogin(phoneNumber)
				def email = randomEmail ?: "noemail@yohmail.com"

				signUp.fillAdditionalInfoDetails(firstName , middleName, lastName);

				Mobile.scrollToText("Email Address*", FailureHandling.OPTIONAL);
				signUp.typeInEmailAddressInput(email)

				Mobile.scrollToText("Zip Code*", FailureHandling.OPTIONAL);
				login.typeInZipCode(zipCode)

				Mobile.scrollToText("Follow @revdoc.official", FailureHandling.OPTIONAL);
				mobileActions.tapOnElementByText("Follow @revdoc.official");
				Mobile.delay(5);

				Mobile.pressBack(FailureHandling.OPTIONAL)
				signUp.tapOnContinueBtn();
				Mobile.delay(5);
				GlobalVariable.eventType ='Member Registration'
				GlobalVariable.invitedMemberPersonName = firstName + " " + middleName + " " + lastName

				//homepage.verifyHomePageIcon()
				//homepage.tapOnHomePageIcon()


			} catch (Exception e) {
				println "Error during iteration $i: ${e.message}"
				ArrayList<String> arr = new ArrayList<String>(Arrays.asList("Error", "Error", "Error", "Error"));
				data <<  arr
			}
		}
	}
}