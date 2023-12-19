package org.spring.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.spring.domain.SampleDTO;
import org.spring.domain.TodoDTO;
import org.spring.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import lombok.Data;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	

	
	@RequestMapping("")
	public void basic() {
		log.info("basic");
	}

	@GetMapping("/basicOnlyGet")
	public void basicGet() {
		log.info("basicGet");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
	    log.info(dto.getName());
	  
	    return "ex01";
	}	
	
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name,@RequestParam("age") int age) {
	    log.info("name: " + name);
	    log.info("age: " + age);
	    return "ex02";
	}
	
	//리스트 겟방식 불가
	@GetMapping("/ex02PL")
	public String ex02PL(@RequestParam("n") ArrayList<String> chk) {
		for(String c : chk) log.info(c);
		return "ex02List";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("chk") ArrayList<String> chk) {
		for(String c : chk) log.info(c);
		return "ex02List";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info(todo);
		return "ex03";
	}
	@GetMapping("/ex04")
	public void ex04() {
		log.info("ex04");
		
	}
	@RequestMapping("/uploadForm")
	public String uploadForm() {
	    return "uploadForm";
	}
	

	
	@PostMapping("/uploadFiles")
	public String uploadFiles(@RequestParam("files") List<MultipartFile> files) {
	    try {
	        for (MultipartFile file : files) {
	            if (!file.isEmpty()) {
	                byte[] bytes = file.getBytes();
	                // 파일 저장 로직을 여기에 추가
	                String savePath = "C:\\uploads"; // 파일을 저장할 디렉터리 경로
	                String originalFilename = file.getOriginalFilename();
	                
	                // 충돌을 방지하기 위해 고유한 파일 이름 생성
	                String fileName = System.currentTimeMillis() + "_" + UUID.randomUUID().toString() +
	                        getExtension(originalFilename);
	                
	                String filePath = savePath + File.separator + fileName;

	                // 파일을 쓸 때 UTF-8 인코딩을 사용하여 한글 문자를 올바르게 처리
	                Files.write(Paths.get(filePath), bytes, StandardOpenOption.CREATE);

	                System.out.println("File Path: " + filePath);
	            }
	        }

	        return "uploadSuccess";
	    } catch (IOException e) {
	        e.printStackTrace();
	        return "uploadFailure";
	    }
	}

	// 파일 확장자 추출을 위한 도우미 메서드
	private String getExtension(String filename) {
	    int dotIndex = filename.lastIndexOf('.');
	    return (dotIndex == -1) ? "" : filename.substring(dotIndex);
	}

}
