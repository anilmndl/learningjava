
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*
 * A. Create Employee class with the following fields: id, name, salary, department
B. Create a stream of employee objects
C. print employee of particular department
D. filter employee whose salary greater than 5000$
E. find the average salary of employee
F. sort the employees based on name
G. sort the employees on department  and then sort by their name.

 */

/**
 * @Anil Mandal
 */
public class StreamHO {
    public static void main(String[] args) {
        
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Ram Bilas", 1000.5, "hawaldar"));
        employees.add(new Employee(2, "Saab se bada don", 800000.0, "Mumbai ka bhai"));
        employees.add(new Employee(3, "dhanya bhai", 2000.0, "Mumbai ka bhai"));
        employees.add(new Employee(4, "chota chetan", 6000000.0, "Mumbai ka bhai"));
        employees.add(new Employee(5, "Alpha", 3000.0, "science"));
        employees.add(new Employee(6, "Beta", 7000.0, "science"));
        
        Stream empStream;
        
        System.out.println("--------------**All Employees**-----------");
        System.out.println(employees);
        
        System.out.println("\n\n--------------**Employees of Particular Department**-----------");
        empStream = employees.stream();
        Predicate<Employee> filterByDept = (x)->x.department == "Mumbai ka bhai";
        empStream.filter(filterByDept).forEach((x) -> System.out.println(x));
       
        System.out.println("\n\n--------------**Employees with salary > 5000**-----------");
        empStream = employees.stream();
        Predicate<Employee> filterSalary = (x)->x.salary > 5000.0;
        empStream.filter(filterSalary).forEach((x) -> System.out.println(x));
        
        
        System.out.println("\n\n--------------**Average salary of employees**-----------");
        empStream = employees.stream();
        ToDoubleFunction<Employee> getDouble = x -> x.salary; 
        double average = empStream.mapToDouble(getDouble).average().getAsDouble();
        System.out.println("The average salary is: $" + average);
        
        
        System.out.println("\n\n--------------**Sort Employeed Based Name**-----------");
        Comparator<Employee> nameComparer = (e1, e2)-> e1.name.compareTo(e2.name);
        empStream = employees.stream();
        System.out.println(
                empStream
                .sorted(nameComparer)
                .collect(Collectors.toList())
        );
        
        System.out.println("\n\n--------------**Sort Employeed Based on Department then by Name**-----------");
        Comparator<Employee> deptComparer = (e1, e2)-> e1.department.compareTo(e2.department);
        empStream = employees.stream();
        System.out.println(
                empStream
                .sorted(deptComparer.thenComparing(nameComparer))
                .collect(Collectors.toList())
        );   
    }
}

class Employee{
    Integer id;
    String name;
    Double salary;
    String department;
    
    Employee(Integer id, String name, Double salary, String department){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
    
    @Override
    public String toString(){
        return "{id: " + this.id + " | name: " + this.name + " | salary: " + this.salary + " | department: " + this.department + "}";
    }
    
    
}
