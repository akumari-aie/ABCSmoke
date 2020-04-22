import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.aventstack.extentreports.Status
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import util.CustomReport

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC__001_004', 'To verify the footer and Header link section of home page.')
.assignCategory('smoke_Test', 'HomePage')
	
WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/HomePage/Homepage_Header And Footer/HP_VerifyLogo'), 5)

testLogger.log(Status.PASS, 'Verification of MK Logo is PASS')

WebUI.verifyElementPresent(findTestObject('Object Repository/HomePage/Homepage_Header And Footer/HP_VerifyCountryIcon'), 5)

testLogger.log(Status.PASS, 'Verification of Country icon is PASS')

WebUI.verifyElementPresent(findTestObject('Object Repository/HomePage/Homepage_Header And Footer/HP_VerifySignInicon'), 5)

testLogger.log(Status.PASS, 'Verification of Sign In Icon is PASS')

WebUI.verifyElementPresent(findTestObject('Object Repository/HomePage/Homepage_Header And Footer/HP_VerifySearch'), 5)

testLogger.log(Status.PASS, 'TC_004: Verification of Search Icon is PASS')

WebUI.verifyElementPresent(findTestObject('Object Repository/HomePage/Homepage_Header And Footer/HP_VerifyCartIcon'), 5)

testLogger.log(Status.PASS, 'TC_004: Verification of Cart Icon is PASS')

WebUI.verifyElementPresent(findTestObject('Object Repository/HomePage/Homepage_Header And Footer/HP_Verify MegaMenu'), 5)

testLogger.log(Status.PASS, 'TC_004: Verification of Header Mega Menue is PASS')

WebUI.verifyElementPresent(findTestObject('Object Repository/HomePage/Homepage_Header And Footer/HP_HeaderStoreLocatorIcon'), 5)

testLogger.log(Status.PASS, 'Verification of Store locator Icon in header is PASS')

WebUI.verifyElementPresent(findTestObject('Object Repository/HomePage/Homepage_Header And Footer/HP_NewsLetter Email'), 5)

testLogger.log(Status.PASS, 'Verification of NewsLetter Footer is PASS')

WebUI.verifyElementPresent(findTestObject('Object Repository/HomePage/Homepage_Header And Footer/HP_Footer StoreLocatoricon'), 5)

testLogger.log(Status.PASS, 'Verification of Store Locator Footer is PASS')

WebUI.verifyElementPresent(findTestObject('Object Repository/HomePage/Homepage_Header And Footer/HP_FooterDetails Customer'), 5)

testLogger.log(Status.PASS, 'Verification of First Footer Menue is PASS')

WebUI.verifyElementPresent(findTestObject('Object Repository/HomePage/Homepage_Header And Footer/HP_FooterDetails Comapny'), 5)

testLogger.log(Status.PASS, 'Verification of Second footer menue is PASS')

WebUI.verifyElementPresent(findTestObject('Object Repository/HomePage/Homepage_Header And Footer/HP_Footer MyAccount'), 5)

testLogger.log(Status.PASS, 'Verification of Third footer menue is PASS')



