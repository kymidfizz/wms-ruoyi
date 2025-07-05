package com.ruoyi.wms.mapper;

import com.ruoyi.common.mybatis.annotation.DataColumn;
import com.ruoyi.common.mybatis.annotation.DataPermission;
import com.ruoyi.wms.domain.entity.ShipmentOrder;
import com.ruoyi.wms.domain.vo.ShipmentOrderVo;
import com.ruoyi.common.mybatis.core.mapper.BaseMapperPlus;

/**
 * 出库单Mapper接口
 *
 * @author zcc
 * @date 2024-08-01
 */
@DataPermission({
    @DataColumn(key = "isDelete", value = "is_delete")
})
public interface ShipmentOrderMapper extends BaseMapperPlus<ShipmentOrder, ShipmentOrderVo> {

}
