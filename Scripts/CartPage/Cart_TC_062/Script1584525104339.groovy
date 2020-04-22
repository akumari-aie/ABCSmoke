import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

testLogger = customReport.startTestCase('TC_062', ' Verify the display of product recommendations in empty cart and wishlist landing page')
.assignCategory('smoke_Test', 'Shopping cart')
    
WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/span_Sign In_icon'))

testLogger.log(Status.INFO, 'User Navigated to cart')

//WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/verify_rfk in PDP'), 
  //  10)

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/verify_rfk in PDP'), 10)

testLogger.log(Status.PASS, 'RFK products are not displaying in Empty cart')



