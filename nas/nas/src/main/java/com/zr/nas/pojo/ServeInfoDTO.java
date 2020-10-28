package com.zr.nas.pojo;

import java.util.List;

public class ServeInfoDTO {
	private List<String> workersId;//销售id
	private String serveId;//服务id
	private String staffId;//施工员工id
	private String modelsId;//服务车辆类型id
	public ServeInfoDTO(List<String> workersId, String serveId, String staffId, String modelsId) {
		super();
		this.workersId = workersId;
		this.serveId = serveId;
		this.staffId = staffId;
		this.modelsId = modelsId;
	}
	public ServeInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<String> getWorkersId() {
		return workersId;
	}
	public void setWorkersId(List<String> workersId) {
		this.workersId = workersId;
	}
	public String getServeId() {
		return serveId;
	}
	public void setServeId(String serveId) {
		this.serveId = serveId;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getModelsId() {
		return modelsId;
	}
	public void setModelsId(String modelsId) {
		this.modelsId = modelsId;
	}
	@Override
	public String toString() {
		return "ServeInfoDTO [workersId=" + workersId + ", serveId=" + serveId + ", staffId=" + staffId + ", modelsId="
				+ modelsId + "]";
	}
	
	
}
