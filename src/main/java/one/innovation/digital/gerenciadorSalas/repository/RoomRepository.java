package one.innovation.digital.gerenciadorSalas.repository;

import one.innovation.digital.gerenciadorSalas.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository  extends JpaRepository<Room,Long> {

}
