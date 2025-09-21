package pl.bliasz.prescription_web_service.doctor;

import org.springframework.stereotype.Controller;

@Controller
public class DoctorController {
    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
}
