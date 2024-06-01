package ptithcm.utils;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import ptithcm.bean.Image;

public class UploadImage {
	@Autowired
	private static Cloudinary cloudinary;

	public static String add(@ModelAttribute(value = "image") Image image) {
		try {
			Map<String, String> m = cloudinary.uploader().upload(image.getFile().getBytes(),
					ObjectUtils.asMap("resource_type", "auto", "folder", "WebAoQuan/Products","public_id", image.getFile().getOriginalFilename()));
			String image_url = (String) m.get("secure_url");
			return image_url;
		} catch (Exception e) {
			System.out.println("Error upload image " + e.getMessage());
		}
		return null;
	}
}
