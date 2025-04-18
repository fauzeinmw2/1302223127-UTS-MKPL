package lib;

import java.util.LinkedList;
import java.util.List;

public class Family {
    private String spouseName;
    private String spouseIdNumber;
    private List<String> childNames = new LinkedList<>();
    private List<String> childIdNumbers = new LinkedList<>();

    public void setSpouse(String name, String idNumber) {
        this.spouseName = name;
        this.spouseIdNumber = idNumber;
    }

    public void addChild(String name, String idNumber) {
        childNames.add(name);
        childIdNumbers.add(idNumber);
    }

    public boolean hasSpouse() {
        return spouseIdNumber != null && !spouseIdNumber.isEmpty();
    }

    public int getNumberOfChildren() {
        return childIdNumbers.size();
    }
}
