package com.shotgun.my.service.dao.defaultGroup;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shotgun.my.api.po.pojos.defaultGroup.MyStudent;
import org.springframework.stereotype.Repository;

/**
* 学生表-Mapper 接口
*
*/
@Repository(value = "iMyStudentMapper")
public interface MyStudentMapper extends BaseMapper<MyStudent> {

}
