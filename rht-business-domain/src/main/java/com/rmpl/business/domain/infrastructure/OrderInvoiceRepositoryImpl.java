package com.rmpl.business.domain.infrastructure;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rmpl.business.common.constant.GlobalConstant;
import com.rmpl.business.domain.infrastructure.dataobject.MOrderInvoice;
import com.rmpl.business.domain.infrastructure.mapper.MOrderInvoiceMapper;
import com.rmpl.business.domain.invoice.repository.OrderInvoiceRepository;
import com.rmpl.business.domain.invoice.vo.OrderInvoiceDetailReqVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author muxh
 * @desc 基础通用的mapper接口
 */
@Slf4j
@Repository
@AllArgsConstructor
public class OrderInvoiceRepositoryImpl implements OrderInvoiceRepository {
    private final MOrderInvoiceMapper orderInvoiceMapper;

    @Override
    public MOrderInvoice invoiceDetail(OrderInvoiceDetailReqVO orderInvoiceDetailReqVO) {
        log.info("查询发票详情的请求参数[{}]", JSON.toJSONString(orderInvoiceDetailReqVO));
        LambdaQueryWrapper<MOrderInvoice> invoiceLambdaQueryWrapper = Wrappers.lambdaQuery();
        invoiceLambdaQueryWrapper.eq(StringUtils.isNotBlank(orderInvoiceDetailReqVO.getOrderSubNo()), MOrderInvoice::getOrderSubNo, orderInvoiceDetailReqVO.getOrderSubNo()).eq(MOrderInvoice::getFgDel, 0);
        List<MOrderInvoice> orderInvoiceList = orderInvoiceMapper.selectList(invoiceLambdaQueryWrapper);
        if (CollectionUtils.isNotEmpty(orderInvoiceList)) {
            MOrderInvoice orderInvoice = orderInvoiceList.get(0);
            return orderInvoice;
        }
        return null;
    }

    @Override
    public IPage<MOrderInvoice> orderInvoicePage(OrderInvoiceDetailReqVO orderInvoiceDetailReqVO) {
        log.info("发票列表请求参数[{}]", JSON.toJSONString(orderInvoiceDetailReqVO));
        //过滤掉代客下单数据
        IPage<MOrderInvoice> selectPage = this.orderInvoiceMapper.selectPage(this.orderInvoicePageHead(orderInvoiceDetailReqVO), this.getOrderInvoiceWrapper(orderInvoiceDetailReqVO));
        if (null == selectPage) {
            return null;
        }
        return selectPage;
    }

    private Page<MOrderInvoice> orderInvoicePageHead(OrderInvoiceDetailReqVO orderInvoiceDetailReqVO) {
        if (null == orderInvoiceDetailReqVO.getPageNum()) {
            orderInvoiceDetailReqVO.setPageNum(1);
        }
        if (null == orderInvoiceDetailReqVO.getPageSize()) {
            orderInvoiceDetailReqVO.setPageSize(20);
        }
        Page<MOrderInvoice> orderInvoicePage = new Page<>(orderInvoiceDetailReqVO.getPageNum(), orderInvoiceDetailReqVO.getPageSize());
        return orderInvoicePage;
    }

    private LambdaQueryWrapper<MOrderInvoice> getOrderInvoiceWrapper(OrderInvoiceDetailReqVO orderInvoiceDetailReqVO) {
        LambdaQueryWrapper<MOrderInvoice> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(StringUtils.isNotBlank(orderInvoiceDetailReqVO.getOrderSubNo()), MOrderInvoice::getOrderSubNo, orderInvoiceDetailReqVO.getOrderSubNo());
        queryWrapper.eq(null != orderInvoiceDetailReqVO.getInvoiceType(), MOrderInvoice::getInvoiceType, orderInvoiceDetailReqVO.getInvoiceType());
        queryWrapper.gt(null != orderInvoiceDetailReqVO.getBeginTime(), MOrderInvoice::getDtmCrt, orderInvoiceDetailReqVO.getBeginTime());
        queryWrapper.lt(null != orderInvoiceDetailReqVO.getEndTime(), MOrderInvoice::getDtmCrt, orderInvoiceDetailReqVO.getEndTime());
        queryWrapper.eq(MOrderInvoice::getFgDel, GlobalConstant.ZERO);
        queryWrapper.orderByDesc(MOrderInvoice::getDtmCrt);
        return queryWrapper;
    }


}
