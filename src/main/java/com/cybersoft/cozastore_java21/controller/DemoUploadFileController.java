package com.cybersoft.cozastore_java21.controller;

import com.cybersoft.cozastore_java21.exception.CustomFileNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/demo")
public class DemoUploadFileController {
    // Path: Chứa toàn bộ hàm hỗ trợ sẵn liên quan tới đường dẫn
    @Value("${path.root}")
    private String spath;

    @PostMapping("/uploadfile")
    public ResponseEntity<?> uploadFile(@RequestParam MultipartFile file) {
        //Định nghĩa đường dẫn
        Path rootPath = Paths.get(spath);
        try {
            if (!Files.exists(rootPath)) {
                //Tạo folder ứng với đường dẫn nếu không tồn tại
                Files.createDirectories(rootPath);
            }
            ///Users/Bach\'s\ WorkSpace/Java21/image21/abc.jpg
            // resolve <==> /
//            file.getOriginalFilename() : Lấy tên file và định dạng
            String fileName = file.getOriginalFilename();
            Files.copy(file.getInputStream(),
                    rootPath.resolve(fileName),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.out.println("Lỗi " + e.getLocalizedMessage());
        }
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/{filename}")
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        try {
            //Đường dẫn folder root lưu hình
            Path rootPath = Paths.get(spath);
            Resource resource = new UrlResource(rootPath.resolve(filename).toUri());
            if (resource.exists()) {
                //Nếu tồn tại thì mới cho phép download
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                //khi ném exception thì code sẽ dừng và quăng ra lỗi
                throw new CustomFileNotFoundException(200,"File not found");

            }
        } catch (Exception e) {
            throw new CustomFileNotFoundException(200,"File not found");
        }
    }
}
