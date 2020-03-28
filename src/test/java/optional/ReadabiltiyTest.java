package optional;

import optional.readability.CreditCard;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * @author Julian Stuecker
 */
public class ReadabiltiyTest extends BaseTest {

    /**
     * Handle Return Values 1:
     *
     * Positive case:
     * Shows, that when a method have problems returning the expected value, Optional is an explicit indicator for this
     * case, the consumer must take care of the returnValue being potentially empty.
     */
    @Test
    public void testReturnTypeBenefits_2() {
        final CreditCard creditCard = CreditCard.of("333", "4242424242424242", "10/20", "Lutz", "Wagner");
        Optional<String> cardHolder = creditCardService.getCardHolderFromCreditCard(creditCard);
        Assert.assertTrue(cardHolder.isPresent());
    }

    /**
     * Handle Return Values 1:
     *
     * Negative case:
     * Shows, that when a method have problems returning the expected value, Optional is an explicit indicator for this
     * case, the consumer must take care of the returnValue being potentially empty.
     */
    @Test
    public void testReturnTypeBenefits_1() {
        final CreditCard creditCard = CreditCard.of("333", "4242424242424242", "10/20", null, null);
        Optional<String> cardHolder = creditCardService.getCardHolderFromCreditCard(creditCard);
        Assert.assertEquals(Optional.empty(), cardHolder);
    }

}
