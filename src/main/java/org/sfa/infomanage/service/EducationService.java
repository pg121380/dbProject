package org.sfa.infomanage.service;

import org.sfa.infomanage.bean.Education;
import org.sfa.infomanage.mapper.EducationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {
    @Autowired
    private EducationMapper educationMapper;

    public List<Education> getAllEducations(){
        return educationMapper.getAllEducations();
    }
}
