package com.ruoyi.wms.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import com.ruoyi.wms.domain.vo.ItemBrandVo;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.io.Serial;

/**
 * 商品品牌对象 wms_item_brand
 *
 * @author zcc
 * @date 2024-07-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("wms_item_brand")
@AutoMapper(target = ItemBrandVo.class)
public class ItemBrand extends BaseEntity {

    @Serial
    private static final long serialVersionUID=1L;

    /**
     *
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 品牌名称
     */
    private String brandName;

}
