package pl.bliasz.prescription_web_service.doctor;


import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

}
