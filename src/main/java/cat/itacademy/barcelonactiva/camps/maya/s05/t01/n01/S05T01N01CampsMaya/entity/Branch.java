package cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "branches", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Branch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "cannot be null")
    @Column(name = "name")
    private String name;

    @NotNull(message = "cannot be null")
    @Column(name = "country")
    private String country;

    public Branch(String name, String country){
        this.name = name;
        this.country = country;
    }

}
