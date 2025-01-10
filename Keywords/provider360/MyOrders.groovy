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

public class MyOrders {
	String os=GlobalVariable.osName;
	int defaultTime= GlobalVariable.defaultTime;
	@Keyword
	def tapOnMyOrdersBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MyOrders/MyOrderBtn_'+os), defaultTime);
	}
	@Keyword
	def taponPastOrdersBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MyOrders/pastOrdersBtn_'+os),defaultTime );
	}
	@Keyword
	def tapOnAddItemPuls() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MyOrders/addItemPlus_'+os),defaultTime );
	}
	@Keyword
	def tapOnAddToCartBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MyOrders/addToCartBtn_'+os),defaultTime );
	}
	@Keyword
	def tapOnStoreSymBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MyOrders/storeSymBtn_'+os),defaultTime );
	}
	@Keyword
	def tapOnProceedToCheckOutBtn(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MyOrders/ProceedToCheckOutBtn_'+os),defaultTime, onFailure);
	}
	@Keyword
	def tapOnPlaceOrderBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MyOrders/PlaceOrderBtn_'+os),defaultTime );
	}
	@Keyword
	def tapOnInfoIcon() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MyOrders/infoIcon_'+os), defaultTime);
	}
}
