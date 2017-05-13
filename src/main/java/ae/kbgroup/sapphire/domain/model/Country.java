package ae.kbgroup.sapphire.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the country_lk database table.
 * 
 */
@Entity
@Table(name="country_lk")
@NamedQuery(name="Country.findAll", query="SELECT m FROM Country m")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="CNTRY_CODE", length=45)
	private String cntryCode;

	@Column(name="CNTRY_DESC", length=45)
	private String cntryDesc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="IS_ACTIVE")
	private int isActive;

/*	//bi-directional many-to-one association to TImportDetail
	@OneToMany(mappedBy="Country")
	private List<TImportDetail> ;

	//bi-directional many-to-one association to TInvoiceDetail
	@OneToMany(mappedBy="Country")
	private List<TInvoiceDetail> InvoiceDetails;*/

	public Country() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCntryCode() {
		return this.cntryCode;
	}

	public void setCntryCode(String cntryCode) {
		this.cntryCode = cntryCode;
	}

	public String getCntryDesc() {
		return this.cntryDesc;
	}

	public void setCntryDesc(String cntryDesc) {
		this.cntryDesc = cntryDesc;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getIsActive() {
		return this.isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

/*	public List<TImportDetail> get() {
		return this.;
	}

	public void set(List<TImportDetail> ) {
		this. = ;
	}

	public TImportDetail addTImportDetail(TImportDetail TImportDetail) {
		get().add(TImportDetail);
		TImportDetail.setCountry(this);

		return TImportDetail;
	}

	public TImportDetail removeTImportDetail(TImportDetail TImportDetail) {
		get().remove(TImportDetail);
		TImportDetail.setCountry(null);

		return TImportDetail;
	}

	public List<TInvoiceDetail> getInvoiceDetails() {
		return this.InvoiceDetails;
	}

	public void setInvoiceDetails(List<TInvoiceDetail> InvoiceDetails) {
		this.InvoiceDetails = InvoiceDetails;
	}

	public TInvoiceDetail addTInvoiceDetail(TInvoiceDetail TInvoiceDetail) {
		getInvoiceDetails().add(TInvoiceDetail);
		TInvoiceDetail.setCountry(this);

		return TInvoiceDetail;
	}

	public TInvoiceDetail removeTInvoiceDetail(TInvoiceDetail TInvoiceDetail) {
		getInvoiceDetails().remove(TInvoiceDetail);
		TInvoiceDetail.setCountry(null);

		return TInvoiceDetail;
	}*/

}