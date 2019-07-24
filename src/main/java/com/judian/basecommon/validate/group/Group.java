package com.judian.basecommon.validate.group;

import javax.validation.GroupSequence;

/**
 * 定义校验顺序，如果AddGroup组失败，则UpdateGroup组不会再校验
 * @author LM  参考： @author chenshun
 * @version v1.0
 * @description: 校验工具
 * @date 2019/6/10 19:08
 */
@GroupSequence({AddGroup.class, UpdateGroup.class})
public interface Group {

}
