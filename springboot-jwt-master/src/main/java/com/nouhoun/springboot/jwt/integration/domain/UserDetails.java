package com.nouhoun.springboot.jwt.integration.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"displayName",
	"email",
	"emailVerified",
	"isAnonymous",
	"phoneNumber",
	"photoURL",
	"providerId",
	"uid"
})

@Entity
@Table(name = "userinfo_rtab")
public class UserDetails {

	@JsonProperty("displayName")
	private String displayName;
	@JsonProperty("email")
	private String email;
	@JsonProperty("emailVerified")
	private Boolean emailVerified;
	@JsonProperty("isAnonymous")
	private Boolean isAnonymous;
	@JsonProperty("phoneNumber")
	private Object phoneNumber;
	@JsonProperty("photoURL")
	private String photoURL;
	@JsonProperty("providerId")
	private String providerId;
	@JsonProperty("uid")
	private String uid;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("displayName")
	public String getDisplayName() {
		return displayName;
	}

	@JsonProperty("displayName")
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("emailVerified")
	public Boolean getEmailVerified() {
		return emailVerified;
	}

	@JsonProperty("emailVerified")
	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	@JsonProperty("isAnonymous")
	public Boolean getIsAnonymous() {
		return isAnonymous;
	}

	@JsonProperty("isAnonymous")
	public void setIsAnonymous(Boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	@JsonProperty("phoneNumber")
	public Object getPhoneNumber() {
		return phoneNumber;
	}

	@JsonProperty("phoneNumber")
	public void setPhoneNumber(Object phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@JsonProperty("photoURL")
	public String getPhotoURL() {
		return photoURL;
	}

	@JsonProperty("photoURL")
	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	@JsonProperty("providerId")
	public String getProviderId() {
		return providerId;
	}

	@JsonProperty("providerId")
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	@JsonProperty("uid")
	public String getUid() {
		return uid;
	}

	@JsonProperty("uid")
	public void setUid(String uid) {
		this.uid = uid;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
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