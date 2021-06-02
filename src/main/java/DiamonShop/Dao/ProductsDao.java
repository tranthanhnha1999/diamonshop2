package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Dto.ProductsDtoMapper;
@Repository
public class ProductsDao extends BaseDao{
	private final boolean yes = true;
	private final boolean no = false;
	
	private StringBuffer SqlString() {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("p.id as id_product ");
		sql.append(",p.id_category ");
		sql.append(",p.sizes ");
		sql.append(",p.name ");
		sql.append(",p.price ");
		sql.append(",p.sale ");
		sql.append(",p.title ");
		sql.append(",p.highlight ");
		sql.append(",p.new_product ");
		sql.append(",p.details ");
		sql.append(",p.created_at ");
		sql.append(",p.updated_at ");
		sql.append(",c.id as id_color ");
		sql.append(",c.name as name_color ");
		sql.append(",c.code as code_color ");
		sql.append(",c.img ");
		sql.append("FROM ");
		sql.append("products AS p ");
		sql.append("INNER JOIN ");
		sql.append("colors as c ");
		sql.append("ON p.id = c.id_product ");
		return sql;
	}
	private String SqlProduct(boolean highlight,boolean new_product) {
		StringBuffer sql= SqlString();
		sql.append("WHERE 1 = 1 ");
		if(highlight) {
			sql.append("AND p.highlight = true ");
		}
		if(new_product) {
			sql.append("AND p.new_product = true ");
		}
		sql.append("GROUP BY p.id,c.id_product ");
		sql.append("ORDER BY RAND() ");
		if(new_product) {
			sql.append("LIMIT 12 ");
		}
		if(highlight) {
			sql.append("LIMIT 9 ");
		}
		return sql.toString();
	}
	private StringBuffer SqlProductByID(int id) {
		StringBuffer sql= SqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND id_category = " + id + "");
		return sql;
	}
	private String SqlProductPaginate(int id,int start,int totalPage) {
		StringBuffer sql= SqlProductByID(id);
		sql.append(" LIMIT " + start +"," + totalPage);
		return sql.toString();
	}
	
	public List<ProductsDto> getDataProducts() {
		String sql = SqlProduct(yes,no);
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql,new ProductsDtoMapper());
			return listProducts;
	}
	public List<ProductsDto> getAllProductsByID(int id) {
		String sql = SqlProductByID(id).toString();
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql,new ProductsDtoMapper());
			return listProducts;
	}
	public List<ProductsDto> getDataProductsPaginate(int id,int start,int totalPage) {
		StringBuffer sqlGetDataByID= SqlProductByID(id);
		List<ProductsDto> listProductsByID = _jdbcTemplate.query(sqlGetDataByID.toString(),new ProductsDtoMapper());
		List<ProductsDto> listProducts = new ArrayList<ProductsDto>();
		if(listProductsByID.size() >0) {
			String sql = SqlProductPaginate(id,start, totalPage);
			listProducts = _jdbcTemplate.query(sql,new ProductsDtoMapper());
		}
		return listProducts;
	}
	
	private String SqlproductByID(long id) {
		StringBuffer sql= SqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND p.id = " + id + " ");
		sql.append("LIMIT 1 ");
		return sql.toString();
	}
	
	
	public List<ProductsDto> getProductByID(long id) {
		String sql = SqlproductByID(id);
		List<ProductsDto> listproduct = _jdbcTemplate.query(sql,new ProductsDtoMapper());
		return listproduct;
	}
	
	public ProductsDto FindProductByID(long id) {
		String sql = SqlproductByID(id);
		ProductsDto product = _jdbcTemplate.queryForObject(sql, new ProductsDtoMapper());
		return product;
	}
}
