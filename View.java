package bookstore;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View extends JFrame{

	private static final long serialVersionUID = 1L;

	//FRAME
	JFrame frame = new JFrame("Book");
	
	//PANELS
	JPanel mainPanel=new JPanel();
	JPanel userPanel=new JPanel();
	JPanel adminPanel=new JPanel();
	
	//BUTTONS
	private JButton userButton=new JButton("USER");
	private JButton adminButton=new JButton("ADMIN");
	
	//buttons for user
	private JButton searchG=new JButton("Search by Genre");
	private JButton searchT=new JButton("Search by Title");
	private JButton searchA=new JButton("Search by Author");
	private JButton sellBook=new JButton("Sell Book");
	
	//buttons for admin
	private JButton addBook=new JButton("Add Book");
	private JButton viewBooks=new JButton("View Books");
	private JButton updateBookQ=new JButton("Update Quantity");
	private JButton updateBookP=new JButton("Update Price");
	private JButton deleteBook=new JButton("Delete Book");
	private JButton addEmployee=new JButton("Add Employee");
	private JButton viewEmpl=new JButton("View Employees");
	private JButton updateEmpl=new JButton("Updae Employee");
	private JButton deleteEmpl=new JButton("Delete Employee");
	private JButton backUser=new JButton("Back");
	private JButton backAdmin=new JButton("Back");
	private JButton pdf=new JButton("PDF");
	private JButton csv=new JButton("CSV");
	
	//TEXT FIELDS
	private JTextArea showUser=new JTextArea();
	private JTextArea showAdmin=new JTextArea();
	private JTextField genre=new JTextField();
	private JTextField title=new JTextField();
	private JTextField author=new JTextField();
	private JTextField sellTitle=new JTextField();
	
	private JTextField titText=new JTextField();
	private JTextField genText=new JTextField();
	private JTextField autText=new JTextField();
	private JTextField prText=new JTextField();
	private JTextField quText=new JTextField();
	
	private JTextField upTitle=new JTextField();
	private JTextField upPrice=new JTextField();
	
	private JTextField upTitleQ=new JTextField();
	private JTextField upPriceQ=new JTextField();
	
	private JTextField deleteB=new JTextField();
	
	private JTextField nameT=new JTextField();
	private JTextField ageT=new JTextField();
	private JTextField emplDateT=new JTextField();
	private JTextField deleteNameT=new JTextField();
	
	private JTextField nameUpdateT=new JTextField();
	private JTextField dateUpdateT=new JTextField();
	
	//LABELS
	private JLabel welcomeLabel=new JLabel("WELCOME!");
	private JLabel chooseOp=new JLabel("CHOOSE ONE!");
	private JLabel chooseOp1=new JLabel("CHOOSE ONE!");
	private JLabel tit=new JLabel("Title:");
	private JLabel gen=new JLabel("Genre:");
	private JLabel aut=new JLabel("Author");
	private JLabel pr=new JLabel("Price:");
	private JLabel qu=new JLabel("Quantity:");
	private JLabel titlePrice=new JLabel("Title:");
	private JLabel updatePrice=new JLabel("Price:");
	private JLabel titlePriceQ=new JLabel("Title:");
	private JLabel updatePriceQ=new JLabel("Quant:");
	private JLabel deleteBoo=new JLabel("Title:");
	private JLabel nameL=new JLabel("Name:");
	private JLabel ageL=new JLabel("Age:");
	private JLabel emplDateL=new JLabel("Date:");
	private JLabel deleteName=new JLabel("Name:");
	private JLabel nameUpdate=new JLabel("Name:");
	private JLabel dateUpdate=new JLabel("Date:");
	
	
	public View()
	{
		  frame.setVisible(true);
		  frame.setSize(900,600);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  frame.add(mainPanel);
		  
		  //MAIN PANEL
		  mainPanel.setBackground(new Color(255, 230, 204));
		  mainPanel.setLayout(null);
		  
		  userButton.setBounds(230,250,130,50);
		  userButton.setBackground(new Color(102, 53, 0));
		  userButton.setForeground(Color.white);
		  userButton.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  //userButton.addActionListener(new userPanel());
		  mainPanel.add(userButton);
	
		  adminButton.setBounds(550,250,130,50);
		  adminButton.setBackground(new Color(102, 53, 0));
		  adminButton.setForeground(Color.white);
		  adminButton.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  //adminButton.addActionListener(new adminPanel());
		  mainPanel.add(adminButton);
		  
		  welcomeLabel.setBounds(350,100,300,100);
		  welcomeLabel.setFont(new Font("Times New Roman", Font.ITALIC, 40));
		  welcomeLabel.setForeground(new Color(102, 53, 0));
		  mainPanel.add(welcomeLabel);
		  
		  
		  
		  
		  //USER PANEL
		  userPanel.setBackground(new Color(255, 230, 204));
		  userPanel.setLayout(null);
		  
		  chooseOp.setBounds(290,10,300,100);
		  chooseOp.setFont(new Font("Times New Roman", Font.ITALIC, 40));
		  chooseOp.setForeground(new Color(102, 53, 0));
		  userPanel.add(chooseOp);
		  
		  searchG.setBounds(250,140,170,30);
		  searchG.setBackground(new Color(102, 53, 0));
		  searchG.setForeground(Color.white);
		  searchG.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  //searchG.addActionListener(new clientInfo());
		  userPanel.add(searchG);
		  
		  genre.setBounds(430,140,170,30);
		  userPanel.add(genre);
		  
		  searchT.setBounds(250,190,170,30);
		  searchT.setBackground(new Color(102, 53, 0));
		  searchT.setForeground(Color.white);
		  searchT.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  //searchG.addActionListener(new clientInfo());
		  userPanel.add(searchT);
		  
		  title.setBounds(430,190,170,30);
		  userPanel.add(title);
		  
		  searchA.setBounds(250,250,170,30);
		  searchA.setBackground(new Color(102, 53, 0));
		  searchA.setForeground(Color.white);
		  searchA.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  //searchG.addActionListener(new clientInfo());
		  userPanel.add(searchA);
		  
		  author.setBounds(430,250,170,30);
		  userPanel.add(author);
		  
		  sellBook.setBounds(250,300,170,30);
		  sellBook.setBackground(new Color(102, 53, 0));
		  sellBook.setForeground(Color.white);
		  sellBook.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  //searchG.addActionListener(new clientInfo());
		  userPanel.add(sellBook);
		  
		  sellTitle.setBounds(430,300,170,30);
		  userPanel.add(sellTitle);
		  
		  showUser.setBounds(250,350,350,150);
		  userPanel.add(showUser);
		  
		  backUser.setBounds(100,400,100,30);
		  backUser.setBackground(new Color(102, 53, 0));
		  backUser.setForeground(Color.white);
		  backUser.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  //searchG.addActionListener(new clientInfo());
		  userPanel.add(backUser);
		  
		  
		  
		  
		  //ADMIN PANEL
		  adminPanel.setBackground(new Color(255, 230, 204));
		  adminPanel.setLayout(null);
		  
		  chooseOp1.setBounds(290,5,300,100);
		  chooseOp1.setFont(new Font("Times New Roman", Font.ITALIC, 40));
		  chooseOp1.setForeground(new Color(102, 53, 0));
		  adminPanel.add(chooseOp1);
		  
		  //ADD BOOK
		  tit.setBounds(20,40,300,100);
		  tit.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  tit.setForeground(new Color(102, 53, 0));
		  adminPanel.add(tit);
		  
		  titText.setBounds(100,80,130,20);
		  adminPanel.add(titText);
		  
		  gen.setBounds(20,70,300,100);
		  gen.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  gen.setForeground(new Color(102, 53, 0));
		  adminPanel.add(gen);
		  
		  genText.setBounds(100,110,130,20);
		  adminPanel.add(genText);
		  
		  aut.setBounds(20,100,300,100);
		  aut.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  aut.setForeground(new Color(102, 53, 0));
		  adminPanel.add(aut);
		  
		  autText.setBounds(100,140,130,20);
		  adminPanel.add(autText);
		  
		  qu.setBounds(20,130,300,100);
		  qu.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  qu.setForeground(new Color(102, 53, 0));
		  adminPanel.add(qu);
		  
		  quText.setBounds(100,170,130,20);
		  adminPanel.add(quText);
		  
		  pr.setBounds(20,160,300,100);
		  pr.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  pr.setForeground(new Color(102, 53, 0));
		  adminPanel.add(pr);
		  
		  prText.setBounds(100,200,130,20);
		  adminPanel.add(prText);
		  
		  addBook.setBounds(45,235,120,30);
		  addBook.setBackground(new Color(102, 53, 0));
		  addBook.setForeground(Color.white);
		  addBook.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  //searchG.addActionListener(new clientInfo());
		  adminPanel.add(addBook);
		  
		  
		  //UPDATE BOOK BY PRICE
		  titlePrice.setBounds(240,40,300,100);
		  titlePrice.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  titlePrice.setForeground(new Color(102, 53, 0));
		  adminPanel.add(titlePrice);
		  
		  upTitle.setBounds(290,80,130,20);
		  adminPanel.add(upTitle);
		  
		  updatePrice.setBounds(240,70,300,100);
		  updatePrice.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  updatePrice.setForeground(new Color(102, 53, 0));
		  adminPanel.add(updatePrice);
		  
		  upPrice.setBounds(290,110,130,20);
		  adminPanel.add(upPrice);
		  
		  updateBookP.setBounds(265,140,120,30);
		  updateBookP.setBackground(new Color(102, 53, 0));
		  updateBookP.setForeground(Color.white);
		  updateBookP.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  //searchG.addActionListener(new clientInfo());
		  adminPanel.add(updateBookP);
		  
		  
		//UPDATE BOOK BY QUANTITY
		  titlePriceQ.setBounds(440,40,300,100);
		  titlePriceQ.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  titlePriceQ.setForeground(new Color(102, 53, 0));
		  adminPanel.add(titlePriceQ);
		  
		  upTitleQ.setBounds(490,80,130,20);
		  adminPanel.add(upTitleQ);
		  
		  updatePriceQ.setBounds(430,70,300,100);
		  updatePriceQ.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  updatePriceQ.setForeground(new Color(102, 53, 0));
		  adminPanel.add(updatePriceQ);
		  
		  upPriceQ.setBounds(490,110,130,20);
		  adminPanel.add(upPriceQ);
		  
		  updateBookQ.setBounds(470,140,140,30);
		  updateBookQ.setBackground(new Color(102, 53, 0));
		  updateBookQ.setForeground(Color.white);
		  updateBookQ.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  //searchG.addActionListener(new clientInfo());
		  adminPanel.add(updateBookQ);
		  
		  viewBooks.setBounds(300,235,120,30);
		  viewBooks.setBackground(new Color(102, 53, 0));
		  viewBooks.setForeground(Color.white);
		  viewBooks.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  //searchG.addActionListener(new clientInfo());
		  adminPanel.add(viewBooks);
		  
		  pdf.setBounds(450,235,120,30);
		  pdf.setBackground(new Color(102, 53, 0));
		  pdf.setForeground(Color.white);
		  pdf.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  //searchG.addActionListener(new clientInfo());
		  adminPanel.add(pdf);
		  
		  csv.setBounds(600,235,120,30);
		  csv.setBackground(new Color(102, 53, 0));
		  csv.setForeground(Color.white);
		  csv.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  //searchG.addActionListener(new clientInfo());
		  adminPanel.add(csv);
		  
		  deleteBoo.setBounds(640,40,300,100);
		  deleteBoo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  deleteBoo.setForeground(new Color(102, 53, 0));
		  adminPanel.add(deleteBoo);
		  
		  deleteB.setBounds(690,80,130,20);
		  adminPanel.add(deleteB);
		  
		  deleteBook.setBounds(690,140,120,30);
		  deleteBook.setBackground(new Color(102, 53, 0));
		  deleteBook.setForeground(Color.white);
		  deleteBook.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  //searchG.addActionListener(new clientInfo());
		  adminPanel.add(deleteBook);
		  
		  
		  
		  //ADD EMPLOYEE
		  nameL.setBounds(20,260,300,100);
		  nameL.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  nameL.setForeground(new Color(102, 53, 0));
		  adminPanel.add(nameL);
		  
		  nameT.setBounds(100,300,130,20);
		  adminPanel.add(nameT);
		  
		  ageL.setBounds(20,290,300,100);
		  ageL.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  ageL.setForeground(new Color(102, 53, 0));
		  adminPanel.add(ageL);
		  
		  ageT.setBounds(100,330,130,20);
		  adminPanel.add(ageT);
		  
		  emplDateL.setBounds(20,320,300,100);
		  emplDateL.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  emplDateL.setForeground(new Color(102, 53, 0));
		  adminPanel.add(emplDateL);
		  
		  emplDateT.setBounds(100,360,130,20);
		  adminPanel.add(emplDateT);
		  
		  addEmployee.setBounds(45,390,140,30);
		  addEmployee.setBackground(new Color(102, 53, 0));
		  addEmployee.setForeground(Color.white);
		  addEmployee.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  //searchG.addActionListener(new clientInfo());
		  adminPanel.add(addEmployee);
		  
		  
		  deleteName.setBounds(20,400,300,100);
		  deleteName.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  deleteName.setForeground(new Color(102, 53, 0));
		  adminPanel.add(deleteName);
		  
		  deleteNameT.setBounds(100,440,130,20);
		  adminPanel.add(deleteNameT);
		  
		  deleteEmpl.setBounds(45,470,140,30);
		  deleteEmpl.setBackground(new Color(102, 53, 0));
		  deleteEmpl.setForeground(Color.white);
		  deleteEmpl.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  //searchG.addActionListener(new clientInfo());
		  adminPanel.add(deleteEmpl);
		  
		  
		  nameUpdate.setBounds(240,260,300,100);
		  nameUpdate.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  nameUpdate.setForeground(new Color(102, 53, 0));
		  adminPanel.add(nameUpdate);
		  
		  nameUpdateT.setBounds(295,300,130,20);
		  adminPanel.add(nameUpdateT);
		  
		  dateUpdate.setBounds(240,290,300,100);
		  dateUpdate.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  dateUpdate.setForeground(new Color(102, 53, 0));
		  adminPanel.add(dateUpdate);
		  
		  dateUpdateT.setBounds(295,330,130,20);
		  adminPanel.add(dateUpdateT);
		  
		  updateEmpl.setBounds(270,390,140,30);
		  updateEmpl.setBackground(new Color(102, 53, 0));
		  updateEmpl.setForeground(Color.white);
		  updateEmpl.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  //searchG.addActionListener(new clientInfo());
		  adminPanel.add(updateEmpl);
		  
		  viewEmpl.setBounds(270,470,140,30);
		  viewEmpl.setBackground(new Color(102, 53, 0));
		  viewEmpl.setForeground(Color.white);
		  viewEmpl.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  //searchG.addActionListener(new clientInfo());
		  adminPanel.add(viewEmpl);
		  
		  showAdmin.setBounds(450,300,380,200);
		  adminPanel.add(showAdmin);
		  
		  backAdmin.setBounds(400,520,120,30);
		  backAdmin.setBackground(new Color(102, 53, 0));
		  backAdmin.setForeground(Color.white);
		  backAdmin.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  //searchG.addActionListener(new clientInfo());
		  adminPanel.add(backAdmin);
		  
		  
	
	}
	
	public void setPanel(JPanel panel)
	{
	frame.setContentPane(panel);
	frame.validate();
	}
	
	 public void userListener(ActionListener user)
	    {
	        userButton.addActionListener(user);
	    }
	 
	 public void adminListener(ActionListener admin)
	    {
	        adminButton.addActionListener(admin);
	    }
	 
	 public void searchG(ActionListener searchGe)
	    {
	        searchG.addActionListener(searchGe);
	    }
	 
	 public void searchT(ActionListener searchTi)
	    {
	        searchT.addActionListener(searchTi);
	    }
	 
	 public void searchA(ActionListener searchAu)
	    {
	        searchA.addActionListener(searchAu);
	    }
	 
	 public void sellBook(ActionListener sell)
	    {
	        sellBook.addActionListener(sell);
	    }
	 
	 public void backU(ActionListener b)
	    {
	        backUser.addActionListener(b);
	    }
	 
	 public void backA(ActionListener b)
	    {
	        backAdmin.addActionListener(b);
	    }
	 
	 public void addBook(ActionListener addB)
	    {
	        addBook.addActionListener(addB);
	    }
	 
	 public void updateBookQ(ActionListener upB)
	    {
	        updateBookQ.addActionListener(upB);
	    }
	 
	 public void updateBookP(ActionListener upB)
	    {
	        updateBookP.addActionListener(upB);
	    }
	 
	 public void deleteBook(ActionListener dele)
	    {
	        deleteBook.addActionListener(dele);
	    }
	 
	 public void viewBooks(ActionListener view)
	    {
	        viewBooks.addActionListener(view);
	    }
	 
	 public void addEmpl(ActionListener addE)
	    {
	        addEmployee.addActionListener(addE);
	    }
	 
	 public void updateEmpl(ActionListener upE)
	    {
	        updateEmpl.addActionListener(upE);
	    }
	 
	 public void deleteEmpl(ActionListener delE)
	    {
	        deleteEmpl.addActionListener(delE);
	    }
	 
	 public void viewEmpl(ActionListener viewE)
	    {
	        viewEmpl.addActionListener(viewE);
	    }
	 
	 public void pdf(ActionListener pdff)
	    {
	        pdf.addActionListener(pdff);
	    }
	 
	 public void csv(ActionListener csvv)
	    {
	        csv.addActionListener(csvv);
	    }
	 
	 public void showUser(String result)
	 {
		 showUser.setText(result);
	 }
	 
	 
	 public String getGenre()
	 {
		 return genre.getText();
	 }
	 
	 public String getTitle()
	 {
		 return title.getText();
	 }
	 
	 public String getAuthor()
	 {
		 return author.getText();
	 }
	 
	 public String sellBook()
	 {
		 return sellTitle.getText();
	 }
	 
	 public void afisGenre(List<String> result)
	 {
		 showUser.setText("Search by genre:" +
                 Arrays.toString(result.toArray()));
	 }
	 
	 public void afisTitle(List<String> result)
	 {
		 showUser.setText("Search by Title:" +
                 Arrays.toString(result.toArray()));
	 }
	 
	 public void afisAuthor(List<String> result)
	 {
		 showUser.setText("Search by Author:" +
                 Arrays.toString(result.toArray()));
	 }
	 
	 public void afis(int x)
	 {
		 if(x==0)
			 showUser.setText("Book doesn't exist!");
		 else
			 showUser.setText("SOLD!");
	 }
	 
	 
	 public String getTitleA()
	 {
		 return titText.getText();
	 }
	 
	 public String getGenA()
	 {
		 return genText.getText();
	 }
	 
	 public String getAuthorA()
	 {
		 return autText.getText();
	 }
	 
	 public String getPriceA()
	 {
		 return prText.getText();
	 }
	 
	 public String getQuA()
	 {
		 return quText.getText();
	 }
	 
	 public void afisOK()
	 {
		 JOptionPane.showMessageDialog(null, "Done!", null, JOptionPane.INFORMATION_MESSAGE);
	 }
	 
	 public void initAdd() {
	        titText.setText("");
	        autText.setText("");
	        genText.setText("");
	        prText.setText("");
	        quText.setText("");
	    }
	 
	 public String getTitleUpdateQ()
	 {
		 return upTitleQ.getText();
	 }
	 
	 public String getQuUpdate()
	 {
		 return upPriceQ.getText();
	 }
	 
	 public void initUpdateQ() {
	        upTitleQ.setText("");
	        upPriceQ.setText("");
	    }
	 
	 public String getTitleUpdateP()
	 {
		 return upTitle.getText();
	 }
	 
	 public String getPriceUpdate()
	 {
		 return upPrice.getText();
	 }
	 
	 public void initUpdateP() {
	        upTitle.setText("");
	        upPrice.setText("");
	    }
	 
	 public String getTitleDel()
	 {
		 return deleteB.getText();
	 }
	 
	 public void initDel() {
		 deleteB.setText("");
	    }
	 
	 public void afisBooks(List<String> result)
	 {
		 showAdmin.setText("Books:\n" +
                 Arrays.toString(result.toArray()));
	 }
	 
	 public String getName()
	 {
		 return nameT.getText();
	 }
	 
	 public String getAge()
	 {
		 return ageT.getText();
	 }
	 
	 public String getDate()
	 {
		 return emplDateT.getText();
	 }
	 
	 public void initEmpl()
	 {
		 nameT.setText("");
		 ageT.setText("");
		 emplDateT.setText("");
	 }
	 
	 public String getNameDel()
	 {
		 return deleteNameT.getText();
	 }
	 
	 public void initEmplD()
	 {
		 deleteNameT.setText("");
	 }
	
	 public String getNameUpdate()
	 {
		 return nameUpdateT.getText();
	 }
	 
	 public String getDateUpdate()
	 {
		 return dateUpdateT.getText();
	 }
	 
	 public void initEmplUp()
	 {
		 dateUpdateT.setText("");
		 nameUpdateT.setText("");
	 }
	 
	 public void afisEmpl(List<String> result)
	 {
		 showAdmin.setText("Employees:\n" +
                 Arrays.toString(result.toArray()));
	 }
	 
}
