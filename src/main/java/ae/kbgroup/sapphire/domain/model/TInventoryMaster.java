package ae.kbgroup.sapphire.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_inventory_master database table.
 * 
 */
@Entity
@Table(name="t_inventory_master")
@NamedQuery(name="TInventoryMaster.findAll", query="SELECT t FROM TInventoryMaster t")
public class TInventoryMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="CLOSING_BAL")
	private int closingBal;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(length=100)
	private String description;

	@Column(name="DO_TOTAL")
	private int doTotal;

	@Column(name="GRN_ID", length=75)
	private String grnId;

	@Column(name="OPENINIG_BAL")
	private int openinigBal;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	//bi-directional many-to-one association to TCustomerDetail
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	private TCustomerDetail TCustomerDetail;

	public TInventoryMaster() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getClosingBal() {
		return this.closingBal;
	}

	public void setClosingBal(int closingBal) {
		this.closingBal = closingBal;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDoTotal() {
		return this.doTotal;
	}

	public void setDoTotal(int doTotal) {
		this.doTotal = doTotal;
	}

	public String getGrnId() {
		return this.grnId;
	}

	public void setGrnId(String grnId) {
		this.grnId = grnId;
	}

	public int getOpeninigBal() {
		return this.openinigBal;
	}

	public void setOpeninigBal(int openinigBal) {
		this.openinigBal = openinigBal;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public TCustomerDetail getTCustomerDetail() {
		return this.TCustomerDetail;
	}

	public void setTCustomerDetail(TCustomerDetail TCustomerDetail) {
		this.TCustomerDetail = TCustomerDetail;
	}

}