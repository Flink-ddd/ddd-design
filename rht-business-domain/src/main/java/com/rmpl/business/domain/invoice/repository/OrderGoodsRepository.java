package com.rmpl.business.domain.invoice.repository;

import com.rmpl.business.domain.invoice.vo.OrderInvoiceDetailReqVO;
import com.rmpl.business.domain.infrastructure.dataobject.MOrderGoods;

import java.util.List;

public interface OrderGoodsRepository {
    List<MOrderGoods> orderGoodsList(OrderInvoiceDetailReqVO orderInvoiceDetailReqVO);

}
