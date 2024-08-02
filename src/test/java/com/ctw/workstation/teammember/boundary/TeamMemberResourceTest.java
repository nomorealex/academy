package com.ctw.workstation.teammember.boundary;

import com.ctw.workstation.teammember.control.TeamMemberService;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectSpy;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class TeamMemberResourceTest {

    @InjectMock
    TeamMemberService teamMemberService;
    //@InjectSpy


    @Inject
    TeamMemberResource teamMemberResource;


    @Test
    void getAllTeamsMembers() {
    }

    @Test
    void getTeamMemberById() {
    }

    @Test
    void addTeamMember() {
    }

    @Test
    void removeTeamMember() {
    }
}