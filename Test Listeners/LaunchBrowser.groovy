import com.aventstack.extentreports.Status
import com.aventstack.extentreports.markuputils.ExtentColor
import com.aventstack.extentreports.markuputils.MarkupHelper
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.configuration.RunConfiguration as RC
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import util.CustomReport
 
class LaunchBrowser {
 
	
       CustomReport customReport = new CustomReport()
	   //Reporting customReport = new Reporting();
	   SendMail sm = new SendMail();
	   def totalNumberOfTestCases = 0;
	   def totalTestCasesPassed = 0;
	   def totalTestCasesFailed = 0;
	   def totalTestCasesError = 0;
	   def totalTestCasesSkipped = 0;
	   def testCaseVar = [:]
	   def failedTCs = [:];
 
	   
	   /**
		* Executes before every test case starts.
		* @param testCaseContext related information of the executed test case.
		*/
	   @BeforeTestCase
	   def sampleBeforeTestCase(TestCaseContext testCaseContext) {
		   println testCaseContext.getTestCaseId()
		   println testCaseContext.getTestCaseVariables()
		   
	   }
	   
	   @AfterTestCase
	   def getExtentReport(TestCaseContext testCaseContext) {
		   String testName = RC.getExecutionSourceName()
			  switch (testCaseContext.getTestCaseStatus()){
				  
					  case "PASSED" :
							  customReport.getExtentTest().log(Status.PASS,MarkupHelper.createLabel("${testCaseContext.getTestCaseId()} \t PASSED", ExtentColor.GREEN))
                          customReport.getExtentTest().addScreenCaptureFromPath(customReport.captureScreen())
							totalTestCasesPassed++;
						   break
					 case "FAILED" :
						   customReport.getExtentTest().log(Status.FAIL, MarkupHelper.createLabel(testName+ " FAILED ", ExtentColor.RED))
						   customReport.getExtentTest().fail(testCaseContext.getMessage())
						   totalTestCasesFailed++;
						   testCaseVar = testCaseContext.testCaseVariables
						   failedTCs.put(testCaseContext.getTestCaseId()+"/"+testCaseVar.testCaseDescription, testCaseContext.getMessage())
						   
						   break
					 case "ERROR" :
						   customReport.getExtentTest().log(Status.ERROR, MarkupHelper.createLabel(testName+ " ERROR ", ExtentColor.ORANGE))
						   customReport.getExtentTest().error(testCaseContext.getMessage())
						   totalTestCasesError++;
						   testCaseVar = testCaseContext.testCaseVariables
						   failedTCs.put(testCaseContext.getTestCaseId()+"/"+testCaseVar.testCaseDescription, testCaseContext.getMessage())
						   break
					 default :
						  customReport.getExtentTest().log(Status.SKIP, MarkupHelper.createLabel(testName+ " SKIP ", ExtentColor.CYAN))
						  customReport.getExtentTest().skip(testCaseContext.getMessage())
						  totalTestCasesSkipped++;
			  }
			  customReport.tearDownExtentReports()
	   }
	   
	   /**
		* Executes before every test suite starts.
		* @param testSuiteContext: related information of the executed test suite.
		*/
	   @BeforeTestSuite
	   def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
		   println testSuiteContext.getTestSuiteId()
	   }
   
	   /**
		* Executes after every test suite ends.
		* @param testSuiteContext: related information of the executed test suite.
		*/
	   @AfterTestSuite
	   def sendMailListner(TestSuiteContext testSuiteContext) {
		   
		   totalNumberOfTestCases = totalTestCasesPassed + totalTestCasesFailed + totalTestCasesError + totalTestCasesSkipped;
		   
		   if(testSuiteContext.getStatus()){
			   println("in After Test Suit")
			   sm.sendMail(totalNumberOfTestCases, totalTestCasesPassed, totalTestCasesFailed,totalTestCasesError,totalTestCasesSkipped, failedTCs);
		   
			   customReport.zipExtentReport()
			   
			   }
		   
	   }
	   
     /*@AfterTestCase
       def getExtentReport(TestCaseContext testCaseContext) {
		   String testName = RC.getExecutionSourceName()
              switch (testCaseContext.getTestCaseStatus()){
                     case "PASSED" :
                     //customReport.getExtentTest().log(Status.PASS,MarkupHelper.createLabel("${testCaseContext.getTestCaseId()} \t PASSED", ExtentColor.GREEN))
                            customReport.getExtentTest().addScreenCaptureFromPath(customReport.captureScreen())
                           break
                     case "FAILED" :
                           customReport.getExtentTest().log(Status.FAIL, MarkupHelper.createLabel(testName+ " FAILED ", ExtentColor.RED))
                           customReport.getExtentTest().fail(testCaseContext.getMessage())
                           break
                     case "ERROR" :
                           customReport.getExtentTest().log(Status.ERROR, MarkupHelper.createLabel(testName+ " ERROR ", ExtentColor.ORANGE))
                           customReport.getExtentTest().error(testCaseContext.getMessage())
                           break
                     default :
                           customReport.getExtentTest().log(Status.SKIP, MarkupHelper.createLabel(testName+ " SKIP ", ExtentColor.CYAN))
                          customReport.getExtentTest().skip(testCaseContext.getMessage())
              }
              customReport.tearDownExtentReports()
			  
			  
       }*/
	  /* @AfterTestSuite
	   def addZipFolder()
	   {
		   customReport.zipExtentReport()
	   }*/
 
}