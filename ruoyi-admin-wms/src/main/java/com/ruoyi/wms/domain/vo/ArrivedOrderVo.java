package com.ruoyi.wms.domain.vo;


import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.excel.annotation.ExcelDictFormat;
import com.ruoyi.common.excel.convert.ExcelDictConvert;
import com.ruoyi.wms.domain.entity.ArrivedOrder;
import lombok.Data;
import io.github.linpeilie.annotations.AutoMapper;

import java.io.Serializable;
import java.io.Serial;
import java.util.Date;

/**
 * 【请填写功能名称】视图对象 wms_arrived_order
 *
 * @author BlooD
 * @date 2025-06-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = ArrivedOrder.class)
public class ArrivedOrderVo extends BaseOrderVo<ArrivedOrderDetailVo> {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 到货类型
     */
    private Long optType;

    /**
     * 到货日期
     */
    private Date arrivedDate;

    /**
     * 供应商
     */
    private Long merchantId;
}
