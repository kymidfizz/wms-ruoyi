package com.ruoyi.wms.mapper;

import com.ruoyi.common.mybatis.annotation.DataColumn;
import com.ruoyi.common.mybatis.annotation.DataPermission;
import com.ruoyi.wms.domain.entity.MovementOrder;
import com.ruoyi.wms.domain.vo.MovementOrderVo;
import com.ruoyi.common.mybatis.core.mapper.BaseMapperPlus;

/**
 * 移库单Mapper接口
 *
 * @author zcc
 * @date 2024-08-09
 */
@DataPermission({
    @DataColumn(key = "isDelete", value = "is_delete")
})
public interface MovementOrderMapper extends BaseMapperPlus<MovementOrder, MovementOrderVo> {

}
