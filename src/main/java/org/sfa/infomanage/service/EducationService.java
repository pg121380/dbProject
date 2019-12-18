package org.sfa.infomanage.service;

import org.sfa.infomanage.bean.Education;
import org.sfa.infomanage.mapper.EducationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class EducationService {
    @Autowired
    private EducationMapper educationMapper;

    public List<Education> getAllEducations(){
        return educationMapper.getAllEducations();
    }

    public List<Education> getEducationByCondition(Education education){
        return educationMapper.getEducationByCondition(education);
    }

    public void deleteEducationById(String employeeId) {
        educationMapper.deleteEducationById(employeeId);
    }

    public void addEducation(Education education){
        educationMapper.addEducation(education);
    }

    public void updateEducation(Education education){
        educationMapper.updateEducation(education);
    }

    public List<HashMap<String,Object>> getEducationNumber(){
        return educationMapper.getDeptEducationNumber();
    }
}
