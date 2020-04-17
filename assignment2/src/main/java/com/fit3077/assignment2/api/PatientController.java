package com.fit3077.assignment2.api;

import com.fit3077.assignment2.model.Patient;
import com.fit3077.assignment2.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * @RestController: REST API interface: GET, POST, DELETE, PUT
 */

@RestController
@RequestMapping("api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public void addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping(path = "{id}")
    public Patient getPatientById(@PathVariable("id") UUID id) {
        return patientService.getPatientById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePatientById(@PathVariable("id") UUID id) {
        patientService.deletePatientById(id);
    }

    @PutMapping(path = "{id}")
    public void updatePatientById(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Patient patient) {
        patientService.updatePatientById(id, patient);
    }
}
