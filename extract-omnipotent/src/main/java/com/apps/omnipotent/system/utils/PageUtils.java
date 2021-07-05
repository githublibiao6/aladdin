package com.apps.omnipotent.system.utils;

import com.apps.omnipotent.system.pagehelper.entity.PageEntity;
import com.github.pagehelper.PageInfo;

public class PageUtils {

    /**
     * 将分页信息封装到统一的接口
     * @param pageRequest
     * @param
     * @return
     */
    public static PageEntity getPageResult(PageEntity pageRequest, PageInfo<?> pageInfo) {
        PageEntity pageResult = new PageEntity();
        pageResult.setPage(pageInfo.getPageNum());
        pageResult.setLimit(pageInfo.getPageSize());
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setItems(pageInfo.getList());
        return pageResult;
    }
}