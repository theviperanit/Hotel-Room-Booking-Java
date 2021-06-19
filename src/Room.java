public class Room {
    private int roomNum;
    private int hotelID;
    private RoomType roomType;
    private RoomStatus roomStatus;
    private int amount;
    public Room(int roomNum,int hotelID,int amount,RoomType type)
    {
        this.roomNum=roomNum;
        this.hotelID=hotelID;
        this.amount=amount;
        this.roomType=type;
        this.roomStatus=RoomStatus.UNBOOKED;
    }
    public int getRoomNum()
    {
        return this.roomNum;
    }
    public int getAmount()
    {
        return this.amount;
    }
    public RoomType getRoomType()
    {
        return this.roomType;
    }
    public RoomStatus getRoomStatus()
    {
        return this.roomStatus;
    }
    public void bookRoom()
    {
        this.roomStatus=RoomStatus.BOOKED;
    }
    public void checkoutRoom()
    {
        this.roomStatus=RoomStatus.UNBOOKED;
    }

}
