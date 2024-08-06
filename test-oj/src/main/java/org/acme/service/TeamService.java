package org.acme.service;

import org.acme.entity.Team;

import jakarta.ws.rs.core.Response;

public interface TeamService {
    Response getTeam();

    Response createTeam(Team newTeam);

    Response deleteTeam(Long id);
}
