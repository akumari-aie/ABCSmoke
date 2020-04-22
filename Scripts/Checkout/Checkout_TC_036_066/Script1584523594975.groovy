import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.aventstack.extentreports.Status as Status
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import dataFile.ReadDataFromExcel as ReadDataFromExcel
import util.CustomReport as CustomReport
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC_036_066', 'Verify user not able to apply Any (Order/Item/Shipping level) promotion in cart / Payment page and To verify the Klarna payment method availability in Review and Pay page.')
.assignCategory('smoke_Test', 'Checkout')

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

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_Apply Promo Code_link--block js-boxToggle_733008'))

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_Apply Promo Code_couponCode'), 'Order1')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/button_Apply'))

testLogger.log(Status.INFO, 'User entered promo and cliked on Apply promo button')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/verify_PromoError'), 5)

testLogger.log(Status.PASS, 'TC_036: User not able to apply Order/item/shipping level promotion is PASS')

//Klarna
WebUI.click(findTestObject('Page_Michael Kors/a_Checkout Securely'))

WebUI.click(findTestObject('Page_Michael Kors/input_Continue as a guest_Checkout As Guest'))

testLogger.log(Status.INFO, 'Chceckout As a Guest')

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_ShippingAddress'), '129')

WebUI.delay(2)

WebUI.click(findTestObject('Page_Michael Kors/a_129 Breakspeare Road Abbots Langley WD5'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/label_Make this my billing address'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/button_Select Title'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_Title_ShippinhPage'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Michael Kors/select_Select Title                      Mr_65db62'), 
    'Miss', true)

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_First Name_atgcommerceorderpurchaseSh_aa9d23'), 
    'anamika')

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_Last Name_atgcommerceorderpurchaseShi_73b465'), 
    'kumari')

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_PhoneNumber_atgcommerceorderpurchaseS_831fd4'), 
    '0044 9067224536')

String email = CustomKeywords.'Random.randomemailAddress'()

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_Email Address_atgcommerceorderpurchas_d8765d'), 
    email)

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/span_Yes sign me up By checking this box I _9cbd3b'))

testLogger.log(Status.INFO, 'Added Shipping address')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/button_SHIP TO THIS ADDRESS'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/ReviewAndPayButton'))

testLogger.log(Status.INFO, 'Navigated to Billing page')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_KlarnaPayLater'), 10)

testLogger.log(Status.PASS, 'TC_066: Kalrna Payment Mathod Displayed in Payment Page')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_KlarnaPayOver'), 10)

testLogger.log(Status.PASS, 'TC_066: Kalrna Payment Mathod Displayed in Payment Page')






