package tda.final_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tda.final_app.entity.Agent;

public interface AgentRepository extends JpaRepository <Agent, Integer> {
    Agent findByUsername(String Username);
}
