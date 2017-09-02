package com.garse.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

/***
 * 
 * @author srinivasans
 *
 */

public final class ExcelUtils {
    private static InputStream in = null;
    private static List<String> values = null;
    private static HSSFWorkbook workbook = null;
    private static HSSFSheet sheet = null;
    private static HSSFRow row = null;
    private static HSSFCell cell = null;
    private static Iterator rows = null;
    private static Iterator cells = null;
    public static List<String> readXLSFile(String FILE_NAME) {
        try {
            in = new FileInputStream(FILE_NAME);
            workbook = new HSSFWorkbook(in);
            sheet = workbook.getSheetAt(0);
            rows = sheet.rowIterator();
            values = new ArrayList<String>();
            while (rows.hasNext()) {
                row = (HSSFRow) rows.next();
                cells = row.cellIterator();
                while (cells.hasNext()) {
                    cell = (HSSFCell) cells.next();
                    if (cell.getCellTypeEnum() == CellType.STRING ) {
                        values.add(cell.getStringCellValue());
                    } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                        values.add(String.valueOf(cell.getNumericCellValue()));
                    } else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
                        values.add(String.valueOf(cell.getBooleanCellValue()));
                    } else { // //Here if require, we can also add below methods to
                        // read the cell content
                        // HSSFCell.CELL_TYPE_BLANK
                        // HSSFCell.CELL_TYPE_FORMULA
                        // HSSFCell.CELL_TYPE_ERROR
                    }
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                workbook.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return values;
    }
}
