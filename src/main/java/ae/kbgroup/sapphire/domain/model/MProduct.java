package ae.kbgroup.sapphire.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the m_product database table.
 * 
 */
@Entity
@Table(name="m_product")
@NamedQuery(name="MProduct.findAll", query="SELECT m FROM MProduct m")
public class MProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="CUSTOM_FIELD_1", length=50)
	private String customField1;

	@Column(name="CUSTOM_FIELD_2", length=50)
	private String customField2;

	@Column(name="IS_ACTIVE")
	private int isActive;

	@Column(name="PRODUCT_NAME", length=100)
	private String productName;

	//bi-directional many-to-one association to MCategory
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
	private MCategory MCategory;

	//bi-directional many-to-one association to TImportDetail
	@OneToMany(mappedBy="MProduct")
	private List<TImportDetail> TImportDetails;

	//bi-directional many-to-one association to TInvoiceDetail
	@OneToMany(mappedBy="MProduct")
	private List<TInvoiceDetail> TInvoiceDetails;

	public MProduct() {
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

	public String getCustomField1() {
		return this.customField1;
	}

	public void setCustomField1(String customField1) {
		this.customField1 = customField1;
	}

	public String getCustomField2() {
		return this.customField2;
	}

	public void setCustomField2(String customField2) {
		this.customField2 = customField2;
	}

	public int getIsActive() {
		return this.isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public MCategory getMCategory() {
		return this.MCategory;
	}

	public void setMCategory(MCategory MCategory) {
		this.MCategory = MCategory;
	}

	public List<TImportDetail> getTImportDetails() {
		return this.TImportDetails;
	}

	public void setTImportDetails(List<TImportDetail> TImportDetails) {
		this.TImportDetails = TImportDetails;
	}

	public TImportDetail addTImportDetail(TImportDetail TImportDetail) {
		getTImportDetails().add(TImportDetail);
		TImportDetail.setMProduct(this);

		return TImportDetail;
	}

	public TImportDetail removeTImportDetail(TImportDetail TImportDetail) {
		getTImportDetails().remove(TImportDetail);
		TImportDetail.setMProduct(null);

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
		TInvoiceDetail.setMProduct(this);

		return TInvoiceDetail;
	}

	public TInvoiceDetail removeTInvoiceDetail(TInvoiceDetail TInvoiceDetail) {
		getTInvoiceDetails().remove(TInvoiceDetail);
		TInvoiceDetail.setMProduct(null);

		return TInvoiceDetail;
	}

}