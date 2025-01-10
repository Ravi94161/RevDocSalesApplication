package providerRegistration

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

import internal.GlobalVariable
import mobile.Generic
import provider360.SetUpYourAvailability
import mobile.MobileActions


public class License {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Education edu = new Education();
	WorkHistory work = new WorkHistory();
	Generic gen = new Generic();
	Demographics demo = new Demographics();
	ContactInformation contactInfo = new ContactInformation();
	SetUpYourAvailability avail = new SetUpYourAvailability();
	ProfileBiography profile = new ProfileBiography()
	MobileActions mobile = new MobileActions()


	// Define the mapping of state acronyms to full names
	def stateMap = [
		'AL': 'Alabama',
		'AK': 'Alaska',
		'AZ': 'Arizona',
		'AR': 'Arkansas',
		'CA': 'California',
		'CO': 'Colorado',
		'CT': 'Connecticut',
		'DE': 'Delaware',
		'FL': 'Florida',
		'GA': 'Georgia',
		'HI': 'Hawaii',
		'ID': 'Idaho',
		'IL': 'Illinois',
		'IN': 'Indiana',
		'IA': 'Iowa',
		'KS': 'Kansas',
		'KY': 'Kentucky',
		'LA': 'Louisiana',
		'ME': 'Maine',
		'MD': 'Maryland',
		'MA': 'Massachusetts',
		'MI': 'Michigan',
		'MN': 'Minnesota',
		'MS': 'Mississippi',
		'MO': 'Missouri',
		'MT': 'Montana',
		'NE': 'Nebraska',
		'NV': 'Nevada',
		'NH': 'New Hampshire',
		'NJ': 'New Jersey',
		'NM': 'New Mexico',
		'NY': 'New York',
		'NC': 'North Carolina',
		'ND': 'North Dakota',
		'OH': 'Ohio',
		'OK': 'Oklahoma',
		'OR': 'Oregon',
		'PA': 'Pennsylvania',
		'RI': 'Rhode Island',
		'SC': 'South Carolina',
		'SD': 'South Dakota',
		'TN': 'Tennessee',
		'TX': 'Texas',
		'UT': 'Utah',
		'VT': 'Vermont',
		'VA': 'Virginia',
		'WA': 'Washington',
		'WV': 'West Virginia',
		'WI': 'Wisconsin',
		'WY': 'Wyoming'
	]

	// Function to get the full state name from an acronym
	String getStateFullName(String acronym)
	{
		def fullName = stateMap[acronym.toUpperCase()]
		if (fullName)
		{
			return fullName
		}
		else
		{
			return 'Invalid acronym'
		}
	}

	@Keyword
	def tapOnSelectStateDropdown() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/License/selectStateDropdown_android'), defaultTime)
	}

	@Keyword
	def tapOnselcetStateFl() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/License/selcetStateFl_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectStateGA() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/License/selcetStateGA_android'), defaultTime)
	}

	@Keyword
	def typeInProviderLicenseNumberInputBx(name) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/License/providerLicenseNumberInputBx_android'), name, defaultTime)
	}

	@Keyword
	def tapOnLicenseExpirationDate() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/License/licenseExpirationDate_android'), defaultTime)
	}
	@Keyword
	def getLicenseExpirationDate() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Registration/License/getLicenseExpirationDate_android'), defaultTime);
	}

	@Keyword
	def tapOnLicenseTypeDropdown() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/License/licenseTypeDropdown_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectStagingLicense() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/License/selectStagingLicense_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectAALicense() {
		Mobile.tap(findTestObject('Provider/Registration/License/selectAALicense_android'), defaultTime)
	}

	@Keyword
	def tapOnConfirmBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/License/confirmBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnAddAdditionalLicenseBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/License/addAdditionalLicenseBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnDeleteLicenseBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/License/deleteLicenseBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnDeleteBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/License/deleteBtn_android'), defaultTime)
	}

	@Keyword
	def verifyproviderLicenseNumberInputBxElementText(name) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/License/providerLicenseNumberInputBx_android'),name)
	}

	@Keyword
	def verifySelectStateFlElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/License/verifySelectStateFl_android'),defaultTime)
	}

	@Keyword
	def verifySelectStateGAElementExist() {
		Mobile.scrollToText('GA');
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/License/verifySelectStateGA_android'),defaultTime)
	}

	@Keyword
	def verifyLicenseTypeStagingElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/License/verifyLicenseTypeStaging_android'),defaultTime)
	}


	@Keyword
	def verifyLicenseTypeMDElementExist() {
		Mobile.verifyElementExist(findTestObject('Provider/Registration/License/verifyLicenseTypeAA_android'),defaultTime)
	}

	@Keyword
	def tapOnSelectStateInDropDown(state) {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Contact Information/stateInStateDrpDwnList_android',['state': state]), defaultTime)
	}

	@Keyword
	def fillLicenseDetails(num, month) {
		TestObject testObject = findTestObject('Object Repository/Provider/Registration/Education/uploadBtn_android')
		int timeout = 45
		tapOnSelectStateDropdown();
		demo.swipeUpLittle();
		//tapOnselcetStateFl'();
		tapOnSelectStateGA();
		typeInProviderLicenseNumberInputBx(num);
		Mobile.hideKeyboard();
		tapOnLicenseExpirationDate();
		//Adding two months to the existing date
		def formattedFutureDate = gen.addMonthsInSeekBar(2);
		if(formattedFutureDate.year != formattedFutureDate.currentYear) {
			avail.selectYear(formattedFutureDate.year);
		}
		
		avail.selectMonth(formattedFutureDate.month);
		tapOnConfirmBtn();
		def licenseExpirationDate = getLicenseExpirationDate();
		tapOnLicenseTypeDropdown();
		tapOnSelectAALicense();
		//tapOnSelectStagingLicense();
		edu.tapOnUploadBtn();
		edu.tapOnChooseFromLibrary();
		edu.tapOnSelectPic();
		edu.verifyPhotoReuploadBtn();
		Mobile.delay(20);
		contactInfo.tapOnNextBtn();
		Mobile.delay(10)
		//boolean isTextVisible = mobile.waitForTextVisible(testObject, "Reupload", timeout, FailureHandling.OPTIONAL)
		//if(isTextVisible) {
//			contactInfo.tapOnNextBtn();
		//}

		Mobile.delay(10);
		return licenseExpirationDate ;
	}

	@Keyword
	def fillAdditionalLicenseDetails(num, state, month) {
		demo.tapOnBackBtn();
		demo.swipeUp();
		tapOnAddAdditionalLicenseBtn();
		Mobile.scrollToText("Provider License Number ")
		demo.swipeUp();
		tapOnSelectStateDropdown();
		tapOnSelectStateInDropDown(state)
		//tapOnSelectStateGA();
		typeInProviderLicenseNumberInputBx(num);
		tapOnLicenseExpirationDate();
		avail.selectMonth(month)
		tapOnConfirmBtn();
		tapOnLicenseTypeDropdown();
		tapOnSelectAALicense();
		//tapOnSelectStagingLicense();
		edu.tapOnUploadBtn();
		edu.tapOnChooseFromLibrary();
		edu.tapOnSelectPic();
		edu.verifyPhotoReuploadBtn()
		demo.swipeUp();
		profile.waitAndVerifyVideoReuploadBtn(1)
		//Mobile.delay(10)
		contactInfo.tapOnNextBtn();
	}

	@Keyword
	def verifySubmittedLicenseDetailsinRegistrationFlow(num, formattedMonth) {
		demo.tapOnBackBtn();
		//verifySelectStateFlElementExist();
		//		verifySelectStateGAElementExist();
		verifyproviderLicenseNumberInputBxElementText(num);
		mobile.verifyElementPresentByText(formattedMonth)
		verifyLicenseTypeMDElementExist();
		//verifyLicenseTypeStagingElementExist();
		contactInfo.tapOnNextBtn();
	}

	@Keyword
	def verifyUIValidationOfLicenseScreen(num, state, month, formattedMonth) {
		//Click on Next Button in License
		demo.tapOnNextBtn();

		//Verify we are not on Work History Page
		work.verifyEmployerNameInputBxNotExist();

		//Fill the License Details
		fillLicenseDetails(num, month);
		verifySubmittedLicenseDetailsinRegistrationFlow(num, formattedMonth);

		//Fill Additional license data
		fillAdditionalLicenseDetails(num, state, month);

		//Click on Back Button
		demo.tapOnBackBtn();

		//Delete the License
		//demo.swipeUp();
		Mobile.scrollToText("Add Additional License", FailureHandling.STOP_ON_FAILURE)
		tapOnDeleteLicenseBtn();
		tapOnDeleteBtn();
		Mobile.delay(5)

		//Click on Next Button
		contactInfo.tapOnNextBtn();
	}
	@Keyword
	def verifyUIValidationOfLicenseScreenTwo(state,num) {
		work.verifyEmployerNameInputBxNotExist();
		//Fill the License Details
		fillLicenseDetailsTwo(state,num);

	}
	@Keyword
	def tapOnSelectStatePracticeOption(state) {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/License/selectStatePracticeOption_android',["value":state]), defaultTime);
	}
	@Keyword
	def verifySelectStatePracticeOption(state) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/License/selectStateTexBx_android',["value":state]), defaultTime);
	}
	@Keyword
	def fillLicenseDetailsTwo(state,num) {
		tapOnSelectStateDropdown();
		tapOnSelectStatePracticeOption(state);
		typeInProviderLicenseNumberInputBx(num);
		Mobile.hideKeyboard();
		tapOnLicenseExpirationDate();
		gen.swipeUpLeftOfScreen();
		gen.swipeUpRightOfScreen();
		tapOnConfirmBtn();
		tapOnLicenseTypeDropdown();
		tapOnSelectAALicense();
		//tapOnSelectStagingLicense();
		edu.tapOnUploadBtn();
		edu.tapOnChooseFromLibrary();
		edu.tapOnSelectPic();
		Mobile.delay(10)
		//contactInfo.tapOnNextBtn();
	}
	@Keyword
	def verifySubmittedLicenseDetails(state,num) {
		Mobile.scrollToText(state);
		verifySelectStatePracticeOption(state);
		Mobile.scrollToText(num);
		verifyproviderLicenseNumberInputBxElementText(num);
		verifyLicenseTypeMDElementExist();
	}

	@Keyword
	def verifyDAELicensePage(num) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Registration/License/daeLicence_android'), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/License/daeLicenceRegistrationNum_android'), num, defaultTime)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Registration/License/daeExpirationDate_android'), defaultTime)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Registration/License/uploadBtn_android'), defaultTime)
	}

	@Keyword
	def clearDEALicenseNum() {
		Mobile.clearText(findTestObject('Object Repository/Provider/Registration/License/daeLicenceRegistrationNum_android'), defaultTime)
	}
	@Keyword
	def tapOnDAELicenseExpirationDate() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/License/daeExpirationDate_android'), defaultTime)
		gen.swipeUpLeftOfScreen();
		gen.swipeUpRightOfScreen();
		tapOnConfirmBtn();
	}

	@Keyword
	def tapOnDAELicenseExpirationDateField() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/License/daeExpirationDate_android'), defaultTime)
	}

	@Keyword
	def fillDAELicenseDetails(num) {
		verifyDAELicensePage(num)
		tapOnDAELicenseExpirationDate()
		edu.tapOnUploadBtn();
		edu.tapOnChooseFromLibrary();
		edu.tapOnSelectPic();
		edu.verifyPhotoReuploadBtn()
		Mobile.delay(20);
		contactInfo.tapOnNextBtn();
	}
	@Keyword
	def fillAdditionalLicenseDetailsTwo(num, state) {
		tapOnSelectStateDropdown();
		tapOnSelectStateInDropDown(state)
		typeInProviderLicenseNumberInputBx(num);
		tapOnLicenseExpirationDate();
		gen.swipeUpLeftOfScreen();
		gen.swipeUpRightOfScreen();
		tapOnConfirmBtn();
		tapOnLicenseTypeDropdown();
		tapOnSelectAALicense();
		edu.tapOnUploadBtn();
		edu.tapOnChooseFromLibrary();
		edu.tapOnSelectPic();
		Mobile.delay(20)
	}
	//Filling DEA Registration Number
	@Keyword
	def fillDEALicense(num) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Registration/License/daeLicence_android'), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/License/daeLicenceRegistrationNum_android'), num, defaultTime)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Registration/License/daeExpirationDate_android'), defaultTime)
	}
	//tapping on DEA License button
	@Keyword
	def tapOnDEALicense(defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/deaLicense_andriod'), defaultTime);
	}
	//tapping on DEA License Info button
	@Keyword
	def tapOnDEALicenseInfoIcon(defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpProviderProfile/deaLicenseInfoBtn_'+os), defaultTime);
	}
	//Verifying DEA License Info button
	@Keyword
	def verifyDEALicenseInfoIconExist(defaultTime = defaultTime, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpProviderProfile/deaLicenseInfoBtn_android'), defaultTime, onFailure);
	}

	//Verifying DEA License Placeholders
	@Keyword
	def verifyDEALicensePlaceholderExist(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/License/deaPlaceholders_android',['text':text]), defaultTime, onFailure);
	}

	//Verifying DEA License Required Messages
	@Keyword
	def verifyDEALicenseRequiredMsgExist(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/License/deaLicenseFieldsErrorMsg_android',['text':text]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnBackButton() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Education/backBtn_android'), defaultTime);
	}
}
