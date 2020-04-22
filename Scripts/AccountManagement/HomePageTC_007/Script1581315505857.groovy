import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.aventstack.extentreports.Status as Status
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
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


WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.michaelkors.global/en_IN/')

//WebUI.navigateToUrl('https://sit2.michaelkors.global/en_IN/')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Page_Michael Kors India Designer handbags c_d413dc/span_SHOP NOW'))
//WebUI.click(findTestObject('Page_Michael Kors India Designer handbags c_d413dc/button_Continue to Michael Kors India'))

WebUI.waitForPageLoad(2)

WebUI.click(findTestObject('HomePage/span_IN _icon'))

WebUI.delay(2)

WebUI.mouseOver(findTestObject('HomePage/mousehover_UK'))

WebUI.click(findTestObject('Page_Michael Kors India Designer handbags c_d413dc/a_(en)'))

WebUI.delay(2)

//WebUI.click(findTestObject('Page_Michael Kors India Designer handbags c_d413dc/languageEnglish'))
WebUI.click(findTestObject('Page_Michael Kors UK Designer handbags clot_5e67ef/button_Continue to Michael Kors United Kingdom'))

WebUI.click(findTestObject('Page_Michael Kors UK Designer handbags clot_5e67ef/a_I ACCEPT'))



