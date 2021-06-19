import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {
    private int hotelID;
    private String hotelName;
    private ArrayList<Room> rooms;
    private ArrayList<Customer> customers;
    private HashMap<Integer,Integer> booked;
    public Hotel(int hotelID,String name)
    {
        this.hotelID=hotelID;
        this.hotelName=name;
        this.rooms = new ArrayList<>();
        this.booked = new HashMap<>();
        this.customers = new ArrayList<>();
    }
    public int getHotelID()
    {
        return this.hotelID;
    }
    public void addRoom(Room room)
    {
        this.rooms.add(room);
    }
    public void addCustomer(Customer customer)
    {
        this.customers.add(customer);
    }
    public ArrayList<Room> returnList()
    {
        return this.rooms;
    }
    public void showRooms()
    {
        for(Room r : this.rooms)
        {
            System.out.println("Room number: " + r.getRoomNum()+ " Amount: " + r.getAmount() + " Type: " + r.getRoomType() + " Status: " + r.getRoomStatus());
        }
    }
    public void addBook(int cust,int room)
    {
        this.booked.put(cust,room);
    }
    public void showBookings()
    {
        for(int i : this.booked.keySet())
        {
            System.out.println("Customer with Customer ID " + i + " has booked room " + this.booked.get(i));
        }
    }
    public void checkout(int id)
    {
        for(int i =0;i<this.customers.size();i++)
        {
            if(this.customers.get(i).getCusID()==id)
            {
                this.customers.get(i).checkout();
            }
        }
        for(int i=0;i<this.rooms.size();i++) {
            if (this.rooms.get(i).getRoomNum() == this.booked.get(id))
                this.rooms.get(i).checkoutRoom();
        }
    }
    public void retrieve(String custName)
    {
        for(int i=0;i<this.customers.size();i++)
        {
            if(this.customers.get(i).getName().equals(custName))
            {
                for(int j=0;j<this.rooms.size();j++)
                {
                    if(this.rooms.get(j).getRoomNum()==this.booked.get(this.customers.get(i).getCusID()))
                    {
                        System.out.println("Customer ID: " + this.customers.get(i).getCusID() +"\n"+ "Name: " + this.customers.get(i).getName()
                                            + "\n" + "Aadhar Number: " + this.customers.get(i).getAadharNumber() + "\n" +"Mobile No: "+ this.customers.get(i).getMobileNum()
                                                +"\n"+ "Current Status: "+this.customers.get(i).getCustomerStatus()+"\n"+"Room Number: " + this.rooms.get(j).getRoomNum() + "\n" +"Room Type: " + this.rooms.get(j).getRoomType());
                    }
                }
            }
        }
    }
    public void retrieve(int custID)
    {
        for(int i=0;i<this.customers.size();i++)
        {
            if(this.customers.get(i).getCusID()==custID)
            {
                for(int j=0;j<this.rooms.size();j++)
                {
                    if(this.rooms.get(j).getRoomNum()==this.booked.get(custID))
                    {
                        System.out.println("Customer ID: " + this.customers.get(i).getCusID() +"\n"+ "Name: " + this.customers.get(i).getName()
                                + "\n" + "Aadhar Number: " + this.customers.get(i).getAadharNumber() + "\n" +"Mobile No: "+ this.customers.get(i).getMobileNum()
                                +"\n" + "Current Status: "+this.customers.get(i).getCustomerStatus() + "Room Number: " + this.rooms.get(j).getRoomNum() + "\n" +"Room Type: " + this.rooms.get(j).getRoomType());
                    }
                }
            }
        }
    }

}
