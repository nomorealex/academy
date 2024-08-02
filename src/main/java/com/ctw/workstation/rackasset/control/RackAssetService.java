package com.ctw.workstation.rackasset.control;

import com.ctw.workstation.rackasset.entity.RackAsset;
import com.ctw.workstation.team.entity.Team;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class RackAssetService implements PanacheRepositoryBase<RackAsset, UUID> {

    public RackAsset findRackAssetById(UUID rackAssetUuid){
        return findById(rackAssetUuid);
    }

    public List<RackAsset> findAllRackAssets(){
        return listAll();
    }

    @Transactional
    public RackAsset addRackAsset(RackAsset rackAsset){
        //Maybe we should make some validations in order to see if the user sends the UUID field.
        this.persist(rackAsset);
        return rackAsset;
    }

    @Transactional
    public void removeRackAsset(UUID uuidRackAsset) {
        this.listAll().removeIf(n -> n.getId().equals(uuidRackAsset));
    }
}