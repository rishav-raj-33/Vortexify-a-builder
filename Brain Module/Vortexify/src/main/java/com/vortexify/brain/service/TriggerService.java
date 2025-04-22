package com.vortexify.brain.service;

import java.io.IOException;

import com.vortexify.brain.exception.DeploymentFailedException;



public interface TriggerService {
	
	 boolean cloneRepo(String url,String name) throws DeploymentFailedException ,IOException, InterruptedException;
	 
	 boolean buildDockerImage(String name) throws DeploymentFailedException ,IOException, InterruptedException;
	 
	 boolean deployDockerImage(String name,Long userId)throws DeploymentFailedException ,IOException, InterruptedException; 
	
	 
	 boolean stopContainer(String containerId) throws DeploymentFailedException, InterruptedException, IOException;
	 
	 boolean removeImage(String imageId,String containerId) throws DeploymentFailedException, InterruptedException, IOException;
	 
	 

}
