package com.hibernate.hql;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="hqldemo")
public class HqlDemo {

	@Id
	private int oid;
	private String oname;
	private double oprice;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public double getOprice() {
		return oprice;
	}
	public void setOprice(double oprice) {
		this.oprice = oprice;
	}
	@Override
	public String toString() {
		return "HqlDemo [oid=" + oid + ", oname=" + oname + ", oprice=" + oprice + "]";
	}
}
