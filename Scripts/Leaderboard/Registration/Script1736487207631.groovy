import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


def salesDeepLink = "https://revdoc.app.link/gMWtsXRuFPb"
def iterations = 1

List<List<String>> data = [["Email", "PhoneNumber", "FirstName", "LastName"]]

for (int i = 1; i <= iterations; i++) {
	try {
		def randomNumber = CustomKeywords.'mobile.Generic.generateRandomNumericString'(3)
		def firstName = "salesRevPlusMember${randomNumber}";
		def middleName = "U";
		def lastName = "user${randomNumber}"
		def fullAddress = GlobalVariable.searchAddress
		def race = "Asian"
		def zipCode = "48867"
		CustomKeywords.'member.loginPage.launchMemberAppAndroid'()
		Mobile.pressHome()
		CustomKeywords.'provider.InvitePatients.sendDeepLinkThroughMsgs'(salesDeepLink)

		def phoneNumber = CustomKeywords.'mobile.Generic.generateRandomMobileNumber'(startsWith = "22903");
		def randomEmail = CustomKeywords.'mobile.Generic.generateRandomEmail'();
		def memberDetails = CustomKeywords.'member.loginPage.newMemberLogin'(phoneNumber)
		def email = randomEmail ?: "noemail@yohmail.com"
		
		//fill Aadditional details
		CustomKeywords.'memberSignUp.SignUp.fillAdditionalInfoDetails'(firstName , middleName, lastName, tapOnContinue = false);
		
		Mobile.scrollToText("Email Address*", FailureHandling.OPTIONAL);
		CustomKeywords.'memberSignUp.SignUp.typeInEmailAddressInput'(email)
		
		Mobile.scrollToText("Zip Code*", FailureHandling.OPTIONAL);
		CustomKeywords.'member.loginPage.typeInZipCode'(zipCode)
		
		Mobile.scrollToText("Follow @revdoc.official", FailureHandling.OPTIONAL);
		CustomKeywords.'mobile.MobileActions.tapOnElementByText'("Follow @revdoc.official");
		Mobile.delay(5);
		
		Mobile.pressBack(FailureHandling.OPTIONAL)
		CustomKeywords.'memberSignUp.SignUp.tapOnContinueBtn'();
		Mobile.delay(5);
		
	} catch (Exception e) {
		println "Error during iteration $i: ${e.message}"
		ArrayList<String> arr = new ArrayList<String>(Arrays.asList("Error", "Error", "Error", "Error"));
		data <<  arr
	}
}

