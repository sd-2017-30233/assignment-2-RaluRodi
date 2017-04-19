package bookstore;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;



public class Model {

	
	
	//SEARCH BY GENRE
	public List<String> searchByGenre(Document doc, XPath xpath,String genre) {
        List<String> list = new ArrayList<>();
        try {
        	
            //create XPathExpression object
            XPathExpression expr =xpath.compile("/bookstore/book[genre='"+genre+"']/title/text()");
            //evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++)
            {
                list.add(nodes.item(i).getNodeValue());
               // System.out.println(nodes.item(i).getNodeValue());
            }
            
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return list;
    }
        
	
	//SEARCH BY TITLE
        public List<String> searchByTitle(Document doc, XPath xpath,String title) {
            List<String> list = new ArrayList<>();
            try {
                //create XPathExpression object
                XPathExpression expr =xpath.compile("bookstore/book[title='"+ title +"']/title/text()");
                //evaluate expression result on XML document
                NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
                for (int i = 0; i < nodes.getLength(); i++)
                {
                    list.add(nodes.item(i).getNodeValue());
                   // System.out.println(nodes.item(i).getNodeValue());
                }
                
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }
            return list;
        }
        
        
        
        //SEARCH BY AUTHOR
        public List<String> searchByAuthor(Document doc, XPath xpath,String author) {
            List<String> list = new ArrayList<>();
            try {
                //create XPathExpression object
                XPathExpression expr =xpath.compile("bookstore/book[author='"+ author +"']/title/text()");
                //evaluate expression result on XML document
                NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
                for (int i = 0; i < nodes.getLength(); i++)
                {
                    list.add(nodes.item(i).getNodeValue());
                   // System.out.println(nodes.item(i).getNodeValue());
                }
                
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }
            return list;
        }
        
        

        //SELL BOOKS
        public int sellBooks(Document doc,XPath xpath,String title) throws FileNotFoundException, TransformerFactoryConfigurationError, TransformerException, DatatypeConfigurationException
        {
        	XPathExpression expr;
        	int qu=0;
			try {
				expr = xpath.compile("bookstore/book[title='"+ title +"']/title/text()");
	             //evaluate expression result on XML document
	             NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
	             if(nodes.getLength()==0)
	             {
	            	 System.out.println("Book doesn't exist");
	            	// return 0;
	             }
	             else
	             {
	            	 NodeList myNodeList = (NodeList) xpath.compile("bookstore/book[title='"+ title +"']/quantity/text()").evaluate(doc, XPathConstants.NODESET);
	            	 String q = myNodeList.item(0).getNodeValue();
	            	 qu=Integer.parseInt(q);
	            	 if(qu>0)
	            	 {
	            	 qu=qu-1;
	          
	            	 //Update quantity
	            	 myNodeList.item(0).setNodeValue(Integer.toString(qu));
	            	 
	            	 //Save changes to file
	            	 Transformer transformer = TransformerFactory.newInstance().newTransformer();
	            	 transformer.transform(new DOMSource(doc), new StreamResult(new File("C:/Users/Raluca/workspace/BookStore/Book.xml")));
	            	 
	            	 //String d="12-02-2017";
	            	 //Sale sale=new Sale(title,d);
	            	// addSale(sale);
	            	 //serializeSale(); 
	             }
	            	 else
	            	 {
	            		 return 0;
	            	 }
	           }
	             
			} catch (XPathExpressionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return qu;
   }
        
      
        
      //ADD BOOKS
      public void addBook(Document doc,XPath xpath,Book b)
      {
    	  try{
	       NodeList nodeList = doc.getElementsByTagName("bookstore");
	       
	       Element book=doc.createElement("book");
	       
	       String title=b.getTitle();
	       String genre=b.getGenre();
	       String author=b.getAuthor();
	       int quantity=b.getQuantity();
	       double price=b.getPrice();
	       
	       Element tit=doc.createElement("title");
	       tit.appendChild(doc.createTextNode(title));	       
	       Element gen=doc.createElement("genre");
	       gen.appendChild(doc.createTextNode(genre));	       
	       Element aut=doc.createElement("author");
	       aut.appendChild(doc.createTextNode(author));      
	       Element qua=doc.createElement("quantity");
	       qua.appendChild(doc.createTextNode(Integer.toString(quantity)));
	       Element pr=doc.createElement("price");
	       pr.appendChild(doc.createTextNode(Double.toString(price)));
	      
	       book.appendChild(gen);
	       book.appendChild(tit);
	       book.appendChild(aut);
	       book.appendChild(qua);
	       book.appendChild(pr);
	       
	       Node node = nodeList.item(0);
	       node.appendChild(book);   
	
	       TransformerFactory tff  = TransformerFactory.newInstance();
	       Transformer transformer = tff.newTransformer();
	      
	       DOMSource xmlSource = new DOMSource(doc);
	       StreamResult outputTarget = new StreamResult("Book.xml");
	       transformer.transform(xmlSource, outputTarget);
      }
    	  catch(Exception e)
    	  {
    		  e.printStackTrace();
    	  }
    }
      
      
      
      //VIEW BOOKS
      public List<String> viewBook(Document doc, XPath xpath)
      {
    	  List<String> list = new ArrayList<>();
          try {
              //create XPathExpression object
              XPathExpression expr =xpath.compile("bookstore/book/title/text()");
              //evaluate expression result on XML document
              NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
              for (int i = 0; i < nodes.getLength(); i++)
              {
                  list.add(nodes.item(i).getNodeValue());
                 // System.out.println(nodes.item(i).getNodeValue());
              }
              
          } catch (XPathExpressionException e) {
              e.printStackTrace();
          }
          return list;
      }
      
      
      
      
      //UPDATE BOOK QUANTITY
      public void updateBookQ(Document doc,XPath xpath,String title,int qu) throws TransformerException
      {
    	  try {
              XPathExpression expr =xpath.compile("bookstore/book[title='"+title+"']/quantity/text()");
              NodeList node = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
              //Update quantity
              node.item(0).setNodeValue(Integer.toString(qu));
         	 //Save changes to file
         	 Transformer transformer = TransformerFactory.newInstance().newTransformer();
         	 transformer.transform(new DOMSource(doc), new StreamResult(new File("C:/Users/Raluca/workspace/BookStore/Book.xml")));
              
          } catch (XPathExpressionException e) {
              e.printStackTrace();
          }
         
      }
      
      
      
      //UPDATE BOOK PRICE
      public void updateBookP(Document doc,XPath xpath,String title,double pr) throws TransformerException
      {
    	  try {
              XPathExpression expr =xpath.compile("bookstore/book[title='"+title+"']/price/text()");
              NodeList node = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
              //Update quantity
              node.item(0).setNodeValue(Double.toString(pr));
         	 //Save changes to file
         	 Transformer transformer = TransformerFactory.newInstance().newTransformer();
         	 transformer.transform(new DOMSource(doc), new StreamResult(new File("C:/Users/Raluca/workspace/BookStore/Book.xml")));
              
          } catch (XPathExpressionException e) {
              e.printStackTrace();
          }
         
      }
      
      
      
      
    //DELETE BOOK
      public void deleteBook(Document doc,XPath xpath,String title) throws TransformerException
      {
    	  try {
              XPathExpression expr =xpath.compile("bookstore/book[title='"+title+"']");
              NodeList node = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
              for(int i=0;i<node.getLength();i++)
              {
            	  Node n=node.item(i);
            	  n.getParentNode().removeChild(n);
              }
         	 Transformer transformer = TransformerFactory.newInstance().newTransformer();
         	 transformer.transform(new DOMSource(doc), new StreamResult(new File("C:/Users/Raluca/workspace/BookStore/Book.xml")));
              
          } catch (XPathExpressionException e) {
              e.printStackTrace();
          }
      }
      
      
      
      
      //ADD EMPLOYEE
      public void addEmployee(Document doc, XPath xpath, Employee em)
      {
    	  try{
   	       NodeList nodeList = doc.getElementsByTagName("employees");
   	       
   	       Element employee=doc.createElement("empl");
   	       
   	       String name=em.getName();
   	       int age=em.getAge();
   	       String date=em.getDate();
   	       
   	       Element n=doc.createElement("name");
   	       n.appendChild(doc.createTextNode(name));	       
   	       Element ag=doc.createElement("age");
   	       ag.appendChild(doc.createTextNode(Integer.toString(age)));	       
   	       Element empld=doc.createElement("empl_date");
   	       empld.appendChild(doc.createTextNode(date));      
   	      
   	    employee.appendChild(n);
   	    employee.appendChild(ag);
   	    employee.appendChild(empld);
   	       
   	       Node node = nodeList.item(0);
   	       node.appendChild(employee);   
   	
   	       TransformerFactory tff  = TransformerFactory.newInstance();
   	       Transformer transformer = tff.newTransformer();
   	      
   	       DOMSource xmlSource = new DOMSource(doc);
   	       StreamResult outputTarget = new StreamResult("Employee.xml");
   	       transformer.transform(xmlSource, outputTarget);
         }
       	  catch(Exception e)
       	  {
       		  e.printStackTrace();
       	  }
      }
      
      
      
      
     //VIEW EMPLOYEES
      public List<String> viewEmployee(Document doc, XPath xpath)
      {
    	  List<String> list = new ArrayList<>();
          try {
              //create XPathExpression object
              XPathExpression expr =xpath.compile("employees/empl/name/text()");
              //evaluate expression result on XML document
              NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
              for (int i = 0; i < nodes.getLength(); i++)
              {
                  list.add(nodes.item(i).getNodeValue());
                 // System.out.println(nodes.item(i).getNodeValue());
              }
              
          } catch (XPathExpressionException e) {
              e.printStackTrace();
          }
          return list;
      }
      
      
      
    //UPDATE EMPLOYEE DATE
      public void updateEmplD(Document doc,XPath xpath,String name,String date) throws TransformerException
      {
    	  try {
              XPathExpression expr =xpath.compile("employees/empl[name='"+name+"']/empl_date/text()");
              NodeList node = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
              //Update quantity
              node.item(0).setNodeValue(date);
         	 //Save changes to file
         	 Transformer transformer = TransformerFactory.newInstance().newTransformer();
         	 transformer.transform(new DOMSource(doc), new StreamResult(new File("C:/Users/Raluca/workspace/BookStore/Employee.xml")));
              
          } catch (XPathExpressionException e) {
              e.printStackTrace();
          }
         
      }
      
      
      
      
     //DELETE EMPLOYEE
      public void deleteEmployee(Document doc,XPath xpath,String name) throws TransformerException
      {
    	  try {
              XPathExpression expr =xpath.compile("employees/empl[name='"+name+"']");
              NodeList node = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
              for(int i=0;i<node.getLength();i++)
              {
            	  Node n=node.item(i);
            	  n.getParentNode().removeChild(n);
              }
         	 Transformer transformer = TransformerFactory.newInstance().newTransformer();
         	 transformer.transform(new DOMSource(doc), new StreamResult(new File("C:/Users/Raluca/workspace/BookStore/Employee.xml")));
              
          } catch (XPathExpressionException e) {
              e.printStackTrace();
          }
      }
      
      
      public List<String> booksOut() throws SAXException, IOException, ParserConfigurationException
      {
    	     List<String> list=new ArrayList<>();
    	     File inputFile = new File("C:/Users/Raluca/workspace/BookStore/Book.xml");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
  
	         XPath xpath = XPathFactory.newInstance().newXPath();
    	  try {
              XPathExpression expr =xpath.compile("bookstore/book[quantity='"+0+"']/title/text()");
              NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
              
              for(int i=0;i<nodes.getLength();i++)
              {
            	  list.add(nodes.item(i).getNodeValue()); 
            	  System.out.println(nodes.item(i).getNodeValue());
              }
      }
      catch (XPathExpressionException e) {
          e.printStackTrace();
      }
      return list;
      
}
      

}

        
    
        


