package com.github.kaydunovDenis.model;

import com.github.kaydunovDenis.annotation.ValidateNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The object responsible for the permission to access.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionToAccess {
    @ValidateNumber
    private int counter;
}
