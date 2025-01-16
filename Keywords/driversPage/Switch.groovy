package driversPage

import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import internal.GlobalVariable
import io.appium.java_client.android.AndroidDriver




public class Switch {

	static driver = null

	/*@Keyword
	 def launchMobileDevice(deviceName = "Galaxy S23 Ultra", platformVersion = "13", grantPermission = false) {
	 RunConfiguration.setDriverPreferencesProperty('Remote',  "deviceName" , deviceName)
	 RunConfiguration.setDriverPreferencesProperty('Remote', "platformVersion", platformVersion)
	 RunConfiguration.setDriverPreferencesProperty('Remote', "autoGrantPermissions", grantPermission    )
	 }*/

	@Keyword
	def setWebBrowser(String testCaseName){

		def nameToDisplay = testCaseName
		DesiredCapabilities caps = new DesiredCapabilities()
		caps.setCapability("os", "Windows")
		caps.setCapability("os_version", "10")
		caps.setCapability("browser", "Chrome")
		caps.setCapability("browser_version", "latest")
		caps.setCapability("browserstack.local", "false")
		caps.setCapability("browserstack.selenium_version", "3.14.0")
		caps.setCapability("resolution", "1920x1080")

		caps.setCapability("project", "sales")
		caps.setCapability("build", "TestcaseID")
		caps.setCapability("name", nameToDisplay)

		driver = new RemoteWebDriver(new URL("http://expenses_gkna7o:YCVGzwZUexSELmAqjrMg@hub-cloud.browserstack.com/wd/hub"), caps);

		DriverFactory.changeWebDriver(driver)
		println '-------- driver = ' + driver
	}

	@Keyword
	def getBrowserStackAndroidChromeDriver(String testCaseName){

		def nameToDisplay = testCaseName
		DesiredCapabilities caps = new DesiredCapabilities()
		caps.setCapability("browserstack.user", "expenses_gkna7o")
		caps.setCapability("browserstack.key", "YCVGzwZUexSELmAqjrMg")
		caps.setCapability("device", "Google Pixel 8 Pro")
		caps.setCapability("os_version", "14.0")

		//caps.setCapability("browser", "Chrome")
		caps.setCapability("real_mobile", true)
		//caps.setCapability("buildIdentifier", ${DATE_TIME})

		//To hide keyboard
		caps.setCapability("unicodeKeyboard", true);
		caps.setCapability("resetKeyboard", true);

		caps.setCapability("app", GlobalVariable.memberAppAndroid)

		caps.setCapability("project", "Sales")
		caps.setCapability("build", "SalesTest")
		caps.setCapability("name", nameToDisplay)


		driver = new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), caps);
		MobileDriverFactory.setDriver(driver)

		//driver = new RemoteWebDriver(new URL("http://hub.browserstack.com/wd/hub"), caps);

		//DriverFactory.changeWebDriver(driver)
		//println '-------- driver = ' + driver
	}
}
