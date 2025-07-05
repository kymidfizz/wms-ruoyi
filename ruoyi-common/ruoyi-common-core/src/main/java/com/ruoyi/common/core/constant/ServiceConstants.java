package com.ruoyi.common.core.constant;

public class ServiceConstants {
    /**
     * 入库单状态
     */
    public class ReceiptOrderStatus {
        public static final Integer INVALID = -1;
        public static final Integer PENDING = 0;
        public static final Integer FINISH = 1;
    }

    /**
     * 出库单状态
     */
    public class ShipmentOrderStatus {
        public static final Integer INVALID = -1;
        public static final Integer PENDING = 0;
        public static final Integer FINISH = 1;
    }

    /**
     * 库存记录操作类型
     */
    public class InventoryHistoryOrderType {
        public static final Integer RECEIPT = 1;
        public static final Integer SHIPMENT = 2;
        public static final Integer MOVEMENT = 3;
        public static final Integer CHECK = 4;
    }

    /**
     * 移库单状态
     */
    public class MovementOrderStatus {
        public static final Integer INVALID = -1;
        public static final Integer PENDING = 0;
        public static final Integer FINISH = 1;
    }

    /**
     * 盘库单状态
     */
    public class CheckOrderStatus {
        public static final Integer INVALID = -1;
        public static final Integer PENDING = 0;
        public static final Integer FINISH = 1;
    }

    /**
     * 采购订单状态
     */
    public class PurchaseOrderStatus {
        public static final Integer NO_APPROVAL = 0;//待审核
        public static final Integer APPROVAL = 1;//审核通过
    }

    /**
     * 采购订单状态
     */
    public class ArrivadOrderStatus {
        public static final Integer NO_APPROVAL = 0;//待审核
        public static final Integer APPROVAL = 1;//审核通过
        public static final Integer ARRIVED = 0;//到货
        public static final Integer NO_ARRIVED = 1;//拒收
    }

    /**
     * 单据类型
     */
    public class VoucherType {
        public static final String PURCHASE_ORDER = "CG";//采购订单
        public static final String ARRIVAL_ORDER = "DH";//到货单
        public static final String SHIPMENT_ORDER = "CK";//出库单
        public static final String RECEIPT_ORDER = "RK";//入库单
        public static final String MOVEMENT_ORDER = "YK";//移库单
        public static final String CHECK_ORDER = "PK";//盘库单
        public static final String RETURN_ORDER = "ZJ";//退货单
    }
}
