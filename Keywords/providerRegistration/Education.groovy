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
import providerRegistration.Demographics
import mobile.MobileActions

import internal.GlobalVariable

public class Education {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Demographics demo = new Demographics();
	ContactInformation contactInfo = new ContactInformation();
	WorkHistory work = new WorkHistory();
	MobileActions mob = new MobileActions()

	@Keyword
	def typeInUgUniversityNameInputBx(name) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Education/ugUniversityNameInputBx_android'), name, defaultTime)
	}

	@Keyword
	def tapOnUgSelectStateDropdown() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Education/ugSelectStateDropdown_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectFl() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Education/selectFl_android'), defaultTime)
	}

	@Keyword
	def tapOnUgMonthOfGraduationDropdown() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Education/ugMonthOfGraduationDropdown_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectMarch() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Education/selectMarch_android'), defaultTime)
	}

	@Keyword
	def tapOnUgYearOfGraduationDropdown() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Education/ugYearOfGraduationDropdown_android'), defaultTime)
	}

	@Keyword
	def tapOnUgSelect2016() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Education/ugSelect2016_android'), defaultTime)
	}

	@Keyword
	def tapOnUgDegreeNameInputBx(degreename) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Education/ugDegreeNameInputBx_android'), degreename, defaultTime)
	}

	@Keyword
	def tapOnUploadBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Education/uploadBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnChooseFromLibrary() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Education/chooseFromLibrary_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectPic() {
		try {
			Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/selectPic_android'), defaultTime)
		}
		catch(Exception e) {
			Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/selectPic2_android'), defaultTime)
		}
	}

	@Keyword
	def verifyPhotoReuploadBtn() {
		Mobile.delay(10);
		Mobile.waitForElementPresent(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/profileBiographyReuploadBtn_android'), 30);
	}

	@Keyword
	def typeInGeUniversityNameInputBx(uname) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Education/geUniversityNameInputBx_android'), uname, defaultTime)
	}

	@Keyword
	def tapOnGeSelectStateDropdown() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Education/geSelectStateDropdown_android'), defaultTime)
	}

	@Keyword
	def tapOnGeMonthOfGraduation() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Education/geMonthOfGraduation_android'), defaultTime)
	}

	@Keyword
	def tapOnGeYearOfGraduationDropdown() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Education/geYearOfGraduationDropdown_android'), defaultTime)
	}

	@Keyword
	def tapOnGeSelect2018() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Education/geSelect2018_android'), defaultTime)
	}

	@Keyword
	def typeInGeDegreeNameInputBx(name) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Education/geDegreeNameInputBx_android'), name, defaultTime)
	}

	@Keyword
	def typeInInternshipNameInputBx(name) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Education/internshipNameInputBx_android'), name, defaultTime)
	}

	@Keyword
	def clearInternshipNameInputBx() {
		Mobile.clearText(findTestObject('Object Repository/Provider/Registration/Education/internshipNameInputBx_android'), defaultTime)
	}
	@Keyword
	def tapOnInternSelectStateDropdown() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Education/internSelectStateDropdown_android'), defaultTime)
	}

	@Keyword
	def tapOnyearOfInternshipDropdown() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Education/yearOfInternshipDropdown_android'), defaultTime)
	}

	@Keyword
	def tapOnInternSelect2019() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Education/internSelect2019_android'), defaultTime)
	}

	@Keyword
	def tapOnResidencyNameInputBx(name) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Education/residencyNameInputBx_android'), name, defaultTime)
	}

	@Keyword
	def clearResidencyNameInputBx() {
		Mobile.clearText(findTestObject('Object Repository/Provider/Registration/Education/residencyNameInputBx_android'), defaultTime)
	}

	@Keyword
	def tapOnResSelectStateDropdown() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Education/resSelectStateDropdown_android'), defaultTime)
	}

	@Keyword
	def tapOnYearOfResidencyDropdown() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Education/yearOfResidencyDropdown_android'), defaultTime)
	}

	//Verify Elements

	@Keyword
	def verifyUgUniversityNameInputBxElementText(name) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Education/ugUniversityNameInputBx_android'),name)
	}

	@Keyword
	def verifyUgDegreeNameInputBxElementText(name) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Education/ugDegreeNameInputBx_android'),name)
	}

	@Keyword
	def verifyGeUniversityNameInputBxElementText(name) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Education/geUniversityNameInputBx_android'),name)
	}

	@Keyword
	def verifyGeDegreeNameInputBxElementText(name) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Education/geDegreeNameInputBx_android'),name)
	}

	@Keyword
	def verifyInternshipNameInputBxElementText(name) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Education/internshipNameInputBx_android'),name)
	}

	@Keyword
	def verifyResidencyNameInputBxElementText(name) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Education/residencyNameInputBx_android'),name)
	}

	@Keyword
	def verifyStateFlElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Education/verifyStateFl_android'),defaultTime)
	}

	@Keyword
	def verifyInternStateFlElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Education/verifyInternStateFl_android'),defaultTime)
	}

	@Keyword
	def verifyMonthMarchElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Education/verifyMonthMarch_android'),defaultTime)
	}

	@Keyword
	def verifyResStateFlElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Education/verifyResStateFl_android'),defaultTime)
	}

	@Keyword
	def verifyYear2016ElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Education/verifyYear2016_android'),defaultTime)
	}

	@Keyword
	def verifyYear2018ElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Education/verifyYear2018_android'),defaultTime)
	}

	@Keyword
	def verifyYear2019ElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Education/verifyYear2019_android'),defaultTime)
	}

	@Keyword
	def verifyTitleElementExist(title) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Education/verifyTitle_android', ['title': title]),defaultTime)
	}

	@Keyword
	def verifyRequiredMsgElementExist(msg,index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Education/verifyRequiredMsg_android', ['msg': msg, 'index': index]),defaultTime)
	}

	@Keyword
	def verifyPlaceholderElementExist(placeholder) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Education/verifyPlaceholder_android', ['placeholder': placeholder]),defaultTime)
	}

	@Keyword
	def tapOnSelectStateInDropDown(state) {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Contact Information/stateInStateDrpDwnList_android',['state': state]), defaultTime)
	}

	@Keyword
	def verifyStateSelectedText(state) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Education/verifyRequiredStateSelected_android', ['state': state]),defaultTime)
	}

	@Keyword
	def verifyOptionalStateSelectedText(state) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Education/verifyOptionalSelectedState_android', ['state': state]),defaultTime)
	}

	@Keyword
	def fillDetailsInUnderGraduationSection(university, degree, state) {
		typeInUgUniversityNameInputBx(university);
		Mobile.hideKeyboard();
		tapOnUgSelectStateDropdown();
		tapOnSelectStateInDropDown(state)
		tapOnUgMonthOfGraduationDropdown();
		tapOnSelectMarch();
		tapOnUgYearOfGraduationDropdown();
		tapOnUgSelect2016();
		tapOnUgDegreeNameInputBx(degree);
		Mobile.hideKeyboard();
		tapOnUploadBtn();
		tapOnChooseFromLibrary();
		tapOnSelectPic();
		verifyPhotoReuploadBtn()
		Mobile.delay(10);
		demo.swipeUp();
		//Mobile.scrollToText('Upload', FailureHandling.STOP_ON_FAILURE);
	}

	@Keyword
	def fillDetailsInGraduationSection(university, degree, state) {
		TestObject testObject = findTestObject('Object Repository/Provider/Registration/Education/uploadBtn_android')
		typeInGeUniversityNameInputBx(university);
		Mobile.hideKeyboard();
		tapOnGeSelectStateDropdown();
		tapOnSelectStateInDropDown(state)
		tapOnGeMonthOfGraduation();
		tapOnSelectMarch();
		tapOnGeYearOfGraduationDropdown();
		tapOnGeSelect2018();
		typeInGeDegreeNameInputBx(degree);
		Mobile.hideKeyboard();
		mob.scrollUntilElementIsVisible(testObject)
		tapOnUploadBtn();
		tapOnChooseFromLibrary();
		tapOnSelectPic();
		verifyPhotoReuploadBtn()
		Mobile.delay(20)
		//demo.swipeUp();
		Mobile.scrollToText('Add Certifications', FailureHandling.STOP_ON_FAILURE);
	}

	@Keyword
	def fillFellowshipDetails(name, state) {
		typeInInternshipNameInputBx(name);
		Mobile.hideKeyboard();
		tapOnInternSelectStateDropdown();
		tapOnSelectStateInDropDown(state)
		tapOnyearOfInternshipDropdown();
		tapOnInternSelect2019();
		contactInfo.tapOnNextBtn();
		demo.tapOnBackBtn();
	}

	@Keyword
	def fillFellowshipDetailsWithoutNxtBtn(name, state) {
		typeInInternshipNameInputBx(name);
		Mobile.hideKeyboard();
		tapOnInternSelectStateDropdown();
		tapOnSelectStateInDropDown(state)
		tapOnyearOfInternshipDropdown();
		tapOnInternSelect2019();
	}

	@Keyword
	def fillResidencyDetails(name, state) {
		tapOnResidencyNameInputBx(name);
		Mobile.hideKeyboard();
		tapOnResSelectStateDropdown();
		tapOnSelectStateInDropDown(state)
		demo.swipeUp();
		tapOnYearOfResidencyDropdown();
		tapOnInternSelect2019();
		//Mobile.scrollToText('Add Certifications', FailureHandling.STOP_ON_FAILURE)

	}

	@Keyword
	def verifyTheGraduationDetails(ugUniversity, ugDegree, gUniversity, gDegree, state) {
		verifyUgUniversityNameInputBxElementText(ugUniversity);
		verifyStateSelectedText(state)
		verifyMonthMarchElementExist();
		verifyYear2016ElementExist();
		verifyUgDegreeNameInputBxElementText(ugDegree);
		demo.swipeUpLittle();
		Mobile.scrollToText('Ge University', FailureHandling.STOP_ON_FAILURE);
		verifyGeUniversityNameInputBxElementText(gUniversity);
		verifyStateSelectedText(state)
		verifyMonthMarchElementExist();
		demo.swipeUpLittle();
		verifyYear2018ElementExist();
		verifyGeDegreeNameInputBxElementText(gDegree);
	}

	@Keyword
	def verifyFellowshipAndResidenceDetails(internName, residencyName, state) {
		Mobile.scrollToText('Add Certifications', FailureHandling.STOP_ON_FAILURE);
		verifyInternshipNameInputBxElementText(internName);
		verifyOptionalStateSelectedText(state)
		verifyYear2019ElementExist();
		verifyResidencyNameInputBxElementText(residencyName);
		verifyOptionalStateSelectedText(state)
		verifyYear2019ElementExist();
		//contactInfo.tapOnNextBtn();
	}

	@Keyword
	def verifyUIAndFillDetailsInUnderGraduationSection(university, degree) {
		contactInfo.tapOnNextBtn();
		verifyTitleElementExist("Undergraduate Education *")
		verifyPlaceholderElementExist("University Name *")
		verifyRequiredMsgElementExist("Required","1")
		typeInUgUniversityNameInputBx(university);
		Mobile.hideKeyboard();
		verifyPlaceholderElementExist("State *")
		verifyRequiredMsgElementExist("Required","1")
		tapOnUgSelectStateDropdown();
		tapOnSelectFl();
		verifyPlaceholderElementExist("Month of Graduation *")
		verifyRequiredMsgElementExist("Required","1")
		tapOnUgMonthOfGraduationDropdown();
		tapOnSelectMarch();
		verifyPlaceholderElementExist("Year of Graduation *")
		verifyRequiredMsgElementExist("Required","1")
		tapOnUgYearOfGraduationDropdown();
		tapOnUgSelect2016();
		Mobile.scrollToText('Degree Name (Bachelors etc) *', FailureHandling.CONTINUE_ON_FAILURE);
		verifyPlaceholderElementExist("Degree Name (Bachelors etc) *")
		verifyRequiredMsgElementExist("Required","1")
		tapOnUgDegreeNameInputBx(degree);
		Mobile.hideKeyboard();
		verifyTitleElementExist("Upload School Diploma *")
		verifyRequiredMsgElementExist("Required","1")
		tapOnUploadBtn();
		tapOnChooseFromLibrary();
		tapOnSelectPic();
		//demo.swipeUp();
		//Mobile.scrollToText('Internship (optional)', FailureHandling.STOP_ON_FAILURE);
		//Mobile.scrollToText('Graduate Education *', FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifyUIAndFillDetailsInGraduationSection(university, degree) {
		Mobile.scrollToText('State *', FailureHandling.CONTINUE_ON_FAILURE);
		demo.swipeUpLittle();
		verifyTitleElementExist("Graduate Education *")
		verifyPlaceholderElementExist("University Name *")
		verifyRequiredMsgElementExist("Required","1")
		typeInGeUniversityNameInputBx(university);
		Mobile.hideKeyboard();
		//Mobile.scrollToText('Upload School Diploma *', FailureHandling.CONTINUE_ON_FAILURE);
		verifyPlaceholderElementExist("State *")
		verifyRequiredMsgElementExist("Required","1")
		tapOnGeSelectStateDropdown();
		tapOnSelectFl();
		//demo.swipeUpLittle();
		//Mobile.scrollToText('Month of Graduation *', FailureHandling.CONTINUE_ON_FAILURE);
		verifyPlaceholderElementExist("Month of Graduation *")
		demo.swipeUpLittle();
		verifyRequiredMsgElementExist("Required","1")
		tapOnGeMonthOfGraduation();
		tapOnSelectMarch();
//		demo.swipeUpLittle();
		//Mobile.scrollToText('Year of Graduation *', FailureHandling.CONTINUE_ON_FAILURE);
		verifyPlaceholderElementExist("Year of Graduation *")
		verifyRequiredMsgElementExist("Required","1")
		tapOnGeYearOfGraduationDropdown();
		tapOnGeSelect2018();
		//Mobile.scrollToText('Degree Name (Bachelors etc) *', FailureHandling.CONTINUE_ON_FAILURE);
		verifyPlaceholderElementExist("Degree Name (Bachelors etc) *")
		verifyRequiredMsgElementExist("Required","1")
		typeInGeDegreeNameInputBx(degree);
		Mobile.hideKeyboard();
		verifyTitleElementExist("Upload School Diploma *")
		verifyRequiredMsgElementExist("Required","1")
		tapOnUploadBtn();
		tapOnChooseFromLibrary();
		tapOnSelectPic();
		//demo.swipeUp();
		//demo.swipeUpLittle();
		//Mobile.scrollToText('Fellowship (optional)', FailureHandling.CONTINUE_ON_FAILURE);
		//Mobile.scrollToText('Year of Residency', FailureHandling.STOP_ON_FAILURE);
	}

	@Keyword
	def verifyUIAndFillFellowshipDetails(name) {
		demo.swipeUp();
		verifyTitleElementExist("Fellowship (optional)")
		verifyPlaceholderElementExist("Fellowship Name")
		typeInInternshipNameInputBx(name);
		Mobile.hideKeyboard();
		verifyPlaceholderElementExist("State")
		tapOnInternSelectStateDropdown();
		tapOnSelectFl();
		demo.swipeUp();
		verifyPlaceholderElementExist("Year of Completion")
		tapOnyearOfInternshipDropdown();
		tapOnInternSelect2019();
		//demo.swipeUp();
//		contactInfo.tapOnNextBtn();
		//demo.tapOnBackBtn();
	}

	@Keyword
	def verifyUIAndFillResidencyDetails(name) {
		//demo.swipeUp();
		Mobile.scrollToText('Year of Completion', FailureHandling.CONTINUE_ON_FAILURE);
		verifyTitleElementExist("Residency (optional)")
		verifyPlaceholderElementExist("Residency Name")
		tapOnResidencyNameInputBx(name);
		Mobile.hideKeyboard();
		verifyPlaceholderElementExist("State")
		tapOnResSelectStateDropdown();
		tapOnSelectFl();
		//demo.swipeUp();
		Mobile.scrollToText("Fellowship (optional)");
		verifyPlaceholderElementExist("Year of Completion")
		tapOnYearOfResidencyDropdown();
		tapOnInternSelect2019();
	}
	@Keyword
	def tapOnAddCertificationsOption() {
		Mobile.scrollToText("Add Certifications");
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Education/addCertificationsOption_android'), defaultTime);
	}
	@Keyword
	def tapOnAddAdditionalCertificationsOption() {
		Mobile.scrollToText("Add Additional Certifications");
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Education/addAdditionalCertificationsOp_android'), defaultTime);
	}
	@Keyword
	def typeInCertificateNameTxtBx(certificateName) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Education/certificationNameTxtBx_android'), certificateName, defaultTime);
	}
	@Keyword
	def addingCertificationInEducationalField(certificateName) {
		tapOnUploadBtn();
		tapOnChooseFromLibrary();
		tapOnSelectPic();
		Mobile.delay(5);
		Mobile.scrollToText('Add Additional Certifications', FailureHandling.STOP_ON_FAILURE);
		typeInCertificateNameTxtBx(certificateName);

	}
	@Keyword
	def addingCertificationInEducationalFieldTwo(certificateName) {
		tapOnUploadBtn();
		tapOnChooseFromLibrary();
		tapOnSelectPic();
		Mobile.delay(5);
		Mobile.scrollToText('Add Additional Certifications', FailureHandling.STOP_ON_FAILURE);
		typeInCertificateNameTxtBxtwo(certificateName);

	}
	@Keyword
	def typeInCertificateNameTxtBxtwo(certificateName) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Education/certificateNameTxtBxTwo_android'), certificateName, defaultTime);
	}

	@Keyword
	def verifyCertificationNameValue(certificationName) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Education/certificationNameValue_android',["value":certificationName]), defaultTime);
	}
	@Keyword
	def verifyUploadCertificateRequiredError() {
		Mobile.scrollToText("Add Additional Certifications");
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Education/uploadCertificateRequiredError_android'), defaultTime);
	}
	@Keyword
	def verifyCertificateNameRequiredError() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Education/certificateNameRequiredError_android'), defaultTime);
	}
	@Keyword
	def tapOnDeleteCertificate()
	{
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Education/deleteCertificate_android'), defaultTime);
	}
	@Keyword
	def verifyElementTxtNotExist(text) {
		Mobile.delay(20);
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Registration/Education/verifyElementText_android',["text":text]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}
	@Keyword
	def tapOnDeleteBtn()
	{
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Education/tapOnDeleteBtn_android'), defaultTime);
	}
	@Keyword
	def verifyANetworkErrorExists(onFailure=FailureHandling.OPTIONAL, defaultTime = 10) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Education/aNetworkError_android'), defaultTime, onFailure);
	}
}
