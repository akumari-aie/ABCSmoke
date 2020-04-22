import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.testng.Assert as Assert
import com.aventstack.extentreports.Status as Status
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
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

testLogger = customReport.startTestCase('TC_025', 'Verify that guest and logged in user able to navigate to PDP by browsing the products through department and sub-category navigations.').assignCategory(
    'smoke_Test', 'BrowseAndShop')

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/a_HandbagMosueHover'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/a_View All Handbags'))

WebUI.click(findTestObject('Page_Michael Kors/svg'))

//WebUI.click(findTestObject('Object Repository/Page_Michael Kors/close subscription'))

//WebUI.click(findTestObject('Object Repository/Page_Michael Kors/Click_SubsCription PopUp'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/span_ProductBrandName'))



WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_VerifyPdpdPage'), 5)

testLogger.log(Status.PASS, 'User navigated to PDP page from SybCategory is Passed')

not_run: WebUI.closeBrowser()

//WebUI.switchToFrame(findTestObject('Object Repository/Page_Michael Kors/Klarna Assertion'), 10)

//WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/verify_KlarnaText'), 5)

//WebUI.getText(findTestObject(null))
//WebUI.verifyTextPresent('Pay in 3 instalments of', true)
//testLogger.log(Status.PASS, 'TC_065 Kalrna text present on PDP')

