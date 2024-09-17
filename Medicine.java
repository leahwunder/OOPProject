//---------------------------------
//Parent class for defining medicines' objects
//The objects should be inherited & used by specific medicines type
//--------------------------------
import javax.xml.namespace.QName;
import java.util.Date;

public abstract class Medicine {
     private String medicineName;
     private String companyName;
     private String companyEmail;
     private double price;
     private int quantity;
     private int expirationYear;
     private Type type;

     enum Type{
          PILLS,
          SYRUP,
          INHALER}

//Constructors
    public Medicine(Type type) {
    setType(type);
    }

    public Medicine(String medicineName, String companyName, String companyEmail, double price, int quantity, int expirationYear, Type type) throws InvalidEmailAddressException{
        setMedicineName(medicineName);
        setCompanyName(companyName);
        setCompanyEmail(companyEmail);
        setPrice(price);
        setQuantity(quantity);
        setExpirationYear(expirationYear);
        setType(type);
    }

    //Getters
    public String getMedicineName() {
        return medicineName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public Type getType() {
        return type;
    }

//Setters
    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName.toUpperCase();
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyEmail(String companyEmail) throws InvalidEmailAddressException{
         int at = companyEmail.indexOf('@');
         String regex = ".*@.*\\..*";
         if (at < 0)            //Validating that '@' included in the email address
             throw new InvalidEmailAddressException(companyEmail, "An email address should include '@'.");
         if (at == 0)           //Validating that '@' is not the first char in the email address
             throw new InvalidEmailAddressException(companyEmail, "'@' can't be the first char in an email address.");
         if (companyEmail.endsWith("@"))  //Validating that '@' is not the last char in the email address
             throw new InvalidEmailAddressException(companyEmail, "An email address should include a domain after the '@'.");
         if (!companyEmail.matches(regex))  ////Validating that there is at least 1 dot after the '@' in the email address
             throw new InvalidEmailAddressException(companyEmail, "There should be at least 1 dot in the address domain");
        this.companyEmail = companyEmail;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    private void setType(Type type) {
        this.type = type;
    }

    //Methods

    public String toString() {
         String str = ("\n****************" + "\nMedicine name:" + medicineName + "\nCompany nane:" + companyName + "\nCompany email:" + companyEmail +  "\nPrice:" + price + "\nQuantity:" + quantity + "\nExpiration date:" + expirationYear + "\nType:" + type);
         return str;
    }

    //Returning the total amount of the medicine.
    //Methods should be implemented by class of each type of medicine
    public abstract int totalInventory();


    public  boolean inStock(){
        boolean inStock = true;
        if (quantity<=0){
            inStock = false;
            return inStock;}
        else
            return inStock;
    }

}










