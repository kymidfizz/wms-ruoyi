package com.ruoyi.wms.domain.vo;

import com.ruoyi.wms.domain.entity.ArrivedOrderDetail;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import lombok.Data;
import io.github.linpeilie.annotations.AutoMapper;

import java.io.Serializable;
import java.io.Serial;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 【请填写功能名称】视图对象 wms_arrived_order_detail
 *
 * @author BlooD
 * @date 2025-06-24
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = ArrivedOrderDetail.class)
public class ArrivedOrderDetailVo extends BaseOrderDetailVo {

    @Serial
    private static final long serialVersionUID = 1L;

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
