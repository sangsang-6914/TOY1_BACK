package com.sangsang.backend.common.service;

import java.util.List;

public interface CrudService<D, ID> {
    D get(ID id);

    D update(D dto);

    D delete(ID id);

    List<D> search(); // 추후 구현
}
