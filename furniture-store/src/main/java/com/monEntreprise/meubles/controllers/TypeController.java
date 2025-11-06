package com.monEntreprise.meubles.controllers;

import com.monEntreprise.meubles.entities.Type;
import com.monEntreprise.meubles.services.TypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/types")
public class TypeController {
    private final TypeService typeService;

    public TypeController(TypeService typeService){
        this.typeService = typeService;
    }

    @GetMapping
    public ResponseEntity<List<Type>> getAllTypes(){
        return new ResponseEntity<>(typeService.getAllTypes(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Type> getTypeById(@PathVariable Long id){
        Optional<Type> type = typeService.getTypeById(id);

        if (type.isPresent()){
            return new ResponseEntity<>(type.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Type> createType(@RequestBody Type type){
        Type typeCreated = typeService.createType(type);
        return new ResponseEntity<>(typeCreated, HttpStatus.CREATED);
    }

    @PutMapping("/id")
    public ResponseEntity<Type> updateType(@PathVariable Long id, @RequestBody Type typeDetails){
        Optional<Type> type = typeService.updateType(id, typeDetails);

        if (type.isPresent()){
            return new ResponseEntity<>(type.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteType(@PathVariable Long id){
        Optional<Type> deletedType = typeService.deleteType(id);

        if (deletedType.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
