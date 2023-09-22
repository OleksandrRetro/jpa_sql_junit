package org.med.poc.service;

import org.med.poc.entity.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor addDoctor(Doctor bank);

    void deleteDoctor(long id);

    Doctor getDoctorByName(String name);

    Doctor editDoctor(Doctor bank);

    List<Doctor> getAllDoctors();
}
