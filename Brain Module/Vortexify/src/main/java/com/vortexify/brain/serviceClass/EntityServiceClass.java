package com.vortexify.brain.serviceClass;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vortexify.brain.entity.Deployment;
import com.vortexify.brain.payloads.Request;
import com.vortexify.brain.payloads.DeploymentSuccessResponse;
import com.vortexify.brain.repo.DeployRepo;
import com.vortexify.brain.service.EntityService;

@Service
public class EntityServiceClass implements EntityService {
	
	@Autowired
	private DeployRepo deployRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public boolean storeInfo(Deployment deployment) {
		deployRepo.save(deployment);
		return true;
	}

	@Override
	public boolean deleteInfo(Request stopRequest) {
		List<Deployment> deployment=deployRepo.findByUserId(stopRequest.getUserId());
		deployRepo.deleteAll(deployment);
		return true;
	}

	//pending.....
	
	@Override
	public boolean updateInfo(Deployment deployment, Request request) {
		//Deployment getDeployment=deployRepo.findByLiveUrl(request.getLiveUrl());
		
		
		
		
		
		return false;
	}

	
	//Pagination Pending...
	
	@Override
	public List<DeploymentSuccessResponse> getDeploymentInfo(Long userId) {
		
		List<Deployment> list=deployRepo.findByUserId(userId);
		List<DeploymentSuccessResponse> list2=list.stream().map((obj)->modelMapper.map(obj, DeploymentSuccessResponse.class)).toList();
		return list2;
	}

	@Override
	public DeploymentSuccessResponse getDeployInfo(Request request) {
		
		Deployment getDeploymentInfo=deployRepo.findByLiveUrl(request.getUrl());
		
		DeploymentSuccessResponse response=new DeploymentSuccessResponse();
		response.setUserId(getDeploymentInfo.getUserId());
		response.setLiveUrl(getDeploymentInfo.getLiveUrl());
		response.setStatus(getDeploymentInfo.getStatus());
		response.setCreatedAt(getDeploymentInfo.getCreatedAt());
		response.setUpdatedAt(getDeploymentInfo.getUpdatedAt());
		return response;
	}
	
	
	
	

}
