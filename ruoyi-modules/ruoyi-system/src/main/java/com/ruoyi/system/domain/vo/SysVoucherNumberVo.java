package com.ruoyi.system.domain.vo;

import com.ruoyi.system.domain.entity.SysVoucherNumber;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.excel.annotation.ExcelDictFormat;
import com.ruoyi.common.excel.convert.ExcelDictConvert;
import lombok.Data;
import io.github.linpeilie.annotations.AutoMapper;

import java.io.Serializable;
import java.io.Serial;

/**
 * 【请填写功能名称】视图对象 sys_voucher_number
 *
 * @author ${author}
 * @date 2025-07-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = SysVoucherNumber.class)
public class SysVoucherNumberVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer size;
    private Integer rule;
    private Integer number;
    private String voucherCode;
}
