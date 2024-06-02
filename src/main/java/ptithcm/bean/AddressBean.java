package ptithcm.bean;

public class AddressBean {
	private String recipientName;
	private String phoneNumber;
	private String addressName;
	
	public AddressBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AddressBean(String recipientName, String phoneNumber, String addressName) {
		super();
		this.recipientName = recipientName;
		this.phoneNumber = phoneNumber;
		this.addressName = addressName;
	}
	
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
}
