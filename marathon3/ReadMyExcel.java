
package week6.marathon3;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadMyExcel {

	public static String[][] readData(String excelFileName) throws IOException {
		//Setup the path of the workbook
		XSSFWorkbook wb =new XSSFWorkbook("./data/"+excelFileName+".xlsx");
		//Setup the worksheet
		XSSFSheet ws=wb.getSheetAt(0);
		//Get the Row count excluding header
		int rowCount = ws.getLastRowNum();
		//Get Cell Count
		int cellCount=ws.getRow(rowCount).getLastCellNum();
		//System.out.println("The total no: of rows : "+rowCount);
		//System.out.println("The total no: of columns :"+cellCount);
		
		String[][] data = new String[rowCount][cellCount];
		for (int i=1;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				//Read the data from cell
				String value = ws.getRow(i).getCell(j).getStringCellValue();
			//	System.out.println(value);
				data[i-1][j]=value;// data[0][0]="TestLeaf"
			}
		}
		wb.close();
		return data;
	}
	}