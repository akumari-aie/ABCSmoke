import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.testng.Assert

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject


class Random {
	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		WebUiBuiltInKeywords.findWebElements(By.xpath("./" + outerTagName + "/tr"))
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}

	@Keyword
	public String randomemailAddress() {
		StringBuffer sb = new StringBuffer("autotest");
		// sb.append(Long.toString(random.nextInt()));
		int randomNo = (int)(Math.random() * 100000);
		sb.append(randomNo+"@mailinator.com");
		print("email: "+sb)
		return sb.toString();
	}

	@Keyword
	public String addAllProductToCart1() {



		println("inside Custom")
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> allproduct = driver.findElements(By.xpath("//div[contains(@class,'buy-look-prod-thumbnails')]//a/img"))
		println("list allproduct after")
		//	List<WebElement> allproduct = WebUI.click(findTestObject('Object Repository/HomePage/PDP_GetAllLookProductFromPopup'))



		int productSize = allproduct.size()
		print("productSize"+ productSize)
		for (int i = 1; i <= productSize; i++) {
			if (i <= (productSize - 1)) {

				if(WebUiBuiltInKeywords.verifyElementPresent(findTestObject('Object Repository/HomePage/PDP_SelectLookProductSizeInPopup'), 10)==true)
				{
					print("IN assert if loop")
					WebUiBuiltInKeywords.click(findTestObject('Object Repository/HomePage/PDP_SelectLookProductSizeInPopup'))

					WebUiBuiltInKeywords.click(findTestObject('Object Repository/Page_Sequined Puffer Jacket Logo T-shirt Je_20b822/PDP_NextButtonInPopup'))

					print("after assert if loop")
				}

				else {
					print("after assert else loop")
					WebUiBuiltInKeywords.click(findTestObject('Object Repository/Page_Sequined Puffer Jacket Logo T-shirt Je_20b822/PDP_NextButtonInPopup'))
				}
			} else {
				if (WebUiBuiltInKeywords.verifyElementPresent(findTestObject('Object Repository/HomePage/PDP_SelectLookProductSizeInPopup'))) {
					WebUiBuiltInKeywords.click(findTestObject('Object Repository/HomePage/PDP_SelectLookProductSizeInPopup'))
					WebUiBuiltInKeywords.click(findTestObject('Object Repository/Page_Sequined Puffer Jacket Logo T-shirt Je_20b822/PDP_AddAllLookToCart'))
				}
				else {
					WebUiBuiltInKeywords.click(findTestObject('Object Repository/Page_Sequined Puffer Jacket Logo T-shirt Je_20b822/PDP_AddAllLookToCart'))
				}

			}
		}


	}







	/*@Keyword
	 public String generateRandamName() {
	 StringBuffer sb = new StringBuffer("autotest")
	 //sb.append(Long.toString(random.nextInt()));
	 return sb.toString();
	 }
	 */
	@Keyword
	public String getAttribute(String elemXpath, String attributename) {
		String attrVal = WebUiBuiltInKeywords.findWebElement(By.xpath(elemXpath)).getAttribute(attributename);
		//String attrVal = driver.findElement(By.xpath(elemXpath)).getAttribute(attributename);
		return attrVal;

	}


	public boolean assertElementPresent(String locater)
	throws InterruptedException {

		Thread.sleep(2000);
		boolean isPresent = false;
		if (WebUiBuiltInKeywords.findWebElements(By.xpath(locater)).size() > 0) {
			Assert.assertTrue(WebUiBuiltInKeywords.findWebElements(By.xpath(locater)).size() > 0);
			System.out.println("Element is Present");
			isPresent = true;
		} else {
			System.out.println("Element is NOT present");
		}
		System.out.println(isPresent);
		return isPresent;
	}

	public List<WebElement> findElementsByXpath(String xPathlocator) {
		List<WebElement> webElementsList = WebUiBuiltInKeywords.findWebElements(By
				.xpath(xPathlocator));
		return webElementsList;
	}

	@Keyword
	def addAllProductToCart() throws InterruptedException {
		println("inside Custom")
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> allproduct = driver.findElements(By.xpath("//div[contains(@class,'buy-look-prod-thumbnails')]/img"))

		//	List<WebElement> allproduct = WebUI.click(findTestObject('Object Repository/HomePage/PDP_GetAllLookProductFromPopup'))

		print(allproduct)

		int productSize = allproduct.size()
		print(productSize)
		for (int i = 1; i <= productSize; i++) {
			if (i <= (productSize - 1)) {

				if (assertElementPresent(findTestObject('Object Repository/HomePage/PDP_SelectLookProductSizeInPopup'))) {
					WebUiBuiltInKeywords.click(findTestObject('Object Repository/HomePage/PDP_SelectLookProductSizeInPopup'))

					WebUiBuiltInKeywords.click(findTestObject('Object Repository/Page_Sequined Puffer Jacket Logo T-shirt Je_20b822/PDP_NextButtonInPopup'))
				} else {
					WebUiBuiltInKeywords.click(findTestObject('Object Repository/Page_Sequined Puffer Jacket Logo T-shirt Je_20b822/PDP_NextButtonInPopup'))
				}
			} else {
				if (assertElementPresent(findTestObject('Object Repository/HomePage/PDP_SelectLookProductSizeInPopup'))) {
					WebUiBuiltInKeywords.click(findTestObject('Object Repository/HomePage/PDP_SelectLookProductSizeInPopup'))
					WebUiBuiltInKeywords.click(findTestObject('Object Repository/Page_Sequined Puffer Jacket Logo T-shirt Je_20b822/PDP_AddAllLookToCart'))
				}
				else {
					WebUiBuiltInKeywords.click(findTestObject('Object Repository/Page_Sequined Puffer Jacket Logo T-shirt Je_20b822/PDP_AddAllLookToCart'))
				}

			}
		}
	}
}































