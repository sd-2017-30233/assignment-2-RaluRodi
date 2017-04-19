package bookstore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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

public class Controller {
	
	private View view;
	private Model model;
	private Document doc,doc1;
	private XPath xpath;
	FileFactory f;
	Book b;
	Employee e;
	
	 public Controller(View view,Model model) throws ParserConfigurationException, SAXException, IOException {
	        this.view = view;
	        this.model=model;
	        view.userListener(new userPanel());
	        view.adminListener(new adminPanel());
	        view.searchG(new searchByGenre());
	        view.searchT(new searchByTitle());
	        view.searchA(new searchByAuthor());
	        view.sellBook(new sellBook());
	        view.backU(new backU());
	        view.backA(new backA());
	        view.addBook(new addBook());
	        view.updateBookP(new updatePrice());
	        view.updateBookQ(new updateQuantity());
	        view.deleteBook(new deleteBook());
	        view.viewBooks(new viewBooks());
	        view.addEmpl(new addEmpl());
	        view.deleteEmpl(new deleteEmpl());
	        view.updateEmpl(new updateEmpl());
	        view.viewEmpl(new viewEmployees());
	        view.pdf(new pdf());
	        view.csv(new csv());
	        
	        File inputFile = new File("C:/Users/Raluca/workspace/BookStore/Book.xml");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         
	         //EMPLOYEE.XML
	         File inputFile1 = new File("C:/Users/Raluca/workspace/BookStore/Employee.xml");
	         DocumentBuilderFactory dbFactory1= DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder1 = dbFactory1.newDocumentBuilder();
	         doc1 = dBuilder1.parse(inputFile1);
	         doc1.getDocumentElement().normalize();
	         
	        // Create XPath object
			xpath = XPathFactory.newInstance().newXPath();
	 }
	 
	
		 
	 
	 //USER PANEL
	 class userPanel implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				JTextField userText = new JTextField();
				JTextField passText = new JTextField();
				
				Object[] msg = {"Username:",userText,"Password:",passText};
				JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
				       JDialog dialog = op.createDialog("Authentication:");
				       dialog.setVisible(true);
				       int result = JOptionPane.OK_OPTION;
				       try
				       {
				           result = ((Integer)op.getValue()).intValue();
				       }
				       catch(Exception uninitializedValue)
				       {}
				     if (result == JOptionPane.OK_OPTION)
				     {
				    	 
				    	String user=userText.getText();
				    	String pass=passText.getText();
				    	 if (user.equals("") || pass.equals(""))
				    		 JOptionPane.showMessageDialog(null, "Uncompleted field", "Alert", JOptionPane.ERROR_MESSAGE);
				    	 else  
				    	 {
				    		 if(!user.equals("user") || !pass.equals("user"))
							{
								JOptionPane.showMessageDialog(null, "Username and Password don't match", "Alert", JOptionPane.ERROR_MESSAGE);
							}
							else
							{
								view.setPanel(view.userPanel);
								view.userPanel.setVisible(true);
								view.mainPanel.setVisible(false); 
							}
				    	 }
				     }
		}
	}
	 
	 
	 //ADMIN PANEL
	 class adminPanel implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				JTextField userText = new JTextField();
				JTextField passText = new JTextField();
				
				Object[] msg = {"Username:",userText,"Password:",passText};
				JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
				       JDialog dialog = op.createDialog("Authentication:");
				       dialog.setVisible(true);
				       int result = JOptionPane.OK_OPTION;
				       try
				       {
				           result = ((Integer)op.getValue()).intValue();
				       }
				       catch(Exception uninitializedValue)
				       {}
				     if (result == JOptionPane.OK_OPTION)
				     {
				    	 
				    	String user=userText.getText();
				    	String pass=passText.getText();
				    	 if (user.equals("") || pass.equals(""))
				    		 JOptionPane.showMessageDialog(null, "Uncompleted field", "Alert", JOptionPane.ERROR_MESSAGE);
				    	 else  
				    	 {
				    		 if(!user.equals("admin") || !pass.equals("admin"))
							{
								JOptionPane.showMessageDialog(null, "Username and Password don't match", "Alert", JOptionPane.ERROR_MESSAGE);
							}
							else
							{
								view.setPanel(view.adminPanel);
								view.adminPanel.setVisible(true);
								view.mainPanel.setVisible(false); 
							}
				    	 }
				     }
		}
	}
	 
	 
	 class searchByGenre implements ActionListener{
		 public void actionPerformed(ActionEvent e)
		 {
			 String genre=view.getGenre();
			 List<String> list=model.searchByGenre(doc, xpath, genre);
			 view.afisGenre(list);
		 }
	 }
	 
	 class searchByTitle implements ActionListener{
		 public void actionPerformed(ActionEvent e)
		 {
			 String title=view.getTitle();
			 List<String> list=model.searchByTitle(doc, xpath, title);
			 view.afisTitle(list);
		 }
	 }
	 
	 class searchByAuthor implements ActionListener{
		 public void actionPerformed(ActionEvent e)
		 {
			 String author=view.getAuthor();
			 List<String> list=model.searchByAuthor(doc, xpath, author);
			 view.afisAuthor(list);
		 }
	 }
	 
	 
	 
	 class sellBook implements ActionListener{
		 public void actionPerformed(ActionEvent e)
		 {
			 
			 String sell=view.sellBook();
			 try {
				int x=model.sellBooks(doc, xpath, sell);
				view.afis(x);
			} catch (FileNotFoundException | TransformerFactoryConfigurationError | TransformerException
					| DatatypeConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
		 }
	 }
	 
	 class backU implements ActionListener{
			public void actionPerformed(ActionEvent e)
			{
				view.setPanel(view.mainPanel);
				view.adminPanel.setVisible(false);
				view.userPanel.setVisible(false);
				view.mainPanel.setVisible(true); 
			}
		}
	 
	 
	 
	 class addBook implements ActionListener{
		 public void actionPerformed(ActionEvent e)
		 {
			String title=view.getTitleA();
			String genre=view.getGenA();
			String author=view.getAuthor();
			String pr=view.getPriceA();
			double price=Double.parseDouble(pr);
			String qu=view.getQuA();
			int quantity=Integer.parseInt(qu);
			
			Book b=new Book(title,author,genre,quantity,price);
			model.addBook(doc, xpath, b);
			view.afisOK();
			view.initAdd();
			 
		 }
	 }
	 
	 class updatePrice implements ActionListener{
		 public void actionPerformed(ActionEvent e)
		 {
			String title=view.getTitleUpdateP();
			String pr=view.getPriceUpdate();
			double price=Double.parseDouble(pr);

			try {
				model.updateBookP(doc, xpath, title,price);
			} catch (TransformerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			view.afisOK();
			view.initUpdateP();
			 
		 }
	 }
	 
	 
	 class updateQuantity implements ActionListener{
		 public void actionPerformed(ActionEvent e)
		 {
			String title=view.getTitleUpdateQ();
			String qu=view.getQuUpdate();
			int quantity=Integer.parseInt(qu);

			try {
				model.updateBookQ(doc, xpath, title,quantity);
			} catch (TransformerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			view.afisOK();
			view.initUpdateQ();
			 
		 }
	 }
	 
	 class deleteBook implements ActionListener{
		 public void actionPerformed(ActionEvent e)
		 {
			String title=view.getTitleDel();
			
			try {
				model.deleteBook(doc, xpath, title);
			} catch (TransformerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			view.afisOK();
			view.initDel();
			 
		 }
	 }
	 
	 class viewBooks implements ActionListener{
		 public void actionPerformed(ActionEvent e)
		 {
			List<String> list=model.viewBook(doc, xpath);
			view.afisBooks(list);			 
		 }
	 }
	 
	 class addEmpl implements ActionListener{
		 public void actionPerformed(ActionEvent e)
		 {
			String name=view.getName();
			String ageS=view.getAge();
			int age=Integer.parseInt(ageS);
			String emplDate=view.getDate();
			
			Employee emp=new Employee(name,age,emplDate);
	
			model.addEmployee(doc1, xpath, emp);
			view.afisOK();
			view.initEmpl(); 
		 }
	 }
	 
	 class deleteEmpl implements ActionListener{
		 public void actionPerformed(ActionEvent e)
		 {
			String name=view.getNameDel();
	
			try {
				model.deleteEmployee(doc1, xpath, name);
			} catch (TransformerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			view.afisOK();
			view.initEmplD(); 
		 }
	 }
	 
	 class updateEmpl implements ActionListener{
		 public void actionPerformed(ActionEvent e)
		 {
			String name=view.getNameUpdate();
			String date=view.getDateUpdate();
	
			try {
				model.updateEmplD(doc1, xpath, name, date);
			} catch (TransformerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			view.afisOK();
			view.initEmplUp(); 
		 }
	 }
	 
	 class viewEmployees implements ActionListener{
		 public void actionPerformed(ActionEvent e)
		 {
			List<String> list=model.viewEmployee(doc1, xpath);
			view.afisEmpl(list);			 
		 }
	 }
	 
	 class pdf implements ActionListener{
		 public void actionPerformed(ActionEvent e)
		 {
			FileFactory f=new FileFactory();		
			Report r=f.getReport("PDF");
			r.generateReport();
			view.afisOK();
		 }
	 }
	 
	 class csv implements ActionListener{
		 public void actionPerformed(ActionEvent e)
		 {
			FileFactory f=new FileFactory();		
			Report r=f.getReport("CSV");
			r.generateReport();
			view.afisOK();
		 }
	 }
	 
	 class backA implements ActionListener{
			public void actionPerformed(ActionEvent e)
			{
				view.setPanel(view.mainPanel);
				view.adminPanel.setVisible(false);
				view.userPanel.setVisible(false);
				view.mainPanel.setVisible(true); 
			}
		}
	 
	 

}
