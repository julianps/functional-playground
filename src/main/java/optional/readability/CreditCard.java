package optional.readability;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * An immutable DTO for testing.
 *
 * @author Julian Stuecker
 */
@Getter
@AllArgsConstructor(staticName = "of")
public class CreditCard {
	private String cvc;
	private String pan;
	private String expiryDate;
	private String cardHolderFirstName;
	private String cardHolderLastName;
}
