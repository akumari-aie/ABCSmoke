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

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC_016', 'Verify that user able to add the payment to the profile')
.assignCategory('smoke_Test', 'Account')

ReadDataFromExcel testdata = new ReadDataFromExcel()

String[] setup = testdata.getExcelDataByColumn('Setup', 2)

String[] acm = testdata.getExcelDataByColumn('AccountManagement', 2)

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

/***/
//WebUI.click(findTestObject('Object Repository/HomePage/a_Accept'))

WebUI.delay(2)

WebUI.mouseOver(findTestObject('HomePage/a_SignIn'))

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/input_Email Address_email'), 
    setup[5])

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/input_Password_password'), 
    setup[6])

WebUI.click(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/button_Sign In'))

WebUI.delay(2)

WebUI.mouseOver(findTestObject('Object Repository/HomePage/mouseHover_SignIn'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/a_Profile'))

//WebUI.click(findTestObject('Object Repository/HomePage/Page_Account/svg'))
WebUI.delay(2)

testLogger.log(Status.INFO, 'Navigated to profile Page')

/***/
/*WebUI.mouseOver(findTestObject('HomePage/a_SignIn'))

WebUI.click(findTestObject('Object Repository/HomePage/Page_Michael Kors India Designer handbags c_d413dc/a_create an account'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/HomePage/Page_Account/svg'))

WebUI.setText(findTestObject('Page_Account/input_Email Address_accountlogin'), 'anamika_test_add@gmail.com')

WebUI.setEncryptedText(findTestObject('Page_Account/input_Password_accountPassword'), 'fJfSCPMMNStB1FYeEsXpOg==')

//WebUI.delay(2)
WebUI.click(findTestObject('Page_Account/input_Details_signin_submit'))

WebUI.delay(2)*/
WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_Payment Information'))

testLogger.log(Status.INFO, 'Navigated to Payment Information Page')

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_Name on Card_creditCardName'), acm[1])

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_CARD NUMBER_creditCardNumber'), acm[10])

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_MM'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_03 - March'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_YYYY'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_2022'))

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_SECURITY CODE_creditCardCVV'), acm[11])

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/label_Make This My Default Payment Method'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_savePayment'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/verify_CardDetailsAdded'), 10)

testLogger.log(Status.PASS, 'Payment is saved to Payment Information Page is Passed')




WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_Delete'))

testLogger.log(Status.INFO, 'Click on Remove Payment button')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/span_YES'))

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Michael Kors/verify_CardDetailsAdded'), 10)

testLogger.log(Status.PASS, 'Payment is Removed from Payment Information Page is Passed')
not_run: WebUI.closeBrowser()

