package homework;

import org.junit.jupiter.api.*;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

@DisplayName("Класс ClubTest")
public class ClubTest {

    private static final String DANCER_NAME = "Denis";
    private static final String MESSAGE_ALLOWED_LET_PASS = DANCER_NAME + " is allowed to enter the club";
    private static final String MESSAGE_BAN_LET_PASS = DANCER_NAME + " is banned from entering the club";
    private static final String MESSAGE_ALLOWED_LET_OUT = DANCER_NAME + " is allowed to leave the club";
    private static final String MESSAGE_BAN_LET_OUT = DANCER_NAME + " is prohibited from leaving the club";


    private Club club;
    private static Dancer dancer;
    private Security security;

    @BeforeAll
    public static void setUpClass() {
        dancer = Mockito.mock(Dancer.class);
        BDDMockito.given(dancer.getName()).willReturn(DANCER_NAME);
    }

    @BeforeEach
    public void setUp() {
        security = Mockito.mock(Security.class);
        club = new Club(100, security, DressCode.GREEN_STYLE);
    }

    @DisplayName("должен вывести сообщениие об успешном разрешении входа для человека")
    @Test
    public void shouldAllowLetPassForDancer() throws DancerNotFoundException {
        BDDMockito.given(security.isAllowedPass(Mockito.any(Dancer.class), Mockito.any(DressCode.class), Mockito.anyInt())).willReturn(true);

        String exceptedMessage = MESSAGE_ALLOWED_LET_PASS;

        String actualMessage = club.letPass(dancer);

        Assertions.assertEquals(exceptedMessage, actualMessage);
    }

    @DisplayName("должен вывести сообщениие о запрете входа для человека")
    @Test
    public void  shouldBanLetPassForDancer() throws DancerNotFoundException {
        BDDMockito.given(security.isAllowedPass(Mockito.any(Dancer.class), Mockito.any(DressCode.class), Mockito.anyInt())).willReturn(false);

        String exceptedMessage = MESSAGE_BAN_LET_PASS;

        String actualMessage = club.letPass(dancer);

        Assertions.assertEquals(exceptedMessage, actualMessage);
    }


    @DisplayName("должен вывести сообщениие об разрешении выпустить человека")
    @Test
    public void shouldAllowLetOutForDancer() {
        BDDMockito.given(security.isAllowedOut(dancer)).willReturn(true);

        String exceptedMessage = MESSAGE_ALLOWED_LET_OUT;

        String actualMessage = club.letOut(dancer);

        Assertions.assertEquals(exceptedMessage, actualMessage);
    }

    @DisplayName("должен вывести сообщениие о запрете выхода человеку")
    @Test
    public void  shouldBanLetOutForDancer() {
        BDDMockito.given(security.isAllowedOut(dancer)).willReturn(false);

        String exceptedMessage = MESSAGE_BAN_LET_OUT;

        String actualMessage = club.letOut(dancer);

        Assertions.assertEquals(exceptedMessage, actualMessage);
    }

    @DisplayName("должен должен единажды вызвать метод разрешения у охраны")
    @Test
    public void  mustCallMethodFromTheSecurityClassOnce() {
        BDDMockito.given(security.isAllowedOut(dancer)).willReturn(false);
        club.letOut(dancer);
        Mockito.verify(security, Mockito.times(1)).isAllowedOut(dancer);
    }

    @DisplayName("должен кидать нужное исключение, когда зависимость возвращает null вместо танцора")
    @Test
    public void shouldThrowExceptedExceptionWhenDependencyReturnNullInstatedOfDancer(){
        Assertions.assertThrows(DancerNotFoundException.class, () ->
                club.letPass(null));
    }

}


