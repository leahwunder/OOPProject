public class MedicineNotExistException extends Exception{
    public MedicineNotExistException (String medicineName, Medicine.Type type){
        System.out.println("ERROR: " + type + " of " + medicineName + " was not found in the inventory");
    }

}
