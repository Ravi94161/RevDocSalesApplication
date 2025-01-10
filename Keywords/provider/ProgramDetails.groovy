package provider
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import mobile.MobileActions
import mobile.Utility

class ProgramDetails {

	def defaultTime = GlobalVariable.defaultTime
	def telemedicineResourceId = 'telehealthgrey'
	def vanCallResourceId = 'vangrey'

	MobileActions mobile = new MobileActions()
	Utility ul = new Utility()

	@Keyword
	def verifyCloseBtnExist() {
		ul.verifyElementPresent(findTestObject('Object Repository/Provider/More/Opt-in to Programs/ProgramDetails/closeBtn_android'), 'close button not found', defaultTime)
	}
	
	@Keyword
	def verifyTitleText(text, onFailure = FailureHandling.STOP_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/More/Opt-in to Programs/ProgramDetails/programDetailsTitle_android'), text, onFailure)
	}

	@Keyword
	def verifyProgramName(text, index, onFailure = FailureHandling.STOP_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/More/Opt-in to Programs/ProgramDetails/programName_android', ['name' : text,'index':index]), text, onFailure)
	}

	@Keyword
	def verifyProgramOwnerName(text, index, onFailure = FailureHandling.STOP_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/More/Opt-in to Programs/ProgramDetails/programOwnerName_android', ['name' : text,'index':index]), text, onFailure)
	}

	@Keyword
	def verifyAvatarImgExist(index) {
		ul.verifyElementPresent(findTestObject('Object Repository/Provider/More/Opt-in to Programs/ProgramDetails/avatarImg_android', ['index':index]), "Avatar image not exist", defaultTime)
	}

	@Keyword
	def verifyExclamationCircleFillExist() {
		ul.verifyElementPresent(findTestObject('Object Repository/Provider/More/Opt-in to Programs/ProgramDetails/exclamationCircleFill_android'), "Exclamation Circle fill not exist", defaultTime)
	}

	@Keyword
	def verifyVerifiedCheckExist() {
		ul.verifyElementPresent(findTestObject('Object Repository/Provider/More/Opt-in to Programs/ProgramDetails/verifiedCheck_android'), "Verified Check not exist", defaultTime)
	}

	@Keyword
	def verifyDeliveryMethodNameExist(deliveryMethod, index, onFailure = FailureHandling.STOP_ON_FAILURE) {
			def obj= findTestObject('Object Repository/Provider/More/Opt-in to Programs/ProgramDetails/deliveryMethodName_android', ['name' : deliveryMethod, 'index' : index])
			mobile.scrollUntilElementIsVisible(obj, 15, 5);
			Mobile.verifyElementText(obj, deliveryMethod, onFailure)
	}

	@Keyword
	def verifySupportedProcedureNameExist(procedureName, onFailure = FailureHandling.STOP_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/More/Opt-in to Programs/ProgramDetails/supportedProcedures_android', ['text' : procedureName]), procedureName, onFailure)
	}

	@Keyword
	def verifyUnsupportedProcedureNameExist(procedureName, onFailure = FailureHandling.OPTIONAL) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/More/Opt-in to Programs/ProgramDetails/unsupportedProcedures_android', ['text' : procedureName]), procedureName, onFailure)
	}

	@Keyword
	def verifyPerAppointmentTextExist(index) {
		ul.verifyElementPresent(findTestObject('Object Repository/Provider/More/Opt-in to Programs/ProgramDetails/perAppointmentText_android', ['index' : index]), "per appointment text is not exist", defaultTime)
	}
	@Keyword
	def verifyProgramImgExist(text, index) {
		ul.verifyElementPresent(findTestObject('Object Repository/Provider/More/Opt-in to Programs/ProgramDetails/programImg_android', ['text' : text, 'index': index]), 'Program image not exist',defaultTime)
	}

	@Keyword
	def verifyDeliveryMethodSymbolExist(text, index) {
		if(text == 'Telemedicine') {
			ul.verifyElementPresent(findTestObject('Object Repository/Provider/More/Opt-in to Programs/ProgramDetails/deliveryMethodSymbol_android', ['text' : telemedicineResourceId, 'index' : index]), "Telemedicine Symbol not found", defaultTime)
		}
		else if(text == 'Van Call') {
			ul.verifyElementPresent(findTestObject('Object Repository/Provider/More/Opt-in to Programs/ProgramDetails/deliveryMethodSymbol_android', ['text' : vanCallResourceId, 'index' : index]), "Van Call Symbol not found", defaultTime)
		}
	}

}