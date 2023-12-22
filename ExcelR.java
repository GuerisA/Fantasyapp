import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelR {

    public static List<String> readStringFromExcel(String filePath, String searchResult) {

        List<String> playerInforList = new ArrayList<>() {

        };

        try (FileInputStream file = new FileInputStream(new File(filePath));
                XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            XSSFSheet sheet = workbook.getSheetAt(0);

            int nColl = sheet.getRow(0).getPhysicalNumberOfCells();
            int nRows = sheet.getPhysicalNumberOfRows();
            for (int i = 0; i < nColl; i++) {

                Cell searchTitle = sheet.getRow(0).getCell(i);
                if (searchResult.equals(searchTitle.toString())) {
                    for (int j = 1; j < nRows; j++) {

                        String searchItemCell = sheet.getRow(j).getCell(i).toString();

                        playerInforList.add(searchItemCell);

                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return playerInforList;
    }
    public static List<Double> readDoubleFromExcel(String filePath, String searchResult) {

        List<Double> playerInforList = new ArrayList<>() {

        };

        try (FileInputStream file = new FileInputStream(new File(filePath));
                XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            XSSFSheet sheet = workbook.getSheetAt(0);

            int nColl = sheet.getRow(0).getPhysicalNumberOfCells();
            int nRows = sheet.getPhysicalNumberOfRows();
            for (int i = 0; i < nColl; i++) {

                Cell searchTitle = sheet.getRow(0).getCell(i);
                if (searchResult.equals(searchTitle.toString())) {
                    for (int j = 1; j < nRows; j++) {

                        double searchItemCell = sheet.getRow(j).getCell(i).getNumericCellValue();

                        playerInforList.add(searchItemCell);

                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return playerInforList;
    }
}
