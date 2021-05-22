package net.tuto.pfe.projet.v4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.tuto.pfe.projet.v4.Model.Seance;

@Repository
public interface SeanceRepository  extends JpaRepository<Seance,Long> {

}
