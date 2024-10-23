package com.rmpl.business.api.order.request.invoice;

import com.rmpl.business.common.bottom.dto.Request;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author vensen
 */
@Data
@ApiModel(description = "开票列表查询参数")
public class OrderInvoiceQueryDTO extends Request {
    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("子订单编号")
    private String orderSubNo;

    @ApiModelProperty("页码")
    private Integer pageNum;

    @ApiModelProperty("每页数据条数")
    private Integer pageSize;
}
