package com.aurionpro.bankapp.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;

import io.jsonwebtoken.io.IOException;

import java.util.Map;

@Service
public class CloudServiceImpl implements CloudService {

	@Autowired
	private Cloudinary cloudinary;

	@Override
	public String uploadFile(MultipartFile file, String folderName) {
		try {
            HashMap<Object, Object> options = new HashMap<>();
            options.put("folder", folderName);
            Map uploadedFile = null;
			try {
				uploadedFile = cloudinary.uploader().upload(file.getBytes(), options);
			} catch (java.io.IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            String publicId = (String) uploadedFile.get("public_id");
            return cloudinary.url().secure(true).generate(publicId);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
	}
	
}
