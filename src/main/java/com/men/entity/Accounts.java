package com.men.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email") })
public class Accounts implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthdate;
	
	private Date create_date;
	
	@NotBlank
	@Size(max = 50)
	private String email;
	
	@Column(columnDefinition = "NVARCHAR(255) NULL")
	private String fullname;
	
	private String image;
	
	@NotBlank
	@Size(max = 120)
	private String password;
	
	private String phone;
	
	private boolean status;
	
	@NotBlank
	@Size(max = 20)
	private String username;
	
		
	@Column(name = "provider")
	private String provider;
	@Column(name = "reset_password_token")
	private String resetPasswordToken;
	
	@Column(columnDefinition = "NVARCHAR(5) NULL")
	private String adminAstrator;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	private List<Orders> orders;

	@JsonIgnore
	@OneToMany(mappedBy = "account")
	private List<WishList> wishLists;

	@JsonIgnore
	@OneToMany(mappedBy = "account")
	private List<Feedback> feedbacks;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	private List<Address> address;

	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
  @JoinTable(name = "authorities", joinColumns = @JoinColumn(name = "account_id")
    , inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Roles> roles = new HashSet<>();

	public Accounts(@NotBlank @Size(max = 20) String username,
					@NotBlank @Size(max = 50) String email,
					@NotBlank @Size(max = 120) String encode) {
		this.username = username;
		this.email = email;
		this.password = encode;
	}
	
	public String getAdminAstrator() {
		return adminAstrator;
	}

	public void setAdminAstrator(String adminAstrator) {
		this.adminAstrator = adminAstrator;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public void addRole(Roles roles) {

		this.roles.add(roles);
	}

	public Long getAccountId() {
		return accountId;
	}
	
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public List<WishList> getWishLists() {
		return wishLists;
	}

	public void setWishLists(List<WishList> wishLists) {
		this.wishLists = wishLists;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public Accounts() {
		// TODO Auto-generated constructor stub
	}

	public Accounts(Long accountId, Date birthdate, Date create_date, @NotBlank @Size(max = 50) String email,
			String fullname, String image, @NotBlank @Size(max = 120) String password, String phone, boolean status,
			@NotBlank @Size(max = 20) String username, String address, String provider, String resetPasswordToken,
			String adminAstrator, List<Orders> orders, List<WishList> wishLists, List<Feedback> feedbacks,
			Set<Roles> roles) {
		super();
		this.accountId = accountId;
		this.birthdate = birthdate;
		this.create_date = create_date;
		this.email = email;
		this.fullname = fullname;
		this.image = image;
		this.password = password;
		this.phone = phone;
		this.status = status;
		this.username = username;
		this.provider = provider;
		this.resetPasswordToken = resetPasswordToken;
		this.adminAstrator = adminAstrator;
		this.orders = orders;
		this.wishLists = wishLists;
		this.feedbacks = feedbacks;
		this.roles = roles;
	}

	

	
	
	
	

}
