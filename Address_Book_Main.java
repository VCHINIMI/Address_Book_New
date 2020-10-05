package MyPackage.Vinay.Address_Book_New;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Scanner;


public class Address_Book_Main {
	public HashMap<String, AddressBookClass> multiAddressBook = new HashMap<String, AddressBookClass>();
	
	public HashMap<String, AddressBookClass> getMultiAddressBook() {
		return multiAddressBook;
	}
	public void setMultiAddressBook(HashMap<String, AddressBookClass> multiAddressBook) {
		this.multiAddressBook = multiAddressBook;
	}
	public ArrayList<Contact> listOfAllContactsByOrder() {
		ArrayList<Contact> con = new ArrayList<Contact>();
		for(AddressBookClass abc : multiAddressBook.values()) {
			for(Contact c : abc.getAddressBook()) {
				con.add(c);
			}
		}
		return con;
	}
	public boolean createNewAddressBook(String name){
		int flag =0;
		//System.out.println("Enter name of New Address Book");
		for(String nameString : multiAddressBook.keySet()) {
			if(name.equals(nameString))
				flag = 1;
		}
		if(flag==0) {
			AddressBookClass aBook = new AddressBookClass(name);
			multiAddressBook.put(aBook.getNameOfAddressBook(), aBook);
			return true;
		}
		else {
			System.out.println("Name of new address book Invalid, try again!");
			return false;
		}
	}
	
	public void searchByCityOrState() {
		int flag14 =0;
		int myFlag=0;
		List<AddressBookClass> demo1= multiAddressBook.values().stream().collect(Collectors.toList());
		List<Contact> myList = new ArrayList<Contact>();
		for(AddressBookClass abClass : demo1) {
			for(Contact contact : abClass.getAddressBook()) {
				myList.add((Contact) contact);
			}
		}
		while(myFlag==0) {
			System.out.println("1.City");
			System.out.println("2.State");
			System.out.println("3.Exit");
			Scanner sc_1 = new Scanner(System.in);
			int opt = sc_1.nextInt();sc_1.nextLine();
			switch(opt) {
			case 1 :
				System.out.println("Enter City");
				Scanner sc1234 = new Scanner(System.in);
				String cityString = sc1234.nextLine();
				List<Contact> sByCity = myList.stream().filter(c->(c.getCity()).equals(cityString)).collect(Collectors.toList());
				if(sByCity.isEmpty())
					System.out.println("No contact Found");
				else {
					for(Contact contact : sByCity) {
						System.out.println(contact);
					}
				}					
				break;
		
			case 2 : 
				System.out.println("Enter State");
				String stateString = sc_1.nextLine();
				List<Contact> sByState = myList.stream().filter(c->(c.getState()).equals(stateString)).collect(Collectors.toList());
				if(sByState.isEmpty())
					System.out.println("No contact Found");
				else {
					for(Contact contact : sByState) {
						System.out.println(contact);
					}
				}				
				break;
				
			case 3 :
				System.out.println("Exiting Search...");
				myFlag=1;
				break;
			}
		}
	}
	public void searchByName() {
		int flag12 = 0;
		Scanner sc12 = new Scanner(System.in);
		System.out.println("Enter name you want to search");
		String nameString = sc12.nextLine();
		Iterator<HashMap.Entry<String, AddressBookClass>> itr3 = (multiAddressBook.entrySet()).iterator();
		while(itr3.hasNext()) {
			HashMap.Entry<String, AddressBookClass> entry = itr3.next();
			AddressBookClass aBookClass2 = entry.getValue();
			for(Contact c : aBookClass2.getAddressBook()) {
				if(c.getF_Name().equals(nameString)) {
					System.out.println(c.getF_Name()+" "+c.getCity()+" "+c.getState());
					flag12++;
				}	
			}
		}
		if(flag12==0) {
			System.out.println("Contact not found");
		}		
	}
	
	public void countByCityAndState() {
		final HashMap<String, Integer>countByHashMap = new HashMap<String, Integer>();
		Iterator<HashMap.Entry<String,AddressBookClass>> it4 = (multiAddressBook.entrySet()).iterator();
		while(it4.hasNext()) {
			HashMap.Entry<String,AddressBookClass> entry = it4.next();
			AddressBookClass aBookClass3 = entry.getValue();
			for(Contact c : aBookClass3.getAddressBook() ) {
				if(countByHashMap.get(c.getCity())==null) {
					countByHashMap.put(c.getCity(), 1);
				}
				else {
					int co = countByHashMap.get(c.getCity());
					countByHashMap.put(c.getCity(), co++);
				}
			}
		}
		
		Iterator<HashMap.Entry<String, AddressBookClass>> it5 = (multiAddressBook.entrySet()).iterator();
		while(it5.hasNext()) {
			HashMap.Entry<String,AddressBookClass> entry = it5.next();
			System.out.println("City : "+entry.getKey()+" Count : "+entry.getValue());
		}
	}
	
	public void displayAllAddressBooks() {
		for(String nameString : multiAddressBook.keySet())
			System.out.println(nameString);
	}
	
	public static void main(String[] args) {
		int flag1 =0;
		Address_Book_Main abMain = new Address_Book_Main();
		while(flag1==0) {
			abMain.displayAllAddressBooks();
			System.out.println("1. Create");
			System.out.println("2. Edit");
			System.out.println("3. Search By City or State");
			System.out.println("4. Search By Person Name");
			System.out.println("5. Count by city Name");
			System.out.println("6. Exit ");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt(); sc.nextLine();
			switch(option) {
			
			
			case 1 :
				System.out.println("Enter name ");
				Scanner sc0 = new Scanner(System.in);
				int flag_1 = 0;
				String name_1 = sc0.nextLine();
				Iterator<HashMap.Entry<String, AddressBookClass>> it2 = (abMain.getMultiAddressBook().entrySet()).iterator();
				while(it2.hasNext()) {
					HashMap.Entry<String, AddressBookClass> entry = it2.next();
					if(entry.getKey().equals(name_1))
						flag_1=1;
				}
				if(flag_1!=1) {
					abMain.createNewAddressBook(name_1);				
					AddressBookClass abClass1= (abMain.getMultiAddressBook()).get(name_1);
					int flag_0 =0;		
						while(flag_0==0) {
							System.out.println("1.Enter Contact");
							System.out.println("2.Edit Contact");
							System.out.println("3.Delete Contact");
							System.out.println("4.Display All Contacts");
							System.out.println("5.Exit from AddressBook");
							Scanner scanner_2 = new Scanner(System.in);
							int option_1 = scanner_2.nextInt(); scanner_2.nextLine();
							//scanner.close();
							switch(option_1) {
								case 1 :
									abClass1.addContact(abClass1.takeContactInformation());
									(abMain.getMultiAddressBook()).put(abClass1.getNameOfAddressBook(), abClass1);
									break;
								case 2 :
									System.out.println("Enter name");
									Scanner scanner_3 = new Scanner(System.in);
									String fName1=scanner_3.nextLine();
									abClass1.editContact(fName1);
									(abMain.getMultiAddressBook()).put(abClass1.getNameOfAddressBook(), abClass1);
								//	scanner2.close();
									break;
								case 3 :
									System.out.println("Enter name");
									Scanner scanner_4= new Scanner(System.in);
									String fName2 = scanner_4.nextLine();
									abClass1.deleteContact(fName2);
								//	scanner3.close();
									(abMain.getMultiAddressBook()).put(abClass1.getNameOfAddressBook(), abClass1);
									break;
								case 4 :
									abClass1.displayAllContacts();
									break;
								case 5 :
									flag_0 = 1;
									break;
						}
					}
				}
				else {
					System.out.println("Name Already exists, Try again");
				}
				break;
				
			case 2 :
				if(!(abMain.multiAddressBook.isEmpty())) {
					System.out.println("Enter name of address book you want to see");
					String nameOfAddressBook = sc.nextLine();
					AddressBookClass abClass = null;
					Iterator<HashMap.Entry<String, AddressBookClass>> itr = ((abMain.getMultiAddressBook()).entrySet()).iterator();
					while(itr.hasNext()) {
						HashMap.Entry<String, AddressBookClass> entry = itr.next();
						if(entry.getKey().equals(nameOfAddressBook)) {
							abClass =  entry.getValue();				
						}
					}
					
					int flag0 =0;		
					while(flag0==0) {
						System.out.println("1.Enter Contact");
						System.out.println("2.Edit Contact");
						System.out.println("3.Delete Contact");
						System.out.println("4.Display All Contacts");
						System.out.println("5.Exit from AddressBook");
						Scanner scanner = new Scanner(System.in);
						int option1 = scanner.nextInt(); scanner.nextLine();
						//scanner.close();
						switch(option1) {
							case 1 :
								abClass.addContact(abClass.takeContactInformation());
								(abMain.getMultiAddressBook()).put(abClass.getNameOfAddressBook(), abClass);
								break;
							case 2 :
								System.out.println("Enter name");
								Scanner scanner2 = new Scanner(System.in);
								String fName1=scanner2.nextLine();
								abClass.editContact(fName1);
								(abMain.getMultiAddressBook()).put(abClass.getNameOfAddressBook(), abClass);
							//	scanner2.close();
								break;
							case 3 :
								System.out.println("Enter name");
								Scanner scanner3= new Scanner(System.in);
								String fName2 = scanner3.nextLine();
								abClass.deleteContact(fName2);
							//	scanner3.close();
								(abMain.getMultiAddressBook()).put(abClass.getNameOfAddressBook(), abClass);
								break;
							case 4 :
								abClass.displayAllContacts();
								break;
							case 5 :
								flag0 = 1;
								break;
						}
					}
				}
				else {
					System.out.println("MultiAddress Book is Empty");
				}
				break;				
			case 3 :
				abMain.searchByCityOrState();
				break;				
			case 4 :
				abMain.searchByName();
				break;				
			case 5 :
				abMain.countByCityAndState();
				break;			
			case 6 :
				System.out.println("Exiting...");
				flag1=1;
				break;
				
			}
		}
	}
}