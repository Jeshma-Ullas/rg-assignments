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
}

public class EmployeeJDBC {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/my-db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Create
    public void createEmployee(Employee emp) {
        String query = "INSERT INTO Employee (id, name, department) VALUES (?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement stmt = con.prepareStatement(query)) {
                stmt.setInt(1, emp.getId());
                stmt.setString(2, emp.getName());
                stmt.setString(3, emp.getDept());
                int rows = stmt.executeUpdate();
                System.out.println("Employee inserted: " + rows + " row(s)");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }    

    // Read
    public void readEmployees() {
        String query = "SELECT * FROM Employee";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   " Name: " + rs.getString("name") +
                                   " Dept: " + rs.getString("department"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update
    public void updateEmployee(int id, String name, String department) {
        String query = "UPDATE Employee SET name = ?, department = ? WHERE id = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, department);
            stmt.setInt(3, id);
            int rows = stmt.executeUpdate();
            System.out.println("Employee updated: " + rows + " row(s)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Delete
    public void deleteEmployee(int id) {
        String query = "DELETE FROM Employee WHERE id = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            System.out.println("Employee deleted: " + rows + " row(s)");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        EmployeeJDBC ejdbc = new EmployeeJDBC();
        Employee e1 = new Employee(1, "Jeshma", "Software");
        Employee e2 = new Employee(2, "ABC", "AI");
        ejdbc.createEmployee(e1);
        ejdbc.createEmployee(e2);
        ejdbc.readEmployees();
        ejdbc.updateEmployee(2, "DEF", "Data");
        ejdbc.readEmployees();
        ejdbc.deleteEmployee(1);
        ejdbc.readEmployees();
    }
}
