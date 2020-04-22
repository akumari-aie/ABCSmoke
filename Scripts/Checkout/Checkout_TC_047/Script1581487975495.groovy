import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys
import org.testng.Assert

import com.aventstack.extentreports.Status
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import dataFile.ReadDataFromExcel
import util.CustomReport

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC_047', 'Verify the saving address functionality in Shipping and billing address page')
.assignCategory('smoke_Test', 'Checkout')

ReadDataFromExcel testdata = new ReadDataFromExcel()

String[] accm = testdata.getExcelDataByColumn('AccountManagement', 2)

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

testLogger.log(Status.INFO, 'Navigated to UK site')

WebUI.mouseOver(findTestObject('HomePage/a_SignIn'))

WebUI.click(findTestObject('Object Repository/HomePage/Page_Michael Kors India Designer handbags c_d413dc/a_create an account'))

testLogger.log(Status.INFO, 'Navigated to Creat Account page')

//WebUI.click(findTestObject('Object Repository/HomePage/Page_Account/svg'))
String email = CustomKeywords.'Random.randomemailAddress'()

WebUI.setText(findTestObject('Object Repository/HomePage/Page_Account/input_Email Address_login'), email)

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Object Repository/HomePage/Page_Account/input_Confirm Email Address_email'), email)

WebUI.delay(5)

WebUI.sendKeys(findTestObject('Object Repository/HomePage/Page_Account/input_First Name_firstName'), accm[1])

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Object Repository/HomePage/Page_Account/input_Last Name_lastName'), accm[2])

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/HomePage/Page_Account/input_Password_password'), accm[3])

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/HomePage/Page_Account/input_Confirm Password_confirmPassword'), accm[3])

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Page_Account/input_Confirm Password_confirmPassword'), Keys.chord(Keys.TAB, Keys.SPACE))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/HomePage/Page_Account/input_Remember Me_register_account translate'))

WebUI.delay(5)

WebUI.verifyElementPresent(findTestObject('Object Repository/HomePage/a_AssertProfile'), 20)

testLogger.log(Status.PASS, 'TC_009: Verification of Account creation is Passed')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/span_UK _icon'))

WebUI.click(findTestObject('Page_Michael Kors/svg'))

WebUI.setText(findTestObject('Page_Michael Kors/input_Close_search-box'), 'totes')

WebUI.sendKeys(findTestObject('Page_Michael Kors/input_Close_search-box'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Page_Michael Kors/img_QUICKVIEW_product-image'))

WebUI.click(findTestObject('Object Repository/Page_Designer Handbags  Luxury Bags Michael Kors/a_add to bag'))

testLogger.log(Status.INFO, 'Product added to cart')

WebUI.click(findTestObject('Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/a_view full bag'))

testLogger.log(Status.INFO, 'User navigated to cart page')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/input_13000_atgstoreorderpurchaseCartFormHa_4eb9a7'))

testLogger.log(Status.INFO, 'User navigated to Shipping page')

WebUI.setText(findTestObject('Page_Michael Kors/input_Address_address'), '123')

WebUI.click(findTestObject('Page_Michael Kors/a_123 Breakspeare Road Abbots Langley WD5'))

testLogger.log(Status.INFO, 'Entered the addredd details in Shipping page')

WebUI.click(findTestObject('Page_Michael Kors/span_Select Title'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/span_Ms'))

WebUI.selectOptionByValue(findTestObject('Page_Michael Kors/select_Select Title                      Mr_65db62'), 'Ms', 
    true)

WebUI.setText(findTestObject('Page_Michael Kors/input_First Name_atgcommerceorderpurchaseSh_aa9d23'), 'test')

WebUI.setText(findTestObject('Page_Michael Kors/input_Last Name_atgcommerceorderpurchaseShi_73b465'), 'testname')

WebUI.setText(findTestObject('Page_Michael Kors/input_PhoneNumber_atgcommerceorderpurchaseS_831fd4'), '8795346210')

testLogger.log(Status.INFO, 'Entered the Profile details in Shipping page')

WebUI.click(findTestObject('Page_Michael Kors/button_SHIP TO THIS ADDRESS'))

testLogger.log(Status.INFO, 'Shipping address added in Shipping page')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/span_shipping'))

testLogger.log(Status.INFO, 'User clicked on Add New Address link in Shipping page')

WebUI.setText(findTestObject('Page_Michael Kors/input_Address_address'), '123')

WebUI.click(findTestObject('Page_Michael Kors/a_123 Breakspeare Road Abbots Langley WD5'))

testLogger.log(Status.INFO, 'Entered the Profile details in Shipping page')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/span_Select Title_caret'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/span_Miss'))

WebUI.selectOptionByValue(findTestObject('Page_Michael Kors/select_Select Title                      Mr_65db62_1'), 'Miss', 
    true)

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/s_AddNewName'), 'anu')

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/s_AddNew Laste Name'), 'anz')

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/s_Add NewPhone Numaber'), '8934562346')

testLogger.log(Status.INFO, 'Entered the Profile details in Shipping page')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/label_Make this my default shipping address'))

testLogger.log(Status.INFO, 'Mark makee this default shippingb address in Shipping page')

WebUI.click(findTestObject('Page_Michael Kors/button_Save'))

testLogger.log(Status.INFO, 'New address added in Shipping page')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/img_Secure Checkout_logo'))

WebUI.mouseOver(findTestObject('Object Repository/HomePage/mouseHover_SignIn'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/a_Address Book'))

testLogger.log(Status.INFO, 'User navigated to Address book page')

String newName = WebUI.getText(findTestObject('Object Repository/Page_Michael Kors/p_GetName'))

String name = WebUI.getText(findTestObject('Object Repository/Page_Michael Kors/p_GetFirstName'))

Assert.assertNotEquals(name, newName)

testLogger.log(Status.PASS, 'User navigated to Address book page add saving address from shipping page is pass')



