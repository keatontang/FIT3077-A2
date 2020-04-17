package com.fit3077.assignment2.dao;

import com.fit3077.assignment2.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Concrete implementation of PatientDao. Can be swapped out for actual database implementation using dependency
 * injection.
 *
 * @Repository decorator: tell Spring that this class needs to be instantiated (similar to @Component)
 */
@Repository("fakeDao")
public class FakePatientDataAccessService implements PatientDao {

    private static Map<UUID, Patient> DB = new HashMap<>();

    @Override
    public boolean insertPatient(UUID id, Patient patient) {
        DB.put(id, new Patient(id, patient.getName()));
        return true;
    }

    @Override
    public List<Patient> selectAllPatient() {
        return new ArrayList<Patient>(DB.values());
    }

    @Override
    public Optional<Patient> selectPatientById(UUID id) {
        return Optional.ofNullable(DB.get(id));
    }

    @Override
    public boolean deletePatientById(UUID id) {
        Patient patientMaybe = DB.remove(id);
        if (patientMaybe == null){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean updatePatientById(UUID id, Patient patient) {
        if (selectPatientById(id).isEmpty()){
            return false;
        } else {
            DB.put(id, new Patient(id, patient.getName()));
            return true;
        }
    }
}
