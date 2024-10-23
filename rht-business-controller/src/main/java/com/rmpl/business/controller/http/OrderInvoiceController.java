package com.rmpl.business.controller.http;

import com.rmpl.business.api.order.request.invoice.OrderInvoiceDetailReqDTO;
import com.rmpl.business.api.order.request.invoice.OrderInvoiceQueryDTO;
import com.rmpl.business.common.bottom.domain.CommandExecutorI;
import com.rmpl.business.common.bottom.dto.SingleResponse;
import com.rmpl.business.api.order.clientobject.invoice.OrderInvoiceCO;
import com.rmpl.business.common.page.PageData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author muxh
 * @since 2021-09-06 16:12:40
 */
@RestController
@RequestMapping("/invoice/")
@Api(value = "订单发票相关接口", tags = "订单发票相关接口")
@Slf4j
@AllArgsConstructor
public class OrderInvoiceController {

    private final CommandExecutorI<OrderInvoiceDetailReqDTO, SingleResponse<OrderInvoiceCO>> queryInvoiceDetailCmdExe;
    private final CommandExecutorI<OrderInvoiceQueryDTO, SingleResponse<PageData<OrderInvoiceCO>>> queryInvoicePageCmdExe;


    @PostMapping("v1/invoiceDetail")
    @ApiOperation(value = "发票详情", notes = "发票详情")
    public SingleResponse<OrderInvoiceCO> invoiceDetail(@RequestBody OrderInvoiceDetailReqDTO orderInvoiceDetailReqDTO) {
        return queryInvoiceDetailCmdExe.execute(orderInvoiceDetailReqDTO);
    }

    @PostMapping("v1/invoicePage")
    @ApiOperation(value = "发票列表", notes = "发票详情")
    public SingleResponse<PageData<OrderInvoiceCO>> invoiceDetail(@RequestBody OrderInvoiceQueryDTO orderInvoiceQueryDTO) {
        return queryInvoicePageCmdExe.execute(orderInvoiceQueryDTO);
    }
}
