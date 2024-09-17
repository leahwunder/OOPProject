public class MedicineAlreadyExistsException extends Exception{

    public MedicineAlreadyExistsException(Medicine newMedicine){
        System.out.println("ERROR: " + newMedicine.getMedicineName() +" " +newMedicine.getType()+ " already exist in the inventory");
    }

}
