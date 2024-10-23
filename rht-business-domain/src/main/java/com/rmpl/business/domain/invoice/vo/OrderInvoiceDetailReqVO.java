package com.rmpl.business.domain.invoice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author vensen
 */
@Data
@ApiModel(description = "开票详情查询参数")
public class OrderInvoiceDetailReqVO {

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("子订单编号")
    private String orderSubNo;

    @ApiModelProperty("发票类型（1：增值税电子普通发票、2：增值税普通发票、3：增值税专用发票、4：增值税电子专用发票）")
    private Integer invoiceType;

    @ApiModelProperty("开始时间")
    private Date beginTime;

    @ApiModelProperty("开始时间")
    private Date endTime;

    @ApiModelProperty("页码")
    private Integer pageNum;

    @ApiModelProperty("每页数据条数")
    private Integer pageSize;
}
