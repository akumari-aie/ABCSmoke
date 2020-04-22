import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.testng.Assert

import com.aventstack.extentreports.Status as Status
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import dataFile.ReadDataFromExcel as ReadDataFromExcel
import util.CustomReport as CustomReport

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC_010_011','Verify that user able to Sign in and Sign out with Remember me checkbox through SignIn Overlay')
.assignCategory('smoke_Test', 'Account')

ReadDataFromExcel testdata = new ReadDataFromExcel()

String[] setup = testdata.getExcelDataByColumn('Setup', 2)

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

/***/
//WebUI.click(findTestObject('Object Repository/HomePage/a_Accept'))

WebUI.delay(2)

WebUI.mouseOver(findTestObject('HomePage/a_SignIn'))

testLogger.log(Status.INFO, 'Mouse Hoverd to signIn overlay')

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/input_Email Address_email'), 
    setup[3])

testLogger.log(Status.INFO, 'Entered emailID')

String message = WebUI.getText(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/input_Email Address_email'))


WebUI.setText(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/input_Password_password'), 
    setup[4])

testLogger.log(Status.INFO, 'Entered Password')

WebUI.click(findTestObject('Object Repository/HomePage/RememberMe_CheckBox'))

testLogger.log(Status.INFO, 'CHeck Remember Me Checkbox')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/button_Sign In'))

WebUI.delay(1)

testLogger.log(Status.INFO, 'Clicked on SignIn button')

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('Object Repository/HomePage/mouseHover_SignIn'), 5)

testLogger.log(Status.PASS, 'Sign in is Pass')

WebUI.mouseOver(findTestObject('Object Repository/HomePage/mouseHover_SignIn'))

WebUI.click(findTestObject('Object Repository/HomePage/Sign_Out'))

testLogger.log(Status.INFO, 'Clicked on Sign Out button')

WebUI.verifyElementPresent(findTestObject('HomePage/a_SignIn'), 5)

testLogger.log(Status.PASS, 'TC_11_Sign Out is Pass')

WebUI.mouseOver(findTestObject('HomePage/a_SignIn'))

String message1 = WebUI.getText(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/input_Email Address_email'))

Assert.assertEquals(message, message1)

testLogger.log(Status.PASS, 'TC_10_Remember Me checkbox is Pass')


