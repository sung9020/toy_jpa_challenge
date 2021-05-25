package jpa_challenge.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

/*
 *
 * @author snow
 * @since 2021/05/25
 */
@Embeddable
public class Address {
    @Column(length = 10)
    private String city;
    @Column(length = 20)
    private String street;
    @Column(length = 5)
    private String zipcode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    private void setStreet(String street) {
        this.street = street;
    }

    private String getZipcode() {
        return zipcode;
    }

    private void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String fullAddress(){
        return getCity() + " " + getStreet() + " " + getZipcode();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getCity(), address.getCity()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getZipcode(), address.getZipcode());
    } // 프록시일때도 진짜 객체에 접근이 되므로 getter를 쓰자

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }
}
