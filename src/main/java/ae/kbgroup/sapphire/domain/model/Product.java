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
@Table(name="product_lk")
@NamedQuery(name="Product.findAll", query="SELECT m FROM Product m")
public class Product implements Serializable {
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

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
	private Category category;

	/*//bi-directional many-to-one association to PurchaseOrder
	@OneToMany(mappedBy="Product")
	private List<PurchaseOrder> purchaseOrders;

	//bi-directional many-to-one association to TInvoiceDetail
	@OneToMany(mappedBy="Product")
	private List<TInvoiceDetail> InvoiceDetails;*/

	public Product() {
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

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	/*public List<PurchaseOrder> getPurchaseOrders() {
		return this.purchaseOrder;
	}

	public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}

	public PurchaseOrder addPurchaseOrder(PurchaseOrder PurchaseOrder) {
		getPurchaseOrders().add(PurchaseOrder);
		PurchaseOrder.setProduct(this);

		return PurchaseOrder;
	}

	public PurchaseOrder removePurchaseOrder(PurchaseOrder purchaseOrder) {
		getPurchaseOrders().remove(purchaseOrder);
		purchaseOrder.setProduct(null);

		return purchaseOrder;
	}

	public List<TInvoiceDetail> getInvoiceDetails() {
		return this.InvoiceDetails;
	}

	public void setInvoiceDetails(List<TInvoiceDetail> InvoiceDetails) {
		this.InvoiceDetails = InvoiceDetails;
	}

	public TInvoiceDetail addTInvoiceDetail(TInvoiceDetail TInvoiceDetail) {
		getInvoiceDetails().add(TInvoiceDetail);
		TInvoiceDetail.setProduct(this);

		return TInvoiceDetail;
	}

	public TInvoiceDetail removeTInvoiceDetail(TInvoiceDetail TInvoiceDetail) {
		getInvoiceDetails().remove(TInvoiceDetail);
		TInvoiceDetail.setProduct(null);

		return TInvoiceDetail;
	}
*/
}