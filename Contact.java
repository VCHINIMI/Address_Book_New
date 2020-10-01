package MyPackage.Vinay.Address_Book_New;

public class Contact{
	String f_Name;
	String l_Name;
	String address;
	String city;
	String state;
	int zip;
	int phone_Number;
	String email;
	
	public Contact(String f_Name, String l_Name, String address, String city, String state, int zip, int phone_Number,
			String email) {
		super();
		this.f_Name = f_Name;
		this.l_Name = l_Name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone_Number = phone_Number;
		this.email = email;
	}	
	@Override
	public String toString() {
		return ("Name : "+f_Name+"Last name : "+l_Name+" Address : "+address+" City : "+city+" State: "+state+" Zip Code: "+zip+" Phone Number : "+ phone_Number+" Email Id : "+email);
		
	}
}