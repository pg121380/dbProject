package org.sfa.infomanage.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.sfa.infomanage.bean.Education;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationMapper {

    @Select("select * from education")
    List<Education> getAllEducations();

    @Select("select * from education where employeeId=#{employeeId}")
    Education getEducationById(String employeeId);

    @Update("update education set eduBackground=#{education},major=#{major},graduateDate=#{graduateDate},graduateSchool=#{graduateSchool},foreignLang=#{foreignLang} where employeeId=#{employeeId}")
    int updateEducationById(Education education);
}
