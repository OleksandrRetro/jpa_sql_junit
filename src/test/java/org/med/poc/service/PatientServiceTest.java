package org.med.poc.service;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.med.poc.entity.Doctor;
import org.med.poc.entity.Patient;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = org.med.poc.config.TestDataBaseConfig.class)
public class PatientServiceTest {

    @Resource
    private EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    @Resource
    private DoctorService doctorService;
    @Resource
    private PatientService patientService;

    @Before
    public void setUp() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Test
    public void testSaveDoctor() {
        Doctor doctor = new Doctor("Igor");
        doctorService.addDoctor(doctor);

        Patient patient1 = new Patient();
        patient1.setDoctor(doctor);
        patient1.setFirstName("John");
        patient1.setLastName("Rambo");

        Patient patient2 = new Patient();
        patient2.setDoctor(doctor);
        patient2.setFirstName("Sarah");
        patient2.setLastName("Connor");

        patientService.addPatient(patient1);
        patientService.addPatient(patient2);

        List<Patient> result = patientService.getPatientsByDoctorId(doctor.getId());

        Assert.assertEquals(String.format("Doctor %s should have %d patients.", doctor.getName(), result.size()),
                result.size(), 2);
    }
}
