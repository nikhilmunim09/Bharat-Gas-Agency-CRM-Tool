package gasSupplier;

public interface GasAgencies {

    public String agencyName = "Bharat Gas";

    public int agencyCode = 771;

    public String phNumber = "9927130018";
    
    default void displayAgency() {

        System.out.println("Name of agency : "+agencyName);

        System.out.println("Agency code : "+agencyCode);
        
        System.out.println("Contact us : "+phNumber);
    }
    
}
