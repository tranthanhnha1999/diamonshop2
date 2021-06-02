package DiamonShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Service.User.ProductSericeImpl;

@Controller
public class ProductController extends BaseController {
	
	@Autowired
	private ProductSericeImpl _productsService;
	
	@RequestMapping(value = { "chi-tiet-san-pham/{id}"})
	public ModelAndView Index(@PathVariable long id) {		
		_mvShare.setViewName("user/products/product");
		_mvShare.addObject("product",_productsService.getProductByID(id) );
		int idCategory =_productsService.getProductByID(id).getId_category();
		_mvShare.addObject("productByIDCategory",_productsService.getProductByIDCategory(idCategory) );
		return _mvShare;
	}
}
