package bookstore;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class Main {

	public static void main(String[] args) throws TransformerFactoryConfigurationError, TransformerException, DatatypeConfigurationException, ParserConfigurationException, SAXException, IOException  {
		// TODO Auto-generated method stub
		/*Model m=new Model();
		try {
			 //BOOK.XML
		     File inputFile = new File("C:/Users/Raluca/workspace/BookStore/Book.xml");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         
	         //EMPLOYEE.XML
	         File inputFile1 = new File("C:/Users/Raluca/workspace/BookStore/Employee.xml");
	         DocumentBuilderFactory dbFactory1= DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder1 = dbFactory1.newDocumentBuilder();
	         Document doc1 = dBuilder1.parse(inputFile1);
	         doc1.getDocumentElement().normalize();
	         
            // Create XPath object
			XPath xpath = XPathFactory.newInstance().newXPath();

            String genre="web";
            List<String> titles = m.searchByGenre(doc,xpath,genre);
            System.out.println("Search by genre:" +
                    Arrays.toString(titles.toArray()));
            
            String title="Learning XML";
           // String title1="Everyday Italian";
            //String title2="XQuery Kick Start";
            List<String> titles1 = m.searchByTitle(doc,xpath,title);
            System.out.println("Search by tile:" +
                    Arrays.toString(titles1.toArray()));
            
            String author="Giada De Laurentiis";
            List<String> titles2 = m.searchByAuthor(doc,xpath,author);
            System.out.println("Search by author:" +
                    Arrays.toString(titles2.toArray()));
            
          // m.sellBooks(doc,xpath,"-1");
           //m.sellBooks(doc,xpath,title1);
            //System.out.println("Done");
           //m.sellBooks(doc,xpath,title2);
            //System.out.println("Gata");
            
            String titl="Ratusca cea urata";
            String auth="Hans Christian Andersen";
            String genree="children";
            int qua=20;
            double price=20.4;
            Book b=new Book(titl,auth,genree,qua,price);
            //m.createBook(b);
            
            
            String t="Ralu";
            String a="Sechel";
            String g="tna:";
            int q=10;
            double p=30;
            Book book=new Book(g,t,a,q,p);
           // m.addBook(doc, xpath, book);
            
            List<String> allBooks = m.viewBook(doc,xpath);
            System.out.println("All books:" +
                    Arrays.toString(allBooks.toArray()));
            
            //m.updateBookQ(doc, xpath, title, 23);
           // m.updateBookP(doc,xpath,title,55.5);
            //m.deleteBook(doc, xpath, "tna:");
            
            String name="Ionut Vasi";
            int age=22;
            String date="13-06-2016";
            Employee e=new Employee(name,age,date);
           // m.addEmployee(doc1, xpath, e);
            
            List<String> allEmpl=m.viewEmployee(doc1, xpath);
            System.out.println("All employees:" + Arrays.toString(allEmpl.toArray()));
            
            //m.updateEmplD(doc1, xpath,name, "12-12-2012");
           // m.deleteEmployee(doc1, xpath, name);
            
           //PdfReport r=new PdfReport();
           // r.generateReport();
            
            //CsvReport c=new CsvReport();
            //c.generateReport();
            */
			Model m=new Model();
            View view=new View();
			Controller controller = new Controller(view,m);
            
		 /*} catch (ParserConfigurationException | SAXException | IOException e) {
	            e.printStackTrace();
	        }*/	   
	}

}
