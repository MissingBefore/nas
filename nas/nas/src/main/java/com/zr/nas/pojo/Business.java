package com.zr.nas.pojo;

public class Business {

	private Double Recharge_income;// 充值收入
	private Double Package_income;// 大礼包收入
	private Double Cash_income;// 现金收入
	private Double Wechat_income;// 微信收入
	private Double Card_income;// 刷卡收入
	private Double ExperienceCard_income;// 体验卡收入
	private Integer Urban_card;// 都市储值卡
	private Integer Platinum_card;// 白金储值卡
	private Integer RedDiamond_card;// 红钻储值卡

	public Business(Double recharge_income, Double package_income, Double cash_income, Double wechat_income,
			Double card_income, Double experienceCard_income, Integer urban_card, Integer platinum_card,
			Integer redDiamond_card) {
		super();
		Recharge_income = recharge_income;
		Package_income = package_income;
		Cash_income = cash_income;
		Wechat_income = wechat_income;
		Card_income = card_income;
		ExperienceCard_income = experienceCard_income;
		Urban_card = urban_card;
		Platinum_card = platinum_card;
		RedDiamond_card = redDiamond_card;
	}

	public Business() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Business [Recharge_income=" + Recharge_income + ", Package_income=" + Package_income + ", Cash_income="
				+ Cash_income + ", Wechat_income=" + Wechat_income + ", Card_income=" + Card_income
				+ ", ExperienceCard_income=" + ExperienceCard_income + ", Urban_card=" + Urban_card + ", Platinum_card="
				+ Platinum_card + ", RedDiamond_card=" + RedDiamond_card + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Card_income == null) ? 0 : Card_income.hashCode());
		result = prime * result + ((Cash_income == null) ? 0 : Cash_income.hashCode());
		result = prime * result + ((ExperienceCard_income == null) ? 0 : ExperienceCard_income.hashCode());
		result = prime * result + ((Package_income == null) ? 0 : Package_income.hashCode());
		result = prime * result + ((Platinum_card == null) ? 0 : Platinum_card.hashCode());
		result = prime * result + ((Recharge_income == null) ? 0 : Recharge_income.hashCode());
		result = prime * result + ((RedDiamond_card == null) ? 0 : RedDiamond_card.hashCode());
		result = prime * result + ((Urban_card == null) ? 0 : Urban_card.hashCode());
		result = prime * result + ((Wechat_income == null) ? 0 : Wechat_income.hashCode());
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
		Business other = (Business) obj;
		if (Card_income == null) {
			if (other.Card_income != null)
				return false;
		} else if (!Card_income.equals(other.Card_income))
			return false;
		if (Cash_income == null) {
			if (other.Cash_income != null)
				return false;
		} else if (!Cash_income.equals(other.Cash_income))
			return false;
		if (ExperienceCard_income == null) {
			if (other.ExperienceCard_income != null)
				return false;
		} else if (!ExperienceCard_income.equals(other.ExperienceCard_income))
			return false;
		if (Package_income == null) {
			if (other.Package_income != null)
				return false;
		} else if (!Package_income.equals(other.Package_income))
			return false;
		if (Platinum_card == null) {
			if (other.Platinum_card != null)
				return false;
		} else if (!Platinum_card.equals(other.Platinum_card))
			return false;
		if (Recharge_income == null) {
			if (other.Recharge_income != null)
				return false;
		} else if (!Recharge_income.equals(other.Recharge_income))
			return false;
		if (RedDiamond_card == null) {
			if (other.RedDiamond_card != null)
				return false;
		} else if (!RedDiamond_card.equals(other.RedDiamond_card))
			return false;
		if (Urban_card == null) {
			if (other.Urban_card != null)
				return false;
		} else if (!Urban_card.equals(other.Urban_card))
			return false;
		if (Wechat_income == null) {
			if (other.Wechat_income != null)
				return false;
		} else if (!Wechat_income.equals(other.Wechat_income))
			return false;
		return true;
	}

	public Double getRecharge_income() {
		return Recharge_income;
	}

	public void setRecharge_income(Double recharge_income) {
		Recharge_income = recharge_income;
	}

	public Double getPackage_income() {
		return Package_income;
	}

	public void setPackage_income(Double package_income) {
		Package_income = package_income;
	}

	public Double getCash_income() {
		return Cash_income;
	}

	public void setCash_income(Double cash_income) {
		Cash_income = cash_income;
	}

	public Double getWechat_income() {
		return Wechat_income;
	}

	public void setWechat_income(Double wechat_income) {
		Wechat_income = wechat_income;
	}

	public Double getCard_income() {
		return Card_income;
	}

	public void setCard_income(Double card_income) {
		Card_income = card_income;
	}

	public Double getExperienceCard_income() {
		return ExperienceCard_income;
	}

	public void setExperienceCard_income(Double experienceCard_income) {
		ExperienceCard_income = experienceCard_income;
	}

	public Integer getUrban_card() {
		return Urban_card;
	}

	public void setUrban_card(Integer urban_card) {
		Urban_card = urban_card;
	}

	public Integer getPlatinum_card() {
		return Platinum_card;
	}

	public void setPlatinum_card(Integer platinum_card) {
		Platinum_card = platinum_card;
	}

	public Integer getRedDiamond_card() {
		return RedDiamond_card;
	}

	public void setRedDiamond_card(Integer redDiamond_card) {
		RedDiamond_card = redDiamond_card;
	}
}
