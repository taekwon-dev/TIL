package com.taekwonv.jpa.repository;


import com.taekwonv.jpa.domain.Doctor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private DoctorRepository doctorRepository;

    @BeforeEach
    public void init() {
        List<Doctor> doctors = new ArrayList<>();

        for (long i = 1; i <= 5; i++) {
            Doctor doctor = new Doctor("Doctor " + i);
            doctors.add(doctor);
        }
        doctorRepository.saveAll(doctors);

    }

    @AfterEach
    public void teardown() {
        doctorRepository.deleteAll();
    }

    @Test
    @DisplayName("MultiBagException - 즉시 로딩 관계")
    void 즉시로딩_N_Plus_1() {

        /**
         * N + 1
         *
         * Hibernate: select doctor0_.id as id1_1_, doctor0_.name as name2_1_ from doctor doctor0_ (5)
         *
         * (1)
         * Hibernate: select appointmen0_.doctor_id as doctor_i2_0_0_, appointmen0_.id as id1_0_0_, appointmen0_.id as id1_0_1_, appointmen0_.doctor_id as doctor_i2_0_1_ from appointment appointmen0_ where appointmen0_.doctor_id=?
         * Hibernate: select patients0_.doctor_id as doctor_i3_2_0_, patients0_.id as id1_2_0_, patients0_.id as id1_2_1_, patients0_.doctor_id as doctor_i3_2_1_, patients0_.name as name2_2_1_ from patient patients0_ where patients0_.doctor_id=?
         *
         * (2)
         * Hibernate: select appointmen0_.doctor_id as doctor_i2_0_0_, appointmen0_.id as id1_0_0_, appointmen0_.id as id1_0_1_, appointmen0_.doctor_id as doctor_i2_0_1_ from appointment appointmen0_ where appointmen0_.doctor_id=?
         * Hibernate: select patients0_.doctor_id as doctor_i3_2_0_, patients0_.id as id1_2_0_, patients0_.id as id1_2_1_, patients0_.doctor_id as doctor_i3_2_1_, patients0_.name as name2_2_1_ from patient patients0_ where patients0_.doctor_id=?
         *
         * (3)
         * Hibernate: select appointmen0_.doctor_id as doctor_i2_0_0_, appointmen0_.id as id1_0_0_, appointmen0_.id as id1_0_1_, appointmen0_.doctor_id as doctor_i2_0_1_ from appointment appointmen0_ where appointmen0_.doctor_id=?
         * Hibernate: select patients0_.doctor_id as doctor_i3_2_0_, patients0_.id as id1_2_0_, patients0_.id as id1_2_1_, patients0_.doctor_id as doctor_i3_2_1_, patients0_.name as name2_2_1_ from patient patients0_ where patients0_.doctor_id=?
         *
         * (4)
         * Hibernate: select appointmen0_.doctor_id as doctor_i2_0_0_, appointmen0_.id as id1_0_0_, appointmen0_.id as id1_0_1_, appointmen0_.doctor_id as doctor_i2_0_1_ from appointment appointmen0_ where appointmen0_.doctor_id=?
         * Hibernate: select patients0_.doctor_id as doctor_i3_2_0_, patients0_.id as id1_2_0_, patients0_.id as id1_2_1_, patients0_.doctor_id as doctor_i3_2_1_, patients0_.name as name2_2_1_ from patient patients0_ where patients0_.doctor_id=?
         *
         * (5)
         * Hibernate: select appointmen0_.doctor_id as doctor_i2_0_0_, appointmen0_.id as id1_0_0_, appointmen0_.id as id1_0_1_, appointmen0_.doctor_id as doctor_i2_0_1_ from appointment appointmen0_ where appointmen0_.doctor_id=?
         * Hibernate: select patients0_.doctor_id as doctor_i3_2_0_, patients0_.id as id1_2_0_, patients0_.id as id1_2_1_, patients0_.doctor_id as doctor_i3_2_1_, patients0_.name as name2_2_1_ from patient patients0_ where patients0_.doctor_id=?
         *
         */

        // given
        List<Doctor> doctors = doctorRepository.findAll();

        // then
        assertThat(doctors.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("MultiBagException - 지연 로딩 관계")
    void 지연로딩_N_Plus_1() {

        // given
        List<Doctor> doctors = doctorRepository.findAll();

//        for (Doctor doctor : doctors) {
//            // 프록시 초기화
//            doctor.getAppointments();
//            doctor.getPatients();
//        }

        for (int i = 0; i < doctors.size(); i++) {
            doctors.get(i).getPatients().size();
            doctors.get(i).getAppointments().size();
        }


        // then
        assertThat(doctors.size()).isEqualTo(5);
    }
}