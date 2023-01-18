package hello.itemservice.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity // JPA가 사용하는 객체라는 뜻
@Table(name = "item")  //객체 명이랑 같으면 생략가능
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //@Id 는 테이블의 PK와 해당 필드 매핑
    private Long id;

    @Column(name = "item_name", length = 10) // 이름 같으면 생략 가능 price, quantity
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
