package utility
import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor

import org.apache.commons.lang.RandomStringUtils
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable


class Verify {
	Random random = new Random()
	int timetoWait = GlobalVariable.lowWaitTime
	
	
	/**
	 * Reusable Methods
	 */

	@Keyword
	def verifyElementPresent(TestObject element, String failureDescription, int maxWaitTime = timetoWait) {
		if(!WebUI.verifyElementPresent(element, maxWaitTime, FailureHandling.OPTIONAL)) {
			WebUI.takeScreenshot(FailureHandling.OPTIONAL)
			KeywordUtil.markFailedAndStop(failureDescription)
		}
	}

	@Keyword
	def verifyElementPresentAndContinueOnFailure(TestObject element, String failureDescription, int maxWaitTime = timetoWait) {
		if(!WebUI.verifyElementPresent(element, maxWaitTime, FailureHandling.OPTIONAL)) {
			//WebUI.takeScreenshot()
			WebUI.takeScreenshot(FailureHandling.OPTIONAL)
			KeywordUtil.markFailed(failureDescription)
		}
	}

	@Keyword
	def verifyElementNotPresent(TestObject element, String failureDescription, int maxWaitTime = timetoWait) {
		if(!(WebUI.verifyElementNotPresent(element, maxWaitTime, FailureHandling.OPTIONAL))) {
			//WebUI.takeScreenshot()
			WebUI.takeScreenshot(FailureHandling.OPTIONAL)
			KeywordUtil.markFailedAndStop(failureDescription)
		}
	}

	@Keyword
	def verifyElementNotPresentAndContinueOnFailure(TestObject element, String failureDescription, int maxWaitTime = timetoWait) {
		if(!WebUI.verifyElementNotPresent(element, maxWaitTime, FailureHandling.OPTIONAL)) {
			WebUI.takeScreenshot(FailureHandling.OPTIONAL)
			KeywordUtil.markFailed(failureDescription)
		}
	}

	@Keyword
	def verifyTextMatch(String actual, String expected, String failureDescription){
		if(!(WebUI.verifyMatch(actual, expected, false, FailureHandling.OPTIONAL))){
			//WebUI.takeScreenshot()
			WebUI.takeFullPageScreenshot(FailureHandling.OPTIONAL)
			KeywordUtil.markFailedAndStop(failureDescription +" Actual string: "+ actual + ", Expected string: "+ expected )
		}
	}

	@Keyword
	def verifyTextMatchAndContinueOnFailure(String actual, String expected, String failureDescription){
		if(!(WebUI.verifyMatch(actual, expected, false, FailureHandling.OPTIONAL))){
			WebUI.takeScreenshot(FailureHandling.OPTIONAL)
			KeywordUtil.markFailed(failureDescription +" Actual string: "+ actual + ", Expected string: "+ expected )
		}
	}

	@Keyword
	def verifyTextNotMatch(String actual, String expected, String failureDescription){
		if(!(WebUI.verifyNotMatch(actual, expected, false, FailureHandling.OPTIONAL))){
			WebUI.takeScreenshot(FailureHandling.OPTIONAL)
			KeywordUtil.markFailedAndStop(failureDescription +" Actual string: "+ actual + ", Not Expected string: "+ expected)
		}
	}

	@Keyword
	def verifyTextNotMatchAndContinueOnFailure(String actual, String expected, String failureDescription){
		if(!(WebUI.verifyNotMatch(actual, expected, false, FailureHandling.OPTIONAL))){
			WebUI.takeScreenshot(FailureHandling.OPTIONAL)
			KeywordUtil.markFailed(failureDescription +" Actual string: "+ actual + ", Not Expected string: "+ expected)
		}
	}

	@Keyword
	def verifyIsEqual(int actual, int expected, String failureDescription){
		if(expected != actual){
			//WebUI.takeScreenshot()
			WebUI.takeFullPageScreenshot(FailureHandling.OPTIONAL)
			KeywordUtil.markFailedAndStop(failureDescription + " Actual value: "+ actual + ", Expected value: "+ expected)
		}
	}

	@Keyword
	def verifyIsNotEqualAndContinueOnFailure(int actual, int expected, String failureDescription){
		if(expected == actual){
			//WebUI.takeScreenshot()
			WebUI.takeFullPageScreenshot(FailureHandling.OPTIONAL)
			KeywordUtil.markFailedAndStop(failureDescription + " Actual value: "+ actual + ", Expected value: "+ expected)
		}
	}

	@Keyword
	def verifyElementChecked(TestObject element, String failureDescription, int maxWaitTime = timetoWait){
		if(! WebUI.verifyElementChecked(element, maxWaitTime, FailureHandling.OPTIONAL)) {
			WebUI.takeScreenshot(FailureHandling.OPTIONAL)
			KeywordUtil.markFailedAndStop(failureDescription)
		}
	}

	@Keyword
	def verifyElementNotChecked(TestObject element, String failureDescription, int maxWaitTime = timetoWait){
		if(! WebUI.verifyElementNotChecked(element, maxWaitTime, FailureHandling.OPTIONAL)) {
			WebUI.takeScreenshot(FailureHandling.OPTIONAL)
			KeywordUtil.markFailedAndStop(failureDescription)
		}
	}

	@Keyword
	def verifyElementVisible(TestObject element, String failureDescription){
		if(!(WebUI.verifyElementVisible(element, FailureHandling.OPTIONAL))){
			WebUI.takeScreenshot(FailureHandling.OPTIONAL)
			KeywordUtil.markFailedAndStop(failureDescription)
		}
	}

	@Keyword
	def verifyElementNotVisible(TestObject element, String failureDescription){
		if(!(WebUI.verifyElementNotVisible(element, FailureHandling.OPTIONAL))){
			WebUI.takeScreenshot(FailureHandling.OPTIONAL)
			KeywordUtil.markFailedAndStop(failureDescription)
		}
	}

	@Keyword
	def verifyElementNotVisibleAndContinuewOnFailure(TestObject element, String failureDescription, int maxWaitTime = timetoWait) {
		if(!WebUI.verifyElementNotVisible(element, maxWaitTime, FailureHandling.OPTIONAL)) {
			WebUI.takeScreenshot(FailureHandling.OPTIONAL)
			KeywordUtil.markFailed(failureDescription)
		}
	}

	@Keyword
	def verifyElementClickable(TestObject element, String failureDescription){
		if(!(WebUI.verifyElementClickable(element))){
			WebUI.takeScreenshot(FailureHandling.OPTIONAL)
			KeywordUtil.markFailedAndStop(failureDescription)
		}
	}

	@Keyword
	def verifyElementNotClickable(TestObject element, String failureDescription){
		if(!(WebUI.verifyElementNotClickable(element))){
			WebUI.takeScreenshot(FailureHandling.OPTIONAL)
			KeywordUtil.markFailedAndStop(failureDescription)
		}
	}

	@Keyword
	def verifyTextboxEditable(TestObject element){
	}


	@Keyword
	def verifyElementPresentInMobile(TestObject element, String failureDescription, int maxWaitTime = timetoWait) {
		if(!Mobile.verifyElementExist(element, maxWaitTime, FailureHandling.OPTIONAL)) {
			Mobile.takeScreenshot()
			KeywordUtil.markFailedAndStop(failureDescription)
		}
	}

	@Keyword
	def verifyObjectsMatch(def actual, def expected, String failureDescription){

		if(!actual.equals(expected)) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop(failureDescription)
		}
	}

	@Keyword
	def getClipboardContent(){

		String textInClipboard = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor)
		return textInClipboard
	}

	@Keyword
	def generateRandomString(String generateFor){
		def randomText
		def option
		switch(generateFor){
			case "Note":
				option = "Sample Note Text "
				break
			case "ModifiedNote":
				option = "Modified Note Content "
				break
			case "Bookmark":
				option = "AutoBM "
				break
			case "Alphabet&Numbers":
				option = RandomStringUtils.randomAlphabetic(10)
				break
			case "Event":
				option = "QAuto: "
				break
			case "SuperPropertyEvent":
				option = "QEvent: "
				break
			case "Alert Name":
				option = "Automation "
				break
			case "Form Name":
				option = "Automation "
				break
			case "FeedbackRegex":
				option = "Automation Regex "
				break
			case "Form Title":
				option = "Automation Form Title "
				break
			case "Project":
				option = "QProject "
				break
			case "Password":
				List specialChar = [
					'!',
					'@',
					'#',
					'$',
					'%',
					'^',
					"&",
					'*',
					'(',
					')',
					'-',
					'_',
					'=',
					'+',
					'<',
					'>',
					',',
					'.',
					'?',
					'/',
					';',
					':',
					'[',
					']',
					'{',
					'}'
				]
				option = RandomStringUtils.randomAlphabetic(10) + specialChar[random.nextInt(specialChar.size())]
				break
			case "Number":
				option = ""
				break
			default:
				KeywordUtil.markFailedAndStop("Invalid option")
		}
		randomText = option + random.nextInt(100000)
		return randomText
	}

	@Keyword
	def addTrackingCode(String src){

		def addTrackingCode = WebUI.executeJavaScript('return !function(a){a.aurycReadyCb=a.aurycReadyCb||[],a.auryc=a.auryc||[];a.aurycEventPropertiesCb = a.aurycEventPropertiesCb||[];var e=document,r=e.createElement("script"),t=e.head||e.getElementsByTagName("head")[0],c={src:"' + src + '","data-cfasync":"false",async:"true","data-vendor":"auryc","data-role":"container",charset:"utf-8"};for(var d in c)r.setAttribute(d,c[d]);t.appendChild(r);for(var n=["track","identify","addFBCustomData","addUserProperties","addSessionProperties","addInternalSessionProperties","getReplayUrl","setFeedbackEnabled","clearUserCookie","addFBSubmitHandler","addFBCancelHandler","addEventProperties","removeEventProperty","removeAllEventProperties","pause","resume"],u=function(e){return function(){var r=Array.prototype.slice.call(arguments,0);if(e==="addEventProperties"||e==="removeEventProperty"||e==="removeAllEventProperties"){a.aurycEventPropertiesCb.push(function(){a.auryc[e]&&a.auryc[e].apply(a.auryc,r)})}else{a.aurycReadyCb.push(function(){a.auryc[e]&&a.auryc[e].apply(a.auryc,r)})}}},s=0;s<n.length;s++)a.auryc[n[s]]=u(n[s])}(window);', null)

		println "--------addTrackingCodeReturnData = " + addTrackingCode

		verifyObjectsMatch(addTrackingCode , true, "Issue while adding a tracking code.")
	}
}