package com.ruoyi.system.controller.system;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaIgnore;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.domain.entity.SysVoucherNumber;
import com.ruoyi.system.domain.vo.SysVoucherNumberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import com.ruoyi.common.web.core.BaseController;
import com.ruoyi.system.service.SysVoucherNumberService;

/**
 * 【请填写功能名称】
 *
 * @author ${author}
 * @date 2025-07-03
 */
@SaIgnore
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/voucher")
public class SysVoucherNumberController extends BaseController {

    private final SysVoucherNumberService sysVoucherNumberService;

    @GetMapping(value = { "/getVoucherNumber"})
    public R<SysVoucherNumberVo> getVoucherNumber(String voucherCode) {
        return R.ok(sysVoucherNumberService.queryVoucherNumber(voucherCode));
    }
}
