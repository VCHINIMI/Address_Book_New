package MyPackage.Vinay.Address_Book_New;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;





public class Address_Book_Main {
	public ArrayList<Contact> addressBook = new ArrayList<Contact>();
	
	public void addContact(Contact contact) {
		addressBook.add(contact);
	}
	public ArrayList<Contact> getAddressBook() {
		return addressBook;
	}
	public Contact takeContactInformation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first name: ");
		String f_name = sc.nextLine();
		System.out.println("Enter Last Name : ");
		String l_name = sc.nextLine();
		System.out.println("Enter Address : ");
		String address = sc.nextLine();
		System.out.println("Enter City : ");
		String city = sc.nextLine();
		System.out.println("Enter State : ");
		String state = sc.nextLine();
		System.out.println("Enter Zip : "); 
		int zip = sc.nextInt();sc.nextLine();
		System.out.println("Enter Phone Number : ");
		int phone_Number= sc.nextInt(); sc.nextLine();
		System.out.println("Enter email : ");
		String email = sc.nextLine();
		Contact c= new Contact(f_name,l_name,address,city,state,zip,phone_Number,email);
		return c;
	}
	public void displayAllContacts() {
		Iterator<Contact> it = addressBook.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}		
	}
	public void editContact(String fName) {
		int flag1=0;
		for(int i=0; i<addressBook.size(); i++) {
			if( ((addressBook.get(i)).f_Name).equals(fName)) {
				addressBook.set(i, takeContactInformation());
				flag1=1;
			}
		}
		if(flag1==0)
			System.out.println("Name not in addressBook");
		
	}
	public void deleteContact(String fName) {
		for(int i=0; i<addressBook.size(); i++) {
			if( ((addressBook.get(i)).f_Name).equals(fName)) {
				addressBook.remove(i);
			}
			else {
				System.out.println("Name not in AddressBook");
			}
		}		
	}
	
	public static void main(String[] args) {
		int flag =0;
		System.out.println("Welcome to Address Book Program");
		Address_Book_Main aMain = new Address_Book_Main();
		while(flag==0) {
			System.out.println("1.Enter Contact");
			System.out.println("2.Edit Contact");
			System.out.println("3.Delete Contact");
			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt(); scanner.nextLine();
			//scanner.close();
			switch(option) {
				case 1 :
					aMain.addContact(aMain.takeContactInformation());
					break;
				case 2 :
					System.out.println("Enter name");
					Scanner scanner2 = new Scanner(System.in);
					String fName1=scanner2.nextLine();
					aMain.editContact(fName1);
				//	scanner2.close();
					break;
				case 3 :
					System.out.println("Enter name");
					Scanner scanner3= new Scanner(System.in);
					String fName2 = scanner3.nextLine();
					aMain.deleteContact(fName2);
				//	scanner3.close();
					break;
				case 4 :
					aMain.displayAllContacts();
					break;
				case 5 :
					flag = 1;
					break;
			}
		}
		
	}
	
}
