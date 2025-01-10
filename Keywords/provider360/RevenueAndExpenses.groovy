package provider360

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import provider360.Expenses
import mobile.MobileActions
import java.util.Date
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter


public class RevenueAndExpenses {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE;
	Expenses exp = new Expenses()
	MobileActions ma = new MobileActions()

	@Keyword
	def verifyRevenueAndExpensesTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/revenueAndExpensesTitle_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyRevenueTab() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/revenueTab_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyExpensesTab() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/expensesTab_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyElementText(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/Expenses/elelmentText_android',["text":text]), defaultTime, onFailure);
	}

	@Keyword
	def verifyEhr() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/ehrInRevenueAndExpenses_android'), defaultTime, onFailure);
	}

	@Keyword
	def getMonthName() {
		Mobile.getText(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/getMonthName_android'), defaultTime)
	}
	@Keyword
	def verifyShareRevenueBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/ShareRevenueBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/backBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyBackBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/backBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyMonthYearRevenueTitle(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/verifyMonthYearRevenueTitle_android',["text":text]), defaultTime, onFailure);
	}
	@Keyword
	def getYearOrMonthRevenueOnTab(year) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/getYearOrMonthRevenueOnTab_android',["year":year]), defaultTime, onFailure);
	}
	@Keyword
	def getTotalMonthRevenue() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/getTotalMonthRevenue_android'), defaultTime, onFailure);
	}
	@Keyword
	def getTotalYearRevenue() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/getTotalYearRevenue_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyTotalYearRevenueOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/getTotalYearRevenue_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyTotalMonthRevenueOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/getTotalMonthRevenue_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyTotalAppointmentsOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/totalAppointmentsOption_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyAppointmentRevenue(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/appointmentRevenue_android',["index":index]), defaultTime, onFailure);
	}
	@Keyword
	def verifyAppointmentDeliveryMethod(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/appointmentDeliveryMethod_android',["index":index]), defaultTime, onFailure);
	}
	@Keyword
	def verifyAppointmentDateAndTime(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/appointmentDateAndTime_android',["index":index]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnFirstMonth() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/firstMonth_andriod'), defaultTime)
	}
	@Keyword
	def tapOnShareRevenueBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/ShareRevenueBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnAppoinmentInRevenuePage(procedure, date) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/appoinmentInRevenuePg_andriod', ['procedure': procedure, 'date': date]), defaultTime)
	}
	@Keyword
	def verifyAppoinmentNotExtInRevenuePage(procedure, date) {
		return Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/appoinmentInRevenuePg_andriod', ['procedure': procedure, 'date': date]), defaultTime, FailureHandling.OPTIONAL)
	}
	@Keyword
	def tapOnFirstAppoinmentInRevenuePage() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/firstAppoinment_andriod'), defaultTime)
	}
	@Keyword
	def verifyRevenueBasedOnDate(date, revenue) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/revenueBasedOnDate_android', ['date': date, 'revenue': revenue]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verifyRevenueMatchWithCalendarApptRevenue(procedureName, revenue) {
		def currentDate = LocalDate.now()
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH)
		def formattedRevenueDate = currentDate.format(formatter)
		def year = currentDate.year
		exp.tapRevenueAndExpensesTab();
		exp.tapByText(year);
		def month = getMonthName();
		verifyElementText(month);
		exp.tapByText(month);
		Mobile.scrollToText(formattedRevenueDate)
		ma.verifyElementPresentByText(formattedRevenueDate);
		ma.verifyElementPresentByText(procedureName);
		verifyRevenueBasedOnDate(formattedRevenueDate, revenue);
	}
}