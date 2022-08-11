package genericUtility;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	@DataProvider(name="getData")
	public Object [][] dataSupplier() throws Throwable
	{
		Object[][] obj = new Object[3][4];
//		obj[0][0] = "Praveen";
//		obj[0][1] = "rmgYantra";
//		obj[0][2] = "Created";
//		obj[0][3] = 10;
	//	
//		obj[1][0] = "Praveen";
//		obj[1][1] = "dell";
//		obj[1][2] = "On Going";
//		obj[1][3] = 5;
	//	
//		obj[2][0] = "Praveen";
//		obj[2][1] = "micromax";
//		obj[2][2] = "Created";
//		obj[2][3] = 12;
		
		ExcelUtility eLib = new ExcelUtility();
		int m=1;
		for(int i=0;i<3;i++)
		{
			int n=0;
			for(int j=0;j<4;j++)
			{
				if(j==3)
				{
					obj[i][j]=eLib.getIntDataFromExcel("dataSupplier", m , n);
				}else
				{
				    obj[i][j]=eLib.getDataFromExcel("dataSupplier", m , n);
				}
				n++;
			}
			m++;
		}
		return obj;
	}
}
