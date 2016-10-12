package com.example.service;

import com.example.mapper.MajorMapper;
import com.example.model.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorService {
    private MajorMapper majorMapper;

    @Autowired
    public MajorService(MajorMapper majorMapper) {
        this.majorMapper = majorMapper;
    }

    public List<Major> findAll(){
        return majorMapper.findAll();
    }
    public void insert(Major specialities){
        majorMapper.insert(specialities);
    }
    public void update(Major specialities){
        majorMapper.update(specialities);
    }
    public void deleteOne(Integer id){
        majorMapper.deleteOne(id);
    }


}
