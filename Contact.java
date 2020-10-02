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
	@Override
	public boolean equals(Object o) {
		if(o==this)
			return true;
		if(!(o instanceof Contact))
			return false;
		Contact c = (Contact) o;
		return f_Name.equals(c.f_Name) && l_Name.equals(c.l_Name) && address.equals(c.address) && city.equals(c.city) && state.equals(c.state) && Integer.compare(zip, c.zip)==0 && Integer.compare(phone_Number, c.phone_Number)==0 && email.equals(c.email);
	}
}