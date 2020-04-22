import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import org.openqa.selenium.Keys as Keys

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC__003', 'To verify the system behaviour when user subscribe to newsletter from footer section.').assignCategory(
    'smoke_Test', 'HomePage')

ReadDataFromExcel testdata = new ReadDataFromExcel()

String[] search = testdata.getExcelDataByColumn('Search', 2)

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

//WebUI.click(findTestObject('Page_Michael Kors UK Designer handbags clot_5e67ef/a_I ACCEPT'))
String randomemail = CustomKeywords.'Random.randomemailAddress'()

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/input_Find a Store_mailingListSignUplogin'), 
    randomemail)

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/input_Find a Store_mailingListSignUplogin'), 
    Keys.chord(Keys.TAB, Keys.ENTER))

//WebUI.delay(2)
//WebUI.click(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/button_Sign Up'))
testLogger.log(Status.INFO, 'User navigated to SignUp page')

//WebUI.click(findTestObject('null'))
//String email = WebUI.getText(findTestObject('Object Repository/HomePage/First_email_SignUp'))
String email = WebUI.getAttribute(findTestObject('Object Repository/HomePage/First_email_SignUp'), 'value')

//println(email)
WebUI.sendKeys(findTestObject('Object Repository/Page_Michael Kors/input_Confirm Email Address_email'), email)

testLogger.log(Status.INFO, 'Enter confirm email in SignUp page')

//WebUI.click(findTestObject('Page_Michael Kors/input_First Name_firstname'))
WebUI.setText(findTestObject('Page_Michael Kors/input_First Name_firstname'), 'Auto')

testLogger.log(Status.INFO, 'Enter FirstName in SignUp page')

WebUI.setText(findTestObject('Page_Michael Kors/input_Last Name_lastName'), 'Test')

testLogger.log(Status.INFO, 'Enter LastName email in SignUp page')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/input_Privacy Policy_newsletter_signup'))

testLogger.log(Status.INFO, 'Click on SignUp Button')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/verify_NewsLetterSignUp msg'), 5)

testLogger.log(Status.PASS, 'confirmation message is displayed for Newletter SignuP is pass')

