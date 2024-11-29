package homework;

public class Security {
    private static int occupied = 0;
    private final static int vipPlaces = 20;
    private final DayOfWeek dayOfWeek;
    private static int ids = 0;

    public static int getIds() {
        return ++ids;
    }

    public Security(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public boolean isAllowedPass(Dancer dancer, DressCode dressCode, int capacity) {
        switch (dayOfWeek){
            case TUESDAY -> {
                System.out.println("Выходной, иди домой!!!");
                return false;
            }

            case FRIDAY -> {
                if (dancer.getDressCode().equals(dressCode) && capacity + vipPlaces > occupied){
                    dancer.setId(Security.getIds());
                    occupied++;
                    return true;
                }
            }

            default -> {
                if (dancer.getDressCode().equals(dressCode) && capacity > occupied){
                    dancer.setId(Security.getIds());
                    occupied++;
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isAllowedOut(Dancer dancer) {
        if (!dancer.isDebt()){
            occupied--;
            return true;
        }
        return false;
    }
}
