package bookstore;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfReport implements Report {
	
	public void generateReport() 
	{
		String FILE = "fisPDF.pdf";
		Model m=new Model();
		List<String> l=new ArrayList<>();
        try {
			l=m.booksOut();
		} catch (SAXException | IOException | ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Document document=new Document();
        try {
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
		} catch (FileNotFoundException | DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        document.open();
        try{
        	 for(int i=0;i<l.size();i++)
        	 {
                 document.open();
                 document.add(new Paragraph(l.get(i)));
                 document.close();
                 document.close();
        		 
        	 }
         } catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
