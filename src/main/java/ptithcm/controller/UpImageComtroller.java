package ptithcm.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import ptithcm.bean.Image;

@Controller
public class UpImageComtroller {
	@Autowired
	private Cloudinary cloudinary;

	@RequestMapping("/images")
	public String list(Model model){
		try {
			model.addAttribute("image", new Image());
			cloudinary.uploader().destroy("WebAoQuan/Products/anime.jpg", ObjectUtils.emptyMap());
			return "page/upload-image";
			
		} catch (Exception e) {
			System.out.println("Xoa that baij");
			// TODO: handle exception
		}
		return "page/upload-image";
		
	}

	@RequestMapping(value = "/images/upload", method = RequestMethod.POST)
	public String add(@ModelAttribute(value = "image") Image image) {
		try {
			Map<String, String> m = cloudinary.uploader().upload(image.getFile().getBytes(),
					ObjectUtils.asMap("resource_type", "auto", "folder", "WebAoQuan/Products","public_id", image.getFile().getOriginalFilename()));
			String i = (String) m.get("secure_url");
			System.out.println(i);
			
			return "redirect:/";
		} catch (Exception e) {
			System.out.println("Error upload image " + e.getMessage());
		}
		return "page/upload-image";
	}

	public String uploadImageToFolder(MultipartFile file, String folderName) throws IOException {
		// Upload the image to Cloudinary with the specified folder
		Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("folder", folderName));

		// Retrieve the URL of the uploaded image
		return (String) uploadResult.get("url");
	}
}
