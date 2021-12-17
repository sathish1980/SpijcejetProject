package weekend.Spicejet;



public class firsttestcase 
{

public void div_1()
{
System.out.println("division");
}

	public firsttestcase()
	{
		System.out.println("this is constructor");
	}

	/*public  Firstprogram()
	{
		System.out.println("constructor");
	}
	
	public  Firstprogram(int a, int b)
	{
		System.out.println("constructor: " + a+b);
	}*/

	public void add()
	{
		int a=50;
		int b=20;
		int c;
		c=a+b;
		System.out.println(c);
		
	}
	
	public void sub(int a, int b)
	{
		
		int c;
		int d=mul(a,b);
		c=a-b+d;
		System.out.println(c);
		
	}
	
	public int mul(int a, int b)
	{

		int c;
		c=a*b;
		//System.out.println(c);
		return c;
		
	}
	
	//method without parameter /arguments
	//method with parameter /arguments
	//method without return type
	//method with return type.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("sathish");
		System.out.println("kumar");
		System.out.print("R");
		System.out.println(10+20);
//		Firstprogram obj= new Firstprogram();
	//	obj.add();
		//obj.sub(10, 2);
	}
}
