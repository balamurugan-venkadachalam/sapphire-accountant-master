package ae.kbgroup.sapphire.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pack_lk database table.
 * 
 */
@Entity
@Table(name="pack_lk")
@NamedQuery(name="Pack.findAll", query="SELECT m FROM Pack m")
public class Pack implements Serializable {
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
	private String measurementType;

	@Column(name="NO_PICES", length=45)
	private String noPices;

	@Column(name="PACK_NAME", length=45)
	private String packName;
/*
	//bi-directional many-to-one association to PurchaseOrder
	@OneToMany(mappedBy="Pack")
	private List<purchaseOrder> purchaseOrders;

	//bi-directional many-to-one association to TInvoiceDetail
	@OneToMany(mappedBy="Pack")
	private List<TInvoiceDetail> InvoiceDetails;*/

	public Pack() {
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

	public String getMeasurementType() {
		return this.measurementType;
	}

	public void setMeasurementType(String measurementType) {
		this.measurementType = measurementType;
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
	public List<purchaseOrder> get() {
		return this.;
	}

	public void set(List<purchaseOrder> ) {
		this. = ;
	}

	public PurchaseOrder addPurchaseOrder(PurchaseOrder purchaseOrder) {
		get().add(purchaseOrder);
		purchaseOrder.setPack(this);

		return purchaseOrder;
	}

	public PurchaseOrder removePurchaseOrder(PurchaseOrder purchaseOrder) {
		get().remove(purchaseOrder);
		purchaseOrder.setPack(null);

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
		TInvoiceDetail.setPack(this);

		return TInvoiceDetail;
	}

	public TInvoiceDetail removeTInvoiceDetail(TInvoiceDetail TInvoiceDetail) {
		getInvoiceDetails().remove(TInvoiceDetail);
		TInvoiceDetail.setPack(null);

		return TInvoiceDetail;
	}
*/
}