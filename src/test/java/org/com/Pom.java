package org.com;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class Pom extends BaseClass {

	public Pom() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "username")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "login")
	private WebElement login;

	@FindBy(id = "location")
	private WebElement location;

	@FindBy(id = "hotels")
	private WebElement hotels;

	@FindBy(id = "room_type")
	private WebElement room_type;

	@FindBy(id = "room_nos")
	private WebElement room_nos;

	@FindBy(id = "datepick_in")
	private WebElement datepick_in;

	@FindBy(id = "datepick_out")
	private WebElement datepick_out;

	@FindBy(id = "adult_room")
	private WebElement adult_room;

	@FindBy(id = "child_room")
	private WebElement child_room;

	@FindBy(id = "Submit")
	private WebElement search;
	
	@FindBy(id="radiobutton_0")
	private WebElement radiobutton;
	
	@FindBy(id= "continue")
	private WebElement continueBtn;
	
	@FindBy(id= "first_name")
	private WebElement firstName;
	
	@FindBy(id= "last_name")
	private WebElement lastName;
	
	@FindBy(id= "address")
	private WebElement address;
	
	@FindBy(id= "cc_num")
	private WebElement creditCardNo;
	
	@FindBy(id= "cc_type")
	private WebElement creditCardType;
	
	@FindBy(id= "cc_exp_month")
	private WebElement expMonth;
	
	@FindBy(id= "cc_exp_year")
	private WebElement expYear;
	
	@FindBy(id= "cc_cvv")
	private WebElement cvvNo;
	
	@FindBy(id= "book_now")
	private WebElement BookNow;
	
	@FindBy(id="orde_no")
	private WebElement order;
	

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getOrder() {
		return order;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCreditCardNo() {
		return creditCardNo;
	}

	public WebElement getCreditCardType() {
		return creditCardType;
	}

	public WebElement getExpMonth() {
		return expMonth;
	}

	public WebElement getExpYear() {
		return expYear;
	}

	public WebElement getCvvNo() {
		return cvvNo;
	}

	public WebElement getBookNow() {
		return BookNow;
	}

	public WebElement getRadiobutton() {
		return radiobutton;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoom_type() {
		return room_type;
	}

	public WebElement getRoom_nos() {
		return room_nos;
	}

	public WebElement getDatepick_in() {
		return datepick_in;
	}

	public WebElement getDatepick_out() {
		return datepick_out;
	}

	public WebElement getAdult_room() {
		return adult_room;
	}

	public WebElement getChild_room() {
		return child_room;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

}
