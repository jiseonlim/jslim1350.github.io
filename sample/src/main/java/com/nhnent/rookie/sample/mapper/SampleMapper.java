package com.nhnent.rookie.sample.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.nhnent.rookie.sample.domain.Sample;

@Mapper
public interface SampleMapper {
    
    Sample findOne(Long seq);
}