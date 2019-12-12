package com.shotgun.my.service.dao.defaultGroup;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shotgun.my.api.po.pojos.defaultGroup.MyTeacher;
import org.springframework.stereotype.Repository;

/**
* 教师表-Mapper 接口
*
*/
@Repository(value = "iMyTeacherMapper")
public interface MyTeacherMapper extends BaseMapper<MyTeacher> {

}
