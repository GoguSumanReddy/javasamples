package Tasks;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamOps {
	public static void main(String args[]) {

		List<Employee> empList = List.of(
		new Employee(1, "Suman", 28, 13673, "F", "HR", "Hyderabad", 2020),
		new Employee(2, "Jagan", 29, 12056, "F", "HR", "Hyderabad", 2015),
		new Employee(3, "Ram", 30, 11789, "M", "HR", "Chennai", 2014),
		new Employee(4, "Shrija", 32, 12335, "F", "HR", "Chennai", 2013),
		new Employee(5, "Narendra", 22, 12450, "F", "IT", "Noida", 2013),
		new Employee(6, "Vamshi", 27, 140, "M", "IT", "Gurugram", 2017),
		new Employee(7, "Jwala", 26, 13900, "F", "IT", "Pune", 2016),
		new Employee(8, "Tirtha", 23, 33145, "M", "IT", "Trivandam", 2015),
		new Employee(9, "Geshvi", 25, 46160, "M", "IT", "Hyderabad", 2010),		
		new Employee(10, "Ravi", 20, 20160, "M", "IT", "Noida", 2011)
		);

		// 1. employees salary greater than 20000
		System.out.println(empList.stream().filter(e -> (e.getSalary() > 20000)).count());

		// 2. group employees by department
		Map<String, List<Employee>> deptWise = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName));
		System.out.println("DeptWise :: \n" + deptWise);

		// 3. group employees by department and count in each department
		Map<String, Long> deptWiseCount = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
		System.out.println("DeptWiseCount :: \n" + deptWiseCount);

		// 4. group employees by department and then gender in each department
		Map<String, Map<String, List<Employee>>> deptWiseGenderCount = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.groupingBy(Employee::getGender)));
		System.out.println("DeptWiseGenderCount :: \n" + deptWiseGenderCount);

		// 5. group employees by department and count Male and Female in each department
		Map<String, Map<String, Long>> deptWiseGnderCount = empList.stream().collect(Collectors
				.groupingBy(Employee::getDeptName, Collectors.groupingBy(Employee::getGender, Collectors.counting())));
		System.out.println("Employees deptWiseGnderCount :: \n" + deptWiseGnderCount);

		// 6. Min age employee
		Employee e = empList.stream().min((x, y) -> x.getAge() - y.getAge()).get();
		System.out.println("Min age empoyee :: \n" + e);

		// 7. max age employee in each department
		Map<String, Optional<Employee>> maxAgeEmpInEachDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,
				Collectors.maxBy(Comparator.comparingInt(Employee::getAge))));
		System.out.println("max age employee in each department :: \n" + maxAgeEmpInEachDept);
		
		// 8. average of employee salary in each department
		Map<String, Double> deptWiseAverageSalary = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("DeptWiseAverageSalary :: \n" + deptWiseAverageSalary);
		
		// 9. employees joined in 2023
		System.out.println("DeptWiseAverageSalary ::");
	    empList.stream().filter(emp-> (emp.getYearOfJoining() == 2013) ).forEach(System.out::println);
	    //or
	    empList.stream().filter(Utility::joined2013).forEach(System.out::println);
	    
	    
	    //10. sort employees by age within department
	    Map<String, List<Employee>> deptWiseSortedByAge = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,
	    		Collectors.collectingAndThen(Collectors.toList(), 
	    				list->list.stream().sorted(Comparator.comparingInt(Employee::getAge)).collect(Collectors.toList()))
	    		));
	    System.out.println("deptWiseSortedByAge :: \n" + deptWiseSortedByAge);
	    
	    //11. second oldest employee
	    System.out.println("second oldest employee:");
	    empList.stream().sorted(Comparator.comparingInt(Employee::getAge)).skip(empList.size()-2).limit(1).forEach(System.out::println);
	    
	    //12. second youngest employee
	    System.out.println("second youngest employee:");
	    empList.stream().sorted(Comparator.comparingInt(Employee::getAge)).limit(2).skip(1).forEach(System.out::println);
	    
	    //13. find employees whose age is greater than 24 and Male 
	    System.out.println("find empoyees whose age is greater than 24 and Male :");
	    empList.stream().filter(Utility::getAgeGreaterThan24).filter(Utility::getMale).forEach(System.out::println);
	    
	    //14. find average age of Female employees
	    IntSummaryStatistics stats=empList.stream().filter(Utility::getFemale).collect(Collectors.summarizingInt(Employee::getAge));
	    System.out.println("average age of Female employees: "+stats.getAverage());
	    
	    //15.find youngest female employee
	    Optional<Employee> youngestFemale=empList.stream().filter(Utility::getFemale).sorted(Comparator.comparing(Employee::getAge)).findFirst();
	    if(youngestFemale.isPresent()) {
	    	System.out.println("youngestFemale: "+youngestFemale);
	    }
	    
	    //16. count IT employees
	    System.out.println(empList.stream().filter(Utility::getItEmployee).count());
	    
	    
	    

	}

}
