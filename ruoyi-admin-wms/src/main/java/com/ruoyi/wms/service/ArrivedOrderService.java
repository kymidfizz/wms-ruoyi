package com.ruoyi.wms.service;

import cn.hutool.core.lang.Assert;
import com.ruoyi.common.core.constant.ServiceConstants;
import com.ruoyi.common.core.utils.MapstructUtils;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.core.utils.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ruoyi.system.domain.bo.SysVoucherNumberBo;
import com.ruoyi.system.service.SysVoucherNumberService;
import com.ruoyi.wms.domain.bo.ArrivedOrderDetailBo;
import com.ruoyi.wms.domain.bo.PurchaseOrderBo;
import com.ruoyi.wms.domain.bo.PurchaseOrderDetailBo;
import com.ruoyi.wms.domain.entity.ArrivedOrder;
import com.ruoyi.wms.domain.entity.ArrivedOrderDetail;
import com.ruoyi.wms.domain.entity.PurchaseOrderDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.ruoyi.wms.domain.bo.ArrivedOrderBo;
import com.ruoyi.wms.domain.vo.ArrivedOrderVo;
import com.ruoyi.wms.domain.entity.ArrivedOrder;
import com.ruoyi.wms.mapper.ArrivedOrderMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * arrivedService业务层处理
 *
 * @author BlooD
 * @date 2025-06-23
 */
@RequiredArgsConstructor
@Service
public class ArrivedOrderService {

    private final ArrivedOrderMapper arrivedOrderMapper;
    private final SysVoucherNumberService systemVoucherService;
    private final ArrivedOrderDetailsService arrivedOrderDetailService;

    /**
     * 查询
     */
    public ArrivedOrderVo queryById(Long id){
        return arrivedOrderMapper.selectVoById(id);
    }

    /**
     * 查询列表
     */
    public TableDataInfo<ArrivedOrderVo> queryPageList(ArrivedOrderBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<ArrivedOrder> lqw = buildQueryWrapper(bo);
        Page<ArrivedOrderVo> result = arrivedOrderMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询【请填写功能名称】列表
     */
    public List<ArrivedOrderVo> queryList(ArrivedOrderBo bo) {
        LambdaQueryWrapper<ArrivedOrder> lqw = buildQueryWrapper(bo);
        return arrivedOrderMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<ArrivedOrder> buildQueryWrapper(ArrivedOrderBo bo) {
        LambdaQueryWrapper<ArrivedOrder> lqw = Wrappers.lambdaQuery();
        return lqw;
    }

    /**
     * 新增
     */
    @Transactional
    public void insertByBo(ArrivedOrderBo bo) {
        validateArrivedOrderNo(bo.getOrderNo());
        bo.setFlag(ServiceConstants.ArrivadOrderStatus.ARRIVED);
        ArrivedOrder add = MapstructUtils.convert(bo, ArrivedOrder.class);
        assert add != null;
        arrivedOrderMapper.insert(add);
        bo.setId(add.getId());
        List<ArrivedOrderDetailBo> detailBoList = bo.getDetails();
        List<ArrivedOrderDetail> addDetailList = MapstructUtils.convert(detailBoList, ArrivedOrderDetail.class);
        assert addDetailList != null;
        addDetailList.forEach(it -> {
            it.setOrderId(add.getId());
        });
        // 创建到货明细
        arrivedOrderDetailService.saveDetails(addDetailList);
        //流水号+1
        systemVoucherService.updateVoucherNumber(SysVoucherNumberBo.builder().voucherCode(ServiceConstants.VoucherType.PURCHASE_ORDER).build());
    }

    /**
     * 根据采购订单新增
     */
    @Transactional
    public void insertByBo(PurchaseOrderBo bo) {
        ArrivedOrder add = new ArrivedOrder(bo);
        add.setFlag(ServiceConstants.ArrivadOrderStatus.ARRIVED);
        arrivedOrderMapper.insert(add);
    }

    /**
     * 修改【请填写功能名称】
     */
    public void updateByBo(ArrivedOrderBo bo) {
        ArrivedOrder update = MapstructUtils.convert(bo, ArrivedOrder.class);
        arrivedOrderMapper.updateById(update);
    }

    /**
     * 批量删除【请填写功能名称】
     */
    public void deleteByIds(Collection<Long> ids) {
        arrivedOrderMapper.deleteBatchIds(ids);
    }

    public void validateArrivedOrderNo(String ArrivedOrderNo) {
        LambdaQueryWrapper<ArrivedOrder> ArrivedOrderLqw = Wrappers.lambdaQuery();
        ArrivedOrderLqw.eq(ArrivedOrder::getOrderNo, ArrivedOrderNo);
        ArrivedOrder ArrivedOrder = arrivedOrderMapper.selectOne(ArrivedOrderLqw);
        Assert.isNull(ArrivedOrder, "到货单号重复，请手动修改");
    }
}
