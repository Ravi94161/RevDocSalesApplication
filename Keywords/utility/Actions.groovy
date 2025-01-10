package utility
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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import groovy.time.TimeCategory
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.util.internal.PathUtil as PathUtil
//import kms.turing.katalon.plugins.helper.table.HTMLTableHelper
//import org.openqa.selenium.JavascriptExecutor



class Actions extends Verify{
	/**
	 * Actions on web elements
	 */

	int waitTime = GlobalVariable.lowWaitTime


	@Keyword
	def click(TestObject element,String failureDescription) {

		verifyElementPresent(element, failureDescription)
		WebUI.click(element)
	}

	@Keyword
	def clickJS(TestObject element) {

		wait(element, 20)
		WebUI.waitForElementClickable(element, 20)
		WebElement elementToClick = WebUiCommonHelper.findWebElement(element, waitTime)
		//WebUI.executeJavaScript("arguments[0].dispatchEvent(new MouseEvent('click'))", Arrays.asList(elementToClick))
		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(elementToClick))
	}

	@Keyword
	def tap(TestObject element) {

		waitInMobile(element)
		Mobile.tap(element,waitTime)
	}

	@Keyword
	def setText(TestObject element, String text) {

		waitInMobile(element)
		Mobile.setText(element,text,waitTime)
	}

	@Keyword
	def sendKeys(TestObject element, String text) {

		wait(element, 20)
		WebUI.waitForElementClickable(element, 20)
		try{
			WebUI.clearText(element)
		}
		catch(Exception e){
			clearTextJS(element)
		}
		WebUI.sendKeys(element, text)
	}

	@Keyword
	def sendKeysJS(TestObject element, String text) {

		//Check whether the required element contains attribute 'value'
		wait(element, 20)
		clearTextJS(element)
		WebUI.clearText(element)
		WebElement inputElement = WebUiCommonHelper.findWebElement(element, waitTime)
		WebUI.executeJavaScript("arguments[0].value = arguments[1]", Arrays.asList(inputElement, text))
	}

	@Keyword
	def clearText(TestObject element) {

		wait(element)
		String os = getExecutionOS()
		WebUI.waitForElementClickable(element, 20)
		WebUI.doubleClick(element)
		if(os.contains("Windows")){

			WebUI.sendKeys(element, Keys.chord(Keys.CONTROL, 'a'))
			WebUI.sendKeys(element, Keys.chord(Keys.BACK_SPACE))
		}
		else{

			WebUI.sendKeys(element, Keys.chord(Keys.COMMAND, 'a'))
			WebUI.sendKeys(element, Keys.chord(Keys.BACK_SPACE))
		}
	}

	@Keyword
	def pasteClipboardContent(){

		WebUI.sendKeys(Keys.chord(Keys.CONTROL, 'v'))
	}

	@Keyword
	def clearTextJS(TestObject element) {

		wait(element, 20)
		WebUI.doubleClick(element)
		WebElement elementToClear = WebUiCommonHelper.findWebElement(element, waitTime)
		WebUI.executeJavaScript(" arguments[0].value = '' ", Arrays.asList(elementToClear))
	}

	@Keyword
	def sendKeysEncrypted(TestObject element, String encryptedText) {

		wait(element)
		WebUI.waitForElementClickable(element, waitTime)
		WebUI.setEncryptedText(element, encryptedText)
	}

	@Keyword
	def getText(TestObject element, int maxWaitTime = waitTime) {

		wait(element, maxWaitTime)
		return WebUI.getText(element).trim()
	}

	@Keyword
	def getTextInMobile(TestObject element, int maxWaitTime = waitTime) {

		waitInMobile(element)
		return Mobile.getText(element, maxWaitTime).trim()
	}


	@Keyword
	def waitForElement(TestObject element){
		wait(element, 20)
	}

	@Keyword
	def wait(TestObject element, int maxWaitTime = waitTime) {

		try{
			WebUI.waitForElementPresent(element, maxWaitTime)
			WebUI.waitForElementVisible(element, maxWaitTime)
		}
		catch(Exception exp)
		{
			String message = exp.getCause()
			if(message.contains('StaleElementReferenceException')){
				println '-------- Caught the DOM exception -------- Caught the DOM exception -------- Caught the DOM exception --------'
				WebUI.delay(20)
				WebUI.waitForElementPresent(element, 15)
				WebUI.waitForElementVisible(element, 15)
			}
		}
	}

	@Keyword
	def waitInMobile(TestObject element, int maxWaitTime = waitTime) {

		Mobile.waitForElementPresent(element, maxWaitTime)
	}

	@Keyword
	def getElementCount(TestObject element, int waitTimeLocal = waitTime) {

		def count
		if(!(WebUI.verifyElementPresent(element, waitTimeLocal, FailureHandling.OPTIONAL))) {
			count = 0
		}
		else {
			count = WebUiCommonHelper.findWebElements(element, waitTime).size()
		}
		return count
	}

	@Keyword
	def getElementCount(TestObject element, int waitTimeLocal = waitTime, boolean isParentFramePresent) {

		def count
		if(!(WebUI.verifyElementPresent(element, waitTimeLocal, FailureHandling.OPTIONAL))) {
			count = 0
		}
		else {
			if(isParentFramePresent){
				WebUiCommonHelper.switchToParentFrame(element)
				count = WebUiCommonHelper.findWebElements(element, waitTime).size()
				WebUiCommonHelper.switchToDefaultContent()
			}
			else{
				count = WebUiCommonHelper.findWebElements(element, waitTime).size()
			}
		}
		return count
	}

	@Keyword
	def getUrlAndVerify(String name, String failuredescription ) {

		if(!(WebUI.getUrl().endsWith(name))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailed(failuredescription)
		}
	}

	@Keyword
	def getExecutionOS(){

		String OSPlatform
		Map driverProperties = RunConfiguration.getDriverPreferencesProperties()
		//println '--------- driverProperties = ' + driverProperties

		def driverType = driverProperties.keySet() [0]
		//println '--------- driverType = ' + driverType

		if(driverType == 'Remote'){
			Map driverCapabilities = driverProperties.get("Remote")
			OSPlatform = driverCapabilities.get("os")
		}
		else{

			OSPlatform = System.getProperty("os.name")
		}
		//println '--------- OSPlatform = ' + OSPlatform
		return OSPlatform
	}

	@Keyword
	def getExecutionBrowser(){

		String browser
		Map driverProperties = RunConfiguration.getDriverPreferencesProperties()
		//println '--------- driverProperties = ' + driverProperties

		def driverType = driverProperties.keySet() [0]
		//println '--------- driverType = ' + driverType

		if(driverType == 'Remote'){
			Map driverCapabilities = driverProperties.get("Remote")
			browser = driverCapabilities.get("browser")
		}
		else{

			browser = DriverFactory.getExecutedBrowser()
		}
		//println '--------- browser = ' + browser
		return browser
	}





}






