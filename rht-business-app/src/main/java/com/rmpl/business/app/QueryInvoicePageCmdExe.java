package com.rmpl.business.app;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.rmpl.business.api.order.clientobject.invoice.OrderInvoiceCO;
import com.rmpl.business.api.order.request.invoice.OrderInvoiceQueryDTO;
import com.rmpl.business.common.bottom.domain.Command;
import com.rmpl.business.common.bottom.domain.CommandExecutorI;
import com.rmpl.business.common.bottom.dto.SingleResponse;
import com.rmpl.business.common.page.PageData;
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
public class QueryInvoicePageCmdExe implements CommandExecutorI<OrderInvoiceQueryDTO, SingleResponse<PageData<OrderInvoiceCO>>> {

    @Override
    public SingleResponse<PageData<OrderInvoiceCO>> execute(OrderInvoiceQueryDTO request) {
        //检验参数
        ValidateUtils.validAnnotation(request);
        //转化入参
        OrderInvoiceDetailReqVO orderInvoiceDetailReqVO = BeanUtils.convertBean(request, OrderInvoiceDetailReqVO.class);
        PageData<OrderInvoiceCO> findOrderInvoicePage = OrderInvoiceService.get().queryInvoicePage(orderInvoiceDetailReqVO);
        if (null == findOrderInvoicePage && CollectionUtils.isNotEmpty(findOrderInvoicePage.getData())) {
            return SingleResponse.buildSuccess();
        }
        return SingleResponse.of(findOrderInvoicePage);
    }
}
