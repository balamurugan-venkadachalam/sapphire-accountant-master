package ae.kbgroup.sapphire.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the m_pack database table.
 * 
 */
@Entity
@Table(name="m_pack")
@NamedQuery(name="MPack.findAll", query="SELECT m FROM MPack m")
public class MPack implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="IS_ACTIVE")
	private int isActive;

	@Column(name="MEASUREMENT_COUNT")
	private int measurementCount;

	@Column(name="MEASURMENT_TYPE", length=60)
	private String measurmentType;

	@Column(name="NO_PICES", length=45)
	private String noPices;

	@Column(name="PACK_NAME", length=45)
	private String packName;
/*
	//bi-directional many-to-one association to TImportDetail
	@OneToMany(mappedBy="MPack")
	private List<TImportDetail> TImportDetails;

	//bi-directional many-to-one association to TInvoiceDetail
	@OneToMany(mappedBy="MPack")
	private List<TInvoiceDetail> TInvoiceDetails;*/

	public MPack() {
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

	public int getIsActive() {
		return this.isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getMeasurementCount() {
		return this.measurementCount;
	}

	public void setMeasurementCount(int measurementCount) {
		this.measurementCount = measurementCount;
	}

	public String getMeasurmentType() {
		return this.measurmentType;
	}

	public void setMeasurmentType(String measurmentType) {
		this.measurmentType = measurmentType;
	}

	public String getNoPices() {
		return this.noPices;
	}

	public void setNoPices(String noPices) {
		this.noPices = noPices;
	}

	public String getPackName() {
		return this.packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}
/*
	public List<TImportDetail> getTImportDetails() {
		return this.TImportDetails;
	}

	public void setTImportDetails(List<TImportDetail> TImportDetails) {
		this.TImportDetails = TImportDetails;
	}

	public TImportDetail addTImportDetail(TImportDetail TImportDetail) {
		getTImportDetails().add(TImportDetail);
		TImportDetail.setMPack(this);

		return TImportDetail;
	}

	public TImportDetail removeTImportDetail(TImportDetail TImportDetail) {
		getTImportDetails().remove(TImportDetail);
		TImportDetail.setMPack(null);

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
		TInvoiceDetail.setMPack(this);

		return TInvoiceDetail;
	}

	public TInvoiceDetail removeTInvoiceDetail(TInvoiceDetail TInvoiceDetail) {
		getTInvoiceDetails().remove(TInvoiceDetail);
		TInvoiceDetail.setMPack(null);

		return TInvoiceDetail;
	}
*/
}