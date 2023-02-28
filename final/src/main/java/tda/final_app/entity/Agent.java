package tda.final_app.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrePersist;

@Entity
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private Integer cert_no;
    private String type;
    private String name_title;
    private String firstname;
    private String lastname;
    private String address_no;
    private String sub_district;
    private String district;
    private String province;
    private String telephone;
    private String email;
    private Date register_date;
    private Date expire_date;

    // Constructor

    public Agent(String username, String password, Integer cert_no, String type, String name_title, String firstname, String lastname, String address_no, String sub_district, String district, String province, String telephone, String email, Date expire_date) {
        this.username = username;
        this.password = password;
        this.cert_no = cert_no;
        this.type = type;
        this.name_title = name_title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address_no = address_no;
        this.sub_district = sub_district;
        this.district = district;
        this.province = province;
        this.telephone = telephone;
        this.email = email;
        this.expire_date = expire_date;
    }

    public Agent() {

    }

    // Getter, Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCert_no() {
        return cert_no;
    }

    public void setCert_no(Integer cert_no) {
        this.cert_no = (int) (Math.random() * 100000000);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName_title() {
        return name_title;
    }

    public void setName_title(String name_title) {
        this.name_title = name_title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress_no() {
        return address_no;
    }

    public void setAddress_no(String address_no) {
        this.address_no = address_no;
    }

    public String getSub_district() {
        return sub_district;
    }

    public void setSub_district(String sub_district) {
        this.sub_district = sub_district;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    @PrePersist
    protected void onCreate() {
        register_date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(register_date);
    }
    // @PrePersist
    // protected void onCreate() {
    //     register_date = new Date();
    //     Calendar cal = Calendar.getInstance();
    //     cal.setTime(register_date);
    //     cal.add(Calendar.YEAR, 1);
    //     expire_date = cal.getTime();
    // }
}
