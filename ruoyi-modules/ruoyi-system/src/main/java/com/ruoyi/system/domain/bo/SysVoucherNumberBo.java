package com.ruoyi.system.domain.bo;

import com.ruoyi.system.domain.entity.SysVoucherNumber;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import io.github.linpeilie.annotations.AutoMapper;

import java.util.Date;


/**
 * 【请填写功能名称】业务对象 sys_voucher_number
 *
 * @author ${author}
 * @date 2025-07-03
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = SysVoucherNumber.class, reverseConvertGenerate = false)
@Builder
public class SysVoucherNumberBo extends BaseEntity {

    private String voucherCode;
    private Integer size;
    private Integer rule;
    private Integer number;
    private Date bDate;
}
