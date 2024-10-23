package com.rmpl.business.domain.infrastructure;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.rmpl.business.domain.invoice.repository.OrderGoodsRepository;
import com.rmpl.business.domain.invoice.vo.OrderInvoiceDetailReqVO;
import com.rmpl.business.domain.infrastructure.dataobject.MOrderGoods;
import com.rmpl.business.domain.infrastructure.mapper.MOrderGoodsMapper;
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
public class OrderGoodsRepositoryImpl implements OrderGoodsRepository {
    private final MOrderGoodsMapper orderGoodsMapper;

    @Override
    public List<MOrderGoods> orderGoodsList(OrderInvoiceDetailReqVO orderInvoiceDetailReqVO) {
        log.info("根据子订单号查询订单-商品信息[{}]", JSON.toJSONString(orderInvoiceDetailReqVO));
        LambdaQueryWrapper<MOrderGoods> goodsLambdaQueryWrapper = Wrappers.lambdaQuery();
        goodsLambdaQueryWrapper.eq(StringUtils.isNotBlank(orderInvoiceDetailReqVO.getOrderSubNo()), MOrderGoods::getOrderSubNo, orderInvoiceDetailReqVO.getOrderSubNo()).eq(MOrderGoods::getIsInvoiced, 1).eq(MOrderGoods::getFgDel, 0);
        List<MOrderGoods> orderGoodsList = orderGoodsMapper.selectList(goodsLambdaQueryWrapper);
        if (CollectionUtils.isNotEmpty(orderGoodsList)) {
            return orderGoodsList;
        }
        return null;
    }
}
