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
	
	@Autowired
	private EntityService entityService;

	@Override
	public boolean cloneRepo(String url) throws DeploymentFailedException ,IOException, InterruptedException {
	    StringBuilder errorOutput = new StringBuilder();
		
		String pythonScriptPath = "scripts/?.py"; 
	        List<String> command = new ArrayList<>();
	        
	        command.add("python"); 
	        command.add(pythonScriptPath);
	        command.add(url); // Add arguments

	        
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
	public boolean buildDockerImage(String path) throws DeploymentFailedException, IOException, InterruptedException {
	    StringBuilder errorOutput = new StringBuilder();
		
		String pythonScriptPath = "scripts/?.py"; 
	        List<String> command = new ArrayList<>();
	        
	        command.add("python"); 
	        command.add(pythonScriptPath);
	        command.add(path); // Add arguments

	        
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
	public boolean deployDockerImage(String hostName,Long userId) throws DeploymentFailedException, IOException, InterruptedException {
	    StringBuilder errorOutput = new StringBuilder();
		
		String pythonScriptPath = "scripts/?.py"; 
	        List<String> command = new ArrayList<>();
	        
	        command.add("python"); 
	        command.add(pythonScriptPath);
	        command.add(hostName); // Add arguments

	        
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
	            	log.info("Deploy script script excuted....");
	            	
	            	
	            	deploymentInfoDeployment.setContainerIp("?");  //set container id
	            	deploymentInfoDeployment.setContainerPort("?");  //set container port
	            	deploymentInfoDeployment.setLiveUrl("?");   //set live url
	            	deploymentInfoDeployment.setStatus(AppConstants.DEPLOYMENTSTATUS.SUCCESS.toString());
	            	deploymentInfoDeployment.setCreatedAt(LocalDateTime.now());
	            	deploymentInfoDeployment.setUpdatedAt(LocalDateTime.now());
	            	deploymentInfoDeployment.setUserId(userId);
	            	deploymentInfoDeployment.setProjectName("");  //needs to be set
	            	entityService.storeInfo(deploymentInfoDeployment);
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
		            	entityService.storeInfo(deploymentInfoDeployment);
	            	throw new DeploymentFailedException(errorOutput.toString());
	            }
	}

	@Override
	public boolean copyImage(String hostName)
			throws DeploymentFailedException, InterruptedException, IOException {
	    StringBuilder errorOutput = new StringBuilder();
		
		String pythonScriptPath = "scripts/?.py"; 
	        List<String> command = new ArrayList<>();
	        
	        command.add("python"); 
	        command.add(pythonScriptPath);
	        command.add(hostName); // Add arguments
	       

	        
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
	            	log.info("Run Container script script excuted....");
	                return true;  
	            } else {
	            	 log.error("Run Container script failed with exit code {}. Error output: {}", exitCode, errorOutput.toString());
	            	throw new DeploymentFailedException(errorOutput.toString());
	            }
	}

	@Override
	public boolean stopContainer(String hostName, String containerId)
			throws DeploymentFailedException, InterruptedException, IOException {
	    StringBuilder errorOutput = new StringBuilder();
		
		String pythonScriptPath = "scripts/?.py"; 
	        List<String> command = new ArrayList<>();
	        
	        command.add("python"); 
	        command.add(pythonScriptPath);
	        command.add(hostName); // Add arguments
	        command.add(containerId);

	        
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
	public boolean removeImage(String hostName, String containerId)
			throws DeploymentFailedException, InterruptedException, IOException {
	    StringBuilder errorOutput = new StringBuilder();
		
		String pythonScriptPath = "scripts/?.py"; 
	        List<String> command = new ArrayList<>();
	        
	        command.add("python"); 
	        command.add(pythonScriptPath);
	        command.add(hostName); // Add arguments
	        command.add(containerId);

	        
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
