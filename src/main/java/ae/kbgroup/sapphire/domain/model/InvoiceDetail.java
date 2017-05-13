package ae.kbgroup.sapphire.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the invoice_details database table.
 * 
 */
@Entity
@Table(name="invoice_details")
@NamedQuery(name="InvoiceDetail.findAll", query="SELECT t FROM InvoiceDetail t")
public class InvoiceDetail implements Serializable {
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

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	private Country Country;

	//bi-directional many-to-one association to TInvoice
	@ManyToOne
	@JoinColumn(name="INVOICE_ID")
	private Invoice TInvoice;

	//bi-directional many-to-one association to Pack
	@ManyToOne
	@JoinColumn(name="PACK_ID")
	private Pack Pack;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product Product;

	public InvoiceDetail() {
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

	public Country getCountry() {
		return this.Country;
	}

	public void setCountry(Country Country) {
		this.Country = Country;
	}

	public Invoice getTInvoice() {
		return this.TInvoice;
	}

	public void setTInvoice(Invoice TInvoice) {
		this.TInvoice = TInvoice;
	}

	public Pack getPack() {
		return this.Pack;
	}

	public void setPack(Pack Pack) {
		this.Pack = Pack;
	}

	public Product getProduct() {
		return this.Product;
	}

	public void setProduct(Product Product) {
		this.Product = Product;
	}

}