package com.vortexify.brain.serviceClass;

import java.io.IOException;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vortexify.brain.exception.DeploymentFailedException;
import com.vortexify.brain.payloads.DeployRequest;
import com.vortexify.brain.payloads.DeploymentSuccessResponse;
import com.vortexify.brain.payloads.StopRequest;
import com.vortexify.brain.service.DeployService;
import com.vortexify.brain.service.TriggerService;


@Service
public class DeployServiceClass implements DeployService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	private TriggerService triggerService;
	
	
	private Logger log=LoggerFactory.getLogger(DeployServiceClass.class);
	
	
	
	public DeploymentSuccessResponse deploy(DeployRequest request) throws DeploymentFailedException, IOException, InterruptedException {
		
		if (!isPublic(request.getRepoUrl())) throw new DeploymentFailedException("Git Hub Repo may be Private or Can't be Accessed");
		
		triggerService.cloneRepo(request.getRepoUrl());
		triggerService.buildDockerImage("?");  //path needs to be passed
		triggerService.copyImage("?");  //hostName needs to be passed
		triggerService.deployDockerImage("?");  //hostName needs to be passed
		
		
		
		//Needs to use Deployment Entity to save the Data in Database
		

		DeploymentSuccessResponse response=new DeploymentSuccessResponse();
		response.setUserId(request.getUserId());
		response.setCreatedAt(LocalDateTime.now());
		response.setLiveUrl("?");  //needs to be passed
		response.setUpdatedAt(LocalDateTime.now());	
		response.setStatus("?");   //passed through App Constants
		return response;
	}
	
	
	
	
	
	
	//--------------------------------------------------------------------------------------------
	
	private boolean isPublic(String url) {
		ResponseEntity<String> response;
		
		
		try {
			response = restTemplate.getForEntity(url, String.class);
			
		} catch(Exception e) {
			log.error("Exception Occur During Accessing Git Hub Repo", e);
			return false;
			
		}

        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();
            if (responseBody != null && responseBody.contains("\"private\":true")) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
	}






	@Override
	public DeploymentSuccessResponse stop(StopRequest request)
			throws DeploymentFailedException, IOException, InterruptedException {
		
		//need DeploymentService to get the ContainerID here.
		
		
		triggerService.stopContainer("?", "?");  //hostName //containerId need to be passed
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return null;
	}

	
	
	
	
	
	
	
	
	
}
