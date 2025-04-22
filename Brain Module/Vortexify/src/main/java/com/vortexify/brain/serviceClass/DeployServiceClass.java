package com.vortexify.brain.serviceClass;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vortexify.brain.config.AppConstants;
import com.vortexify.brain.entity.Deployment;
import com.vortexify.brain.exception.DeploymentFailedException;
import com.vortexify.brain.payloads.Request;
import com.vortexify.brain.payloads.DeploymentSuccessResponse;
import com.vortexify.brain.service.DeployService;
import com.vortexify.brain.service.EntityService;
import com.vortexify.brain.service.FileService;
import com.vortexify.brain.service.TriggerService;


@Service
public class DeployServiceClass implements DeployService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private TriggerService triggerService;
	@Autowired
	private EntityService entityService;
	
	@Autowired
	private FileService fileService;
	
	private Logger log=LoggerFactory.getLogger(DeployServiceClass.class);
	
	
	
	public DeploymentSuccessResponse deploy(Request request) throws DeploymentFailedException, IOException, InterruptedException {
		
		if (!isPublic(request.getUrl())) throw new DeploymentFailedException("Git Hub Repo may be Private or Can't be Accessed");
		
		String name=generateUniqueImageName();
		
		
		try {
			
			if(triggerService.cloneRepo(request.getUrl(),name))
			     if(triggerService.buildDockerImage(name)) 
			       triggerService.deployDockerImage(name,request.getUserId());
		}finally {
			
			try {
				fileService.deleteFolder(AppConstants.CLONE_DIR+name);
				fileService.deleteLocalFiles(name+".tar");
			} catch (Exception e) {
				e.printStackTrace();
			}	
		} 
	     DeploymentSuccessResponse response=entityService.getDeployInfo(request);
		return response;
	}
	

	@Override
	public DeploymentSuccessResponse stop(Request request)
			throws DeploymentFailedException, IOException, InterruptedException {
		
		
		Deployment deployment=entityService.getDeployInfo(request.getUrl());
		if(triggerService.stopContainer(deployment.getContainerIp())) {
			deployment.setStatus(AppConstants.DEPLOYMENTSTATUS.STOP.toString());
			deployment.setUpdatedAt(LocalDateTime.now());
			this.entityService.storeInfo(deployment);
		}
		DeploymentSuccessResponse response=new DeploymentSuccessResponse();
		response.setCreatedAt(deployment.getCreatedAt());
		response.setLiveUrl(deployment.getLiveUrl());
		response.setStatus(deployment.getStatus());
		response.setUserId(deployment.getUserId());
		response.setUpdatedAt(deployment.getUpdatedAt());
		return response;
	}
	
	
	@Override
	public void remove(Request request) 
			throws DeploymentFailedException, IOException, InterruptedException {
		Deployment deployment=entityService.getDeployInfo(request.getUrl());
		
		if (triggerService.removeImage(deployment.getProjectName(), deployment.getContainerIp())) 
			entityService.deleteInfo(request);
		return;
	}
	
	
	
	@Override
	public boolean removeUser(Long userId) throws DeploymentFailedException, IOException, InterruptedException {
		List<Deployment> deployments=entityService.getDeployments(userId);
		for(int i=0;i<deployments.size();i++) {
			triggerService.removeImage(deployments.get(i).getProjectName(), deployments.get(i).getContainerIp());
		}
		entityService.deleteInfos(userId);
		return true;
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
	
	
	private String generateUniqueImageName() {
		return UUID.randomUUID().toString();
	}




























	
	
	
	
	
	
	
	
	
}
