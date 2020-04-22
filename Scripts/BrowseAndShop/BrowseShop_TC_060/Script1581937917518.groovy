import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys

import com.aventstack.extentreports.Status
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import dataFile.ReadDataFromExcel
import util.CustomReport

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC_060', 'To verify the video products in quick view and PDP')
.assignCategory(
	'smoke_Test', 'BrowseAndShop')

ReadDataFromExcel testdata = new ReadDataFromExcel()
String[] search = testdata.getExcelDataByColumn('Search', 2)

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Michael Kors UK Designer handbags clot_5e67ef/span_UK _icon'))

WebUI.setText(findTestObject('Page_Michael Kors/input_Close_search-box'), search[8])

WebUI.sendKeys(findTestObject('Page_Michael Kors/input_Close_search-box'), Keys.chord(Keys.ENTER))

WebUI.delay(5)

WebUI.click(findTestObject('Page_Michael Kors/svg'))

WebUI.delay(2)

//WebUI.click(findTestObject('Page_Michael Kors/button_QUICKVIEW'))


//WebUI.mouseOver(findTestObject('Page_Designer Handbags  Luxury Bags Michael Kors/button_QUICKVIEW'))

WebUI.click(findTestObject('Page_Designer Handbags  Luxury Bags Michael Kors/button_QUICKVIEW'))

testLogger.log(Status.INFO, 'QV modal displayed')

WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/div_Next_playPauseBtn-vvw-qv-desktop-30S0SNMS1B'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_Verify Video'), 10)

testLogger.log(Status.PASS, 'Vedio Verified on QV')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_View Full Details'))

testLogger.log(Status.INFO, 'NAvigated to PDP')

WebUI.click(findTestObject('Object Repository/Page_Carmen Small Logo And Leather Belted S_4eba4a/svg'))

WebUI.click(findTestObject('Object Repository/Page_Carmen Small Logo And Leather Belted S_4eba4a/div_carmen small logo and leather belted sa_16d9da_1'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_Verify Video'), 10)

testLogger.log(Status.PASS, 'Vedio Verified on PDP')

