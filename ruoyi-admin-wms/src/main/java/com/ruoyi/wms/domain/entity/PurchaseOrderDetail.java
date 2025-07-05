package com.ruoyi.wms.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.wms.domain.bo.PurchaseOrderBo;
import com.ruoyi.wms.domain.bo.PurchaseOrderDetailBo;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @version 1.0
 * @ ClassName PurchaseOrderDetail
 * @ author BlooD
 * @ Date 2025-06-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("wms_purchase_order_detail")
@AutoMapper(target = PurchaseOrderDetailBo.class)
public class PurchaseOrderDetail extends BaseOrderDetail{

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 批次
     */
    private String batch;

    /**
     * 预计到货日期
     */
    private Date arrivedPlanDate;

    /**
     *  货号
     */
    private String artNo;

    /**
     * 行号
     */
    private int rowNo;

    /**
     * 到货数量
     */
    private BigDecimal arrivedQuantity;

    /**
     * 入库数量
     */
    private BigDecimal receiptQuantity;

    /**
     * 仓库id
     */
    private Long warehouseId;

    private Integer isDelete;
}
