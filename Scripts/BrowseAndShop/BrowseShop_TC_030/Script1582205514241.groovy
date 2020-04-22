import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys

import com.aventstack.extentreports.Status
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import dataFile.ReadDataFromExcel as ReadDataFromExcel
import util.CustomReport as CustomReport

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC_030', 'Verify the display of size is classified with locale and also with US (EX: US12/UK16)').assignCategory(
    'smoke_Test', 'BrowseAndShop')

ReadDataFromExcel testdata = new ReadDataFromExcel()

String[] search = testdata.getExcelDataByColumn('Search', 2)

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Michael Kors UK Designer handbags clot_5e67ef/span_UK _icon'))

WebUI.setText(findTestObject('Page_Michael Kors/input_Close_search-box'), search[3])

WebUI.sendKeys(findTestObject('Page_Michael Kors/input_Close_search-box'), Keys.chord(Keys.ENTER))

testLogger.log(Status.INFO, 'User Search for product')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/svg'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_michael michael kors'))

testLogger.log(Status.INFO, 'User Navigated to PDP')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/verify_UkSize'), 2)

testLogger.log(Status.PASS, 'TC_030: display of size is classified with locale is PASS')



