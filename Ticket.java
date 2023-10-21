public class Ticket {
    private int ticketID = 100;
    private double price = 15.00; //ticket price
    private int ticketNum = 0; //ticket number
    private int seatNo; //seat number
    private char seatRow; //seat row
    private String[][] stime = new String[1][2]; //showtime
    private Movie movie; //movie selected
    
    public Ticket(int seatNo, char seatRow, Movie movie, String[][] stime)
    {
        this.seatNo = seatNo;
        this.seatRow = seatRow;
        this.movie = movie;
        this.stime = stime;
        ticketID++; ticketNum++;
    }
    
    public Ticket()
    {
        
    }
    
    public int getTicket()
    {
        return ticketID;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public String[][] getTime()
    {
        return stime;
    }
    
    public int getTicketNum()
    {
        return ticketNum;
    }
    
    public int getSeatNo()
    {
        return seatNo;
    }
    
    public char getSeatRow()
    {
        return seatRow;
    }
    
    public void setTicketID(int t)
    {
        ticketID = t;
    }
    
    public void setPrice(double p)
    {
        price = p;
    }
    
    
    public void setSeatNo(int s)
    {
        seatNo = s;
    }
    
    public void setSeatRow(char r)
    {
        seatRow = r;
    }
}
