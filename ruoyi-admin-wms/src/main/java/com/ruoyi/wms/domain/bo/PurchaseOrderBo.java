package com.ruoyi.wms.domain.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.wms.domain.entity.PurchaseOrder;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.poi.hpsf.Decimal;

import java.util.Date;

/**
 * @version 1.0
 * @ ClassName PurchaseOrderBo
 * @ author BlooD
 * @ Date 2025-06-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = PurchaseOrder.class, reverseConvertGenerate = false)
public class PurchaseOrderBo extends BaseOrderBo<PurchaseOrderDetailBo>{

    /**
     * 供应商id
     */
    @NotNull(message = "供应商不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long merchantId;

    /**
     * 采购日期
     */
    @NotNull(message = "采购日期不能为空", groups = { AddGroup.class, EditGroup.class })
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date purchaseDate;

    /**
     * 采购员
     */
    private Long purchaseUserId;

    /**
     * 采购部门
     */
    private Long deptId;

    /**
     * 采购类型
     */
    @NotNull(message = "采购类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long optType;

    private String bizOrderNo;

    private Integer isDelete;

    private Integer documentStatus;
}
