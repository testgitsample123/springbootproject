package springboot.api.tutorial.model;

import java.util.Objects;

import javax.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "products")
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = { "created_at", "updated_at" }, allowGetters = true)
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer id;
  @Column(name = "title")
  private String title;
  @Column(name = "description")
  private String description;
  @Column(name = "price")
  private float price;
  @Column(name = "category")
  private String category;
  /*@Column(nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  private Date created_at;
  @Column(nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  private Date updated_at;
  */public Product() {}
  public Product(Integer id, String title, String description, float price,String category) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.price = price;
    this.category = category;
  }
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
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
  public float getPrice() {
    return price;
  }
  public void setPrice(float price) {
    this.price = price;
  }
  public String getCategory() {
   return category;
 }
 public void setCategory(String category) {
   this.category = category;
 }
  /*public Date getCreated_at() {
    return created_at;
  }
  public Date getUpdated_at() {
    return updated_at;
  }*/
  @Override
  public boolean equals(Object p) {

    if (this == p)
      return true;
    if (!(p instanceof Product))
      return false;
    Product product = (Product) p;
    return Objects.equals(this.id, product.id) && Objects.equals(this.title, product.title) && Objects.equals(this.description, product.description)
        && Objects.equals(this.price, product.price) && Objects.equals(this.category, product.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.title, this.description, this.price,this.category);
  }

  @Override
  public String toString() {
    return "Product[id=" + id + ", title="+ title + ", description=" + description + ",price="+price+",category=" + category + "]";
  }
}

