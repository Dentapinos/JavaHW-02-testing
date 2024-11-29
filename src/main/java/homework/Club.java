package homework;

import java.util.ArrayList;
import java.util.List;

public class Club {
    private final int capacity;
    private final Security security;
    private final DressCode dressCode;
    private List<Dancer> dancers = new ArrayList<Dancer>();

    public Club(int capacity, Security security, DressCode dressCode) {
        this.capacity = capacity;
        this.security = security;
        this.dressCode = dressCode;
    }

    public List<Dancer> getDancers() {
        return dancers;
    }

    public String letPass(Dancer dancer) throws DancerNotFoundException {
        boolean isAllowedSecurity = security.isAllowedPass(dancer, dressCode, capacity);

        if (dancer == null) {
            throw new DancerNotFoundException("dancer not found");
        }

        if (isAllowedSecurity) {
            dancers.add(dancer);
            return "\u001b[32m" + dancer.getName() + " is allowed to enter the club \u001b[0m";
        }

        return "\u001b[31m" +  dancer.getName() + " is banned from entering the club \u001b[0m";
    }


    public String letOut(Dancer dancer) {
        boolean isAllowedSecurity = security.isAllowedOut(dancer);

        if (isAllowedSecurity) {
            dancers.remove(dancer);
            return "\u001b[32m" +  dancer.getName() + " is allowed to leave the club \u001b[0m";
        }

        return "\u001b[31m" +  dancer.getName() + " is prohibited from leaving the club \u001b[0m";
    }
}

