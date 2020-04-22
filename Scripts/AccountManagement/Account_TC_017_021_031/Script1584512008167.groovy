import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

import com.aventstack.extentreports.Status as Status
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import dataFile.ReadDataFromExcel as ReadDataFromExcel
import util.CustomReport as CustomReport

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC_017_021_031', 'Verify that user is able to add Products to favorites and view the same in favorites page.').assignCategory(
		'smoke_Test', 'Account')

ReadDataFromExcel testdata = new ReadDataFromExcel()

String[] setup = testdata.getExcelDataByColumn('Setup', 2)

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

//WebUI.click(findTestObject('Object Repository/HomePage/a_Accept'))
WebUI.delay(2)

WebUI.mouseOver(findTestObject('HomePage/a_SignIn'))

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/input_Email Address_email'),
		setup[5])

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/input_Password_password'),
		setup[6])

WebUI.click(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/button_Sign In'))

WebUI.delay(1)

WebUI.verifyElementPresent(findTestObject('Object Repository/HomePage/mouseHover_SignIn'), 5)

testLogger.log(Status.PASS, 'User sign in to account')

WebUI.click(findTestObject('Page_Michael Kors UK Designer handbags clot_5e67ef/span_UK _icon'))

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_Close_search-box'), 'Totes')

testLogger.log(Status.INFO, 'Searched for BAG')

WebUI.sendKeys(findTestObject('Object Repository/Page_Michael Kors/input_Close_search-box'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/svg'))

WebUI.click(findTestObject('Page_Designer Handbags  Luxury Bags Michael Kors/img_QUICKVIEW_product-image'))

//WebUI.click(findTestObject('Page_Michael Kors/svg'))

testLogger.log(Status.INFO, 'User Navigated to PDP')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Page_Carmen Small Color-block Saffiano Leat_a28f74/i_View Full Details_mk-favourite-icon'))

WebUI.delay(2)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/verify_ProductAddedToFav in PDP'), 10)

testLogger.log(Status.PASS, 'Product added to favourite page is PASS')

WebUI.mouseOver(findTestObject('Object Repository/HomePage/mouseHover_SignIn'))

WebUI.click(findTestObject('Object Repository/Page_Carmen Small Color-block Saffiano Leat_a28f74/a_Favorites'))

testLogger.log(Status.INFO, 'User Navigated to Favourite page')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/verify_ProductInFav page'), 10)

testLogger.log(Status.PASS, 'Product displaying in Favourite page is PASS')

WebUI.click(findTestObject('Page_Michael Kors/a_Edit'))

testLogger.log(Status.INFO, 'Click on Edit button in Favourite page')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_1'))

WebUI.click(findTestObject('Page_Michael Kors/a_2'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/verify_FavProduct Edited'),10)

testLogger.log(Status.PASS, 'TC_021: Upadted quantity in Edit QV modal in Favourite page')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/button_close'))

testLogger.log(Status.INFO, 'Closed Edit QV modal in Favourite page')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/input_Edit_changed_input translate getvalue'))

testLogger.log(Status.INFO, 'Click on Add to bag in Favourite page')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_AssertProductAddedToCart'), 10)

testLogger.log(Status.PASS, 'TC_031: Product Added to cart from Favourite page')

WebUI.click(findTestObject('Page_Michael Kors/a_Remove'))

testLogger.log(Status.INFO, 'Click on Remove product button in Favourite page')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/span_OK'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/verify_Product Removed From FAV'), 2)

testLogger.log(Status.PASS, 'TC_021: Product removed from Favourite page')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/verify_Product Removed From FAV'))

testLogger.log(Status.INFO, 'Click on Shop Now from Favourite page')

