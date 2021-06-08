package com.testing.Excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PoiExample {
    public static void main(String[] args) {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet1 = wb.createSheet("new sheet");
        Sheet sheet2 = wb.createSheet("second sheet");

        String safeName = WorkbookUtil.createSafeSheetName("[O'Brien's sales*?]"); // returns " O'Brien's sales   "
        Sheet sheet3 = wb.createSheet(safeName);

//        CreationHelper createHelper = wb.getCreationHelper();
//        Sheet sheet = wb.createSheet("new sheet");
//
//        // Create a row and put some cells in it. Rows are 0 based.
//        Row row = sheet.createRow(0);
//        // Create a cell and put a value in it.
//        Cell cell = row.createCell(0);
//        cell.setCellValue(1);
//
//        // Or do it on one line.
//        row.createCell(1).setCellValue(1.2);
//        row.createCell(2).setCellValue(
//                createHelper.createRichTextString("This is a string"));
//        row.createCell(3).setCellValue(true);
               try (OutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
            wb.write(fileOut);
//
//
//                    // Create a cell and put a date value in it.  The first cell is not styled
//                    // as a date.
//
////                    cell.setCellValue(new Date());
////
////                    // we style the second cell as a date (and time).  It is important to
////                    // create a new cell style from the workbook otherwise you can end up
////                    // modifying the built in style and effecting not only this cell but other cells.
////                    CellStyle cellStyle = wb.createCellStyle();
////                    cellStyle.setDataFormat(
////                            createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
////                    cell = row.createCell(1);
////                    cell.setCellValue(new Date());
////                    cell.setCellStyle(cellStyle);
////
////                    //you can also set date as java.util.Calendar
////                    cell = row.createCell(2);
////                    cell.setCellValue(Calendar.getInstance());
////                    cell.setCellStyle(cellStyle);

        }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

    }
}
