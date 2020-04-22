import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.aventstack.extentreports.Status as Status
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import util.CustomReport as CustomReport

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC_026', 'Verify Logged In & Guest Users is able to add a product to cart from PLP Quick view.').assignCategory(
    'smoke_Test', 'BrowseAndShop')

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/a_HandbagMosueHover'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors UK Designer handbags clot_5e67ef/a_View All Handbags'))

WebUI.click(findTestObject('Page_Michael Kors/svg'))

//WebUI.click(findTestObject('Object Repository/Page_Michael Kors/Click_SubsCription PopUp'))

//WebUI.mouseOver(findTestObject('Page_Designer Handbags  Luxury Bags Michael Kors/button_QUICKVIEW'))

WebUI.click(findTestObject('Page_Designer Handbags  Luxury Bags Michael Kors/button_QUICKVIEW'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_VerifyQVmodal'), 10)

testLogger.log(Status.PASS, 'Verification of QV modal is Passed')

WebUI.click(findTestObject('Page_Designer Handbags  Luxury Bags Michael Kors/a_add to bag'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/a_AssertProductAddedToCart'), 10)

testLogger.log(Status.PASS, 'Product added to cart from QV modal is Passed')

