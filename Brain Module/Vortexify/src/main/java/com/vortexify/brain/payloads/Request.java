package com.vortexify.brain.payloads;

public class Request {
	
	
	
	private String url;
	
	private Long userId;
	
	
	//-------------------------------------
	public String getUrl() {
		return url;
	}
	public void setRepoUrl(String url) {
		this.url = url;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	

}
