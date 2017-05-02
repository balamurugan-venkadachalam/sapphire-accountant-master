package ae.kbgroup.sapphire.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_invoice_details database table.
 * 
 */
@Entity
@Table(name="t_invoice_details")
@NamedQuery(name="TInvoiceDetail.findAll", query="SELECT t FROM TInvoiceDetail t")
public class TInvoiceDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	private int amount;

	@Column(name="BOD_DEC_NO", length=60)
	private String bodDecNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="HS_CODE", length=45)
	private String hsCode;

	private int quantity;

	@Column(name="UNIT_RATE")
	private int unitRate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	private int weight;

	//bi-directional many-to-one association to MCountryOrgin
	@ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	private MCountryOrgin MCountryOrgin;

	//bi-directional many-to-one association to TInvoice
	@ManyToOne
	@JoinColumn(name="INVOICE_ID")
	private TInvoice TInvoice;

	//bi-directional many-to-one association to MPack
	@ManyToOne
	@JoinColumn(name="PACK_ID")
	private MPack MPack;

	//bi-directional many-to-one association to MProduct
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private MProduct MProduct;

	public TInvoiceDetail() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getBodDecNo() {
		return this.bodDecNo;
	}

	public void setBodDecNo(String bodDecNo) {
		this.bodDecNo = bodDecNo;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getHsCode() {
		return this.hsCode;
	}

	public void setHsCode(String hsCode) {
		this.hsCode = hsCode;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnitRate() {
		return this.unitRate;
	}

	public void setUnitRate(int unitRate) {
		this.unitRate = unitRate;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getWeight() {
		return this.weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public MCountryOrgin getMCountryOrgin() {
		return this.MCountryOrgin;
	}

	public void setMCountryOrgin(MCountryOrgin MCountryOrgin) {
		this.MCountryOrgin = MCountryOrgin;
	}

	public TInvoice getTInvoice() {
		return this.TInvoice;
	}

	public void setTInvoice(TInvoice TInvoice) {
		this.TInvoice = TInvoice;
	}

	public MPack getMPack() {
		return this.MPack;
	}

	public void setMPack(MPack MPack) {
		this.MPack = MPack;
	}

	public MProduct getMProduct() {
		return this.MProduct;
	}

	public void setMProduct(MProduct MProduct) {
		this.MProduct = MProduct;
	}

}