package services;

import contactdata.AddressBook;
import contactdata.Contacts;
import inputs.Inputs;
import utilities.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Operations
{
    public void addContact(String bookName)
    {
        Contacts CD = new Contacts();
        AddressBook AB = AddressBook.getInstance();

        CD.firstName = Inputs.getInput(" First Name ");
        CD.lastName = Inputs.getInput(" Last Name ");
        CD.address = Inputs.getInput(" Address ");
        CD.city = Inputs.getInput(" City Name ");
        CD.state = Inputs.getInput(" State ");
        CD.zip = Inputs.getInput(" Zip code ");
        CD.mobNo = Inputs.getInput(" Mobile No ");
        CD.email = Inputs.getInput(" Email-ID ");

        if( AB.addToAddressBook(bookName,CD) )
        {
            System.out.println("Added to AdressBook");
        }else
        {
            System.out.println("Duplicate name is given, please give a different name");
        }

    }

    public void mainMenu(List<Contacts> listOfContacts, String bookName)
    {
        int option = 0;
        while ( option != 16 ) {
            AddressBook AB = AddressBook.getInstance();
            System.out.println(" Press " +
                    "\n 1) Print all Books " +
                    "\n 2) Edit Name " +
                    "\n 3) Edit Address " +
                    "\n 4) Edit City " +
                    "\n 5) Edit State " +
                    "\n 6) Edit Zip " +
                    "\n 7) Edit Mobile Number " +
                    "\n 8) Edit Email-Id " +
                    "\n 9) Delete Contact " +
                    "\n 10) Search By City " +
                    "\n 11) Search By State " +
                    "\n 12) Sort By First Name " +
                    "\n 13) Sort By City " +
                    "\n 14) Sort By State " +
                    "\n 15) Sort By Zip " +
                    "\n 16) Quit "
            );
            option = Utilities.SC.nextInt();
            editContact(option,listOfContacts,bookName);
        }
    }

    public void editContact(int optionValue, List<Contacts> listOfContacts,String bookName)
    {
        AddressBook AB = AddressBook.getInstance();

        switch (optionValue){
            case 1:
                System.out.println(AB.getAllAddressBooks());
                break;

            case 2:
                Contacts cdName = AB.getContactObject(listOfContacts);
                if( cdName != null )
                {
                    System.out.println("Enter new first name");
                    cdName.firstName = Utilities.SC.next();
                    System.out.println("Enter new last name");
                    cdName.lastName = Utilities.SC.next();
                }else{
                    System.out.println("Provided name doesn't match our records");
                }
                break;

            case 3:
                Contacts cdAddress = AB.getContactObject(listOfContacts);
                if( cdAddress != null )
                {
                    System.out.println("Enter new address name");
                    cdAddress.address = Utilities.SC.next();
                }else
                {
                    System.out.println("Provided name doesn't match our records");
                }
                break;

            case 4:
                Contacts cdCity = AB.getContactObject(listOfContacts);
                if( cdCity != null )
                {
                    System.out.println("Enter new city name");
                    cdCity.city = Utilities.SC.next();
                }else
                {
                    System.out.println("Provided name doesn't match our records");
                }
                break;

            case 5:
                Contacts cdState = AB.getContactObject(listOfContacts);
                if( cdState != null )
                {
                    System.out.println("Enter new state name");
                    cdState.state = Utilities.SC.next();
                }else
                {
                    System.out.println("Provided name doesn't match our records");
                }
                break;

            case 6:
                Contacts cdZip = AB.getContactObject(listOfContacts);
                if( cdZip != null )
                {
                    System.out.println("Enter new Zip code");
                    cdZip.zip = Utilities.SC.next();
                }else
                {
                    System.out.println("Provided name doesn't match our records");
                }
                break;

            case 7:
                Contacts cdMobNo = AB.getContactObject(listOfContacts);
                if( cdMobNo != null )
                {
                    System.out.println("Enter new mobile number");
                    cdMobNo.zip = Utilities.SC.next();
                }else
                {
                    System.out.println("Provided name doesn't match our records");
                }
                break;

            case 8:
                Contacts cdEmail = AB.getContactObject(listOfContacts);
                if( cdEmail != null )
                {
                    System.out.println("Enter new Email");
                    cdEmail.email = Utilities.SC.next();
                }else
                {
                    System.out.println("Provided name doesn't match our records");
                }
                break;

            case 9:
                String firstName = Inputs.getInput("First Name");
                String lastName = Inputs.getInput("Last Name");
                for ( Contacts CD : listOfContacts )
                {
                    if ( CD.firstName.equals(firstName) && CD.lastName.equals(lastName) )
                    {
                        listOfContacts.remove(CD);
                        break;
                    }
                }
                System.out.println("Name doesn't match our records");
                break;

            case 10:
                String cityName = Inputs.getInput("City name to filter");
                searchCity(cityName);
                break;

            case 11:
                String stateName = Inputs.getInput("State name to filter");
                searchState(stateName);
                break;

            case 12:
                AB.sortedListByFirstName(bookName);
                break;

            case 13:
                AB.sortedListByCity(bookName);
                break;

            case 14:
                AB.sortedListByState(bookName);
                break;

            case 15:
                AB.sortedListByZip(bookName);
                break;
        }
    }

    public void searchCity(String fieldValue)
    {
        AddressBook AB = AddressBook.getInstance();
        Set<String> allKeys = AB.getAllAddressBooks().keySet();
        for ( String str : allKeys)
        {
            List<Contacts> obj = AB.getContactList(str);
            obj.stream()
                    .filter(ContactObj -> ContactObj.city.equals(fieldValue) )
                    .forEach(Contacts -> System.out.println(Contacts.firstName + " " + Contacts.lastName));
        }
    }

    public void searchState(String fieldValue)
    {
        AddressBook AB = AddressBook.getInstance();
        Set<String> allKeys = AB.getAllAddressBooks().keySet();
        for ( String str : allKeys)
        {
            List<Contacts> obj = AB.getContactList(str);
            obj.stream()
                    .filter(ContactObj -> ContactObj.state.equals(fieldValue) )
                    .forEach(Contacts -> System.out.println(Contacts.firstName + " " + Contacts.lastName));
        }
    }


    public void menu()
    {
        int menuOption = 0;
        AddressBook AB = AddressBook.getInstance();
        while ( menuOption != 4 )
        {
            System.out.println(" Press " +
                    "\n 1) Add List of contacts to Address Book " +
                    "\n 2) Edit Address Book Contacts " +
                    "\n 3) Delete Address Book " +
                    "\n 4) Quit "
            );
            menuOption = Utilities.SC.nextInt();
            switch (menuOption)
            {
                case 1:
                    String addressBookName = Inputs.getInput(" Address Book name ");
                    addContact(addressBookName);
                    break;
                case 2:
                    String addressBookToEdit = Inputs.getInput(" Address Book name to Edit ");
                    List<Contacts> listOfContacts = AB.getContactList(addressBookToEdit);
                    mainMenu(listOfContacts,addressBookToEdit);
                    break;
                case 3:
                    String addressBookToDelete = Inputs.getInput(" Address Book name to delete ");
                    if ( AB.getContactList(addressBookToDelete) != null ){
                        AB.getAllAddressBooks().remove(addressBookToDelete);
                    }else{
                        System.out.println("Name doesn't match our records");
                        break;
                    }

            }
        }
    }


}
