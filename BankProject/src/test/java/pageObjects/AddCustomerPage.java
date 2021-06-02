package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver){
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver , this);
	}
	
	@FindBy(linkText ="New Customer")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(name ="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(name ="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(name ="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(name ="addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(name ="city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(name ="state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(name ="pinno")
	@CacheLookup
	WebElement txtpinno;

	@FindBy(name ="telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
	@FindBy(name ="emailid")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy(name ="sub")
	@CacheLookup
	WebElement btnSubmit;
		
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
			
	}

	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
		
	}

	public void custgender(String cgender) {
		rdGender.click();
	}

	public void custdob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
		
	}

	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}

	public void custsubmit() {
		btnSubmit.click();
	}
	
}