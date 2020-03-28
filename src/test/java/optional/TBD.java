package optional;

import io.vavr.control.Option;
import optional.readability.CreditCard;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;


public class TBD extends BaseTest {

   @Test
   public void testStream() {
      Optional<CreditCard> creditCard = creditCardService.getCreditCard();
      creditCard.stream().forEach(c -> System.out.println(c.getCardHolderFirstName()));
   }


   /**
    * Explanation:
    * A none in Java is an Optional.empty.
    * A some in Java is an Optional[1] (e.g. for Integer)
    *
    *
    * Refers to the Blog-Article:
    * http://blog.vavr.io/the-agonizing-death-of-an-astronaut/
    *
    * Shows, that Java does not obey to the monad law of preserving computational context.
    * map() is meant to do this by monadic law.
    * In this example, The computational context changes:
    *
    */
   @Test
   public void testComputationalContextWithJava() {
      // A valid "Some(1)"
      Optional<Integer> intSome = Optional.of(1);

      // maps 1 to null and creates a NONE (mapping from Some to None)
      Optional<String> stringSome = intSome.map(i -> null);
      Assert.assertNotEquals(stringSome, Optional.empty());

      // Call "null.intern()" when stick to monads, this should throw a NPE
      String s = stringSome.map(String::intern).orElse("");
   }

   @Test
   public void testComputationalContextWithVavr() {
      // A valid "Some(1)"
      Option<Integer> intSome = Option.of(1);

      // A "Some(null)"
      Option<String> stringSome = intSome.map(i -> null);

      // Call "null.intern()"
      String s = stringSome.map(String::intern).getOrElse("");

      // s is not null but ""
      Assert.assertNotNull(s);
   }
}

