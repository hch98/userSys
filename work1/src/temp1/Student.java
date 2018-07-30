package temp1;

public class Student extends Person{

	public Student(String _name)
	{
		super(_name);
	}
	public void doSomething(Action ac,Address addr)
	{
		System.out.print(this.name);
		ac.act(addr);
	}
}

