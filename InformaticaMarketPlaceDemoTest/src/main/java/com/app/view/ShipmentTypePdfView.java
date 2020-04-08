package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document,
			PdfWriter writer,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//set filename and download
		response.addHeader("Content-Disposition", "attachment;filename=ShipmentTypes.PDF");
		//create element
		Paragraph paragraph=new Paragraph("Welcome to Shipment Type");
		//add document
		document.add(paragraph);
		//read data
		List<ShipmentType> sTypes=(List<ShipmentType>) model.get("sTypes");
		
		//create table
		PdfPTable table=new PdfPTable(6);
		//add heading columns
		table.addCell("ID");
		table.addCell("MODE");
		table.addCell("CODE");
		table.addCell("ENABLED SHIPMENT");
		table.addCell("GRADE");
		table.addCell("DESCRIPTION");
		
		//add db data to table
		for(ShipmentType st:sTypes) {
			table.addCell(st.getShipmentTypeId().toString());
			table.addCell(st.getShipmentTypeMode());
			table.addCell(st.getShipmentTypeCode());
			table.addCell(st.getEnableShipment());
			table.addCell(st.getGrade());
			table.addCell(st.getDsc());
		}
		//add document
		document.add(table);
	}
	

}
