package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.ShipmentType;

public class ShipmentTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			Workbook workbook,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//set filename and download
		response.addHeader("Content-Disposition","attachment;filename=ShipmentType.XLSX");
		//create sheet
		Sheet sheet=workbook.createSheet("ShipmentTypes");
		setHead(sheet);
		//read data
		List<ShipmentType> sTypes=(List<ShipmentType>) model.get("sTypes");
		setBody(sheet, sTypes);
	}
	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("ENABLED SHIPMENT");
		row.createCell(4).setCellValue("GRADE");
		row.createCell(5).setCellValue("DESCRIPTION");
	}
	
	private void setBody(Sheet sheet,List<ShipmentType> sTypes) {
		int rowNum=1;
		for(ShipmentType st:sTypes) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(st.getShipmentTypeId());
			row.createCell(1).setCellValue(st.getShipmentTypeMode());
			row.createCell(2).setCellValue(st.getShipmentTypeCode());
			row.createCell(3).setCellValue(st.getEnableShipment());
			row.createCell(4).setCellValue(st.getGrade());
			row.createCell(5).setCellValue(st.getDsc());
			
		}
	}

}
