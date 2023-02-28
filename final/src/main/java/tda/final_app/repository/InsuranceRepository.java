package tda.final_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tda.final_app.entity.Insurance;

public interface InsuranceRepository extends JpaRepository <Insurance, Integer> {
    
}
