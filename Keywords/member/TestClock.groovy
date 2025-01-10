package member

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
import member.searchFunctionality
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.text.SimpleDateFormat
import java.util.Calendar

public class TestClock {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def setTextInClockName(text) {
		Mobile.setText(findTestObject('Object Repository/Member/HomePage/TestClock/clockName_android'), text, defaultTime);
		Mobile.hideKeyboard();
	}

	@Keyword
	def tapOnStagingText() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/TestClock/stagingText_android'), defaultTime);
	}

	@Keyword
	def tapOnCreateTestClockBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/TestClock/createTestClockBtn_android'), defaultTime);
	}

	@Keyword
	def verifyCreatedTestClockOption(testClockName, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/TestClock/createdTestClockOption_android', ["testClockName":testClockName]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnCreatedTestClockOption(testClockName) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/TestClock/createdTestClockOption_android', ["testClockName":testClockName]), defaultTime);
	}

	@Keyword
	def tapOnSpecificUpdateTestClockBtn(testClockName) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/TestClock/updateTestClockBtnForSpecificTestClock_android', ["testClockName":testClockName]), defaultTime);
	}

	@Keyword
	def tapOnSpecificDeleteTestClockBtn(testClockName) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/TestClock/deleteBtnForSpecificTestClock_android', ["testClockName":testClockName]), defaultTime);
	}
	
	@Keyword
	def verifySpecificDeleteTestClockBtn(testClockName) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/TestClock/deleteBtnForSpecificTestClock_android', ["testClockName":testClockName]), defaultTime, FailureHandling.OPTIONAL);
	}
	
	@Keyword
	def tapOnSpecificDateField(testClockName) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/TestClock/dateFieldForSpecificTestClock_android', ["testClockName":testClockName]), defaultTime);
	}

	@Keyword
	def scrollToSpecificDateAndUpdateTheTestClock(testClockName, newMonth, newDay, newYear ) {
		tapOnSpecificDateField(testClockName)
		new searchFunctionality().selectDate(newMonth, newDay, newYear)
		new searchFunctionality().tapOnConformBtn()
		tapOnSpecificUpdateTestClockBtn(testClockName);
		Mobile.delay(8);
	}

	@Keyword
	def scrollToOneYearAndUpdateTheTestClock(testClockName) {
		// Get the new month, day, and year
		def newMonth = ""
		def newDay = 0
		def newYear = 0

		// Create a calendar instance and set it to the current date
		def calendar = Calendar.getInstance()
		def currentDate = new Date()
		calendar.setTime(currentDate)
		// Get the current month, day, and year
		def currentMonth = calendar.get(Calendar.MONTH)
		def currentDay = calendar.get(Calendar.DAY_OF_MONTH)
		def currentYear = calendar.get(Calendar.YEAR)

		// DateFormat to print the current date
		def dateFormat = new SimpleDateFormat("MMMM dd, yyyy")

		// Print the current date
		println "Current Date: " + dateFormat.format(calendar.getTime())

		// Increment the month and update until it reaches the same month and day in the next year
		while (true) {
			// Add one month
			calendar.add(Calendar.MONTH, 1)

			// Adjust the day of the month if necessary
			int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
			if (currentDay > maxDay) {
				calendar.set(Calendar.DAY_OF_MONTH, maxDay)
			} else {
				calendar.set(Calendar.DAY_OF_MONTH, currentDay)
			}

			// Get the new month, day, and year
			newMonth = new SimpleDateFormat("MMMM").format(calendar.getTime())
			newDay = calendar.get(Calendar.DAY_OF_MONTH)
			newYear = calendar.get(Calendar.YEAR)

			// Reusable method for Scroll to Specific month
			scrollToSpecificDateAndUpdateTheTestClock(testClockName, newMonth, newDay, newYear)

			// Check if the month and day match the original month and day, and the year is incremented by 1
			if (calendar.get(Calendar.YEAR) == currentYear + 1 &&
			calendar.get(Calendar.MONTH) == currentMonth &&
			calendar.get(Calendar.DAY_OF_MONTH) == currentDay) {
				break
			}
		}

		// Return the new month, day, and year as a map
		return [newMonth: newMonth, newDay: newDay, newYear: newYear]
	}

	@Keyword
	def getQuartersFromCurrentMonth(int daysToRemove = 0) {
		// Get the current date and subtract days if necessary
		def calendar = Calendar.getInstance()

		// Subtract days if needed
		if (daysToRemove > 0) {
			calendar.add(Calendar.DAY_OF_MONTH, -daysToRemove)
		}

		// Set the current time to the adjusted date
		def currentDate = calendar.getTime()

		// Format for Month Year
		def dateFormat = new SimpleDateFormat("MMMM yyyy")

		// List to store the quarters
		def quarters = []

		// Add the adjusted date as the first quarter
		quarters << dateFormat.format(currentDate)

		// Loop to get the next 4 quarters
		for (int i = 1; i <= 4; i++) {
			calendar.add(Calendar.MONTH, 3)
			def newDate = dateFormat.format(calendar.getTime())
			quarters << newDate
		}

		return quarters
	}

	@Keyword
	def generateNextMonthDayAndYear() {
		// Get the new month, day, and year
		def newMonth = ""
		def newDay = 0
		def newYear = 0

		// Create a calendar instance and set it to the current date
		def calendar = Calendar.getInstance()
		def currentDate = new Date()
		calendar.setTime(currentDate)
		// Get the current month, day, and year
		def currentMonth = calendar.get(Calendar.MONTH)
		def currentDay = calendar.get(Calendar.DAY_OF_MONTH)
		def currentYear = calendar.get(Calendar.YEAR)

		// DateFormat to print the current date
		def dateFormat = new SimpleDateFormat("MMMM dd, yyyy")

		// Print the current date
		println "Current Date: " + dateFormat.format(calendar.getTime())

		// Add one month
		calendar.add(Calendar.MONTH, 1)

		// Adjust the day of the month if necessary
		int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
		if (currentDay > maxDay) {
			calendar.set(Calendar.DAY_OF_MONTH, maxDay)
		} else {
			calendar.set(Calendar.DAY_OF_MONTH, currentDay)
		}

		// Get the new month, day, and year
		newMonth = new SimpleDateFormat("MMMM").format(calendar.getTime())
		newDay = calendar.get(Calendar.DAY_OF_MONTH)
		newYear = calendar.get(Calendar.YEAR)
		// Return the new month, day, and year as a map
		return [newMonth: newMonth, newDay: newDay, newYear: newYear]
	}

	@Keyword
	def generateFutureDateFromSpecificDate(int monthsToAdd, Date startDate = null) {
		// Use the provided startDate if available, otherwise use the current date
		if (startDate == null) {
			startDate = new Date()
		}

		// Create a calendar instance and set it to the start date
		def calendar = Calendar.getInstance()
		calendar.setTime(startDate)

		// Store the original day to compare with the maximum day of the new month
		def originalDay = calendar.get(Calendar.DAY_OF_MONTH)

		// Print the start date
		def dateFormat = new SimpleDateFormat("MMMM dd, yyyy")
		println "Start Date: " + dateFormat.format(calendar.getTime())

		// Add the specified number of months to the start date
		calendar.add(Calendar.MONTH, monthsToAdd)

		// Adjust the day of the month if necessary
		int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
		if (originalDay > maxDay) {
			calendar.set(Calendar.DAY_OF_MONTH, maxDay)
		} else {
			calendar.set(Calendar.DAY_OF_MONTH, originalDay)
		}

		// Get the new month, day, and year
		def newMonth = new SimpleDateFormat("MMMM").format(calendar.getTime())
		def newDay = calendar.get(Calendar.DAY_OF_MONTH)
		def newYear = calendar.get(Calendar.YEAR)

		// Print the generated date
		println "Generated Date: " + dateFormat.format(calendar.getTime())

		// Return the new month, day, and year as a map
		return [newMonth: newMonth, newDay: newDay, newYear: newYear]
	}
	@Keyword
	def scrollToSpecificDateAndUpdateTheTestClockEveryMonth(Date targetDate1 = null, Date targetDate2, testClockName) {
		// Create a calendar instance
		def calendar = Calendar.getInstance()

		// If targetDate1 is null, start from the current date; otherwise, start from targetDate1
		if (targetDate1 != null) {
			calendar.setTime(targetDate1)
		} else {
			// Start from the current month
			calendar.setTime(new Date())
		}

		// Store the original day to compare with the maximum day of the target month
		def originalDay = calendar.get(Calendar.DAY_OF_MONTH)

		// DateFormat to print dates
		def dateFormat = new SimpleDateFormat("MMMM dd, yyyy")
		println "Starting from: " + dateFormat.format(calendar.getTime())

		// Create a calendar instance for the target date
		def targetCalendar = Calendar.getInstance()
		targetCalendar.setTime(targetDate2)

		// Loop to increment the month and update until it reaches the targetDate2
		while (calendar.before(targetCalendar) || calendar.get(Calendar.YEAR) < targetCalendar.get(Calendar.YEAR)) {
			// Add one month
			calendar.add(Calendar.MONTH, 1)

			// Adjust the day of the month if necessary
			int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
			if (originalDay > maxDay) {
				calendar.set(Calendar.DAY_OF_MONTH, maxDay)
			} else {
				calendar.set(Calendar.DAY_OF_MONTH, originalDay)
			}

			// Get the new month, year, and set day to the target date's day if it's the same month/year
			def newMonth = new SimpleDateFormat("MMMM").format(calendar.getTime())
			def newYear = calendar.get(Calendar.YEAR)

			// If we reach the target year and month, use targetDate2's day
			def newDay = (calendar.get(Calendar.YEAR) == targetCalendar.get(Calendar.YEAR) &&
					calendar.get(Calendar.MONTH) == targetCalendar.get(Calendar.MONTH))
					? targetCalendar.get(Calendar.DAY_OF_MONTH)
					: calendar.get(Calendar.DAY_OF_MONTH)

			// Reusable method for Scroll to Specific date
			scrollToSpecificDateAndUpdateTheTestClock(testClockName, newMonth, newDay, newYear)

			// Break the loop if we've reached the target date
			if (calendar.get(Calendar.YEAR) == targetCalendar.get(Calendar.YEAR) &&
			calendar.get(Calendar.MONTH) == targetCalendar.get(Calendar.MONTH)) {
				break
			}
		}

		// Print the final date reached
		println "Final Date Reached: " + dateFormat.format(calendar.getTime())

		// Return the new month, day, and year as a map
		return [newMonth: new SimpleDateFormat("MMMM").format(calendar.getTime()),
			newDay: calendar.get(Calendar.DAY_OF_MONTH),
			newYear: calendar.get(Calendar.YEAR)]
	}


	@Keyword
	def generateMonthsBetween(startMonth, endMonth) {
		def months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']

		def startIndex = months.indexOf(startMonth)
		def endIndex = months.indexOf(endMonth)

		if (startIndex == -1 || endIndex == -1) {
			throw new IllegalArgumentException("Invalid month names")
		}
		// If the start and end months are the same, return from start to the end of the list, then wrap around
		if (startMonth == endMonth) {
			return months[startIndex..-1] + months[0..startIndex - 1]
		}

		// If the start month comes after the end month, wrap around
		if (startIndex <= endIndex) {
			return months[startIndex + 1..endIndex - 1]
		} else {
			return months[startIndex + 1..-1] + months[0..endIndex - 1]
		}
	}

	@Keyword
	def getDateMinusDays(int daysToRemove, Date givenDate = new Date()) {
		def calendar = Calendar.getInstance()
		calendar.setTime(givenDate)
		calendar.add(Calendar.DAY_OF_MONTH, -daysToRemove)

		// Extract the new month, day, and year
		def newMonth = new SimpleDateFormat("MMMM").format(calendar.getTime())
		def newDay = calendar.get(Calendar.DAY_OF_MONTH)
		def newYear = calendar.get(Calendar.YEAR)

		// Format the date as 'MMMM dd, yyyy'
		def formattedDate = new SimpleDateFormat("MMMM dd, yyyy").format(calendar.getTime())

		// Return both the individual elements and the formatted date string
		return [newMonth: newMonth, newDay: newDay, newYear: newYear, formattedDate: formattedDate]
	}

	@Keyword
	def convertToDate(String month, int day, int year) {
		def dateString = "$month $day, $year"
		def dateFormat = new SimpleDateFormat("MMMM dd, yyyy")
		return dateFormat.parse(dateString)
	}

}

