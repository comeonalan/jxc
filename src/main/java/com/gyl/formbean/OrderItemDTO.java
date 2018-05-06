package com.gyl.formbean;

public class OrderItemDTO {
	
	   private long id;
	   //货物型号
		private String productType;

		// 厂家名称
		private String venderName;

		// 货物数量
		private int quantity;

		// 厂家单价
		private float venderUnitPrice;

		// 出售单价
		private float sellUnitPrice;
		
		private long orderId;

		public String getProductType() {
			return productType;
		}

		public void setProductType(String productType) {
			this.productType = productType;
		}

		public String getVenderName() {
			return venderName;
		}

		public void setVenderName(String venderName) {
			this.venderName = venderName;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public float getVenderUnitPrice() {
			return venderUnitPrice;
		}

		public void setVenderUnitPrice(float venderUnitPrice) {
			this.venderUnitPrice = venderUnitPrice;
		}

		public float getSellUnitPrice() {
			return sellUnitPrice;
		}

		public void setSellUnitPrice(float sellUnitPrice) {
			this.sellUnitPrice = sellUnitPrice;
		}

		public long getOrderId() {
			return orderId;
		}

		public void setOrderId(long orderId) {
			this.orderId = orderId;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}
		
		
}
