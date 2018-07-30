package temp1;

public class StudentInf {
	private int id;
	private String name;
	private String depart;
	public int getId()
	{
		return id;
	}
	public void setId(int _id)
	{
		id=_id;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String _name)
	{
		name=_name;
	}
	public String getDepart()
	{
		return depart;
	}
	public void setDepart(String _depart)
	{
		depart=_depart;
	}
	
	public StudentInf()
	{
		super();
	}
	public StudentInf(int _id,String _name,String _depart)
	{
		super();
		id=_id;
		name=_name;
		depart=_depart;
	}
	
	
}
