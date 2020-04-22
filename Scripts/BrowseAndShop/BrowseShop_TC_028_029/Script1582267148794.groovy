import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.aventstack.extentreports.Status as Status
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import util.CustomReport as CustomReport
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC_028_29', 'Verify the user is redirected to home page of the switched country From PLP/PDP').assignCategory(
    'smoke_Test', 'BrowseAndShop')

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.michaelkors.global/en_IN/')

WebUI.maximizeWindow()

testLogger.log(Status.INFO, 'User Navigated to India site')

WebUI.click(findTestObject('Page_Michael Kors India Designer handbags c_d413dc/span_SHOP NOW'))

WebUI.click(findTestObject('Page_Michael Kors UK Designer handbags clot_5e67ef/a_I ACCEPT'))

WebUI.mouseOver(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/a_HandbagMosueHover'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/a_View All Handbags'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/India_Close Subscriotion'))

//WebUI.click(findTestObject('Object Repository/Page_Michael Kors India Designer handbags c_d413dc/a_View All Handbags'))
testLogger.log(Status.INFO, 'User Navigated to PLP in India site')

//WebUI.click(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/a_View All Handbags'))
WebUI.click(findTestObject('Page_Michael Kors/img_QUICKVIEW_product-image'))

testLogger.log(Status.INFO, 'User Navigated to PDP in India site')

WebUI.click(findTestObject('HomePage/span_IN _icon'))

WebUI.delay(2)

testLogger.log(Status.INFO, 'User Navigated Country OverLay PopUp')

WebUI.mouseOver(findTestObject('HomePage/mousehover_UK'))

WebUI.click(findTestObject('Page_Michael Kors India Designer handbags c_d413dc/a_(en)'))

WebUI.verifyElementPresent(findTestObject('Page_Michael Kors UK Designer handbags clot_5e67ef/button_Continue to Michael Kors United Kingdom'), 
    3)

testLogger.log(Status.INFO, 'TC_028: Country Switched from India to UK from PDP')

