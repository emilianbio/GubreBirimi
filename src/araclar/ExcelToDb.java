/**
 * 
 */
package araclar;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Emrah Denizer
 *
 */
public class ExcelToDb {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException {
		System.out.println("main çalıştı....");
		String fileName = "D:\\test.xlsx";
		Vector dataHolder = read(fileName);
		saveToDatabase(dataHolder);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector read(String fileName) {
		Vector cellVectorHolder = new Vector();
		try {
			FileInputStream myInput = new FileInputStream(fileName);
			// POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
			XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			Iterator rowIter = mySheet.rowIterator();
			while (rowIter.hasNext()) {
				XSSFRow myRow = (XSSFRow) rowIter.next();
				Iterator cellIter = myRow.cellIterator();
				// Vector cellStoreVector=new Vector();
				List list = new ArrayList();
				while (cellIter.hasNext()) {
					XSSFCell myCell = (XSSFCell) cellIter.next();
					list.add(myCell);
				}
				cellVectorHolder.addElement(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellVectorHolder;
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	private static void saveToDatabase(Vector dataHolder)
			throws InstantiationException, IllegalAccessException {
		// String ClientAdd = "";
		// String Page = "";
		// String AccessDate = "";
		String il = "";
		java.sql.Date eklemeZamani ;
		String Bytes = "";
		System.out.println("1. sys: " + dataHolder);

		for (Iterator iterator = dataHolder.iterator(); iterator.hasNext();) {
			List list = (List) iterator.next();
			// ClientAdd = list.get(0).toString();
			// Page = list.get(1).toString();
			// AccessDate = list.get(2).toString();

			il = list.get(0).toString();
			//eklemeZamani = (Date) list.get(1);

			try {

				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/gubrebirimi",
						"postgres", "1234");

				//
				// Class.forName("com.mysql.jdbc.Driver").newInstance();
				// Connection con = DriverManager.getConnection(
				// "jdbc:mysql://localhost:3306/test", "root", "welcome");
				System.out.println("connection made...");
				PreparedStatement stmt = con
						.prepareStatement("INSERT INTO il (isim,eklemezamani) VALUES(?,?)");
				// stmt.setString(1, ClientAdd);
				// stmt.setString(2, Page);
				// stmt.setString(3, AccessDate);

				stmt.setString(1, il);
				stmt.setDate(2, (java.sql.Date) new Date());
				stmt.executeUpdate();

				System.out.println("Data is inserted");
				stmt.close();
				con.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Data failed...");
				e.printStackTrace();
			}
		}

	}

}
