package pl.bliasz.prescription_web_service.doctor;

public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Iterable<Doctor> getAll(){
        return doctorRepository.findAll();
    }
}
