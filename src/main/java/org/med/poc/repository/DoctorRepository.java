package org.med.poc.repository;

import org.med.poc.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query(value = "select * from doctor where name = :name", nativeQuery = true)
    Doctor findDoctorByName(@Param("name") String name);
}
