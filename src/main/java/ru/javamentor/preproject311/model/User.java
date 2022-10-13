package ru.javamentor.preproject311.model;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   protected Integer id;

   @Column(name = "name")
   protected String name;

   @Column(name = "surName")
   protected String surName;

   @Column(name = "email")
   protected String email;

   public User() {

   }
   
   public User(String name, String surName, String email) {
      this.name = name;
      this.surName = surName;
      this.email = email;
   }

    public User(int id, String name, String surName, String email) {
       this.id = id;
       this.name = name;
       this.surName = surName;
       this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String lastName) {
        this.surName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getId() != user.getId()) return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        if (getSurName() != null ? !getSurName().equals(user.getSurName()) : user.getSurName() != null) return false;
        return getEmail() != null ? getEmail().equals(user.getEmail()) : user.getEmail() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSurName() != null ? getSurName().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + surName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
