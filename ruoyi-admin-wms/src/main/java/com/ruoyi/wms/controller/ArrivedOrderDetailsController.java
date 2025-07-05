package com.ruoyi.wms.controller;

import java.util.Collection;
import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import com.ruoyi.common.idempotent.annotation.RepeatSubmit;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.web.core.BaseController;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.excel.utils.ExcelUtil;
import com.ruoyi.wms.domain.vo.ArrivedOrderDetailVo;
import com.ruoyi.wms.domain.bo.ArrivedOrderDetailBo;
import com.ruoyi.wms.service.ArrivedOrderDetailsService;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;

/**
 * 【请填写功能名称】
 *
 * @author BlooD
 * @date 2025-06-24
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/wms/arrivedDetails")
public class ArrivedOrderDetailsController extends BaseController {

    private final ArrivedOrderDetailsService arrivedOrderDetailsService;

    /**
     * 查询【请填写功能名称】列表
     */
    @SaCheckPermission("wms:arrivedDetails:list")
    @GetMapping("/list")
    public TableDataInfo<ArrivedOrderDetailVo> list(ArrivedOrderDetailBo bo, PageQuery pageQuery) {
        return arrivedOrderDetailsService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @SaCheckPermission("wms:arrivedDetails:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(ArrivedOrderDetailBo bo, HttpServletResponse response) {
        List<ArrivedOrderDetailVo> list = arrivedOrderDetailsService.queryList(bo);
        ExcelUtil.exportExcel(list, "【请填写功能名称】", ArrivedOrderDetailVo.class, response);
    }

    /**
     * 获取【请填写功能名称】详细信息
     *
     * @param id
     */
    @SaCheckPermission("wms:arrivedDetails:query")
    @GetMapping("/{id}")
    public R<ArrivedOrderDetailVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(arrivedOrderDetailsService.queryById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @SaCheckPermission("wms:arrivedDetails:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody ArrivedOrderDetailBo bo) {
        arrivedOrderDetailsService.insertByBo(bo);
        return R.ok();
    }

    /**
     * 修改【请填写功能名称】
     */
    @SaCheckPermission("wms:arrivedDetails:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody ArrivedOrderDetailBo bo) {
        arrivedOrderDetailsService.updateByBo(bo);
        return R.ok();
    }

    /**
     * 删除【请填写功能名称】
     *
     * @param id
     */
    @SaCheckPermission("wms:arrivedDetails:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long id) {
        arrivedOrderDetailsService.deleteByIds(List.of(id));
        return R.ok();
    }
}
