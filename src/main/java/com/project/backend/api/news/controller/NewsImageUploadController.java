package com.project.backend.api.news.controller;

import com.project.backend.api.common.ImageBase64Transfer;
import com.project.backend.api.news.error.NewsErrorCode;
import com.project.backend.api.news.model.domain.NewsImage;
import com.project.backend.api.news.model.dto.ImageOutputDTO;
import com.project.backend.api.news.service.INewsImageUploadService;
import com.project.backend.api.user.model.dto.MemberSession;
import com.project.backend.config.exception.InternalServerErrorException;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.net.URI;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RestControllerAdvice
@RequestMapping("/api")
@RequiredArgsConstructor
public class NewsImageUploadController {

    @Value("${spring.servlet.multipart.location}")
    private String fileUploadPath;
    @Value("${server.port}")
    private String port;

    private final INewsImageUploadService imageUploadService;
    /**
     * 업로드된 서버의 이미지 url을 전달해준다.
     * @return
     */
    @Transactional
    @PostMapping("/news/saveNewsImage")
    public ImageOutputDTO uploadImage(@RequestPart("files") List<MultipartFile> files, @RequestParam("member") String sessionStr){
        File uploadFile = null;
        Long imageId;
        try{
            MemberSession session = new MemberSession().convertMemberSession(sessionStr);



            MultipartFile file = files.get(0);
            String originName = file.getOriginalFilename();
            String fileExtension = originName.substring(originName.lastIndexOf(".") + 1); // ex) jpg

            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
            String time = sf.format(new Timestamp(System.currentTimeMillis()));
            String saveFileName = time + "-newsImage."+fileExtension; //파일명.확장자

            uploadFile = new File(fileUploadPath);

            if(!uploadFile.exists()){
                uploadFile.mkdirs();    //설정된 경로까지의 모든 dir을 만들어준다.
            }
            uploadFile = new File(fileUploadPath + saveFileName);
            file.transferTo(uploadFile);

            NewsImage image = NewsImage.builder()
                    .path(fileUploadPath)
                    .originImgNm(originName)
                    .saveImgNm(saveFileName)
                    .inputId(session.getId())
                    .build();

            //DB insert
            imageId = imageUploadService.saveImage(image);


        }catch(Exception e){
            e.printStackTrace();
            throw new InternalServerErrorException(NewsErrorCode.IMG_UPLOAD_ERROR);
        }

        ImageOutputDTO out = new ImageOutputDTO("http://localhost:" + port + "/api/news/viewImage/" +  uploadFile.getName(),
                imageId
                );

        return out;
    }



}
