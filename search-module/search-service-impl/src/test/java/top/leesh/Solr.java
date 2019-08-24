package top.leesh;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.leesh.service.SolrDataTra;

/**
 * @author 李书涵
 * @package_name: top.leesh.text
 * @createdate 2019/8/9 21:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Solr
{
    @Autowired
    private SolrDataTra solrDataTra;


    @Test
    public  void inportData()
    {
        solrDataTra.importSolrData();
    }

}
