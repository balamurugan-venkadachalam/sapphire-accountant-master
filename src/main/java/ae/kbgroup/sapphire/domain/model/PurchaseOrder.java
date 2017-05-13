package ae.kbgroup.sapphire.domain.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

//import org.hibernate.search.annotations.Field;
//import org.hibernate.search.annotations.Indexed;


/**
 * The persistent class for the purchase_order database table.
 * 
 */
//@Indexed
@Entity
@Table(name="purchase_order")
@NamedQuery(name="PurchaseOrder.findAll", query="SELECT t FROM PurchaseOrder t")
public class PurchaseOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	private int count;

	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

//	@Field
	@Column(name="GRN_CODE", length=75)
	private String grnCode;

	@Column(name="PACK_PIECES")
	private Long packPieces;

	@Column(name="PIECE_WEIGHT")
	private Double pieceWeight;

	@Column(name="UNIT_PRICE")
	private Double unitPrice;
	
	@Column(name="UNIT_SELLING_PRICE")
	private Double unitSellingPrice;
	
	@Column(name="PRICE")
	private Double price;

	@Column(name="WEIGHT")
	private Double weight;
	
	@Column(name="REMARKS")
	private String remarks;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
	private Category category;

	//bi-directional many-to-one association to MCountryOrigin
	@ManyToOne
	@JoinColumn(name="CNTRY_CODE")
	private Country country;

	//bi-directional many-to-one association to Pack
	@ManyToOne
	@JoinColumn(name="PACK_ID")
	private Pack pack;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
	
	
	@ManyToOne
	@JoinColumn(name="SUPPLIER_ID")
	private SupplierDetail supplier;

	public PurchaseOrder() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getGrnCode() {
		return this.grnCode;
	}

	public void setGrnCode(String grnCode) {
		this.grnCode = grnCode;
	}

	public Long getPackPieces() {
		return this.packPieces;
	}

	public void setPackPieces(Long packPieces) {
		this.packPieces = packPieces;
	}

	public Double getPieceWeight() {
		return this.pieceWeight;
	}

	public void setPieceWeight(Double pieceWeight) {
		this.pieceWeight = pieceWeight;
	}

	public Double getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Pack getPack() {
		return this.pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public SupplierDetail getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierDetail supplier) {
		this.supplier = supplier;
	}

	public Double getUnitSellingPrice() {
		return unitSellingPrice;
	}

	public void setUnitSellingPrice(Double unitSellingPrice) {
		this.unitSellingPrice = unitSellingPrice;
	}


}