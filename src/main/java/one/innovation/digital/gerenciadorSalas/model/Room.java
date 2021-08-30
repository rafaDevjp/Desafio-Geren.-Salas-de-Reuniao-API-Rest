package one.innovation.digital.gerenciadorSalas.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "meetingRoom")
@Data
public class Room {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "date", nullable = false)
        private String date;

        @Column(name = "startHour", nullable = false)
        private String startHour;

        @Column(name = "endHour", nullable = false)
        private String EndHour;


    public Room(Long id, String name, String date, String startHour, String endHour) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.startHour = startHour;
        EndHour = endHour;
    }




}
