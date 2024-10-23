package com.rmpl.business.app;

import com.rmpl.business.api.order.clientobject.invoice.OrderInvoiceCO;
import com.rmpl.business.api.order.request.invoice.OrderInvoiceDetailReqDTO;
import com.rmpl.business.common.bottom.domain.Command;
import com.rmpl.business.common.bottom.domain.CommandExecutorI;
import com.rmpl.business.common.bottom.dto.SingleResponse;
import com.rmpl.business.common.utils.BeanUtils;
import com.rmpl.business.common.utils.ValidateUtils;
import com.rmpl.business.domain.invoice.service.OrderInvoiceService;
import com.rmpl.business.domain.invoice.vo.OrderInvoiceDetailReqVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author muxiaohui
 */
@Slf4j
@Command
@AllArgsConstructor
public class QueryInvoiceDetailCmdExe implements CommandExecutorI<OrderInvoiceDetailReqDTO, SingleResponse<OrderInvoiceCO>> {
    @Override
    public SingleResponse<OrderInvoiceCO> execute(OrderInvoiceDetailReqDTO request) {
        //检验参数
        ValidateUtils.validAnnotation(request);
        //转化入参
        OrderInvoiceDetailReqVO orderInvoiceDetailReqVO = BeanUtils.convertBean(request, OrderInvoiceDetailReqVO.class);
        OrderInvoiceCO orderInvoiceCO = OrderInvoiceService.get().queryInvoiceDetail(orderInvoiceDetailReqVO);
        if (null == orderInvoiceCO) {
            return SingleResponse.buildSuccess();
        }
        return SingleResponse.of(orderInvoiceCO);
    }
}
