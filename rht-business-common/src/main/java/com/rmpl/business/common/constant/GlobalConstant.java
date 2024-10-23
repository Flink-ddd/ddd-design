package com.rmpl.business.common.constant;

/**
 * @author muxh
 * @version V1.0
 * @since 2021-08-24 18:19
 */
public class GlobalConstant {

    /**
     * 全局KEY前缀
     */
    public static final String SYSTEM_KEY_PREFIX = "order:order_center_key_";

    /**
     * 用于规格和规格明细字符串拼接
     */
    public static final String SKYU_SPECS = "#*#";

    /**
     * 订单数据的最大量
     */
    public static final Integer EXPORT_ORDER_MAX = 50000;

    /**
     * 每次批量入库的最大限制值
     */
    public static final int MAX_INSERT_SIZE = 500;

    /**
     * 调用云仓中心合作商家批处理，一批300个。
     */
    public static final Integer BATCH_SIZE = 300;

    public static final Integer JOB_BATCH_SIZE = 20;

    public static final String NULL = "null";

    /**
     * 物流状态￿设置值
     */
    public static final String LOGISTIC_DICT_FIELD = "logistic_status";
    public static final String LOGISTIC_TABLE_NAME = "order_sub";

    /**
     * 售后状态￿设置值
     */
    public static final String RETURN_DICT_FIELD = "status";
    public static final String RETURN_TABLE_NAME = "order_return";

    /**
     * 当前用户地址限制
     */
    public static final Integer USER_ADDRESS_MAX = 20;

    /**
     * 数字0
     */
    public static final Integer ZERO = 0;

    public static final Long LONG_ZERO = 0L;

    public static final String SOURCE_TYPE = "tencent";

    /**
     * 时间差值
     */
    public static final Long DATE_DIFFERENCE = 1L;

    /**
     * 默认金额
     */
    public static final Double DEFAULT_MONEY = 0.00;

    /**
     * 字符串0
     */
    public static final String ZERO_STR = "0";

    public static final String ONE_STR = "1";

    /**
     * 数字1
     */
    public static final Integer ONE = 1;

    public static final Integer TWO = 2;

    public static final Integer THREE = 3;

    public static final Integer SIX = 6;


    /**
     * 健康通行证access_token
     */
    public static final String ACCESS_TOKEN = "accessToken";
    public static final String USER_ID = "userId";
    public static final String USER_NAME = "username";
    public static final String REAL_NAME = "realname";

    /**
     * 毫秒和秒转换
     */
    public static final Integer MILLISECOND_CONVERT_SECOND = 1000;

    public static final String ORDER_RETURN_CHANNEL_DETAIL = SYSTEM_KEY_PREFIX + "orderReturnDetail";

    /**
     * 收货地址详情缓存key
     */
    public static final String ADDRESS_CHANNEL_DETAIL = SYSTEM_KEY_PREFIX + "addressDetail";

    /**
     * 收货地址列表缓存key
     */
    public static final String ADDRESS_CHANNEL_LIST = SYSTEM_KEY_PREFIX + "addressList";

    /**
     * 商品订单详情缓存key
     */
    public static final String SUB_SHOP_CHANNEL_DETAIL = SYSTEM_KEY_PREFIX + "shopDetail";

    /**
     * 云仓订单详情缓存key
     */
    public static final String WAREHOUSE_ORDER_CHANNEL_DETAIL = SYSTEM_KEY_PREFIX + "warehouseOrderDetail";

    /**
     * 商品订单列表缓存key
     */
    public static final String ORDER_CHANNEL_LIST = SYSTEM_KEY_PREFIX + "orderList";

    /**
     * 订单公共设置详情缓存key
     */
    public static final String ORDER_SETTINGS_CHANNEL_DETAIL = SYSTEM_KEY_PREFIX + "orderSettingsDetail";

    /**
     * 订单公共设置列表缓存key
     */
    public static final String ORDER_SETTINGS_CHANNEL_LIST = SYSTEM_KEY_PREFIX + "orderSettingsList";

    /**
     * 购物车列表缓存key
     */
    public static final String SHOP_CART_CHANNEL_LIST = SYSTEM_KEY_PREFIX + "shopCartList";

    /**
     * 评价列表缓存key
     */
    public static final String EVALUATE_CHANNEL_LIST = SYSTEM_KEY_PREFIX + "evaluateList";

    /**
     * 评价详情缓存key
     */
    public static final String EVALUATE_CHANNEL_DETAIL = SYSTEM_KEY_PREFIX + "evaluateDetail";

    /**
     * 物流公司信息列表缓存key
     */
    public static final String LOGISTICS_CHANNEL_LIST = SYSTEM_KEY_PREFIX + "logisticsList";

    /**
     * 物流公司信息详情缓存key
     */
    public static final String LOGISTICS_CHANNEL_DETAIL = SYSTEM_KEY_PREFIX + "logisticsDetail";

    /**
     * 根据物流单号查询物流信息缓存key
     */
    public static final String LOGISTICS_DETAIL = SYSTEM_KEY_PREFIX + "logisticsDetailByNo";

    /**
     * 商品发货详情缓存key
     */
    public static final String DELIVER_GOODS_DETAIL = SYSTEM_KEY_PREFIX + "deliverGoodsDetail";

    /**
     * 订单商品列表缓存key
     */
    public static final String ORDER_GOODS_PRODUCT_LIST = SYSTEM_KEY_PREFIX + "goodsProductList";

    /**
     * 订单商品详情缓存key
     */
    public static final String ORDER_GOODS_PRODUCT_DETAIL = SYSTEM_KEY_PREFIX + "goodsProductDetail";

    /**
     * 订单商品赠品列表缓存key
     */
    public static final String GOODS_GIFT_LIST = SYSTEM_KEY_PREFIX + "goodsGiftList";

    /**
     * 订单商品赠品详情缓存key
     */
    public static final String GOODS_GIFT_DETAIL = SYSTEM_KEY_PREFIX + "goodsGiftDetail";

    /**
     * 订单-自提列表缓存key
     */
    public static final String ORDER_EXTRACT_LIST = SYSTEM_KEY_PREFIX + "orderExtractList";

    /**
     * 订单-自提详情缓存key
     */
    public static final String ORDER_EXTRACT_DETAIL = SYSTEM_KEY_PREFIX + "orderExtractDetail";

    /**
     * 主订单表详情缓存key
     */
    public static final String ORDER_MAIN_DETAIL = SYSTEM_KEY_PREFIX + "orderMainDetail";

    /**
     * 子订单表详情缓存key
     */
    public static final String ORDER_SUB_DETAIL = SYSTEM_KEY_PREFIX + "orderSubDetail";

    /**
     * 子订单表列表缓存key
     */
    public static final String ORDER_SUB_LIST = SYSTEM_KEY_PREFIX + "orderSubList";

    /**
     * 动态物流详情缓存key
     */
    public static final String ORDER_DYNAMIC_DETAIL = SYSTEM_KEY_PREFIX + "dynamicDetail";

    /**
     * 核销详情缓存key
     */
    public static final String ORDER_WRITE_OFF_DETAIL = SYSTEM_KEY_PREFIX + "orderWriteOffDetail";

    /**
     * 商家详情缓存key
     */
    public static final String ORDER_BUSINESS_DETAIL = SYSTEM_KEY_PREFIX + "orderBusinessDetail";

    /**
     * 订单详情缓存key
     */
    public static final String ORDER_DETAIL = SYSTEM_KEY_PREFIX + "orderDetail";

    /**
     * 配置账户详情缓存key
     */
    public static final String ORDER_GOODS_ACCOUNT_DETAIL = SYSTEM_KEY_PREFIX + "orderGoodsAccountDetail";

    /**
     * 定时任务中查询订单缓存key
     */
    public static final String ORDER_JOB_DATA = SYSTEM_KEY_PREFIX + "orderJobData";

    public static final String CHARSET_UTF_8 = "utf-8";

    public static final String ORDER_ALL_TYPE = "全部";

    public static final Integer EXPORT_ENTER_MAX = 80000;

    public static final String LOGISTICS_TYPE = "SF";

    public static final String CUSTOMER_TIPS = "为保障您的课程体验，请微信添加：";

    public static final String FREIGHT_MODE_1 = "全国包邮";

    public static final String FREIGHT_MODE_2 = "偏远地区";

    public static final String RETURN_DEFAULT_MESS = "以实际退款金额为准";

    public static final String RETURN_OTHER_MESS = "--";






}
