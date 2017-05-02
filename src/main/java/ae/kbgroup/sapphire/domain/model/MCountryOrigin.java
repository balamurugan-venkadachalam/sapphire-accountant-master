package ae.kbgroup.sapphire.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the m_country_orgin database table.
 * 
 */
@Entity
@Table(name="m_country_orgin")
@NamedQuery(name="MCountryOrigin.findAll", query="SELECT m FROM MCountryOrigin m")
public class MCountryOrigin implements Serializable {
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
	@OneToMany(mappedBy="MCountryOrgin")
	private List<TImportDetail> TImportDetails;

	//bi-directional many-to-one association to TInvoiceDetail
	@OneToMany(mappedBy="MCountryOrgin")
	private List<TInvoiceDetail> TInvoiceDetails;*/

	public MCountryOrigin() {
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

/*	public List<TImportDetail> getTImportDetails() {
		return this.TImportDetails;
	}

	public void setTImportDetails(List<TImportDetail> TImportDetails) {
		this.TImportDetails = TImportDetails;
	}

	public TImportDetail addTImportDetail(TImportDetail TImportDetail) {
		getTImportDetails().add(TImportDetail);
		TImportDetail.setMCountryOrgin(this);

		return TImportDetail;
	}

	public TImportDetail removeTImportDetail(TImportDetail TImportDetail) {
		getTImportDetails().remove(TImportDetail);
		TImportDetail.setMCountryOrgin(null);

		return TImportDetail;
	}

	public List<TInvoiceDetail> getTInvoiceDetails() {
		return this.TInvoiceDetails;
	}

	public void setTInvoiceDetails(List<TInvoiceDetail> TInvoiceDetails) {
		this.TInvoiceDetails = TInvoiceDetails;
	}

	public TInvoiceDetail addTInvoiceDetail(TInvoiceDetail TInvoiceDetail) {
		getTInvoiceDetails().add(TInvoiceDetail);
		TInvoiceDetail.setMCountryOrgin(this);

		return TInvoiceDetail;
	}

	public TInvoiceDetail removeTInvoiceDetail(TInvoiceDetail TInvoiceDetail) {
		getTInvoiceDetails().remove(TInvoiceDetail);
		TInvoiceDetail.setMCountryOrgin(null);

		return TInvoiceDetail;
	}*/

}