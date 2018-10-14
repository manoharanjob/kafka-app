package app.kafka.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CM_PRICELIST_EXT_STG")
public class PriceList implements Serializable {

	@Id
	@Column(name = "PRICELIST_ID")
	private String priceListId;

	@Column(name = "PRICELIST_EXT_ID")
	private String priceListExtId;

	@Column(name = "PRICELIST_NAME")
	private String priceListName;

	@Column(name = "PL_STATUS_FLG")
	private String priceListStatus;

	@Column(name = "PL_START_DT")
	private Date startDate;

	@Column(name = "PL_END_DT")
	private Date endDate;

	@Column(name = "PL_TYPE")
	private String priceListType;

	@Column(name = "RECORD_STATUS")
	private String recordStatus;

	@Column(name = "CREATION_DT")
	private Date createDate;

	public PriceList() {
	}

	public PriceList(String priceListId, String priceListExtId, String priceListName, String priceListStatus,
			Date startDate, Date endDate, String priceListType, String recordStatus, Date createDate) {
		this.priceListId = priceListId;
		this.priceListExtId = priceListExtId;
		this.priceListName = priceListName;
		this.priceListStatus = priceListStatus;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceListType = priceListType;
		this.recordStatus = recordStatus;
		this.createDate = createDate;
	}

	public String getPriceListId() {
		return priceListId;
	}

	public void setPriceListId(String priceListId) {
		this.priceListId = priceListId;
	}

	public String getPriceListExtId() {
		return priceListExtId;
	}

	public void setPriceListExtId(String priceListExtId) {
		this.priceListExtId = priceListExtId;
	}

	public String getPriceListName() {
		return priceListName;
	}

	public void setPriceListName(String priceListName) {
		this.priceListName = priceListName;
	}

	public String getPriceListStatus() {
		return priceListStatus;
	}

	public void setPriceListStatus(String priceListStatus) {
		this.priceListStatus = priceListStatus;
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

	public String getPriceListType() {
		return priceListType;
	}

	public void setPriceListType(String priceListType) {
		this.priceListType = priceListType;
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
		return "PriceList [priceListId=" + priceListId + ", priceListExtId=" + priceListExtId + ", priceListName="
				+ priceListName + ", priceListStatus=" + priceListStatus + ", startDate=" + startDate + ", endDate="
				+ endDate + ", priceListType=" + priceListType + ", recordStatus=" + recordStatus + ", createDate="
				+ createDate + "]";
	}

}
