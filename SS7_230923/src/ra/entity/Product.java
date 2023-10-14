package ra.entity;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;
    public Product() {

    }

    public Product(String productId, String productName, float importPrice,
                   float exportPrice, float profit, int quantity,
                   String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
    }



    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
//    public String getStatus(){
//        if (this.status){
//            return "Đang bán";
//        }else {
//            return "Không bán";
//        }
//    }
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public void inputData(Scanner scanner){
        System.out.println("Nhập mã sản phẩm");
        this.productId = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm");
        this.productName = scanner.nextLine();
        System.out.println("Nhập giá nhập");
        this.importPrice= Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập giá xuất");
        this.exportPrice= Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập số lượng");
        this.quantity=Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mô tả sản phẩm");
        this.descriptions=scanner.nextLine();
        System.out.println("Nhập trạng thái sản phẩm");
        this.status=Boolean.parseBoolean(scanner.nextLine());

    }
    public float calProfit(){
        return (this.exportPrice-this.importPrice);
    }
    public void displayData(){
        System.out.printf("Mã sản phẩm: %s - Tên sản phẩm: %s - Giá nhập: %.2f  -Giá xuất: %.2f - Lợi nhuận: %.2f - Số lượng: %d - Mô tả: %s - Trạng thái: %s\n",
                this.productId,this.productName,this.importPrice,this.exportPrice,this.calProfit(),
                this.quantity,this.descriptions,(this.status?"Đang bán":"Không bán"));
    }


}
