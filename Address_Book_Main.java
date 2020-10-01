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
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		Address_Book_Main aMain = new Address_Book_Main();
		Contact contact = aMain.takeContactInformation();
		
	}
}
