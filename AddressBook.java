import java.util.Scanner;
import java.util.HashMap;

public class AddressBook{
	Scanner scan = new Scanner(System.in);
	public static void main( String[] args ){
		System.out.println(" Welcome to Address Book Program ");
		ContactDetails obj = new ContactDetails();
		obj.addContact();
		System.out.println(obj.details);
		System.out.println(obj.Contacts);
	}
}

class ContactDetails {
	String first_name, last_name, address, city, state,	zip, phone_number, email;

	HashMap<String, Object> Contacts = new HashMap<>();
	HashMap<String, String> details = new HashMap<>();

	public void addContact(){
		AddressBook scanObject = new AddressBook();

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
		String full_name = (first_name + " " + last_name);

		details.put("Address", address);
		details.put("City", city);
		details.put("State", state);
		details.put("Zip", zip);
		details.put("PhoneNumber", phone_number);
		details.put("Email-Id", email);

		Contacts.put(full_name,details);
	}
}
