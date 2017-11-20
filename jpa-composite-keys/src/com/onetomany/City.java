package com.onetomany;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class City implements Serializable {

	private String cityCode;

	private String CityName;

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	@Override
	public String toString() {
		return "City [cityCode=" + cityCode + ", CityName=" + CityName + "]";
	}

}
