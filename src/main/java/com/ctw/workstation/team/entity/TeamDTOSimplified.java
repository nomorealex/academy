package com.ctw.workstation.team.entity;

import jakarta.validation.constraints.NotNull;

public record TeamDTOSimplified(@NotNull String name, String product, String defaultLocation) {}
