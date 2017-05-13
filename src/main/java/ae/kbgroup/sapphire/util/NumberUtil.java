package ae.kbgroup.sapphire.util;

public class NumberUtil {
	
	
	public static boolean isValidNumber(Long no){
		if(null != no && no > 0){
			return true;
		}
		return false;
	}

}
