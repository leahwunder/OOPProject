//-------------------------------------
//Class for handling inhaler medicines.
//-------------------------------------
public class Inhaler extends Medicine{
    private int amountOfClick;


    //Constructors
    public Inhaler(Type type) {
        super(type);
    }

    public Inhaler(String medicineName, String companyName, String companyEmail, double price, int quantity, int expirationYear, Type type, int amountOfClick) throws InvalidEmailAddressException {
        super(medicineName, companyName, companyEmail, price, quantity, expirationYear, type);
        setAmountOfClick(amountOfClick);
    }

    //Getter

    public int getAmountOfClick() {
        return amountOfClick;
    }

    //Setter

    public void setAmountOfClick(int amountOfClick) {
        this.amountOfClick = amountOfClick;
    }


//Methods

    public String toString(){

        String str = super.toString() + "\nAmount of clicks:" + amountOfClick + "\n****************";
        return str;
    }

    //Returning the total amount of the medicine by multiplying the quantity inhalers by amount of clicks in an inhaler
    public int totalInventory() {
        int quantity =getQuantity();
        int inventory = quantity * amountOfClick;
        return inventory;
    }

}
