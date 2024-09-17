public class InvalidEmailAddressException extends Exception {
    public InvalidEmailAddressException(String companyEmail, String msg){
        System.out.println("ERROR: " + companyEmail + " Invalid email address: " + msg);
    }
}
