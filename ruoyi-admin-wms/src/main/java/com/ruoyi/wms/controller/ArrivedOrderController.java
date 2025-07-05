package com.ruoyi.wms.controller;

import java.util.List;

import cn.dev33.satoken.annotation.SaIgnore;
import com.ruoyi.wms.domain.bo.PurchaseOrderBo;
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
import com.ruoyi.wms.domain.vo.ArrivedOrderVo;
import com.ruoyi.wms.domain.bo.ArrivedOrderBo;
import com.ruoyi.wms.service.ArrivedOrderService;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;

/**
 * 【请填写功能名称】
 *
 * @author BlooD
 * @date 2025-06-23
 */
@SaIgnore
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/wms/arrivedOrder")
public class ArrivedOrderController extends BaseController {

    private final ArrivedOrderService arrivedOrderService;

    /**
     * 查询列表
     */
    @SaCheckPermission("wms:arrived:list")
    @GetMapping("/list")
    public TableDataInfo<ArrivedOrderVo> list(ArrivedOrderBo bo, PageQuery pageQuery) {
        return arrivedOrderService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出列表
     */
    @SaCheckPermission("wms:arrived:export")
    @Log(title = "【导出】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(ArrivedOrderBo bo, HttpServletResponse response) {
        List<ArrivedOrderVo> list = arrivedOrderService.queryList(bo);
        ExcelUtil.exportExcel(list, "【请填写功能名称】", ArrivedOrderVo.class, response);
    }

    /**
     * 获取详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("wms:arrived:query")
    @GetMapping("/{id}")
    public R<ArrivedOrderVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(arrivedOrderService.queryById(id));
    }

    /**
     * 到货单新增
     */
    @SaCheckPermission("wms:arrived:add")
    @Log(title = "【到货单新增】", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping("/add")
    public R<Void> add(@Validated(AddGroup.class) @RequestBody ArrivedOrderBo bo) {
        arrivedOrderService.insertByBo(bo);
        return R.ok();
    }

    /**
     * 根据采购订单新增到货单
     */
    @SaCheckPermission("wms:arrived:add")
    @Log(title = "【根据采购订单新增到货单】", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping("/addByPurchaseOrder")
    public R<Void> add(@Validated(AddGroup.class) @RequestBody PurchaseOrderBo bo) {
        arrivedOrderService.insertByBo(bo);
        return R.ok();
    }

    /**
     * 修改
     */
    @SaCheckPermission("wms:arrived:edit")
    @Log(title = "修改", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping("/edit")
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody ArrivedOrderBo bo) {
        arrivedOrderService.updateByBo(bo);
        return R.ok();
    }

    /**
     * 删除
     *
     * @param id 主键串
     */
    @SaCheckPermission("wms:arrived:remove")
    @Log(title = "删除", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long id) {
        arrivedOrderService.deleteByIds(List.of(id));
        return R.ok();
    }
}
