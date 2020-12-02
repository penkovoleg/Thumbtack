package net.thumbtack.school.colors.v3;

public enum Color {
    RED, GREEN, BLUE;

    public static Color colorFromString(String colorString) throws ColorException {
        try{
            return Color.valueOf(colorString);
        }
        catch (IllegalArgumentException ex){
            throw new ColorException(ColorErrorCode.WRONG_COLOR_STRING);
        }
        catch (NullPointerException ex){
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
    }

    public static void colorEqualsNull(Color color) throws ColorException {
        if(color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
    }
}
