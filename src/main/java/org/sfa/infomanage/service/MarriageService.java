package org.sfa.infomanage.service;

import org.sfa.infomanage.bean.Marriage;
import org.sfa.infomanage.mapper.MarriageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarriageService {

    @Autowired
    private MarriageMapper marriageMapper;

    public List<Marriage> getAllMarriages(){
        return marriageMapper.getAllMarriages();
    }
}
