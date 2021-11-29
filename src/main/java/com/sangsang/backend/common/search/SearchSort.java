package com.sangsang.backend.common.search;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchSort {
    private String column;
    private SortOrderType order;
}
