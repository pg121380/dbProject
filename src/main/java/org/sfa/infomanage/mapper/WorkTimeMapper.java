package org.sfa.infomanage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.sfa.infomanage.bean.WorkTime;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface WorkTimeMapper {

    @Select("select * from IS_workTime where workTime >= #{time}")
    List<WorkTime> getWorkTimeByTime(int time);

    @Select("select * from IS_workTime")
    List<WorkTime> getWorkTimes();
}
