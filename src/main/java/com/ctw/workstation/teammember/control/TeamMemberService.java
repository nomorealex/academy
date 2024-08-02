package com.ctw.workstation.teammember.control;

import com.ctw.workstation.teammember.control.mapper.ITeamMemberMapper;
import com.ctw.workstation.teammember.entity.TeamMember;
import com.ctw.workstation.teammember.entity.TeamMemberDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TeamMemberService implements PanacheRepositoryBase<TeamMember, UUID> {

    @Inject
    ITeamMemberMapper teamMemberMapper;

    public TeamMemberDTO findTeamMemberById(UUID teamUuid){
        if (teamUuid == null){
            throw new BadRequestException("PLEASE, make a good request.");
        }

        TeamMember teamMember = find("id", teamUuid).firstResult();
        if (teamMember == null){
            throw new NotFoundException("The team was not found");
        }

        return teamMemberMapper.toDTO(teamMember);
    }

    public List<TeamMemberDTO> findAllTeamMembers(){

        return listAll().stream()
                .map(teamMemberMapper::toDTO)
                .toList();
    }

    @Transactional
    public TeamMemberDTO addTeamMember(TeamMemberDTO teamMemberDTO){
        if (teamMemberDTO == null){
            throw new BadRequestException("PLEASE, make a good request.");
        }

        TeamMember teamMember = teamMemberMapper.toEntity(teamMemberDTO);
        this.persist(teamMember);
        return teamMemberDTO;
    }

    @Transactional
    public boolean removeTeamMember(UUID uuidTeamMember) {
        return this.listAll().removeIf(n -> n.getId().equals(uuidTeamMember));

    }
}








    /*
    @Transactional
    public TeamMemberDTO updateTeamMember(TeamMemberDTO teamMemberDTO){

        TeamMember teamMember1 = findTeamMemberById();

        if(teamMember1 != null){
            TeamMember teamMemberUpdated = new TeamMember();
            teamMemberUpdated.setName(teamMember.name);
            teamMemberUpdated.setCreatedAt(teamMember.createdAt);
            teamMemberUpdated.setTeamId(teamMember.teamId);
            teamMemberUpdated.setCtwId(teamMember.ctwId);

            return teamMemberUpdated;
        }

        return null;
    }
     */