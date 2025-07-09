import java.util.*;

class Employee {
    private int id;
    private String name;
    private String department;
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDept() {
        return department;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDept(String department) {
        this.department = department;
    }
    public String details() {
        return "ID: " + id + " Name: " + name + " Dept: " + department;
    }
}

public class EmployeeCRUD {
    private ArrayList<Employee> employees = new ArrayList<>();
    //Create
    public void createEmployee(int id, String name, String department) {
        employees.add(new Employee(id, name, department));
        System.out.println("Employee " + id + " added");
    }
    //Read
    public void readEmployee() {
        System.out.println("Reading employees...");
        if(employees.isEmpty()) {
            System.out.println("No employees");
            return;
        }
        for(Employee e : employees) {
            System.out.println(e.details());
        }
    }
    //Update
    public void updateEmployee(int id, String name, String department) {
        for(Employee e : employees) {
            if(e.getId() == id) {
                e.setName(name);
                e.setDept(department);
                System.out.println("Employee " + id + " updated");
                return;
            }
        }
        System.out.println("Employee not found");
    }
    //Delete
    public void deleteEmployee(int id) {
        for(Employee e : employees) {
            if(e.getId() == id) {
                employees.remove(e);
                System.out.println("Employee " + id + " deleted");
                return;
            }
        }
        System.out.println("Employee not found");
    }
    public static void main(String args[]) {
        EmployeeCRUD employee = new EmployeeCRUD();
        employee.createEmployee(1, "Jeshma Ullas", "Software Development");
        employee.createEmployee(2, "ABC", "AI");
        employee.readEmployee();
        employee.updateEmployee(2, "DEF", "Data");
        employee.readEmployee();
        employee.deleteEmployee(2);
        employee.readEmployee();
    }
}


