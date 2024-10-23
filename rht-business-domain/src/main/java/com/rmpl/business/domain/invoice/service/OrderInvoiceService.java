package com.rmpl.business.domain.invoice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rmpl.business.api.order.clientobject.invoice.OrderInvoiceCO;
import com.rmpl.business.common.bottom.domain.DomainFactory;
import com.rmpl.business.common.bottom.domain.Entity;
import com.rmpl.business.common.exception.Errors;
import com.rmpl.business.common.exception.RhtBusinessDomainException;
import com.rmpl.business.common.page.PageData;
import com.rmpl.business.common.utils.BeanUtils;
import com.rmpl.business.common.utils.CheckUtil;
import com.rmpl.business.domain.infrastructure.dataobject.MOrderGoods;
import com.rmpl.business.domain.infrastructure.dataobject.MOrderInvoice;
import com.rmpl.business.domain.invoice.repository.OrderGoodsRepository;
import com.rmpl.business.domain.invoice.repository.OrderInvoiceRepository;
import com.rmpl.business.domain.invoice.vo.OrderInvoiceDetailReqVO;
import com.rmpl.business.domain.invoice.vo.OrderInvoiceGoodsVO;
import com.rmpl.business.domain.invoice.vo.OrderInvoiceVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author muxiaohui
 * @desc 订单发票领域
 * @tips: 领域中调用接口分为两类，基础设施层和spi层。
 */
@Slf4j
@Data
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrderInvoiceService implements Entity<Long> {
    @Resource
    private OrderInvoiceRepository orderInvoiceRepository;
    @Resource
    private OrderGoodsRepository orderGoodsRepository;

    @Override
    public Long getUniqueId() {
        return null;
    }

    @ApiModelProperty("发票类型（1：增值税电子普通发票、2：增值税普通发票、3：增值税专用发票、4：增值税电子专用发票）")
    private Integer invoiceType;

    @ApiModelProperty("是否特殊票种（0：否、1：是）")
    private Integer isSpecial;

    @ApiModelProperty("抬头类型")
    private Integer invoiceRise;

    @ApiModelProperty("购方编码（售前订单号）")
    private String orderSubNo;

    @ApiModelProperty("发票值对象")
    private OrderInvoiceVO orderInvoiceVO;


    /**
     * 得到自己的实例
     *
     * @return DownloadEntity
     */
    public static final OrderInvoiceService get() {
        return DomainFactory.get(OrderInvoiceService.class);
    }


    /**
     * 查询订单-发票详情
     */
    public OrderInvoiceCO queryInvoiceDetail(OrderInvoiceDetailReqVO orderInvoiceDetailReqVO) {
        try {
            MOrderInvoice orderInvoice = orderInvoiceRepository.invoiceDetail(orderInvoiceDetailReqVO);
            if (CheckUtil.isNotEmpty(orderInvoice)) {
                OrderInvoiceVO orderInvoiceVO = BeanUtils.convertBean(orderInvoice, OrderInvoiceVO.class);
                List<MOrderGoods> orderGoodsList = orderGoodsRepository.orderGoodsList(orderInvoiceDetailReqVO);
                if (CollectionUtils.isNotEmpty(orderGoodsList)) {
                    List<OrderInvoiceGoodsVO> orderInvoiceGoodsVOList = BeanUtils.convertList(orderGoodsList, OrderInvoiceGoodsVO.class);
                    orderInvoiceVO.setOrderInvoiceGoodsRespDTOList(orderInvoiceGoodsVOList);
                }
                return BeanUtils.convertBean(orderInvoiceVO, OrderInvoiceCO.class);
            }
            return null;
        } catch (RhtBusinessDomainException e) {
            throw e;
        } catch (Exception e) {
            throw new RhtBusinessDomainException(Errors.DEFAULT_PARAM_VALID_ERROR.getCode(), e.getMessage());
        }
    }

    /**
     * 查询订单-发票列表
     */
    public PageData<OrderInvoiceCO> queryInvoicePage(OrderInvoiceDetailReqVO orderInvoiceDetailReqVO) {
        try {
            IPage<MOrderInvoice> invoiceIPage = orderInvoiceRepository.orderInvoicePage(orderInvoiceDetailReqVO);
            //构造返回数据
            List<MOrderInvoice> orderInvoiceList = invoiceIPage.getRecords();
            if (CollectionUtils.isEmpty(orderInvoiceList)) {
                return null;
            }
            List<OrderInvoiceCO> orderInvoiceCOS = BeanUtils.convertList(orderInvoiceList, OrderInvoiceCO.class);
            //如果接口返回数据复杂的话，在此处写接口的业务聚合数据？？？
            //分页信息
            PageData<OrderInvoiceCO> response = PageData.of(new Page<>(invoiceIPage.getCurrent(), invoiceIPage.getSize(), invoiceIPage.getTotal()), orderInvoiceCOS);
            return response;
        } catch (RhtBusinessDomainException e) {
            throw e;
        } catch (Exception e) {
            throw new RhtBusinessDomainException(Errors.DEFAULT_PARAM_VALID_ERROR.getCode(), e.getMessage());
        }
    }
}
