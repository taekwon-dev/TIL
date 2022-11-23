package com.taekwonv.jpa.service;

import com.taekwonv.jpa.domain.Doctor;
import com.taekwonv.jpa.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    /* 지연 로딩 - 프록시 초기화  */
    public void initProxy() {
        List<Doctor> doctors = doctorRepository.findAll();

        for (Doctor doctor : doctors) {
            doctor.getAppointments().size();
            doctor.getPatients().size();
        }
    }


}
