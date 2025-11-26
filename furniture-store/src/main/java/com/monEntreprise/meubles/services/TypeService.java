package com.monEntreprise.meubles.services;

import com.monEntreprise.meubles.entities.Type;
import com.monEntreprise.meubles.repositories.TypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {
    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository){
        this.typeRepository = typeRepository;
    }

    public List<Type> getAllTypes(){
        return typeRepository.findAll();
    }

    public Optional<Type> getTypeById(Long id){
        return typeRepository.findById(id);
    }

    @Transactional
    public Type createType(Type type){
        return typeRepository.save(type);
    }

    @Transactional
    public Optional<Type> updateType(Long id, Type typeDetails){
        Optional<Type> optionalType = typeRepository.findById(id);

        if (optionalType.isPresent()){
            Type existingType = optionalType.get();
            existingType.setType(typeDetails.getType());
            Type updatedType = typeRepository.save(existingType);
            return Optional.of(updatedType);
        }
        return Optional.empty();
    }

    @Transactional
    public Optional<Type> deleteType(Long id){
        Optional<Type> type = typeRepository.findById(id);

        if (type.isPresent()){
            typeRepository.delete(type.get());
        }
        return type;
    }
}
