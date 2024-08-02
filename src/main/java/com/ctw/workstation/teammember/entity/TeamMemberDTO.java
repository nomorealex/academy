package com.ctw.workstation.teammember.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record TeamMemberDTO(@NotNull UUID teamId, String ctwId, String name) {}
