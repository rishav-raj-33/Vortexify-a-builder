package com.vortexify.brain.serviceClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import org.springframework.stereotype.Service;

import com.vortexify.brain.config.AppConstants;
import com.vortexify.brain.service.FileService;



@Service
public class FileServiceClass implements FileService {

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
		  Path directory = Paths.get(folderPath);

	        if (Files.notExists(directory)) {
	            System.out.println("Directory does not exist: " + folderPath);
	            return false;
	        }

	        Files.walkFileTree(directory, new SimpleFileVisitor<>() {
	            @Override
	            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
	                    throws IOException {
	                Files.delete(file);
	                return FileVisitResult.CONTINUE;
	            }

	            @Override
	            public FileVisitResult postVisitDirectory(Path dir, IOException exc)
	                    throws IOException {
	                Files.delete(dir);
	                return FileVisitResult.CONTINUE;
	            }
	        });
	        
	        return true;
	}

}
