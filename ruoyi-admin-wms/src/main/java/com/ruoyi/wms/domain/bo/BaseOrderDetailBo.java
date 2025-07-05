package com.ruoyi.wms.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.DeleteGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseOrderDetailBo extends BaseEntity {

    /**
     * 行号
     */
    @NotNull(message = "行号不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long rowNo;

    /**
     * 入库单号
     */
    @NotNull(message = "单号不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long orderId;
    /**
     *
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class, DeleteGroup.class})
    private Long id;

    /**
     * 规格id
     */
    @NotNull(message = "规格id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long skuId;

    /**
     * 入库数量
     */
    @NotNull(message = "数量不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal quantity;

    /**
     * 批次
     */
    private String batch;

    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 备注
     */
    private String remark;

    /**
     * 所属仓库
     */
    private Long warehouseId;

    /**
     * 更新前数量
     */
    private BigDecimal beforeQuantity;
    /**
     * 更新后数量
     */
    private BigDecimal afterQuantity;
}
