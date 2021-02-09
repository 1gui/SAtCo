package model.entity.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_company")
	private Long id;

	@Column(name = "name_company", length = 40, nullable = false, unique = false)
	private String name;
	
	@Column(name = "cnpj_company", length = 18, nullable = false, unique = false)
	private String cnpj;
	
	@Column(name = "email= company", length = 40, nullable = false, unique = false)
	private String email;
	
	@Column(name = "address_company", length = 40, nullable = false, unique = false)
	private String address;
	
	@Column(name = "phone_company", length = 15, nullable = false, unique = false)
	private Long phone;
	
	public Company() {}

	public Company(Long id, String name, String cnpj, String email,
			String address, Long phone) {

		setId(id);
		setName(name);
		setCnpj(cnpj);
		setEmail(email);
		setAddress(address);
		setPhone(phone);

	}

	public Company(String name, String cnpj, String email, String address, Long phone) {

		setName(name);
		setCnpj(cnpj);
		setEmail(email);
		setAddress(address);
		setPhone(phone);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}
}