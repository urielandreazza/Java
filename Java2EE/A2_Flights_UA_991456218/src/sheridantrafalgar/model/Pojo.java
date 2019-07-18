package sheridantrafalgar.model;

public class Pojo {

	//JAVA POJO (Plain Old Java Object)
	//Also, a JAVA Bean --> ALL PROPERTIES NEED TO BE LOWER CASE
	//So Tomcat J2EE defines a JAVA BEAN with LOWER CASE properties
	//by convention (Tomcat will interpret the class as a Bean)
	//Java BEAN getters are Camel case (first Letter is Capital) [Convention]
	
	
	//Properties of the Object
	private int flightid;
	private String flightno;
	private String departingcity;
	private String destination;
	private int distanceinkm;
	private String dailyflights;
	
	
	//Get and Setter Methods for the Properties
	public int getFlightid() {
		return flightid;
	}
	
	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}
	
	public String getFlightno() {
		return flightno;
	}
	
	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}
	
	public String getDepartingcity() {
		return departingcity;
	}
	
	public void setDepartingcity(String departingcity) {
		this.departingcity = departingcity;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public int getDistanceinkm() {
		return distanceinkm;
	}
	
	public void setDistanceinkm(int distanceinkm) {
		this.distanceinkm = distanceinkm;
	}
	
	public String getDailyflights() {
		return dailyflights;
	}
	
	public void setDailyflights(String dailyflights) {
		this.dailyflights = dailyflights;
	}
	
	@Override
	public String toString() {
		return "Flight [flightid=" + flightid + ", FlightNO=" + flightno+ ", DepartingCity=" + departingcity+ ", Destination="
				+ destination + ", distanceInKm=" + distanceinkm +", dailyFlights="+dailyflights +"]";
	}
}
