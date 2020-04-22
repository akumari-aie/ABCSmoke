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

testLogger = customReport.startTestCase('TC_041_042_046', 'Verify that user is able to add addresses from Manual address form in shipping page.').assignCategory(
    'smoke_Test', 'Checkout')

ReadDataFromExcel testdata = new ReadDataFromExcel()

String[] search = testdata.getExcelDataByColumn('Search', 2)

String[] checkout = testdata.getExcelDataByColumn('Checkout', 2)

//WebUI.click(findTestObject('Page_Michael Kors India Designer handbags c_d413dc/button_Continue to Michael Kors India'))
WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Michael Kors UK Designer handbags clot_5e67ef/span_UK _icon'))

WebUI.setText(findTestObject('Page_Michael Kors/input_Close_search-box'), search[1])

WebUI.sendKeys(findTestObject('Page_Michael Kors/input_Close_search-box'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Page_Michael Kors/svg'))

WebUI.click(findTestObject('Page_Michael Kors/img_QUICKVIEW_product-image'))

//WebUI.click(findTestObject('Object Repository/Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/div_Tab to the end of the page to access th_5fd8e3'))
WebUI.click(findTestObject('Object Repository/Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/span__Select-arrow'))

WebUI.click(findTestObject('Object Repository/Page_Designer Handbags  Luxury Bags Michael Kors/a_add to bag'))

WebUI.click(findTestObject('Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/span_Sign In_icon'))

WebUI.click(findTestObject('Page_Michael Kors/a_Checkout Securely'))

WebUI.click(findTestObject('Page_Michael Kors/input_Continue as a guest_Checkout As Guest'))

testLogger.log(Status.INFO, 'Guest user navigated to shippinhg page')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_Enter address manually'))

testLogger.log(Status.INFO, 'Guest user click on Enter address manually')

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_Address line 1 _atgcommerceorderpurch_726252'), 
    checkout[9])

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_Town or City _atgcommerceorderpurchas_094173'), 
    checkout[10])

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_Postcode _atgcommerceorderpurchaseShi_92380f'), 
    checkout[11])

testLogger.log(Status.INFO, 'Guest user Entered the address in shippinhg page')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/div_Address line 2'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/div_Where are you shipping to              _dd163a'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/input_Postcode _atgcommerceorderpurchaseShi_de557c'))

WebUI.click(findTestObject('Page_Michael Kors/span_Select Title'))

WebUI.click(findTestObject('Page_Michael Kors/a_Ms'))

WebUI.selectOptionByValue(findTestObject('Page_Michael Kors/select_Select Title                      Mr_65db62'), 'Ms', 
    true)

WebUI.click(findTestObject('Page_Michael Kors/input_First Name_atgcommerceorderpurchaseSh_aa9d23'))

WebUI.setText(findTestObject('Page_Michael Kors/input_First Name_atgcommerceorderpurchaseSh_aa9d23'), checkout[3])

WebUI.setText(findTestObject('Page_Michael Kors/input_Last Name_atgcommerceorderpurchaseShi_73b465'), checkout[4])

WebUI.setText(findTestObject('Page_Michael Kors/input_PhoneNumber_atgcommerceorderpurchaseS_831fd4'), checkout[5])

WebUI.setText(findTestObject('Page_Michael Kors/input_Email Address_atgcommerceorderpurchas_d8765d'), 'produk0220@mailinator.com')

testLogger.log(Status.INFO, 'Guest user Enetred the profile details in shippinhg page')

WebUI.click(findTestObject('Page_Michael Kors/button_SHIP TO THIS ADDRESS'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_AssertShippingAddressAdded'), 10)

testLogger.log(Status.PASS, 'TC_046_Guest user able to add address manually in shipping page is Pass')

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Michael Kors/verify_DeletAddressLink'), 5)

testLogger.log(Status.PASS, 'TC_041_Delete Address link is not present in shipping page is Pass')
	
WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_Continue to Review  Pay'))

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Michael Kors/verify_DeletAddressLink'), 5)

testLogger.log(Status.PASS, 'TC_041_Delete Address link is not present in Billing page is Pass')

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Michael Kors/verify_CheckGiftCard Balance'), 5)

testLogger.log(Status.PASS, 'TC_042_Check Gift Card balance is not present in Billing page is Pass')



