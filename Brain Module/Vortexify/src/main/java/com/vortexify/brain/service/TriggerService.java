package com.vortexify.brain.service;

import java.io.IOException;

import jakarta.websocket.DeploymentException;

public interface TriggerService {
	
	 boolean cloneRepo(String url) throws DeploymentException ,IOException, InterruptedException;
	 
	 boolean buildDockerImage(String path) throws DeploymentException ,IOException, InterruptedException;
	 
	 boolean deployDockerImage(String hostName)throws DeploymentException ,IOException, InterruptedException;  
	 
	 
	 

}
