package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 购物车类
 * @author Doctor邓
 *
 */
public class Cart {
	//购买商品的集合
	private HashMap<Items, Integer> goods;
	
	//购物车的总金额
	private double totalPrice;

	public Cart(){
		goods      = new HashMap<Items, Integer>();
		totalPrice = 0;
	}
	/**
	 * 添加商品进入购物车
	 * @param items   需要添加的商品
	 * @return        添加成功返回true，失败为false
	 */
	public boolean addGoodsInCart(Items items, int number) {
		
		if (goods.containsKey(items)) {
			goods.put(items, number + goods.get(items));
		} 
		else {
			goods.put(items, number);
		}
		/**
		 * 在添加商品后重新计算商品总金额
		 */
		
		calTotalPrice();
		return true;
	}
	/**
	 * 删除商品的方法
	 * @param item    需要删除的商品
	 * @return        删除成功返回true，失败返回false
	 */
	public boolean removeGoodsFromCart(Items item) {
		goods.remove(item);
		/**
		 * 在删除商品后重新计算商品总金额
		 */
		calTotalPrice();
		return true;
	}
	/**
	 * 统计购物车的总金额
	 * @return    返回购物测的总金额
	 */
	public double calTotalPrice() {
		double sum = 0.0;
		/**
		 * 获得键的集合
		 */
		Set<Items> keys = goods.keySet();
		Iterator<Items> it= keys.iterator();
		
		while (it.hasNext()) {
			Items i = it.next();
			sum += i.getPrice() * goods.get(i);
		}
		/**
		 * 设置购物车的总金额
		 */
		this.setTotalPrice(sum);
		return this.getTotalPrice();
	}

	public HashMap<Items, Integer> getGoods() {
		return goods;
	}
	
	public void setGoods(HashMap<Items, Integer> goods) {
		this.goods = goods;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public static void main(String[] args) {
		
		Items i1 = new Items(1, "乌特篮球鞋", "上海",200,500,"001.jpg");
		Items i2 = new Items(2, "李宁运动鞋", "武汉",300,400,"002.jpg");
		Items i3 = new Items(2, "李宁运动鞋", "武汉",300,400,"002.jpg");
		
		Cart c = new Cart();
		c.addGoodsInCart(i1, 3);
		c.addGoodsInCart(i2, 2);
		c.addGoodsInCart(i3, 6);
		//遍历购物商品的集合
		Set<Map.Entry<Items, Integer>>  items = c.getGoods().entrySet();
		for (Map.Entry<Items, Integer> item : items) {
			System.out.println(item);
		}
		
		System.out.println("购物车的总金额:" + c.getTotalPrice());
	}
}
