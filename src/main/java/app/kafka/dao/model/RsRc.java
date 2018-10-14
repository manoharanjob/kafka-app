package app.kafka.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CM_RS_RC_EXT_STG")
public class RsRc implements Serializable {

	@Id
	@Column(name = "RS_CD")
	private String rsCd;

	@Column(name = "RS_DESCR")
	private String rsDesc;

	@Column(name = "PRICE_CURRENCY_CD")
	private String priceCurrency;

	@Column(name = "EFFTDT")
	private String efftdt;

	@Column(name = "RC_SEQ")
	private String recordSeq;

	@Column(name = "RC_NAME")
	private String recordName;

	@Column(name = "STEP_RC_SEQ")
	private String stepRecordSeq;

	@Column(name = "STEP_LOW_VAL")
	private String stepLowValue;

	@Column(name = "STEP_HIGH_VAL")
	private String stepHighValue;

	@Column(name = "CREATION_DT")
	private Date createDate;

	public RsRc() {
	}

	public RsRc(String rsCd, String rsDesc, String priceCurrency, String efftdt, String recordSeq, String recordName,
			String stepRecordSeq, String stepLowValue, String stepHighValue, Date createDate) {
		this.rsCd = rsCd;
		this.rsDesc = rsDesc;
		this.priceCurrency = priceCurrency;
		this.efftdt = efftdt;
		this.recordSeq = recordSeq;
		this.recordName = recordName;
		this.stepRecordSeq = stepRecordSeq;
		this.stepLowValue = stepLowValue;
		this.stepHighValue = stepHighValue;
		this.createDate = createDate;
	}

	public String getRsCd() {
		return rsCd;
	}

	public void setRsCd(String rsCd) {
		this.rsCd = rsCd;
	}

	public String getRsDesc() {
		return rsDesc;
	}

	public void setRsDesc(String rsDesc) {
		this.rsDesc = rsDesc;
	}

	public String getPriceCurrency() {
		return priceCurrency;
	}

	public void setPriceCurrency(String priceCurrency) {
		this.priceCurrency = priceCurrency;
	}

	public String getEfftdt() {
		return efftdt;
	}

	public void setEfftdt(String efftdt) {
		this.efftdt = efftdt;
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

	public String getStepRecordSeq() {
		return stepRecordSeq;
	}

	public void setStepRecordSeq(String stepRecordSeq) {
		this.stepRecordSeq = stepRecordSeq;
	}

	public String getStepLowValue() {
		return stepLowValue;
	}

	public void setStepLowValue(String stepLowValue) {
		this.stepLowValue = stepLowValue;
	}

	public String getStepHighValue() {
		return stepHighValue;
	}

	public void setStepHighValue(String stepHighValue) {
		this.stepHighValue = stepHighValue;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "RsRc [rsCd=" + rsCd + ", rsDesc=" + rsDesc + ", priceCurrency=" + priceCurrency + ", efftdt=" + efftdt
				+ ", recordSeq=" + recordSeq + ", recordName=" + recordName + ", stepRecordSeq=" + stepRecordSeq
				+ ", stepLowValue=" + stepLowValue + ", stepHighValue=" + stepHighValue + ", createDate=" + createDate
				+ "]";
	}

}
