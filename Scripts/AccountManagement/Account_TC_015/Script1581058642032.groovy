import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.testng.Assert as Assert
import com.aventstack.extentreports.Status as Status
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import dataFile.ReadDataFromExcel as ReadDataFromExcel
import util.CustomReport as CustomReport

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC_015', 'Verify that user able to add and edit the address to the profile')
.assignCategory('smoke_Test', 'Account')

ReadDataFromExcel testdata = new ReadDataFromExcel()

String[] setup = testdata.getExcelDataByColumn('Setup', 2)
String[] acm = testdata.getExcelDataByColumn('AccountManagement', 2)

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

//WebUI.click(findTestObject('Object Repository/HomePage/Page_Account/svg'))
WebUI.delay(2)
testLogger.log(Status.INFO, 'Navigated to profile Page')
/*WebUI.mouseOver(findTestObject('HomePage/a_SignIn'))

WebUI.click(findTestObject('Object Repository/HomePage/Page_Michael Kors India Designer handbags c_d413dc/a_create an account'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/HomePage/Page_Account/svg'))

WebUI.setText(findTestObject('Page_Account/input_Email Address_accountlogin'), 'ukprod0301@mailinator.com')

WebUI.setEncryptedText(findTestObject('Page_Account/input_Password_accountPassword'), 'dXad34d372mT/t0meKq5fQ==')

WebUI.delay(2)

not_run: WebUI.click(findTestObject('Page_Account/input_Details_signin_submit'))*/
WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_Address Book'))

WebUI.delay(2)

testLogger.log(Status.INFO, 'Navigated to AddressBook Page')

WebUI.setText(findTestObject('Object Repository/Page_Account/input_AddressBook Key'), acm[8])

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_129 Breakspeare Road Abbots Langley WD5'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_Select Title'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_Miss'))

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/Page_Account/input_AdreesBook FirstName'), acm[1])

WebUI.setText(findTestObject('Object Repository/Page_Account/input_AdrdressBook LastName'), acm[2])

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_Phone Number_phoneNumber'), '0044 9087445623')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/input_Make This My Default Billing Address__6f6103'))

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_VerifyAddressAdded'), 20)

testLogger.log(Status.PASS, 'Address added to profile is Passed')

String name = WebUI.getText(findTestObject('Object Repository/Page_Michael Kors/a_EditedAddress'))

System.out.println(name)

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/span_Edit'))

testLogger.log(Status.INFO, 'Clicked On Edit Adress Button')

WebUI.setText(findTestObject('Object Repository/Page_Michael Kors/input_First Name_atguserprofilingProfileFor_7ec8d2'), 
    acm[6])

testLogger.log(Status.INFO, 'Modified First Name')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/input_Phone Number_editsubmit'))

testLogger.log(Status.INFO, 'Clicked On Save CHanges Button')

String editeName = WebUI.getText(findTestObject('Object Repository/Page_Michael Kors/a_EditedAddress'))

System.out.println(editeName)

Assert.assertNotEquals(name, editeName)

testLogger.log(Status.PASS, 'Edit address to profile is Passed')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_Delete'))

testLogger.log(Status.INFO, 'Clicked On Delete Address Button')
WebUI.click(findTestObject('Object Repository/Page_Michael Kors/button_Yes'))
not_run: WebUI.closeBrowser()

