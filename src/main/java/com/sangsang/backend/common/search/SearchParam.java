package com.sangsang.backend.common.search;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchParam {
    protected List<SearchColumn> columnList;

    protected boolean needPage;

    protected int offset = -1;
    protected int limit = -1;

    protected int page = 0;

    protected int size = 10;
}
