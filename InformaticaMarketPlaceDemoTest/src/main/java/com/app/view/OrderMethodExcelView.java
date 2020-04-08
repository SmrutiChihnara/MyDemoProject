package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			Workbook workbook,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// set file name and download
		response.addHeader("Content-Disposition","attachment;filename=OrderMethods.XLSX");
		//create sheet
		Sheet sheet=workbook.createSheet("OrderMethods");
		//set head
		setHead(sheet);
		//read data
		List<OrderMethod> orMethods=(List<OrderMethod>) model.get("orMethods");
		//set body
		setBody(sheet, orMethods);
	}
	
	public void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("METHOD");
		row.createCell(4).setCellValue("ACCEPT");
		row.createCell(5).setCellValue("DESCRIPTION");
	}
	
	public void setBody(Sheet sheet,List<OrderMethod> orMethods) {
		int rowNum=1;
		for(OrderMethod om:orMethods) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(om.getOrderId());
			row.createCell(1).setCellValue(om.getOrderMode());
			row.createCell(2).setCellValue(om.getOrderCode());
			row.createCell(3).setCellValue(om.getOrderMethod());
			row.createCell(4).setCellValue(om.getOrderAccept().toString());
			row.createCell(5).setCellValue(om.getDsc());
		}
	}
}
