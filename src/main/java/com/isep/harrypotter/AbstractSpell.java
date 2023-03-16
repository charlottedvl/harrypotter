package com.isep.harrypotter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public abstract class AbstractSpell{
    private String name;
    private int damage;
    private String description;
    private int year;
    private String type;
    private String effectOne;
    private String effectTwo;

}
