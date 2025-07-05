package com.ruoyi.wms.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.wms.domain.entity.BaseOrderDetail;
import com.ruoyi.wms.domain.entity.PurchaseOrderDetail;
import com.ruoyi.wms.domain.entity.ReceiptOrderDetail;
import com.ruoyi.wms.enums.ArrivedStatus;
import com.ruoyi.wms.enums.ReceiptStatus;
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
@ExcelIgnoreUnannotated
@AutoMapper(target = PurchaseOrderDetail.class)
public class PurchaseOrderDetailVo extends BaseOrderDetailVo {

    /**
     * 到货数量
     */
    private BigDecimal arrivedQuantity;

    /**
     * 入库数量
     */
    private BigDecimal receiptQuantity;

    /**
     * 到货状态
     */
    private ArrivedStatus arrivedStatus;

    /**
     * 入库状态
     */
    private ReceiptStatus receiptStatus;

    /**
     * 预计到货日期
     */
    private Date arrivedPlanDate;

    /**
     * 单价
     */
    private BigDecimal price;


    /**
     * 批次
     */
    private String batch;

    /**
     *  货号
     */
    private String artNo;
}
