package ru.taravkov.ifmo.webservices.entity;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author vtaravkov
 * @since lab1
 */
@XmlRootElement
public enum VehicleClass {
    SUBCOMPACT,

    COMPACT,

    CROSSOVER;
}
