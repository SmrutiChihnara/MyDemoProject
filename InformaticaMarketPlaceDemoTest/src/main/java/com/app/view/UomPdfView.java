package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document,
			PdfWriter writer,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//set filename and download
		response.addHeader("Content-Disposition","attachment;filename=UOMS.PDF");
		//create paragraph
		Paragraph paragraph=new Paragraph("Welcome to UOMS");
		//add to documents
		document.add(paragraph);
		//read data
		List<Uom> uoms=(List<Uom>) model.get("uoms");
		
		//create table
		PdfPTable table=new PdfPTable(4);
		table.addCell("ID");
		table.addCell("TYPE");
		table.addCell("MODEL");
		table.addCell("DESCRIPTION");
		
		//fetches data from db
		for(Uom u:uoms) {
			table.addCell(u.getUomId().toString());
			table.addCell(u.getUomType());
			table.addCell(u.getUomModel());
			table.addCell(u.getDsc());
		}
		//add to document
		document.add(table);
	}
}
