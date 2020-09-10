package com.psss.registro.backend.models;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity(name = "insegnamenti") @ToString(exclude = {"docente", "materia", "classe"})
@EqualsAndHashCode()
public class Insegnamento extends AbstractEntity{

    @ManyToOne
    @NotNull(message = "Selezionare il docente")
    private Docente docente;
    @ManyToOne
    @NotNull(message = "Selezionare la materia")
    private Materia materia;
    @ManyToOne
    @NotNull(message = "Selezionare la classe")
    private Classe classe;

    public Insegnamento(Docente docente, Materia materia, Classe classe) {
        this.docente = docente;
        this.materia = materia;
        this.classe = classe;
    }

    public void setDocente(Docente docente){
        this.docente = docente;
        docente.getInsegnamenti().add(this);
    }

    public void setClasse(Classe classe){
        this.classe = classe;
        classe.getInsegnamenti().add(this);
    }

    public String toString() {
        return docente.toString() + " (" + materia.getNome() + ")";
    }
}
