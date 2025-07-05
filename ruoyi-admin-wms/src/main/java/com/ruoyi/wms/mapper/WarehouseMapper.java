package com.ruoyi.wms.mapper;

import com.ruoyi.common.mybatis.core.mapper.BaseMapperPlus;
import com.ruoyi.wms.domain.entity.Warehouse;
import com.ruoyi.wms.domain.vo.ItemSkuMapVo;
import com.ruoyi.wms.domain.vo.WarehouseMapVo;
import com.ruoyi.wms.domain.vo.WarehouseVo;

import java.util.Collection;
import java.util.List;

public interface WarehouseMapper extends BaseMapperPlus<Warehouse, WarehouseVo> {

    List<WarehouseMapVo> queryWarehouseMapVos(Collection<Long> ids);
}
