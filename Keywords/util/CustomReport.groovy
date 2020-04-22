package util

import java.text.SimpleDateFormat
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

import org.apache.commons.io.FileUtils
import org.apache.commons.io.FilenameUtils
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot

import com.aventstack.extentreports.ExtentReports
import com.aventstack.extentreports.ExtentTest
import com.aventstack.extentreports.Status
import com.aventstack.extentreports.markuputils.ExtentColor
import com.aventstack.extentreports.markuputils.MarkupHelper
import com.aventstack.extentreports.reporter.ExtentHtmlReporter
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration as RC
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.webui.driver.DriverFactory


public class CustomReport {

	public static  ExtentHtmlReporter extentHtmlReport
	public static  ExtentReports extentReport
	public static  ExtentTest testLogger
	private static String currentDir
	private static String fileSeperator
	//private static Threadlocal<ExtentTest> testLogger = new ThreadLocal<ExtentTest>()

	@Keyword
	public ExtentTest getExtentTest() {
		return testLogger
	}

	public void setExtentTest(ExtentTest testLogger) {
		this.testLogger =  testLogger
	}

	public static ExtentReports initExtentReports() {
		//String filePath= "Extents/ExtentReport.html"
		currentDir = "C:/Users/ADMIN/Katalon Studio/Test/"
		String filePath="C:/Users/ADMIN/Katalon Studio/Test/Extents/SmokeReport.html"
		fileSeperator = System.getProperty("file.separator")

		extentReport = new ExtentReports()

		extentHtmlReport = new ExtentHtmlReporter(FilenameUtils.separatorsToSystem(filePath))
		//            extentHtmlReport.config().setDocumentTitle("Automation Report")
		//            extentHtmlReport.config().setReportName("Functional Testing")
		//                         extentHtmlReport.config().setTheme(Theme.DARK)
		extentReport.attachReporter(extentHtmlReport)
		extentHtmlReport.loadXMLConfig("${currentDir}${fileSeperator}Extents${fileSeperator}extent-config.xml")
		//extentHtmlReport.loadXMLConfig("${currentDir}${fileSeperator}extent-config.xml")

		extentReport.setSystemInfo("OS", RC.getOS())
		extentReport.setSystemInfo("Host", RC.getHostAddress())
		extentReport.setSystemInfo("User", RC.getHostName())
		//extentReport.setSystemInfo("Host URL", WebUiBuiltInKeywords.getUrl())
		extentReport.setSystemInfo("Environment", RC.getExecutionProfile())
		extentReport.setSystemInfo("Katalon Version", RC.getAppVersion())
	}

	@Keyword
	public static ExtentTest startTestCase(String testCaseName,String description) {
		testLogger = extentReport.createTest(testCaseName,description)
		return testLogger
	}

	public static ExtentReports extent = getInstance();

	public static ExtentReports getInstance() {
		if (extent == null)
			initExtentReports();
		return extent;
	}


	public static String captureScreen() throws IOException {
		TakesScreenshot screen = (TakesScreenshot) DriverFactory.getWebDriver()
		File src = screen.getScreenshotAs(OutputType.FILE)
		String dest = "${currentDir}${fileSeperator}Extents${fileSeperator}ScreenShots${fileSeperator}" + new Date().format('dd_MM_yyy_hh_mm_ss') + ".png"
		//String dest = "${currentDir}${fileSeperator}ScreenShots${fileSeperator}" + new Date().format('dd_MM_yyy_hh_mm_ss') + ".png"
		File target = new File(dest)
		FileUtils.copyFile(src, target)
		return target.getAbsolutePath()
	}

	public static ExtentReports tearDownExtentReports() {
		extentReport.flush()
	}


	public static void zipExtentReport() {
		try {

			String filePath = currentDir + "/Extents/";
			//String filePath = currentDir
			File file = new File(filePath + "ExtentReport.html");


			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			formater.format(calendar.getTime());
			String zipFileName = filePath + "archives/" + "ExtentReport.html_" + formater.format(calendar.getTime()) + ".zip";

			addToZipFile(file, zipFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addToZipFile(File file, String zipFileName) throws FileNotFoundException, IOException {



		FileOutputStream fos = new FileOutputStream(zipFileName);
		ZipOutputStream zos = new ZipOutputStream(fos);



		ZipEntry zipEntry = new ZipEntry(file.getName());
		zos.putNextEntry(zipEntry);



		FileInputStream fis = new FileInputStream(file);



		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) > 0) {
			zos.write(bytes, 0, length);
		}
		zos.closeEntry();
		zos.close();
		fis.close();
		fos.close();
		System.out.println(file.getCanonicalPath() + " is zipped to " + zipFileName);
	}


}











