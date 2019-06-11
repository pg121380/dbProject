package org.sfa.infomanage.sqlprovider;

import org.apache.ibatis.jdbc.SQL;
import org.sfa.infomanage.bean.Employee;

public class EmployeeSQLProvider {

    private void addFrom(SQL sql){
        sql.FROM("employee");
    }
    private void addWhere(SQL sql, Employee employee){
        if(employee.getEmployeeId() != null){
            sql.WHERE("employeeId = #{employeeId}");
        }
        if(employee.getEmployeeName() != null){
            sql.WHERE("employeeName like CONCAT('%',#{employeeName},'%')");
        }
        if(employee.getTitle() != null){
            sql.WHERE("title = #{title}");
        }
        if(employee.getIsMarried() != null){
            sql.WHERE("isMarried = #{isMarried}");
        }
        if(employee.getDeptNumber() != null){
            sql.WHERE("deptNumber = #{deptNumber}");
        }
    }

    public String getQuerySql(Employee employee){
        SQL sql = new SQL().SELECT("*");
        addFrom(sql);
        addWhere(sql, employee);
        return sql.toString();
    }
}
