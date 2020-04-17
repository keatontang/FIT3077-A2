package com.fit3077.assignment2.dao;

import com.fit3077.assignment2.model.Patient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Interface to do CRUD operations for Patient model
 */

public interface PatientDao {
    boolean insertPatient(UUID id, Patient patient);

    default boolean insertPatient(Patient patient){
        return insertPatient(UUID.randomUUID(), patient);
    }

    List<Patient> selectAllPatient();

    Optional<Patient> selectPatientById(UUID id);

    boolean deletePatientById(UUID id);

    boolean updatePatientById(UUID id, Patient patient);
}
