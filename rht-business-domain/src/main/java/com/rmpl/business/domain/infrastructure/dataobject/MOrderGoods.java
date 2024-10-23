package com.rmpl.business.domain.infrastructure.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.rmpl.business.common.interceptor.PrimaryKey;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 订单商品表
 * </p>
 *
 * @author muxh
 * @since 2022-11-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("m_order_goods")
public class MOrderGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.INPUT)
    @PrimaryKey
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 主订单编号
     */
    private String mainOrderNo;

    /**
     * 子订单编号
     */
    private String orderSubNo;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 商品种类： 1：课程，2：图书，3：1v1，4：课程包，5：辅导产品
     */
    private Integer goodsClass;

    /**
     * 商品编码
     */
    private String goodsNo;

    /**
     * 第三方编码
     */
    private String thirdProductCode;

    /**
     * 所属品牌Id
     */
    private Long goodsBrandId;

    /**
     * 所属品牌
     */
    private String goodsBrand;

    /**
     * 商品类型（1：实物、2：1v1、3：课程包）
     */
    private Integer goodsType;

    /**
     * 商品分类（1：职场、2：办公、3：其他）
     */
    private Integer goodsClassification;

    /**
     * 商品单位
     */
    private String goodsUnit;

    /**
     * 商家id
     */
    private Long businessId;

    /**
     * 商家名称
     */
    private String businessName;

    /**
     * 商品sku标识
     */
    private String specSkuId;

    /**
     * 商品规格id
     */
    private Long goodsSkuId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品价格
     */
    private String goodsPrice;

    /**
     * 商品规格
     */
    private String goodsSpecifications;

    /**
     * 商品图片地址，多张图片以;号隔开。
     */
    private String goodsImgUrl;

    /**
     * 制造商
     */
    private String manufacturer;

    /**
     * 购买数量
     */
    private Integer purchaseNum;

    /**
     * 申请售后的数量
     */
    private Integer appliedNum;

    /**
     * 开具发票的数量
     */
    private Integer invocedNum;

    /**
     * 剩余可申请数量
     */
    private Integer canApplyNum;

    /**
     * 是否执行（0：否、1：是）
     */
    private Integer isHandle;

    /**
     * 是否退课时（0：否、1：是）
     */
    private Integer isReturnPeriod;

    /**
     * 配送费
     */
    private BigDecimal returnFreight;

    /**
     * 规格类型(10单规格 20多规格)
     */
    private Integer specType;

    /**
     * 规格详情
     */
    private String specTitle;

    /**
     * 商品规格信息
     */
    private String goodsAttr;

    /**
     * 商品信息
     */
    private String content;

    /**
     * 商品划线价
     */
    private BigDecimal linePrice;

    /**
     * 优惠券优惠金额
     */
    private String discountMoney;

    /**
     * 商品重量(Kg)
     */
    private Double goodsWeight;

    /**
     * 商品总价(数量×单价)
     */
    private BigDecimal totalPrice;

    /**
     * 交易手续费(实际付款价(折扣和优惠后)*交易手续费率）
     */
    private BigDecimal transactionFee;

    /**
     * 实际付款价(折扣和优惠后)
     */
    private BigDecimal totalPayPrice;

    /**
     * 是否已评价(0否 1是)
     */
    private Integer isComment;

    /**
     * 是否已开发票（0否  1是）
     */
    private Integer isInvoiced;

    /**
     * 平台服务费率
     */
    private BigDecimal servicePrice;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 税收分类编码
     */
    private String taxClassificationCode;

    /**
     * 享受税收优惠政策内容
     */
    private String preferentialTaxPolicies;

    /**
     * 是否享受税收优惠政策：0，是；1，否
     */
    private Integer preferentialTaxCode;

    /**
     * 含税标志0，是；1，否
     */
    private Integer taxIncludedSigns;

    /**
     * 税率
     */
    private String rate;

    /**
     * 注册来源类型（1.PC；2.小程序；3.H5；4.APP）
     */
    private String sdScrtp;

    /**
     * 注册伙伴产品(业务项目: 0军考)
     */
    private String idScrvar;

    /**
     * 注册上传机构（公司号；1.融通）
     */
    private String idScrorg;

    /**
     * 启用禁用（是否失效）0启用，1禁用
     */
    private Integer fgDis;

    /**
     * 是否删除，0未删除，1已删除
     */
    private Integer fgDel;

    /**
     * 创建用户
     */
    private Long idUsrCrt;

    /**
     * 创建时间
     */
    private Date dtmCrt;

    /**
     * 最后更新用户
     */
    private Long idUsrEdt;

    /**
     * 最后更新时间
     */
    private Date dtmEdt;

    /**
     * 记录版本号
     */
    private String verNo;

}
