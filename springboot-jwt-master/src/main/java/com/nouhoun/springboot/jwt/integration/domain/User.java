package com.nouhoun.springboot.jwt.integration.domain;

public class User {
	private String displayName;
	
	private String email;
	
	private String photoURL;
	
    private Long id;
    
    boolean isFriend;
    
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
	
	public String getPhotoURL() {
		return photoURL;
	}
	
	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public boolean isFriend() {
		return isFriend;
	}

	public void setFriend(boolean isFriend) {
		this.isFriend = isFriend;
	}

}
