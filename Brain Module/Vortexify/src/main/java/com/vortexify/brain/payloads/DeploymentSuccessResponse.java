package com.vortexify.brain.payloads;

import java.time.LocalDateTime;

public class DeploymentSuccessResponse {
	private String liveUrl; 
    private Long userId; 
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String status;
    
    
   
  //--------------------------------------
    
    public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getLiveUrl() {
		return liveUrl;
	}
	public void setLiveUrl(String liveUrl) {
		this.liveUrl = liveUrl;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
