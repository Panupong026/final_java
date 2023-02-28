package tda.final_app.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrePersist;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String customer_name_title;
    private String customer_firstname;
    private String customer_lastname;
    private String customer_id_no;
    private String customer_address_no;
    private String customer_sub_district;
    private String customer_district;
    private String customer_province;
    private String customer_email;
	private Date customer_birthday;
	private Date start_cover_day;
	private Date end_cover_day;
	private int premium;
	private String beneficial_info;
	private String insurance_info;
	private int insurance_id;
    private int agent_id;

    @Column(unique=true)
    private String policy_number;

    // Constructor



    public Customer(String customer_firstname, String customer_lastname) {
        this.customer_firstname = customer_firstname;
        this.customer_lastname = customer_lastname;
    }

    public Customer() {

    }

    // Getter, Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getCustomer_name_title() {
        return customer_name_title;
    }

    public void setCustomer_name_title(String customer_name_title) {
        this.customer_name_title = customer_name_title;
    }

    public String getCustomer_firstname() {
        return customer_firstname;
    }

    public void setCustomer_firstname(String customer_firstname) {
        this.customer_firstname = customer_firstname;
    }

    public String getCustomer_lastname() {
        return customer_lastname;
    }

    public void setCustomer_lastname(String customer_lastname) {
        this.customer_lastname = customer_lastname;
    }

    public String getCustomer_id_no() {
        return customer_id_no;
    }

    public void setCustomer_id_no(String customer_id_no) {
        this.customer_id_no = customer_id_no;
    }

    public String getCustomer_address_no() {
        return customer_address_no;
    }

    public void setCustomer_address_no(String customer_address_no) {
        this.customer_address_no = customer_address_no;
    }

    public String getCustomer_sub_district() {
        return customer_sub_district;
    }

    public void setCustomer_sub_district(String customer_sub_district) {
        this.customer_sub_district = customer_sub_district;
    }

    public String getCustomer_district() {
        return customer_district;
    }

    public void setCustomer_district(String customer_district) {
        this.customer_district = customer_district;
    }

    public String getCustomer_province() {
        return customer_province;
    }

    public void setCustomer_province(String customer_province) {
        this.customer_province = customer_province;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public Date getCustomer_birthday() {
        return customer_birthday;
    }

    public void setCustomer_birthday(Date customer_birthday) {
        this.customer_birthday = customer_birthday;
    }

    public Date getStart_cover_day() {
        return start_cover_day;
    }

    public void setStart_cover_day(Date start_cover_day) {
        this.start_cover_day = start_cover_day;
    }

    public Date getEnd_cover_day() {
        return end_cover_day;
    }

    public void setEnd_cover_day(Date end_cover_day) {
        this.end_cover_day = end_cover_day;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }

    public String getBeneficial_info() {
        return beneficial_info;
    }

    public void setBeneficial_info(String beneficial_info) {
        this.beneficial_info = beneficial_info;
    }

    public String getInsurance_info() {
        return insurance_info;
    }

    public void setInsurance_info(String insurance_info) {
        this.insurance_info = insurance_info;
    }

    public int getInsurance_id() {
        return insurance_id;
    }

    public void setInsurance_id(int insurance_id) {
        this.insurance_id = insurance_id;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public String getPolicy_number() {
        return policy_number;
    }

    public void setPolicy_number(String policy_number) {
        this.policy_number = policy_number;
    }

    // 1

    // public void Policy() {
    //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    //     String date = LocalDate.now().format(formatter);
    //     this.policy_number = "TIP-" + date + "-" + this.id;
    // }

    // public void generatePolicyNumber() {
    //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    //     String date = LocalDateTime.now().format(formatter);
    //     this.policy_number = "TIP-" + date + "-" + this.id;
    // }

    // @PostLoad
    // protected void onCreate() {
    //     generatePolicyNumber();
    // }

    // 2
    
    @PrePersist
    protected void onCreate() {
        // generate policy number
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        // String date = LocalDate.now().format(formatter);
        // String id = String.format("%04d", this.id);
        
        // this.policy_number = "TIP-" + date + "-" + id;
        
        start_cover_day = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(start_cover_day);
        cal.add(Calendar.YEAR, 1);
        end_cover_day = cal.getTime();
    }

    // 3

    // public void generatePolicyNumber() {
    //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    //     String date = LocalDateTime.now().format(formatter);
    //     this.policy_number = "TIP-" + date + "-" + this.id;
    // }
    
    // @PostLoad
    // protected void onCreate() {
    //     generatePolicyNumber();
    // }
    
    // @PrePersist
    // protected void onCreatePolicy() {      
    //     start_cover_day = new Date();
    //     Calendar cal = Calendar.getInstance();
    //     cal.setTime(start_cover_day);
    //     cal.add(Calendar.YEAR, 1);
    //     end_cover_day = cal.getTime();
    // }

    // 4

    // public void generatePolicyNumber() {
    //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    //     String date = LocalDateTime.now().format(formatter);
    //     this.policy_number = "TIP-" + date + "-" + this.id;
    // }
    
    // @PrePersist
    // protected void onCreate() {
    //     generatePolicyNumber();
        
    //     start_cover_day = new Date();
    //     Calendar cal = Calendar.getInstance();
    //     cal.setTime(start_cover_day);
    //     cal.add(Calendar.YEAR, 1);
    //     end_cover_day = cal.getTime();
    // }
    
}
