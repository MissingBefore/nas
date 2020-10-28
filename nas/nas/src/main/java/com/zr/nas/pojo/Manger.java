package com.zr.nas.pojo;

public class Manger {
	String zhanghao;
	String mima;
	public Manger(String zhanghao, String mima) {
		super();
		this.zhanghao = zhanghao;
		this.mima = mima;
	}
	public Manger() {
		super();
	}
	public String getZhanghao() {
		return zhanghao;
	}
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	public String getMima() {
		return mima;
	}
	public void setMima(String mima) {
		this.mima = mima;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mima == null) ? 0 : mima.hashCode());
		result = prime * result + ((zhanghao == null) ? 0 : zhanghao.hashCode());
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
		Manger other = (Manger) obj;
		if (mima == null) {
			if (other.mima != null)
				return false;
		} else if (!mima.equals(other.mima))
			return false;
		if (zhanghao == null) {
			if (other.zhanghao != null)
				return false;
		} else if (!zhanghao.equals(other.zhanghao))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Manger [zhanghao=" + zhanghao + ", mima=" + mima + "]";
	}
	

}
