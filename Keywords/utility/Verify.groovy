package utility
import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor

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
	def verifyTextContains(String actual, String failureDescription) {
		WebUI.verifyTextPresent(actual, false)
		if(!WebUI.verifyTextPresent(actual, false)){
			//WebUI.takeScreenshot()
			WebUI.takeFullPageScreenshot(FailureHandling.OPTIONAL)
			KeywordUtil.markFailedAndStop(failureDescription)
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
	def verifyIsEqualFLoat(double actual, float expected, String failureDescription){
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
}