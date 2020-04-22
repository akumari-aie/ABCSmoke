import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.aventstack.extentreports.Status
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import util.CustomReport

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC_002', 'To verify the system behaviour when user search for the store from footer section.')
.assignCategory('smoke_Test', 'HomePage')
	
WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/span_Find a Store'))

WebUI.click(findTestObject('Page_Michael Kors/svg'))

testLogger.log(Status.INFO, 'User navigated to Store Locator page')

WebUI.setText(findTestObject('Object Repository/Page_Store Locator  Michael Kors/input_CITY REGION OR POSTCODE_storeCity'), 
    'EH1 3DQ')

testLogger.log(Status.INFO, 'User Enter the zip code in Store Locator page')

WebUI.click(findTestObject('Object Repository/Page_Store Locator  Michael Kors/button_SEARCH'))

testLogger.log(Status.INFO, 'User Click on search Locator in Store Locator page')

WebUI.verifyElementPresent(findTestObject('Object Repository/HomePage/verify_StoreDetails'), 10)

testLogger.log(Status.PASS, 'System displayed store details in Store Locator page')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Page_Store Locator  Michael Kors/a_SEE STORE DETAILS'))

testLogger.log(Status.INFO, 'User Click on See store Details lilnk in Store Locator page')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Page_Store Locator  Michael Kors/a_VIEW THIS STORE'))

testLogger.log(Status.INFO, 'User Click on View store Details lilnk in Store Locator page')

