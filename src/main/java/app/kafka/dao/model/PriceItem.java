package app.kafka.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CM_PRICEITEM_EXT_STG")
public class PriceItem implements Serializable {

	@Id
	@Column(name = "PRICEITEM_ID")
	private String priceItemId;

	@Column(name = "PRICEITEM_CD")
	private String priceItem;

	@Column(name = "PI_STATUS_FLAG")
	private String priceItemstatus;

	@Column(name = "RECORD_STATUS")
	private String recordStatus;

	@Column(name = "DESCRIPTION_TEXT")
	private String descriptionText;

	@Column(name = "CREATION_DT")
	private Date createDate;

	public PriceItem() {
	}

	public PriceItem(String priceItemId, String priceItem, String priceItemstatus, String recordStatus,
			String descriptionText, Date createDate) {
		this.priceItemId = priceItemId;
		this.priceItem = priceItem;
		this.priceItemstatus = priceItemstatus;
		this.recordStatus = recordStatus;
		this.descriptionText = descriptionText;
		this.createDate = createDate;
	}

	public String getPriceItemId() {
		return priceItemId;
	}

	public void setPriceItemId(String priceItemId) {
		this.priceItemId = priceItemId;
	}

	public String getPriceItem() {
		return priceItem;
	}

	public void setPriceItem(String priceItem) {
		this.priceItem = priceItem;
	}

	public String getPriceItemstatus() {
		return priceItemstatus;
	}

	public void setPriceItemstatus(String priceItemstatus) {
		this.priceItemstatus = priceItemstatus;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getDescriptionText() {
		return descriptionText;
	}

	public void setDescriptionText(String descriptionText) {
		this.descriptionText = descriptionText;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "PriceItem [priceItemId=" + priceItemId + ", priceItem=" + priceItem + ", priceItemstatus="
				+ priceItemstatus + ", recordStatus=" + recordStatus + ", descriptionText=" + descriptionText
				+ ", createDate=" + createDate + "]";
	}

}
