package com.apps.omnipotent.system.pagehelper.util;

import com.apps.omnipotent.system.global.entity.Result;

import java.util.List;

public interface PageHandle {

    <T> Result turnPage(Result result, List<T> list, int start, int lengrh);
}
