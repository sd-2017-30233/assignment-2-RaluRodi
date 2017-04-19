package bookstore;

public class Book implements java.io.Serializable{

	
	private static final long serialVersionUID = 1L;
	private String title;
	private String author;
	private String genre;
	private int quantity;
	private double price;
	
	public Book(String title, String author, String genre,int quantity, double price)
	{
		this.title=title;
		this.author=author;
		this.genre=genre;
		this.quantity=quantity;
		this.price=price;
	}
	
	public Book()
	{
		
	}
	
	public void setTitle(String title)
	{
		this.title=title;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public void setAuthor(String author)
	{
		this.author=author;
	}
	
	public String getAuthor()
	{
		return this.author;
	}
	
	public void setGenre(String genre)
	{
		this.genre=genre;
	}
	
	public String getGenre()
	{
		return this.genre;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity=quantity;
	}
	
	public int getQuantity()
	{
		return this.quantity;
	}
	
	public void setPrice(double price)
	{
		this.price=price;
	}
	
	public double getPrice()
	{
		return this.price;
	}
}
