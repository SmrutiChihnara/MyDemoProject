package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Uom;

public class UomExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attachment;filename=UOMS.XLSX");

		Sheet sheet=workbook.createSheet("UOMS");
		setHead(sheet);
		List<Uom> uoms=(List<Uom>) model.get("uoms");
		setBody(sheet, uoms);
	}
	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("TYPE");
		row.createCell(2).setCellValue("MODEL");
		row.createCell(3).setCellValue("DESCRIPTION");

	}
	private void setBody(Sheet sheet,List<Uom> uoms) {
		int rowNum=1;
		for(Uom u:uoms) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(u.getUomId());
			row.createCell(1).setCellValue(u.getUomType());
			row.createCell(2).setCellValue(u.getUomModel());
			row.createCell(3).setCellValue(u.getDsc());
		}
	}
}
