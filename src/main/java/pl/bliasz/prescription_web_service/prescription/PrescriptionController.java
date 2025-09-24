package pl.bliasz.prescription_web_service.prescription;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrescriptionController {
    PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping("prescriptions")
    public ResponseEntity<Iterable<Prescription>> getAllPrescriptions(){
        return ResponseEntity.ok(prescriptionService.getAll());
    }
}
