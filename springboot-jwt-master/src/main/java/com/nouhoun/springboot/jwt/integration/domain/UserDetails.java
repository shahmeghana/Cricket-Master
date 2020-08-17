package com.nouhoun.springboot.jwt.integration.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdetails_rtab")
public class UserDetails {

	@Column(name = "displayName")
	private String displayName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "emailVerified")
	private Boolean emailVerified;
	
	@Column(name = "isAnonymous")
	private Boolean isAnonymous;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "photoURL")
	private String photoURL;
	
	@Column(name = "providerId")
	private String providerId;
	
	@Column(name = "uid")
	private String uid;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public Boolean getIsAnonymous() {
		return isAnonymous;
	}

	public void setIsAnonymous(Boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
}



/*
 * package com.nouhoun.springboot.jwt.integration.domain;
 * 
 * public class UserDetails {
 * 
 * private String username;
 * 
 * private String password;
 * 
 * private String name;
 * 
 * private String email;
 * 
 * private String phone;
 * 
 * public String getUsername() { return username; }
 * 
 * public void setUsername(String username) { this.username = username; }
 * 
 * public String getPassword() { return password; }
 * 
 * public void setPassword(String password) { this.password = password; }
 * 
 * public String getName() { return name; }
 * 
 * public void setName(String name) { this.name = name; }
 * 
 * public String getEmail() { return email; }
 * 
 * public void setEmail(String email) { this.email = email; }
 * 
 * public String getPhone() { return phone; }
 * 
 * public void setPhone(String phone) { this.phone = phone; }
 * 
 * 
 * 
 * {"displayName": "Pranjal Gore", "email": "jalispran@gmail.com",
 * "emailVerified": true, "isAnonymous": false, "metadata": {"creationTime":
 * 1597028485 361, "lastSignInTime": 1597600942352}, "phoneNumber": null,
 * "photoURL":
 * "https://lh3.googleusercontent.com/a-/AOh14GhWXrPHwGx6NqGMnjk19JH5OMZQ_zj2nNTE9BWvvQ=s96-c",
 * "providerData": [[Object ]], "providerId": "firebase", "uid":
 * "iQwz7frsqDWRwVYvkYlXxiguykD2"}
 * 
 * 
 * 
 * }
 */