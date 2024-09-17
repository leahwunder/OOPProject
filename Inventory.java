//--------------------------------------------
//Class for managing medicines inventory.
//Adding/updating medicines
//Searching for a specific medicine by name
//Searching for all medicines in a specific type
//Returning all existing medicines
//--------------------------------------------

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Medicine> allMedicines = new ArrayList<Medicine>();


//Methods
/*public  void addMedicine(Medicine newMedicine) {
    for (Medicine mdc: allMedicines) {
        if (newMedicine.getMedicineName().equals(mdc.getMedicineName()))
            System.out.println("Medicine already exists");
        else
        { System.out.println("Adding medicine to the inventory");
            allMedicines.add(newMedicine);}
    }
}*/

    public void addMedicine(Medicine newMedicine) throws MedicineAlreadyExistsException {
        boolean exists = false;

        for (Medicine mdc : allMedicines) {
            if (newMedicine.getMedicineName().equalsIgnoreCase(mdc.getMedicineName()) && (newMedicine.getType().equals(mdc.getType()))) {
                throw new MedicineAlreadyExistsException(newMedicine);
                //   exists = true;
                //   break;  // exit the loop once a match is found
            }
        }
        if (!exists) {
            System.out.println("Adding medicine " + newMedicine.getMedicineName() +" " +newMedicine.getType() + " to the inventory");
            allMedicines.add(newMedicine);
        }
    }

    public String searchMedicineByName(Medicine medicine) {
        String retVal = medicine.getMedicineName();
        for (Medicine mdc : allMedicines) {
            if (mdc.getMedicineName().equalsIgnoreCase(String.valueOf(medicine)) && mdc.getType().equals(medicine.getType()))
                ;
            {
                System.out.println(medicine.getMedicineName() + "'s inventory is: " + medicine.totalInventory());
                return retVal;
            }
        }
        System.out.println(retVal + " doesn't exist in the inventory");
        return retVal;
    }

//    public void searchMedicineByName(Medicine medicine) {
//        for (Medicine mdc : allMedicines) {
//            if (mdc.getMedicineName().equalsIgnoreCase(String.valueOf(medicine)))
//            {
//                System.out.println(medicine.getMedicineName() + "'s inventory is: " + medicine.totalInventory());
//                break;
//            }
//            else{
//                System.out.println(medicine.getMedicineName() + " doesn't exist in the inventory");
//            }
//        }
//    }

    //Getting a medicine name, returning a list of all existing types of this medicine
    //Returning a MedicineDoesNotExistException if medicine doesn't exist
    public Medicine searchMedicineByName2(String medicineName, Medicine.Type type) throws MedicineNotExistException {
        Medicine found = null;

        for (Medicine mdc : allMedicines) {
            if (mdc.getMedicineName().equalsIgnoreCase(medicineName) && mdc.getType().equals(type)) {
                found = mdc;
                break;
            }
        }

        if (found == null) {
            throw new MedicineNotExistException(medicineName, type);
        }
        return found;
    }

//    //Getting medicineName, returning all existing types of this medicine
//    public ArrayList searchMedicineByType(Medicine medicine) {
//        ArrayList<Medicine> medicineAllTypes = new ArrayList<Medicine>();
//        for (Medicine mdc: allMedicines) {
//            if (mdc.getMedicineName().equalsIgnoreCase(medicine.getMedicineName()))
//               medicineAllTypes.add(mdc);
//        }
//        return medicineAllTypes;
//    }

    //The function gets a type of medicine, and returns an array of medicines of this type from the inventory.
    //A message is received in case there are no medicine of the given type.
    public void searchMedicineByType(Medicine.Type type) {
        ArrayList<Medicine> medicinesOfSpecificType = new ArrayList<>();
        boolean found = false;
        for (Medicine mdc : allMedicines) {
            if (mdc.getType().equals(type)) {
                medicinesOfSpecificType.add(mdc);
                found = true;
            }
        }
        if (found) {
            System.out.println("#######" + type + " medicines in the stock:#######");
            System.out.println(medicinesOfSpecificType);
        }
        if (!found) {
            System.out.println("There are no " + type + " medicines in the stock");

        }
    }

    public ArrayList getMedicineInStock() {
        return allMedicines;

    }
}
