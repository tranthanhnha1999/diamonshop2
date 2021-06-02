package DiamonShop.Service.User;


import java.util.List;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.ProductsDto;

@Service
public interface IProductService {
	public ProductsDto getProductByID(long id);
	
	public List<ProductsDto> getProductByIDCategory(int id);


}
