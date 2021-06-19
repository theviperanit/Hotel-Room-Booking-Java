import java.util.Random;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Hotel hotel;

    public UserInterface(Hotel hotel,Scanner scanner)
    {
        this.hotel=hotel;
        this.scanner=scanner;
    }
    public Customer newCustomer()
    {
        Random rand = new Random();
        int num = rand.nextInt(200);
        System.out.println("Enter name of customer");
        String name = scanner.nextLine();
        System.out.println("Enter Aadhaar number");
        String aadhar = scanner.nextLine();
        System.out.println("Enter mobile number");
        String mob = scanner.nextLine();
        Customer customer = new Customer(num,name,aadhar,mob);
        return customer;
    }
    public Room createNewRoom()
    {
        Random rand = new Random();
        int num = rand.nextInt(200);
        int id = this.hotel.getHotelID();
        System.out.println("Enter the amount the room would cost");
        int amt = Integer.valueOf(scanner.nextLine());
        System.out.println("Enter the Room Type: SINGLE,DOUBLE or TRIPLE");
        RoomType type = RoomType.valueOf(scanner.nextLine());
        Room room = new Room(num,id,amt,type);
        return room;

    }
    public void start()
    {
        while(true) {
            System.out.println("Enter 1 to Book Rooms");
            System.out.println("Enter 2 to Add Rooms");
            System.out.println("Enter 3 to Checkout");
            System.out.println("Enter 4 to retrieve information about a customer");
            System.out.println("Enter 5 to show Room status");
            System.out.println("Enter 6 to show Booking History");
            System.out.println("Enter 9  to Quit");
            int command = Integer.valueOf(scanner.nextLine());
            if(command==1)
            {
                Customer customer = newCustomer();
                Random rand = new Random();
                int bookID = rand.nextInt(100);
                Booking book = new Booking(bookID,this.hotel,customer);
                Boolean bool=false;
                while(!bool) {
                    System.out.println("What type of room does Customer want: SINGLE,DOUBLE or TRIPLE");
                    RoomType roomType = RoomType.valueOf(scanner.nextLine());
                    bool = book.book(roomType);
                }
                System.out.println("Your customer ID is " + customer.getCusID());
            }
            else if(command==2)
            {
                Room room = createNewRoom();
                this.hotel.addRoom(room);
            }
            else if(command==3)
            {
                System.out.println("Enter the Customer ID of the Customer");
                int ID = Integer.valueOf(scanner.nextLine());
                this.hotel.checkout(ID);
            }
            else if(command==4)
            {
                System.out.println("Enter 1 for Search by Customer ID");
                System.out.println("Enter 2 for Search by Customer Name");
                int response = Integer.valueOf(scanner.nextLine());
                if(response==1)
                {
                    System.out.println("Enter Customer ID");
                    int custID = Integer.valueOf(scanner.nextLine());
                    this.hotel.retrieve(custID);
                }
                else
                {
                    System.out.println("Enter Customer Name");
                    String custName = scanner.nextLine();
                    this.hotel.retrieve(custName);
                }

            }
            else if(command==5)
            {
                this.hotel.showRooms();
            }
            else if(command==6)
            {
                this.hotel.showBookings();
            }
            else if(command==9)
                break;
            System.out.println("");
        }
    }
}
