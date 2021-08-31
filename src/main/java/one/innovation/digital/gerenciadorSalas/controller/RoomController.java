package one.innovation.digital.gerenciadorSalas.controller;


import jakarta.validation.Valid;
import one.innovation.digital.gerenciadorSalas.exceptions.ResourceNotFoundException;
import one.innovation.digital.gerenciadorSalas.model.Room;
import one.innovation.digital.gerenciadorSalas.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;


    @GetMapping("/rooms")
    public List<Room> getAll(){
        return roomRepository.findAll();
    }


    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable(value ="id") long id) throws ResourceNotFoundException  {
       Room room = roomRepository.findById(id)
                      .orElseThrow(() -> new ResourceNotFoundException("Value Not Found in DATABASE!" + id));
       return ResponseEntity.ok().body(room);
    }


    @PostMapping("/rooms")
    public Room creatRoom(@Valid @RequestBody Room room){
        return roomRepository.save(room);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable(value = "id") Long id, @RequestBody Room roomDetails) throws ResourceNotFoundException{
        Room roomUpdate = roomRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Value not found in DATABASES" + id));
                roomUpdate.setName(roomDetails.getName());
                roomUpdate.setDate(roomDetails.getDate());
                roomUpdate.setStartHour(roomDetails.getStartHour());
                roomUpdate.setEndHour(roomDetails.getEndHour());
                final Room updateToRoom = roomRepository.save(roomUpdate);
                return  ResponseEntity.ok(updateToRoom);
    }
    @DeleteMapping("/delete/{id}")
    public Map<String,Boolean> deleteRoom(@PathVariable(value = "id")Long id) throws ResourceNotFoundException{
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Value not found in DATABASES!" + id));
        roomRepository.delete(room);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;

    }










}
