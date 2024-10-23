package com.rmpl.business.api.order.request.invoice;

import com.rmpl.business.common.bottom.dto.Request;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author vensen
 */
@Data
@ApiModel(description = "开票详情查询参数")
public class OrderInvoiceDetailReqDTO extends Request {

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("子订单编号")
    private String orderSubNo;
}
