package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(schema = "XE", name = "DEPT")
@NamedQueries({ @NamedQuery(name = "Dept.findAll", query = "select o from Dept o") })
public class Dept implements Serializable {
	@Id
	@Column(nullable = false)
	private Long deptno;
	@Column(length = 20)
	private String dname;
	@Column(length = 20)
	private String loc;

	public Dept() {
	}

	public Dept(Long deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public Long getDeptno() {
		return deptno;
	}

	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
}
