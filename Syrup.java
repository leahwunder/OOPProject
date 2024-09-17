//-------------------------------------
//Class for handling syrup medicines.
//-------------------------------------
public class Syrup extends Medicine{
    private int bottleContent;

//Constructors

    public Syrup(Type type) {
        super(type);
    }

    public Syrup(String medicineName, String companyName, String companyEmail, double price, int quantity, int expirationYear, Type type, int bottleContent) throws InvalidEmailAddressException{
        super(medicineName, companyName, companyEmail, price, quantity, expirationYear, type);
        setBottleContent(bottleContent);
    }

//Getter

    public int getBottleContent() {
        return bottleContent;
    }
//Setter

    public void setBottleContent(int bottleContent) {
        this.bottleContent = bottleContent;
    }

//Methods
    public String toString(){
        String str = super.toString() + "\nBottle content:" + bottleContent + "\n****************";
       return str;
    }

    //Returning the total amount of the medicine by multiplying the quantity of bottles by bottle content
    @Override
    public int totalInventory() {
        int quantity = getQuantity();
        int inventory = quantity * bottleContent;
        return inventory;
    }
}
