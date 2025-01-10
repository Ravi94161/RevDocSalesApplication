package provider360

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

public class Banking {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	providerRegistration.Demographics demo = new providerRegistration.Demographics();

	@Keyword
	def verifySetupProviderProfileTitle(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/setUpProviderProfileTitle_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnBankingOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Banking/bankingOptionBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnAddAdditonalBankAccountBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Banking/addAdditionalBankAccountBtn_'+os), defaultTime);
	}
	@Keyword
	def verifyAddAdditonalBankAccountBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/addAdditionalBankAccountBtn_'+os), defaultTime, onFailure);
	}
	@Keyword
	def tapOnAddAdditonalBankAccountBtn1() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Banking/addAdditionalBankAccountBtn1_'+os), defaultTime);
	}


	@Keyword
	def verifyBankInformationPageTitle(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/bankInformationTitle_android'), defaultTime, onFailure);
	}

	@Keyword
	def enterBankAccountName(account) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/Banking/accountNameTextField_android'), account, defaultTime);
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}
	@Keyword
	def verifyBankAccountName(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/accountNameTextField_android'), defaultTime, onFailure);
	}

	@Keyword
	def enterBankInstitutionName(bank) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/Banking/bankInstitutionName_'+os), bank, defaultTime);
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}
	@Keyword
	def verifyBankInstitutionName(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/bankInstitutionName_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifySavingsAccountType(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/savingsAccountTypeRadioBtn_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyCheckoutAccountType(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/checkingAccountType_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyAccountNumberField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/accountNumberTextFiield_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyRoutingNumberField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/routingNumberTextField_'+os), defaultTime, onFailure);
	}
	@Keyword
	def checkSavingsAccountType() {
		Mobile.checkElement(findTestObject('Object Repository/Provider/Provider360/Banking/savingsAccountTypeRadioBtn_'+os), defaultTime);
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}

	@Keyword
	def enterAccountNumber(num) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/Banking/accountNumberTextFiield_'+os), num, defaultTime);
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}

	@Keyword
	def enterRoutingNumber(routingNum) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/Banking/routingNumberTextField_'+os), routingNum, defaultTime);
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}
	@Keyword
	def clearRoutingNumber() {
		Mobile.clearText(findTestObject('Object Repository/Provider/Provider360/Banking/routingNumberTextField_'+os), defaultTime);
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}
	@Keyword
	def tapOnSavebankAccountBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Banking/saveBankAccountBtn_'+os), defaultTime);
	}
	@Keyword
	def verifySavebankAccountBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/saveBankAccountBtn_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifySavingsBankCardEditBtn(name,  onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime ) {
		Mobile.verifyElementExist(findTestObject('Provider/Provider360/Banking/editBtnOnBankCard_android', ["value": name]), defaultTime, onFailure);
	}

	@Keyword
	def verifySavingsBankcardDeleteBtn(name,onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Provider/Provider360/Banking/deleteBtnOnBankCard_android', ["value": name]), defaultTime, onFailure);
	}

	@Keyword
	def verifyBankNameOnCard(name,onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/bankNameOnCard_'+os, ["value": name]), defaultTime, onFailure);
	}

	@Keyword
	def verifyBankInstitutionNameOnCard(bankName, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/bankInstitutionNameOnCard_android', ['bankName': bankName]), defaultTime, onFailure);
	}

	@Keyword
	def verifyAddAdditionalBankAccountLink() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/addAdditionalBankAccountBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnSavingsBankcardEditBtn(name) {
		Mobile.tap(findTestObject('Provider/Provider360/Banking/editBtnOnBankCard_android', ["value": name]), defaultTime);
	}

	@Keyword
	def clearBankInstitutionName() {
		Mobile.clearText(findTestObject('Object Repository/Provider/Provider360/Banking/bankInstitutionName_'+os), defaultTime);
		Mobile.hideKeyboard();
	}

	@Keyword
	def clearBankAccountNumber() {
		Mobile.clearText(findTestObject('Object Repository/Provider/Provider360/Banking/accountNumberTextFiield_'+os), defaultTime);
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}

	@Keyword
	def clickOnSaveChangesBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Banking/saveChangesBtn_'+os), defaultTime);
	}

	@Keyword
	def verifyEditedBankNameOnCard(name) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/editedBankNameOnCard_'+os, ['value': name]), defaultTime);
	}

	@Keyword
	def verifyEditedBankAccountNumber(num) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/editedBankAccountNumberOnCard_'+os, ["value": num]), defaultTime);
	}

	@Keyword
	def clickOnDeleteBtn(name) {
		Mobile.tap(findTestObject('Provider/Provider360/Banking/deleteBtnOnBankCard_'+os, ['value': name]), defaultTime);
	}

	@Keyword
	def verifyRemoveBankAccountPopupTitle() {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Banking/removeBankAccountTitle_'+os), "Delete Bank Account");
	}

	@Keyword
	def verifyTextOnRemoveBankAccountPopup() {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Banking/textOnRemoveBankAccountPopup_'+os), "Are you sure that you would like to delete your bank account from RevDoc? This action can not be undone. You must have at least 1 bank account on file to be paid.");
	}

	@Keyword
	def verifyNoKeepBtnOnRemovebankAccountPopup(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/noKeepBtn_'+os), defaultTime, onFailure);
	}
	@Keyword
	def tapOnNoKeepBtnOnRemovebankAccountPopup() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Banking/noKeepBtn_'+os), defaultTime);
	}
	@Keyword
	def clickOnYesRemoveBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Banking/yesRemoveBtn_'+os), defaultTime);
	}

	@Keyword
	def verifyAbscenceOfNewBankCard(name) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/Banking/bankNameOnCard_'+os, ['value':name]), defaultTime);
	}

	@Keyword
	def clickOnSaveBankingBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Banking/saveBankingBtn_'+os), defaultTime);
	}
	@Keyword
	def verifySaveBankingBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/saveBankingBtn_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyAddBankAccountLink(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/BuildMyRevdocProfileBanking/addBankAccountLink_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyBankingDescription(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/BuildMyRevdocProfileBanking/bankingDescription_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyBankingBackBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/BuildMyRevdocProfileBanking/bankingBackBtn_'+os), defaultTime, onFailure)) {
			return true
		}
	}
	@Keyword
	def tapOnBankingBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/BuildMyRevdocProfileBanking/bankingBackBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnAddBankAccountLink() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/BuildMyRevdocProfileBanking/addBankAccountLink_'+os), defaultTime);
	}
	@Keyword
	def verifyYesDeleteBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/yesRemoveBtn_'+os), defaultTime, onFailure);
	}

	@Keyword
	def tapOnSaveBankAccountBtn1() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Banking/saveBankAccountBtn1_'+os), defaultTime);
	}

	@Keyword
	def addAdditionalBankAccounts(name,bankname,number,routing) {
		//demo.swipeUp();
		Mobile.scrollToText("Add an additional bank account")
		tapOnAddAdditonalBankAccountBtn();
		//enter text in required field
		enterBankAccountName(name);
		Mobile.hideKeyboard();
		enterBankInstitutionName(bankname);
		Mobile.hideKeyboard();
		checkSavingsAccountType()
		enterAccountNumber(number);
		Mobile.hideKeyboard();
		enterRoutingNumber(routing);
		Mobile.hideKeyboard();
		tapOnSaveBankAccountBtn1();
		Mobile.scrollToText(name);
		verifyBankNameOnCard(name)

	}

	@Keyword
	def verifyAccountNameRequiredErrMsg(failure = FailureHandling.CONTINUE_ON_FAILURE, errorMsg) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Banking/accountNameRequiredErr_andriod'), errorMsg, failure)
	}

	@Keyword
	def verifyInstituteNameRequiredErrMsg(failure = FailureHandling.CONTINUE_ON_FAILURE, errorMsg) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Banking/instituteNameRequiredErrMsg_andriod'), errorMsg, failure)
	}

	@Keyword
	def verifyAccountTypeRequiredErrMsg(failure = FailureHandling.CONTINUE_ON_FAILURE, errorMsg) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Banking/accountTypeRequiredErrMsg_andriod'), errorMsg, failure)
	}

	@Keyword
	def verifyAccountNumberRequiredError(failure = FailureHandling.CONTINUE_ON_FAILURE, errorMsg) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Banking/requiredErrMsgOfAccntNumField_andriod'), errorMsg, failure)
		//		Mobile.verifyElementText(findTestObject, os, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyRoutingNumberRequiredError(failure = FailureHandling.CONTINUE_ON_FAILURE, errorMsg) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Banking/requiredErrMsgOfRoutingNumField_andriod'), errorMsg, failure)
	}

	@Keyword
	def verifyValidationErrMsgOfAccountNumber(failure = FailureHandling.CONTINUE_ON_FAILURE, errorMsg) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Banking/validationErrMsgofAcctNum_andriod'), errorMsg, failure)
	}

	@Keyword
	def checkTheDefaultBankAccountCheckBox(index) {
		Mobile.checkElement(findTestObject('Object Repository/Provider/Provider360/Banking/tapOnDefaultBankAccnt_andriod',["index" : index]), defaultTime)
	}

	@Keyword
	def verifyDefaultBankAccountCheckBoxChecked(index) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/Banking/tapOnDefaultBankAccnt_andriod',["index" : index]), defaultTime)
	}
	@Keyword
	def verifyCloseBtnOnPopup(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/closeBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnCloseBtnOnPopup() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Banking/closeBtn_android'), defaultTime);
	}
	@Keyword
	def verifyElementText(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/verifyElementText_android', ["text":text]), defaultTime, onFailure)
	}
	@Keyword
	def verifyExitWithOutSavingBtnOnPopup(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/exitWithOutSavingBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyCancelBtnOnPopup(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/cancelButton_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyScreenTitle(title, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/verifyScreenTitle_android',["title":title]), defaultTime, onFailure)
	}
	@Keyword
	def tapOnEditGreyBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Banking/editGreyBtn_android'), defaultTime);
	}
	@Keyword
	def verifyDefaultBankAccountFilledCheckBox(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/defaultBankAccountFilledCheckBox_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyDefaultBankAccountEmptyCheckBox(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/defaultBankAccountEmptyCheckBox_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyBankInstituteNameOnCard(bankName, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/bankInstitutionNameOnCard_android',["bankName":bankName]), defaultTime, onFailure)
	}
	@Keyword
	def verifyBankAccountTypeOnCard1(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/accountTypeOnCard_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyBankAccountNumberOnCard1(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/accountNumberOnCard_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyBankAccountRoutingNumberOnCard1(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/accoutRoutingnumberOnCard_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyPerticularBankDetailsOnCard(bankName, text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime ) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/verifyPertivularBankDetails_android',["bank":bankName, "text":text]), defaultTime, onFailure)
	}
	@Keyword
	def tapOnCheckingAccountRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Banking/checkingAccountType_android'), defaultTime);
	}
	@Keyword
	def tapOnSpecificAccountDefaultCheckBox(accountName, status) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Banking/specificBankDefaultCheckBox_android',["accountName":accountName, "status":status]), defaultTime);
	}
	@Keyword
	def verifySpecificAccountDefaultCheckBox(accountName, status, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/specificBankDefaultCheckBox_android',["accountName":accountName, "status":status]), defaultTime, onFailure);
	}

	@Keyword
	def verifySpecificAccountDefaultCheckBoxCondition(accountName, status, onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Banking/specificBankDefaultCheckBox_android',["accountName":accountName, "status":status]), defaultTime, onFailure);
	}

	@Keyword
	def addingBankAccountInBuildMyProfileScreen(acctName, bankName, acctNum, routingNum) {
		tapOnBankingOption()
		tapOnAddBankAccountLink()
		verifyBankInformationPageTitle()
		enterBankAccountName(acctName)
		enterBankInstitutionName(bankName)
		checkSavingsAccountType()
		enterAccountNumber(acctNum)
		enterRoutingNumber(routingNum)
		tapOnSavebankAccountBtn()
		verifyBankNameOnCard(acctName)
		checkTheDefaultBankAccountCheckBox("1")
		clickOnSaveBankingBtn()
	}
	@Keyword
	def verifyBankAccountTypeTxt(text,onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Banking/accountTypeOnCard_android'), text, onFailure)
	}
	@Keyword
	def verifyBankAccountNumberTxt(text,onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Banking/accountNumberOnCard_android'), text, onFailure)
	}
	@Keyword
	def verifyAdditionalBankAccountNumberTxt(text,onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Banking/additionalBankAccountNumber_android'), text, onFailure)
	}
	@Keyword
	def verifyBankAccountRoutingNumberTxt(text,onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Banking/accoutRoutingnumberOnCard_android'), text, onFailure)
	}
	@Keyword
	def verifyAdditionalBankAccountRoutingNumberTxt(text,onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Banking/additionalbankAccRoutingNum_android'), text, onFailure)
	}
}