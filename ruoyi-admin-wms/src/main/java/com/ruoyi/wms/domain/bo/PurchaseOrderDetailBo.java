package com.ruoyi.wms.domain.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.wms.domain.entity.Inventory;
import com.ruoyi.wms.domain.entity.PurchaseOrderDetail;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @version 1.0
 * @ ClassName PurchaseOrderDetailBo
 * @ author BlooD
 * @ Date 2025-06-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMappers({
    @AutoMapper(target = PurchaseOrderDetail.class, reverseConvertGenerate = false),
    @AutoMapper(target = Inventory.class, reverseConvertGenerate = false)
})
public class PurchaseOrderDetailBo extends BaseOrderDetailBo{

    /**
     * 预计到货日期
     */
    @NotNull(message = "预计到货日期不能为空", groups = { AddGroup.class, EditGroup.class })
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date arrivedPlanDate;

    /**
     *  货号
     */
    private String artNo;


    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 批次
     */
    private String batch;

    private Integer isDelete;

}
