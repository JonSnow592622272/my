package com.shotgun.my.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

public interface MyBaseService<U> extends IService<U> {

    default List<U> testHaha() {
        return list();
    }


}
