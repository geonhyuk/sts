package org.spring.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    public void saveFile(MultipartFile file, String destinationDir) throws IOException {
        // 파일이 저장될 경로와 파일명 설정
        File destination = new File(destinationDir + File.separator + file.getOriginalFilename());

        // transferTo 메서드를 사용하여 파일을 저장
        file.transferTo(destination);
    }
}
