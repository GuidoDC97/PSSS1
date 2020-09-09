package com.psss.registro.backend.repositories;

import com.psss.registro.backend.models.Classe;
import com.psss.registro.backend.models.Studente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudenteRepository extends JpaRepository<Studente, Long> {

    List<Studente> findByClasse(Classe classe);

}
