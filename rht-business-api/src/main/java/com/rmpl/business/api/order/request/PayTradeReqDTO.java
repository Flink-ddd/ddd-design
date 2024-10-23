package com.rmpl.business.api.order.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by gaoronghuan on 2016/3/24.
 */
@Data
public class PayTradeReqDTO {

    @ApiModelProperty("支付方式:0-银行卡, 1-打白条（不分期）,2-余额,3-优惠券,5-小金库,6-网关,15-微信支付,16-支付宝支付,22-云闪付")
    private String payType;
    @ApiModelProperty("交易金额")
    private Long amount;
    @ApiModelProperty("交易币种")
    private String currency;
    @ApiModelProperty("交易时间 yyyyMMddHHmmss")
    private String tradeTime;

}
