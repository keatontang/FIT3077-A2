package com.fit3077.assignment2.service;

import com.fit3077.assignment2.dao.PatientDao;
import com.fit3077.assignment2.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Business logic
 *
 * @Service decorator: where @Component and @Repository are injected into
 */

@Service
public class PatientService {

    private final PatientDao patientDao;

    /**
     * @Autowired: dependency injection
     * @Qualifire: the name needs to match that of @Component or @Repository that you want to inject
     * @param patientDao
     */
    @Autowired
    public PatientService(@Qualifier("fakeDao") PatientDao patientDao){
        this.patientDao = patientDao;
    }

    public boolean addPatient(Patient patient){
        return patientDao.insertPatient(patient);
    }

    public List<Patient> getAllPatients(){
        return patientDao.selectAllPatient();
    }
}
