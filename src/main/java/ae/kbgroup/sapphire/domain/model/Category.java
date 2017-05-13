package ae.kbgroup.sapphire.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name="category_lk")
@NamedQuery(name="Category.findAll", query="SELECT m FROM Category m")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private long id;

	@Column(name="CATEGORY_NAME", nullable=false, length=100)
	private String categoryName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="IS_ACTIVE")
	private int isActive;
	
	@Column(name="HS_CODE")
	private String hsCode;

/*	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="Category")
	private List<Product> products;

	//bi-directional many-to-one association to PurchaseOrder
	@OneToMany(mappedBy="Category")
	private List<PurchaseOrder> purchaseOrder;*/

	public Category() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	public String getHsCode() {
		return hsCode;
	}

	public void setHsCode(String hsCode) {
		this.hsCode = hsCode;
	}

	/*public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> product) {
		this.product = product;
	}

	public Product addProduct(Product product) {
		getProducts().add(Product);
		product.setMCategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setMCategory(null);

		return product;
	}

	public List<PurchaseOrder> getPurchaseOrder() {
		return this.purchaseOrder;
	}

	public void setPurchaseOrder(List<PurchaseOrder> purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public PurchaseOrder addTImportDetail(PurchaseOrder purchaseOrder) {
		getPurchaseOrder().add(purchaseOrder);
		purchaseOrder.setMCategory(this);

		return purchaseOrder;
	}

	public PurchaseOrder removeTImportDetail(PurchaseOrder purchaseOrder) {
		getPurchaseOrder().remove(purchaseOrder);
		purchaseOrder.setMCategory(null);

		return purchaseOrder;
	}
*/
}