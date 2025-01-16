import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable

CustomKeywords.'pages.Login.launchSalesApplication'(GlobalVariable.salesAppURL)

CustomKeywords.'pages.Login.enterEmail'(GlobalVariable.salesUserEmail)

CustomKeywords.'pages.Login.enterPassword'(GlobalVariable.salesUserPassword)

CustomKeywords.'pages.Login.clickOnLoginButton'()

CustomKeywords.'pages.Login.enterMobileNumber'(GlobalVariable.salesUserMobileNumber)

CustomKeywords.'pages.Login.clickOnSendOTP'()

CustomKeywords.'pages.Login.enterOTP'(GlobalVariable.salesUserOTP)

CustomKeywords.'pages.Login.clickOnVerifyOTPButton'()

CustomKeywords.'pages.Dashboard.verifyWelcomeMessage'()

CustomKeywords.'pages.Dashboard.clickOnLeaderboard'()

CustomKeywords.'pages.Dashboard.clickOnTopBarProfile'()

int points = CustomKeywords.'pages.Profile.getPointsFromProfileTabStoreIt'()

CustomKeywords.'pages.Profile.clickOnXButton'()

CustomKeywords.'pages.Contest.clickOnHomeButton'()

//String points = CustomKeywords.'pages.Dashboard.getPointsCount'()

CustomKeywords.'driversPage.Switch.getBrowserStackAndroidChromeDriver'("memberRegistration")
  
CustomKeywords.'memberAppEvents.MemberApplictionEvents.memberRegistration'()
  
Mobile.closeApplication()

CustomKeywords.'pages.Dashboard.clickOnLeaderboard'()

CustomKeywords.'pages.Dashboard.clickOnTopBarProfile'()
  
CustomKeywords.'pages.Profile.verifyPointsAddedAfterEvent'(points)
  
CustomKeywords.'pages.Profile.clickOnPayment'()
  
CustomKeywords.'pages.Profile.verifyRecordAddedToMonthlySales'()
  
CustomKeywords.'pages.Profile.clickOnXButton'()
  
CustomKeywords.'pages.Leaderboard.clickOnHomeButton'()
  
CustomKeywords.'pages.Dashboard.clickOnManage'()
  
CustomKeywords.'pages.Manage.clickOnLogOut'()
  
CustomKeywords.'pages.Login.closeBrowser'()
  
 