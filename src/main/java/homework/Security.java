package homework;

public class Security {
    private static int occupied = 0;
    private final static int vipPlaces = 20;
    private final DayOfWeek dayOfWeek;

    public Security(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public static void setOccupied(int occupied) {
        Security.occupied = occupied;
    }

    public boolean isAllowedPass(Dancer dancer, DressCode dressCode, int capacity) {

        switch (dayOfWeek){
            case TUESDAY -> {
                return false;
            }

            case FRIDAY -> {
                if (dancer.getDressCode().equals(dressCode) && capacity + vipPlaces > occupied){
                    occupied++;
                    return true;
                }
            }

            default -> {
                if (dancer.getDressCode().equals(dressCode) && capacity > occupied){
                    occupied++;
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isAllowedOut(Dancer dancer) {
        if (dancer.isDebt()){
            occupied--;
            return true;
        }
        return false;
    }
}
