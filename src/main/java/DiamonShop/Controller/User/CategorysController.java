package DiamonShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.PaginatesDto;
import DiamonShop.Service.User.CategoryServiceImpl;
import DiamonShop.Service.User.PaginatesServiceImpl;
@Controller
public class CategorysController extends BaseController{
	@Autowired
	private CategoryServiceImpl categoryService;
	@Autowired
	private PaginatesServiceImpl paginatesService;
	@RequestMapping(value = "/san-pham/{id}")	
	public ModelAndView Product(@PathVariable String id) {
		int totalProductsPage = 9;
		_mvShare.setViewName("user/products/category");
		int totalData = categoryService.getAllProductsByID(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo =paginatesService.getInfoPaginates(totalData, totalProductsPage, 1);
		_mvShare.addObject("idcatagory", id);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("ProductsPginate", categoryService.getDataProductsPaginate(Integer.parseInt(id),paginateInfo.getStart(),totalProductsPage));
		return _mvShare;
	}
	@RequestMapping(value = "/san-pham/{id}/{currentPage}")	
	public ModelAndView Product(@PathVariable String id , @PathVariable String currentPage) {
		int totalProductsPage = 9;
		_mvShare.setViewName("user/products/category");
		int totalData = categoryService.getAllProductsByID(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo =paginatesService.getInfoPaginates(totalData, totalProductsPage,Integer.parseInt(currentPage) );
		_mvShare.addObject("idcatagory", id);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("ProductsPginate", categoryService.getDataProductsPaginate(Integer.parseInt(id),paginateInfo.getStart(),totalProductsPage));
		return _mvShare;
	}
	

}
