package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, 
			Document document,
			PdfWriter writer,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//set filename and download
		response.addHeader("Content-Disposition","attachment;filename=WhUserTypes.PDF");
		//create element
		Paragraph paragraph=new Paragraph("Welcome to WhUserType");
		//add document
		document.add(paragraph);
		//read data
		List<WhUserType> userTypes=(List<WhUserType>) model.get("userTypes");
		//create table
		PdfPTable table=new PdfPTable(9);
		//set heading column
		table.addCell("ID");
		table.addCell("TYPE");
		table.addCell("CODE");
		table.addCell("FOR");
		table.addCell("EMAIL");
		table.addCell("CONTACT");
		table.addCell("IDTYPE");
		table.addCell("IF OTHER");
		table.addCell("ID NUMBER");
		
		//add data from db to table
		for(WhUserType ut:userTypes) {
			table.addCell(ut.getUserId().toString());
			table.addCell(ut.getUserType());
			table.addCell(ut.getUserCode());
			table.addCell(ut.getForType());
			table.addCell(ut.getUserEmail());
			table.addCell(ut.getUsercontact());
			table.addCell(ut.getIdType());
			table.addCell(ut.getIfOther());
			table.addCell(ut.getIdNum());
		}
		//add document
		document.add(table);
	}
}
