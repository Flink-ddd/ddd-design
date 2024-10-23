package com.rmpl.business.domain.invoice.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rmpl.business.domain.infrastructure.dataobject.MOrderInvoice;
import com.rmpl.business.domain.invoice.vo.OrderInvoiceDetailReqVO;

/**
 * @author muxiaohui
 */
public interface OrderInvoiceRepository {
    MOrderInvoice invoiceDetail(OrderInvoiceDetailReqVO orderInvoiceDetailReqVO);
    IPage<MOrderInvoice> orderInvoicePage(OrderInvoiceDetailReqVO orderInvoiceDetailReqVO);
}
