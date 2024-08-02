package com.ctw.workstation.rack.control;

import com.ctw.workstation.rack.entity.Rack;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class RackService implements PanacheRepositoryBase<Rack, UUID> {

    public Rack findRackById(UUID rackUuid){
        return findById(rackUuid);
    }

    public List<Rack> findAllRacks(){
        return listAll();
    }

    @Transactional
    public Rack addRack(Rack rack){
        //Maybe we should make some validations in order to see if the user sends the UUID field.
        persist(rack);
        return rack;
    }

    @Transactional
    public void removeRack(UUID uuidRack) {
        this.listAll().removeIf(n -> n.getId().equals(uuidRack));
    }
}
