public class Customer {
    private int customerID;
    private String name;
    private String aadharNumber;
    private String mobileNum;
    private CustomerStatus customerStatus;
    public Customer(int ID, String name,String aadharNumber,String mobileNum)
    {
        this.customerID=ID;
        this.name=name;
        this.aadharNumber=aadharNumber;
        this.mobileNum=mobileNum;
        this.customerStatus=CustomerStatus.CHECKEDIN;
    }
    public int getCusID()
    {
        return this.customerID;
    }
    public String getName()
    {
        return this.name;
    }
    public String getAadharNumber()
    {
        return this.aadharNumber;
    }
    public String getMobileNum()
    {
        return this.mobileNum;
    }
    public CustomerStatus getCustomerStatus(){return this.customerStatus;}
    public void checkout()
    {
        this.customerStatus=CustomerStatus.CHECKEDOUT;
    }

}
