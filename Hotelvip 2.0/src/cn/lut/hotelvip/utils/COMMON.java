package cn.lut.hotelvip.utils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
public class COMMON {
	/**
	 * 去除UUID码的中划线
	 * @return
	 */
	public static String UUID()
	{
		String uuid = UUID.randomUUID().toString();  //36
		StringBuilder sb = new StringBuilder(32);
		
		for(int i=0;i<uuid.length();i++)
		{
			char c = uuid.charAt(i);//获取字符串的每一个字符
			if(c!='_' && c!='-')
			{
				sb.append(c);
			}
		}
		return sb.toString();  //32
	}
	
	/**
	 * 使用md5的算法进行加密
	 */
	public static String md5(String plainText) {
		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(
					plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("没有md5这个算法！");
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
		// 如果生成数字未满32位，需要前面补0
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code = "0" + md5code;
		}
		return md5code;
	}
	/**
	 * 封装 请求对象的参数为指定的类型对象
	 * @param request
	 * @param clazz
	 * @return
	 */
	public static <T> T request2Bean(HttpServletRequest request,Class<T> clazz){  
        try{  
            T bean = clazz.newInstance(); //构造无参对象，需要无参构造函数 
            Enumeration<String> e = request.getParameterNames(); //会返回所以得请求参数的name
            while(e.hasMoreElements()){  
                String name = (String) e.nextElement();     //参数名称
                String value = request.getParameter(name);  //参数的值
                BeanUtils.setProperty(bean, name, value);   //使用beanUtils工具类，它提供了反射。
            }  
            return bean;  
        }catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
	
	

}
