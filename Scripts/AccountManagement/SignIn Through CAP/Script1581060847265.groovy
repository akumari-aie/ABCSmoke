import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import dataFile.ReadDataFromExcel
import util.CustomReport

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC_00','Verify that guest user is able to create account through ‘My Account’ link on the header.')
.assignCategory('smoke_Test', 'Account')

ReadDataFromExcel testdata = new ReadDataFromExcel()

String[] homepage = testdata.getExcelDataByColumn('HomePage', 2)

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('HomePage/a_SignIn'))

WebUI.click(findTestObject('Page_Michael Kors UK Designer handbags clot_5e67ef/a_create an account'))

WebUI.setText(findTestObject('Page_Account/input_Email Address_accountlogin'), 'ukprod0301@mailinator.com')

WebUI.setEncryptedText(findTestObject('Page_Account/input_Password_accountPassword'), 'dXad34d372mT/t0meKq5fQ==')

WebUI.click(findTestObject('Page_Account/input_Details_signin_submit'))

WebUI.delay(5)

WebUI.verifyElementPresent(findTestObject('Object Repository/HomePage/a_AssertProfile'), 20)

//testLogger.log(Status.PASS, 'Verification of Account creation in Passed')

//WebUI.closeBrowser()

