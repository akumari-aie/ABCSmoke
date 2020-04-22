import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys
import org.testng.Assert

import com.aventstack.extentreports.Status
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import util.CustomReport as CustomReport

CustomReport customReport = new CustomReport()

testLogger = customReport.startTestCase('TC_032_033_035', 'Verify that user able to view the individual and order total price and RFK product in Cart page, Edit Cart, Back to homepage.')
.assignCategory('smoke_Test', 'Shopping cart')

WebUI.callTestCase(findTestCase('AccountManagement/HomePageTC_007'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Michael Kors UK Designer handbags clot_5e67ef/span_UK _icon'))

WebUI.setText(findTestObject('Page_Michael Kors/input_Close_search-box'), 'bag')

WebUI.sendKeys(findTestObject('Page_Michael Kors/input_Close_search-box'), Keys.chord(Keys.ENTER))

testLogger.log(Status.INFO, 'User Search for Bag')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/svg'))

//WebUI.mouseOver(findTestObject('Page_Michael Kors/button_QUICKVIEW'))
WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_michael michael kors'))

WebUI.click(findTestObject('Object Repository/Page_Designer Handbags  Luxury Bags Michael Kors/a_add to bag'))

testLogger.log(Status.INFO, 'Product added to cart from PDP')

/***RFK: TC_027***//*

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Voyager Medium Crossgrain Leather Tote_ce5f2e/verify_rfk in PDP'), 10)

testLogger.log(Status.PASS, 'TC_027: RFK products are displaying in PDP is PASS')

WebUI.click(findTestObject('Page_Michael Kors/button_QUICKVIEW'))

testLogger.log(Status.INFO, 'User Clcik on Rfk QV from PDP')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/button_add to bag'))

testLogger.log(Status.INFO, 'RFK product added to cart')*/

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/span_Sign In_icon'))

testLogger.log(Status.INFO, 'User Navigated to cart')

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/SCP_VerifyIndividualPrice'), 10)

testLogger.log(Status.PASS, 'TC_033:Verification of Individual price in cart is Pass')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Michael Kors/SCP_VerifySubTotalPrice'), 10)

testLogger.log(Status.PASS, 'TC_033: Verification of SubTotal price in cart is Pass')

public Double getSubTotalPrice() throws InterruptedException
{
	String str = WebUI.getText(findTestObject('Object Repository/Page_Michael Kors/SCP_VerifySubTotalPrice'))
	String subtotal =null;
	subtotal = str.replaceAll("[^0-9]", "");
	System.out.println("Subtotal after replacing the special chars : "+subtotal);
	return Double.parseDouble(subtotal);
}
	double subtotalpricebeforeqtyupdate = getSubTotalPrice();

WebUI.click(findTestObject('Object Repository/Page_Account/Cart_Edit'))

testLogger.log(Status.INFO, 'Clicked on Edit Product in cart page')

WebUI.click(findTestObject('Page_Michael Kors/SCP_ChangeQuantity'))

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/a_Quantity'))

testLogger.log(Status.INFO, 'Updated product quantity in QV cart page')

WebUI.delay(2)

WebUI.click(findTestObject('Page_Michael Kors/input_Buy Online  Pick Up in Store_updateBag_Cart'))

//WebUI.click(findTestObject('Page_Michael Kors/button_1'))



WebUI.delay(2)
double subtotalpriceafterqtyupdate = getSubTotalPrice();

Assert.assertTrue(subtotalpricebeforeqtyupdate<subtotalpriceafterqtyupdate);

testLogger.log(Status.PASS, 'TC_033: subtotalpricebeforeqtyupdate is less than subtotalpriceafterqtyupdate')

testLogger.log(Status.PASS, 'TC_032: Edit product quantity in cart is Pass')

WebUI.click(findTestObject('Page_Michael Kors/a_Remove'))

WebUI.delay(2)

Assert.assertTrue(subtotalpricebeforeqtyupdate<subtotalpriceafterqtyupdate);

testLogger.log(Status.PASS, 'TC_035: Removed product from cart is PASS')

WebUI.click(findTestObject('Object Repository/Page_Michael Kors/cart_countinue'))

testLogger.log(Status.INFO, 'Clicked Continue shopping link from cart')

not_run: WebUI.closeBrowser()

