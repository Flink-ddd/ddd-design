package com.rmpl.business.domain.invoice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单发票值对象
 *
 * @author vensen
 */
@Data
@ApiModel(description = "订单发票值对象")
public class OrderInvoiceVO {

    @ApiModelProperty("订单号（发票自增ID）")
    private Long id;

    @ApiModelProperty("发票类型（1：增值税电子普通发票、2：增值税普通发票、3：增值税专用发票、4：增值税电子专用发票）")
    private Integer invoiceType;

    @ApiModelProperty("是否特殊票种（0：否、1：是）")
    private Integer isSpecial;

    @ApiModelProperty("抬头类型")
    private Integer invoiceRise;

    @ApiModelProperty("购方编码（售前订单号）")
    private String orderSubNo;

    @ApiModelProperty("购方名称")
    private String buyerName;

    @ApiModelProperty("购方税号")
    private String buyerTaxNumber;

    @ApiModelProperty("购方地址")
    private String buyerAddress;

    @ApiModelProperty("购方电话")
    private String buyerPhone;

    @ApiModelProperty("开户银行")
    private String bank;

    @ApiModelProperty("银行账号")
    private String bankAccount;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("申请开票日期")
    private Date dtmCrt;

    @ApiModelProperty("实际开票日期")
    private Date realityTime;

    @ApiModelProperty("开票商品总金额")
    private BigDecimal totalPaidAmount;

    @ApiModelProperty("开票商品总数量")
    private Integer totalPurchaseNum;

    /**
     * 以下为数据库外导出扩展字段
     */

    @ApiModelProperty("企业自编码")
    private String enterpriseCode;

    @ApiModelProperty("备注")
    private String remarks;

    @ApiModelProperty("扣除额")
    private BigDecimal Deductions;

    @ApiModelProperty("业务类型")
    private Integer busnessType;

    @ApiModelProperty("机动车企业类型")
    private Integer vehicleType;

    @ApiModelProperty("收款人")
    private String payee;

    @ApiModelProperty("复核人")
    private String reviewer;

    @ApiModelProperty("开票人")
    private String drawer;

    @ApiModelProperty("订单发票-商品返回参数")
    private List<OrderInvoiceGoodsVO> orderInvoiceGoodsRespDTOList;

}
