package com.vortexify.brain.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vortexify.brain.entity.Deployment;

public interface DeployRepo extends JpaRepository<Deployment, Long> {

}
