package ae.kbgroup.sapphire.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the t_invoice database table.
 * 
 */
@Entity
@Table(name="invoice")
@NamedQuery(name="Invoice.findAll", query="SELECT t FROM Invoice t")
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(length=45)
	private String currency;

	@Column(name="CUSTOMER_ID")
	private int customerId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(name="INVOICE_ID", length=60)
	private String invoiceId;

	private int quantity;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	private int weight;

	//bi-directional many-to-one association to TInvoiceDetail
	@OneToMany(mappedBy="TInvoice")
	private List<InvoiceDetail> invoiceDetails;

	public Invoice() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public List<InvoiceDetail> getInvoiceDetails() {
		return this.invoiceDetails;
	}

	public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

	public InvoiceDetail addTInvoiceDetail(InvoiceDetail invoiceDetail) {
		getInvoiceDetails().add(invoiceDetail);
		invoiceDetail.setTInvoice(this);

		return invoiceDetail;
	}

	public InvoiceDetail removeInvoiceDetail(InvoiceDetail invoiceDetail) {
		getInvoiceDetails().remove(invoiceDetail);
		invoiceDetail.setTInvoice(null);

		return invoiceDetail;
	}

}