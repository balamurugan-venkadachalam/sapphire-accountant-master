package ae.kbgroup.sapphire.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the t_customer_details database table.
 * 
 */
@Entity
@Table(name="t_customer_details")
@NamedQuery(name="TCustomerDetail.findAll", query="SELECT t FROM TCustomerDetail t")
public class TCustomerDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="ADDRESS_1", length=100)
	private String address1;

	@Column(name="ADDRESS_2", length=100)
	private String address2;

	@Column(name="ADDRESS_3", length=75)
	private String address3;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="CUSTOMER_NAME", length=150)
	private String customerName;

	@Column(length=100)
	private String description;

	@Column(name="IS_ACTIVE")
	private int isActive;

	//bi-directional many-to-one association to TInventoryMaster
	@OneToMany(mappedBy="TCustomerDetail")
	private List<TInventoryMaster> TInventoryMasters;

	public TCustomerDetail() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return this.address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsActive() {
		return this.isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public List<TInventoryMaster> getTInventoryMasters() {
		return this.TInventoryMasters;
	}

	public void setTInventoryMasters(List<TInventoryMaster> TInventoryMasters) {
		this.TInventoryMasters = TInventoryMasters;
	}

	public TInventoryMaster addTInventoryMaster(TInventoryMaster TInventoryMaster) {
		getTInventoryMasters().add(TInventoryMaster);
		TInventoryMaster.setTCustomerDetail(this);

		return TInventoryMaster;
	}

	public TInventoryMaster removeTInventoryMaster(TInventoryMaster TInventoryMaster) {
		getTInventoryMasters().remove(TInventoryMaster);
		TInventoryMaster.setTCustomerDetail(null);

		return TInventoryMaster;
	}

}