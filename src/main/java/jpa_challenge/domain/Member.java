package jpa_challenge.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
 *
 * @author snow
 * @since 2021/04/26
 */
@Entity
public class Member extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="MEMBER_ID")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
