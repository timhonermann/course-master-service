package ch.hontech.course_master.course.controllers;

import ch.hontech.course_master.course.services.ImageUploadService;
import lombok.RequiredArgsConstructor;
import org.apache.hc.client5.http.entity.mime.MultipartPart;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/image-upload")
public class ImageUploadController {

    private final ImageUploadService imageUploadService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String upload(@RequestParam("file") MultipartFile file) {
        try {
            return imageUploadService.upload(file.getBytes());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
