package com.ruoyi.wms.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.validate.DeleteGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.excel.utils.ExcelUtil;
import com.ruoyi.common.idempotent.annotation.RepeatSubmit;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.web.core.BaseController;
import com.ruoyi.wms.domain.bo.PurchaseOrderDetailBo;
import com.ruoyi.wms.domain.vo.PurchaseOrderDetailVo;
import com.ruoyi.wms.service.PurchaseOrderDetailService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 采购订单详情
 *
 * @author zcc
 * @date 2024-07-19
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/wms/purchaseOrderDetail")
public class PurchaseOrderDetailController extends BaseController {

    private final PurchaseOrderDetailService purchaseOrderDetailService;

    /**
     * 查询采购订单详情列表
     */
//    @SaCheckPermission("wms:purchase:all")
//    @GetMapping("/list")
//    public TableDataInfo<PurchaseOrderDetailVo> list(PurchaseOrderDetailBo bo, PageQuery pageQuery) {
//        return purchaseOrderDetailService.queryPageList(bo, pageQuery);
//    }

    /**
     * 导出采购订单详情列表
     */
    @SaCheckPermission("wms:purchase:all")
    @Log(title = "采购订单详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(PurchaseOrderDetailVo bo, HttpServletResponse response) {
        List<PurchaseOrderDetailVo> list = purchaseOrderDetailService.queryList(bo);
        ExcelUtil.exportExcel(list, "采购订单详情", PurchaseOrderDetailVo.class, response);
    }

    /**
     * 获取采购订单详情详细信息
     *
     * @param id 主键
     */
//    @SaCheckPermission("wms:purchase:all")
//    @GetMapping("/{id}")
//    public R<PurchaseOrderDetailVo> getInfo(@NotNull(message = "主键不能为空")
//                                     @PathVariable Long id) {
//        return R.ok(purchaseOrderDetailService.queryById(id));
//    }

    /**
     * 新增采购订单详情
     */
//    @SaCheckPermission("wms:purchase:all")
//    @Log(title = "采购订单详情", businessType = BusinessType.INSERT)
//    @RepeatSubmit()
//    @PostMapping()
//    public R<Void> add(@Validated(AddGroup.class) @RequestBody PurchaseOrderDetailBo bo) {
//        purchaseOrderDetailService.insertByBo(bo);
//        return R.ok();
//    }

    /**
     * 修改采购订单详情
     */
    @SaCheckPermission("wms:purchase:all")
    @Log(title = "采购订单详情", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping("/updateDetailById")
    public R<Void> updateDetailById(@Validated(DeleteGroup.class) @RequestBody PurchaseOrderDetailBo bo) {
        purchaseOrderDetailService.updateDetailById(bo);
        return R.ok();
    }

    /**
     * 删除采购订单详情
     *
     * @param ids 主键串
     */
//    @SaCheckPermission("wms:purchase:all")
//    @Log(title = "采购订单详情", businessType = BusinessType.DELETE)
//    @DeleteMapping("/{ids}")
//    public R<Void> remove(@NotEmpty(message = "主键不能为空")
//                          @PathVariable Long[] ids) {
//        purchaseOrderDetailService.deleteByIds(List.of(ids));
//        return R.ok();
//    }

    /**
     * 根据采购订单id查询采购订单详情列表
     */
    @SaCheckPermission("wms:purchase:all")
    @GetMapping("/list/{purchaseOrderId}")
    public R<List<PurchaseOrderDetailVo>> listByPurchaseOrderId(@NotNull @PathVariable Long purchaseOrderId) {
        return R.ok(purchaseOrderDetailService.queryByPurchaseOrderId(purchaseOrderId));
    }
}
