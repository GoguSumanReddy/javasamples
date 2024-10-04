package Tasks;

public class Utility {
	
	static Boolean startWith(String str) {
		return str.startsWith("New");
	}
	
	static Boolean getAgeGreaterThan24(Employee e) {
		return e.getAge()>24;
	}
	
	static Boolean getFemale(Employee e) {
		return e.getGender().equalsIgnoreCase("F");
	}
	
	static Boolean getItEmployee(Employee e) {
		return e.getDeptName().equalsIgnoreCase("IT");
	}
	
	static Boolean getMale(Employee e) {
		return e.getGender().equalsIgnoreCase("M");
	}
	
	static Boolean joined2013(Employee e) {
		return e.getYearOfJoining()==2013;
	}
	
	Boolean endsWith(String str) {
		return str.endsWith("a");
	}
	
	String upperCase(String str) {
		return str.toUpperCase();
	}
	
	Integer addition(int a, int b) {
		return a+b;
	}

}

class City{
	String name;
	
	public City(String name) {
		this.name=name;
	}
}
