import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.aventstack.extentreports.Status as Status
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import dataFile.ReadDataFromExcel as ReadDataFromExcel
import util.CustomReport as CustomReport

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC_040', 'Verify that user is able to sign in from the cart page').assignCategory(
    'smoke_Test', 'Checkout')

ReadDataFromExcel testdata = new ReadDataFromExcel()

String[] setup = testdata.getExcelDataByColumn('Setup', 2)

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Michael Kors UK Designer handbags clot_5e67ef/span_UK _icon'))

WebUI.setText(findTestObject('Page_Michael Kors/input_Close_search-box'), 'totes')

WebUI.sendKeys(findTestObject('Page_Michael Kors/input_Close_search-box'), Keys.chord(Keys.ENTER))

testLogger.log(Status.INFO, 'Searched for product')

WebUI.click(findTestObject('Page_Michael Kors/img_QUICKVIEW_product-image'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/svg'))

WebUI.click(findTestObject('Object Repository/Page_Designer Handbags  Luxury Bags Michael Kors/a_add to bag'))

testLogger.log(Status.INFO, 'Product added to cart')

WebUI.doubleClick(findTestObject('Object Repository/Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/h6_Shopping Bag'))

WebUI.click(findTestObject('Object Repository/Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/a_view full bag'))

testLogger.log(Status.INFO, 'Navigated to cart page')

WebUI.click(findTestObject('Page_Michael Kors/a_Checkout Securely'))

testLogger.log(Status.INFO, 'Click on Checkout Button')

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_Email Address_login'), setup[3])

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/checkout_Enter Password'), setup[4])

testLogger.log(Status.INFO, 'Entered Login credential')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/input_Details_sign-in-submit'))

WebUI.delay(2)

testLogger.log(Status.INFO, 'Click on Sign In button from cart')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/Verify_ShippingPage'), 5)

testLogger.log(Status.PASS, 'Sign in from cart is Pass and User navigated to shipping page')

