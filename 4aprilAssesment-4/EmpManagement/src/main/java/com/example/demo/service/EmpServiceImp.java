package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EmpRepository;
import com.example.demo.dto.EmpDto;
import com.example.demo.entity.Emp;

@Service
public class EmpServiceImp implements EmpService {
	@Autowired
    private EmpRepository repo;


    private EmpDto toDto(Emp e) {
        EmpDto dto = new EmpDto();
        dto.setEmpId(e.getEmpId());
        dto.setEmpName(e.getEmpName());
        dto.setEmpSal(e.getEmpSal());
        dto.setEmpDoj(e.getEmpDoj());
        dto.setDeptName(e.getDeptName());
        return dto;
    }


    private Emp toEntity(EmpDto dto) {
        Emp e = new Emp();
        e.setEmpId(dto.getEmpId());
        e.setEmpName(dto.getEmpName());
        e.setEmpSal(dto.getEmpSal());
        e.setEmpDoj(dto.getEmpDoj());
        e.setDeptName(dto.getDeptName());
        return e;
    }

    @Override
    public List<EmpDto> getAllEmps() {
        List<Emp> emps = repo.findAll();
        List<EmpDto> dtos = new ArrayList<>();
        for (Emp e : emps) {
            dtos.add(toDto(e));
        }
        return dtos;
    }

    @Override
    public EmpDto getEmpById(Integer id) {
        Emp e = repo.findById(id).orElseThrow();
        return toDto(e);
    }

    @Override
    public void updateEmp(EmpDto dto) {
        repo.save(toEntity(dto));
    }

    @Override
    public void deleteEmp(Integer id) {
        repo.deleteById(id);
    }


	
}
