package com.ctw.workstation.team.control;

import com.ctw.workstation.team.entity.Team;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TeamService implements PanacheRepositoryBase<Team, UUID> {

    public Team findTeamById(UUID teamUuid){
        return findById(teamUuid);
    }

    public List<Team> findAllTeams(){
        return listAll();
    }

    @Transactional
    public void addTeam(Team team){
        //Maybe we should make some validations in order to see if the user sends the UUID field.
        this.persist(team);
    }

    @Transactional
    public void updateTeam(UUID uuidTeam, Team team){
        Team _team = findById(uuidTeam);
        _team.setName(team.getName());
        _team.setProduct(team.getProduct());
        _team.setDefault_location(team.getDefault_location());
        this.persist(_team);
    }


    @Transactional
    public void deleteTeam(UUID uuidTeam){
        delete("id", uuidTeam);
    }
}