package com.kunjproject.newspringbootproject.excel;

import java.io.IOException;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kunjproject.newspringbootproject.Dto.ProductDto;
import com.kunjproject.newspringbootproject.entities.ProductMaster;
import com.kunjproject.newspringbootproject.entities.SubCategoryProduct;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ProductExcel {
	
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	private List<Object[]> product2;
	
	public ProductExcel(List<Object[]> product2) {
		
		this.product2=product2;
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
	        sheet = workbook.createSheet("product2");
	        Row row = sheet.createRow(0);
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setBold(true);
	        font.setFontHeight(16);
	        style.setFont(font);
	        createCell(row, 0, "ProductId", style);
	        createCell(row, 1, "Active", style);
	        createCell(row, 2, "ProductName", style);
	        createCell(row, 3, "Discription", style);
	        createCell(row, 4, "CategoryName", style);
	        createCell(row, 5, "Price", style);
	        createCell(row, 6, "Discount", style);
	    }
	   private void write() {
	        int rowCount = 1;
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setFontHeight(14);
	        style.setFont(font);
	        for (Object[] record: product2) {
	            Row row = sheet.createRow(rowCount++);
	            int columnCount = 0;
	            createCell(row, columnCount++, record[3],style);
	            createCell(row, columnCount++, String.valueOf(record[1]).equalsIgnoreCase("1") ? "Yes" : "No" , style);
	            createCell(row, columnCount++, record[4], style);
	            createCell(row, columnCount++, record[5], style);
	            createCell(row, columnCount++, record[0], style);
	            createCell(row, columnCount++, record[6], style);
	            createCell(row, columnCount++, record[7], style);
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
