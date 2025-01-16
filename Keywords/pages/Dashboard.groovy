package pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import utility.Verify

public class Dashboard {

	int pointsValue;
	String userName;
	Verify verify = new Verify();

	@Keyword
	def clickOnLeaderboard() {

		TestObject leaderboard = findTestObject('Object Repository/Dashboard/div_Leaderboard');
		verify.verifyElementClickable(leaderboard, "Unable to click on leaderboard.....")
		WebUI.click(leaderboard);
	}

	@Keyword
	def clickOnContests() {
		TestObject contest = findTestObject('Object Repository/Dashboard/div_Contests')
		verify.verifyElementClickable(contest, "Unable to click on contest.....")
		WebUI.click(contest);
	}

	@Keyword
	def clickOnManage() {
		TestObject manage = findTestObject('Object Repository/Dashboard/div_Manage')
		verify.verifyElementClickable(manage, "Unable to click on manage.....")
		WebUI.click(manage)
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

		verify.verifyTextContains(firstName, "name is not present in welcome text")
		verify.verifyTextContains(userType, "usertype is not present in welcome text")
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
		//GlobalVariable.salesAppPoints=pointsValue;
		return pointsValue;
	}

	@Keyword
	def verifyPointsAddedForEvent(String points) {

		TestObject pointsCount = findTestObject('Object Repository/Dashboard/p_pointscount');
		String count = WebUI.getText(pointsCount);
		int pointsValueAfterEvent = count as int;
		int pointsValueBeforeEvent = points as int;
		println(pointsValueAfterEvent)
		println(pointsValueBeforeEvent)
		verify.verifyIsEqual(pointsValueAfterEvent, pointsValueBeforeEvent, "Points are not added for the event.....")
	}
}
