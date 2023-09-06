package jpabook.jpashop.domain;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded // 내장 타입임을 명시할 수 있다.
    private Address address;

    @OneToMany(mappedBy = "member") // 맵핑하는 게 아닌 맵핑 됨
    private List<Order> orders = new ArrayList<>();


}
