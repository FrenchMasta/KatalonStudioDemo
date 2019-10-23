package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p>Profile default : Base URL for the demo site</p>
     */
    public static Object BaseURL
     
    /**
     * <p>Profile default : Username used to login into the demo site</p>
     */
    public static Object Username
     
    /**
     * <p>Profile default : Password to login into the demo site</p>
     */
    public static Object Password
     
    /**
     * <p>Profile default : Encrypted password to login into the demo site</p>
     */
    public static Object EncryptedPasword
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            BaseURL = selectedVariables['BaseURL']
            Username = selectedVariables['Username']
            Password = selectedVariables['Password']
            EncryptedPasword = selectedVariables['EncryptedPasword']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
