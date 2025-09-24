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

    public ResponseEntity<Doctor> change(Integer id, Doctor newDoctor){
        return doctorRepository.findById(id)
                .map(oldDoctor -> {
                    oldDoctor.setPwz(newDoctor.getPwz());
                    oldDoctor.setFullName(newDoctor.getFullName());
                    oldDoctor.setPassword(newDoctor.getPassword());
                    return doctorRepository.save(oldDoctor);})
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Doctor> changePartialy(Integer id, Doctor newDoctor){
        return doctorRepository.findById(id)
                .map(oldDoctor -> {
                    if (!newDoctor.getPwz().isBlank()) oldDoctor.setPwz(newDoctor.getPwz());
                    if (!newDoctor.getFullName().isBlank()) oldDoctor.setFullName(newDoctor.getFullName());
                    if (!newDoctor.getPassword().isBlank()) oldDoctor.setPassword(newDoctor.getPassword());
                    return doctorRepository.save(oldDoctor);})
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> delete(Integer id){
        if(!doctorRepository.existsById(id)) return ResponseEntity.notFound().build();

        doctorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
