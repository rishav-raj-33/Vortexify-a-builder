package com.vortexify.brain.payloads;

public class DeployRequest {
	
	
	
	private String repoUrl;
	
	private Long userId;
	
	
	//-------------------------------------
	public String getRepoUrl() {
		return repoUrl;
	}
	public void setRepoUrl(String repoUrl) {
		this.repoUrl = repoUrl;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	

}
