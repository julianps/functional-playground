package optional.readability;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import lombok.Getter;

/**
 * Some data for testing.
 *
 * @author Julian Stuecker
 */
public class CreditCardService {

	/**
	 * returns four (4) elements, one of it is empty
 	 */
	private final List<Optional<CreditCard>> creditCards = Arrays.asList(
			Optional.of(CreditCard.of(String.valueOf(737), "4444333322221111", "10/20", "Julian", "Stücker")),
			Optional.of(CreditCard.of(String.valueOf(636), null, "10/20", "Ralf", "Stücker")),
			Optional.of(CreditCard.of(null, "8888777733334444", "07/30", "Lisa", "Huertgen")),
			Optional.empty());


	public final List<Optional<CreditCard>> getStoredCreditCards() {
		return creditCards;
	}

	public Optional<String> getCardHolderFromCreditCard(final CreditCard creditCard) {
		if(creditCard.getCardHolderLastName() != null && creditCard.getCardHolderLastName() != null){
			return Optional.of(creditCard.getCardHolderFirstName() + " " + creditCard.getCardHolderLastName());
		} else {
			return Optional.empty();
		}
	}

}