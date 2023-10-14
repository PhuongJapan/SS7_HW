package ra.entity;

import java.util.Scanner;

public class ProductImp {
    public static void main(String[] args) {
        //Khởi tạo 1 mảng 100 phần tử
    Product[] arrProduct = new Product[100];
        Scanner scanner=new Scanner(System.in);
        int index=0;
        do {
            System.out.println("****************MENU*****************");
            System.out.println("1. Nhập thông tin n sản phẩm (n nhập từ bàn phím)");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Nhập sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Cập nhật trạng thái sản phẩm");
            System.out.println("10. Thoát");
            System.out.print("Sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập số sản phẩm cần nhập thông tin");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        arrProduct[index]=new Product();
                        System.out.println("Nhập vào sản phẩm thứ"+(index+1)+"là:");
                        //Nhập thông tin cho sản phẩm
                        arrProduct[index].inputData(scanner);
                        index++;
                    }
                    break;
                case 2:
                    //Hiển thị thông tin sản phẩm
                    System.out.printf("Thông tin sách là:\n");
                    for (int i = 0; i < index; i++) {
                        arrProduct[i].displayData();
                    }
                    break;
                case 3:
                    System.out.println("Lợi nhuận các sản phẩm là: ");
                    for (int i = 0; i < index; i++) {
                       float profit = arrProduct[i].calProfit();
                        System.out.println("Mã sản phẩm "+arrProduct[i].getProductId()+" có lợi nhuận là: "+profit);
                    }
                    break;
                case 4:
                    //Sắp xếp sp theo lợi nhuận giảm dần
                    for (int i = 0; i < index-1; i++) {
                        for (int j = i+1; j < index; j++) {
                            if (arrProduct[i].calProfit()<arrProduct[j].calProfit()){
                                Product temp = arrProduct[i];
                                arrProduct[i] = arrProduct[j];
                                arrProduct[j] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp sản phẩm theo lợi nhuận giảm dần");
                    break;
                case 5:
                    //Thống kê các sản phẩm theo giá
                    System.out.println("Bạn cần tìm sản phẩm có giá từ: ");
                    float fromPrice = Float.parseFloat(scanner.nextLine());
                    System.out.println("Bạn cần tìm sản phẩm có giá thấp hơn: ");
                    float toPrice = Float.parseFloat(scanner.nextLine());
                    System.out.println("Các sản phẩm nằm trong khoảng giá bạn đang tìm là: ");
                    for (int i = 0; i < index; i++) {
                        float priceOfProducts = arrProduct[i].getExportPrice();
                        if (priceOfProducts>=fromPrice && priceOfProducts<=toPrice){
//                            System.out.println("Mã sản phẩm" + arrProduct[i].getProductId() + " có giá là"+priceOfProducts);
                            arrProduct[i].displayData();
                        }
                    }
                    break;
                case 6:
                    System.out.println("Nhập tên sản phẩm bạn muốn tìm:");
                    String findProductName = scanner.nextLine();
                    boolean isCheckProductName = false;
                    System.out.println("Thông tin sản phẩm bạn cần tìm kiếm là:\n");
                    for (int i = 0; i < index; i++) {
                        if (arrProduct[i].getProductName().contains(findProductName)){
                            arrProduct[i].displayData();
                            isCheckProductName=true;
                        }
                    }
                    if (!isCheckProductName){
                        System.out.println("Không tìm thấy sản phẩm có tên: "+findProductName);
                    }

                    break;
                case 7:
                    //Nhập sản phẩm
                    if (index<arrProduct.length) {
                        System.out.println("Nhập mã sản phẩm: ");
                        String inputProductId = scanner.nextLine();
                        System.out.println("Nhập số lượng sản phẩm cần nhập: ");
                        int inputQuantity = Integer.parseInt(scanner.nextLine());
                        boolean foundInput = false;
                        for (int i = 0; i < index; i++) {
                            if (arrProduct[i].getProductId().equals(inputProductId)) {
                                arrProduct[i].setQuantity(arrProduct[i].getQuantity() + inputQuantity);
                                System.out.println("Đã nhập thêm số lượng " + inputQuantity + "sản phẩm có mã: " + inputProductId);
                                foundInput = true;
                                break;
                            }
                        }

                        if(!foundInput){
                            System.out.println("Không tìm thấy sản phẩm có mã: "+ inputProductId);
                        }
                    }

                    break;
                case 8:
                    //bán sản phẩm
                    System.out.println("Nhập tên sản phẩm cần bán: ");
                    String productNameToSell = scanner.nextLine();
                    System.out.println("Nhập số lượng cần bán:");
                    int quantityToSell = Integer.parseInt(scanner.nextLine());

                    boolean foundSell = false;
                    for (int i = 0; i < index; i++) {
                        if (arrProduct[i].getProductName().equals(productNameToSell)){
                            arrProduct[i].setQuantity(arrProduct[i].getQuantity()-quantityToSell);
                            System.out.println("Đã bán"+quantityToSell+"của sản phẩm có tên"+productNameToSell);
                            foundSell=true;
                        }
                    }
                    if(!foundSell) {
                    System.out.println("Không tìm thấy sản phẩm có tên"+productNameToSell);
                }
                    break;
                case 9:
                    System.out.println("Nhập mã sản phẩm bạn cần cập nhật trạng thái");
                    String productIdToUpdate= scanner.nextLine();
                    boolean update = false;
                    for (int i = 0; i < index; i++) {
                        if (arrProduct[i].getProductId().equals(productIdToUpdate)) {
                            boolean newStatus = !arrProduct[i].isStatus();
                            arrProduct[i].setStatus(newStatus);
                            System.out.println("Sản phẩm có mã: " + productIdToUpdate + "đã được cập nhật trạng thái");
                            update = true;
                            break;
                        }
                    }
                    if (!update){
                        System.out.println("Không tìm thấy sản phẩm có mã: "+productIdToUpdate);
                    }
                    break;
                case 10:
                    //Sửa sản phẩm theo ID
                    System.out.println("Nhập mã sản phẩm cần sửa");
                    String productIdToEditInfo = scanner.nextLine();
                    boolean edit = false;
                    for (int i = 0; i < index; i++) {
                        if (arrProduct[i].getProductId().equals(productIdToEditInfo)){
                            arrProduct[i].inputData(scanner);
                            arrProduct[i].setProductId(productIdToEditInfo);
                            edit=true;
                            break;
                        }
                    }if (!edit){
                    System.out.println("Không tìm thấy sản phẩm có mã: "+productIdToEditInfo);
                }
                    break;

                case 11:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn 1-11");
            }
        } while (true);
    }
    }
