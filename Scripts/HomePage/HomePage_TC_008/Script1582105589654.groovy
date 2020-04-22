import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.aventstack.extentreports.Status
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import util.CustomReport


CustomReport customReport = new CustomReport()
testLogger=customReport.startTestCase('TC_008','To verify that IP detection overlay is displayed, when user access the Site by changing the domain in browser URL manually.')
.assignCategory("smoke_Test", "HomePage")

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.michaelkors.global/en_IN/')

WebUI.maximizeWindow()

testLogger.log(Status.INFO, 'Navigated to India site')

WebUI.click(findTestObject('Page_Michael Kors India Designer handbags c_d413dc/span_SHOP NOW'))
//WebUI.click(findTestObject('Page_Michael Kors India Designer handbags c_d413dc/button_Continue to Michael Kors India'))

WebUI.waitForPageLoad(2)

String url = WebUI.getUrl()
println(url)
String url1 = url.replace('global/en_IN/', 'de')

println(url1)
WebUI.navigateToUrl(url1)

testLogger.log(Status.INFO, 'Modified the domain in URL Fron India to German site')

WebUI.verifyElementPresent(findTestObject('Object Repository/HomePage/Verify_IP Detction'), 5)

testLogger.log(Status.PASS, 'Varification of IP detection overlay is displayed and Navigated to German site')