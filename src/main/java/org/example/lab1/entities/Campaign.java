package org.example.lab1.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Campaign.findAll", query = "select c from Campaign as c")
})
@Table(name = "CAMPAIGN")
@Getter @Setter
public class Campaign {
    public Campaign(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "LENGTH")
    private Integer length;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name="DUNGEON_MASTER_ID")
    private Person dungeonMaster;

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
