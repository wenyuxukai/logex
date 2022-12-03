package com.xk.logex.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xk.logex.entity.LogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface LogMapper extends BaseMapper<LogEntity> {
}
