package com.ruoyi.system.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import lombok.NoArgsConstructor;


import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 【请填写功能名称】对象 sys_voucher_number
 *
 * @author ${author}
 * @date 2025-07-03
 */
@Data
@TableName("sys_voucher_number")
public class SysVoucherNumber implements Serializable {

    @Serial
    private static final long serialVersionUID=1L;

    @TableId(value = "id")
    private Long id;
    private String voucherCode;
    private Integer size;
    private Integer rule;
    private Integer number;
    private Date bDate;

}
