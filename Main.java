import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();




    //Creating 3 medicines of each type
    //Syrup 'vitamin' has an invalid email, an InvalidEmailAddressException is received.

        Pills acamol = null;
        try {
            acamol = new Pills("Acamol", "Teva", "teva@com.il", 18.80, 0, 2030, Medicine.Type.PILLS, 20);
        } catch (InvalidEmailAddressException e) {
            e.printStackTrace();
        }

        Pills Nurophen = null;
        try {
            Nurophen = new Pills("NUROPHEN", "Teva", "teva@com.il", 21.99, 2, 2028, Medicine.Type.PILLS, 10);
        } catch (InvalidEmailAddressException e) {
            e.printStackTrace();
        }

        Pills moxyvit = null;
        try {
            moxyvit = new Pills("moxyvit", "vitamed", "vitamed@com.uk", 36, 34, 2025, Medicine.Type.PILLS, 5);
        } catch (InvalidEmailAddressException e) {
            e.printStackTrace();
        }

        Syrup nurophen = null;
        try {
            nurophen = new Syrup("NUROPHEN", "Teva", "teva@com.il", 21.99, 5, 2028, Medicine.Type.SYRUP, 100);
        } catch (InvalidEmailAddressException e) {
            e.printStackTrace();
        }

        Syrup rafaphen = null;
        try {
            rafaphen = new Syrup("Rafaphen", "vitamed", "vitamed@com", 18, 22, 2030, Medicine.Type.SYRUP, 80);
        } catch (InvalidEmailAddressException e) {
            e.printStackTrace();
        }

        Syrup Vitamin = null;
        try {
            Vitamin = new Syrup("Vitamin", "Altman", "altman@org.il", 22, 10, 2027, Medicine.Type.SYRUP, 110);
        } catch (InvalidEmailAddressException e) {
            e.printStackTrace();
        }

        Inhaler inhaler1 = null;
        try {
            inhaler1 = new Inhaler("Inhaler1", "company1", "company1@gmail.il", 55, 42, 2045, Medicine.Type.INHALER, 50);
        } catch (InvalidEmailAddressException e) {
            e.printStackTrace();

        }
        Inhaler inhaler2 = null;
        try {
            inhaler2 = new Inhaler("Inhaler2", "company3", "company3@gmail.il", 35, 12, 2030, Medicine.Type.INHALER, 50);
        } catch (InvalidEmailAddressException e) {
            e.printStackTrace();

        }
        Inhaler inhaler3 = null;
        try {
            inhaler3 = new Inhaler("Inhaler3", "company1", "company1@gmail.il", 155, 8, 2028, Medicine.Type.INHALER, 50);
        } catch (InvalidEmailAddressException e) {
            e.printStackTrace();
        }

    //Adding medicines to the Inventory.
    //Adding 'acamol' twice. Second time retrieves a MedicineAlreadyExistsException.
    //??? Is it correct to add this in the constructor???
        try {
            inventory.addMedicine(acamol);
        } catch (MedicineAlreadyExistsException e) {
            e.printStackTrace();
        }

        try {
            inventory.addMedicine(acamol);
        } catch (MedicineAlreadyExistsException e) {
            e.printStackTrace();
        }

        try {
            inventory.addMedicine(Nurophen);
        } catch (MedicineAlreadyExistsException e) {
            e.printStackTrace();
        }

        try {
            inventory.addMedicine(moxyvit);
        } catch (MedicineAlreadyExistsException e) {
            e.printStackTrace();
        }

        try {
            inventory.addMedicine(nurophen);
        } catch (MedicineAlreadyExistsException e) {
            e.printStackTrace();
        }

//        try {
//            inventory.addMedicine(rafaphen);
//        } catch (MedicineAlreadyExistsException e) {
//            e.printStackTrace();
//        }

        try {
            inventory.addMedicine(Vitamin);
        } catch (MedicineAlreadyExistsException e) {
            e.printStackTrace();
        }

        try {
            inventory.addMedicine(inhaler1);
        } catch (MedicineAlreadyExistsException e) {
            e.printStackTrace();
        }

        try {
            inventory.addMedicine(inhaler2);
        } catch (MedicineAlreadyExistsException e) {
            e.printStackTrace();
        }

        try {
            inventory.addMedicine(inhaler3);
        } catch (MedicineAlreadyExistsException e) {
            e.printStackTrace();
        }



        System.out.println("##########################\n##########################");

    //Searching for a specific medicine by name.
    //If medicine is found, it's total inventory is received, or 'out of stock'.
    //If medicine is not found, MedicineNotExistException is received.
        try {
            Medicine norophenPills = inventory.searchMedicineByName2( "nurophen", Medicine.Type.PILLS);
            boolean inStock = norophenPills.inStock();
            if (norophenPills.inStock())
                System.out.println("******Total inventory of " + norophenPills.getMedicineName() + " is: " + norophenPills.totalInventory() + "******");
            else
                System.out.println("******" + norophenPills.getMedicineName() + " " + norophenPills.getType() + " is out of stock******");
        } catch (MedicineNotExistException e) {
            e.printStackTrace();
        }

        try {
            Medicine norophenPills = inventory.searchMedicineByName2( "acamol", Medicine.Type.PILLS);
            boolean inStock = norophenPills.inStock();
            if (norophenPills.inStock())
                System.out.println("******Total inventory of " + norophenPills.getMedicineName() + " is: " + norophenPills.totalInventory() + "******");
            else
                System.out.println("******" + norophenPills.getMedicineName() + " " + norophenPills.getType() + " is out of stock******");
        } catch (MedicineNotExistException e) {
            e.printStackTrace();
        }

        try {
            Medicine norophenPills = inventory.searchMedicineByName2("notExistMedicine", Medicine.Type.PILLS);
            boolean inStock = norophenPills.inStock();
            if (norophenPills.inStock())
                System.out.println("*****Total inventory of " + norophenPills.getMedicineName() + " is: " + norophenPills.totalInventory() + "*****");
            else
                System.out.println("*****" + norophenPills.getMedicineName() + " " + norophenPills.getType() + " is out of stock*****");
        } catch (MedicineNotExistException e) {
            e.printStackTrace();
        }

        System.out.println("##########################\n##########################");

        //Searching for all medicine in a specific type.
        inventory.searchMedicineByType(Medicine.Type.PILLS);


        System.out.println("##########################\n##########################");

        //Printing all medicines in stock
        System.out.println("Listing all medicines in stock:");
        System.out.println(inventory.getMedicineInStock());

    }
}

