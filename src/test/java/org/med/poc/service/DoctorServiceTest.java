package org.med.poc.service;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.med.poc.entity.Doctor;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = org.med.poc.config.TestDataBaseConfig.class)
public class DoctorServiceTest {

    @Resource
    private EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    @Resource
    private DoctorService doctorService;

    @Before
    public void setUp() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Test
    public void testSaveDoctor() {
        Doctor testDoctor = new Doctor("Igor");
        Doctor dbDoctor = doctorService.addDoctor(testDoctor);
        Assert.assertEquals("Doctor is not saved in DB.", testDoctor.getName(), dbDoctor.getName());
    }
}
