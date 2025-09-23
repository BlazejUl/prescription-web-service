package pl.bliasz.prescription_web_service.patient;

public class PatientService {
    PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Iterable<Patient> getAll(){
        return patientRepository.findAll();
    }
}
