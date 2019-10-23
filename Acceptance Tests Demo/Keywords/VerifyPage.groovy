import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class VerifyPage {
	@Keyword
	public void verifyURL(String url) {
		def currentUrL = WebUI.getUrl()

		WebUI.verifyMatch(currentUrL, url, false)
	}
}
