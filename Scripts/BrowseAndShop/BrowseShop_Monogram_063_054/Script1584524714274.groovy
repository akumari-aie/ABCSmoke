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

testLogger = customReport.startTestCase('TC_063_054', 'Verify the functionality of Monogramming, ADD, Edit and Delete monograme Text/product from Cart.')
.assignCategory('smoke_Test','BrowseAndShop')

ReadDataFromExcel testdata = new ReadDataFromExcel()

String[] search = testdata.getExcelDataByColumn('Search', 2)

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Michael Kors UK Designer handbags clot_5e67ef/span_UK _icon'))

WebUI.setText(findTestObject('Page_Michael Kors/input_Close_search-box'), search[7])

WebUI.sendKeys(findTestObject('Page_Michael Kors/input_Close_search-box'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Page_Michael Kors/svg'))

//WebUI.click(findTestObject('Page_Michael Kors/button_QUICKVIEW'))
WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_michael michael kors'))

WebUI.click(findTestObject('Page_Michael Kors/a_add to bag'))

//WebUI.click(findTestObject('Page_Michael Kors/button_QUICKVIEW'))
WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_MONOGRAM IT'))

testLogger.log(Status.INFO, 'Clicked on Monogram link on PDP')

//WebUI.waitForPageLoad(2)
WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_Jet Set Large Saffiano Leather Top-zip_9e0e78/h3_GLITTER GOLDMonogram'))

testLogger.log(Status.INFO, 'Navigated on Fluid PDP')

WebUI.click(findTestObject('Object Repository/Page_Jet Set Large Saffiano Leather Top-zip_9e0e78/span_YELLOW_fc-swatch'))

WebUI.setText(findTestObject('Object Repository/Page_Jet Set Large Saffiano Leather Top-zip_9e0e78/input_Complimentary_text79282'), 
    'ANZ')

testLogger.log(Status.INFO, 'Entered Monogram Text')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Page_Jet Set Large Saffiano Leather Top-zip_9e0e78/span_Add to Bag'))

WebUI.click(findTestObject('Object Repository/Page_Jet Set Large Saffiano Leather Top-zip_9e0e78/a_view full bag'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_assertMonogramItemInCart'), 10)

testLogger.log(Status.PASS, 'TC_063: Monogram added to Cart is Passed')

//WebUI.click(findTestObject('Object Repository/Page_Michael Kors/div_27000_ajax_overlay'))
WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_Remove Monogram'))

testLogger.log(Status.INFO, 'Clicked On Remove monogram link in cart')

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Michael Kors/a_assertMonogramItemInCart'), 10)

testLogger.log(Status.PASS, 'TC_054: Monogram link is removed from cart')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_MONOGRAM IT_1'))

testLogger.log(Status.INFO, 'Clicked On Edit monogram item from cart')

WebUI.click(findTestObject('Object Repository/Page_Jet Set Large Saffiano Leather Top-zip_9e0e78/h3_GLITTER GOLDMonogram'))

WebUI.setText(findTestObject('Object Repository/Page_Jet Set Large Saffiano Leather Top-zip_9e0e78/input_Complimentary_text79282'), 
    'ANU')

WebUI.click(findTestObject('Object Repository/Page_Jet Set Large Saffiano Leather Top-zip_9e0e78/span_GREEN_fc-swatch'))

WebUI.delay(10)

WebUI.click(findTestObject('Object Repository/Page_Jet Set Large Saffiano Leather Top-zip_9e0e78/span_Add to Bag'))

WebUI.click(findTestObject('Object Repository/Page_Jet Set Large Saffiano Leather Top-zip_9e0e78/span_Sign In_icon'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_assertMonogramItemInCart'), 10)

testLogger.log(Status.PASS, 'TC_054: Edit monogram product from cart is Passed')

not_run: WebUI.closeBrowser()

WebUI.click(findTestObject('Object Repository/Page_Carmen Small Color-block Saffiano Leat_a28f74/a_RemoveMono'))
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Carmen Small Color-block Saffiano Leat_a28f74/A_MonogrameRemoved'), 10)

testLogger.log(Status.PASS, 'TC_054: Monogram product got Removed from cart is Passed')



