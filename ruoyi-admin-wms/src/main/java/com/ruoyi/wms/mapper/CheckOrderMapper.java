package com.ruoyi.wms.mapper;

import com.ruoyi.common.mybatis.annotation.DataColumn;
import com.ruoyi.common.mybatis.annotation.DataPermission;
import com.ruoyi.wms.domain.entity.CheckOrder;
import com.ruoyi.wms.domain.vo.CheckOrderVo;
import com.ruoyi.common.mybatis.core.mapper.BaseMapperPlus;

/**
 * 库存盘点单据Mapper接口
 *
 * @author zcc
 * @date 2024-08-13
 */
@DataPermission({
    @DataColumn(key = "isDelete", value = "is_delete")
})
public interface CheckOrderMapper extends BaseMapperPlus<CheckOrder, CheckOrderVo> {

}
