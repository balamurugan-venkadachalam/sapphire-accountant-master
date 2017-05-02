package ae.kbgroup.sapphire.domain.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_import_details database table.
 * 
 */
@Entity
@Table(name="t_import_details")
@NamedQuery(name="TImportDetail.findAll", query="SELECT t FROM TImportDetail t")
public class TImportDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	private int count;

	@Column(name="CREATED_DATE", length=45)
	private String createdDate;

	@Column(name="GRN_CODE", length=75)
	private String grnCode;

	@Column(name="PACK_PIECES")
	private int packPieces;

	@Column(name="PIECE_WEIGHT")
	private int pieceWeight;

	@Column(name="UNIT_PRICE")
	private int unitPrice;

	private int weight;

	//bi-directional many-to-one association to MCategory
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
	private MCategory MCategory;

	//bi-directional many-to-one association to MCountryOrgin
	@ManyToOne
	@JoinColumn(name="CNTRY_CODE")
	private MCountryOrigin MCountryOrgin;

	//bi-directional many-to-one association to MPack
	@ManyToOne
	@JoinColumn(name="PACK_ID")
	private MPack MPack;

	//bi-directional many-to-one association to MProduct
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private MProduct MProduct;

	public TImportDetail() {
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

	public String getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getGrnCode() {
		return this.grnCode;
	}

	public void setGrnCode(String grnCode) {
		this.grnCode = grnCode;
	}

	public int getPackPieces() {
		return this.packPieces;
	}

	public void setPackPieces(int packPieces) {
		this.packPieces = packPieces;
	}

	public int getPieceWeight() {
		return this.pieceWeight;
	}

	public void setPieceWeight(int pieceWeight) {
		this.pieceWeight = pieceWeight;
	}

	public int getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getWeight() {
		return this.weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public MCategory getMCategory() {
		return this.MCategory;
	}

	public void setMCategory(MCategory MCategory) {
		this.MCategory = MCategory;
	}

	public MCountryOrigin getMCountryOrgin() {
		return this.MCountryOrgin;
	}

	public void setMCountryOrgin(MCountryOrigin MCountryOrgin) {
		this.MCountryOrgin = MCountryOrgin;
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