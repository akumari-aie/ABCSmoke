import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.testng.Assert

import com.aventstack.extentreports.Status as Status
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import dataFile.ReadDataFromExcel as ReadDataFromExcel
import util.CustomReport as CustomReport

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC_013', 'Verify that user is able to edit the customer profile.').assignCategory(
    'smoke_Test', 'Account')

ReadDataFromExcel testdata = new ReadDataFromExcel()

String[] setup = testdata.getExcelDataByColumn('Setup', 2)

//String[] acm = testdata.getExcelDataByColumn('AccountManagement', 2)
WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

//WebUI.openBrowser('')
//WebUI.click(findTestObject('Object Repository/HomePage/a_Accept'))

WebUI.delay(2)

WebUI.mouseOver(findTestObject('HomePage/a_SignIn'))

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/input_Email Address_email'), 
    setup[3])

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/input_Password_password'), 
    setup[4])

WebUI.click(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/button_Sign In'))

WebUI.delay(2)

WebUI.mouseOver(findTestObject('Object Repository/HomePage/mouseHover_SignIn'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/a_Profile'))

WebUI.delay(2)

testLogger.log(Status.INFO, 'Navigated to profile Page')

String profilename = WebUI.getText(findTestObject('Object Repository/Page_Michael Kors/Get_ProfileName'))

WebUI.click(findTestObject('Object Repository/Page_Account/Edit_Profile'))

testLogger.log(Status.INFO, 'Clikc on Edit Profile button')

WebUI.clearText(findTestObject('Page_Michael Kors/input_First Name_firstname'))

testLogger.log(Status.INFO, 'Clear FirstName Text feild')

//String name = CustomKeywords.'Random.generateRandamName'()

WebUI.setText(findTestObject('Page_Michael Kors/input_First Name_firstname'), 'auto')

testLogger.log(Status.INFO, 'Entered FirstName')

//WebUI.setText(findTestObject('Page_Michael Kors/input_Last Name_lastName'), 'TestLastName')
WebUI.click(findTestObject('Page_Michael Kors/input_Female_save_changes translate'))

WebUI.delay(10)

String editeName = WebUI.getText(findTestObject('Object Repository/Page_Michael Kors/Get_ProfileName'))

WebUI.delay(5)

Assert.assertNotEquals(profilename, editeName)

testLogger.log(Status.PASS, 'Edit profile detail is Pass')


