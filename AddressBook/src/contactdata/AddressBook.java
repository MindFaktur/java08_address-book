package contactdata;

import inputs.Inputs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AddressBook
{
    public static AddressBook instance;
    private HashMap<String,List<Contacts>> allAddressBooks = new HashMap<>();

    AddressBook(){}

    public static AddressBook getInstance()
    {
        if ( instance == null ){
            instance = new AddressBook();
        }
        return instance;
    }

    public boolean addToAddressBook(String bookName, Contacts data)
    {
        boolean added = true;
        List<Contacts> contactList = new ArrayList<>();
        boolean found = false;
        if ( allAddressBooks.size() == 0 ){
            contactList.add(data);
            allAddressBooks.put(bookName,contactList);
        }
        for ( String str : allAddressBooks.keySet() ) {
            if( bookName.equals(str) ){
                found = true;
                contactList = allAddressBooks.get(bookName);
                if ( contactList.size() > 0 ) {
                    for (Contacts CD : contactList) {
                        if (CD.firstName.equals(data.firstName) && CD.lastName.equals(data.lastName)) {
                            added = false;
                            break;
                        }
                    }
                    if (added) {
                        contactList.add(data);
                    }

                }else{
                    contactList.add(data);
                }
            }
        }
        if( !found ){
            contactList.add(data);
            allAddressBooks.put(bookName,contactList);
        }
        return added;
    }

    public HashMap<String,List<Contacts>> getAllAddressBooks()
    {
        return allAddressBooks;
    }

    public Contacts getContactObject(List<Contacts> contactlist)
    {
        String firstName = Inputs.getInput("First Name");
        String lastName = Inputs.getInput("Last Name");
        for ( Contacts CD : contactlist )
        {
            if ( CD.firstName.equals(firstName) && CD.lastName.equals(lastName) )
            {
                return CD;
            }
        }
        return null;
    }

    public List<Contacts> getContactList(String bookName)
    {
        return allAddressBooks.get(bookName);
    }

    public void sortedListByFirstName(String name){
        List<Contacts> CD = allAddressBooks.get(name);
        CD.sort((cd1, cd2) -> cd1.firstName.compareTo(cd2.firstName));
        System.out.println(CD);
    }

    public void sortedListByCity(String name){
        List<Contacts> CD = allAddressBooks.get(name);
        CD.sort((cd1, cd2) -> cd1.city.compareTo(cd2.city));
        System.out.println(CD);
    }

    public void sortedListByState(String name){
        List<Contacts> CD = allAddressBooks.get(name);
        CD.sort((cd1, cd2) -> cd1.state.compareTo(cd2.state));
        System.out.println(CD);
    }

    public void sortedListByZip(String name){
        List<Contacts> CD = allAddressBooks.get(name);
        CD.sort((cd1, cd2) -> cd1.zip.compareTo(cd2.zip));
        System.out.println(CD);
    }
}
