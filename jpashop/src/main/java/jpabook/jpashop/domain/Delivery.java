package jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    /**
     * Enum 타입은 EnumType.ORDINAL 숫자로 들어간다. READY 이면 0, COMP 1 이런식으로...
     * 만약 값이 추가될 경우 값이 밀릴 수 있다. 따라서 STRING 을 쓰자.
     */
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; // READY, COMP

}
