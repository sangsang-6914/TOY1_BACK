package com.sangsang.backend.common.search;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchColumn {
    private String column;
    private String keyword;
    private OpType opType;

    public OpType getOpType() {
        if (opType == null) {
            if (keyword != null && keyword.indexOf("%") != -1) {
                return OpType.LIKE;
            }
            return OpType.EQUAL;
        }
        return opType;
    }
}
