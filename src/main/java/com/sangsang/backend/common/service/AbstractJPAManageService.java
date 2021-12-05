package com.sangsang.backend.common.service;

import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractJPAManageService<E, D, ID>{

    @Transactional
    public D insert(D dto) {
        return null;
    }

}
