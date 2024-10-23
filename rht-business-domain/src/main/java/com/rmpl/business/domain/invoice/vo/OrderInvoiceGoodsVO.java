package com.rmpl.business.domain.invoice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单发票商品返回参数
 *
 * @author vensen
 */
@Data
@ApiModel(description = "订单发票商品返回参数")
public class OrderInvoiceGoodsVO {

    @ApiModelProperty("商品ID")
    private Long goodsId;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("商品种类： 1  课程，  2   图书，   3   1v1,   4  课程包")
    private Integer goodsClass;

    @ApiModelProperty("规格型号")
    private String goodsSpecifications;

    @ApiModelProperty("单位")
    private String goodsUnit;

    @ApiModelProperty("购买数量")
    private Integer purchaseNum;

    @ApiModelProperty("开具发票的数量")
    private Integer invocedNum;

    @ApiModelProperty("剩余可申请数量")
    private Integer canApplyNum;

    @ApiModelProperty("单价")
    private String goodsPrice;

    @ApiModelProperty("金额")
    private BigDecimal totalPrice;

    @ApiModelProperty("税额")
    private BigDecimal taxAmount;

    @ApiModelProperty("税收分类编码")
    private String taxClassificationCode;

    @ApiModelProperty("享受税收优惠政策内容")
    private String preferentialTaxPolicies;

    @ApiModelProperty("是否享受税收优惠政策：0，是；1，否")
    private Integer preferentialTaxCode;

    @ApiModelProperty("含税标志 0，是；1，否")
    private Integer taxIncludedSigns;

    @ApiModelProperty("税率")
    private String rate;



}
