/*
 * package ptithcm.entity;
 * 
 * import java.util.Collection;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.FetchType; import javax.persistence.Id; import
 * javax.persistence.JoinColumn; import javax.persistence.ManyToOne; import
 * javax.persistence.OneToMany;
 * 
 * @Entity public class OrderDetail {
 * 
 * @Id
 * 
 * @Column(name = "cartDetailId") private String cartDetailId;
 * 
 * @Column(name = "productColorId") private int productColorId;
 * 
 * @Column(name = "accountId") private int accountId;
 * 
 * @Column(name = "quantity") private int quantity;
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "productColorId",insertable = fa;se) private
 * ProductSizeColor productSizeColor;
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "orderId") private Orders orders;
 * 
 * public String getOrderId() { return orderId; }
 * 
 * public void setOrderId(String orderId) { this.orderId = orderId; }
 * 
 * public int getProductSizeColorId() { return productSizeColorId; }
 * 
 * public void setProductSizeColorId(int productSizeColorId) {
 * this.productSizeColorId = productSizeColorId; }
 * 
 * public int getQuantityBought() { return quantityBought; }
 * 
 * public void setQuantityBought(int quantityBought) { this.quantityBought =
 * quantityBought; }
 * 
 * public int getPrice() { return price; }
 * 
 * public void setPrice(int price) { this.price = price; }
 * 
 * 
 * public Orders getOrders() { return orders; }
 * 
 * public void setOrders(Orders orders) { this.orders = orders; }
 * 
 * 
 * }
 */