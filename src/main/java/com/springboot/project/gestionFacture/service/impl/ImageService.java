package com.springboot.project.gestionFacture.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import com.springboot.project.gestionFacture.entity.User;

public class ImageService {
	public static User setAvatarUser(User user) {
		if(user.getAvatar()!=null) {
			user.setAvatar(decompressBytes(user.getAvatar()));
		}
		return user;
	}
	
	 public static byte[] compressBytes(byte[] data) {
	        Deflater deflater = new Deflater();
	        deflater.setInput(data);
	        deflater.finish();
	        System.out.println("img initial length:===>"+data.length);
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
	        byte[] buffer = new byte[500];
	        while (!deflater.finished()) {
	            int count = deflater.deflate(buffer);
	            outputStream.write(buffer, 0, count);
	        }
	        try {
	            outputStream.close();
	        } catch (IOException e) {
	        }
	        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
	        return outputStream.toByteArray();
	    }
	    // uncompress the image bytes before returning it to the angular application

	    public static byte[] decompressBytes(byte[] data) {
	        Inflater inflater = new Inflater();
	        inflater.setInput(data);
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
	        byte[] buffer = new byte[1024];
	        try {
	            while (!inflater.finished()) {
	                int count = inflater.inflate(buffer);
	                outputStream.write(buffer, 0, count);
	            }
	            outputStream.close();
	        } catch (IOException ioe) {
	        } catch (DataFormatException e) {
	        }
	        return outputStream.toByteArray();
	    }
	    public static List<User> decompressUserAvatar(List<User> users){
	    	List<User> fUsers=new ArrayList<User>();
	    	for(User user:users) {
	    		if(user.getAvatar()!=null) {
					user.setAvatar(ImageService.decompressBytes(user.getAvatar()));
				}
	    		fUsers.add(user);
	    	}
	    	return fUsers;
	    }
}
