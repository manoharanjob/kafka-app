package app.kafka.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CM_PRICEITEM_PARM_EXT_STG")
public class PriceItemParam implements Serializable {

	@Id
	@Column(name = "PRICEITEM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String priceItemId;

	@Column(name = "PRICE_PARM_CD")
	private String priceParam;

	@Column(name = "REQUIRED_SW")
	private String required;

	@Column(name = "PRIORITY_NUM")
	private String priorityNum;

	@Column(name = "START_DT")
	private Date startDate;

	@Column(name = "END_DT")
	private Date endDate;

	@Column(name = "DISP_ORD")
	private String dispOrd;

	@Column(name = "RECORD_STATUS")
	private String recordStatus;

	@Column(name = "CREATION_DT")
	private Date createDate;

	public PriceItemParam() {
	}

	public PriceItemParam(String priceParam, String required, String priority, Date startDate, Date endDate,
			String dispOrd, String recordStatus, Date createDate) {
		this.priceParam = priceParam;
		this.required = required;
		this.priorityNum = priority;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dispOrd = dispOrd;
		this.recordStatus = recordStatus;
		this.createDate = createDate;
	}

	public String getPriceItemId() {
		return priceItemId;
	}

	public void setPriceItemId(String priceItemId) {
		this.priceItemId = priceItemId;
	}

	public String getPriceParam() {
		return priceParam;
	}

	public void setPriceParam(String priceParam) {
		this.priceParam = priceParam;
	}

	public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	public String getPriority() {
		return priorityNum;
	}

	public void setPriority(String priority) {
		this.priorityNum = priority;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDispOrd() {
		return dispOrd;
	}

	public void setDispOrd(String dispOrd) {
		this.dispOrd = dispOrd;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "PriceItemParam [priceItemId=" + priceItemId + ", priceParam=" + priceParam + ", required=" + required
				+ ", priority=" + priorityNum + ", startDate=" + startDate + ", endDate=" + endDate + ", dispOrd="
				+ dispOrd + ", recordStatus=" + recordStatus + ", createDate=" + createDate + "]";
	}

}
