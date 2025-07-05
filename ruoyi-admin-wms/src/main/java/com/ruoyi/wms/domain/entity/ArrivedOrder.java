    package com.ruoyi.wms.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.wms.domain.bo.ArrivedOrderBo;
import com.ruoyi.wms.domain.bo.PurchaseOrderBo;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @version 1.0
 * @ ClassName ArrivedOrder
 * @ author BlooD
 * @ Date 2025-06-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("wms_arrived_order")
@AutoMapper(target = ArrivedOrderBo.class)
public class ArrivedOrder extends BaseOrder {

    /**
     * 到货类型
     */
    private Long optType;

    /**
     * 业务订单号
     */
    private String bizOrderNo;

    /**
     * 到货日期
     */
    private Date arrivedDate;

    /**
     * 到货拒收单标志 0：到货 1：拒收
     */
    private Integer flag;

    private Long merchantId;

    public ArrivedOrder() {}
    public ArrivedOrder(PurchaseOrderBo bo) {
        this.optType = bo.getOptType();
        this.bizOrderNo = bo.getBizOrderNo();
        this.arrivedDate = DateUtils.getNowDate();
        this.flag = 0;
        this.merchantId = bo.getMerchantId();
        this.setTotalAmount(bo.getTotalAmount());
        this.setTotalQuantity(bo.getTotalQuantity());
    }
}
