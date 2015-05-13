package ipforcity;

import org.apache.commons.lang3.StringUtils;

public class NonEmptyUpperCaseAsciiString {
    
    private final String asciiString;
    
    public NonEmptyUpperCaseAsciiString(String asciiString) throws IllegalArgumentException {
        if (!isUpperCaseAscii(asciiString)) {
            throw new IllegalArgumentException("Not a NonEmptyUpperCaseAsciiString: " + asciiString);
        }
        this.asciiString = asciiString;
    }
    
    public int length() {
        return asciiString.length();
    }
    
    public static boolean isUpperCaseAscii(String s) {
        return StringUtils.isAllUpperCase(s) && 
                StringUtils.isAsciiPrintable(s) && 
                StringUtils.isNotBlank(s);
    }

    @Override
    public String toString() {
        return asciiString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NonEmptyUpperCaseAsciiString that = (NonEmptyUpperCaseAsciiString) o;

        if (asciiString != null ? !asciiString.equals(that.asciiString) : that.asciiString != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return asciiString != null ? asciiString.hashCode() : 0;
    }
}
