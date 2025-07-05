package com.ruoyi.wms.domain.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.wms.domain.entity.ArrivedOrder;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import com.ruoyi.wms.domain.entity.BaseOrder;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.github.linpeilie.annotations.AutoMapper;

import java.util.Date;


/**
 * 【请填写功能名称】业务对象 wms_arrived_order
 *
 * @author BlooD
 * @date 2025-06-23
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = ArrivedOrder.class)
public class ArrivedOrderBo extends BaseOrderBo<ArrivedOrderDetailBo> {

    /**
     * 供应商id
     */
    @NotNull(message = "供应商不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long merchantId;

    /**
     * 采购日期
     */
    @NotNull(message = "到货日期不能为空", groups = { AddGroup.class, EditGroup.class })
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date arrivedDate;


    /**
     * 采购类型
     */
    @NotNull(message = "到货类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long optType;

    private Integer flag;
}
