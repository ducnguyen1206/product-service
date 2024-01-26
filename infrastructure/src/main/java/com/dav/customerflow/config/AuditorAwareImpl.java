package com.dav.customerflow.config;

import com.dav.customerflow.utils.SecurityUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

import static com.dav.customerflow.constant.HeaderConstant.REQUEST_JWT;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Autowired
    private HttpServletRequest requestHeader;

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(SecurityUtils.getUser(requestHeader.getHeader(REQUEST_JWT)));
    }
}
