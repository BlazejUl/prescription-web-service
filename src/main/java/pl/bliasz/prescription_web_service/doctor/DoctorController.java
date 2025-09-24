package pl.bliasz.prescription_web_service.doctor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("doctors")
    public ResponseEntity<Iterable<Doctor>> getAllDoctors(){
        return doctorService.getAll();
    }

    @GetMapping("doctors/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Integer id){
        return doctorService.getById(id);
    }

    @PostMapping("doctors")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor){
        return doctorService.createNew(doctor);
    }

    @PutMapping("doctors/{id}")
    public ResponseEntity<Doctor> changeDoctor(@PathVariable Integer id, @RequestBody Doctor doctor){
        return doctorService.change(id,doctor);
    }

    @PatchMapping("doctors/{id}")
    public ResponseEntity<Doctor> changeDoctorPartialy(@PathVariable Integer id, @RequestBody Doctor doctor){
        return doctorService.change(id,doctor);
    }
}
