package com.rmpl.business.controller.config;

import com.alibaba.fastjson.JSONObject;
import com.rmpl.business.common.constant.GlobalConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author muxh
 * @since 2021/08/27 上午11:18
 */
@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String token = request.getHeader("accessToken");
//        String defaultToken = "198fa66d-e355-404e-aa8b-443a749de5f3";
//        log.info("============检验登录用户========[{}]", token);
//        //待调用健康通行证，判断调用方有无登录。
//        if (StringUtils.isBlank(token) || !defaultToken.equals(token)) {
//            throw new ServiceException(BaseErrorCode.LOGIN_EXCEPTION.message());
//        }
        String domainId = request.getHeader("domainId");
        if (StringUtils.isNotBlank(domainId)) {
//            OperatorHolder.setDomainId(domainId);
        }
//        if (StringUtils.isBlank(domainId)) {
//            throw new ServiceException(BaseErrorCode.DOMAIN_ID_NOT_NULL.message());
//        }
        String userId = request.getHeader("userId");
        if (StringUtils.isNotBlank(userId)) {
//            OperatorHolder.setUserId(Long.valueOf(userId));
        }
        return true;
    }

    /**
     * 拒绝未授权的请求
     *
     * @param response
     */
    private void reject(HttpServletResponse response) {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        try {
            JSONObject resp = new JSONObject();
            resp.put("success", false);
            resp.put("code", HttpStatus.UNAUTHORIZED.value());
            resp.put("message", HttpStatus.UNAUTHORIZED.getReasonPhrase());
            response.setCharacterEncoding(GlobalConstant.CHARSET_UTF_8);
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.getWriter().write(resp.toJSONString());
        } catch (IOException e) {
        }
    }


}
