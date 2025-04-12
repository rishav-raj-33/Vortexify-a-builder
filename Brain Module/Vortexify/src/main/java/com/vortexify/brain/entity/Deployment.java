package com.vortexify.brain.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Deployment {
	
	
	  @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String status; // PENDING, IN_PROGRESS, SUCCESS, FAILED
	    private String containerIp;
	    private String containerPort;
	    private String liveUrl; 
	    private Long userId; 
	    private LocalDateTime createdAt;
	    private LocalDateTime updatedAt;
	
	    
	    //------------------------------------------------------------
	    
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getContainerIp() {
			return containerIp;
		}
		public void setContainerIp(String containerIp) {
			this.containerIp = containerIp;
		}
		public String getContainerPort() {
			return containerPort;
		}
		public void setContainerPort(String containerPort) {
			this.containerPort = containerPort;
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
