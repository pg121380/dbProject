package org.sfa.infomanage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.sfa.infomanage.bean.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {

    @Select("select deptNumber as deptId,deptName from department where deptNumber=#{deptId}")
    Department getDepartmentById(String deptId);

    @Select("select deptNumber as deptId,deptName from department")
    List<Department> getAllDepartments();
}
