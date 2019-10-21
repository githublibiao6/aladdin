package com.company.system.core.page;

import com.company.system.core.model.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class LayuiPageHandle implements PageHandle{
    @Override
    public <T> Result turnPage(Result result,List<T> list, int start, int lengrh) {
        PageHelper.offsetPage(start-1,lengrh);
        PageInfo<T> pages = new PageInfo<T>(list);
        result.setData(list);
        result.setCode("0");
        result.setCount((int)pages.getTotal());
        return result;
    }
}
