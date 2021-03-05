package model;

import javax.persistence.*;

@Entity
@Table
public class Customer {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   @Column(nullable = false)
   private String name;
   private String address;
   public Customer(){}
   public Customer(String name, String address) {
      this.name = name;
      this.address = address;
   }

   public Customer(int id, String name, String address) {
      this.id = id;
      this.name = name;
      this.address = address;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }
}
