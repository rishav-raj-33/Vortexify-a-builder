package com.vortexify.brain.serviceClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vortexify.brain.service.TriggerService;

import jakarta.websocket.DeploymentException;

public class TriggerServiceClass implements TriggerService {
	
	private Logger log=LoggerFactory.getLogger(TriggerServiceClass.class);

	@Override
	public String cloneRepo(String url) {
	    StringBuilder errorOutput = new StringBuilder();
		
		String pythonScriptPath = "scripts/?.py"; 
	        List<String> command = new ArrayList<>();
	        
	        command.add("python"); 
	        command.add(pythonScriptPath);
	        command.add(url); // Add arguments

	        try {
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
	            	log.info("Python script excuted....");
	                return "Python script output:\n" + output.toString();  
	            } else {
	            	 log.error("Python script failed with exit code {}. Error output: {}", exitCode, errorOutput.toString());
	            	throw new DeploymentException(errorOutput.toString());
	            }

	        } catch (Exception e) {
	        	log.error("Exception Occured while Running Python Scripts....");	
	            return "Error running Python script: " + e.getMessage();
	        }
	}

}
