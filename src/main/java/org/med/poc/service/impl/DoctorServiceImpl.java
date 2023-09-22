package org.med.poc.service.impl;

import org.med.poc.entity.Doctor;
import org.med.poc.repository.DoctorRepository;
import org.med.poc.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.saveAndFlush(doctor);
    }

    @Override
    public void deleteDoctor(long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public Doctor getDoctorByName(String name) {
        return doctorRepository.findDoctorByName(name);
    }

    @Override
    public Doctor editDoctor(Doctor doctor) {
        return doctorRepository.saveAndFlush(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
}
