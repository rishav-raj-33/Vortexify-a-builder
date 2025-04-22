package com.vortexify.brain.serviceClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vortexify.brain.config.AppConstants;
import com.vortexify.brain.entity.Deployment;
import com.vortexify.brain.exception.DeploymentFailedException;
import com.vortexify.brain.service.EntityService;
import com.vortexify.brain.service.TriggerService;



@Service
public class TriggerServiceClass implements TriggerService {
	
	private Logger log=LoggerFactory.getLogger(TriggerServiceClass.class);
	
//	@Autowired
//	private EntityService entityService;

	@Override
	public boolean cloneRepo(String url) throws DeploymentFailedException ,IOException, InterruptedException {
	    StringBuilder errorOutput = new StringBuilder();
		
		String pythonScriptPath = AppConstants.SCRIPT_DIR+AppConstants.CLONE_SCRIPT; 
	        List<String> command = new ArrayList<>();
	        
	        command.add("python"); 
	        command.add(pythonScriptPath);
	        command.add(url); 
	        command.add(AppConstants.CLONE_DIR); 

	        
	            ProcessBuilder processBuilder = new ProcessBuilder(command);
	     
	            processBuilder.redirectErrorStream(false);
	            Process process = processBuilder.start();
	            
	            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
	            String line1;
	            while ((line1 = errorReader.readLine()) != null) {
	                errorOutput.append(line1).append("\n");
	            }
	            // Capture output
	            StringBuilder output = new StringBuilder();
	            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
	                String line;
	                while ((line = reader.readLine()) != null) {
	                    output.append(line).append("\n");
	                }   
	            }

	            // Wait for the process to finish
	            int exitCode = process.waitFor();
	            if (exitCode == 0) {
	            	log.info("Clone Repo script excuted....");
	                return true;  
	            } else {
	            	 log.error("Clone Repo script failed with exit code {}. Error output: {}", exitCode, errorOutput.toString());
	            	throw new DeploymentFailedException(errorOutput.toString());
	            }

	        
	        
	        
	}

	@Override
	public boolean buildDockerImage(String name) throws DeploymentFailedException, IOException, InterruptedException {
	    StringBuilder errorOutput = new StringBuilder();
		
		String pythonScriptPath = AppConstants.SCRIPT_DIR+AppConstants.BUILD_DOCKER_SCRIPT; 
	        List<String> command = new ArrayList<>();
	        
	        command.add("python"); 
	        command.add(pythonScriptPath);
	        command.add(AppConstants.CLONE_DIR+name);
	        command.add(AppConstants.TAR_DIR); 
	        command.add(name); 

	        
	            ProcessBuilder processBuilder = new ProcessBuilder(command);
	     
	            processBuilder.redirectErrorStream(false);
	            Process process = processBuilder.start();
	            
	            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
	            String line1;
	            while ((line1 = errorReader.readLine()) != null) {
	                errorOutput.append(line1).append("\n");
	            }
	            // Capture output
	            StringBuilder output = new StringBuilder();
	            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
	                String line;
	                while ((line = reader.readLine()) != null) {
	                    output.append(line).append("\n");
	                }   
	            }

	            // Wait for the process to finish
	            int exitCode = process.waitFor();
	            if (exitCode == 0) {
	            	log.info("Build Docker Image script excuted....");
	                return true;  
	            } else {
	            	 log.error("Build Docker Image script failed with exit code {}. Error output: {}", exitCode, errorOutput.toString());
	            	throw new DeploymentFailedException(errorOutput.toString());
	            }
	}

	@Override
	public boolean deployDockerImage(String name,Long userId) throws DeploymentFailedException, IOException, InterruptedException {
	    StringBuilder errorOutput = new StringBuilder();
		
		String pythonScriptPath = AppConstants.SCRIPT_DIR+AppConstants.DEPLOY_SCRIPT; 
	        List<String> command = new ArrayList<>();
	        
	        command.add("python"); 
	        command.add(pythonScriptPath);
	        command.add(AppConstants.TAR_DIR+name+".tar"); 
	        command.add(name); 
	        command.add(AppConstants.HOSTNAME); 
	        command.add(AppConstants.USER_NAME);
	        command.add(AppConstants.PASSWORD);

	        
	            ProcessBuilder processBuilder = new ProcessBuilder(command);
	     
	            processBuilder.redirectErrorStream(false);
	            Process process = processBuilder.start();
	            
	            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
	            String line1;
	            while ((line1 = errorReader.readLine()) != null) {
	                errorOutput.append(line1).append("\n");
	            }
	            // Capture output
	            StringBuilder output = new StringBuilder();
	            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
	                String line;
	                while ((line = reader.readLine()) != null) {
	                    output.append(line).append("\n");
	                }   
	            }
	            
	            Deployment deploymentInfoDeployment=new Deployment();

	            // Wait for the process to finish
	            int exitCode = process.waitFor();
	            if (exitCode == 0) {
	            	log.info("Deploy script script excuted...."+output);
	            	
	            	
	            	deploymentInfoDeployment.setContainerIp("?");  //set container id
	            	deploymentInfoDeployment.setContainerPort("?");  //set container port
	            	deploymentInfoDeployment.setLiveUrl("?");   //set live url
	            	deploymentInfoDeployment.setStatus(AppConstants.DEPLOYMENTSTATUS.SUCCESS.toString());
	            	deploymentInfoDeployment.setCreatedAt(LocalDateTime.now());
	            	deploymentInfoDeployment.setUpdatedAt(LocalDateTime.now());
	            	deploymentInfoDeployment.setUserId(userId);
	            	deploymentInfoDeployment.setProjectName(name);  
//	            	entityService.storeInfo(deploymentInfoDeployment);
	                return true;  
	            } else {
	            	 log.error("Deploy script failed with exit code {}. Error output: {}", exitCode, errorOutput.toString());
		            	deploymentInfoDeployment.setContainerIp(null);  //set container id
		            	deploymentInfoDeployment.setContainerPort(null);  //set container port
		            	deploymentInfoDeployment.setLiveUrl(null);   //set live url
		            	deploymentInfoDeployment.setStatus(AppConstants.DEPLOYMENTSTATUS.FAILED.toString());
		            	deploymentInfoDeployment.setCreatedAt(LocalDateTime.now());
		            	deploymentInfoDeployment.setUpdatedAt(LocalDateTime.now());
		            	deploymentInfoDeployment.setUserId(userId);
//		            	entityService.storeInfo(deploymentInfoDeployment);
	            	throw new DeploymentFailedException(errorOutput.toString());
	            }
	}


	

	@Override
	public boolean stopContainer(String containerId)
			throws DeploymentFailedException, InterruptedException, IOException {
	    StringBuilder errorOutput = new StringBuilder();
		
		String pythonScriptPath = AppConstants.SCRIPT_DIR+AppConstants.STOP_SCRIPT; 
	        List<String> command = new ArrayList<>();
	        
	        command.add("python"); 
	        command.add(pythonScriptPath);
	        command.add(containerId);
	        command.add(AppConstants.HOSTNAME); 
	        command.add(AppConstants.USER_NAME);
	        command.add(AppConstants.PASSWORD);

	        
	            ProcessBuilder processBuilder = new ProcessBuilder(command);
	     
	            processBuilder.redirectErrorStream(false);
	            Process process = processBuilder.start();
	            
	            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
	            String line1;
	            while ((line1 = errorReader.readLine()) != null) {
	                errorOutput.append(line1).append("\n");
	            }
	            // Capture output
	            StringBuilder output = new StringBuilder();
	            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
	                String line;
	                while ((line = reader.readLine()) != null) {
	                    output.append(line).append("\n");
	                }   
	            }

	            // Wait for the process to finish
	            int exitCode = process.waitFor();
	            if (exitCode == 0) {
	            	log.info("Stop Container script script excuted....");
	                return true;  
	            } else {
	            	 log.error("Stop Container script failed with exit code {}. Error output: {}", exitCode, errorOutput.toString());
	            	throw new DeploymentFailedException(errorOutput.toString());
	            }
	}

	@Override
	public boolean removeImage(String imageId, String containerId)
			throws DeploymentFailedException, InterruptedException, IOException {
	    StringBuilder errorOutput = new StringBuilder();
		
		String pythonScriptPath = AppConstants.SCRIPT_DIR+AppConstants.REMOVE_DEPLOY_SCRIPT;; 
	        List<String> command = new ArrayList<>();
	        
	        command.add("python"); 
	        command.add(pythonScriptPath);
	        command.add(containerId);
	        command.add(imageId); 
	        command.add(AppConstants.HOSTNAME);
	        command.add(AppConstants.USER_NAME);
	        command.add(AppConstants.PASSWORD);

	        
	            ProcessBuilder processBuilder = new ProcessBuilder(command);
	     
	            processBuilder.redirectErrorStream(false);
	            Process process = processBuilder.start();
	            
	            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
	            String line1;
	            while ((line1 = errorReader.readLine()) != null) {
	                errorOutput.append(line1).append("\n");
	            }
	            // Capture output
	            StringBuilder output = new StringBuilder();
	            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
	                String line;
	                while ((line = reader.readLine()) != null) {
	                    output.append(line).append("\n");
	                }   
	            }

	            // Wait for the process to finish
	            int exitCode = process.waitFor();
	            if (exitCode == 0) {
	            	log.info("Remove Image script script excuted....");
	                return true;  
	            } else {
	            	 log.error("Remove Image script failed with exit code {}. Error output: {}", exitCode, errorOutput.toString());
	            	throw new DeploymentFailedException(errorOutput.toString());
	            }
	}



}
