package pl.mzuchnik.kursspringbootpracadomowa2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.mzuchnik.kursspringbootpracadomowa2.model.Product;

import java.math.BigDecimal;
import java.util.List;

@Service
@Profile("start")
public class StartShop {

    private List<Product> productList;

    public StartShop(){}

    @Autowired
    public StartShop(List<Product> products){
        productList = products;
    }

    public final BigDecimal getNetTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Product p : productList) {
            totalPrice = totalPrice.add(p.getPrice());
        }
        return totalPrice;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void printNetTotalPrice()
    {
        System.out.println("Łączna cena za zakupy 'StartShop' : " + getNetTotalPrice().doubleValue() + " zł(Netto)");
    }

    public List<Product> getProductList() {
        return productList;
    }
    public final void addProduct(Product newProduct) {
        productList.add(newProduct);
    }
}
