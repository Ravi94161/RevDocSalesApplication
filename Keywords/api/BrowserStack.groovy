package api

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

import groovy.json.JsonSlurper
import internal.GlobalVariable

public class BrowserStack {
@Keyword
	def getBrowserStackSessionDetails(sessionId) {
		def username = GlobalVariable.bsUserName
		def accessKey = GlobalVariable.bsAccessKey

		def apiUrl = "https://api.browserstack.com/app-automate/sessions/${sessionId}.json"
		def connection = new URL(apiUrl).openConnection() as HttpURLConnection
		connection.requestMethod = 'GET'
		connection.setRequestProperty("Authorization", "Basic ${"${username}:${accessKey}".bytes.encodeBase64().toString()}")
		def responseCode = connection.responseCode
		if (responseCode == 200) {
			def response = connection.inputStream.text
			def json = new JsonSlurper().parseText(response)
			println("Session Details: ${json}")
			return json
		} else {
			println("Failed to get session details. Response Code: ${responseCode}")
		}
	}
}
