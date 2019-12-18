package org.sfa.infomanage.sqlprovider;

import org.apache.ibatis.jdbc.SQL;
import org.sfa.infomanage.bean.Education;

public class EducationSQLProvider {

    private void addFrom(SQL sql){
        //为sql 添加 "...from..."语句
        sql.FROM("education");
    }

    private void addWhere(SQL sql, Education education){
        // 以下是根据传入的Education对象拼装查询SQL语句
        if(!education.getEmployeeId().equals("")){
            sql.WHERE("employeeId = #{employeeId}");
        }
        if(!education.getEduBackground().equals("")){
            sql.WHERE("eduBackground = #{eduBackground}");
        }
        if(!education.getForeignLang().equals("")){
            sql.WHERE("foreignLang = #{foreignLang}");
        }
        if(!education.getMajor().equals("")){
            sql.WHERE("major = #{major}");
        }
        if(!education.getGraduateSchool().equals("")){
            sql.WHERE("graduateSchool = #{graduateSchool}");
        }
        if(education.getGraduateDate() != null){
            sql.WHERE("graduateDate < #{graduateDate}");
        }
    }

    public String getQuerySql(Education education){
        //此方法将返回"select * from ... where ..."的查询SQL语句
        SQL sql = new SQL().SELECT("*");
        addFrom(sql);
        addWhere(sql, education);
        return sql.toString();
    }
}
