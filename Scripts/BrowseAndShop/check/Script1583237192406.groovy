import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI



WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Store Locator  Michael Kors/span_UK _icon'))

WebUI.setText(findTestObject('Page_Michael Kors/input_Close_search-box'), 'look')

WebUI.sendKeys(findTestObject('Page_Michael Kors/input_Close_search-box'), Keys.chord(Keys.ENTER))

//if(CustomKeywords.'Random.assertElementPresent'('Object Repository/Page_Michael Kors/svg'))

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/svg'),10))
{
	WebUI.click(findTestObject('Object Repository/Page_Michael Kors/svg'))
}
//WebUI.click(findTestObject('Page_Michael Kors/svg'))

WebUI.click(findTestObject('Page_Michael Kors/img_3200 to 16700_product-image'))

WebUI.click(findTestObject('Page_Sequined Puffer Jacket Logo T-shirt Je_20b822/button_BUY ALL (4)'))

Thread.sleep(2000)

CustomKeywords.'Random.addAllProductToCart1'()

Thread.sleep(2000)