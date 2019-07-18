package sheridantrafalgar.model;

public class Pojo {

	//JAVA POJO (Plain Old Java Object)
	//Also, a JAVA Bean --> ALL PROPERTIES NEED TO BE LOWER CASE
	//So Tomcat J2EE defines a JAVA BEAN with LOWER CASE properties
	//by convention (Tomcat will interpret the class as a Bean)
	//Java BEAN getters are Camel case (first Letter is Capital) [Convention]
	
	
	//Properties of the Object
	private int rocketid;
	private String name;
	private String launchweight;
	private int heightmetres;
	
	
	//Get and Setter Methods for the Properties
	public int getRocketid() {
		return rocketid;
	}
	
	public void setRocketid(int rocketid) {
		this.rocketid = rocketid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLaunchweight() {
		return launchweight;
	}
	
	public void setLaunchweight(String launchweight) {
		this.launchweight = launchweight;
	}
	public int getHeightmetres() {
		return heightmetres;
	}
	
	public void setHeightmetres(int heightmetres) {
		this.heightmetres = heightmetres;
	}
		
	@Override
	public String toString() {
		return "Rocket [rocketID=" + rocketid + ", Name=" + name + ", heighmeters=" + heightmetres+ ", launchweight="
				+ launchweight +"]";
	}
}
