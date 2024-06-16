package uce.edu.ec.FutbolRelaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uce.edu.ec.FutbolRelaciones.clases.Players;
import uce.edu.ec.FutbolRelaciones.clases.Team;

import java.util.List;
import java.util.Optional;

public interface PlayersRepository extends JpaRepository<Players, Long> {
    List<Players> findByTeam(Team team);
    Optional<Players> findByNombreAndTeam(String nombre, Team team);
}

