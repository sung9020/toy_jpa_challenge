package jpa_challenge.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

/*
 *
 * @author snow
 * @since 2021/05/10
 */
@Entity
public class Delivery extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipcode;

    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order Order;

}
