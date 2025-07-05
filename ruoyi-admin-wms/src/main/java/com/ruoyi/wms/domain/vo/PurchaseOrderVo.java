package com.ruoyi.wms.domain.vo;


import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.system.domain.entity.SysDept;
import com.ruoyi.system.domain.vo.SysDeptVo;
import com.ruoyi.system.domain.vo.SysUserVo;
import com.ruoyi.wms.domain.entity.BaseOrder;
import com.ruoyi.wms.domain.entity.PurchaseOrder;
import com.ruoyi.wms.domain.entity.ReceiptOrder;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 采购订单
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ExcelIgnoreUnannotated
@AutoMapper(target = PurchaseOrder.class)
public class PurchaseOrderVo extends BaseOrderVo<PurchaseOrderDetailVo> {

    /**
     * 采购类型
     */
    private Long optType;

    /**
     * 供应商
     */
    private Long merchantId;

    /**
     * 业务订单号
     */
    private String bizOrderNo;

    /**
     * 采购日期
     */
    private Date purchaseDate;

    /**
     * 0:禁用 1:正常
     */
    private Integer isDelete;

    /**
     * 采购员
     */
    private SysUserVo sysUserVo;

    /**
     * 采购部门
     */
    private SysDeptVo sysDeptVo;


    private List<PurchaseOrderDetailVo> details;
}
