package com.xk.logex.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xk.logex.entity.ExcepEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ExceptionMapper extends BaseMapper<ExcepEntity> {
}
