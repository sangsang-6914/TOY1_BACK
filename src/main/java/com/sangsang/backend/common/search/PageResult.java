package com.sangsang.backend.common.search;

import java.util.List;

public interface PageResult<T> {
    int getPage();

    int getSize();

    int getTotalPages();

    long getTotalCount();

    List<T> getList();
}
