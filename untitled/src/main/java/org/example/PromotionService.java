package org.example;

import java.util.List;

/*
 * W projekcie zastosowano wzorzec projektowy Strategy.
 *
 * Każda promocja implementuje wspólny interfejs Promotion
 * i reprezentuje osobną strategię naliczania rabatu:
 *
 * - Buy2Get1Promotion
 * - PercentageDiscountPromotion
 * - CouponDiscountPromotion
 * - FreeMugPromotion
 *
 * Dzięki temu:
 * - promocje są od siebie niezależne,
 * - można łatwo dodawać nowe typy promocji,
 * - logika promocji jest zamknięta w osobnych klasach,
 * - PromotionService może dynamicznie wykonywać różne strategie.
 *
 */

public class PromotionService {
    private final List<Promotion> promotions;

    public PromotionService(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    private void resetDiscounts(Customer customer) {

        for (CartItem item : customer.getCart().getItems()) {
            item.resetPrice();
        }
    }

    public void addPromotion(Promotion promotion) {
        promotions.add(promotion);
    }

    public void removePromotion(Promotion promotion) {
        promotions.remove(promotion);
    }

    public void applyPromotions(Customer customer) {

        resetDiscounts(customer);

        for (Promotion promotion : promotions) {
            promotion.apply(customer);
        }
    }

}
