package com.proyecto.ecommerce.dto;

import java.util.List;
import java.util.Set;

import com.proyecto.ecommerce.model.Category;

public class ProductDTO{
		private Integer productId;
		private String productName;
		private Double price;
		private String description;
		private Boolean state;
		//private String image;
		private List<CategoryDTO> categories;
		
		
		
		public ProductDTO(Integer productId, String productName, Double price, String description, Boolean state,
				/*String imageUrl,*/ List<CategoryDTO> categories) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.price = price;
			this.description = description;
			this.state = state;
			//this.image = imageUrl;
			this.categories = categories;
		}
		
		public Integer getProductId() {
			return productId;
		}
		public void setProductId(Integer productId) {
			this.productId = productId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Boolean getState() {
			return state;
		}
		public void setState(Boolean state) {
			this.state = state;
		}
		/*public String getImageUrl() {
			return image;
		}
		public void setImageUrl(String imageUrl) {
			this.image = imageUrl;
		}*/
		public List<CategoryDTO> getCategories() {
			return categories;
		}
		public void setCategories(List<CategoryDTO> categories) {
			this.categories = categories;
		}
	
		
}
	
