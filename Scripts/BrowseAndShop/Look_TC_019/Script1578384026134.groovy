import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement

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

CustomKeywords.'Random.addAllProductToCart'()


//List<WebElement> allproduct = WebUI.click(findTestObject('Object Repository/HomePage/PDP_GetAllLookProductFromPopup'))

/*WebUI.click(findTestObject('Page_Sequined Puffer Jacket Logo T-shirt Je_20b822/label_UK 6-8'))

WebUI.click(findTestObject('PDP_NextButtonInPopup'))

WebUI.click(findTestObject('Object Repository/Page_Sequined Puffer Jacket Logo T-shirt Je_20b822/label_UK 2-4'))

WebUI.click(findTestObject('PDP_NextButtonInPopup'))

WebUI.click(findTestObject('Page_Sequined Puffer Jacket Logo T-shirt Je_20b822/label_OS'))

WebUI.click(findTestObject('Page_Sequined Puffer Jacket Logo T-shirt Je_20b822/PDP_NextButtonInPopup'))

WebUI.click(findTestObject('Page_Sequined Puffer Jacket Logo T-shirt Je_20b822/PDP_AddAllLookToCart'))

WebUI.click(findTestObject('Object Repository/Page_Sequined Puffer Jacket Logo T-shirt Je_20b822/button_CONTINUE SHOPPING'))*/
not_run: WebUI.closeBrowser() //  List<WebElement> allproduct =WebUI.findElementsByXpath(PDP_GetAllLookProductFromPopup)

/*public void addAllProductToCart() throws InterruptedException {
  List<WebElement> allproduct = CustomKeywords.'Random.findElementsByXpath'(findTestObject('Object Repository/HomePage/PDP_GetAllLookProductFromPopup'))

    int productSize = allproduct.size()
print(productSize)
    for (int i = 1; i <= productSize; i++) {
        if (i <= (productSize - 1)) {
			
            if (CustomKeywords.'Random.assertElementPresent'(findTestObject('Object Repository/HomePage/PDP_SelectLookProductSizeInPopup'))) {
                WebUI.click(findTestObject('Object Repository/HomePage/PDP_SelectLookProductSizeInPopup'))

                WebUI.click(findTestObject('Object Repository/Page_Sequined Puffer Jacket Logo T-shirt Je_20b822/PDP_NextButtonInPopup'))
            } else {
                WebUI.click(findTestObject('Object Repository/Page_Sequined Puffer Jacket Logo T-shirt Je_20b822/PDP_NextButtonInPopup'))
            }
        } else {
            if (CustomKeywords.'Random.assertElementPresent'(findTestObject('Object Repository/HomePage/PDP_SelectLookProductSizeInPopup'))) {
                WebUI.click(findTestObject('Object Repository/HomePage/PDP_SelectLookProductSizeInPopup'))
                WebUI.click(findTestObject('Object Repository/Page_Sequined Puffer Jacket Logo T-shirt Je_20b822/PDP_AddAllLookToCart'))
            } 
			else {
                WebUI.click(findTestObject('Object Repository/Page_Sequined Puffer Jacket Logo T-shirt Je_20b822/PDP_AddAllLookToCart'))
            }
        }
    
    }
*/    //WebUI.acceptAlert()


