package Serialization.Excel;

import Control.Manager;
import InfoAboutContacts.Contact;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ApatchPOIClass {
    private final static String xlsFile = "projectbook.xlsx";
    public static void Serialization() throws IOException {
        //создаем файл
        FileOutputStream out = new FileOutputStream(new File(xlsFile));
        //создаем рабочую книгу
        XSSFWorkbook workbook = new XSSFWorkbook();
        //создать лист
        XSSFSheet sheet = workbook.createSheet("project");
        int rowindex = 0 ;
        // созадем Font
        XSSFFont headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());
        // создаем CellStyle
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        XSSFRow row = sheet.createRow((short) rowindex);
        row.createCell(0).setCellStyle(headerCellStyle);
        row.getCell(0).setCellValue("Contact ID");
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Surname");
        for (Contact contact: Manager.getContactList()) {
            row = sheet.createRow((short) ++rowindex);
            row.createCell(0).setCellValue(contact.getId());
            row.createCell(1).setCellValue(String.valueOf(contact.getName()));
            row.createCell(2).setCellValue(String.valueOf(contact.getSurname()));
        }
        workbook.write(out);
        out.close();
    }
}
