package bookstore;


public class Employee implements java.io.Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String empl_date;
	
	public Employee(String name, int age, String empl_date)
	{
		this.name=name;
		this.age=age;
		this.empl_date=empl_date;
	}
	
	public Employee()
	{
		
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setAge(int age)
	{
		this.age=age;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public void setDate(String empl_date)
	{
		this.empl_date=empl_date;
	}
	
	public String getDate()
	{
		return this.empl_date;
	}

}
