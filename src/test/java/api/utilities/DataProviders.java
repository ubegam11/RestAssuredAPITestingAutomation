package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "AllData")
	public String[][] AllDataProvider() {
		String fileName = System.getProperty("user.dir") + "//TestData//TestData.xlsx";
		int totalRowCount = ReadExcelFile.getRowCount(fileName, "Sheet1");
		int totalColumnCount = ReadExcelFile.getColCount(fileName, "Sheet1");

		String userData[][] = new String[totalRowCount-1][totalColumnCount];

		for (int row = 1; row < totalRowCount; row++) {
			for (int col = 0; col < totalColumnCount; col++) {
				userData[row - 1][col] = ReadExcelFile.getCellValue(fileName, "Sheet1", row, col);
			}
		}
		return userData;
	}

	@DataProvider(name = "UserNameData")
	public String[] userNameData() {
		String fileName = System.getProperty("user.dir") + "//TestData//TestData.xlsx";
		int totalRowCount = ReadExcelFile.getRowCount(fileName, "Sheet1");

		String userNameData[] = new String[totalRowCount-1];

		for (int row = 1; row < totalRowCount; row++) {
			userNameData[row - 1] = ReadExcelFile.getCellValue(fileName, "Sheet1", row, 1);// 1 is bcz userNam is at col=1
		}

		return userNameData;
	}

}
