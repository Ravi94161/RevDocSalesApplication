package mobile

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.codehaus.groovy.ast.stmt.ContinueStatement
import org.openqa.selenium.remote.SessionId

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.appium.driver.AppiumDriverManager
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import api.BrowserStack
import api.Lambda
import groovy.json.JsonSlurper
import internal.GlobalVariable
import java.time.LocalDate
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files
import java.nio.file.Paths
import java.security.MessageDigest
import java.util.Date
import java.util.Calendar
import java.text.NumberFormat
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import java.util.TimeZone
import java.time.temporal.ChronoUnit

public class Generic {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	BrowserStack bs = new BrowserStack();
	Lambda lambda = new Lambda();
	Utility util = new Utility()

	@Keyword
	def setDeviceConfiguration(deviceName = "Galaxy S23 Ultra", platformVersion = "13", grantPermission = false) {
		RunConfiguration.setDriverPreferencesProperty('Remote',  "deviceName" , deviceName)
		RunConfiguration.setDriverPreferencesProperty('Remote', "platformVersion", platformVersion)
		RunConfiguration.setDriverPreferencesProperty('Remote', "autoGrantPermissions", grantPermission	)
	}

	@Keyword
	def setDeviceNetwork(net = false, grantPermission = true) {
		RunConfiguration.setDriverPreferencesProperty('Remote', 'network', net)
		RunConfiguration.setDriverPreferencesProperty('Remote', "autoGrantPermissions", grantPermission	)
	}

	@Keyword
	def startExistingRevDocApp() {
		Mobile.pressHome()
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		driver.activateApp('com.revdoc.member')
		Mobile.delay(5)
	}

	@Keyword
	def launchProviderAppAndroid(boolean deleteAfterDone = true) {
		//		try {
		//			if(GlobalVariable.sessionId != null) {
		//				AppiumDriverManager.getDriver().launchApp()
		//			} else {
		//				Mobile.startApplication(GlobalVariable.providerAppAndroid, deleteAfterDone)
		//				GlobalVariable.sessionId =  AppiumDriverManager.getDriver().getSessionId();
		//			}
		//		} catch (Exception e) {
		//			GlobalVariable.sessionId = null
		//			Mobile.startApplication(GlobalVariable.providerAppAndroid, deleteAfterDone)
		//			GlobalVariable.sessionId =  AppiumDriverManager.getDriver().getSessionId();
		//		}
		Mobile.startApplication(GlobalVariable.providerAppAndroid, deleteAfterDone)
	}

	@Keyword
	def launchProviderAppIos(boolean deleteAfterDone = true) {
		Mobile.startApplication(GlobalVariable.providerAppIos, deleteAfterDone)
	}

	@Keyword
	def launchProviderApp(boolean deleteAfterDone = true) {
		if(os == 'Ios') {
			launchProviderAppIos(deleteAfterDone);
		}
		else {
			launchProviderAppAndroid(deleteAfterDone);
		}

		GlobalVariable.bsResult = GlobalVariable.bsResult + ' ' + "Provider "
		getSessionDetails()
	}

	@Keyword
	def launchMemberAppAndroid(boolean deleteAfterDone = true) {
		//		try {
		//			if(GlobalVariable.sessionId != null) {
		//				AppiumDriverManager.getDriver().launchApp()
		//			} else {
		//				Mobile.startApplication(GlobalVariable.memberAppAndroid, deleteAfterDone)
		//				GlobalVariable.sessionId =  AppiumDriverManager.getDriver().getSessionId();
		//			}
		//		} catch (Exception e) {
		//			GlobalVariable.sessionId = null;
		//			Mobile.startApplication(GlobalVariable.memberAppAndroid, deleteAfterDone)
		//			GlobalVariable.sessionId =  AppiumDriverManager.getDriver().getSessionId();
		//		}
		Mobile.startApplication(GlobalVariable.memberAppAndroid, deleteAfterDone)
	}

	@Keyword
	def launchMemberAppIos(boolean deleteAfterDone = true) {
		Mobile.startApplication(GlobalVariable.providerAppIos, deleteAfterDone)
	}

	@Keyword
	def launchMemberApp(boolean deleteAfterDone = true) {
		if(os == 'Ios') {
			launchMemberAppIos(deleteAfterDone);
		}
		else {
			launchMemberAppAndroid(deleteAfterDone);
		}
		GlobalVariable.bsResult = GlobalVariable.bsResult + ' ' + "Member "
		getSessionDetails()
	}

	@Keyword
	def getSessionDetails() {
		SessionId sessionId =  AppiumDriverManager.getDriver().getSessionId();
		GlobalVariable.sessionId = sessionId
		Mobile.comment("sessionId: ${sessionId}")
		if (GlobalVariable.providerAppAndroid.contains("lt:") || GlobalVariable.memberAppAndroid.contains("lt:")) {
			//			def res = lambda.getLambdaSessionDetails1(sessionId)
			//			Mobile.comment("res: ${res}")
			//			Mobile.comment("LambdaUrl: https://appautomation.lambdatest.com/test?testID=${res.data.test_id}")
			Mobile.comment("LambdaUrl: https://appautomation.lambdatest.com/test?testID=${GlobalVariable.sessionId}")
			GlobalVariable.bsResult = GlobalVariable.bsResult +  ' ' + "LambdaUrl: https://appautomation.lambdatest.com/test?testID=${GlobalVariable.sessionId}"
		} else {
			def res = bs.getBrowserStackSessionDetails(sessionId);
			if(res?.automation_session?.browser_url) {
				Mobile.comment("BSUrl: ${res.automation_session.browser_url}")
				GlobalVariable.bsResult = GlobalVariable.bsResult + ' ' + "BSUrl: ${res.automation_session.browser_url}"
			}
		}
	}

	@Keyword
	def tapOnOkayInAppUpdatePopup() {
		try {
			//Mobile.tap(findTestObject('Object Repository/Provider/Login/AppUpdateOkayBtn_'+os), 10);
			Mobile.tap(findTestObject('Object Repository/Provider/Login/appUpdateNoLaterBtn_'+os), defaultTime)
		}
		catch(Exception e){
			println("okay button not there");
		}
	}
	@Keyword
	def verifyOkayInAppUpdatePopup() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Login/AppUpdateOkayBtn_'+os), defaultTime);
	}

	@Keyword
	def swipeUpRightOfScreen() {
		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()

		int startX = device_Width / 2
		int endX = startX
		int startY = device_Height * 0.70  // Change to 70% from the top
		int endY = device_Height * 0.30  // Change to 30% from the top

		// Swipe up
		Mobile.swipe(startX, startY, endX, endY)
	}

	@Keyword
	def swipeDownRightOfScreen() {
		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()

		int dstartX = device_Width / 2
		int dendX = dstartX
		int dstartY = device_Height * 0.30  // Change to 30% from the top
		int dendY = device_Height * 0.70  // Change to 70% from the top

		// Swipe down
		Mobile.swipe(dstartX, dstartY, dendX, dendY)
	}

	@Keyword
	def swipeUpLeftOfScreen() {
		int device_Width = Mobile.getDeviceWidth()
		int device_Height = Mobile.getDeviceHeight()

		int startX = device_Width / 3  // Change to 1/3rd from the left
		int endX = startX
		int startY = device_Height * 0.80  // Change to 80% from the top
		int endY = device_Height * 0.70  // Change to 70% from the top (or adjust as needed)

		// Swipe up on the left side of the screen
		Mobile.swipe(startX, startY, endX, endY)
	}

	@Keyword
	def swipeDownInMiddle() {
		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()

		// Define the position on the right side (50% from the top)
		int dstartX = device_Width * 0.75 // 75% from the left
		int dstartY = device_Height * 0.50 // 50% from the top

		// Define the position in the middle of the right side
		int dendX = dstartX
		int dendY = device_Height * 0.50 // 50% from the top

		// Swipe down
		Mobile.swipe(dstartX, dstartY, dendX, dendY)
	}


	@Keyword
	def swipeDownLeftOfScreen() {
		int device_Width = Mobile.getDeviceWidth()
		int device_Height = Mobile.getDeviceHeight()

		int startX = device_Width / 3  // Change to 1/3rd from the left
		int endX = startX
		int startY = device_Height * 0.70  // Change to 70% from the top
		int endY = device_Height * 0.80  // Change to 80% from the top (or adjust as needed)

		// Swipe down the left side of the screen
		Mobile.swipe(startX, startY, endX, endY)
		Mobile.delay(10);
	}

	@Keyword
	def closeTheApp() {
		//				Mobile.closeApplication();
		//		AppiumDriverManager.getDriver().closeApp()
	}

	@Keyword
	def closeAppAndSetSessionNull() {
		// GlobalVariable.sessionId = null
		Mobile.closeApplication()
	}

	@Keyword
	def verifyURL(String currentURL, String expectedURL) {
		if (currentURL.equals(expectedURL)) {
			println("Current URL matches the expected URL: $expectedURL")
		} else {
			println("Current URL ($currentURL) does not match the expected URL: $expectedURL")
		}
	}


	@Keyword
	def tapBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/backBtn_'+os), 30);
	}

	@Keyword
	def swipeUpLoop(index) {
		for(int i = 0;i < index;i++) {
			swipeUp();
		}
	}

	@Keyword
	def swipeDownLoop(index) {
		for(int i = 0;i < index;i++) {
			swipeDown();
		}
	}

	@Keyword
	def swipeUp() {
		Mobile.delay(3)
		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()

		int startX = device_Width / 2
		int endX = startX
		int startY = device_Height * 0.70  // Change to 70% from the top
		int endY = device_Height * 0.30  // Change to 30% from the top

		// Swipe up
		Mobile.swipe(startX, startY, endX, endY)
		Mobile.delay(1)
	}

	@Keyword
	def swipeUpLittle() {
		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()

		int startX = device_Width / 2
		int endX = startX
		int startY = device_Height * 0.50  // Set to 50% from the top
		int endY = device_Height * 0.25  // Set to a lower percentage to cover 50% of the screen

		// Swipe up
		Mobile.swipe(startX, startY, endX, endY)
		Mobile.delay(1)
	}

	@Keyword
	def swipeUpShort() {
		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()

		int startX = device_Width / 2
		int endX = startX
		int startY = (int) (device_Height * 0.55)  // Set to 55% from the top
		int endY = (int) (device_Height * 0.45)  // Set to 45% from the top

		// Swipe up
		Mobile.swipe(startX, startY, endX, endY)
		Mobile.delay(1)
	}

	@Keyword
	def swipeUpShortLoop(index) {
		for(int i = 0;i < index;i++) {
			swipeUpShort();
		}
	}

	@Keyword
	def swipeDown() {
		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()

		int startX = device_Width / 2
		int startY = device_Height * 0.30  // Change to 30% from the top
		int endX = startX
		int endY = device_Height * 0.70  // Change to 70% from the top

		// Swipe up
		Mobile.swipe(startX, startY, endX, endY)
		Mobile.delay(1)
	}

	@Keyword
	def swipeDownLittle() {
		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()

		int startX = device_Width / 2
		int startY = device_Height * 0.25  // Set to a lower percentage to cover 50% of the screen
		int endX = startX
		int endY = device_Height * 0.50  // Set to 50% from the top

		// Swipe up
		Mobile.swipe(startX, startY, endX, endY)
		Mobile.delay(5)
	}

	// Function to get the suffix for the day
	@Keyword
	def getDaySuffix(int day) {
		def suffix = ""
		if (day >= 11 && day <= 13) {
			suffix = "th"
		} else {
			switch (day % 10) {
				case 1: suffix = "st"; break;
				case 2: suffix = "nd"; break;
				case 3: suffix = "rd"; break;
				default: suffix = "th"; break;
			}
		}
		return suffix
	}

	@Keyword
	def generateRandomEmail() {
		def uuid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5);
		return "autouser_${uuid}@yopmail.com"
	}

	@Keyword
	def generateRandomMobileNumber(String firstFiveDigits = "66904") { //958895
		// Generate random last four digits
		//		def randomLastFourDigits = new Random().nextInt(10000).toString().padLeft(4, '0')
		def randomLastFiveDigitNumber = new Random().nextInt(100000).toString().padLeft(5, '0')
		// Concatenate first six digits and random last four digits
		def newPhoneNumber = "${firstFiveDigits}${randomLastFiveDigitNumber}"

		return newPhoneNumber
	}

	@Keyword
	def verifyElementTextPresentByIndex(Text, index=1, val = 1,onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(val == 1) {
			Mobile.scrollToText(Text, FailureHandling.OPTIONAL)
		}
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/elementTextUsingIndex_android', ['Text': Text, "index": index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyElementTextPresentOld(Text, val = 1,onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(val == 1) {
			Mobile.scrollToText(Text, FailureHandling.OPTIONAL)
		}
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': Text]), defaultTime, onFailure);
	}

	@Keyword
	def verifyElementTextPresent(text, val = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {

		if(val == 1) {
			Mobile.scrollToText(text, FailureHandling.OPTIONAL)
		}

		def failureMessage = "Expected text not found: ${text}"
		TestObject element = findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': text])

		if(onFailure == FailureHandling.CONTINUE_ON_FAILURE){
			util.verifyElementPresentAndContinueOnFailure(element, failureMessage, defaultTime)
		}
		else if(onFailure == FailureHandling.OPTIONAL) {
			return Mobile.verifyElementExist(element, defaultTime, onFailure);
		}
		else {
			util.verifyElementPresent(element, failureMessage, defaultTime)
		}
	}

	@Keyword
	def verifyElementTxtWithoutScroll(Text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': Text]), defaultTime, onFailure);
	}
	@Keyword
	def verifyElementTextNotPresent(Text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': Text]), defaultTime, onFailure);
	}

	@Keyword
	def verifyElementTextPresentWithScroll(Text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText(Text, FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': Text]), defaultTime, onFailure);
	}

	// Function to convert date and time from one timezone to GMT
	@Keyword
	def convertToTimezone(dateTime, currentTimezone = "EST", convertTimezone = "GMT") {
		// Define date format
		def dateFormat = new SimpleDateFormat("MMMM dd, yyyy, h:mm a")
		if (currentTimezone == 'EST' || currentTimezone == 'EDT') {
			// Set input timezone
			dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"))
		} else if(currentTimezone == 'CST') {
			def inputTimeZone = TimeZone.getTimeZone(currentTimezone)
			dateFormat.setTimeZone(inputTimeZone)
		} else if (currentTimezone == 'CDT') {
			dateFormat.setTimeZone(TimeZone.getTimeZone("America/Chicago"))
		} else if (currentTimezone == 'PST') {
			dateFormat.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"))
		}
		else {
			dateFormat.setTimeZone(TimeZone.getTimeZone(currentTimezone))
		}
		// Parse input date and time
		def parsedDateTime = dateFormat.parse(dateTime)

		// Set output timezone
		dateFormat.setTimeZone(TimeZone.getTimeZone(convertTimezone))

		// Format parsed date and time to the desired timezone
		def convertedDateTime = dateFormat.format(parsedDateTime)

		return convertedDateTime
	}

	@Keyword
	def getProviderApptTimings(providerDate, dm) {
		def duration;
		def timeRange;
		def parts = providerDate.split(',')
		def dateTimePart = parts[0].trim().split(' ')
		def day = Integer.parseInt(dateTimePart[1].replaceAll("\\D", "")) // Parse as integer to remove leading zeros
		def daySuffix = getDaySuffix(day.toInteger())
		def month = dateTimePart[0]
		def year = parts[1].trim()
		def time = parts[2].toLowerCase().trim()
		def providerDateTime = "${month} ${day}${daySuffix}, ${year}"
		//println("dateTime1 : ${dateTime1}" )
		println("providerDateTime : ${providerDateTime}" )

		def time1 = time.split(":")[0]+ time.split(" ")[1].toUpperCase()
		if(dm == "Telemedicine" || dm == "Facility") {
			duration = 15
			timeRange = getTimeRanze(time, duration)
		}
		else {
			duration = 60
			timeRange = getTimeRanze(time, duration)
		}
		Mobile.comment("TimeRange:"+timeRange)
		return timeRange
	}

	@Keyword
	def  convertDateToFormat(dateTime, format = 'MMMM dd, yyyy, h:mm a') {
		def inputFormat = new SimpleDateFormat('MMMM dd, yyyy, h:mm a')
		def outputFormat = new SimpleDateFormat(format)
		def formattedDate = outputFormat.format(inputFormat.parse(dateTime))
		return formattedDate
	}

	@Keyword
	def getTimezone(dateTimeWithTimezone) {
		//	Example format to pass as parameter: "February 29, 2024, 12:00 AM PST"
		return (dateTimeWithTimezone =~ /\b([A-Z]{3})\b/)[0][1]
	}

	@Keyword
	def getTimeRanze(timeSlot, timegap) {
		// Parse the input time
		LocalTime startTime = LocalTime.parse(timeSlot.toUpperCase(), DateTimeFormatter.ofPattern("h:mm a"));
		LocalTime endTime = startTime.plusMinutes(timegap);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
		//	Example format to pass as parameter: "February 29, 2024, 12:00 AM PST"
		return startTime.format(formatter).toLowerCase() +" - " + endTime.format(formatter).toLowerCase()
	}

	@Keyword
	def waitForRevdocLoaderToDisappear() {
		int count = 0;
		while(Mobile.waitForElementPresent(findTestObject('Object Repository/revdocLoadingIcon_android'), 5, FailureHandling.OPTIONAL) && count<=2){
			Mobile.delay(15);
			count = count + 1;
		}
		//Mobile.waitForElementNotPresent(findTestObject('Object Repository/revdocLoadingIcon_android'), 30,  FailureHandling.OPTIONAL);
	}

	@Keyword
	def getRevoneApptPrice(deliveryRateFee, procedureFee, pharmaceuticalMaterialFinalPrice, revOneAdminFeePercentage) {
		def totalRevoneCost = (deliveryRateFee + procedureFee + pharmaceuticalMaterialFinalPrice) * (1 + revOneAdminFeePercentage);
		return Math.round(totalRevoneCost * 100.0) / 100.0;
	}

	@Keyword
	def getRevPlusApptPrice(deliveryRateFee, procedureFee, pharmaceuticalMaterialFinalPrice, revPlusAdminFeePercentage) {
		def totalRevplusCost = (deliveryRateFee + procedureFee + pharmaceuticalMaterialFinalPrice) * (1 + revPlusAdminFeePercentage);
		return Math.round(totalRevplusCost * 100.0) / 100.0;
	}

	@Keyword
	def revPlusCardPrice(totalrevOneUsd, totalrevPlusUsd) {
		return (totalrevOneUsd - totalrevPlusUsd)
	}

	@Keyword
	def convertTo12HourFormat(time24) {
		def time = time24.split(":")
		def hour = time[0].trim().toInteger()
		def minute = time[1].trim()

		def period = (hour < 12) ? "AM" : "PM"

		if (hour == 0) {
			hour = 12
		} else if (hour > 12) {
			hour -= 12
		}

		return "${hour}:${minute} ${period}"
	}

	@Keyword
	Date getNextWeekday(int weekday = Calendar.MONDAY) {
		// Get today's date
		def today = Calendar.instance

		// Find today's day of the week
		def currentDayOfWeek = today.get(Calendar.DAY_OF_WEEK)

		// Calculate the difference needed to reach the specified weekday
		def daysToAdd = (weekday - currentDayOfWeek + 7) % 7

		// Add the calculated number of days to reach the specified weekday
		today.add(Calendar.DAY_OF_MONTH, daysToAdd)

		// Get the result
		return today.time
	}

	@Keyword
	def clickOnBackBtn() {
		Mobile.delay(3)
		Mobile.waitForElementPresent(findTestObject('Object Repository/Provider/Provider360/MyProviderRelationManager/backBtn_android'), defaultTime);
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MyProviderRelationManager/backBtn_android'), defaultTime);
	}

	@Keyword
	def swipeBack() {
		int deviceHeight = Mobile.getDeviceHeight()
		int deviceWidth = Mobile.getDeviceWidth();
		// Define the starting and ending coordinates for the swipe
		int startX = 50 // Adjust as needed based on the desired starting position
		int startY = deviceHeight / 2 // Swipe vertically at the middle of the screen
		int endX = deviceWidth - 50 // Adjust as needed based on the desired ending position
		int endY = startY

		// Swipe from the left edge of the screen to the right edge
		Mobile.swipe(startX, startY, endX, endY)
	}
	@Keyword
	def capitalizeFirstLetter(String input) {
		if (input == null || input.isEmpty()) {
			return input;
		}
		return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
	}

	@Keyword
	def static byte[] convertToByteCode(String filePath) {
		byte[] byteArray = null;
		FileInputStream fis = null;
		try {
			File file = new File(filePath);
			fis = new FileInputStream(file);
			byteArray = new byte[(int) file.length()];
			fis.read(byteArray);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return byteArray;
	}

	@Keyword
	def boolean compareByteCode(byte[] byteCode1, byte[] byteCode2) {
		if (byteCode1.length != byteCode2.length) {
			return false;
		}
		for (int i = 0; i < byteCode1.length; i++) {
			if (byteCode1[i] != byteCode2[i]) {
				return false;
			}
		}
		return true;
	}

	@Keyword
	def saveFile(byte[] data, String filePath) {
		try {
			Files.write(Paths.get(filePath), data)
			println("File saved successfully at: " + filePath)
		} catch (Exception e) {
			println("Error saving file: " + e.getMessage())
		}
	}

	@Keyword
	def swipeUpWithinElement() {
		try {
			// Get the element's properties
			int elementHeight = Mobile.getElementHeight(findTestObject('Object Repository/Provider/Calendar/PatientHealthRecord/swipePopup_android'), defaultTime)
			int elementWidth = Mobile.getElementWidth(findTestObject('Object Repository/Provider/Calendar/PatientHealthRecord/swipePopup_android'), defaultTime)
			int elementLeft = Mobile.getElementLeftPosition(findTestObject('Object Repository/Provider/Calendar/PatientHealthRecord/swipePopup_android'), defaultTime)
			int elementTop = Mobile.getElementTopPosition(findTestObject('Object Repository/Provider/Calendar/PatientHealthRecord/swipePopup_android'), defaultTime)

			// Calculate the coordinates for the swipe
			int startX = elementLeft + (elementWidth / 2)
			int endX = startX
			int startY = elementTop + (elementHeight / 2) // Start from the middle of the element
			int endY = 0 // Swipe to the top of the screen
			// Perform the swipe action
			Mobile.swipe(startX, startY, endX, endY)
			Mobile.delay(1)
		} catch (Exception e) {
			println("Failed to swipe up within element: " + e.message)
		}
	}

	//addMonthsForCurrentDate
	@Keyword
	def addMonthsToCurrentDate(month, fmt) {
		Date currentDate = new Date()
		int monthToAdd = month

		Calendar calendar = Calendar.getInstance()
		calendar.setTime(currentDate)

		// Add months to the current date
		calendar.add(Calendar.MONTH, monthToAdd)

		// Get the date after adding months
		Date futureDate = calendar.getTime()

		SimpleDateFormat dateFormat = new SimpleDateFormat(fmt)
		String formattedFutureMonth = dateFormat.format(futureDate)
		return formattedFutureMonth
	}

	//addDaysToCurrentDate
	@Keyword
	def addDaysToCurrentDateInSeekBar(days, fmt) {
		Date currentDate = new Date()
		SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM")
		String currentMonth = monthFormat.format(currentDate)

		int daysToAdd = days

		Calendar calendar = Calendar.getInstance()
		calendar.setTime(currentDate)

		// Add months to the current date
		calendar.add(Calendar.DATE, daysToAdd)

		// Get the date after adding months
		Date futureDate = calendar.getTime()

		SimpleDateFormat dateFormat = new SimpleDateFormat(fmt)
		String formattedFutureDate = dateFormat.format(futureDate)

		// Split the date string to get the month
		String[] dateParts = formattedFutureDate.split(" ")

		// The month will be the second part (index 1) of the split array
		String month = dateParts[1]
		//declaring empty array
		String[] onlyDate = []

		if(month != currentMonth) {
			return dateParts
		}
		else {
			onlyDate += dateParts[0]
			return onlyDate
		}

	}

	@Keyword
	def addMonthsInSeekBar(int months){
		Date currentDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);

		// Add months to the current date
		calendar.add(Calendar.MONTH, months);

		// Get the date after adding months
		Date futureDate = calendar.getTime();

		// Format the date to include both month and year
		SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		String month = monthFormat.format(futureDate);
		String year = yearFormat.format(futureDate);
		String currentYear = yearFormat.format(currentDate);


		return [month: month, year: year, currentYear: currentYear];
	}


	@Keyword
	def addMonths(int months)
	{
		Date currentDate = new Date()
		Calendar calendar = Calendar.getInstance()
		calendar.setTime(currentDate)
		// Add months to the current date
		calendar.add(Calendar.MONTH, months)
		// Get the date after adding months
		Date futureDate = calendar.getTime()
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM")
		def formattedFutureDate = dateFormat.format(futureDate)

		return formattedFutureDate;
	}

	@Keyword
	def addMonthsFormat(int months)
	{
		Date currentDate = new Date()
		Calendar calendar = Calendar.getInstance()
		calendar.setTime(currentDate)
		// Add months to the current date
		calendar.add(Calendar.MONTH, months)
		// Get the date after adding months
		Date futureDate = calendar.getTime()
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM")
		def formattedFutureDate = dateFormat.format(futureDate)
		SimpleDateFormat dateMonthFormat = new SimpleDateFormat("MM/dd/yyyy")
		String formattedFutureDateMonth = dateMonthFormat.format(futureDate)

		return [formattedFutureDate: formattedFutureDate, formattedFutureDateMonth: formattedFutureDateMonth]
	}

	@Keyword
	def addDaysToCurrentDate(daysToAdd, formate = "MMMM dd, yyyy") {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))

		// Reset time of day to midnight
		calendar.set(Calendar.HOUR_OF_DAY, 0)
		calendar.set(Calendar.MINUTE, 0)
		calendar.set(Calendar.SECOND, 0)
		calendar.set(Calendar.MILLISECOND, 0)
		calendar.add(Calendar.DAY_OF_YEAR, daysToAdd) // Subtract 1 day to get yesterday's date if add plus 1 day to get tomorrow date
		Date yesterday = calendar.time

		// Define format
		SimpleDateFormat dateFormat1 = new SimpleDateFormat(formate)

		// Format yesterday's date
		String formattedYesterday = dateFormat1.format(yesterday)

		// Print formatted yesterday's date
		println("Yesterday's Date: " + formattedYesterday)

		return formattedYesterday;

	}

	@Keyword
	def getDayOfWeekByAddingDaysToCurrentDate(int daysToAdd) {
		// Get the current date
		Date currentDate = new Date();

		// Create a Calendar instance and set it to the current date
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);

		// Add one day to get tomorrow's date
		calendar.add(Calendar.DAY_OF_YEAR, daysToAdd);
		Date tomorrowDate = calendar.getTime();

		// Create SimpleDateFormat to format the date to get the day of the week
		SimpleDateFormat dayOfWeekFormat = new SimpleDateFormat("EEEE", Locale.ENGLISH);

		// Format the parsed date to get the day of the week
		return dayOfWeekFormat.format(tomorrowDate);
	}

	@Keyword
	def generateRandomString(int length) {
		def chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789'
		def random = new Random()
		def sb = new StringBuilder()
		(1..length).each {
			sb.append(chars[random.nextInt(chars.length())])
		}
		return sb.toString()
	}

	@Keyword
	def generateRandomNumericString(int length) {
		def digits = '0123456789'
		def random = new Random()
		def sb = new StringBuilder()
		(1..length).each {
			sb.append(digits[random.nextInt(digits.length())])
		}
		return sb.toString()
	}

	@Keyword
	def static Map<String, String> getEffectiveAndTermDates(addDaysToEffectiveDate = -1, addDaysToTermDate = 3) {
		def dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"))

		// Get the current date and set it to yesterday
		def calendar = Calendar.getInstance()
		calendar.add(Calendar.DAY_OF_MONTH, addDaysToEffectiveDate)
		def yesterdayDate = calendar.time
		def effectiveDate = dateFormat.format(yesterdayDate)

		// Get the date two days from yesterday
		calendar.add(Calendar.DAY_OF_MONTH, addDaysToTermDate)
		def dateAfterTwoDays = calendar.time
		def termDate = dateFormat.format(dateAfterTwoDays)

		return [effectiveDate: effectiveDate, termDate: termDate]
	}

	@Keyword
	def getCurrentMonthAndYear() {
		def currentDate = LocalDate.now()
		def currentMonth = currentDate.format(DateTimeFormatter.ofPattern("MMMM"))
		def currentYear = currentDate.year
		return [currentMonth: currentMonth, currentYear:currentYear]
	}

	@Keyword
	def calculateThePercentageValue(percentage, price) {
		String stringValue = percentage.trim()
		int numberPart = stringValue.replace("%", "").toInteger()
		println(numberPart)
		double value = price*(numberPart / 100) ;
		println(value)
		price = price-Math.ceil(value);
		println(price)
		int finalPrice = Math.ceil(price)
		return finalPrice
	}

	@Keyword
	def generateRandomAlphabets(int length) {
		def random = new Random()
		def alphabet = ('A'..'Z') + ('a'..'z')  // Combine uppercase and lowercase letters
		def randomString = (1..length).collect { alphabet[random.nextInt(alphabet.size())] }.join()
		return randomString
	}

	@Keyword
	def parseJsonFile(filePath) {
		// Read and parse JSON file
		def slurper = new JsonSlurper()
		return slurper.parse(new File(filePath))
	}

	@Keyword
	def tapOnChromeAndEnterTheDeeplink(link) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/chromeBrowser_andriod'), 30)
		Mobile.setText(findTestObject('Object Repository/Member/HomePage/MyPrograms/chromeSearchBox_andriod'), link, 30)
	}

	@Keyword
	def formatAndRoundPriceValue(String amount) {
		if(amount.contains('/mo')) {
			amount = amount.replace('/mo', '')
		}
		// Remove the $ sign and convert to BigDecimal

		def value = amount.replace('$', '').replace(',', '').toBigDecimal()

		// Handle negative value placement
		def isNegative = value < 0

		if (value.remainder(BigDecimal.ONE) == BigDecimal.ZERO) {
			// If there's no decimal value, return formatted without decimal
			return String.format("%s\$%.0f", isNegative ? "-" : "", Math.abs(value))
		} else if(value== 0 || value== 0.00 || value== 0.0) {
			return '$0'
		} else {
			// For negative values, round towards zero (truncate), and for positive, round up
			def roundedValue = isNegative ? value.setScale(0, BigDecimal.ROUND_DOWN) : value.setScale(0, BigDecimal.ROUND_UP)
			return String.format("%s\$%.0f", isNegative ? "-" : "", Math.abs(roundedValue))
		}
	}

	@Keyword
	def removeDecimal(String amount) {
		// Remove the $ sign, convert to BigDecimal, and then cast to an integer
		def value = amount.replace('$', '').toBigDecimal().intValue()

		// Return formatted string with $ and without decimal
		return String.format("\$%d", value)
	}

	@Keyword
	def getUserTestData(name) {
		def jsonFile = new File('TestData/testData.json')

		// Parse the JSON file content
		def jsonSlurper = new JsonSlurper()
		def jsonData = jsonSlurper.parse(jsonFile)

		// Access variables from the JSON file
		def value = jsonData[name].key
		return value
	}

	@Keyword
	def formatAmountWithCommas(String amountString) {
		// Remove the $ symbol and convert the string to an integer
		def amount = amountString.replaceAll("[^0-9]", "").toInteger()

		// Format the amount with commas
		def formattedAmount = NumberFormat.getNumberInstance(Locale.US).format(amount)

		// Add back the $ symbol in front of the formatted number
		def finalFormattedAmount = "\$${formattedAmount}"

		// Return the formatted amount
		println(finalFormattedAmount:finalFormattedAmount)
		return finalFormattedAmount
	}

	@Keyword
	def getMichiganCurrentTime() {
		def dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a")

		// Set the timezone to Eastern Time (Michigan's timezone)
		def michiganTimeZone = TimeZone.getTimeZone("America/Detroit")
		dateFormat.setTimeZone(michiganTimeZone)

		// Get the current date and time in the Michigan timezone
		def michiganTime = dateFormat.format(new Date())

		println("Current time in Michigan: $michiganTime")

		def inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a")

		// Parse the input date string to a Date object
		def date = inputFormat.parse(michiganTime)

		// Create a Calendar instance and set the parsed date
		def calendar = Calendar.getInstance()
		calendar.setTime(date)
		return date
	}

	@Keyword
	def addHoursAndFormatTime(roundedTime, hours = 1) {
		def outputFormat = new SimpleDateFormat("h:mm a")
		def calendar = Calendar.getInstance()
		calendar.time = roundedTime
		calendar.add(Calendar.HOUR_OF_DAY, hours)
		// Format the updated date-time to the desired output format
		def updatedTime = outputFormat.format(calendar.getTime())

		println("Updated time: $updatedTime")
		return updatedTime
	}

	@Keyword
	def addMinutesAndFormatTime(roundedTime, minutes) {
		def outputFormat = new SimpleDateFormat("h:mm a")
		def calendar = Calendar.getInstance()
		calendar.time = roundedTime
		calendar.add(Calendar.MINUTE, minutes)
		// Format the updated date-time to the desired output format
		def updatedTime = outputFormat.format(calendar.getTime())

		println("Updated time: $updatedTime")

		return updatedTime
	}

	@Keyword
	def convertAndFormatToSignNoteEncounterTime(hoursToSubtract) {
		// Get the current time in IST
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

		// Subtract hours
		calendar.add(Calendar.HOUR_OF_DAY, -hoursToSubtract);

		// Round up to the nearest quarter-hour
		int minutes = calendar.get(Calendar.MINUTE);
		int remainder = minutes % 15;
		if (remainder != 0) {
			calendar.add(Calendar.MINUTE, 15 - remainder);
		}
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		// Format the time in HH:mm for UTC
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		String shortTime = timeFormat.format(calendar.getTime());

		// Format only the date part in yyyy-MM-dd for UTC
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		String dateOnly = dateFormat.format(calendar.getTime());

		// Format only the day part in d for UTC
		SimpleDateFormat dayFormat = new SimpleDateFormat("d");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		String dayOnly = dayFormat.format(calendar.getTime());

		// Format the time in ISO 8601 with milliseconds and 'Z' for UTC
		SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		String formattedTime = isoFormat.format(calendar.getTime());

		println("{\"startDate\":\"" + formattedTime + "\"}");
		return [formattedTime: formattedTime, shortTime: shortTime, dateOnly: dateOnly, dayOnly:dayOnly];
	}

	@Keyword
	def convertUTCinProviderCalendarTime(dateTime) {
		// Original date string
		//String startDate = "2024-11-15T05:00:00.608Z"

		// Parse the ISO 8601 string into a Date object
		SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
		isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"))
		Date date = isoFormat.parse(dateTime)

		// Use Calendar to manipulate the time
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
		calendar.setTime(date)

		// Add 5 hours and 30 minutes
		calendar.add(Calendar.HOUR, 5)
		calendar.add(Calendar.MINUTE, 30)

		// Format the date part in 'd' format
		SimpleDateFormat dateOnlyFormat = new SimpleDateFormat("d")
		dateOnlyFormat.setTimeZone(TimeZone.getTimeZone("UTC"))
		String dateOnly = dateOnlyFormat.format(calendar.getTime())

		// Format the time part in am/pm format
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a")
		timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"))
		String timeInAmPm = timeFormat.format(calendar.getTime())

		// Output results
		println "Date in 'd' format: ${dateOnly}"
		println "Time in am/pm format: ${timeInAmPm}"

		// Return as a map if needed
		return [dateOnly: dateOnly, timeInAmPm: timeInAmPm]

	}

	@Keyword
	def convertTo12HourRange(String isoTime) {
		// Parse the input ISO 8601 time string
		ZonedDateTime zonedDateTime = ZonedDateTime.parse(isoTime)

		// Format the start time in 12-hour format
		String startTime = zonedDateTime.format(DateTimeFormatter.ofPattern("h:mm a").withLocale(Locale.ENGLISH)).toLowerCase()

		// Add 1 hour to the original time
		ZonedDateTime endDateTime = zonedDateTime.plusHours(1)

		// Format the end time in 12-hour format
		String endTime = endDateTime.format(DateTimeFormatter.ofPattern("h:mm a").withLocale(Locale.ENGLISH)).toLowerCase()

		// Return the range as "start time - end time"
		return "$startTime - $endTime"
	}

	@Keyword
	def roundOffToNextQuarter(date) {
		def calendar = Calendar.getInstance()
		calendar.setTime(date)
		int minutes = calendar.get(Calendar.MINUTE)
		if (minutes > 0) {
			int remainder = minutes % 15
			if (remainder != 0) {
				// Always round up to the next quarter
				calendar.add(Calendar.MINUTE, 15 - remainder)
			}
		}
		return calendar.time
	}

	@Keyword
	def convertISOToFormattedDate(String isoDate) {
		// Parse the ISO 8601 date string
		SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
		isoFormat.setTimeZone(TimeZone.getDefault()) // Use local time zone
		Date parsedDate = isoFormat.parse(isoDate)

		// Initialize a Calendar instance with the parsed date
		Calendar calendar = Calendar.getInstance()
		calendar.setTime(parsedDate)

		// Get the day of the month
		int day = calendar.get(Calendar.DAY_OF_MONTH)

		// Determine the day suffix (st, nd, rd, th)
		String daySuffix
		if (day in [11, 12, 13]) {
			daySuffix = "th" // Special case for 11th, 12th, 13th
		} else {
			switch (day % 10) {
				case 1:
					daySuffix = "st"
					break
				case 2:
					daySuffix = "nd"
					break
				case 3:
					daySuffix = "rd"
					break
				default:
					daySuffix = "th"
			}
		}

		// Format the date to the desired output
		SimpleDateFormat targetFormat = new SimpleDateFormat("MMMM d',' yyyy',' h:mm a")
		targetFormat.setTimeZone(TimeZone.getDefault()) // Maintain local time zone

		// Get the formatted date
		String formattedDate = targetFormat.format(calendar.getTime())

		// Insert the day suffix
		formattedDate = formattedDate.replaceFirst("\\d+", day + daySuffix)

		formattedDate = formattedDate.replaceAll("AM", "am").replaceAll("PM", "pm")

		// Return the result
		return formattedDate
	}

	@Keyword
	def convertToFormatDate(String inputDate) {
		try {
			// Predefined input and target date formats
			String inputFormat = "MMMM dd, yyyy, h:mm a z"  // Input: "November 02, 2024, 3:45 PM EST"
			String targetFormat = "MMMM d, yyyy, h:mm a z"  // Output: "November 2, 2024, 3:45 PM EST"

			// Create the input and output formatters
			SimpleDateFormat inputFormatter = new SimpleDateFormat(inputFormat)

			// Parse the input date
			Date date = inputFormatter.parse(inputDate)

			// Extract the time zone from the input
			String timeZoneId = inputDate.replaceAll(/^.*\s([A-Za-z]{3,4})$/, '$1')

			// Set the output formatter with the extracted time zone
			SimpleDateFormat targetFormatter = new SimpleDateFormat(targetFormat)
			targetFormatter.setTimeZone(TimeZone.getTimeZone(timeZoneId))  // Use extracted time zone

			// Format the date into the desired format and return
			return targetFormatter.format(date)
		} catch (Exception e) {
			println("Error converting date format: " + e.message)
			return null
		}
	}

	@Keyword
	def formatToTwoDigitDay(String inputDate) {
		try {
			// Define input and target formats
			SimpleDateFormat inputFormat = new SimpleDateFormat("MMM d, yyyy")
			SimpleDateFormat targetFormat = new SimpleDateFormat("MMM dd, yyyy")

			// Parse and format the date
			Date date = inputFormat.parse(inputDate)
			return targetFormat.format(date)
		} catch (Exception e) {
			println("Error formatting date: " + e.message)
			return null
		}
	}

	@Keyword
	def roundAndAddTime(String dateStr, int minutesToAdd) {
		try {
			// Define date formats
			SimpleDateFormat fullFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy")
			SimpleDateFormat shortFormat = new SimpleDateFormat("h:mm a")

			// Parse the input date string
			Date date = fullFormat.parse(dateStr)

			// Create a calendar instance
			Calendar cal = Calendar.getInstance()
			cal.setTime(date)

			// Round to the nearest positive quarter-hour
			int minutes = cal.get(Calendar.MINUTE)
			int roundedMinutes = ((minutes + 7) / 15) * 15
			cal.set(Calendar.MINUTE, roundedMinutes)
			cal.set(Calendar.SECOND, 0)

			// Add specified minutes
			cal.add(Calendar.MINUTE, minutesToAdd)

			// Format results
			String fullTime = fullFormat.format(cal.getTime())
			String shortTime = shortFormat.format(cal.getTime())

			// Print results
			println("Full Format: " + fullTime)
			println("Short Format: " + shortTime)

			return "Full: ${fullTime}, Short: ${shortTime}"
		} catch (Exception e) {
			println("Error: " + e.getMessage())
			return null
		}
	}

	@Keyword
	def getRoundedAppointmentTimes(){
		// Get the current UTC time
		ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"))

		// Round to the nearest 30-minute interval
		int currentMinutes = now.getMinute()
		int roundedMinutes = (currentMinutes < 15) ? 0 : (currentMinutes < 45 ? 30 : 60)
		ZonedDateTime roundedTime = now.truncatedTo(ChronoUnit.HOURS).plusMinutes(roundedMinutes)

		// Calculate the start and end of the interval
		ZonedDateTime value1Time = roundedTime.minusMinutes(30)
		ZonedDateTime value2Time = roundedTime

		// Format the output in the desired format (ISO-8601 with milliseconds and 'Z' for UTC)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
		String value1 = value1Time.format(formatter)
		String value2 = value2Time.format(formatter)

		// Log the output values
		println "----- Generated appt start time = ${value1}"
		println "----- Generated appt end time = ${value2}"
		return [apptStartTime: value1, apptEndTime: value2];
	}
}
