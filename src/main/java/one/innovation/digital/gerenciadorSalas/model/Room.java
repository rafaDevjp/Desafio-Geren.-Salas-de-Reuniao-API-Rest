package one.innovation.digital.gerenciadorSalas.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "meetingRoom")
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
        private String endHour;







}
