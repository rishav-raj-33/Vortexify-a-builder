package com.vortexify.brain.service;

import java.io.IOException;

import com.vortexify.brain.exception.DeploymentFailedException;



public interface TriggerService {
	
	 boolean cloneRepo(String url) throws DeploymentFailedException ,IOException, InterruptedException;
	 
	 boolean buildDockerImage(String path) throws DeploymentFailedException ,IOException, InterruptedException;
	 
	 boolean deployDockerImage(String name,Long userId)throws DeploymentFailedException ,IOException, InterruptedException; 
	
	 
	 boolean stopContainer(String containerId) throws DeploymentFailedException, InterruptedException, IOException;
	 
	 boolean removeImage(String imageId,String containerId) throws DeploymentFailedException, InterruptedException, IOException;
	 
	 

}
