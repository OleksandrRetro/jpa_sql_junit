package org.med.poc.service;

import org.med.poc.entity.Patient;

import java.util.List;

public interface PatientService {
    Patient addPatient(Patient patient);

    void deletePatient(long id);

    Patient getPatientByName(String name);

    Patient editPatient(Patient patient);

    List<Patient> getAllPatients();

    List<Patient> getPatientsByDoctorId(Long id);
}
