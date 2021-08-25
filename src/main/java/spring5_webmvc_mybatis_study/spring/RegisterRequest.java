package spring5_webmvc_mybatis_study.spring;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RegisterRequest {
	@NotBlank
	@Email
	private String email;
	@Size(min = 6)
	private String password;
	@NotEmpty
	private String confirmPassword;
	@NotEmpty
	private String name;
	
	public void setConformPassword(String conformPassword) {
		this.confirmPassword = conformPassword;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password =password;
	}
	

	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public boolean isPasswordEqualToConfirmPassword() {
		return password.contentEquals(confirmPassword);
	}

	@Override
	public String toString() {
		return String.format("RegisterRequest [email=%s, password=%s, confirmPassword=%s, name=%s]", email, password,
				confirmPassword, name);
	}

}
