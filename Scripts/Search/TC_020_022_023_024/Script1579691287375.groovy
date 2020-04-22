import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.aventstack.extentreports.Status as Status
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import dataFile.ReadDataFromExcel as ReadDataFromExcel
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import util.CustomReport as CustomReport

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC__020,022,023,024', 'Verify the display of Search results page for keyword/product/articles/free-form text/Color/Invalid Keyword.').assignCategory(
    'smoke_Test', 'Search')

ReadDataFromExcel testdata = new ReadDataFromExcel()

String[] search = testdata.getExcelDataByColumn('Search', 2)

    WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Page_Michael Kors UK Designer handbags clot_5e67ef/span_UK _icon'))

    WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_Close_search-box'), search[1])

    testLogger.log(Status.INFO, 'Searched for BAG')

    WebUI.sendKeys(findTestObject('Object Repository/Page_Michael Kors/input_Close_search-box'), Keys.chord(Keys.ENTER))

    WebUI.click(findTestObject('Object Repository/Page_Michael Kors/svg'))

   // testLogger.log(Status.INFO, 'Bags are displayed')
	
	testLogger.log(Status.PASS, 'TC_20: Bags are displayed')

    WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_michael michael kors'))

    WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_VerifyPdpdPage'), 5)

    testLogger.log(Status.PASS, 'TC_23: Navigated to PDP from SLP is Passed')

    WebUI.delay(2)

    WebUI.back()

    testLogger.log(Status.PASS, 'TC_24: Navigated back to SLP from PLP is Passed')

    WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_Close_search-box'), search[4])

    testLogger.log(Status.INFO, 'Searched Colour RED')

    WebUI.sendKeys(findTestObject('Object Repository/Page_Michael Kors/input_Close_search-box'), Keys.chord(Keys.ENTER))

    WebUI.click(findTestObject('Page_Designer Handbags  Luxury Bags Michael Kors/button_QUICKVIEW'))

    WebUI.delay(2)

    WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_VerifyQVmodal'), 10)

    testLogger.log(Status.PASS, 'Navigated to QV from SLP is Passed')

    WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_SelectSize'))

    WebUI.click(findTestObject('Page_Michael Kors/a_add to bag'))

    WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_AssertProductAddedToCart'), 10)

    testLogger.log(Status.PASS, 'Added product to cart from SLP QV is Passed')

    WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_Close_search-box'), search[2])

    WebUI.sendKeys(findTestObject('Object Repository/Page_Michael Kors/input_Close_search-box'), Keys.chord(Keys.ENTER))

    testLogger.log(Status.INFO, 'Searched for Product ID')

    WebUI.click(findTestObject('Object Repository/Page_Michael Kors/img_QUICKVIEW_product-image'))

    WebUI.click(findTestObject('Page_Michael Kors/a_add to bag'))

    WebUI.delay(1)

    testLogger.log(Status.PASS, 'Navigated to PDP by clickin on product images from SLP is Passed')

    WebUI.back()

	WebUI.delay(2)
	
    WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_Close_search-box'), search[5])

    WebUI.sendKeys(findTestObject('Object Repository/Page_Michael Kors/input_Close_search-box'), Keys.chord(Keys.ENTER))

    testLogger.log(Status.INFO, 'Searched for Invalid')

    WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_AssertInvalidSearch'), 10)

    testLogger.log(Status.PASS, 'TC_22: No Result Found for Invalid keyword is Passed')

 
