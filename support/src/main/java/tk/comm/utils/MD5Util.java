package tk.comm.utils;
import java.security.MessageDigest;

/**
 * @author zhou
 * @version V1.0
 * @Description:md5加密工具类
 * @date 2016/8/24 15:25
 */
public class MD5Util 
{
	/**
	 * <p>Title: getMD5By32bit</p> 
	 * <p>Description: 对字符串进行32位MD5加密</p> 
	 * @author jj
	 * @date 2015-4-15
	 * @param str 需要加密的字符串
	 * @param code 字符编码格式
	 * @return
	 */
	public static String getMD5By32bit(String str,String code)
	{
		String md5Str = "";
		try 
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes(code));
			byte b[] = md.digest();
			System.out
			.println(new String(b));
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) 
			{
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			
			// 32位的加密
			md5Str = buf.toString();
			
			//System.out.println("result: " + buf.toString().substring(8, 24));// 16位的加密
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return md5Str;
	}
	
	/**
	 * <p>Title: getMD5ToUpperBy32bit</p> 
	 * <p>Description: 对字符串进行32位MD5加密，并且得到加密字符串为大写</p> 
	 * @author jj
	 * @date 2015-4-15
	 * @param str 需加密的字符串
	 * @param code 字符编码格式
	 * @return
	 */
	public String getMD5ToUpperBy32bit(String str,String code)
	{
		return getMD5By32bit(str,code).toUpperCase();
	}
	
	
	
	public static void main(String args[]) 
	{
		MD5Util m = new MD5Util();
		System.out
			  .println(m
						.getMD5ToUpperBy32bit("InputCharset=1&Version=v1.0&Language=1&SignType=1&PageUrl=http://192.168.0.122/index.do&BgUrl=http://192.168.0.122/index.do&ShowUrl=http://192.168.0.122/index.do&MerchantOrderId=123456789&AssBillNo=123456789&TradeName=电商网站&TradeCode=hg456&SrcNcode=1234567&OrderCommitTime=20071117020101&SenderName=张三&SenderTel=021-888888888&SenderCompanyName=海购购物网站&SenderAddr=芝加哥350号&SenderZip=201020&SenderCity=芝加哥&SenderProvince=伊利诺伊州&SenderCountry=美国&CargoDescript=电器相关物品&AllCargoTotalPrice=3700.00&AllCargoTotalTax=60.58&ExpressPrice=100.50&PayTotalPrice=3861.08&PayCUR=RMB&CrtCountryCode=AO&CrtAccount=356000023&CrtAccountName=李四&CrtCUR=RMB&CargoName=iphone4^GALAXY S4&CargoCode=100000^100001&HSCode=HG-100000^HG1000001&CargoOrigin=美国^加拿大&CargoNum=2^1&CargoUnit=部^部&CargoUnitPrice=1200.00^1300.00&CargoTotalTax=20.50^40.08ds12345","UTF-8"));
	}

}

