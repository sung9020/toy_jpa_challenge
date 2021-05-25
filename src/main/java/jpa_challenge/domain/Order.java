package jpa_challenge.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

/*
 *
 * @author snow
 * @since 2021/04/26
 */
@Entity
@Table(name ="ORDERS")
public class Order extends BaseEntity  {
    @Id @GeneratedValue
    @Column(name ="ORDER_ID")
    private Long id;
//    @Column(name ="MEMBER_ID")
//    private Long memberId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name= "MEMBER_ID")
    private Member member; // 연관관계의 주인

    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    @OneToMany(mappedBy = "order", cascade = ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;


    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

}
