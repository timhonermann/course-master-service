package ch.hontech.course_master.course.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ImageUploadService {

    @Value("${hontech.cloudinary.url}")
    private String cloudinaryUrl;

    public String upload(byte[] bytes) throws IOException {
        var cloudinary = new Cloudinary(cloudinaryUrl);
        var uploadParams = ObjectUtils.asMap(
                "eager", List.of(
                        new Transformation().width(400).crop("scale")
                )
        );


        var result = cloudinary.uploader().upload(bytes, uploadParams);
        var eagerList = (List<Map<String, Object>>) result.get("eager");

        return (String) eagerList.get(0).get("url");
    }

}
