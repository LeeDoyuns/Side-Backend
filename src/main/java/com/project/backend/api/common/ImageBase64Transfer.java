package com.project.backend.api.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author leedy
 * 로컬 경로에 있는 이미지 파일을 base64로 변환하는 클래스
 */
@Slf4j
public class ImageBase64Transfer {

    public static String transferBase64(String filePath, String fileExtension){
        String result = "";
        File file=  new File(filePath);
        if(file.exists() && file.isFile() && file.length()>0){
            byte[] img = new byte[(int) file.length()];
            FileInputStream fis = null;

            try{
                fis = new FileInputStream(file);
                fis.read(img);
                result = new String(Base64.encodeBase64(img));
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{
                    log.info("file read finally");
                    if(fis != null){
                        fis.close();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }

        //data:image/확장자;base64, 변환 문자열
        return "data:image/" + fileExtension + ";base64, " + result;
    }

}
