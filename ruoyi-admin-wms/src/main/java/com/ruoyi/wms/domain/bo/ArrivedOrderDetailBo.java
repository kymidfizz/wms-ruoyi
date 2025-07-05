package com.ruoyi.wms.domain.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.wms.domain.entity.ArrivedOrderDetail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.github.linpeilie.annotations.AutoMapper;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 业务对象 wms_arrived_order_detail
 *
 * @author BlooD
 * @date 2025-06-24
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = ArrivedOrderDetail.class, reverseConvertGenerate = false)
public class ArrivedOrderDetailBo extends BaseOrderDetailBo {

    /**
     * 所属仓库
     */
    @NotBlank(message = "所属仓库不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long warehouseId;

    /**
     * 批次
     */
    @NotBlank(message = "批次不能为空", groups = { AddGroup.class, EditGroup.class })
    private String batch;

    /**
     * 货号
     */
    private String artNo;

    /**
     * 行号
     */
    private Long rowNo;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 到货日期
     */
    @NotBlank(message = "到货日期不能为空", groups = { AddGroup.class, EditGroup.class })
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date arrivedDate;
}
