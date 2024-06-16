package uce.edu.ec.FutbolRelaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uce.edu.ec.FutbolRelaciones.clases.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
