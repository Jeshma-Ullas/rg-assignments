class Details {
    private String name;
    private String email;
    public String getName() { 
        return name; 
    }
    public String getEmail() { 
        return email;
    }
    public void setName(String name) { 
        this.name = name; 
    }
    public void setEmail(String email) { 
        this.email = email; 
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        Details d = new Details();
        d.setName("Jeshma Ullas");
        d.setEmail("jeshmarajiullas@gmail.com");
        System.out.println("Name: " + d.getName());
        System.out.println("Email: " + d.getEmail());
    }
}