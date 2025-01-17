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


CustomKeywords.'pages.Login.launchSalesApplication'('https://stage.sales.revdoc.link/')

CustomKeywords.'pages.Login.enterEmail'('ravi.kumar+2065@qualitlabs.com')

CustomKeywords.'pages.Login.enterPassword'('Test@123')

CustomKeywords.'pages.Login.clickOnLoginButton'()

CustomKeywords.'pages.Login.enterMobileNumber'('8977942065')

CustomKeywords.'pages.Login.clickOnSendOTP'()

CustomKeywords.'pages.Login.enterOTP'('123456')

CustomKeywords.'pages.Login.clickOnVerifyOTPButton'()

CustomKeywords.'pages.Dashboard.verifyWelcomeMessage'()

CustomKeywords.'pages.Dashboard.clickOnLeaderboard'()

CustomKeywords.'pages.Dashboard.clickOnTopBarProfile'()

int points = CustomKeywords.'pages.Profile.getPointsFromProfileTabStoreIt'()

CustomKeywords.'pages.Profile.clickOnXButton'()

CustomKeywords.'pages.Leaderboard.clickOnHomeButton'()

CustomKeywords.'driversPage.Switch.getBrowserStackAndroidChromeDriver'("memberRegistration")

CustomKeywords.'memberAppEvents.MemberApplictionEvents.memberRegistration'()

Mobile.closeApplication()

CustomKeywords.'driversPage.Switch.getBrowserStackAndroidChromeDriver'("memberRegistration")

CustomKeywords.'memberAppEvents.MemberApplictionEvents.memberRegistration'()

Mobile.closeApplication()

CustomKeywords.'pages.Dashboard.clickOnLeaderboard'()

CustomKeywords.'pages.Dashboard.clickOnTopBarProfile'()

CustomKeywords.'pages.Profile.clickOnPayment'()

CustomKeywords.'pages.Profile.verifyPointsAndDollarsNotAddingOnceLimitExceeded'(points)

CustomKeywords.'pages.Profile.clickOnXButton'()

CustomKeywords.'pages.Leaderboard.clickOnHomeButton'()

CustomKeywords.'pages.Dashboard.clickOnManage'()

CustomKeywords.'pages.Manage.clickOnLogOut'()

CustomKeywords.'pages.Login.closeBrowser'()

