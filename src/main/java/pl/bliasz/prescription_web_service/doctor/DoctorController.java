package pl.bliasz.prescription_web_service.doctor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
}
