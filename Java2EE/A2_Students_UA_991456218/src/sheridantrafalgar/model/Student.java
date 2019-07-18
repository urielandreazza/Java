package sheridantrafalgar.model;

public class Student {

	//JAVA POJO (Plain Old Java Object)
	//Also, a JAVA Bean --> ALL PROPERTIES NEED TO BE LOWER CASE
	//So Tomcat J2EE defines a JAVA BEAN with LOWER CASE properties
	//by convention (Tomcat will interpret the class as a Bean)
	//Java BEAN getters are Camel case (first Letter is Capital) [Convention]
	
	
	//Properties of the Object
	private int studentid;
	private String firstname;
	private String lastname;
	private String city;
	private String province;
	private String postalcode;
	private double gpa;
	
	
	
	//Get and Setter Methods for the Properties
	public int getStudentid() {
		return studentid;
	}
	
	public void setStudentid(int studentId) {
		this.studentid = studentId;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getPostalcode() {
		return postalcode;
	}
	
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
		
	public double getGpa() {
		return gpa;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", firstname=" + firstname + ", lastname=" + lastname + ", city="
				+ city + ", gpa=" + gpa + "]";
	}
}
