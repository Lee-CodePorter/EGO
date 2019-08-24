package top.leesh.test;

import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;

/**
 * @author 李书涵
 * @package_name: top.leesh.test
 * @createdate 2019/7/31 16:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileUpload
{
    @Autowired
    private FastFileStorageClient client;

    @Test
    public  void upload()
    {
        File file=null;
        try {
           file=new File("D://1.JPG");
        }
        catch (Exception e)
        {
            System.out.println("文件错误");
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            StorePath storePath = client.uploadFile(fileInputStream, file.length(), "jpg", new HashSet<MetaData>());
            System.out.println(storePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
