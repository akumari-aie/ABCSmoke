import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys

import com.aventstack.extentreports.Status
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import dataFile.ReadDataFromExcel
import util.CustomReport


CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC_038_039', 'Verify that Guest Users is able to apply Employee Promotions and employee cannot purchase more than 3 quantities of the same ')
.assignCategory(
	'smoke_Test', 'Checkout')

ReadDataFromExcel testdata = new ReadDataFromExcel()

String[] checkout = testdata.getExcelDataByColumn('Checkout', 2)

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_New Arrivals/span_UK _icon'))

WebUI.doubleClick(findTestObject('Object Repository/Page_Michael Kors/div_Sign InCreate An AccountCreate a Michae_6d6ab2'))

WebUI.setText(findTestObject('Page_Michael Kors/input_Close_search-box'), 'totes')

WebUI.sendKeys(findTestObject('Page_Michael Kors/input_Close_search-box'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Page_Michael Kors/svg'))

WebUI.click(findTestObject('Page_Michael Kors/img_QUICKVIEW_product-image'))

WebUI.click(findTestObject('Object Repository/Page_Designer Handbags  Luxury Bags Michael Kors/a_add to bag'))

testLogger.log(Status.INFO, 'Product added to cart')

WebUI.click(findTestObject('Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/a_view full bag'))

testLogger.log(Status.INFO, 'User navigated to cart page')

WebUI.click(findTestObject('Page_Michael Kors/button_1'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/span_3'))

testLogger.log(Status.INFO, 'Product quantity update 3 in cart')

//WebUI.selectOptionByValue(findTestObject('Page_Michael Kors/select_Quantity Dropdown12345'), '3', true)

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_Apply Promo Code_link--block js-boxToggle_733008'))

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_Apply Promo Code_couponCode'), checkout[6])

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/button_Apply'))

testLogger.log(Status.INFO, 'User entered EMP promo and cliked on Apply promo button')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/verify_EmpPromtion'), 5)

testLogger.log(Status.PASS, 'TC_038: User able to apply EMP promotuon in cart is PASS')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/Remove_EmpPromo'))

testLogger.log(Status.INFO, 'Promtoion removed from cart')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/span_13000_caret'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/span_4'))

testLogger.log(Status.INFO, 'Product quantity updated more than 3 in cart')

//WebUI.selectOptionByValue(findTestObject('Page_Michael Kors/select_Quantity Dropdown12345'), '4', true)

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_Apply Promo Code_link--block js-boxToggle_733008'))

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_Apply Promo Code_couponCode'), 'EMP00271519900411')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/button_Apply'))

testLogger.log(Status.INFO, 'User entered EMP promo and cliked on Apply promo button')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/verify_EmpPromoError'), 5)

testLogger.log(Status.PASS, 'TC_039: Promtoion can not apply for more than 3 sku is PASS')


