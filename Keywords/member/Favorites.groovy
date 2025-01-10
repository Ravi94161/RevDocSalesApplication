package member

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
import mobile.MobileActions

import internal.GlobalVariable

public class Favorites {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE;
	MobileActions mobile = new MobileActions();

	@Keyword
	def tapToAddFavorite() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Favourites/favouriteOutline_android'), defaultTime)
	}

	@Keyword
	def verifyProviderAddedToFavorite() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Favourites/favouriteOrange_android'), defaultTime)
	}

	@Keyword
	def verifyProviderAddedToFavorite(procedureName) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Favourites/favoriteOrangeIcon_android', ['name': procedureName]), defaultTime)
	}

	@Keyword
	def tapToRemoveFromFavorite() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Favourites/favouriteOrange_android'), defaultTime)
	}

	@Keyword
	def tapToAddFavoriteProvider() {
		boolean ispresent = Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Favourites/favouriteOutline_android'), 10, FailureHandling.OPTIONAL);

		if(ispresent) {
			Mobile.tap(findTestObject('Object Repository/Member/HomePage/Favourites/favouriteOutline_android'), defaultTime)
		}
		//Object Repository/Member/HomePage/Favourites/favouriteOrange_android
		//		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Favourites/favouriteOutline_android'), defaultTime)
		//		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Favourites/favouriteOutline_android'), defaultTime)
	}

	@Keyword
	def verifyFavoriteIconExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Favourites/favoriteIcon_android'), defaultTime)
	}

	@Keyword
	def tapOnFavoriteIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Favourites/favoriteIcon_android'), defaultTime)
	}

	@Keyword
	def verifyProvidersTabExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Favourites/providersTab_android'), defaultTime)
	}

	@Keyword
	def verifyFavoriteIconInMyFavoritePageExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Favourites/favoriteIconInMyfavoritePage_android'), defaultTime)
	}

	@Keyword
	def verifyNotAddedToFavorite() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Favourites/favouriteOutline_android'), defaultTime)
	}

	@Keyword
	def verifyProcedureTabExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Favourites/procedureTab_android'), defaultTime)
	}

	@Keyword
	def tapOnProcedureTab() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Favourites/procedureTab_android'), defaultTime)
	}

	@Keyword
	def verifyProgramsTabExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Favourites/programsTab_android'), defaultTime)
	}

	@Keyword
	def tapOnProgramsTab() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Favourites/programsTab_android'), defaultTime)
	}

	@Keyword
	def verifyFavoriteOrangeIconExist(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Favourites/favouriteOrange_android'), defaultTime, onFailure)
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Favourites/favouriteOrange_android'), defaultTime, onFailure)
		}
	}
}
