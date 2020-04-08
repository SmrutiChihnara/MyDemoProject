package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderMethodPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, 
			Document document,
			PdfWriter writer,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//set filename and download
		response.addHeader("Content-Disposition","attachment;filename=OrderMethods.PDF");
		//create paragraph
		Paragraph paragraph=new Paragraph("Welcome to Order Method");
		//add to documents
		document.add(paragraph);
		//read data
		List<OrderMethod> orMethods=(List<OrderMethod>) model.get("orMethods");
		//create table
		PdfPTable table=new PdfPTable(6);
		table.addCell("ID");
		table.addCell("MODE");
		table.addCell("CODE");
		table.addCell("METHOD");
		table.addCell("ACCEPT");
		table.addCell("DESCRIPTION");
		
		//add db data to table
		for(OrderMethod om:orMethods) {
			table.addCell(om.getOrderId().toString());
			table.addCell(om.getOrderMode());
			table.addCell(om.getOrderCode());
			table.addCell(om.getOrderMethod());
			table.addCell(om.getOrderAccept().toString());
			table.addCell(om.getDsc());
		}
		document.add(table);
	}
}
