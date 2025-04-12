package com.vortexify.brain.payloads;

public class DeploymentResponseFailed {
	
	String msg;
	boolean success;
	
	public DeploymentResponseFailed(String msg, boolean success) {
		super();
		this.msg = msg;
		this.success = success;
	}
	

}
