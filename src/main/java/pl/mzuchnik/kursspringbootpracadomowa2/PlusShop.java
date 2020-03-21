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
@Profile("plus")
public class PlusShop extends StartShop {

    private Cost cost;

    public PlusShop(){}

    @Autowired
    public PlusShop(List<Product> products, Cost cost) {
        super(products);
        this.cost = cost;
    }

    public BigDecimal getGrossTotalPrice() {
        BigDecimal netTotalPrice = super.getNetTotalPrice();
        BigDecimal grossTotalPrice = getCost().getVat().add(new BigDecimal(100)).divide(new BigDecimal(100)).multiply(netTotalPrice);
        return grossTotalPrice;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void printGrossAndNetTotalPrice() {
        System.out.println("Łączna cena za zakupy 'PlusShop' : " + getNetTotalPrice().doubleValue() + " zł(Netto), "
                 + getGrossTotalPrice().doubleValue() + " zł(Brutto) ");
    }
    public void printGrossTotalPrice() {
        System.out.println("Łączna cena za zakupy 'PlusShop' : " + getGrossTotalPrice().doubleValue() + "zł(Brutto)");
    }

    public Cost getCost() {
        return cost;
    }
}
