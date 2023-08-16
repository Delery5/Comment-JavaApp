package com.example.information.dto;

import java.util.Objects;

import lombok.Data;

@Data
public class LoginDTO {

	 private String usernameOrEmail;
	    private String password;
		
	    public LoginDTO(String usernameOrEmail, String password) {
			super();
			this.usernameOrEmail = usernameOrEmail;
			this.password = password;
		}

		public String getUsernameOrEmail() {
			return usernameOrEmail;
		}

		public void setUsernameOrEmail(String usernameOrEmail) {
			this.usernameOrEmail = usernameOrEmail;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "LoginDTO [usernameOrEmail=" + usernameOrEmail + ", password=" + password + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(password, usernameOrEmail);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LoginDTO other = (LoginDTO) obj;
			return Objects.equals(password, other.password) && Objects.equals(usernameOrEmail, other.usernameOrEmail);
		}
	    
}
