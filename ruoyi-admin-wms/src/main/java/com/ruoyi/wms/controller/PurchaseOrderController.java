package com.ruoyi.wms.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaIgnore;
import com.ruoyi.common.core.constant.ServiceConstants;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.idempotent.annotation.RepeatSubmit;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;
import com.ruoyi.common.web.core.BaseController;
import com.ruoyi.wms.domain.bo.PurchaseOrderBo;
import com.ruoyi.wms.domain.bo.ReceiptOrderBo;
import com.ruoyi.wms.domain.vo.PurchaseOrderVo;
import com.ruoyi.wms.domain.vo.ReceiptOrderVo;
import com.ruoyi.wms.service.PurchaseOrderService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @ ClassName PurchaseOrderController
 * @ author BlooD
 * @ Date 2025-06-21
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/wms/purchaseOrder")
public class PurchaseOrderController  extends BaseController {

    private final PurchaseOrderService purchaseOrderService;

    /**
     * 查询入库单列表
     */
    @SaCheckPermission("wms:purchase:all")
    @GetMapping("/list")
    public TableDataInfo<PurchaseOrderVo> list(PurchaseOrderBo bo, PageQuery pageQuery) {
        return purchaseOrderService.queryPageList(bo, pageQuery);
    }

    /**
     * 获取入库单详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("wms:purchase:all")
    @GetMapping("/{id}")
    public R<PurchaseOrderVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(purchaseOrderService.queryById(id));
    }

    /**
     * 保存采购订单
     */
    @SaCheckPermission("wms:purchase:all")
    @Log(title = "采购订单", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping("/add")
    public R<Void> add(@Validated(AddGroup.class) @RequestBody PurchaseOrderBo bo) {
        bo.setOrderStatus(ServiceConstants.PurchaseOrderStatus.NO_APPROVAL);
        purchaseOrderService.insertByBo(bo);
        return R.ok();
    }

    @SaCheckPermission("wms:purchase:all")
    @Log(title = "采购订单", businessType = BusinessType.OTHER)
    @RepeatSubmit()
    @PostMapping("/copy")
    public R<PurchaseOrderVo> copy(PurchaseOrderVo vo){
        return R.ok(purchaseOrderService.copy(vo));
    }

    @SaCheckPermission("wms:purchase:all")
    @Log(title = "采购订单审核、弃审、删除、修改", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PostMapping("/update")
    public R<Void> audit(@RequestBody PurchaseOrderBo vo){
        purchaseOrderService.update(vo);
        return R.ok();
    }

}
