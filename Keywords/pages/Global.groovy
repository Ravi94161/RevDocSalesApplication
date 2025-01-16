package pages

import java.text.SimpleDateFormat
import java.time.LocalDate

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import utility.Verify

public class Global {

	WebDriver driver = DriverFactory.getWebDriver()
	Verify verify = new Verify()
	List<String> valueList

	@Keyword
	def chooseCurrentMonth(TestObject monthDropdown) {

		//TestObject monthDropdown = findTestObject('Object Repository/Profile/div_MonthDropdown')
		WebUI.click(monthDropdown)
		selectCurrentMonthAsPerCurrentDate()

	}


	@Keyword
	def selectCurrentMonthAsPerCurrentDate() {

		List<String> monthsList = new ArrayList<>()
		List<WebElement> monthsElements = driver.findElements(By.xpath("//ul[@role='listbox']/li"))
		for(WebElement monthsElement : monthsElements) {
			monthsList.add(monthsElement.getText())
		}
		println(monthsList)
		//get the current month and select the month from thelist
		LocalDate localDate = LocalDate.now()
		String month = localDate.getMonth()
		println(monthsList.size())
		for(int i=0; i<monthsList.size();i++) {
			//TestObject monthElement = findTestObject("//ul[@role='listbox']/li[" + i + "]")
			//String monthName = WebUI.getText(monthElement)
			String monthName = monthsList.get(i);
			println("Checking month: " + monthName)
			if(monthName.toUpperCase().contains(month.toUpperCase())) {
				//WebUI.click("//ul[@role='listbox']/li[" + i + "]")
				TestObject monthElementClick = new TestObject()
				monthElementClick.addProperty("xpath", ConditionType.EQUALS, "//ul[@role='listbox']/li[" + (i+1) + "]")
				WebUI.click(monthElementClick)
				break;
			}
		}

	}

	@Keyword
	def verifyPaymentDetails() {
		List<String> valueList = new ArrayList()
		// Locate elements by XPath
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='item-pop-first MuiBox-root css-c3vlm2'][1]/div/h6"))
		for (WebElement element : elements) {
			valueList.add(element.getText())
		}
		println(valueList)

		// Create a SimpleDateFormat with the desired pattern
		def sdf = new SimpleDateFormat("MM/dd")
		// Get the current date and format it
		String currentDate = sdf.format(new Date())

		String iMP = GlobalVariable.invitedMemberPersonName
		String eT = GlobalVariable.eventType
		String dA = GlobalVariable.dollarAmount

		println(dA +" "+ valueList.get(3))

		if(valueList.get(0).equalsIgnoreCase(currentDate) &&
		valueList.get(1).equalsIgnoreCase(iMP) &&
		valueList.get(2).equalsIgnoreCase(eT) &&
		valueList.get(3)?.equals(dA)){
			println('details got added to payment tab....')

		}else {
			throw new Exception('details not added to paymet tab.....')
		}
	}

	@Keyword
	def storeDetailsUnderPaymentToListAndVerify() {

		storeDetailsFromPaymentsTabAsList()
		verifyStoredValuesInListWithRegistrationTimeValues()

	}

	@Keyword
	def storeDetailsFromPaymentsTabAsList() {

		valueList = new ArrayList<>()
		// Locate elements by XPath
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='item-pop-first MuiBox-root css-c3vlm2'][1]/div/h6"))
		for (WebElement element : elements) {
			valueList.add(element.getText())
		}
		println(valueList)
	}

	@Keyword
	def verifyStoredValuesInListWithRegistrationTimeValues() {
		// Create a SimpleDateFormat with the desired pattern
		def sdf = new SimpleDateFormat("MM/dd")
		// Get the current date and format it
		String currentDate = sdf.format(new Date())

		String iMP = GlobalVariable.invitedMemberPersonName
		String eT = GlobalVariable.eventType
		String dA = GlobalVariable.dollarAmount
		verify.verifyTextMatch(valueList.get(0), currentDate, "date not matched....")
		verify.verifyTextMatch(valueList.get(1), iMP, "invited sales person name not matched....")
		verify.verifyTextMatch(valueList.get(2), eT, "event type not matched....")
		verify.verifyTextMatch(valueList.get(3), dA, "dollar amount not matched....")
	}

	@Keyword
	def clickOnHomeButton(TestObject homeLink) {
		WebUI.click(homeLink)
	}

	@Keyword
	def getOverrideValueBeforeEventAndStoreIt(TestObject overrideAmountTXT) {

		String dollarAmount = WebUI.getText(overrideAmountTXT)
		//GlobalVariable.OverrideAmountBeforeEvent = dollarAmount
		println(dollarAmount)
		return dollarAmount
	}

	@Keyword
	def verifyOverrideValueAfterEventAddedOrNot(TestObject overrideAmountTXT, String overrideAmountBeforeEvent) {

		String dollarAmount = WebUI.getText(overrideAmountTXT)
		println(dollarAmount)
		println(overrideAmountBeforeEvent)
		float dollarAmountBeforeEventWithOverrideValue = getAmountValueWithOutDollarSign(overrideAmountBeforeEvent) + 0.1
		float dollarAmountAfterEvent = getAmountValueWithOutDollarSign(dollarAmount)
		println(dollarAmountBeforeEventWithOverrideValue)
		println(dollarAmountAfterEvent)
		verify.verifyIsEqualFLoat(dollarAmountBeforeEventWithOverrideValue, dollarAmountAfterEvent, "Override amount verification failed.....")
	}

	@Keyword
	def getAmountValueWithOutDollarSign(String dollarAmount) {

		return dollarAmount.replace('$', '').toFloat()
	}

	@Keyword
	def verifyPointsAddedAfterEvent(TestObject pointsCountTxt,int points) {
		int pointsAfterEvent = WebUI.getText(pointsCountTxt).toInteger()
		int pointsBeforeEvent = points + 5
		println(pointsAfterEvent)
		println(pointsBeforeEvent)
		verify.verifyIsEqual(pointsAfterEvent, pointsBeforeEvent , "Points not added for event")
	}
	
	@Keyword
	def getGoalValuesOfAnEvent(List<String> goalsData) {
		List<Integer> goalsValues = new ArrayList()
		for(int i=0 ; i<goalsData.size() ; i++) {
			goalsValues[i] = goalsData.get(i).toInteger()
			println(goalsData.get(i).toInteger())
		}
		return goalsValues
	}
	
	@Keyword
	def verifyGoalsUpdatedOrNot(TestObject goalsOBJ, TestObject myProgressOBJ, TestObject reachedStatusOBJ, List<Integer> goalsValuesBeforeEvent) {
		int goalsCount = WebUI.getText(goalsOBJ).toInteger()
		int myProgressCount = WebUI.getText(myProgressOBJ).toInteger()
		int reachedCount = WebUI.getText(reachedStatusOBJ).toInteger()
		//myProgressCount == goalsValuesBeforeEvent[1] +1
		verify.verifyIsEqual(myProgressCount, goalsValuesBeforeEvent[1] +1, "Goals not added.....")
		println(goalsValuesBeforeEvent[1] +1)
		if(myProgressCount >= goalsCount) {
			//reachedCount == goalsValuesBeforeEvent[3] + 1
			verify.verifyIsEqual(reachedCount, (goalsValuesBeforeEvent[2] +1), "Goals not added.....")
			println(goalsValuesBeforeEvent[2] +1)
		}else {
			//reachedCount == goalsValuesBeforeEvent[3] - 1
			verify.verifyIsEqual(reachedCount, (goalsValuesBeforeEvent[2] -1), "Goals not added.....")
			println(goalsValuesBeforeEvent[2] -1)
		}
	}

}
