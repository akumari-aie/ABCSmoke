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

testLogger = customReport.startTestCase('TC_037', 'To Verify that user is able to navigate from a Member PDP to Master PDP from Shop Now link.').assignCategory(
    'smoke_Test', 'BrowseAndShop')

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Store Locator  Michael Kors/span_UK _icon'))

WebUI.setText(findTestObject('Page_Michael Kors/input_Close_search-box'), 'look')

WebUI.sendKeys(findTestObject('Page_Michael Kors/input_Close_search-box'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/svg'))

//if(CustomKeywords.'Random.assertElementPresent'('Object Repository/Page_Michael Kors/svg'))
/*if(WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/svg'),10))
{
	WebUI.click(findTestObject('Object Repository/Page_Michael Kors/svg'))
}
*/
//WebUI.click(findTestObject('Page_Michael Kors/svg'))
WebUI.click(findTestObject('Page_Michael Kors/img_3200 to 16700_product-image'))

//WebUI.click(findTestObject('Object Repository/Page_Michael Kors/c_ClickOnSelectBelowItem'))
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/c_ClickOnMemberProduct'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_VerifyPdpdPage'), 5)

testLogger.log(Status.PASS, 'User navigated to PDP member page from Look PDP')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_shopNowLink'), 10)

testLogger.log(Status.PASS, 'Shop Now Link is present in Member PDP')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_shopNowLink'))

testLogger.log(Status.INFO, 'Click on Shop Now Link in Member PDP')

WebUI.verifyElementPresent(findTestObject('Page_Sequined Puffer Jacket Logo T-shirt Je_20b822/button_BUY ALL (4)'), 10)

testLogger.log(Status.PASS, 'User anvigated to LOOK PDP from Member PDP')


