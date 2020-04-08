package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			Workbook workbook,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//set filename and download
		response.addHeader("Content-Disposition", "attachment;filename=WhUserTypes.XLSX");
		//create sheet
		Sheet sheet=workbook.createSheet("WhUserTypes");
		setHead(sheet);
		//read data
		List<WhUserType> userTypes=(List<WhUserType>) model.get("userTypes");
		setBody(sheet, userTypes);
	}
	
	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("TYPE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("FOR");
		row.createCell(4).setCellValue("EMAIL");
		row.createCell(5).setCellValue("CONTACT");
		row.createCell(6).setCellValue("IDTYPE");
		row.createCell(7).setCellValue("IF OTHER");
		row.createCell(8).setCellValue("ID NUMBER");
	}
	private void setBody(Sheet sheet,List<WhUserType> userTypes) {
		int rowNum=1;
		for(WhUserType ut:userTypes) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(ut.getUserId());
			row.createCell(1).setCellValue(ut.getUserType());
			row.createCell(2).setCellValue(ut.getUserCode());
			row.createCell(3).setCellValue(ut.getForType());
			row.createCell(4).setCellValue(ut.getUserEmail());
			row.createCell(5).setCellValue(ut.getUsercontact());
			row.createCell(6).setCellValue(ut.getIdType());
			row.createCell(7).setCellValue(ut.getIfOther());
			row.createCell(8).setCellValue(ut.getIdNum());
		}
	}

}
