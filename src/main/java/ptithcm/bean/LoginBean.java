package ptithcm.bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class LoginBean {
	@NotBlank(message="Vui lòng điền email")
	@Email(message="Email không đúng định dạng")
	private String email;
	
	@NotBlank(message="Vui lòng điền password")
	private String password;

	private Boolean rememberMe;
	
	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginBean(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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

	public Boolean getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	@Override
	public String toString() {
		return "LoginBean [email=" + email + ", password=" + password + ", rememberMe=" + rememberMe + "]";
	}
}
