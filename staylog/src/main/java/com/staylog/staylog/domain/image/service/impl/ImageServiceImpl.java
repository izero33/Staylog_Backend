package com.staylog.staylog.domain.image.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.staylog.staylog.domain.image.dto.request.ImageLoadRequest;
import com.staylog.staylog.domain.image.dto.request.ImageUploadRequest;
import com.staylog.staylog.domain.image.service.ImageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService{
	
	@Value("${file.image-location}")
	private String filePath;
	
	@Override
	public void saveImage(ImageUploadRequest uploadRes) {
		
		
	}

	@Override
	public void loadImage(ImageLoadRequest loadRes) {
		
		
	}

}
