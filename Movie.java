import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Movie
{
	private String title;
	private String length;
	private String releaseDate;
	private String[][] showtime = new String [4][2];

	public Movie(String title, String length, String releaseDate)
	{
		this.title= title;
		this.length=length;
		this.releaseDate=releaseDate;
	}

        public Movie() {

        }

	public void setTitle(String t)
	{
		t=title;
	}
	public void setLength(String l)
	{
		l=length;
	}
	public void setReleaseDate(String r)
	{
		r=releaseDate;
	}

	public String getTitle()
	{
		return title;
	}
	public String getLength()
	{
		return length;
	}
	public String getReleaseDate()
	{
		return releaseDate;
	}

	public String toString()
	{
		return title+"\t\t"+length+"\t\t"+releaseDate;
	}

	public void setShowtime(String[][] s)
        {
            for(int i=0; i<showtime.length; i++)
            {
                for(int j=0; j<showtime[i].length; j++)
                {
                    showtime[i][j] = s[i][j];
                }
            }
        }

        public void displayShowtime()
        {
            for(int i=0; i<showtime.length; i++)
            {
                System.out.println("\t[" + (i+1) + "]");
                for(int j=0; j<showtime[i].length; j++)
                {
                    System.out.println("\t" + showtime[i][j]);
                }
                System.out.println();
            }
        }

        public String[][] getShowtime(int s)
        {
            String[][] temp = new String [1][2];
            switch(s)
            {
                case 1: temp[0][0] = showtime[0][0]; temp[0][1] = showtime[0][1]; break;
                case 2: temp[0][0] = showtime[1][0]; temp[0][1] = showtime[1][1]; break;
                case 3: temp[0][0] = showtime[2][0]; temp[0][1] = showtime[2][1]; break;
                case 4: temp[0][0] = showtime[3][0]; temp[0][1] = showtime[3][1]; break;
            }

            return temp;
        }

	//display movie menu
	/* public void displayMovie()
	{
		System.out.println("\tNo"+"\t\tTitle"+"\t\tLength (Minutes)");
		for(int i=0; i<movie.size(); i++)
		{
			System.out.println("\t"+(i+1)+"\t\t"+movie.get(i));
			System.out.println("");
		}
	} */

	/* public static void main(String[] args)throws IOException
	{
			String name,length,date;
			Movie m= new Movie("","","");


			/* If selection=1 (View Upcoming Movie Menu)
			System.out.println(" \t\t\t\t\t\tUpcoming Movies In The Town  ");
			System.out.println("");
			System.out.println("Title\t\t\t\t\t" +"Introduction\t\t\t"+"Movie release Date\t" +"Length(minutes)");
			System.out.println("");
			System.out.println("Black Widow\t"+"At birth the Black Widow is given to the KGB," + "\t\tJuly 9,2021"+"\t\t150");
			System.out.println("\t\twhich grooms her to become its ultimate operative.");
			System.out.println("\t\tWhen the U.S.S.R breaks up, goverment tries to kill");
			System.out.println("\t\ther as the action moves to present-day New York, ");
			System.out.println("\t\twhere she is a freelance operative");
			System.out.println("");
			System.out.println("King's Man\t"+"One man must race against time to stop history's" + "\tJuly 15,2021"+"\t\t167");
			System.out.println("\t\tworst tyrants and criminal masterminds as they get");
			System.out.println("\t\ttogether to pot a war that could wipe out millions of ");
			System.out.println("\t\tpeople and destroy humanity.");
			System.out.println("");
			System.out.println("Eternals\t"+"A race of immortal beings with superhuman powers" + "\tNovember 4,2021"+"\t\t159");
			System.out.println("\t\twho have secretly lived on Earth for thousands");
			System.out.println("\t\tof years, reunite to battle the evil Deviants");
			System.out.println("");


			// If selection =3 (Add 3 Movies)
			int n=3;
			for(int i=0; i<n; i++)
			{
				System.out.println("\t\t\t= = = Add Movie = = =");
				System.out.println("Please enter the details of the new movie.");
				Scanner input=new Scanner(System.in);
				System.out.println("Title   : ");
				name=input.nextLine();
				System.out.println("Length  : ");
				length=input.nextLine();
				System.out.println("Showtime: ");
				date=input.nextLine();
				m.addMovie(name,length); //create new Movie object
				//m.addMovie(m);
				if(i==n-1)
				{
					m.displayMovie();
					System.out.println("");
				}
			}
	} */
}
