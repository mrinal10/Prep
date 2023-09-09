import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Employee{
    String name;
    String emailId;

    Employee(String n, String email) {
        name = n;
        emailId = email;
    }
}

public class Streammms {

    public static void main(String[] args) {
        
        List<Employee> employees = new ArrayList<>(); 
        employees.add(new Employee("A", "A@google.com")); 
        employees.add(new Employee("b", "b@gmail.com"));
        employees.add(new Employee("C", "C@mail.com")); 
        employees.add(new Employee("D", "D@yahoo.com"));

        Set<String> domains = new HashSet<>();

        employees.stream().forEach(employee -> {
            String empEmail = employee.emailId;
            String domain = empEmail.split("@")[1];
            domains.add(domain);
        });

        List<Employee> filteredEmployeeList 
        = employees.stream().filter(employee -> {
            String empEmail = employee.emailId;
            String domain = empEmail.split("@")[1];
            return domain.equals("gmail.com");
        }).collect(Collectors.toList());

        System.out.println(filteredEmployeeList.size());
        System.out.println(domains.size());
    }
    
}
