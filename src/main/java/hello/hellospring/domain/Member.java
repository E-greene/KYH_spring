package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {

    //PK 매핑
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //만약 db의 column명이 username이면 @Column(name = "username") 이렇게 해준다.
    private String name;

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
}
