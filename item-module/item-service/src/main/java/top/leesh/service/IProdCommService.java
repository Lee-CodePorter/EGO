package top.leesh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import top.leesh.pojo.ProdComm;
import top.leesh.vo.PageParam;
import top.leesh.vo.ProdCommListVo;
import top.leesh.vo.ProdCommVo;

import java.util.List;

/**
 * <p>
 * 商品评论 服务类
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
public interface IProdCommService extends IService<ProdComm> {


    IPage<ProdComm> getPage(Page<ProdComm> commPage, ProdComm comm);

    /**
     *@Description //TODO    获取商品的评论
     *@Param [prodId]
     *@Return java.util.List<top.leesh.vo.ProdCommVo>
     */
    ProdCommVo getProdCommById(Integer prodId);



    /**
     *@Description //TODO    查询评论详情
     *@Param [prodId, evaluate]
     *@Return java.util.List<top.leesh.vo.ProdCommListVo>
     */
    PageParam<ProdCommListVo> getProdCommList(Page<ProdComm> page, Integer prodId, Integer evaluate);
}
