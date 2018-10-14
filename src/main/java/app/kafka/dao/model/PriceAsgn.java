package app.kafka.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CM_PRICEASGN_RS_RC_EXT_STG")
public class PriceAsgn implements Serializable {

	@Id
	@Column(name = "PRICE_ASGN_ID")
	private String priceAsgnId;

	@Column(name = "PRICELIST_EXT_ID")
	private String priceListExtId;

	@Column(name = "PRICEITEM_CD")
	private String priceItem;

	@Column(name = "PRICECOMP_ID")
	private String priceCompId;

	@Column(name = "RS_CD")
	private String rs;

	@Column(name = "EFFDT")
	private String effdt;

	@Column(name = "RC_SEQ")
	private String recordSeq;

	@Column(name = "RC_NAME")
	private String recordName;

	@Column(name = "VALUE_AMT")
	private String valueAmount;

	@Column(name = "TIERED_FLAG")
	private String tieredFlag;

	@Column(name = "CREATION_DT")
	private Date createDate;

	public PriceAsgn() {
	}

	public PriceAsgn(String priceAsgnId, String priceListExtId, String priceItem, String priceCompId, String rs,
			String effdt, String recordSeq, String recordName, String valueAmount, String tieredFlag, Date createDate) {
		super();
		this.priceAsgnId = priceAsgnId;
		this.priceListExtId = priceListExtId;
		this.priceItem = priceItem;
		this.priceCompId = priceCompId;
		this.rs = rs;
		this.effdt = effdt;
		this.recordSeq = recordSeq;
		this.recordName = recordName;
		this.valueAmount = valueAmount;
		this.tieredFlag = tieredFlag;
		this.createDate = createDate;
	}

	public String getPriceAsgnId() {
		return priceAsgnId;
	}

	public void setPriceAsgnId(String priceAsgnId) {
		this.priceAsgnId = priceAsgnId;
	}

	public String getPriceListExtId() {
		return priceListExtId;
	}

	public void setPriceListExtId(String priceListExtId) {
		this.priceListExtId = priceListExtId;
	}

	public String getPriceItem() {
		return priceItem;
	}

	public void setPriceItem(String priceItem) {
		this.priceItem = priceItem;
	}

	public String getPriceCompId() {
		return priceCompId;
	}

	public void setPriceCompId(String priceCompId) {
		this.priceCompId = priceCompId;
	}

	public String getRs() {
		return rs;
	}

	public void setRs(String rs) {
		this.rs = rs;
	}

	public String getEffdt() {
		return effdt;
	}

	public void setEffdt(String effdt) {
		this.effdt = effdt;
	}

	public String getRecordSeq() {
		return recordSeq;
	}

	public void setRecordSeq(String recordSeq) {
		this.recordSeq = recordSeq;
	}

	public String getRecordName() {
		return recordName;
	}

	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}

	public String getValueAmount() {
		return valueAmount;
	}

	public void setValueAmount(String valueAmount) {
		this.valueAmount = valueAmount;
	}

	public String getTieredFlag() {
		return tieredFlag;
	}

	public void setTieredFlag(String tieredFlag) {
		this.tieredFlag = tieredFlag;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "PriceAsgn [priceAsgnId=" + priceAsgnId + ", priceListExtId=" + priceListExtId + ", priceItem="
				+ priceItem + ", priceCompId=" + priceCompId + ", rs=" + rs + ", effdt=" + effdt + ", recordSeq="
				+ recordSeq + ", recordName=" + recordName + ", valueAmount=" + valueAmount + ", tieredFlag="
				+ tieredFlag + ", createDate=" + createDate + "]";
	}

}
