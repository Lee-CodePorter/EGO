package top.leesh.vo;

import lombok.Data;

/**
 * @author 李书涵  添加购物车的扩展类
 * @package_name: top.leesh.vo
 * @createdate 2019/8/15 14:52
 */
@Data
public class ItemVo
{
  private String basketId;
  private String count;
  private String prodId;
  private String shopId;
  private String skuId;
}
