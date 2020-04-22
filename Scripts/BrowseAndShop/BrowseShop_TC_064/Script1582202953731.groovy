import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys

import com.aventstack.extentreports.Status
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import dataFile.ReadDataFromExcel as ReadDataFromExcel
import util.CustomReport as CustomReport

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC_064', 'Verify the Click and collect functionality in PDP and able to add C&C item to cart to proced to checkout page').assignCategory(
    'smoke_Test', 'BrowseAndShop')

ReadDataFromExcel testdata = new ReadDataFromExcel()

String[] search = testdata.getExcelDataByColumn('Search', 2)

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Michael Kors UK Designer handbags clot_5e67ef/span_UK _icon'))

WebUI.setText(findTestObject('Page_Michael Kors/input_Close_search-box'), search[8])

WebUI.sendKeys(findTestObject('Page_Michael Kors/input_Close_search-box'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Page_Michael Kors/svg'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/span_ProductBrandName'))

testLogger.log(Status.INFO, 'User navigated to PDP')

WebUI.click(findTestObject('Object Repository/Page_Designer Handbags  Luxury Bags Michael Kors/verify_CnC Feild on PDP'))

testLogger.log(Status.INFO, 'CnC Feild is displaying in PDP')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Designer Handbags  Luxury Bags Michael Kors/verify_CnC PopUp'), 
    5)

testLogger.log(Status.PASS, 'CnC PopUp Displayed in PDP')

WebUI.sendKeys(findTestObject('Object Repository/Page_Designer Handbags  Luxury Bags Michael Kors/CnC_Enter CityName'), 
    search[11])

testLogger.log(Status.INFO, 'Enter City Name in CnC PopUp ')

WebUI.click(findTestObject('Object Repository/Page_Designer Handbags  Luxury Bags Michael Kors/CnC_ClcikOn FindStore Button'))

testLogger.log(Status.INFO, 'Click on Find store button in CnC PopUp ')

WebUI.click(findTestObject('Object Repository/Page_Designer Handbags  Luxury Bags Michael Kors/CnC_Add Cnc product To Cart'))

testLogger.log(Status.INFO, 'Add CnC product to cart based on availability from CnC PopUp ')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/span_Sign In_icon'))

testLogger.log(Status.INFO, 'User Navigated to cart page')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Designer Handbags  Luxury Bags Michael Kors/CnC_Verify Product in Cart'), 5)

testLogger.log(Status.PASS, 'CnC product is added to cart')



