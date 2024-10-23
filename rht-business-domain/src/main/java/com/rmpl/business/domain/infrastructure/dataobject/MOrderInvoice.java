package com.rmpl.business.domain.infrastructure.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.rmpl.business.common.interceptor.PrimaryKey;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 订单-发票信息表
 * </p>
 *
 * @author muxh
 * @since 2022-11-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("m_order_invoice")
public class MOrderInvoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.INPUT)
    @PrimaryKey
    private Long id;

    /**
     * 主订单编号
     */
    private String mainOrderNo;

    /**
     * 子订单编号
     */
    private String orderSubNo;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 是否特殊票种（0：否、1：是）
     */
    private Integer isSpecial;

    /**
     * 发票状态（1：已申请、2：已开票）
     */
    private Integer invoiceState;

    /**
     * 发票类型（1：增值税电子普通发票、2：增值税普通发票、3：增值税专用发票、4：增值税电子专用发票）
     */
    private Integer invoiceType;

    /**
     * 发票抬头（1：个人/其他、2：企业）
     */
    private Integer invoiceRise;

    /**
     * 发票主体
     */
    private String invoiceSubject;

    /**
     * 购方名称
     */
    private String buyerName;

    /**
     * 购方税号
     */
    private String buyerTaxNumber;

    /**
     * 发票金额
     */
    private BigDecimal invoiceAmount;

    /**
     * 发票明细
     */
    private String invoiceDetail;

    /**
     * 注册地址
     */
    private String registerAddress;

    /**
     * 开户银行
     */
    private String bank;

    /**
     * 银行账号
     */
    private String bankAccount;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 购方地址
     */
    private String buyerAddress;

    /**
     * 联系方式
     */
    private String buyerPhone;

    /**
     * 备注
     */
    private String remark;

    /**
     * 实际开票日期
     */
    private Date realityTime;

    /**
     * 注册来源类型（1.PC；2.小程序；3.H5；4.APP）
     */
    private String sdScrtp;

    /**
     * 注册伙伴产品(业务项目: 0军考)
     */
    private String idScrvar;

    /**
     * 注册上传机构（公司号；1.融通）
     */
    private String idScrorg;

    /**
     * 启用禁用（是否失效）0启用，1禁用
     */
    private Integer fgDis;

    /**
     * 是否删除，0未删除，1已删除
     */
    private Integer fgDel;

    /**
     * 创建用户
     */
    private Long idUsrCrt;

    /**
     * 创建时间
     */
    private Date dtmCrt;

    /**
     * 最后更新用户
     */
    private Long idUsrEdt;

    /**
     * 最后更新时间
     */
    private Date dtmEdt;

    /**
     * 记录版本号
     */
    private String verNo;


}
