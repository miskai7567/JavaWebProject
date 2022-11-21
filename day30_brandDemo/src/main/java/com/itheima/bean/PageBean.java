package com.itheima.bean;

import java.util.List;

/**
 * @Author pzl
 * @Date 2022/11/17 9:55
 */
public class PageBean<E> {
    // 当前页的数据
    private List<E> list;

    // 总记录数
    private int totalCount;

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "list=" + list +
                ", totalCount=" + totalCount +
                '}';
    }
}
