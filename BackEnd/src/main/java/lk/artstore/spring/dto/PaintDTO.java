package lk.artstore.spring.dto;

import java.util.Arrays;

public class PaintDTO {
    int id;
    MemberDTO memberDTO;
    String title;
    String description;
    byte[] img;
    double price;

    public PaintDTO() {
    }

    public PaintDTO(int id, MemberDTO memberDTO, String title, String description, byte[] img, double price) {
        this.id = id;
        this.memberDTO = memberDTO;
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

    public MemberDTO getMemberDTO() {
        return memberDTO;
    }

    public void setMemberDTO(MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
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
        return "PaintDTO{" +
                "id=" + id +
                ", memberDTO=" + memberDTO +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", img=" + Arrays.toString(img) +
                ", price=" + price +
                '}';
    }
}
