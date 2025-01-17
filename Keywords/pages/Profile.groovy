package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.text.Normalizer
import java.text.SimpleDateFormat
import java.time.DateTimeException
import java.time.LocalDate
import java.time.LocalDateTime

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.server.handler.FindElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.beans.ListenerList
import groovy.json.internal.ValueList
import internal.GlobalVariable
import utility.Verify

public class Profile {

	Verify verify = new Verify()
	Global global = new Global()
	WebDriver driver = DriverFactory.getWebDriver()

	@Keyword
	def clickOnGoals() {

		TestObject goals = findTestObject('Object Repository/Profile/button_Goals');
		verify.verifyElementClickable(goals, "Goals element is not clickable...")
		WebUI.click(goals);
	}

	@Keyword
	def clickOnPayment() {

		TestObject payment = findTestObject('Object Repository/Profile/button_Payment');
		verify.verifyElementClickable(payment, "payment element is not clickable...")
		WebUI.click(payment);
	}

	@Keyword
	def clickOnStatus() {

		TestObject status = findTestObject('Object Repository/Profile/button_Status');
		WebUI.click(status);
	}

	@Keyword
	def clickOnMySales() {

		TestObject mySales = findTestObject('Object Repository/Profile/button_My Sales');
		WebUI.click(mySales);
	}

	@Keyword
	def normalize(value) {

		return Normalizer.normalize(value, Normalizer.Form.NFD).replaceAll("\\p{M}", "").toLowerCase()
	}

	@Keyword
	def verifyRecordAddedToMonthlySales() {

		TestObject monthDropdown = findTestObject('Object Repository/Profile/div_MonthDropdown')
		global.chooseCurrentMonth(monthDropdown)
		global.storeDetailsUnderPaymentToListAndVerify()
	}

	@Keyword
	def clickOnXButton() {

		TestObject closeButtonOBJ =  findTestObject('Object Repository/Profile/button_X')
		WebUI.click(closeButtonOBJ)
	}

	@Keyword
	def getOverrideAmountBeforEvent() {

		TestObject monthDropdown = findTestObject('Object Repository/Profile/div_MonthDropdown')
		global.chooseCurrentMonth(monthDropdown)
		//get override value and store it in default profile
		TestObject overrideTextOBJ = findTestObject('Object Repository/Profile/overrideTxt')
		String dollarAmount = global.getOverrideValueBeforeEventAndStoreIt(overrideTextOBJ)
		return dollarAmount

	}

	@Keyword
	def verifyOverrideAmountAfterEvent(String overrideAmountBeforeEvent) {

		TestObject monthDropdown = findTestObject('Object Repository/Profile/div_MonthDropdown')
		global.chooseCurrentMonth(monthDropdown)
		TestObject overrideTextOBJ = findTestObject('Object Repository/Profile/overrideTxt')
		global.verifyOverrideValueAfterEventAddedOrNot(overrideTextOBJ,overrideAmountBeforeEvent)
	}

	@Keyword
	def getPointsFromProfileTabStoreIt() {

		TestObject pointsOBJ = findTestObject('Object Repository/Profile/pointsOnProfile')
		int points = WebUI.getText(pointsOBJ).toInteger()
		println(points)
		return points
	}

	@Keyword
	def verifyPointsAddedAfterEvent(int points) {

		TestObject pointsOBJ = findTestObject('Object Repository/Profile/pointsOnProfile')
		global.verifyPointsAddedAfterEvent(pointsOBJ,points)
	}

	@Keyword
	def getCurrentMonthGoalsAndStoreGoals() {

		TestObject monthDropdownOBJ = findTestObject('Object Repository/Profile/div_MonthDropdown')
		global.chooseCurrentMonth(monthDropdownOBJ)
		TestObject goalsOBJ = findTestObject('Object Repository/Profile/goalCount')
		String goalsCount = WebUI.getText(goalsOBJ)
		TestObject myProgressOBJ = findTestObject('Object Repository/Profile/myProgress')
		String myProgressCount = WebUI.getText(myProgressOBJ)
		TestObject reachedStatusOBJ = findTestObject('Object Repository/Profile/reachedStatus')
		String reachedCount = WebUI.getText(reachedStatusOBJ)
		List<String> goalsData = new ArrayList()
		goalsData.add(goalsCount)
		goalsData.add(myProgressCount)
		goalsData.add(reachedCount)
		println(goalsData)
		List<Integer> goalsValues = global.getGoalValuesOfAnEvent(goalsData)
		println(goalsValues)
		return goalsValues
	}

	@Keyword
	def selectCurrentMonthVerifyGoalsUpdatedOrNot(List<Integer> goalsValuesBeforeEvent) {

		TestObject monthDropdownOBJ = findTestObject('Object Repository/Profile/div_MonthDropdown')
		global.chooseCurrentMonth(monthDropdownOBJ)
		TestObject goalsOBJ = findTestObject('Object Repository/Profile/goalCount')
		TestObject myProgressOBJ = findTestObject('Object Repository/Profile/myProgress')
		TestObject reachedStatusOBJ = findTestObject('Object Repository/Profile/reachedStatus')
		global.verifyGoalsUpdatedOrNot(goalsOBJ, myProgressOBJ, reachedStatusOBJ, goalsValuesBeforeEvent)
	}

	def verifyPointsAndDollarsNotAddingOnceLimitExceeded(int points) {
	 TestObject pointsOBJ = findTestObject('Object Repository/Profile/pointsOnProfile')
	 int pointsAfterEvents = WebUI.getText(pointsOBJ).toInteger()
	 if(points == 0) {
	 verify.verifyIsEqual(pointsAfterEvents, points+5, "Points limits feature is not working fine in leaderboard.....")
	 }else {
	 verify.verifyIsEqual(pointsAfterEvents, points, "Points limits feature is not working fine in leaderboard.....")
	 }
	 clickOnPayment()
	 TestObject monthDropdown = findTestObject('Object Repository/Profile/div_MonthDropdown')
	 TestObject limitsText = findTestObject('Object Repository/Profile/limitsText')
	 TestObject saleRecord = findTestObject('Object Repository/Profile/salesDataField')
	 global.verifyLimitsFeatureInPaymetsProfile(monthDropdown, limitsText, saleRecord)
	 }
}
