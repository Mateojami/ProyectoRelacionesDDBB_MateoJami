package uce.edu.ec.FutbolRelaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uce.edu.ec.FutbolRelaciones.clases.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
}
