package com.apps.datamodel;

import java.util.ArrayList;

public class HottestInfo {
	private int restaurantId;
	private String restaurantName;
	private String restaurantAddress;
	private String restaurantRating;
	private String restaurantAbout;
	private double lat;
	private double lon;
	private String logo;
	private int hottest;
	private int likes;
	private int branches;
	private int branchId;
	private String openinHour;
	private int isOpen;
	private String city;
	private String area;
	
	private ArrayList<HottestFoodItemInfo> hottestFoodItemList;
	
	
	public String getRestaurantRating() {
		return restaurantRating;
	}
	
	public void setRestaurantRating(String restaurantRating) {
		this.restaurantRating = restaurantRating;
	}
	 
	public String getRestaurantAddress() {
		return restaurantAddress;
	}
	
	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}
	
	public String getRestaurantName() {
		return restaurantName;
	}
	
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public int getHottest() {
		return hottest;
	}

	public void setHottest(int hottest) {
		this.hottest = hottest;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getBranches() {
		return branches;
	}

	public void setBranches(int branches) {
		this.branches = branches;
	}

	public String getOpeninHour() {
		return openinHour;
	}

	public void setOpeninHour(String openinHour) {
		this.openinHour = openinHour;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(int isOpen) {
		this.isOpen = isOpen;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public ArrayList<HottestFoodItemInfo> getHottestFoodItemList() {
		return hottestFoodItemList;
	}

	public void setHottestFoodItemList(ArrayList<HottestFoodItemInfo> hottestFoodItemList) {
		this.hottestFoodItemList = hottestFoodItemList;
	}

	public String getRestaurantAbout() {
		return restaurantAbout;
	}

	public void setRestaurantAbout(String restaurantAbout) {
		this.restaurantAbout = restaurantAbout;
	}
}
