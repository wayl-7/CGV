public class Person {
    private String name;
    private String phone;
    
    Person(String name, String phone)
    {
        this.name = name;
        this.phone = phone;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public void setName(String n)
    {
        name = n;
    }
    
    public void setPhone(String p)
    {
        phone = p;
    }
}
