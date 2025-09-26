
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class movie_ticket_booking_system {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         

        try {
            System.out.print("enter file name:");
            String filename=sc.nextLine();
            System.out.print("");
             File file=new File(filename);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists!");
            }
            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            System.out.print("Enter movie name: |--LEO--| |--KANTARA--| |--KGF 2--| ");
            String movie = sc.nextLine();

            System.out.print("Enter showtime |--first show :10:30--| |--second show : 2:30--| |--third show : 6:30--| ");
            String showtime = sc.nextLine();
            System.out.print("first class(1) :150rs | second class(2) :200rs | third class(3) :300rs");
            
             String classType = sc.nextLine();


            System.out.print("Enter number of seats: (min 5 seats allowed) ");
            int seats = sc.nextInt();
            int price = 0;
            if (classType.equals("1")) {
                price = 150*seats;
            } else if (classType.equals("2")) {
                price = 200*seats;
            } else if (classType.equals("3")) {
                price = 300*seats;
            } else {
                throw new Exception("Invalid class type selected.");
            }

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
            String formattedDateTime = now.format(dtf);


            if (seats >= 5) {
                throw new Exception("You can only book a maximum of 5 seats.");
            }
            else{
                System.out.println("Your welcome to the Blitz Cinemas");

            }
        
        FileWriter writer = new FileWriter(filename,true);

        writer.write("---------------- THE BLITZ CINEMAS -------------------\n");
        writer.write("Date & time : " + formattedDateTime + "\n");
        writer.write("Customer Name : " + name + "\n");
        writer.write("Movie         : " + movie + "\n");
        writer.write("class type    : " + classType + "\n");
        writer.write("Showtime      : " + showtime + "\n");
        writer.write("Seats Booked  : " + seats + "\n");
        writer.write("total price   : " + price + "\n");
        writer.write("-----------------THANK YOU----------------------\n");

        writer.close();
        System.out.println("\nTicket booked successfully! Receipt saved to: " + filename);

            

        } catch (Exception e) {
            System.out.println("Booking Failed: " + e.getMessage());
       
        } finally {
            sc.close();
        }
    }
}

    
