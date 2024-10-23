package com.rmpl.business.common.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.rmpl.business.common.bottom.dto.CommonPage;
import lombok.Data;

import java.util.List;

/**
 * 分页对象PageData
 *
 * @author muxh
 * @since 2021-11-27 10:38
 */
@Data
public class PageData<T> {
    /**
     * 当前页
     */
    private long pageNum;
    /**
     * 数据列表长度
     */
    private long pageSize;
    /**
     * 总记录数
     */
    private long total;
    /**
     * 总页数
     */
    private long pages;
    /**
     * 数据列表
     */
    private List<T> data;

    public PageData() {
        data = Lists.newArrayList();
    }

    /**
     * 构造分页对象
     *
     * @return 分页对象
     */
    public static PageData of() {
        return new PageData();
    }

    /**
     * 构造分页对象
     *
     * @return 分页对象
     */
    public static <N> PageData of(PageData<N> pageObject) {
        PageData<N> pageData = PageData.of();
        pageData.setPageNum(pageObject.getPageNum());
        pageData.setPageSize(pageObject.getPageSize());
        pageData.setTotal(pageObject.getTotal());
        pageData.setPages(pageObject.getPages());
        return pageData;
    }

    /**
     * 构造分页对象
     *
     * @return 分页对象
     */
    public static <N> PageData ofCommon(CommonPage pageObject) {
        PageData<N> pageData = PageData.of();
        pageData.setPageNum(pageObject.getPageNo());
        pageData.setPageSize(pageObject.getPageSize());
        pageData.setTotal(pageObject.getTotalNum());
        pageData.setPages(pageObject.getTotalPage());
        return pageData;
    }

    /**
     * 获取分页对象
     *
     * @param pageObject 原始分页对象
     * @param dataList   数据列表
     * @param <N>        泛型类型
     * @return 返回分页对象
     */
    public static <N> PageData<N> of(Page<N> pageObject, List<N> dataList) {
        PageData<N> pageData = PageData.of();
        pageData.setData(dataList);
        pageData.setPageNum(pageObject.getCurrent());
        pageData.setPageSize(pageObject.getSize());
        pageData.setPages(pageObject.getPages());
        pageData.setTotal(pageObject.getTotal());
        return pageData;
    }

    /**
     * 构建分页对象
     * @param pageObject
     * @param dataList
     * @param <N>
     * @return
     */
    public static <N> PageData<N> build(Page<N> pageObject, List<N> dataList) {
        Page<N> objectPage = new Page<>(pageObject.getCurrent(), pageObject.getSize(), pageObject.getTotal());
        return of(objectPage, dataList);
    }
}
