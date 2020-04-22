import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys

import com.aventstack.extentreports.Status
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import util.CustomReport as CustomReport

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC_027', 'Verify the recommended products are coming from the RFK').assignCategory(
    'smoke_Test', 'BrowseAndShop')

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Michael Kors UK Designer handbags clot_5e67ef/span_UK _icon'))

WebUI.setText(findTestObject('Page_Michael Kors/input_Close_search-box'), 'totes')

WebUI.sendKeys(findTestObject('Page_Michael Kors/input_Close_search-box'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Page_Michael Kors/svg'))

WebUI.click(findTestObject('Page_Michael Kors/img_QUICKVIEW_product-image'))

testLogger.log(Status.INFO, 'User Navigated to PDP')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/verify_rfk in PDP'), 10)

testLogger.log(Status.PASS, 'TC_027: RFK products are displaying in PDP is PASS')

WebUI.click(findTestObject('Object Repository/Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/button_QUICKVIEW'))

WebUI.click(findTestObject('Object Repository/Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/rfk_AddToBag'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_AssertProductAddedToCart'),5)

testLogger.log(Status.PASS, 'TC_027: RFK added to cart from PDP QV modal is PASS')



