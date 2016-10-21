package com.example.service;

import com.example.mapper.MajorMapper;
import com.example.mapper.PositionMapper;
import com.example.model.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MajorService {
    private MajorMapper majorMapper;
    private PositionMapper positionMapper;

    @Autowired
    public MajorService(MajorMapper majorMapper, PositionMapper positionMapper) {
        this.majorMapper = majorMapper;
        this.positionMapper = positionMapper;
    }

    @Transactional(readOnly = true)
    public List<Major> findAll() {
        return majorMapper.findAll();
    }

    @Transactional
    public void insert(Major major) {
        majorMapper.insert(major);
        major.getPositions().forEach(position -> {
            positionMapper.insert(position.setMarjorId(major.getId()));
        });
    }

    @Transactional
    public void update(Major major) {
        majorMapper.update(major);
    }

    @Transactional
    public void deleteOne(Integer id) {
        majorMapper.deleteOne(id);
    }


}
