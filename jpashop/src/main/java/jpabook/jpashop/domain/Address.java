package jpabook.jpashop.domain;

import javax.persistence.Embeddable;
import lombok.Getter;

@Embeddable // JPA 의 내장 타입으로 어딘가에 내장될 수 있음을 말한다.
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;
}

