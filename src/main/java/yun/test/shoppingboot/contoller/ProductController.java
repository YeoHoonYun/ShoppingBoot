package yun.test.shoppingboot.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yun.test.shoppingboot.domain.ImageFile;
import yun.test.shoppingboot.domain.Product;
import yun.test.shoppingboot.service.CategoryService;
import yun.test.shoppingboot.service.ImageFileService;
import yun.test.shoppingboot.service.ProductService;
import yun.test.shoppingboot.service.ReviewService;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Calendar;
import java.util.UUID;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ReviewService reviewService;
    private final CategoryService categoryService;
    private final ImageFileService imageFileService;

    @GetMapping("/images/{id}")
    @ResponseBody // 컨트롤러안에서 직접 response를 이용하여 결과를 출력할 때 사용
    public void downloadImage(
            @PathVariable(name = "id") Long id,
            HttpServletResponse response
    ) {
        ImageFile imageFile = imageFileService.getImageFile(id);
        response.setContentType(imageFile.getMimeType());

        try(FileInputStream fis = new FileInputStream(imageFile.getSaveFileName());
            OutputStream out = response.getOutputStream()
        ){
            byte[] buffer = new byte[1024];
            int readCount = 0;

            while((readCount = fis.read(buffer)) != -1){
                out.write(buffer, 0, readCount);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    @GetMapping(value = "/detail")
    public String itemPage(Model model, @RequestParam("id") Long id){
        model.addAttribute("product", productService.productById(id));
        model.addAttribute("reviews", reviewService.getReviewByProductId(id));
        model.addAttribute("categorys",categoryService.categoryListAll());
        return "/product/detail";
    }

    @GetMapping(value = "/write")
    public String productWriteGet(Model model){

        model.addAttribute("categorys",categoryService.categoryListAll());
        return "/product/write";
    }

    @PostMapping(value = "/write")
    public String productWritePost(
                                    @RequestParam(value = "name") String name,
                                    @RequestParam(value = "price") int price,
                                    @RequestParam(value = "quanity") int quanity,
                                    @RequestParam(value = "categoryId") int categoryId,
                                    @RequestParam(name = "image") MultipartFile[] images){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuanity(quanity);
        if(images != null && images.length > 0) {
            for (MultipartFile image : images) {
                ImageFile imageFile = new ImageFile();
                imageFile.setLength(image.getSize());
                imageFile.setMimeType(image.getContentType());
                imageFile.setName(image.getOriginalFilename());
                String saveFileName = saveFile(image);

                imageFile.setSaveFileName(saveFileName); // save되는 파일명
                System.out.println(saveFileName);
                product.addImageFile(imageFile);
            }
        }
        //TODO
        Long companyId = 1L;
        productService.addProduct(product, (long) categoryId, companyId);
        return "redirect:/main";
    }
    private String saveFile(MultipartFile image){
        String dir = "C:\\Users\\Public\\";
        Calendar calendar = Calendar.getInstance();
        dir = dir + calendar.get(Calendar.YEAR);
        dir = dir + "\\";
        dir = dir + (calendar.get(Calendar.MONTH) + 1);
        dir = dir + "\\";
        dir = dir + calendar.get(Calendar.DAY_OF_MONTH);
        dir = dir + "\\";
        File dirFile = new File(dir);
        dirFile.mkdirs(); // 디렉토리가 없을 경우 만든다. 퍼미션이 없으면 생성안될 수 있다.
        dir = dir + UUID.randomUUID().toString();

        try(FileOutputStream fos = new FileOutputStream(dir);
            InputStream in = image.getInputStream()
        ){
            byte[] buffer = new byte[1024];
            int readCount = 0;
            while((readCount = in.read(buffer)) != -1){
                fos.write(buffer, 0, readCount);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return dir;
    }
}
