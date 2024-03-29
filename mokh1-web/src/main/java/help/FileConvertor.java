package help;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.primefaces.model.file.UploadedFile;

public class FileConvertor {

	public static String convertTextFile(String txtFile){
		try {
		UUID uuid=UUID.randomUUID();
		byte[] blog = txtFile.getBytes(StandardCharsets.UTF_8);
		File out1 = new File("/home/wildfly/wildfly-18.0.1.Final/fimg/" + uuid+ ".txt");
		InputStream in1 = new ByteArrayInputStream(blog);
		OutputStream outputStream = new FileOutputStream(out1);
		outputStream.write(blog);
		outputStream.flush();
		return uuid.toString();
		}catch (Exception e) {
			//e.printStackTrace();
			//throw new Exception("error blog main entering 1");
			return null;
		}
	}
	
	public static String convertTextFileToText(String textName) throws Exception{
        try {
		File file = new File("/home/wildfly/wildfly-18.0.1.Final/fimg/" + textName + ".txt");
		byte[] bytesArray = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(bytesArray);
		fis.close();
		String string=new String(bytesArray);
		return string;
        }catch (Exception e) {
			throw new Exception("file not find");
		}
      
}
	public static String convertPicture(UploadedFile uploadedFile) throws Exception {
		try {
			UUID uuid = UUID.randomUUID();
			byte[] image1Byte = IOUtils.toByteArray(uploadedFile.getInputStream());
			File out3 = new File("/home/wildfly/wildfly-18.0.1.Final/fimg/" + uuid + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			//BufferedImage scaledImg = Scalr.resize(img3, 800, 1000);
			//ImageIO.write(scaledImg, "jpg", out3);
			ImageIO.write(img3, "jpg", out3);
			return uuid.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new Exception("error image entering 1");
		}

	}
}
