package org.sfa.infomanage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.sfa.infomanage.bean.Marriage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MarriageMapper {
    @Select("select * from marriage")
    List<Marriage> getAllMarriages();
}
