package sheridantrafalgar.model;

public class Pojo {

	//JAVA POJO (Plain Old Java Object)
	//Also, a JAVA Bean --> ALL PROPERTIES NEED TO BE LOWER CASE
	//So Tomcat J2EE defines a JAVA BEAN with LOWER CASE properties
	//by convention (Tomcat will interpret the class as a Bean)
	//Java BEAN getters are Camel case (first Letter is Capital) [Convention]
	
	
	//Properties of the Object
	private int carid;
	private String make;
	private String model;
	private String enginetype;
	private int gallonthousandmilesgas;
	private String aiassistant;
	
	
	//Get and Setter Methods for the Properties
	public int getCarid() {
		return carid;
	}
	
	public void setCarid(int carId) {
		this.carid = carId;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getenginetype() {
		return enginetype;
	}
	
	public void setEnginetype(String enginetype) {
		this.enginetype = enginetype;
	}
	
	public int getGallonthousandmilesgas() {
		return gallonthousandmilesgas;
	}
	
	public void setGallonthousandmilesgas(int gallonthousandmilesgas) {
		this.gallonthousandmilesgas = gallonthousandmilesgas;
	}
	
	public String getaiassistant() {
		return aiassistant;
	}
	
	public void setaiassistant(String aiassistant) {
		this.aiassistant = aiassistant;
	}


	@Override
	public String toString() {
		return "Car [carid=" + carid + ", make=" + make+ ", model=" + model + ", enginetype="
				+ enginetype + ", gallonthousandmilesgas=" + gallonthousandmilesgas +"aiassistant="+aiassistant +"]";
	}
}
