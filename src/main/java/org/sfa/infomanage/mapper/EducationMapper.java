package org.sfa.infomanage.mapper;

import org.apache.ibatis.annotations.*;
import org.sfa.infomanage.bean.Education;
import org.sfa.infomanage.sqlprovider.EducationSQLProvider;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface EducationMapper {

    @Select("select * from education")
    List<Education> getAllEducations();

    @Select("select * from education where employeeId=#{employeeId}")
    Education getEducationById(String employeeId);

    @Update("update education set eduBackground=#{education},major=#{major},graduateDate=#{graduateDate},graduateSchool=#{graduateSchool},foreignLang=#{foreignLang} where employeeId=#{employeeId}")
    int updateEducationById(Education education);

    @SelectProvider(type = EducationSQLProvider.class, method = "getQuerySql")
    List<Education> getEducationByCondition(Education education);

    @Delete("delete from education where employeeId=#{employeeId}")
    void deleteEducationById(String employeeId);

    @Insert("insert into education values(#{employeeId},#{eduBackground},#{major},#{graduateDate},#{graduateSchool},#{foreignLang})")
    void addEducation(Education education);

    @Update("update education set eduBackground=#{eduBackground},major=#{major},graduateDate=#{graduateDate},graduateSchool=#{graduateSchool},foreignLang=#{foreignLang}  where employeeId=#{employeeId}")
    void updateEducation(Education education);

    @Select("select COUNT(*) as value,education.eduBackground as name from education group by(eduBackground)")
    List<HashMap<String, Object>> getDeptEducationNumber();
}
