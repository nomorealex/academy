package com.ctw.workstation.team.entity;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record TeamDTOCompleted(@NotNull UUID teamUuid, String name, String product, String defaultLocation) {}
