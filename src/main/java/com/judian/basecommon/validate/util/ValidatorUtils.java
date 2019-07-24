package com.judian.basecommon.validate.util;


import com.judian.basecommon.exception.JdException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;


/**
 * @author LM 参考： @author chenshun
 * @version v1.0
 * @description: 校验工具
 * @date 2019/6/10 19:08
 */
public class ValidatorUtils {
    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 校验对象
     *
     * @param object 待校验对象
     * @param groups 待校验的组
     * @throws JdException 校验不通过
     */
    public static void validateEntity(Object object, Class<?>... groups)
            throws JdException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            StringBuilder msg = new StringBuilder();
            for (ConstraintViolation<Object> constraint : constraintViolations) {
                msg.append(constraint.getMessage()).append("<br>");
            }
            throw new JdException(msg.toString());
        }
    }
}
