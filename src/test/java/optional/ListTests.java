package optional;

import optional.readability.CreditCard;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ListTests extends BaseTest {

    /**
     * Handle Collection Return Values 1:
     *
     * Shows, that when a method returns List with Optional Elements, the flatMap method
     * can be used to automatically remove Empty Optionals from computation.
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
}
