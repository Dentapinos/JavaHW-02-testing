package homework;

public class Club {
    private final int capacity;
    private final Security security;
    private final DressCode dressCode;

    public Club(int capacity, Security security, DressCode dressCode) {
        this.capacity = capacity;
        this.security = security;
        this.dressCode = dressCode;
    }

    public String letPass(Dancer dancer) throws dancerNotFoundException {
        boolean isAllowedSecurity = security.isAllowedPass(dancer, dressCode, capacity);

        if (dancer == null) {
            throw new dancerNotFoundException("dancer not found");
        }

        if (isAllowedSecurity) {
            return dancer.getName() + " is allowed to enter the club";
        }

        return dancer.getName() + " is banned from entering the club";
    }


    public String letOut(Dancer dancer) {
        boolean isAllowedSecurity = security.isAllowedOut(dancer);

        if (isAllowedSecurity) {
            return dancer.getName() + " is allowed to leave the club";
        }

        return dancer.getName() + " is prohibited from leaving the club";
    }
}

