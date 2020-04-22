import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys

import com.aventstack.extentreports.Status as Status
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import dataFile.ReadDataFromExcel
import util.CustomReport as CustomReport

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC_057', 'To verify the ability to allow the shopper to sort by ‘New Arrivals').assignCategory(
    'smoke_Test', 'BrowseAndShop')

ReadDataFromExcel testdata = new ReadDataFromExcel()

String[] search = testdata.getExcelDataByColumn('Search', 2)

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

/**search***/
WebUI.click(findTestObject('Page_Michael Kors UK Designer handbags clot_5e67ef/span_UK _icon'))

	WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_Close_search-box'), search[1])

	testLogger.log(Status.INFO, 'Searched for BAG')

	WebUI.sendKeys(findTestObject('Object Repository/Page_Michael Kors/input_Close_search-box'), Keys.chord(Keys.ENTER))

	WebUI.click(findTestObject('Object Repository/Page_Michael Kors/svg'))

	/*****/

/*WebUI.mouseOver(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/a_HandbagMosueHover'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/a_View All Handbags'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/Click_SubsCription PopUp'))

testLogger.log(Status.INFO, 'User navigated to PLP')*/

//WebUI.delay(2)

//WebUI.scrollToElement(findTestObject('Object Repository/Page_Carmen Small Color-block Saffiano Leat_a28f74/page_Scroll'), 5)
WebUI.click(findTestObject('Object Repository/Page_Designer Handbags  Luxury Bags Michael Kors/Filter_ClickOn SortBy Option'))

//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))

testLogger.log(Status.INFO, 'User Click on SortBy Filter option in PLP')

//WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/Page_Designer Handbags  Luxury Bags Michael Kors/Filter_ClickOn NewArrival Option'))

testLogger.log(Status.INFO, 'User selected NewArrival from SortBy in PLP')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Designer Handbags  Luxury Bags Michael Kors/verify_NewArrival Filtered'), 
    5)

testLogger.log(Status.PASS, 'New Arrivals products are diplaying in PLP is PASS')

