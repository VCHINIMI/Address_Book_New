package MyPackage.Vinay.Address_Book_New;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class AddressBookClassTest {

	@Test
	public void writeContactToAddressBookFileTest() {
		Address_Book_Main address_Book_Main = new Address_Book_Main();
		address_Book_Main.writeContactToFile(
				new Contact("Vinay", "ch", "55", "vskp", "AP", 5330, 99122, "vina.ch@gmail"), "Contacts.txt");
		address_Book_Main.writeContactToFile(
				new Contact("Vinay", "ch", "55", "vskp", "AP", 5330, 99122, "vina.ch@gmail"), "Contacts.txt");
		List<Contact> contactList = address_Book_Main.readContactFromFile("Contacts.txt");
		assertEquals(contactList.get(0), new Contact("Vinay", "ch", "55", "vskp", "AP", 5330, 99122, "vina.ch@gmail"));
		assertEquals(contactList.get(1), new Contact("Vinay", "ch", "55", "vskp", "AP", 5330, 99122, "vina.ch@gmail"));
	}
}
