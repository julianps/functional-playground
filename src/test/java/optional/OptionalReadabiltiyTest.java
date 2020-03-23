package optional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import optional.readability.CreditCard;
import optional.readability.CreditCardService;

/**
 * @author Julian Stuecker
 */
public class OptionalReadabiltiyTest {

	final CreditCardService creditCardService = new CreditCardService();


	/**
	 * Ein Service gibt eine Liste mit Optionalen Elementen zurück.
	 * - davon könnten welche empty sein.
	 * - Wie geht ein Consumer damit um?
	 * - flatMap
	 */
	@Test
	public void testListWithFlatMap() {
		final List<CreditCard> creditCards =
				creditCardService.getStoredCreditCards()
						.stream()
						.flatMap(Optional::stream)
						.collect(Collectors.toList());

		// Optional.empty is gone due to flatMap
		Assert.assertEquals(3, creditCards.size());
	}

	/**
	 * Negative case:
	 * Shows, that when a method have problems returning the expected value, Optional is an explicit indicator for this
	 * case, the consumer must take care of.
	 */
	@Test
	public void testReturnTypeBenefits_1() {
		final CreditCard creditCard = CreditCard.of("333", "4242424242424242", "10/20", null, null);
		Optional<String> cardHolder = creditCardService.getCardHolderFromCreditCard(creditCard);
		Assert.assertEquals(Optional.empty(), cardHolder);
	}

	/**
	 * Positive case:
	 * Shows, that when a method have problems returning the expected value, Optional is an explicit indicator for this
	 * case, the consumer must take care of.
	 */
	@Test
	public void testReturnTypeBenefits_2() {
		final CreditCard creditCard = CreditCard.of("333", "4242424242424242", "10/20", "Lutz", "Wagner");
		Optional<String> cardHolder = creditCardService.getCardHolderFromCreditCard(creditCard);
		Assert.assertTrue(cardHolder.isPresent());
	}

}
