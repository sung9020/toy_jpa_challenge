package jpa_challenge.domain;

import javax.persistence.Entity;

/*
 *
 * @author snow
 * @since 2021/05/22
 */
@Entity
public class Movie extends Item {
    private String director;
    private String actor;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
