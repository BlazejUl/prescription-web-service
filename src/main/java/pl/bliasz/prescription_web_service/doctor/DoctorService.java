package pl.bliasz.prescription_web_service.doctor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public ResponseEntity<Iterable<Doctor>> getAll(){
        return ResponseEntity.ok(doctorRepository.findAll());
    }

    public ResponseEntity<Doctor> getById(Integer id){
        return doctorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    public ResponseEntity<Doctor> createNew(Doctor doctor){
        Doctor savedDoctor = doctorRepository.save(doctor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("doctors/{id}")
                .buildAndExpand(savedDoctor.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedDoctor);
    }
}
