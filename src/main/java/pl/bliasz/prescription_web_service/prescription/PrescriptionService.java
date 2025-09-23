package pl.bliasz.prescription_web_service.prescription;

import org.springframework.stereotype.Service;

@Service
public class PrescriptionService {
    PrescriptionRepository prescriptionRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public Iterable<Prescription> getAll(){
        return prescriptionRepository.findAll();
    }
}
