package pl.bliasz.prescription_web_service.prescription;


import org.springframework.data.repository.CrudRepository;

public interface PrescriptionRepository extends CrudRepository<Prescription,Integer> {
}
