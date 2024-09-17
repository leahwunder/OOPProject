//-------------------------------------
//Class for handling pills medicines.
//-------------------------------------
public class Pills extends Medicine{
    private int numOfPillsInBox;

    public Pills(Type type) {
        super(type);
    }

    public Pills(String medicineName, String companyName, String companyEmail, double price, int quantity, int expirationYear, Type type, int numOfPillsInBox) throws InvalidEmailAddressException {
        super(medicineName, companyName, companyEmail, price, quantity, expirationYear, type);
        setNumOfPillsInBox(numOfPillsInBox);
    }

    public int getNumOfPillsInBox() {
        return numOfPillsInBox;
    }

    public void setNumOfPillsInBox(int numOfPillsInBox) {
        this.numOfPillsInBox = numOfPillsInBox;
    }

    //Methods

    public String toString(){

       String str = super.toString() + "\nNumber of pills in box:" + numOfPillsInBox + "\n****************";
        return str;
    }

    //Returning the total amount of the medicine by multiplying the quantity of boxes by number of pills in a box
    @Override
    public int totalInventory() {
        int quantity =getQuantity();
        int inventory = quantity * numOfPillsInBox;
        return inventory;
    }
}
