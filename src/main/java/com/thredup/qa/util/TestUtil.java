package com.thredup.qa.util;
import com.thredup.qa.base.TestBase1;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil extends TestBase1 {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;

    public static String TestDataPath = "C:\\Users\\ramku\\IdeaProjects\\ThredUpTest\\src\\main\\java\\com\\crm\\qa\\testdata\\Book1.xlsx";

    static Workbook book;
    public static org.apache.poi.ss.usermodel.Sheet sheet;

    public TestUtil() throws IOException {
        super();
    }

    public  void failedTest(String FTname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File Sfile = ts.getScreenshotAs(OutputType.FILE);
        File Dfile= new File("C:\\Users\\ramku\\IdeaProjects\\ThredUpTest\\src\\main\\java\\com\\crm\\qa\\Screenshot\\"+FTname+".png");
        FileHandler.copy(Sfile,Dfile);
        System.out.println("Screenshot taken successful ");

    }

    public static Object[][] getTestData(String SheetName) {

        FileInputStream file = null;
        try {
            file = new FileInputStream(TestDataPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet = book.getSheet(SheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
            }
        }
        return data;
    }
}
