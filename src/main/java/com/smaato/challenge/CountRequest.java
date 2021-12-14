package com.smaato.challenge;

import lombok.Data;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 * @author Salmane Mhamedi
 */


@Data
public class CountRequest {

    @NotNull
    private int id;

    @Pattern(regexp="^(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$")
    private String endpoint;


}
