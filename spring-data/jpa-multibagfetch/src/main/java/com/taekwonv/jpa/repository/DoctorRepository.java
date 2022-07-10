package com.taekwonv.jpa.repository;

import com.taekwonv.jpa.domain.Doctor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("SELECT d FROM Doctor d")
    List<Doctor> findAll();

    @Query("SELECT d FROM Doctor d JOIN FETCH d.patients")
    List<Doctor> findAllJoinFetch();

    @EntityGraph(attributePaths = "patients")
    @Query("SELECT d FROM Doctor d")
    List<Doctor> findAllEntityGraph();
}
