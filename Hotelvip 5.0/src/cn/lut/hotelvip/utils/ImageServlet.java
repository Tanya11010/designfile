package cn.lut.hotelvip.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 计算机生成图片
 */
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//告诉客户端不使用缓存【浏览器默认情况对相同地址和相同名称的图片不会从新发送请求】
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setIntHeader("expires", 0);
		//生成验证码图片
		BufferedImage img = drawValidateCode(request);
		//将图片对象以流的方式输出的客户端
		ImageIO.write(img, "jpg", response.getOutputStream());

	}
	private BufferedImage drawValidateCode(HttpServletRequest request) throws IOException {
		int width = 150;
		int height = 40;
		
		//在内存中创建一个图像对象
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//创建一个画板
		Graphics g = img.getGraphics(); //Graphics 绘图工具类 
		
		//给图片添加前景色
		g.setColor(Color.WHITE);//设置一个颜色
		g.fillRect(1, 1, width-2, height-2);//填充颜色
		
		//给边框一个色
		g.setColor(Color.RED);
		g.drawRect(0, 0, width-1, height-1);//设置边框的显示坐标
		
		//设置文本样式
		g.setColor(Color.BLUE);
		g.setFont(new Font("宋体", Font.BOLD|Font.ITALIC, 15));
		
		//给图片添加文本
		Random rand = new Random();
		int position = 20;
		String imagecode="";
		for (int i = 0; i < 4; i++) {
			imagecode+=rand.nextInt(10)+"";
		}
		//imagecode= "2248"
		request.getSession().setAttribute("imgcodestr", imagecode); //把每个用户访问的图片验证码就存入到Session。
		
		g.drawString(imagecode, position, 20);//给图片填充文本

		//添加9条干扰线
		for (int i = 0; i < 9; i++) {
			g.drawLine(rand.nextInt(width), rand.nextInt(height), rand.nextInt(width), rand.nextInt(height));
		}
		
		return img;
	}



}
