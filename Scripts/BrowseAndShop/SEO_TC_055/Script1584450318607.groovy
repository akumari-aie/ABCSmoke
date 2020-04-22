import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/a_HandbagMosueHover'))

//WebUI.click(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/a_View All Handbags'))

//WebUI.click(findTestObject('Object Repository/Page_Michael Kors/Click_SubsCription PopUp'))

//WebUI.click(findTestObject('Object Repository/Page_Michael Kors/span_ProductBrandName'))

//WebUI.click(findTestObject('Page_Michael Kors/svg'))

//WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_VerifyPdpdPage'), 5)

WebUI.navigateToUrl('view-source:https://www.michaelkors.co.uk/carmen-small-saffiano-leather-belted-satchel/_/R-30S0SNMS0L?color=2688')

