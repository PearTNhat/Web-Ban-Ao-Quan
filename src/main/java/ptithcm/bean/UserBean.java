package ptithcm.bean;
import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class UserBean {
	@NotBlank(message="Vui lòng không để trống Họ")
	private String firstName;
	
	@NotBlank(message="Vui lòng không để trống Tên")
	private String lastName;
	
	private String address;
	
	@NotBlank(message="Vui lòng điền email")
	@Email(message="Email không đúng định dạng")
	private String email;
	
	@NotBlank(message="Vui lòng không để trống mật khẩu")
	@Length(min=8, max=40, message="Mật khẩu phải có độ dài hơn 8 ký tự")
	private String password;
	
	@NotBlank(message="Vui lòng nhập lại mật khẩu")
	private String confirmPassword;
	
	private MultipartFile avatar;
	
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserBean(String firstName, String lastName, String address, String email, String password,
			String confirmPassword, MultipartFile avatar) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.avatar = avatar;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public MultipartFile getAvatar() {
		return avatar;
	}
	public void setAvatar(MultipartFile avatar) {
		this.avatar = avatar;
	}
	@Override
	public String toString() {
		return "UserBean [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", email="
				+ email + ", password=" + password + ", confirmPassword=" + confirmPassword + ", avatar=" + avatar
				+ "]";
	}
}
