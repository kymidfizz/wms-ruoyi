package com.ruoyi.wms.service;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.utils.MapstructUtils;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ruoyi.wms.domain.bo.PurchaseOrderDetailBo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.ruoyi.wms.domain.bo.ArrivedOrderDetailBo;
import com.ruoyi.wms.domain.vo.ArrivedOrderDetailVo;
import com.ruoyi.wms.domain.entity.ArrivedOrderDetail;
import com.ruoyi.wms.mapper.ArrivedOrderDetailsMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Collection;


/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author BlooD
 * @date 2025-06-24
 */
@RequiredArgsConstructor
@Service
public class ArrivedOrderDetailsService extends ServiceImpl<ArrivedOrderDetailsMapper, ArrivedOrderDetail> {

    private final ArrivedOrderDetailsMapper arrivedOrderDetailsMapper;

    /**
     * 查询
     */
    public ArrivedOrderDetailVo queryById(Long id){
        return arrivedOrderDetailsMapper.selectVoById(id);
    }

    /**
     * 查询列表
     */
    public TableDataInfo<ArrivedOrderDetailVo> queryPageList(ArrivedOrderDetailBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<ArrivedOrderDetail> lqw = buildQueryWrapper(bo);
        Page<ArrivedOrderDetailVo> result = arrivedOrderDetailsMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询列表
     */
    public List<ArrivedOrderDetailVo> queryList(ArrivedOrderDetailBo bo) {
        LambdaQueryWrapper<ArrivedOrderDetail> lqw = buildQueryWrapper(bo);
        return arrivedOrderDetailsMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<ArrivedOrderDetail> buildQueryWrapper(ArrivedOrderDetailBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<ArrivedOrderDetail> lqw = Wrappers.lambdaQuery();
        return lqw;
    }

    /**
     * 新增
     */
    public void insertByBo(ArrivedOrderDetailBo bo) {
        ArrivedOrderDetail add = MapstructUtils.convert(bo, ArrivedOrderDetail.class);
        arrivedOrderDetailsMapper.insert(add);
    }

    /**
     * 根据采购订单新增
     */
    public void insertByBo(PurchaseOrderDetailBo bo) {
        ArrivedOrderDetail add = MapstructUtils.convert(bo, ArrivedOrderDetail.class);
        arrivedOrderDetailsMapper.insert(add);
    }

    /**
     * 修改
     */
    public void updateByBo(ArrivedOrderDetailBo bo) {
        ArrivedOrderDetail update = MapstructUtils.convert(bo, ArrivedOrderDetail.class);
        arrivedOrderDetailsMapper.updateById(update);
    }

    /**
     * 批量删除
     */
    public void deleteByIds(Collection<Long> ids) {
        arrivedOrderDetailsMapper.deleteBatchIds(ids);
    }

    @Transactional
    public void saveDetails(List<ArrivedOrderDetail> list) {
        if (CollUtil.isEmpty(list)) {
            return;
        }
        saveOrUpdateBatch(list);
    }
}
