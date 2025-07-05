package com.ruoyi.wms.service;


import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.utils.MapstructUtils;
import com.ruoyi.system.service.SysDeptService;
import com.ruoyi.system.service.SysUserService;
import com.ruoyi.wms.domain.bo.PurchaseOrderDetailBo;
import com.ruoyi.wms.domain.entity.PurchaseOrderDetail;
import com.ruoyi.wms.domain.vo.PurchaseOrderDetailVo;
import com.ruoyi.wms.enums.ArrivedStatus;
import com.ruoyi.wms.enums.ReceiptStatus;
import com.ruoyi.wms.mapper.PurchaseOrderDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
* @author BlooD
* @description 针对表【wms_purchase_order(采购订单)】的数据库操作Service
* @createDate 2025-06-20 15:59:47
*/
@RequiredArgsConstructor
@Service
public class PurchaseOrderDetailService extends ServiceImpl<PurchaseOrderDetailMapper, PurchaseOrderDetail> {

    private final PurchaseOrderDetailMapper purchaseOrderDetailMapper;
    private final ItemSkuService itemSkuService;
    /**
     * 查询入库单详情列表
     */
    public List<PurchaseOrderDetailVo> queryList(PurchaseOrderDetailVo bo) {
        LambdaQueryWrapper<PurchaseOrderDetail> lqw = buildQueryWrapper(bo);
        List<PurchaseOrderDetailVo> purchaseOrderDetailVos = purchaseOrderDetailMapper.selectVoList(lqw);
        purchaseOrderDetailVos.forEach(detail ->{
            if (detail.getArrivedQuantity() == null) {
                detail.setArrivedStatus(ArrivedStatus.NOT_ARRIVED); // 未到货
            } else if (detail.getArrivedQuantity().compareTo(BigDecimal.ZERO) == 0) {
                detail.setArrivedStatus(ArrivedStatus.NOT_ARRIVED); // 未到货
            } else if (detail.getArrivedQuantity().compareTo(detail.getQuantity()) < 0) {
                detail.setArrivedStatus(ArrivedStatus.PARTIAL_ARRIVED); // 部分到货
            } else if (detail.getArrivedQuantity().equals(detail.getQuantity())) {
                detail.setArrivedStatus(ArrivedStatus.FULL_ARRIVED); // 全部到货
            } else {
                detail.setArrivedStatus(ArrivedStatus.OVER_ARRIVED); // 超额到货
            }

            if (detail.getReceiptQuantity() == null) {
                detail.setReceiptStatus(ReceiptStatus.NOT_RECEIPT); // 未入库
            } else if (detail.getReceiptQuantity().compareTo(BigDecimal.ZERO) == 0) {
                detail.setReceiptStatus(ReceiptStatus.NOT_RECEIPT); // 未入库
            } else if (detail.getReceiptQuantity().compareTo(detail.getQuantity()) < 0) {
                detail.setReceiptStatus(ReceiptStatus.PARTIAL_RECEIPT); // 部分入库
            } else if (detail.getReceiptQuantity().equals(detail.getQuantity())) {
                detail.setReceiptStatus(ReceiptStatus.FULL_RECEIPT); // 全部入库
            } else {
                detail.setReceiptStatus(ReceiptStatus.OVER_RECEIPT); // 超额入库
            }
        });
        return purchaseOrderDetailVos;
    }

    /**
     * 新增采购单详情
     * @param list
     */
    @Transactional
    public void saveDetails(List<PurchaseOrderDetail> list) {
        if (CollUtil.isEmpty(list)) {
            return;
        }
        saveOrUpdateBatch(list);
    }

    public void updateDetailById(PurchaseOrderDetailBo bo) {
        bo.setIsDelete(0);
        updateById(MapstructUtils.convert(bo,PurchaseOrderDetail.class));
    }

    public List<PurchaseOrderDetailVo> queryByPurchaseOrderId(Long PurchaseOrderId) {
        PurchaseOrderDetailVo bo = new PurchaseOrderDetailVo();
        if(PurchaseOrderId != null){
            bo.setOrderId(PurchaseOrderId);
        }
        List<PurchaseOrderDetailVo> details = queryList(bo);
        if (CollUtil.isEmpty(details)) {
            return Collections.emptyList();
        }
        itemSkuService.setItemSkuMap(details);
//        warehouseService.setWarehouseMap(details);
        return details;
    }

    private LambdaQueryWrapper<PurchaseOrderDetail> buildQueryWrapper(PurchaseOrderDetailVo bo) {
        LambdaQueryWrapper<PurchaseOrderDetail> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getOrderId() != null, PurchaseOrderDetail::getOrderId, bo.getOrderId());
        lqw.eq(bo.getSkuId() != null, PurchaseOrderDetail::getSkuId, bo.getSkuId());
        lqw.eq(bo.getQuantity() != null, PurchaseOrderDetail::getQuantity, bo.getQuantity());
        lqw.eq(bo.getAmount() != null, PurchaseOrderDetail::getAmount, bo.getAmount());
        lqw.eq(PurchaseOrderDetail::getIsDelete, 1);
        return lqw;
    }
}
