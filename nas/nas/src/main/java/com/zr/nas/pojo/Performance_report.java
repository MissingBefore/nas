package com.zr.nas.pojo;

public class Performance_report {

	private String report_date;
	private Double income;

	public Performance_report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Performance_report(String report_date, Double income) {
		super();
		this.report_date = report_date;
		this.income = income;
	}

	@Override
	public String toString() {
		return "Performance_report [report_date=" + report_date + ", income=" + income + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((income == null) ? 0 : income.hashCode());
		result = prime * result + ((report_date == null) ? 0 : report_date.hashCode());
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
		Performance_report other = (Performance_report) obj;
		if (income == null) {
			if (other.income != null)
				return false;
		} else if (!income.equals(other.income))
			return false;
		if (report_date == null) {
			if (other.report_date != null)
				return false;
		} else if (!report_date.equals(other.report_date))
			return false;
		return true;
	}

	public String getReport_date() {
		return report_date;
	}

	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}
}
