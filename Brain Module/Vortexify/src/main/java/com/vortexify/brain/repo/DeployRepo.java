package com.vortexify.brain.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vortexify.brain.entity.Deployment;

public interface DeployRepo extends JpaRepository<Deployment, Long> {
	
	Deployment findByLiveUrl(String liveUrl);
	List<Deployment>  findByUserId(Long userId);
	
	
	
	

}
