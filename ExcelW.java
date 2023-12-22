import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelW {

    public static void writeStringToExcel(String filePath, String change, String searchTerm, String keyTerm) {

        try (FileInputStream file = new FileInputStream(new File(filePath));
                XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            XSSFSheet sheet = workbook.getSheet("Sheet1");
            int nColl = sheet.getRow(0).getPhysicalNumberOfCells();
            int nRows = sheet.getPhysicalNumberOfRows();

            for (int i = 0; i < nColl; i++) {

                Cell searchTitle = sheet.getRow(0).getCell(i);

                if (searchTerm.equals(searchTitle.toString())) {

                    for (int j = 1; j < nRows; j++) {
                        Cell keyTermCell = sheet.getRow(j).getCell(0);
                        if (keyTerm.equals(keyTermCell.toString())) {
                            Cell changeCell = sheet.getRow(j).getCell(i);

                            changeCell.setCellValue(change);

                        }

                    }
                }
            }

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
               
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeDoubleToExcel(String filePath, double change, String searchTerm, String keyTerm) {

        try (FileInputStream file = new FileInputStream(new File(filePath));
                XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            XSSFSheet sheet = workbook.getSheet("Sheet1");
            int nColl = sheet.getRow(0).getPhysicalNumberOfCells();
            int nRows = sheet.getPhysicalNumberOfRows();

            for (int i = 0; i < nColl; i++) {

                Cell searchTitle = sheet.getRow(0).getCell(i);

                if (searchTerm.equals(searchTitle.toString())) {

                    for (int j = 1; j < nRows; j++) {
                        Cell keyTermCell = sheet.getRow(j).getCell(0);
                        if (keyTerm.equals(keyTermCell.toString())) {
                            Cell changeCell = sheet.getRow(j).getCell(i);

                            changeCell.setCellValue(change);

                        }

                    }
                }
            }

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
