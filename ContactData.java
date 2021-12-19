import java.util.*;

class ContactData {
    public static String first_name, last_name, address, city, state,	zip, phone_number, full_name, email;
    public static HashMap <String, HashMap<String,String>> contactsMap = new HashMap<>();
    AddressBook scanObject = new AddressBook();

    public void addContact(){

        System.out.println(" Please enter the First name to add details ");
        first_name = scanObject.scan.nextLine();
        System.out.println(" Please enter the last name to add details ");
        last_name = scanObject.scan.nextLine();
        System.out.println(" Please enter the address to add details ");
        address = scanObject.scan.nextLine();
        System.out.println(" Please enter city to add details ");
        city = scanObject.scan.nextLine();
        System.out.println(" Please enter the state to add details ");
        state = scanObject.scan.nextLine();
        System.out.println(" Please enter the zip code to add details ");
        zip = scanObject.scan.nextLine();
        System.out.println(" Please enter the phone number to add details ");
        phone_number = scanObject.scan.nextLine();
        System.out.println(" Please enter the email id to add details ");
        email = scanObject.scan.nextLine();
        full_name = (first_name + " " + last_name);

        HashMap<String,String> details = new HashMap<>();
        details.put("First Name",first_name);
        details.put("Last Name",last_name);
        details.put("Address",address);
        details.put("City",city);
        details.put("State",state);
        details.put("Zip",zip);
        details.put("Phone Number",phone_number);
        details.put("Email-Id",email);
        contactsMap.put(full_name, details);
    }

    public void changeAddress() {
        System.out.println(" Please enter name whose address you want to change ");
        String userName = scanObject.scan.nextLine();
        for ( String name : contactsMap.keySet() ) {
            if(Objects.equals(userName, name)){
                System.out.println(contactsMap.get(userName));
                System.out.println(" Please enter new address ");
                String userAddress = scanObject.scan.nextLine();
                HashMap<String,String> tempList = contactsMap.get(userName);
                tempList.replace("Address",userAddress);
                System.out.println(contactsMap.get(userName));
            }else{
                System.out.println(" The given name does not match any records ");
            }
        }
    }

}
