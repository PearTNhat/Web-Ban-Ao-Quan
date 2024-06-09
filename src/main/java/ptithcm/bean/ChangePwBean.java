package ptithcm.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class ChangePwBean {
	@NotBlank(message = "Vui lòng không để trống mật khẩu")
	@Length(min = 8, max = 40, message = "Mật khẩu phải có độ dài hơn 8 ký tự")
	private String oldPassword;

	@NotBlank(message = "Vui lòng không để trống mật khẩu")
	@Length(min = 8, max = 40, message = "Mật khẩu phải có độ dài hơn 8 ký tự")
	private String newPassword;

	@NotBlank(message = "Vui lòng không để trống mật khẩu")
	@Length(min = 8, max = 40, message = "Mật khẩu phải có độ dài hơn 8 ký tự")
	private String confirmPw;

	public ChangePwBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChangePwBean(String oldPassword, String newPassword, String confirmPw) {
		super();
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.confirmPw = confirmPw;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPw() {
		return confirmPw;
	}

	public void setConfirmPw(String confirmPw) {
		this.confirmPw = confirmPw;
	}

}
