// Interactions with some un-related classes
// - The use of interface 
//
// File name: TestInterface.java

import java.util.ArrayList;

// interface class(es)
interface Payable
{
	public final double PerSubject = 1000.00;
	public final double ProjectCost = 2000.00;
	public double payment();
}

interface Discountable
{
	public final double Discount = 20;
	public double discount();
}

// BasicInfo class
abstract class BasicInfo implements Payable
{
	protected final String name;
	protected final String address;
	
	public BasicInfo()
	{
		name = "";
		address = "";
	}
	
	public BasicInfo(String name, String address)
	{
		this.name = name;
		this.address = address;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	@Override
	public String toString()
	{
		return String.format("Name: %s%n" + "Address: %s", name, address);
	}
}

// Employee class
class Employee extends BasicInfo
{
	private static int NO = 0;
	protected final int id;
	protected double salary;
	
	public Employee()
	{
		++NO;
		id = NO;
	}
	
	public Employee(String name, String address, double salary)
	{
		super(name, address);
		++NO;
		id = NO;
		this.salary = salary;
	}
	
	public Employee(Employee e)
	{
		this(e.name, e.address, e.salary);
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public int getID()
	{
		return id;
	}
	
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	
	@Override
	public double payment()
	{
		return salary;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s%n" + "Salary: $ %.2f", super.toString(), salary);
	}
}

// EmploeePlus class
class EmployeePlus extends Employee
{
	private double bonus;
	
	public EmployeePlus()
	{
		
	}
	
	public EmployeePlus(String name, String address, double salary, double bonus)
	{
		super(name, address, salary);
		this.bonus = bonus;
	}
	
	public EmployeePlus(EmployeePlus ep)
	{
		this(ep.name, ep.address, ep.salary, ep.bonus);
	}
	
	public double getBonus()
	{
		return bonus;
	}
	
	public void setBonus(double bonus)
	{
		this.bonus = bonus;
	}
	
	@Override
	public double payment()
	{
		return super.payment() + bonus;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s%n" + "Bonus: $ %.2f", super.toString(), bonus);
	}
}

// Student class
class Student extends BasicInfo
{
	private static int NO = 2023000;
	private final int id;
	protected String subject1;
	protected String subject2;
	
	public Student() {
		NO++;
		id = NO;
	}
	
	public Student(String name, String address) {
		super(name, address);
		NO++;
		id = NO;
	}
	
	public Student(String name, String address, String subject1){
		super(name, address);
		NO++;
		id = NO;
		this.subject1 = subject1;
	}
	
	public Student(String name, String address, String subject1, String subject2){
		super(name, address);
		NO++;
		id = NO;
		this.subject1 = subject1;
		this.subject2 = subject2;
	}
	
	public Student(Student s){
		this(s.name, s.address, s.subject1, s.subject2);
	}
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSubject1() {
		return subject1;
	}
	
	public String getSubject2() {
		return subject2;
	}
	
	public void setInfo(String subject1) {
		this.subject1 = subject1;
	}
	
	public void setInfo(String subject1,  String subject2) {
		setInfo(subject1);
		this.subject2 = subject2;
	}
	
	@Override
	public double payment() {
		if (subject1 == null && subject2 == null)
			return 0;
		else if (subject2 == null)
			return PerSubject;
		else 
			return 2*PerSubject;
	}
	
	@Override
	public String toString() {
		if (subject1 == null && subject2 == null)
			return String.format("%s%n" + "Student id: %d", super.toString(), id);
		else if (subject2 == null)
			return String.format("%s%n" + "Student id: %d%n" + "Subject 1: %s", super.toString(), id, subject1);
		else
			return String.format("%s%n" + "Student id: %d%n" + "Subject 1: %s%n" + "Subject 2: %s",
												super.toString(), id, subject1, subject2);
	}
}



// FYStudent class
class FYStudent extends Student implements Discountable{
	private boolean project;
	
	public FYStudent() {
		
	}
	
	public FYStudent(String name, String address, boolean project) {
		super(name, address);
		this.project = project;
	}
	
	public FYStudent(String name, String address, String subject1, boolean project) {
		super(name, address, subject1);
		this.project = project;
	}
	
	public FYStudent(String name, String address, String subject1, String subject2, boolean project) {
		super(name, address, subject1, subject2);
		this.project = project;
	}
	
	public FYStudent(FYStudent fy) {
		this(fy.name, fy.address, fy.subject1, fy.subject2, fy.project);
	}
	
	public boolean getProject() {
		return project;
	}
	
	public void setProject(boolean project) {
		this.project = project;
	}
	
	@Override
	public double payment() {
		if (project == false)
			return super.payment();
		else
			return super.payment() + ProjectCost;
	}
	
	@Override
	public double discount()
	{
		return Discount;
	}
	
	@Override
	public String toString() {
		return String.format("%s%n" + "Project: %b", super.toString(), project);
	}
}

class TestInterface
{
	private static int i = 1;
	
	private static double getValue()
	{
		return Math.random() * 10000 + 1000;
	}
	
	private static String getAddress()
	{
		int k = (int) (Math.random() * 6);
		
		switch(k)
		{
			case 0: return "Clementi Campus";
			case 1: return "Bukit Timah";
			case 2: return "Ang Mo Kio";
			case 3: return "Jurong";
			case 4: return "Changi";
			default: return "Bedok";
		}
	}
	
	private static String getSubject()
	{
		int k = (int)(Math.random() * 4);
		
		switch(k)
		{
			case 0: return "CSIT121";
			case 1: return "CSIT128";
			case 2: return "CSIT111";
			default: return "CSIT115";
		}
	}
	
	private static void constructAList(ArrayList<Payable> alist)
	{
		Employee e0 = new Employee();
		Employee e1 = new Employee("Saud" + i++, getAddress(), getValue());
		Employee e2 = new Employee(e1);
		e2.setSalary(getValue());
		
		EmployeePlus ep0 = new EmployeePlus();
		EmployeePlus ep2 = new EmployeePlus("Saud" + i++, getAddress(), getValue(), getValue());
		EmployeePlus ep3 = new EmployeePlus(ep2);
		ep3.setSalary(getValue());
		ep3.setBonus(getValue());
		
		Student s0 = new Student();
		Student s1 = new Student("Lim" + i++, getAddress(), getSubject());
		Student s2 = new Student("Lim" + i++, getAddress(), getSubject(), getSubject());
		Student s3 = new Student(s2);
		
		FYStudent fy0 = new FYStudent();
		FYStudent fy1 = new FYStudent("Lim" + i++, getAddress(), true);
		FYStudent fy2 = new FYStudent("Lim" + i++, getAddress(), getSubject(), true);
		FYStudent fy3 = new FYStudent("Lim" + i++, getAddress(), getSubject(), getSubject(), true);
		FYStudent fy4 = new FYStudent(fy3);
		fy4.setProject(false);
		
		alist.add(e0);
		alist.add(e1);
		alist.add(e2);
		alist.add(ep0);
		alist.add(ep2);
		alist.add(ep3);
		
		alist.add(s0);
		alist.add(s1);
		alist.add(s2);
		alist.add(s3);
		
		alist.add(fy0);
		alist.add(fy1);
		alist.add(fy2);
		alist.add(fy3);
		alist.add(fy4);
	}
	
	private static void displayAList(ArrayList<Payable> alist)
	{
		for (Payable p : alist)
		{
			System.out.println(p);
			
			System.out.printf("Total Payment: $ %.2f%n", p.payment());
			
			double discount = 0;
			if (p instanceof FYStudent)
			{
					FYStudent fy = (FYStudent)(p);
					
					// Discount is given to students who take 2 subjects and a project
					
					if (fy.getSubject1() != null && fy.getSubject2() != null && fy.getProject() == true)
					{
						discount = fy.payment() * fy.discount() / 100.0;
						System.out.printf("Discount: $ %.2f%n", discount);
						System.out.printf("Total payment(After discount): $ %.2f%n",
													fy.payment() - discount);
					}
			}
			
			System.out.println("----------------------------------------------");
		}
	}
	
	public static void main (String [ ] args)
	{
		ArrayList<Payable> alist = new ArrayList<Payable>();
		
		constructAList(alist);
		displayAList(alist);
	}
}