package ru.mahach.graphqlapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ships")
public class Ship {
    @Id
    @Column(
            name = "id",
            nullable = false,
            unique = true
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(
            name = "status",
            nullable = false
    )
    private String status;

    @Column(name = "flag")
    private String flag;

    @Column(
            name = "yearBuilt",
            nullable = false
    )
    private int yearBuilt;

    @Column(name = "homePort")
    private String homePort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public String getHomePort() {
        return homePort;
    }

    public void setHomePort(String homePort) {
        this.homePort = homePort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return yearBuilt == ship.yearBuilt && id.equals(ship.id) && name.equals(ship.name) && status.equals(ship.status) && Objects.equals(flag, ship.flag) && Objects.equals(homePort, ship.homePort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, flag, yearBuilt, homePort);
    }
}
