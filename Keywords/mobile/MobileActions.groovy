package mobile

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import java.awt.Image
import java.awt.Toolkit
import java.awt.image.BufferedImage
import java.awt.image.PixelGrabber

import com.kms.katalon.core.configuration.RunConfiguration

import internal.GlobalVariable
import java.security.SecureRandom

import javax.imageio.ImageIO

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebElement

public class MobileActions extends Utility{

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Generic gen = new Generic()

	@Keyword
	def tap(TestObject element) {
		Mobile.waitForElementPresent(element, defaultTime);
		Mobile.tap(element, defaultTime);
	}

	@Keyword
	def verifyScreenshotMatchesWithElementScreenshot(beforeImageFilePath, testObject) {
		def Image2 = Mobile.takeElementScreenshot(beforeImageFilePath, testObject)

		byte[] bytecode1 = gen.convertToByteCode(beforeImageFilePath);
		byte[] bytecode2 = gen.convertToByteCode(Image2);

		Mobile.verifyEqual(gen.compareByteCode(bytecode1, bytecode2), true)
		Mobile.verifyEqual(bytecode1, bytecode2)
	}
	@Keyword
	def verifyImagesNotEqual(String actualImagePath, String expectedImagePath) {
		// Load the images
		Image image1 = Toolkit.getDefaultToolkit().getImage(actualImagePath)
		Image image2 = Toolkit.getDefaultToolkit().getImage(expectedImagePath)

		// Grab pixels from the images
		PixelGrabber grab1 = new PixelGrabber(image1, 0, 0, -1, -1, false)
		PixelGrabber grab2 = new PixelGrabber(image2, 0, 0, -1, -1, false)

		if (grab1.grabPixels() && grab2.grabPixels()) {
			int width1 = grab1.getWidth()
			int height1 = grab1.getHeight()
			int[] data1 = new int[width1 * height1]
			data1 = (int[]) grab1.getPixels()

			int width2 = grab2.getWidth()
			int height2 = grab2.getHeight()
			int[] data2 = new int[width2 * height2]
			data2 = (int[]) grab2.getPixels()

			// Return the result of the comparison
			boolean areEqual = Arrays.equals(data1, data2)
			Mobile.verifyNotEqual(areEqual, true)
		}
	}

	@Keyword
	def verifyImagePresent(filePath) {
		Mobile.verifyImagePresent(filePath)
	}

	@Keyword
	def tapOnElementByText(Text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText(Text, FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': Text]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnElementByTextUsingIndex(Text, index, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/elementTextUsingIndex_android', ['Text': Text, 'index': index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyElementPresentByTextOld(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': text]), defaultTime, onFailure);
	}

	@Keyword
	def verifyElementPresentByText(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {

		def failureMessage = "Element with text '${text}' not present"
		TestObject element = findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': text])

		if(onFailure == FailureHandling.CONTINUE_ON_FAILURE){
			verifyElementPresentAndContinueOnFailure(element, failureMessage, defaultTime)
		}
		else if(onFailure == FailureHandling.OPTIONAL) {
			return Mobile.verifyElementExist(element, defaultTime, onFailure);
		}
		else {
			verifyElementPresent(element, failureMessage, defaultTime)
		}
	}

	@Keyword
	def verifyElementNotPresentByText(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = 15) {
		def failureMessage = "Element with text '${text}' present"
		TestObject element = findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': text])

		if(onFailure == FailureHandling.CONTINUE_ON_FAILURE){
			verifyElementNotPresentAndContinueOnFailure(element, failureMessage, defaultTime)
		}
		else if(onFailure == FailureHandling.OPTIONAL) {
			return Mobile.verifyElementNotExist(element, defaultTime, onFailure);
		}
		else {
			verifyElementNotPresent(element, failureMessage, defaultTime)
		}
	}
	@Keyword
	def verifyTextViewScreenTitle(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/Checkout/NotesPage/screenTitle_android'), text, FailureHandling.STOP_ON_FAILURE);
	}

	//waituntiltext on a btn visble after loading icon
	@Keyword
	def waitForTextVisible(TestObject testObject, String expectedText, int timeout, failureHandling) {
		KeywordLogger log = new KeywordLogger()
		int elapsedTime = 0
		boolean isTextVisible = false
		while (elapsedTime < timeout) {
			try {
				String actualText = Mobile.getText(testObject, 10)
				if (actualText == expectedText) {
					isTextVisible = true
					break
				}
			} catch (Exception e) {
				println("Text not found yet. Retrying...")
			}
			Mobile.delay(5)
			elapsedTime++
		}
		if (isTextVisible) {
			KeywordUtil.logInfo("The text is visible: " + expectedText)
		} else {
			KeywordUtil.markFailed("The text is not visible within the timeout period: " + expectedText)
		}

		return isTextVisible
	}

	@Keyword
	def scrollUntilElementIsVisible(element, iterations = 35, waitTime = 5) {
		boolean elementFound = false
		int iterationCounter = 0
		while (!elementFound && iterationCounter < iterations) {
			try {
				elementFound = Mobile.verifyElementVisible(element, waitTime, FailureHandling.OPTIONAL)
			} catch (Exception e) {
				elementFound = false
			}
			if (!elementFound) {
				println("Element not found, swiping up")
				gen.swipeUpLittle()
			} else {
				println("Element found!")
			}
			iterationCounter++
			println("Iteration: " + iterationCounter)
		}
	}

	@Keyword
	def scrollDownUntilElementIsVisible(element, iterations = 15, waitTime = 5) {
		boolean elementFound = false
		int iterationCounter = 0
		while (!elementFound && iterationCounter < iterations) {
			try {
				elementFound = Mobile.verifyElementVisible(element, waitTime, FailureHandling.OPTIONAL)
			} catch (Exception e) {
				elementFound = false
			}
			if (!elementFound) {
				println("Element not found, swiping up")
				gen.swipeDownLittle()
			} else {
				println("Element found!")
			}
			iterationCounter++
			println("Iteration: " + iterationCounter)
		}
	}

	@Keyword
	def swipeUpLittleIfElementIsNotVisible(TestObject element) {
		if(Mobile.verifyElementNotExist(element, 20, FailureHandling.OPTIONAL)) {
			gen.swipeUpLittle();
		}
	}

	@Keyword
	def verifyScreenTitleText(text, index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/My Address/ScreenTitle_android', ["index":index]), text, onFailure);
	}

	@Keyword
	def scrollHorizontallyToSpecificTextFromRightToLeft(TestObject object, text, iterations = 10, defaultTime = defaultTime) {
		def eHeight = Mobile.getElementHeight(object, defaultTime)
		def eWidth = Mobile.getElementWidth(object, defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(object, defaultTime)
		def eTopPos = Mobile.getElementTopPosition(object, defaultTime)

		// Define the start and end positions for swiping right to left
		def startx = eLeftPos + eWidth - 250
		def starty = (eTopPos + (eHeight / 2)).toInteger()
		def endx = eLeftPos + 50
		def endy = starty
		int i = 1

		// Swipe from right to left until the element is found or the limit is reached
		while (!verifyElementPresentByText(text, FailureHandling.OPTIONAL, 5) && i < iterations) {
			i = i + 1
			Mobile.swipe(startx, starty, endx, endy, FailureHandling.OPTIONAL)
		}

		if (i >= iterations) {
			return false
		}

		return true
	}

	@Keyword
	def scrollHorizontallyToSpecificElementFromRightToLeft(TestObject scrollObj, TestObject elementObj, iterations = 20, defaultTime = defaultTime) {
		def eHeight = Mobile.getElementHeight(scrollObj, defaultTime)
		def eWidth = Mobile.getElementWidth(scrollObj, defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(scrollObj, defaultTime)
		def eTopPos = Mobile.getElementTopPosition(scrollObj, defaultTime)

		// Define the start and end positions for swiping right to left
		//		def startx = eLeftPos + eWidth - 250
		//		def starty = (eTopPos + (eHeight / 2)).toInteger()
		//		def endx = eLeftPos + 50
		//		def endy = starty
		//		int i = 1

		// Adjust the scroll length to 70% by modifying the start and end positions
		def startx = eLeftPos + (eWidth * 0.7).toInteger()  // Start at 70% of the width
		def starty = (eTopPos + (eHeight / 2)).toInteger()
		def endx = eLeftPos + (eWidth * 0.3).toInteger()    // End at 30% of the width
		def endy = starty
		int i = 1

		// Swipe from right to left until the element is found or the limit is reached

		while (!Mobile.verifyElementExist(elementObj, 5, FailureHandling.OPTIONAL) && i < iterations) {
			i = i + 1
			Mobile.swipe(startx, starty, endx, endy, FailureHandling.OPTIONAL)
		}

		if (i >= iterations) {
			return false
		}

		return true
	}

	@Keyword
	def scrollHorizontallyToSpecificElementFromLeftToRight(TestObject scrollObj, TestObject elementObj, iterations = 20, defaultTime = defaultTime) {
		// Get the element's height, width, and position
		def eHeight = Mobile.getElementHeight(scrollObj, defaultTime)
		def eWidth = Mobile.getElementWidth(scrollObj, defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(scrollObj, defaultTime)
		def eTopPos = Mobile.getElementTopPosition(scrollObj, defaultTime)

		// Define the start and end positions for swiping left to right
		// Start at 30% of the width and swipe to 70%
		def startx = eLeftPos + (eWidth * 0.3).toInteger()  // Start at 30% of the width
		def starty = (eTopPos + (eHeight / 2)).toInteger()  // Middle of the elements height
		def endx = eLeftPos + (eWidth * 0.7).toInteger()    // End at 70% of the width
		def endy = starty
		int i = 1

		// Swipe from left to right until the element is found or the limit is reached
		while (!Mobile.verifyElementExist(elementObj, 5, FailureHandling.OPTIONAL) && i < iterations) {
			i = i + 1
			Mobile.swipe(startx, starty, endx, endy, FailureHandling.OPTIONAL)
		}

		// If the element is not found after the given number of iterations, return false
		if (i >= iterations) {
			return false
		}

		return true
	}


	@Keyword
	def scrollUntilTextIsVisible(text, iterations = 15, onFailure = FailureHandling.STOP_ON_FAILURE, waitTime = 5) {
		TestObject elementObj = findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': text])
		scrollUntilElementIsVisible(elementObj, iterations, waitTime)

		verifyElementPresentByText(text, onFailure)
	}

	@Keyword
	def tapOnButtonsheetClose() {
		Mobile.tap(findTestObject('Member/Member360/SearchFunctionality/bottomSheetClose_android'), defaultTime);
	}

	@Keyword
	def verifyButtonsheetClose(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Member/Member360/SearchFunctionality/bottomSheetClose_android'), defaultTime, onFailure);
	}

	@Keyword
	def getFullText(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': text]), defaultTime, onFailure);
	}

	@Keyword
	def verifyEqual(Object obj1, Object obj2, FailureHandling failureHandling = FailureHandling.STOP_ON_FAILURE, String screenshotName = 'screenshot') {
		boolean isEqual = false

		try {
			// Perform the verification using the failure handling parameter
			isEqual = Mobile.verifyEqual(obj1, obj2, FailureHandling.CONTINUE_ON_FAILURE)
		} catch (Exception e) {
			// Log the failure message in case of exception
			KeywordUtil.logInfo("Exception during verification: " + e.getMessage())
		}

		// If objects are not equal, handle different failure scenarios
		if (!isEqual) {
			//			takeScreenshot(screenshotName)
			Mobile.takeScreenshot()
			switch (failureHandling) {
				case FailureHandling.CONTINUE_ON_FAILURE:
					KeywordUtil.markFailed("Objects are not equal, but continuing the test: " + obj1.toString() + " != " + obj2.toString())
					break

				case FailureHandling.OPTIONAL:
					KeywordUtil.markWarning("Objects are not equal, but test marked as OPTIONAL: " + obj1.toString() + " != " + obj2.toString())
					break

				case FailureHandling.STOP_ON_FAILURE:
				default:
					KeywordUtil.markFailedAndStop("Objects are not equal, stopping the test: " + obj1.toString() + " != " + obj2.toString())
					break
			}
		} else {
			// Log success if the objects are equal
			KeywordUtil.markPassed("Objects are equal: " + obj1.toString() + " == " + obj2.toString())
		}
	}

	@Keyword
	def verifyNotEqual(Object obj1, Object obj2, FailureHandling failureHandling = FailureHandling.STOP_ON_FAILURE, String screenshotName = 'screenshot') {
		boolean isEqual = false

		try {
			// Perform the verification using the failure handling parameter
			isEqual = Mobile.verifyNotEqual(obj1, obj2, FailureHandling.CONTINUE_ON_FAILURE)
		} catch (Exception e) {
			// Log the failure message in case of exception
			KeywordUtil.logInfo("Exception during verification: " + e.getMessage())
		}

		// If objects are not equal, handle different failure scenarios
		if (!isEqual) {
			//			takeScreenshot(screenshotName)
			Mobile.takeScreenshot()
			switch (failureHandling) {
				case FailureHandling.CONTINUE_ON_FAILURE:
					KeywordUtil.markFailed("Objects are equal, but continuing the test: " + obj1.toString() + " != " + obj2.toString())
					break

				case FailureHandling.OPTIONAL:
					KeywordUtil.markWarning("Objects are equal, but test marked as OPTIONAL: " + obj1.toString() + " != " + obj2.toString())
					break

				case FailureHandling.STOP_ON_FAILURE:
				default:
					KeywordUtil.markFailedAndStop("Objects are equal, stopping the test: " + obj1.toString() + " != " + obj2.toString())
					break
			}
		} else {
			// Log success if the objects are not equal
			KeywordUtil.markPassed("Objects are not equal: " + obj1.toString() + " == " + obj2.toString())
		}
	}

	@Keyword
	def tapOnElementByPosition(element) {

		TestObject obj = findTestObject(element)

		def eHeight = Mobile.getElementHeight(obj, defaultTime)
		def eWidth = Mobile.getElementWidth(obj, defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(obj, defaultTime)
		def eTopPos = Mobile.getElementTopPosition(obj, defaultTime)

		def x = (eLeftPos + (eWidth/2)).toInteger()
		def y = (eTopPos + (eHeight/2)).toInteger()

		println("x": x)
		println("y": y)
		Mobile.tapAtPosition(x, y)
	}

	@Keyword
	def verifyElementScrenshot(String xpath, expectedImageFilePath, FailureHandling failureHandling = FailureHandling.STOP_ON_FAILURE) {
		def element = MobileDriverFactory.getDriver().findElementByXPath(xpath)
		// Capture screenshot of the element

		BufferedImage actualImage = screenshot.getImage()

		// Load the expected image from file
		BufferedImage expectedImage = ImageIO.read(new File(RunConfiguration.getProjectDir() + expectedImageFilePath))

		// Compare the images
		def hasDiff = diff.hasDiff()
		if (hasDiff) {
			println("Element images do not match!")
		} else {
			println("Element images match!")
		}
		verifyEqual(hasDiff, false, failureHandling)
	}

	@Keyword
	def saveElementScreenshot(String xpath, String savePath) {
		def element = MobileDriverFactory.getDriver().findElementByXPath(xpath)
		// Capture screenshot of the element
		
		// Save screenshot
		ImageIO.write(screenshot.getImage(), "PNG", new File(RunConfiguration.getProjectDir() + savePath));
	}

	@Keyword
	def getDeviceDateTimeAndTimeZone() {
		// Get the Appium driver instance
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()

		// Get the current time from the mobile device (includes timezone)
		String deviceTime = driver.getDeviceTime()

		println("deviceTime": deviceTime)
		// Split the deviceTime string to extract the date, time, and timezone
		// The deviceTime will be in ISO 8601 format (e.g., 2024-10-10T08:00:00-04:00)
		String date = deviceTime.substring(0, deviceTime.indexOf('T'))
		String timeAndtimezone = deviceTime.split('T')[1]
		String time, timezone
		if(timeAndtimezone.contains('-')) {
			time = deviceTime.substring(deviceTime.indexOf('T') + 1, deviceTime.lastIndexOf('-'))
			timezone = deviceTime.substring(deviceTime.lastIndexOf('-'))
		} else {
			time = deviceTime.substring(deviceTime.indexOf('T') + 1, deviceTime.lastIndexOf('+'))
			timezone = deviceTime.substring(deviceTime.lastIndexOf('+'))
		}
		date = date.replaceAll('-0(\\d)$', '-$1')

		// Return the extracted values in a Map
		return [
			"date": date,
			"time": time,
			"timezone": timezone
		]
	}

	@Keyword
	def verifyNormalizeSpaceText(text, index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def normalizeSpaceTextObj = findTestObject('Object Repository/Provider/More/Opt-in to Programs/normalizeSpaceText_android', ['text': text, "index":index])
		def isExist = Mobile.verifyElementExist(normalizeSpaceTextObj, defaultTime, onFailure);
		def failureDescription = "Element with text '${text}' not present"
		if(!isExist && onFailure == FailureHandling.CONTINUE_ON_FAILURE) {
			Mobile.takeScreenshot(FailureHandling.OPTIONAL)
			KeywordUtil.markFailed(failureDescription)
		}
	}
}
