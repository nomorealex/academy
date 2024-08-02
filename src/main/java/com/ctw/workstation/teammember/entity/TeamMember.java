package com.ctw.workstation.teammember.entity;

import com.ctw.workstation.shared.entity.AbstractTimeEntity;
import com.ctw.workstation.team.entity.Team;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "T_TEAM_MEMBER")
public class TeamMember extends AbstractTimeEntity {

    @Column(name = "TEAM_ID", nullable = false)
    public UUID teamId;

    @Column(name = "CTW_ID", length = 8, nullable = false, unique = true)
    public String ctwId;

    @Column(name = "NAME", length = 50)
    public String name;

    @JoinColumn(name = "TEAM_ID", updatable = false, insertable = false)
    @ManyToOne(targetEntity = Team.class, fetch = FetchType.LAZY)
    public Team team;

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public UUID getTeamId() {return teamId;}

    public void setTeamId(UUID teamId) {this.teamId = teamId;}

    public String getCtwId() {return ctwId;}

    public void setCtwId(String ctwId) {this.ctwId = ctwId;}
}
