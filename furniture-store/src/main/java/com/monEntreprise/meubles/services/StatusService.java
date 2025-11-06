package com.monEntreprise.meubles.services;

import com.monEntreprise.meubles.entities.Status;
import com.monEntreprise.meubles.repositories.StatusRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class StatusService {
    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository){
        this.statusRepository = statusRepository;
    }

    public List<Status> getAllStatus(){
        return statusRepository.findAll();
    }

    public Optional<Status> getStatusById(Long id){
        return statusRepository.findById(id);
    }

    @Transactional
    public Status createStatus(Status status){
        return statusRepository.save(status);
    }

    @Transactional
    public Optional<Status> updateStatus(Long id, Status statusDetails){
        Optional<Status> optionalStatus = statusRepository.findById(id);

        if (optionalStatus.isPresent()){
            Status existingStatus = optionalStatus.get();
            existingStatus.setStatus(statusDetails.getStatus());
            Status updatedStatus = statusRepository.save(existingStatus);
            return Optional.of(updatedStatus);
        }
        return Optional.empty();
    }

    @Transactional
    public Optional<Status> deleteStatus(Long id){
        Optional<Status> status = statusRepository.findById(id);

        if (status.isPresent()){
            statusRepository.delete(status.get());
        }
        return status;
    }
}
