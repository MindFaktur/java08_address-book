import java.util.Scanner;
import java.util.HashMap;

public class AddressBook{
	Scanner scan = new Scanner(System.in);
	public static void main( String[] args ) {
		int option = 0;
		while (option != 2) {
			System.out.println(" Press 1) Add Contact details 2) quit 3) change address ");
			AddressBook obj = new AddressBook();
			ContactData contactDataObject = new ContactData();
			option = obj.scan.nextInt();
			switch ( option ){
				case 1: contactDataObject.addContact();
						System.out.println(ContactData.contactsMap);
						break;
				case 3: contactDataObject.changeAddress();
						System.out.println(ContactData.contactsMap);
						break;
			}
		}
		System.out.println(ContactData.contactsMap);
	}
}


