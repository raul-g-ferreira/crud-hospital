package com.example.crud_hospital.controller;

import com.example.crud_hospital.model.Hospital;
import com.example.crud_hospital.service.HospitalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospital")
public class HospitalController {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/getall")
    public List<Hospital> getAll() {
        return hospitalService.getAll();
    }

    @GetMapping("/get/{cnpj}")
    public Hospital getByCnpj(@PathVariable String cnpj) {
        return hospitalService.getByCnpj(cnpj);
    }

    @DeleteMapping("/delete/{cnpj}")
    public void delete(@PathVariable String cnpj) {
        hospitalService.delete(cnpj);
    }

    @PostMapping("/create")
    public Hospital create(@RequestBody Hospital hospital) {
        return hospitalService.create(hospital);
    }

    @PutMapping("/update")
    public Hospital update(@RequestBody Hospital hospital) {
        return hospitalService.update(hospital);
    }
}
