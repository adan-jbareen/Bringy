package bringy;
import java.io.BufferedReader;
import java.io.File;
import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.imageio.ImageIO;
public class DownloadImage {
	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);

		byte[] b = new byte[2048];
		int length;
		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}
		is.close();
		os.close();
	}
	public static void main(String[] args) throws IOException {
		String imageUrl;
		String destinationFile;
		int i = 1;
		File file = new File("plaintext_file.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while ((st = br.readLine()) != null) {
			imageUrl = st;
			destinationFile = "image" + String.valueOf(i) + ".jpg";
			saveImage(imageUrl, destinationFile);
			i++;
		}
		System.out.println("the img is save");
	}
}