package com.ruoyi.wms.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.ruoyi.wms.domain.bo.ArrivedOrderDetailBo;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 【请填写功能名称】对象 wms_arrived_order_detail
 *
 * @author BlooD
 * @date 2025-06-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("wms_arrived_order_detail")
@AutoMapper(target = ArrivedOrderDetailBo.class)
public class ArrivedOrderDetail extends BaseOrderDetail {

    @Serial
    private static final long serialVersionUID=1L;

    /**
     * 行号
     */
    private Long rowNo;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 批次
     */
    private String batch;
    /**
     * 到货日期
     */
    private Date arrivedDate;
    /**
     *  货号
     */
    private String artNo;

    /**
     * 采购数量
     */
    private BigDecimal purchaseQuantity;
    /**
     * 入库数量
     */
    private BigDecimal receiptQuantity;
}
