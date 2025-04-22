package com.vortexify.brain.service;

import java.util.List;

import com.vortexify.brain.entity.Deployment;
import com.vortexify.brain.payloads.Request;
import com.vortexify.brain.payloads.DeploymentSuccessResponse;


public interface EntityService {

	boolean storeInfo(Deployment deployment);
	boolean deleteInfos(Long userId);
	boolean deleteInfo(Request request);
	boolean updateInfo(Deployment deployment, Request request);
	List<DeploymentSuccessResponse> getDeploymentInfo(Long userId);
	List<Deployment> getDeployments(Long userId);
    DeploymentSuccessResponse getDeployInfo(Request request);	
    Deployment getDeployInfo(String liveUrl);
    
    
    
}
