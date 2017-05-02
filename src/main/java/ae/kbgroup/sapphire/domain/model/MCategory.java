package ae.kbgroup.sapphire.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the m_category database table.
 * 
 */
@Entity
@Table(name="m_category")
@NamedQuery(name="MCategory.findAll", query="SELECT m FROM MCategory m")
public class MCategory implements Serializable {
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

/*	//bi-directional many-to-one association to MProduct
	@OneToMany(mappedBy="MCategory")
	private List<MProduct> MProducts;

	//bi-directional many-to-one association to TImportDetail
	@OneToMany(mappedBy="MCategory")
	private List<TImportDetail> TImportDetails;*/

	public MCategory() {
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

	/*public List<MProduct> getMProducts() {
		return this.MProducts;
	}

	public void setMProducts(List<MProduct> MProducts) {
		this.MProducts = MProducts;
	}

	public MProduct addMProduct(MProduct MProduct) {
		getMProducts().add(MProduct);
		MProduct.setMCategory(this);

		return MProduct;
	}

	public MProduct removeMProduct(MProduct MProduct) {
		getMProducts().remove(MProduct);
		MProduct.setMCategory(null);

		return MProduct;
	}

	public List<TImportDetail> getTImportDetails() {
		return this.TImportDetails;
	}

	public void setTImportDetails(List<TImportDetail> TImportDetails) {
		this.TImportDetails = TImportDetails;
	}

	public TImportDetail addTImportDetail(TImportDetail TImportDetail) {
		getTImportDetails().add(TImportDetail);
		TImportDetail.setMCategory(this);

		return TImportDetail;
	}

	public TImportDetail removeTImportDetail(TImportDetail TImportDetail) {
		getTImportDetails().remove(TImportDetail);
		TImportDetail.setMCategory(null);

		return TImportDetail;
	}
*/
}