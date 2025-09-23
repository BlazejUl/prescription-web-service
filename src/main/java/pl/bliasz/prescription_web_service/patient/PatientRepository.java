package pl.bliasz.prescription_web_service.patient;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient,Integer> {
}
