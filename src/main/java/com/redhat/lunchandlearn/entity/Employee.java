package com.redhat.lunchandlearn.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import com.redhat.lunchandlearn.entity.Address;
import javax.persistence.ManyToOne;
@Entity public class Employee implements java.io.Serializable {
  @Id private @GeneratedValue(strategy=GenerationType.AUTO) @Column(name="id",updatable=false,nullable=false) Long id=null;
  @Version private @Column(name="version") int version=0;
  public Long getId(){
    return this.id;
  }
  public void setId(  final Long id){
    this.id=id;
  }
  public int getVersion(){
    return this.version;
  }
  public void setVersion(  final int version){
    this.version=version;
  }
  @NotNull @Column private Integer number;
  public Integer getNumber(){
    return this.number;
  }
  public void setNumber(  final Integer number){
    this.number=number;
  }
  @NotNull @Column private String name;
  public String getName(){
    return this.name;
  }
  public void setName(  final String name){
    this.name=name;
  }
  @Override public String toString(){
    return String.format("Employee [id=%s, version=%s, number=%s, name=%s]",id,version,number,name);
  }
  @Column private Long salary;
  public Long getSalary(){
    return this.salary;
  }
  public void setSalary(  final Long salary){
    this.salary=salary;
  }
  @Column private Boolean isManager;
  public Boolean getIsManager(){
    return this.isManager;
  }
  public void setIsManager(  final Boolean isManager){
    this.isManager=isManager;
  }
  @Column private String email;
  public String getEmail(){
    return this.email;
  }
  public void setEmail(  final String email){
    this.email=email;
  }
  @Column private String zipCode;
  public String getZipCode(){
    return this.zipCode;
  }
  public void setZipCode(  final String zipCode){
    this.zipCode=zipCode;
  }
  @Column private Integer addressNumber;
  public Integer getAddressNumber(){
    return this.addressNumber;
  }
  public void setAddressNumber(  final Integer addressNumber){
    this.addressNumber=addressNumber;
  }
//  @ManyToOne private Address address=new Address();
//  public Address getAddress(){
//    return this.address;
//  }
//  public void setAddress(  final Address address){
//    this.address=address;
//  }
}
