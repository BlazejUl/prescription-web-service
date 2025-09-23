package pl.bliasz.prescription_web_service.patient;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientController {

    PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public ResponseEntity<Iterable<Patient>> getAllPatients(){
        return ResponseEntity.ok(patientService.getAll());
    }
}
