package bookstore;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class CsvReport implements Report{
	
	public void generateReport()
	{
		FileWriter fileWriter = null;
		Model m=new Model();
		List<String> l=new ArrayList<>();
		try {
			l=m.booksOut();
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fileWriter = new FileWriter("fisCSV.csv");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0;i<l.size();i++)
		{
			try {
				fileWriter.append(l.get(i));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			fileWriter.flush();
		    fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
			 e.printStackTrace();
	}

		
	}

}
