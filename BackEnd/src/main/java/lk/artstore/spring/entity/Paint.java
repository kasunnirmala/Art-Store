package lk.artstore.spring.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Paint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Member member;
    String title;
    String description;
    byte[] img;
    double price;

    public Paint() {
    }


    public Paint(Member member, String title, String description, byte[] img, double price) {
        this.member = member;
        this.title = title;
        this.description = description;
        this.img = img;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Paint{" +
                "id=" + id +
                ", member=" + member +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", img=" + Arrays.toString(img) +
                ", price=" + price +
                '}';
    }
}
