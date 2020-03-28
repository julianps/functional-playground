package optional.readability;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Some data for testing.
 *
 * @author Julian Stuecker
 */
public class CreditCardService {

	/**
	 * Simulates the result of a database fetch and holds
	 * four (4) elements, one of it is empty / invalid
 	 */
	private final List<Optional<CreditCard>> creditCards = Arrays.asList(
			Optional.of(CreditCard.of(String.valueOf(737), "4444333322221111", "10/20", "Julian", "Stücker")),
			Optional.of(CreditCard.of(String.valueOf(636), null, "10/20", "Ralf", "Stücker")),
			Optional.of(CreditCard.of(null, "8888777733334444", "07/30", "Lisa", "Huertgen")),
			Optional.empty());


	public final List<Optional<CreditCard>> getStoredCreditCards() {
		return creditCards;
	}

	public final Optional<CreditCard> getCreditCard() {
		return Optional.of(CreditCard.of(String.valueOf(737), "4444333322221111", "10/20", "Julian", "Stücker"));
	}

	public final Optional<CreditCard> getEmptyCreditCard() {
		return Optional.empty();
	}

	/**
	 * A method which might having problems to return a valid result based on the input parameters.
	 *
	 * @param creditCard - is a wrapper Object which can have empty fields.
	 * @return An Optional of type String
	 */
	public Optional<String> getCardHolderFromCreditCard(final CreditCard creditCard) {
		if(creditCard.getCardHolderLastName() != null && creditCard.getCardHolderLastName() != null){
			final String returnValue = creditCard.getCardHolderFirstName() + " " + creditCard.getCardHolderLastName();
			return Optional.of(returnValue);
		} else {
			return Optional.empty();
		}
	}
}
