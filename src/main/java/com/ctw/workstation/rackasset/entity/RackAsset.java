package com.ctw.workstation.rackasset.entity;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.shared.entity.AbstractEntity;
import com.ctw.workstation.team.entity.Team;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "T_RACK_ASSET")
public class RackAsset extends AbstractEntity {

    @Column(name = "ASSET_TAG")
    public String assetTag;

    @Column(name = "RACK_ID", length = 50, nullable = false)
    public UUID rackId;

    @ManyToOne(targetEntity = Rack.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "RACK_ID", updatable = false, insertable = false, nullable = false)
    public Rack rack;

    public RackAsset() {}

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public UUID getRackId() {
        return rackId;
    }

    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }
}
