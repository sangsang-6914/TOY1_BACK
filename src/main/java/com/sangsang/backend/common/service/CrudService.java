package com.sangsang.backend.common.service;

import com.sangsang.backend.common.search.PageResult;
import com.sangsang.backend.common.search.SearchParam;

import java.util.List;

public interface CrudService<D, ID> {
    D add(D dto);

    D get(ID id);

    D update(D dto);

    D delete(ID id);

    List<D> list(SearchParam param); // 추후 구현

    PageResult<D> listWithPage(SearchParam param);

}
