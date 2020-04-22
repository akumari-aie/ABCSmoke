import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
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

testLogger = customReport.startTestCase('TC_065', 'To verify Klarna message widget text is displaying in PDP and Shopping Cart page').assignCategory(
    'smoke_Test', 'BrowseAndShop')

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

//WebUI.click(findTestObject('Page_Michael Kors India Designer handbags c_d413dc/button_Continue to Michael Kors India'))
WebUI.click(findTestObject('Page_Michael Kors UK Designer handbags clot_5e67ef/span_UK _icon'))

WebUI.setText(findTestObject('Page_Michael Kors/input_Close_search-box'), 'totes')

WebUI.sendKeys(findTestObject('Page_Michael Kors/input_Close_search-box'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Page_Michael Kors/img_QUICKVIEW_product-image'))

/*if(WebUI.verifyElementPresent(findTestObject('Page_Michael Kors/svg'), 5, FailureHandling.OPTIONAL))
{
	println('Inside if condition')
	WebUI.click(findTestObject('Page_Michael Kors/svg'))
	
}*/
WebUI.click(findTestObject('Page_Michael Kors/svg'))


not_run: WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/img_Learn more_logo'), 
    5)

WebUI.switchToFrame(findTestObject('Object Repository/Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/klarna_frameSwitch'), 10)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/img_Learn more_logo'), 5)
//WebUI.click(findTestObject('Object Repository/Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/img_Learn more_logo'))
//WebUI.click(findTestObject('Object Repository/Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/div_id(katalon-rec_elementInfoDiv)'))
//WebUI.click(findTestObject('Object Repository/Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/a_Learn more'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/a_Close'))

testLogger.log(Status.PASS, 'Klarna Testxt widget ptresent in PDP')

WebUI.click(findTestObject('Object Repository/Page_Designer Handbags  Luxury Bags Michael Kors/a_add to bag'))

WebUI.click(findTestObject('Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/span_Sign In_icon'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/img_Learn more_logo'))

//WebUI.click(findTestObject('Object Repository/Page_Michael Kors/div_id(katalon-rec_elementInfoDiv)'))
WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_Learn more'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_Close'))

testLogger.log(Status.PASS, 'Klarna Testxt widget ptresent in Cart')

