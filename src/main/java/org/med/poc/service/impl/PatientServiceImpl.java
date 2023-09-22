package org.med.poc.service.impl;

import org.med.poc.entity.Patient;
import org.med.poc.repository.PatientRepository;
import org.med.poc.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.saveAndFlush(patient);
    }

    @Override
    public void deletePatient(long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Patient getPatientByName(String name) {
        return patientRepository.findPatientByName(name);
    }

    @Override
    public Patient editPatient(Patient patient) {
        return patientRepository.saveAndFlush(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public List<Patient> getPatientsByDoctorId(Long id) {
        return patientRepository.findPatientsByDoctorId(id);
    }
}
