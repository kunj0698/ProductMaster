package com.kunjproject.newspringbootproject.excel;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kunjproject.newspringbootproject.entities.SubCategoryProduct;
import com.kunjproject.newspringbootproject.entities.User;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class SubCategoryExcel {
	
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	private List<SubCategoryProduct>subCat;
	
	public SubCategoryExcel(List<SubCategoryProduct> subCat) {
		
		this.subCat=subCat;
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
	        sheet = workbook.createSheet("subCat");
	        Row row = sheet.createRow(0);
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setBold(true);
	        font.setFontHeight(16);
	        style.setFont(font);
	        createCell(row, 0, "SubCategoryId", style);
	        createCell(row, 1, "Active", style);
	        createCell(row, 2, "CategoryName", style);
	        createCell(row, 3, "SubCategoryName", style);
	        createCell(row, 4, "Discription", style);
	    }
	   private void write() {
	        int rowCount = 1;
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setFontHeight(14);
	        style.setFont(font);
	        for (SubCategoryProduct record: subCat) {
	            Row row = sheet.createRow(rowCount++);
	            int columnCount = 0;
	            createCell(row, columnCount++, record.getSubCategoryId(), style);
	            createCell(row, columnCount++, String.valueOf(record.getActive()).equalsIgnoreCase("1") ? "Yes" : "No" , style);
	            createCell(row, columnCount++, record.getCategoryName(), style);
	            createCell(row, columnCount++, record.getSubCategoryName(), style);
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
