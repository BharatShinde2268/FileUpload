package com.main.helper;

import java.io.File;
//import java.io.FileOutputStream;
//import java.io.InputStream;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUpload {

	

	public final String UPLOADDIR="F:\\fileUpload\\fileUpload\\src\\main\\resources\\static\\image";
	
	public boolean uploadFile(MultipartFile multi)
	{
		boolean f=false;
		
		try {
			
			// old formula 
			
//			InputStream in = multi.getInputStream();
//			byte data[] = new byte[in.available()];
//			in.read(data);
//			// write
//			
//			FileOutputStream out=new FileOutputStream(UPLOADDIR+File.separator+multi.getOriginalFilename());
//			out.write(data);
//			out.flush();
//			out.close();
			
			//Files.copy
			
			Files.copy(multi.getInputStream(), Paths.get(UPLOADDIR+File.separator+multi.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			f=true;

			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
	}
	
}
