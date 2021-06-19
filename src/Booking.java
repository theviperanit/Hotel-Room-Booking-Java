import java.util.ArrayList;

public class Booking {
    private Hotel hotel;
    private Customer customer;
    private Room room;
    private int bookingID;
    public Booking(int bookingID,Hotel hotel,Customer customer)
    {
        this.bookingID=bookingID;
        this.hotel=hotel;
        this.customer=customer;
    }
    public boolean book(RoomType roomType )
    {
        ArrayList<Room> rooms = this.hotel.returnList();
        for(Room r : rooms)
        {
            if(r.getRoomType() == roomType && r.getRoomStatus()!=RoomStatus.BOOKED)
            {
                this.hotel.addBook(this.customer.getCusID(),r.getRoomNum());
                r.bookRoom();
                this.room=r;
                this.hotel.addCustomer(this.customer);
                System.out.println("You have booked room " + r.getRoomNum());
                return true;
            }
        }
        System.out.println("Sorry, no " + roomType + " rooms are available");
        return false;
    }
}
