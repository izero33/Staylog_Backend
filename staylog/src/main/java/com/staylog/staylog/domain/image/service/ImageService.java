package com.staylog.staylog.domain.image.service;

import com.staylog.staylog.domain.image.dto.request.ImageLoadRequest;
import com.staylog.staylog.domain.image.dto.request.ImageUploadRequest;

public interface ImageService {
	
	public void saveImage(ImageUploadRequest uploadRes);
	public void loadImage(ImageLoadRequest loadRes);
	
}
