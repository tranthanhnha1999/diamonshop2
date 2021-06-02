package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Entity.Categorys;
import DiamonShop.Entity.Menus;
import DiamonShop.Entity.Slides;

@Service
public interface IHomeService {
	@Autowired
	public List<Slides> getDataSlides();
	@Autowired
	public List<Categorys> getDataCategorys();
	@Autowired
	public List<Menus> getDataMenus();
	@Autowired
	public List<ProductsDto> getDataProducts();
	
}
