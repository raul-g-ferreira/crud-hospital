package com.example.crud_hospital.service;

import com.example.crud_hospital.model.Hospital;
import com.example.crud_hospital.repository.HospitalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public Hospital getByCnpj(String cnpj) {
        return hospitalRepository.findById(cnpj).orElseThrow(RuntimeException::new);
    }

    public Hospital create(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    public void delete(String cnpj) {
        hospitalRepository.deleteById(cnpj);
    }

    public Hospital update(Hospital hospital) {
        Hospital dbHospital = hospitalRepository.findById(hospital.getCnpj()).orElse(null);
        if (dbHospital != null) {
            return hospitalRepository.save(hospital);
        } else {
            throw new RuntimeException("Hospital não encontrado");
        }
    }

    public List<Hospital> getAll() {
        return hospitalRepository.findAll();
    }

}
