package com.shotgun.my.service.dao.defaultGroup;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shotgun.my.api.po.pojos.defaultGroup.MyStudentScores;
import org.springframework.stereotype.Repository;

/**
* 分数表-Mapper 接口
*
*/
@Repository(value = "iMyStudentScoresMapper")
public interface MyStudentScoresMapper extends BaseMapper<MyStudentScores> {

}
