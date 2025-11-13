package com.monEntreprise.meubles.services;

import com.monEntreprise.meubles.entities.Furniture;
import com.monEntreprise.meubles.entities.Status;
import com.monEntreprise.meubles.entities.Type;
import com.monEntreprise.meubles.entities.User;
import com.monEntreprise.meubles.repositories.FurnitureRepository;
import com.monEntreprise.meubles.repositories.StatusRepository;
import com.monEntreprise.meubles.repositories.TypeRepository;
import com.monEntreprise.meubles.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FurnitureService {
    private final FurnitureRepository furnitureRepository;
    private final UserRepository userRepository;
    private final StatusRepository statusRepository;
    private final TypeRepository typeRepository;

    public FurnitureService(FurnitureRepository furnitureRepository, UserRepository userRepository, StatusRepository statusRepository, TypeRepository typeRepository) {
        this.furnitureRepository = furnitureRepository;
        this.userRepository = userRepository;
        this.statusRepository = statusRepository;
        this.typeRepository = typeRepository;
    }

    public List<Furniture> getAllFurnitures(){
        return furnitureRepository.findAll();
    }

    public Optional<Furniture> getFurnitureById(Long id){
        return furnitureRepository.findById(id);
    }

    @Transactional
    public Furniture createFurniture(Furniture furniture){
        Long userId = furniture.getUser().getId();
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        User user = userOptional.get();

        Long statusId = furniture.getStatus().getId();
        Optional<Status> statusOptional = statusRepository.findById(statusId);
        if (statusOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Status status = statusOptional.get();

        Long typeId = furniture.getType().getId();
        Optional<Type> typeOptional = typeRepository.findById(typeId);
        if (typeOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Type type = typeOptional.get();

        furniture.setUser(user);
        furniture.setStatus(status);
        furniture.setType(type);
        return furnitureRepository.save(furniture);
    }

    @Transactional
    public Optional<Furniture> updateFurniture(Long id, Furniture furnitureDetails){
        Optional<Furniture> optionalFurniture = furnitureRepository.findById(id);

        if (optionalFurniture.isPresent()){
            Furniture existingFurniture = optionalFurniture.get();
            existingFurniture.setTitle(furnitureDetails.getTitle());
            existingFurniture.setStatus(furnitureDetails.getStatus());
            existingFurniture.setPrice(furnitureDetails.getPrice());
            Furniture updatedFurniture = furnitureRepository.save(existingFurniture);
            return Optional.of(updatedFurniture);
        }
        return Optional.empty();
    }

    @Transactional
    public Optional<Furniture> deleteFurniture(Long id){
        Optional<Furniture> furniture = furnitureRepository.findById(id);

        if (furniture.isPresent()){
            furnitureRepository.delete(furniture.get());
        }
        return furniture;
    }
}
