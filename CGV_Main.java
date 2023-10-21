import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class CGV_Main {

    public static void Menu() {
		Scanner keyboard = new Scanner(System.in);
		boolean wrong = false; //flag variable to check validity of input
		int c;

		do {

			wrong = false;
			System.out.println("\n\n\tWelcome to CGV Movie Ticketing System\n");
			System.out.println("\tSelect an action\n");
			System.out.println("\t[1] View Upcoming Movie");
			System.out.println("\t[2] Book Ticket");
			System.out.println("\t[3] Add Movie");
			System.out.println("\t[4] View Admin Account");
			System.out.println("\t[5] Exit\n");
			System.out.print("\tEnter your choice here: ");
			c = keyboard.nextInt();

			if(c<=5 && c>=1)
			{
				switch(c)
				{
					case 1: displayUpcomingMovie(); break;
					case 2: displayMovieForBooking(); break;
					case 3: addUpcomingMovie(); break;
					case 4: displayAdminAcc(); break; //Display admin account details
					case 5: clearScreen(); System.out.println("\n\n\tThank you! Bye!\n\n\tHave a nice day!\n\n"); System.exit(0);
			 	}
			}
			 else
			 {
				 System.out.print("\n\n\tPlease enter a valid integer number, from 1 to 5 ONLY!");
				 wrong = true;
			 }

			 //Pause the alert message for few seconds
			 try
			 {
				 Thread.sleep(2000);
			 }
			 catch(InterruptedException ex)
			 {
				 Thread.currentThread().interrupt();
			 }
			 clearScreen();

		 } while(wrong);
    }

    public static void displayUpcomingMovie() {
		clearScreen();

        int i = 0;
        boolean back = false;
        Scanner input = new Scanner(System.in);

        System.out.println("\n\n");
        System.out.printf("%10s | %-30s | %-30s | %10s\n", "No", "Title", "Length (in minutes)", "Release Date");
        System.out.println();

        for (Movie u : CGVsystem.upcomingMovie)
        {
            System.out.printf("%10s | %-30s | %-30s | %10s\n", ++i, u.getTitle(), u.getLength(), u.getReleaseDate());
        }

        do {
            back = false;

            System.out.print("\n\tEnter 0 to go back to main menu : ");
            int choice = input.nextInt();

            if(choice != 0)
            {
                System.out.println("\tPlease enter a valid integer number!");
                back = true;
            }
        } while(back);

        clearScreen();
        Menu();
    }

    public static void displayMovieForBooking() {

		clearScreen();

        Scanner input = new Scanner(System.in);
        int choice;
        int movieChoice;
        Movie movieBooked = new Movie();

        boolean flag = false; //flag variable
        int i = 0; //counter variable

        System.out.println("\n");
        System.out.printf("%10s | %-30s | %10s\n", "No.", "Title", "Length (Minutes)");
        System.out.println();

        for(Movie m : CGVsystem.movie)
        {
            System.out.printf("%10s | %-30s | %10s\n", ++i, m.getTitle(), m.getLength());
        }

        do
        {
			if(flag)
				input.nextLine();

            flag = false;
            System.out.print("\n\n\tDo you want to book a ticket?\n\tEnter 1 for YES or 0 for NO: ");
            try {
                choice = input.nextInt();

                if(choice < 0 || choice > 1) {
                    flag = true;
                }
                else if (choice == 0) {
					clearScreen();
                    Menu();
                }
                else {
					boolean invalid = true;

					while(invalid) {
						System.out.println("\n\tWhich movie do you want to choose? ");
                    	System.out.print("\tEnter the integer value of the movie: ");
                    	movieChoice = input.nextInt();

                    	if(movieChoice > CGVsystem.movie.size()|| movieChoice < 0)
                    	{
							System.out.print("\n\n\tEnter the VALID integer value! ");
							invalid = true;
						}
						else
						{
							invalid = false;
							switch(movieChoice)
							{
								case 1: movieBooked = CGVsystem.movie.get(0); break;
							    case 2: movieBooked = CGVsystem.movie.get(1); break;
							    case 3: movieBooked = CGVsystem.movie.get(2); break;
							}
							bookTicket(movieBooked);
						}
					}
                }
            }
            catch(InputMismatchException e) {
                System.out.print("\n\tPlease enter a valid integer value!");
                flag = true;
                pressAnyKeyToContinue();
            }
        } while(flag);
    }

    public static void bookTicket(Movie m) {
        clearScreen();
        boolean flag = false; //A boolean variable to check validity of the input

        Scanner input = new Scanner(System.in);
        String name = "", phone = "", email = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        int selectedShowtime;
        String[][] bookedShowtime = new String [1][2];

        //Display showtime
        System.out.println("\n");
        m.displayShowtime();

        //Ask user to choose showtime
        do {
			if(flag)
				input.nextLine();

            flag = false;
            System.out.print("\tEnter your choice of showtime (integer number only) : ");
            try {
                selectedShowtime = input.nextInt();
                if(selectedShowtime < 1 || selectedShowtime > 4)
                {
					System.out.println("\n\tPlease enter a valid integer value! (1 - 4 ONLY)");
					flag = true;
				}
				else
				{
					switch(selectedShowtime) {
						case 1: bookedShowtime = m.getShowtime(selectedShowtime); break;
                    	case 2: bookedShowtime = m.getShowtime(selectedShowtime); break;
                    	case 3: bookedShowtime = m.getShowtime(selectedShowtime); break;
                    	case 4: bookedShowtime = m.getShowtime(selectedShowtime); break;
                	}
				}
            }
            catch(InputMismatchException e){
                System.out.println("\tPlease enter an integer value ONLY!");
                flag = true;
                pressAnyKeyToContinue();
            }
        } while(flag);

        //Display seat for user to choose
        clearScreen();
        int sNo = 0; char sRow = '\0';
        CGVsystem.cinema.displaySeat();
        do {
            if(flag)
                input.nextLine();

            flag = false;
            System.out.println("\t= = = Choose Your Seat = = =");
            System.out.print("\tSeat Row: ");
            try {
                 sRow = input.next().charAt(0);
            }
            catch(InputMismatchException e) {
                System.out.println("\tPlease enter a character!");
                flag = true;
                pressAnyKeyToContinue();
            }
            System.out.print("\tSeat Number: ");
            try {
                 sNo = input.nextInt();
                 if(sNo <1 || sNo >12)
                 {
					 flag = true;
				 }
            }
            catch(InputMismatchException e) {
                System.out.println("\tPlease enter a valid integer value!");
                flag = true;
            }
            pressAnyKeyToContinue();
        } while(flag);

        //Ask user to enter their personal details
        clearScreen();
        do {
            if(flag)
                input.nextLine();

            flag = false;

            System.out.println("\n\n\t= = = Enter your booking details = = =\n");
            try {
                System.out.print("\tEnter your name: ");
                name = input.next();
                System.out.print("\tEnter your phone number: ");
                phone = input.next();
                System.out.print("\tEnter your email address: ");
                email = input.next();
                System.out.println();
            }
            catch(InputMismatchException e) {
                System.out.println("\tPlease enter a string value!");
                flag = true;
                pressAnyKeyToContinue();
            }

            clearScreen();

        } while(flag);

        //Create a customer
        Customer newCustomer = new Customer(name, phone, email);
        CGVsystem.customer.add(newCustomer);

        //Create a ticket
        Ticket bookedTicket = new Ticket(sNo, sRow, m, bookedShowtime);
        CGVsystem.ticket.add(bookedTicket);

        //Print the ticket booked

        System.out.println("\n\n\tThank you for booking!");
        System.out.println("\tHere is your ticket! /*^_^*/");
        System.out.println();
        System.out.println("\tName          : " + name);
        System.out.println("\tPhone         : " + phone);
        System.out.println("\tEmail         : " + email);
        System.out.println("\tMovie         : " + m.getTitle());
        System.out.println("\tShowtime      : " + bookedShowtime[0][0] + "   " + bookedShowtime[0][1]);
        System.out.println("\tRow / Seat    : " + Character.toUpperCase(sRow) + " / " + sNo);
        System.out.println("\tPrice         : RM" + bookedTicket.getPrice());
        System.out.println("\tDate / Time   : " + formatter.format(date));

        pressAnyKeyToContinue();
        clearScreen();
        Menu();
    }

    public static void addUpcomingMovie()
    {
		clearScreen();

        String movieName, movieLength, desc, rdate;
        Scanner input = new Scanner (System.in);
        int choice;
        boolean contAdd = false; //flag variable to check whether or not the user want to continue to add movie

        do {
			if(contAdd)
				input.nextLine();

            contAdd = false;

            System.out.println("\n\n\t= = = = = Add Movie = = = = =\n");
            System.out.println("\tPlease enter the following details to add movie.\n");
            System.out.print("\tTitle                 : ");
            movieName = input.nextLine();
            //input.next(); //To prevent the skipping of next() for accepting input
            System.out.print("\tLength (in minutes)   : ");
            movieLength = input.nextLine();
            System.out.print("\tRelease Date          : ");
            rdate = input.nextLine();
            System.out.print("\tDescription           : ");
            desc = input.nextLine();
            System.out.println();

            //Add the newly added movie into arraylist
            Movie newMovie = new Movie(movieName, movieLength,rdate);
            CGVsystem.upcomingMovie.add(newMovie);

            System.out.println("\tThe movie has been successfully added! : )\n");

            System.out.println("\tDo you still want to add another movie? ");

            boolean invalid = true;

            while(invalid)
            {
				System.out.print("\tEnter 1 for YES or 0 to return to main menu: ");
				choice = input.nextInt();

				if(choice == 1)
				{
					invalid = false;
					contAdd = true;
				}
				else if(choice == 0)
				{
					clearScreen();
					Menu();
				}
				else
				{
					System.out.println("\n\tPlease enter a valid interger number (1 or 0) ONLY!");
					invalid = true;
				}
			}
        } while(contAdd);
    }

    public static void displayAdminAcc()
    {
		clearScreen();
        CGVsystem.admin.displayAcc();
        Scanner input = new Scanner(System.in);
        boolean goMain = false;

        do {
            goMain = false;

            System.out.print("\n\tEnter 0 to go back to main menu : ");
            int choice = input.nextInt();

            if(choice != 0)
            {
                System.out.println("\tPlease enter a valid integer number!");
                goMain = true;
            }
        } while(goMain);

        clearScreen();
        Menu();
    }

    public static void clearScreen(){
        try
        {
            if (System.getProperty("os.name").contains("Windows"))
	         { new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); }
	    else
            {
                Runtime.getRuntime().exec("clear"); }
	}
	catch (IOException | InterruptedException ex) {}
    }

    public static void pressAnyKeyToContinue() {
        System.out.print("\n\n\tPress Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

    public static void main(String[] args) throws Exception {

        //Instantiate various classes
        Admin admin1 = new Admin("Jenn", "012-5985566", "jadmin123", "jadmin", "admin@cgv.my");

        CGVsystem.admin = admin1;

        Cinema CGV = new Cinema("CGV Cinema", "25, Jalan Theatre 31800 Ipoh Perak");

        CGVsystem.cinema = CGV;

        Movie movie1 = new Movie("Soul", "107", "Octobe 11, 2020");
        Movie movie2 = new Movie("Raya and The Last Dragon", "117", "March 5, 2021");
        Movie movie3 = new Movie("A Quiet Place Part II", "97", "April 16, 2020");

        String[][] showtime1 = {{"Monday","01:00PM"},{"Monday","04:10PM"},{"Tuesday","11:00AM"},{"Tuesday","03:00PM"}};
        String[][] showtime2 = {{"Wednesday","12:20PM"},{"Thursday","04:10PM"},{"Thursday","06:00PM"},{"Friday","03:00PM"}};
        String[][] showtime3 = {{"Saturday","02:40PM"},{"Saturday","12:10PM"},{"Sunday","11:40AM"},{"Sunday","03:30PM"}};

        movie1.setShowtime(showtime1);
        movie2.setShowtime(showtime2);
        movie3.setShowtime(showtime3);

        CGVsystem.movie.add(movie1);
        CGVsystem.movie.add(movie2);
        CGVsystem.movie.add(movie3);

        Movie newMovie1 = new Movie("Black Widow", "150", "July 9, 2021");
        Movie newMovie2 = new Movie("The King's Man", "167", "July 15, 2021");
        Movie newMovie3 = new Movie("Eternals", "159", "November 4, 2021");

        CGVsystem.upcomingMovie.add(newMovie1);
        CGVsystem.upcomingMovie.add(newMovie2);
        CGVsystem.upcomingMovie.add(newMovie3);

        Menu();
    }
}
