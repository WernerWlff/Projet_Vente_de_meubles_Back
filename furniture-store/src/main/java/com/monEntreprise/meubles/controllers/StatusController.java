package com.monEntreprise.meubles.controllers;

import com.monEntreprise.meubles.entities.Status;
import com.monEntreprise.meubles.services.StatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/status")
public class StatusController {
    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    public ResponseEntity<List<Status>> getAllStatus(){
        return new ResponseEntity<>(statusService.getAllStatus(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Status> getStatusById(@PathVariable Long id){
        Optional<Status> status = statusService.getStatusById(id);

        if (status.isPresent()){
            return new ResponseEntity<>(status.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Status> createStatus(@RequestBody Status status){
        Status statusCreated = statusService.createStatus(status);
        return new ResponseEntity<>(statusCreated, HttpStatus.CREATED);
    }

    @PutMapping("/id")
    public ResponseEntity<Status> updateStatus(@PathVariable Long id, @RequestBody Status statusDetails){
        Optional<Status> status = statusService.updateStatus(id, statusDetails);

        if (status.isPresent()){
            return new ResponseEntity<>(status.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteStatus(@PathVariable Long id){
        Optional<Status> deletedStatus = statusService.deleteStatus(id);

        if (deletedStatus.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
