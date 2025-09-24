package pl.bliasz.prescription_web_service.doctor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("doctors")
    public ResponseEntity<Iterable<Doctor>> getAllDoctors(){
        return ResponseEntity.ok(doctorService.getAll());
    }
}
