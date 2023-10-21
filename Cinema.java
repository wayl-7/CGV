public class Cinema
{
    private String cinemaName;
    private String address;
    private String seatID;
    private boolean seatStatus;

    public Cinema(String cinemaName, String address) {
        this.cinemaName = cinemaName;
        this.address = address;
    }

    public String getCinemaName() {return cinemaName;}
    public String getAddress() {return address;}
    public String getSeatID() {return seatID;}
    public boolean isSeatStatus() {return seatStatus;}

    public void setCinemaName(String cinemaName) {this.cinemaName = cinemaName;}
    public void setAddress(String address) {this.address = address;}
    public void setSeatID(String seatID) {this.seatID = seatID;}
    public void setSeatStatus(boolean seatStatus) {this.seatStatus = seatStatus;}

    public void displaySeat()
    {
        System.out.println("\n\n\t                SCREEN                    \n");
        System.out.println("\tA  1  2  3  4  5  6  7  8  9  10  11  12\n");
        System.out.println("\tB  1  2  3  4  5  6  7  8  9  10  11  12\n");
        System.out.println("\tC  1  2  3  4  5  6  7  8  9  10  11  12\n");
        System.out.println("\tD  1  2  3  4  5  6  7  8  9  10  11  12\n");
        System.out.println("\tE  1  2  3  4  5  6  7  8  9  10  11  12\n");
        System.out.println("\tF  1  2  3  4  5  6  7  8  9  10  11  12\n");
        System.out.println("\tG  1  2  3  4  5  6  7  8  9  10  11  12\n");
        System.out.println("\tH  1  2  3  4  5  6  7  8  9  10  11  12\n");
        System.out.println("\tI  1  2  3  4  5  6  7  8  9  10  11  12\n");
        System.out.println("\tJ  1  2  3  4  5  6  7  8  9  10  11  12\n");
        //System.out.println("        Enter your seat number:           ");
    }
}
