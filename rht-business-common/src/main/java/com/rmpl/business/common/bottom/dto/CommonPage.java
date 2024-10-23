package com.rmpl.business.common.bottom.dto;

import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CommonPage<T> implements Serializable {
    private int pageNo;
    private int pageSize;
    private long totalNum;
    private int totalPage;
    private List<T> result;


    public CommonPage() {
        result = Lists.newArrayList();
    }

}
