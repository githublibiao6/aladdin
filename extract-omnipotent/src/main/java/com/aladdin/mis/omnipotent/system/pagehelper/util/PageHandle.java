package com.aladdin.mis.omnipotent.system.pagehelper.util;

import com.aladdin.mis.common.system.entity.Result;

import java.util.List;

public interface PageHandle {

    <T> Result turnPage(Result result, List<T> list, int start, int lengrh);
}
