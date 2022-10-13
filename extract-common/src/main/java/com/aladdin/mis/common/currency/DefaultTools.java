package com.aladdin.mis.common.currency;
/*
 *  Created by cles on 2022/4/18 20:27
 */

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * @author cles
 * @description: 默认参数值
 * @Date 2022/4/28 20:27
 * @version: 1.0.0
 */
public class DefaultTools {

    public static final Digester MD5_TOOL = new Digester(DigestAlgorithm.MD5);

}
