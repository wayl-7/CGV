public class Admin extends Person
{
    private String password;
    private String username;
    private String email;

    public Admin(String n, String ph, String p, String u, String e)
    {
        super(n,ph);
        this.password=p;
        this.username=u;
        this.email=e;
    }

    public String getPassword() {return password;}
    public String getUsername() {return username;}
    public void setPassword(String password) {this.password = password;}
    public void setUsername(String username) {this.username = username;}

    public void displayAcc()
    {
        System.out.println("\n\n\t        * * * Admin Account * * *       \n");
        System.out.println("\tUsername        : " + username);
        System.out.println("\tPassword        : " + password);
        System.out.println("\tEmail Address   : " + email);
    }
}
