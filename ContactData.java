import java.util.*;

class ContactData implements interfaceData{
    userInputs userInputsObject = new userInputs();
    AddressBook scanObject = new AddressBook();
    static HashMap <String, HashMap<String,String>> contactsMap = new HashMap<>();
    static HashMap <Integer,HashMap <String, HashMap<String,String>>> addressBooks = new HashMap<>();
    static Integer count = 0;

    public void addContact(){

        System.out.println(" Please enter the Full name to add details ");
        userInputsObject.setFull_name(scanObject.scan.nextLine());

        System.out.println(" Please enter the address to add details ");
        userInputsObject.setAddress(scanObject.scan.nextLine());

        System.out.println(" Please enter city to add details ");
        userInputsObject.setCity(scanObject.scan.nextLine());

        System.out.println(" Please enter the state to add details ");
        userInputsObject.setState(scanObject.scan.nextLine());

        System.out.println(" Please enter the zip code to add details ");
        userInputsObject.setZip(scanObject.scan.nextLine());

        System.out.println(" Please enter the phone number to add details ");
        userInputsObject.setPhone_number(scanObject.scan.nextLine());

        System.out.println(" Please enter the email id to add details ");
        userInputsObject.setEmail(scanObject.scan.nextLine());

        HashMap<String,String> details = new HashMap<>();

        details.put("Address",userInputsObject.getAddress());
        details.put("City",userInputsObject.getCity());
        details.put("State",userInputsObject.getState());
        details.put("Zip",userInputsObject.getZip());
        details.put("Phone Number",userInputsObject.getPhone_number());
        details.put("Email-Id",userInputsObject.getEmail());
        contactsMap.put(userInputsObject.getFull_name(), details);

        addressBooks.put(count,contactsMap);
        count++;
    }

    public void changeAddress() {
        System.out.println(" Please enter name whose address you want to change ");
        String userName = scanObject.scan.nextLine();
        int val = 0;
        for ( String name : contactsMap.keySet() ) {
            if(Objects.equals(userName, name)){
                System.out.println(" Please enter new address ");
                String userAddress = scanObject.scan.nextLine();
                HashMap<String,String> tempList = contactsMap.get(userName);
                tempList.replace("Address",userAddress);
                val = 1;
            }
        }
        if ( val == 0 ){
            System.out.println(" The given name does not match any records ");
        }
    }

    public void changeCity() {
        System.out.println(" Please enter name whose city you want to change ");
        String userName = scanObject.scan.nextLine();
        int val = 0;
        for ( String name : contactsMap.keySet() ) {
            if(Objects.equals(userName, name)){
                System.out.println(" Please enter new City name ");
                String userCity = scanObject.scan.nextLine();
                HashMap<String,String> tempList = contactsMap.get(userName);
                tempList.replace("City",userCity);
                val = 1;
            }
        }
        if ( val == 0 ){
            System.out.println(" The given name does not match any records ");
        }
    }

    public void changeState() {
        System.out.println(" Please enter name whose State you want to change ");
        String userName = scanObject.scan.nextLine();
        int val = 0;
        for ( String name : contactsMap.keySet() ) {
            if(Objects.equals(userName, name)){

                System.out.println(" Please enter new State ");
                String userState = scanObject.scan.nextLine();
                HashMap<String,String> tempList = contactsMap.get(userName);
                tempList.replace("State",userState);

                val = 1;
            }
        }
        if ( val == 0 ){
            System.out.println(" The given name does not match any records ");
        }
    }

    public void changeZip() {
        System.out.println(" Please enter name whose Zip you want to change ");
        String userName = scanObject.scan.nextLine();
        int val = 0;
        for ( String name : contactsMap.keySet() ) {
            if(Objects.equals(userName, name)){

                System.out.println(" Please enter new Zip ");
                String userZip = scanObject.scan.nextLine();
                HashMap<String,String> tempList = contactsMap.get(userName);
                tempList.replace("Zip",userZip);

                val = 1;
            }
        }
        if ( val == 0 ){
            System.out.println(" The given name does not match any records ");
        }
    }

    public void changePhoneNumber() {
        System.out.println(" Please enter name whose Phone Number you want to change ");
        String userName = scanObject.scan.nextLine();
        int val = 0;
        for ( String name : contactsMap.keySet() ) {
            if(Objects.equals(userName, name)){

                System.out.println(" Please enter new Phone Number ");
                String userNumber = scanObject.scan.nextLine();
                HashMap<String,String> tempList = contactsMap.get(userName);
                tempList.replace("PhoneNumber",userNumber);

                val = 1;

            }
        }
        if ( val == 0 ){
            System.out.println(" The given name does not match any records ");
        }
    }

    public void changeEmail() {
        System.out.println(" Please enter name whose Email-Id you want to change ");
        String userName = scanObject.scan.nextLine();
        int val = 0;
        for ( String name : contactsMap.keySet() ) {
            if(Objects.equals(userName, name)){

                System.out.println(" Please enter new Email-Id ");
                String userEmail = scanObject.scan.nextLine();
                HashMap<String,String> tempList = contactsMap.get(userName);
                tempList.replace("Email-Id",userEmail);

                val = 1;
            }
        }
        if ( val == 0 ){
            System.out.println(" The given name does not match any records ");
        }
    }

    public void deleteContact() {
        System.out.println(" Please enter name whose details you want to delete ");
        String userName = scanObject.scan.nextLine();
        for ( String name : contactsMap.keySet() ) {
            if(Objects.equals(userName, name)){
                contactsMap.remove(userName);
            }else{
                System.out.println(" The given name does not match any records ");
            }
        }
    }

}
