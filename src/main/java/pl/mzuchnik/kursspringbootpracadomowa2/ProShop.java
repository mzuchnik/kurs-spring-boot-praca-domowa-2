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
@Profile("pro")
public class ProShop extends PlusShop {

    public ProShop(){}

    @Autowired
    public ProShop(List<Product> products, Cost cost) {
        super(products, cost);
    }

    public BigDecimal getTotalPriceWithRabat() {
        BigDecimal grossTotalPrice = getGrossTotalPrice();
        BigDecimal totalPriceWithRabat = new BigDecimal(100).subtract(getCost().getRabat()).divide(new BigDecimal(100)).multiply(grossTotalPrice);
        return totalPriceWithRabat;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void printGrossNetAndRabatTotalPrice() {
        System.out.println("Łączna cena za zakupy 'ProShop' : " + getNetTotalPrice().doubleValue() + " zł(Netto), "
                + getGrossTotalPrice().doubleValue() + " zł(Brutto), " + getTotalPriceWithRabat().doubleValue() + " zł(Po Rabacie: " + getCost().getRabat() + "%)");
    }
}
