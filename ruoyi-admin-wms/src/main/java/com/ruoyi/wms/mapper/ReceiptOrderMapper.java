package com.ruoyi.wms.mapper;

import com.ruoyi.common.mybatis.annotation.DataColumn;
import com.ruoyi.common.mybatis.annotation.DataPermission;
import com.ruoyi.common.mybatis.core.mapper.BaseMapperPlus;
import com.ruoyi.wms.domain.entity.ReceiptOrder;
import com.ruoyi.wms.domain.vo.ReceiptOrderVo;

/**
 * 入库单Mapper接口
 *
 * @author zcc
 * @date 2024-07-19
 */
@DataPermission({
    @DataColumn(key = "isDelete", value = "is_delete")
})
public interface ReceiptOrderMapper extends BaseMapperPlus<ReceiptOrder, ReceiptOrderVo> {

}
