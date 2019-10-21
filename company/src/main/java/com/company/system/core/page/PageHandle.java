package com.company.system.core.page;

import com.company.system.core.model.Result;

import java.util.List;

public interface PageHandle {

    <T> Result turnPage(Result result,List<T> list, int start, int lengrh);
}
