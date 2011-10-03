package com.redhat.lunchandlearn.entity;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.util.Set;
import java.util.HashSet;
import com.redhat.lunchandlearn.entity.Employee;
import javax.persistence.OneToMany;
@Entity public class Address implements java.io.Serializable {
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
  @Column private String zipCode;
  public String getZipCode(){
    return this.zipCode;
  }
  public void setZipCode(  final String zipCode){
    this.zipCode=zipCode;
  }
  @Column private String addressName;
  public String getAddressName(){
    return this.addressName;
  }
  public void setAddressName(  final String addressName){
    this.addressName=addressName;
  }
  @Column private String city;
  public String getCity(){
    return this.city;
  }
  public void setCity(  final String city){
    this.city=city;
  }
  @Column private String state;
  public String getState(){
    return this.state;
  }
  public void setState(  final String state){
    this.state=state;
  }
//  private @OneToMany(mappedBy="address") Set<Employee> employees=new HashSet<Employee>();
//  public Set<Employee> getEmployees(){
//    return this.employees;
//  }
//  public void setEmployees(  final Set<Employee> employees){
//    this.employees=employees;
//  }
}
