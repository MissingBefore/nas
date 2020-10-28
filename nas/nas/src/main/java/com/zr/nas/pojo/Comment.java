package com.zr.nas.pojo;

import java.util.Date;

public class Comment {

	private Integer id;
	private Date com_date;
	private String com_content;
	private String order_id;
	private Date order_createdate;
	private String name;
	private Integer com_score;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCom_date() {
		return com_date;
	}

	public void setCom_date(Date com_date) {
		this.com_date = com_date;
	}

	public String getCom_content() {
		return com_content;
	}

	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Date getOrder_createdate() {
		return order_createdate;
	}

	public void setOrder_createdate(Date order_createdate) {
		this.order_createdate = order_createdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCom_score() {
		return com_score;
	}

	public void setCom_score(Integer com_score) {
		this.com_score = com_score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((com_content == null) ? 0 : com_content.hashCode());
		result = prime * result + ((com_date == null) ? 0 : com_date.hashCode());
		result = prime * result + ((com_score == null) ? 0 : com_score.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((order_createdate == null) ? 0 : order_createdate.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
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
		Comment other = (Comment) obj;
		if (com_content == null) {
			if (other.com_content != null)
				return false;
		} else if (!com_content.equals(other.com_content))
			return false;
		if (com_date == null) {
			if (other.com_date != null)
				return false;
		} else if (!com_date.equals(other.com_date))
			return false;
		if (com_score == null) {
			if (other.com_score != null)
				return false;
		} else if (!com_score.equals(other.com_score))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (order_createdate == null) {
			if (other.order_createdate != null)
				return false;
		} else if (!order_createdate.equals(other.order_createdate))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", com_date=" + com_date + ", com_content=" + com_content + ", order_id="
				+ order_id + ", order_createdate=" + order_createdate + ", name=" + name + ", com_score=" + com_score
				+ "]";
	}

	public Comment(Integer id, Date com_date, String com_content, String order_id, Date order_createdate, String name,
			Integer com_score) {
		super();
		this.id = id;
		this.com_date = com_date;
		this.com_content = com_content;
		this.order_id = order_id;
		this.order_createdate = order_createdate;
		this.name = name;
		this.com_score = com_score;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

}
