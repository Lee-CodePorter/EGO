package top.leesh.controller;

import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import top.leesh.pojo.AttachFile;
import top.leesh.service.IAttachFileService;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;

/**
 * @author 李书涵
 * 文件类控制器
 * @package_name: top.leesh.controller
 * @createdate 2019/8/1 19:18
 */
public class FileController
{
    @Autowired
    private FastFileStorageClient fastFileStorageClient;


    @Autowired
    private IAttachFileService attachFileService;


//    @GetMapping("/getimg")
    @PostMapping("/admin/file/upload/element")
    //上传商品图片
    public  Object uploadImage(MultipartFile file)
    {
        int indexOf = file.getOriginalFilename().lastIndexOf(".");
        String fileName = file.getOriginalFilename().substring(indexOf + 1);

        String path="";
        try
        {
            StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), fileName, new HashSet<MetaData>());
            String group = storePath.getGroup();
            //组+文件名称
            path=storePath.getFullPath();

            System.out.println(storePath.getFullPath());

            AttachFile attachFile = new AttachFile();
            attachFile.setFileType(fileName);
            attachFile.setFilePath(path);
            attachFile.setFileSize(Long.valueOf(file.getSize()).intValue());
            attachFile.setUploadTime(LocalDateTime.now());
            attachFileService.save(attachFile);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return  path;
    }


//    public static void main(String[] args)
//    {
//        BigDecimal bigDecimal = new BigDecimal(6);
//
//        BigDecimal divide = bigDecimal.divide(new BigDecimal(3));
//        System.out.println(divide);
//    }


}
