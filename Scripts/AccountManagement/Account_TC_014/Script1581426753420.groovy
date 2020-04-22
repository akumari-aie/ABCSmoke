import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.aventstack.extentreports.Status as Status
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import dataFile.ReadDataFromExcel as ReadDataFromExcel
import util.CustomReport as CustomReport
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

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC_014', 'Verify that user is able to Change the password.').assignCategory('smoke_Test', 
    'Account')

ReadDataFromExcel testdata = new ReadDataFromExcel()

String[] accm = testdata.getExcelDataByColumn('AccountManagement', 2)

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('HomePage/a_SignIn'))

WebUI.click(findTestObject('Object Repository/HomePage/Page_Michael Kors India Designer handbags c_d413dc/a_create an account'))

testLogger.log(Status.INFO, 'Navigated to Crea account page')

//WebUI.click(findTestObject('Object Repository/HomePage/Page_Account/svg'))
String email = CustomKeywords.'Random.randomemailAddress'()

WebUI.setText(findTestObject('Object Repository/HomePage/Page_Account/input_Email Address_login'), email)

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Object Repository/HomePage/Page_Account/input_Confirm Email Address_email'), email)

WebUI.delay(5)

WebUI.sendKeys(findTestObject('Object Repository/HomePage/Page_Account/input_First Name_firstName'), accm[1])

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Object Repository/HomePage/Page_Account/input_Last Name_lastName'), accm[2])

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/HomePage/Page_Account/input_Password_password'), accm[3])

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/HomePage/Page_Account/input_Confirm Password_confirmPassword'), accm[3])

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Page_Account/input_Confirm Password_confirmPassword'), Keys.chord(Keys.TAB, Keys.SPACE))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/HomePage/Page_Account/input_Remember Me_register_account translate'))

WebUI.delay(5)

WebUI.verifyElementPresent(findTestObject('Object Repository/HomePage/a_AssertProfile'), 20)

testLogger.log(Status.INFO, 'Account created and user navigated to Profile page')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_Change Password'))

testLogger.log(Status.INFO, 'Clciked on Change password link')

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_Current Password_oldpassword'), accm[3])

testLogger.log(Status.INFO, 'Entered old password')

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_New Password_password'), accm[4])

testLogger.log(Status.INFO, 'Entered new password')

WebUI.setText(findTestObject('Page_Michael Kors/input_Confirm Password_confirmPassword'), accm[4])

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/input__save_pword translate'))

testLogger.log(Status.INFO, 'Clicked on save password change button')

WebUI.rightClick(findTestObject('Object Repository/Page_Michael Kors/p_Your password has been changed successfully'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/p_Your password has been changed successfully'), 
    2)

testLogger.log(Status.PASS, 'Passwored has been changed Successfully')

