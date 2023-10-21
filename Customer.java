import java.util.ArrayList;

public class Customer extends Person {
    private String email;

    public Customer(String name, String phone, String email)
    {
        super(name,phone);
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }


    public void setEmail(String e)
    {
        this.email = e;
    }

    public void displayAcc()
    {
        System.out.println("        * * * Customer Account * * *       \n");
        //System.out.println("Name                     : " + name);
        //System.out.println("Phone number             : " + phone number);
        System.out.println("Email address            : " + email);

    }
}
