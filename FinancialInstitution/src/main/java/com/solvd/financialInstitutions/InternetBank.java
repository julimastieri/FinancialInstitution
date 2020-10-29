package main.java.com.solvd.financialInstitutions;

public class InternetBank extends FinancialInstitution{

	private String webPageUrl;
	
	public InternetBank() {}

	public InternetBank(int identification, String name, String webPageUrl) {
		super(identification, name);
		this.webPageUrl = webPageUrl;
	}

	public InternetBank(String webPageUrl) {
		super();
		this.webPageUrl = webPageUrl;
	}

	public String getWebPageUrl() {
		return webPageUrl;
	}

	public void setWebPageUrl(String webPageUrl) {
		this.webPageUrl = webPageUrl;
	}
	
}
