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

testLogger = customReport.startTestCase('TC_034', 'Verify that user able to add a product from "You might like" section of Cart page.')
.assignCategory(    'smoke_Test', 'Shopping cart')

ReadDataFromExcel testdata = new ReadDataFromExcel()

String[] setup = testdata.getExcelDataByColumn('Setup', 2)

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.mouseOver(findTestObject('HomePage/a_SignIn'))

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/input_Email Address_email'), 
    setup[3])

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/input_Password_password'), 
    setup[4])

WebUI.click(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/button_Sign In'))

WebUI.delay(1)

testLogger.log(Status.INFO, 'User sign in to profile')

WebUI.click(findTestObject('Object Repository/Page_Account/Click On Search'))

WebUI.setText(findTestObject('Page_Michael Kors/input_Close_search-box'), 'totes')

WebUI.sendKeys(findTestObject('Page_Michael Kors/input_Close_search-box'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/svg'))

WebUI.click(findTestObject('Page_Michael Kors/img_QUICKVIEW_product-image'))

WebUI.click(findTestObject('Page_Michael Kors/a_add to bag'))

testLogger.log(Status.INFO, 'User added product to cart from PDP')

WebUI.click(findTestObject('Object Repository/Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/span_Sign Out_icon'))

testLogger.log(Status.INFO, 'User navigated to cart from PDP')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/verify_rfk product in cart'), 10)

testLogger.log(Status.PASS, 'RFK product displaying in cart is PASS')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_QUICKVIEW'))

testLogger.log(Status.INFO, 'Add rfk product to cart from qv')
	
WebUI.click(findTestObject('Object Repository/Page_Michael Kors/input_26000_addToBag'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/verify_rfk product added to cart'), 5)
testLogger.log(Status.PASS, 'RFK product in cart added to cart is PASS')
