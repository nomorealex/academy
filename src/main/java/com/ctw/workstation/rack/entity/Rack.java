package com.ctw.workstation.rack.entity;


import com.ctw.workstation.shared.entity.AbstractTimeEntity;
import com.ctw.workstation.team.entity.Team;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "T_RACK")
public class Rack extends AbstractTimeEntity {

    @Column(name = "SERIAL_NUMBER", length = 50, nullable = false, unique = true)
    public String serialNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 8, nullable = false)
    public Status status;

    @Column(name = "TEAM_ID")
    public UUID teamId;

    @Column(name = "DEFAULT_LOCATION", length = 10, nullable = false)
    public String default_location;

    @ManyToOne(targetEntity = Team.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID", updatable = false, insertable = false, nullable = false)
    public Team team;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
    }

    public String getDefault_location() {
        return default_location;
    }

    public void setDefault_location(String default_location) {
        this.default_location = default_location;
    }
}
