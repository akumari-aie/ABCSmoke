import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.testng.Assert as Assert
import com.aventstack.extentreports.Status as Status
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import util.CustomReport as CustomReport
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC_043_044_045', 'Verify that user able to Add shiiping Through QAS and user able to Enter emmail in shipping and Edit shippingand Billing address check out pages')
.assignCategory('smoke_Test', 'Checkout')

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Michael Kors UK Designer handbags clot_5e67ef/span_UK _icon'))

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_Close_search-box'), 'bag')

WebUI.sendKeys(findTestObject('Object Repository/Page_Michael Kors/input_Close_search-box'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/svg'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_michael michael kors'))

WebUI.click(findTestObject('Object Repository/Page_Designer Handbags  Luxury Bags Michael Kors/a_add to bag'))

WebUI.click(findTestObject('Object Repository/Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/span_Sign In_icon'))

testLogger.log(Status.INFO, 'Guest user navigated to Cart')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_Checkout Securely'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/input_Continue as a guest_Checkout As Guest'))

WebUI.delay(2)

testLogger.log(Status.INFO, 'Guest User Navigated to Shipping page')

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

testLogger.log(Status.PASS, 'TC_043_Guest user able to enter email in shipping page is pass')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/span_Yes sign me up By checking this box I _9cbd3b'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/button_SHIP TO THIS ADDRESS'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_AssertShippingAddressAdded'), 10)

testLogger.log(Status.PASS, 'TC_045: Shipping addredd added to shipping pageThrough QAS as a guest user is Passed')

String name = WebUI.getText(findTestObject('Object Repository/Page_Michael Kors/a_Before Edit address'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_Edit  shipping   this  address'))

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_First Name_atgcommerceorderpurchaseSh_aa9d23_1'), 
    'anu')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/label_Make this my billing address_1'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/editShipping_SaveButton'))

String editName = WebUI.getText(findTestObject('Object Repository/Page_Michael Kors/a_Before Edit address'))

Assert.assertNotEquals(name, editName)

testLogger.log(Status.PASS, 'TC_044: Shipping addredd Edited to shipping page as a guest user is Passed')

/*WebUI.click(findTestObject('Object Repository/Page_Michael Kors/div_Saturday   1000           Your order wi_dbf305'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/span_Select items to gift wrap for  350  each'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/label_Jet Set Large Saffiano Leather Top-Zi_5b42b8'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_Add Note'))

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/textarea_Remove Note_add-note2'), 'rdctyfvuygbh')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_AssertGWapplied'), 10)

testLogger.log(Status.PASS, 'Gift wrap and Note is applied in shipping page as a guest user is Passed')*/

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_Continue to Review  Pay'))

testLogger.log(Status.INFO, 'Guest user navigated to Billing Page')

String name1 = WebUI.getText(findTestObject('Object Repository/Page_Michael Kors/b_Verify BillingAddress Edited'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/b_Edit Billing Address'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/b_edit Name Billing address'))

//WebUI.clearText('Object Repository/Page_Michael Kors/b_edit Name Billing address')

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/b_edit Name Billing address'), 'TestName')

//WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/b_Modify FirstName'), 'TestName')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/b_Save Edit BillingAddress'))

String editName1 = WebUI.getText(findTestObject('Object Repository/Page_Michael Kors/b_Verify BillingAddress Edited'))

Assert.assertNotEquals(name1, editName1)

testLogger.log(Status.PASS, 'TC_44: Billing addredd Edited in Billing page as a guest user is Passed')

not_run: WebUI.closeBrowser()

