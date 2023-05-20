package com.kunjproject.newspringbootproject.excel;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import com.kunjproject.newspringbootproject.entities.User;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ExportExcel {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	private List<User> user;
	
	public ExportExcel(List<User> user) {
		
		this.user=user;
		workbook = new XSSFWorkbook();
		}
	
	 private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
	        sheet.autoSizeColumn(columnCount);
	
	        Cell cell = row.createCell(columnCount);
	        if (valueOfCell instanceof Integer) {
	            cell.setCellValue((Integer) valueOfCell);
	        } else if (valueOfCell instanceof Long) {
	            cell.setCellValue((Long) valueOfCell);
	        } else if (valueOfCell instanceof String) {
	            cell.setCellValue((String) valueOfCell);
	        } else {
	            cell.setCellValue((Boolean) valueOfCell);
	        }
	        cell.setCellStyle(style);
	}
	 
	 private void writeHeader() {
	        sheet = workbook.createSheet("User");
	        Row row = sheet.createRow(0);
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setBold(true);
	        font.setFontHeight(16);
	        style.setFont(font);
	        createCell(row, 0, "CategoryId", style);
	        createCell(row, 1, "Active", style);
	        createCell(row, 2, "CategoryName", style);
	        createCell(row, 3, "Discription", style);
	    }
	   private void write() {
	        int rowCount = 1;
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setFontHeight(14);
	        style.setFont(font);
	        for (User record: user) {
	            Row row = sheet.createRow(rowCount++);
	            int columnCount = 0;
	            createCell(row, columnCount++, record.getCategoryId(), style);
	            createCell(row, columnCount++, record.getActive(), style);
	            createCell(row, columnCount++, record.getCategoryName(), style);
	            createCell(row, columnCount++, record.getDiscription(), style);
	        }
	    }
	    public void generateExcelFile(HttpServletResponse response) throws IOException {
	        writeHeader();
	        write();
	        ServletOutputStream outputStream = response.getOutputStream();
	        workbook.write(outputStream);
	        workbook.close();
	        outputStream.close();
	    }
}
