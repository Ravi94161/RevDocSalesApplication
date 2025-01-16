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


CustomKeywords.'pages.Login.launchSalesApplication'(GlobalVariable.salesAppURL)

CustomKeywords.'pages.Login.enterEmail'(GlobalVariable.parentSalesUserEmail)

CustomKeywords.'pages.Login.enterPassword'(GlobalVariable.parentSalesUserPassword)

CustomKeywords.'pages.Login.clickOnLoginButton'()

CustomKeywords.'pages.Login.enterMobileNumber'(GlobalVariable.parentSalesUserMobileNumber)

CustomKeywords.'pages.Login.clickOnSendOTP'()

CustomKeywords.'pages.Login.enterOTP'(GlobalVariable.salesUserOTP)

CustomKeywords.'pages.Login.clickOnVerifyOTPButton'()

CustomKeywords.'pages.Dashboard.verifyWelcomeMessage'()

CustomKeywords.'pages.Dashboard.clickOnContests'()

CustomKeywords.'pages.Dashboard.clickOnTopBarProfile'()
  
CustomKeywords.'pages.Profile.clickOnPayment'()

String overrideAmountBeforeEvent = CustomKeywords.'pages.Profile.getOverrideAmountBeforEvent'()

CustomKeywords.'pages.Profile.clickOnXButton'()

CustomKeywords.'pages.Leaderboard.clickOnHomeButton'()

CustomKeywords.'pages.Dashboard.clickOnManage'()

CustomKeywords.'pages.Manage.clickOnLogOut'()

CustomKeywords.'pages.Login.enterEmail'(GlobalVariable.salesUserEmail)

CustomKeywords.'pages.Login.enterPassword'(GlobalVariable.salesUserPassword)

CustomKeywords.'pages.Login.clickOnLoginButton'()

CustomKeywords.'pages.Login.enterMobileNumber'(GlobalVariable.salesUserMobileNumber)

CustomKeywords.'pages.Login.clickOnSendOTP'()

CustomKeywords.'pages.Login.enterOTP'(GlobalVariable.salesUserOTP)

CustomKeywords.'pages.Login.clickOnVerifyOTPButton'()

CustomKeywords.'pages.Dashboard.verifyWelcomeMessage'()

CustomKeywords.'pages.Dashboard.clickOnContests'()

CustomKeywords.'pages.Dashboard.clickOnTopBarProfile'()

int points = CustomKeywords.'pages.Profile.getPointsFromProfileTabStoreIt'()

CustomKeywords.'pages.Profile.clickOnXButton'()

CustomKeywords.'pages.Leaderboard.clickOnHomeButton'()

CustomKeywords.'driversPage.Switch.getBrowserStackAndroidChromeDriver'("CheckOverridesInContest")
  
CustomKeywords.'memberAppEvents.MemberApplictionEvents.memberRegistration'()
  
Mobile.closeApplication()
  
CustomKeywords.'pages.Dashboard.clickOnContests'()

CustomKeywords.'pages.Dashboard.clickOnTopBarProfile'()

CustomKeywords.'pages.Profile.verifyPointsAddedAfterEvent'(points)
  
CustomKeywords.'pages.Profile.clickOnPayment'()
  
CustomKeywords.'pages.Profile.verifyRecordAddedToMonthlySales'()
  
CustomKeywords.'pages.Profile.clickOnXButton'()
  
CustomKeywords.'pages.Leaderboard.clickOnHomeButton'()
  
CustomKeywords.'pages.Dashboard.clickOnManage'()
  
CustomKeywords.'pages.Manage.clickOnLogOut'()

CustomKeywords.'pages.Login.enterEmail'(GlobalVariable.parentSalesUserEmail)

CustomKeywords.'pages.Login.enterPassword'(GlobalVariable.parentSalesUserPassword)

CustomKeywords.'pages.Login.clickOnLoginButton'()

CustomKeywords.'pages.Login.enterMobileNumber'(GlobalVariable.parentSalesUserMobileNumber)

CustomKeywords.'pages.Login.clickOnSendOTP'()

CustomKeywords.'pages.Login.enterOTP'(GlobalVariable.salesUserOTP)

CustomKeywords.'pages.Login.clickOnVerifyOTPButton'()

CustomKeywords.'pages.Dashboard.verifyWelcomeMessage'()

CustomKeywords.'pages.Dashboard.clickOnContests'()

CustomKeywords.'pages.Dashboard.clickOnTopBarProfile'()

CustomKeywords.'pages.Profile.clickOnPayment'()

CustomKeywords.'pages.Profile.verifyOverrideAmountAfterEvent'(overrideAmountBeforeEvent)

CustomKeywords.'pages.Profile.clickOnXButton'()

CustomKeywords.'pages.Leaderboard.clickOnHomeButton'()

CustomKeywords.'pages.Dashboard.clickOnManage'()

CustomKeywords.'pages.Manage.clickOnLogOut'()
  
CustomKeywords.'pages.Login.closeBrowser'()