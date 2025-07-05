package com.ruoyi.wms.enums;

/**
 * @version 1.0
 * @ ClassName OrderStatus
 * @ author BlooD
 * @ Date 2025-06-23
 */
public enum ReceiptStatus {
    NOT_RECEIPT,     // 未入库
    PARTIAL_RECEIPT, // 部分入库
    FULL_RECEIPT,    // 全部入库
    OVER_RECEIPT     // 超额入库
}
