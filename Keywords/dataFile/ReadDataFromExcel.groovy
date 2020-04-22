package dataFile

import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.DataFormatter

import com.kms.katalon.core.annotation.Keyword

@Keyword
public class ReadDataFromExcel {

	File curDir = new File("");
	String currentDir = curDir.getAbsolutePath();
	String dataLibPath = currentDir + "\\TestData\\TestData Prod EU.xls";
	//C:\\Users\\ADMIN\\Katalon Studio\\Test\Data Files

	public String[] getExcelDataByColumn(String sheetName, int columnIndex) {
		String[] retVal = (String[])null;
		FileInputStream fis = null;
		List<String> lst = new ArrayList();
		try {
			fis = new FileInputStream(this.dataLibPath);
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			HSSFSheet sheet = workbook.getSheet(sheetName);
			Iterator rowIter = sheet.rowIterator();

			while (rowIter.hasNext()) {
				HSSFRow myRow = (HSSFRow)rowIter.next();
				Iterator cellIter = myRow.cellIterator();
				Vector<String> cellStoreVector = new Vector();
				while (cellIter.hasNext()) {
					DataFormatter formatter = new DataFormatter();
					HSSFCell myCell = (HSSFCell)cellIter.next();
					//Returns the formatted value of a cell as a String regardless of the cell type.
					String cellvalue = formatter.formatCellValue(myCell);
					// String cellvalue = myCell.getStringCellValue();
					cellStoreVector.addElement(cellvalue);
				}
				String columnValue = null;
				columnValue = ((String)cellStoreVector.get(columnIndex-1)).toString();
				lst.add(columnValue);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		retVal = (String[])lst.toArray(new String[lst.size()]);
		return retVal;
	}
}
