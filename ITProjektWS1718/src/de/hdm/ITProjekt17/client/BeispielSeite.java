package de.hdm.ITProjekt17.client;

public class BeispielSeite extends SiteTemplate{

	@Override
	protected String getHeadlineText() {
		return "Hallo Headline-Text";
	}

	@Override
	protected void run() {
		this.append("hallo");
	}

}
