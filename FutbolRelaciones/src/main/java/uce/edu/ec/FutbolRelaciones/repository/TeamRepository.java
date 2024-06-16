package uce.edu.ec.FutbolRelaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uce.edu.ec.FutbolRelaciones.clases.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
