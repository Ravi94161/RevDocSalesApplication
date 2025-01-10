package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.WebElement

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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.entity.checkpoint.ExcelCheckpointSourceInfo

import internal.GlobalVariable

public class Dashboard {

	int pointsValue;
	String userName;

	@Keyword
	def clickOnLeaderboard() {

		TestObject leaderboard = findTestObject('Object Repository/Dashboard/div_Leaderboard');
		WebUI.click(leaderboard);
	}

	@Keyword
	def clickOnContests() {
		WebUI.click('Object Repository/Dashboard/div_Contests');
	}

	@Keyword
	def clickOnManage() {
		WebUI.click('Object Repository/Dashboard/div_Manage');
	}

	@Keyword
	def clickOnMessaging() {
		WebUI.click('Object Repository/Dashboard/div_Messaging');
	}

	@Keyword
	def clickOnHelp() {
		WebUI.click('Object Repository/Dashboard/div_Help');
	}

	@Keyword
	def clickOnShare() {
		WebUI.click('Object Repository/Dashboard/div_Share');
	}

	@Keyword
	def verifyWelcomeMessage() {
		TestObject welcomeMessageElement = findTestObject('Object Repository/Dashboard/h1_Welcome_message')
		def welcomeText = WebUI.getText(welcomeMessageElement);
		println(welcomeText);

		userName = WebUI.getText(findTestObject('Object Repository/Dashboard/p_name'));
		def userNameWords = userName.split(" ");
		String firstName = userNameWords[0];
		println(firstName);
		String userType = WebUI.getText(findTestObject('Object Repository/Dashboard/p_usertype'));

		if(welcomeText.contains(firstName)) {
			println("Welcome message is displayed correctly.....");
		}else {
			throw new Exception('Text "$firstName" is not present in the text "$welcomeText"');
		}
	}

	@Keyword
	def clickOnTopBarProfile() {

		TestObject topBarName = findTestObject('Object Repository/Dashboard/p_name');
		WebUI.click(topBarName);
	}

	@Keyword
	def getPointsCount() {
		TestObject pointsCount = findTestObject('Object Repository/Dashboard/p_pointscount');
		String count = WebUI.getText(pointsCount);
		pointsValue = count as int;
		println(pointsValue);
		GlobalVariable.leaderboardPoints=pointsValue;
	}

	@Keyword
	def verifyPointsAddedForEvent() {

		TestObject pointsCount = findTestObject('Object Repository/Dashboard/p_pointscount');
		String count = WebUI.getText(pointsCount);
		int pointsValueAfterEvent = count as int;
		println(pointsValueAfterEvent)
		println(GlobalVariable.leaderboardPoints)
		if(pointsValueAfterEvent == (GlobalVariable.leaderboardPoints+5)) {
			println("points got added.....");
		}else {
			throw new Exception("Points are not added for the event.....");
		}
	}
}
