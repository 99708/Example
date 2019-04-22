package com.bjsxt.pojo;

/**
 * slf日志实体类
 * @author HaoziDada
 */
public class SlfLog {

	private Integer sid;	//日志编号
	private Integer uid; 	//操作员编号
	private String oper;	//操作内容
	private String opertime; //操作时间
	private Integer status;//存在状态
	private String success; //成功与否
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	public String getOpertime() {
		return opertime;
	}
	public void setOpertime(String opertime) {
		this.opertime = opertime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oper == null) ? 0 : oper.hashCode());
		result = prime * result + ((opertime == null) ? 0 : opertime.hashCode());
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((success == null) ? 0 : success.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SlfLog other = (SlfLog) obj;
		if (oper == null) {
			if (other.oper != null)
				return false;
		} else if (!oper.equals(other.oper))
			return false;
		if (opertime == null) {
			if (other.opertime != null)
				return false;
		} else if (!opertime.equals(other.opertime))
			return false;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (success == null) {
			if (other.success != null)
				return false;
		} else if (!success.equals(other.success))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SlfLog [sid=" + sid + ", uid=" + uid + ", oper=" + oper + ", opertime=" + opertime + ", status="
				+ status + ", success=" + success + "]";
	}
	public SlfLog(Integer sid, Integer uid, String oper, String opertime, Integer status, String success) {
		super();
		this.sid = sid;
		this.uid = uid;
		this.oper = oper;
		this.opertime = opertime;
		this.status = status;
		this.success = success;
	}
	public SlfLog() {
		super();
	}
	
}
