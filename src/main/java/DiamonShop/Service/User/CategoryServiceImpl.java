package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.ProductsDao;
import DiamonShop.Dto.ProductsDto;
@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	private ProductsDao productsDao;
	
	
	public List<ProductsDto> getAllProductsByID(int id) {
		
		return productsDao.getAllProductsByID(id);
	}
	public List<ProductsDto> getDataProductsPaginate(int id,int start, int totalPage) {
		return productsDao.getDataProductsPaginate(id,start, totalPage);
	}
	public List<ProductsDto> getDataProductsPaginate(int start, int totalPage) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
