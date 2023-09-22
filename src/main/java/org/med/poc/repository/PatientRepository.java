package org.med.poc.repository;

import org.med.poc.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query(value = "select * from patient where doctor_id = :id", nativeQuery = true)
    List<Patient> findPatientsByDoctorId(@Param("id") Long id);

    @Query(value = "select * from patient where name = :name", nativeQuery = true)
    Patient findPatientByName(@Param("name") String name);
}
