package com.vortexify.brain.serviceClass;

import java.io.File;
import java.io.IOException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.vortexify.brain.config.AppConstants;
import com.vortexify.brain.service.FileService;



@Service
public class FileServiceClass implements FileService {
	
	
	
	private Logger log=LoggerFactory.getLogger(FileServiceClass.class);

	@Override
	public boolean deleteLocalFiles(String name) {
		
		String fullPath=AppConstants.TAR_DIR+name;
		File file=new File(fullPath);
		if(file.exists()) {
			file.delete();
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteFolder(String folderPath) throws IOException {
		   File fileOrFolder = new File(folderPath);

	        if (!fileOrFolder.exists()) {
	            log.error("Path does not exist: " + folderPath);
	            return false;
	        }

	        if (fileOrFolder.isDirectory()) {
	            File[] contents = fileOrFolder.listFiles();
	            if (contents != null) {
	                for (File file : contents) {
	                    if (!deleteFolder(file.getAbsolutePath())) {
	                        return false;
	                    }
	                }
	            }
	        }

	        return fileOrFolder.delete();
	}

}
