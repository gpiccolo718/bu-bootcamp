public class Contact {
    
    // FIELDS
    private String name;
    private String phone;

    // CONSTRUCTOR 
    public Contact(String name, String phone) { 
        this.name   = name;    
        this.phone = phone; 
    }

    // GETTERS 
    public String  getName()   { return name; } 
    public String  getPhone() { return phone; }  

    // TOSTRING
    @Override 
    public String toString() { 
        return name + " | " + phone; 
    } 
}
