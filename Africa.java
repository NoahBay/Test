import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Africa extends Location {

    final String name = "Sydafrika";
    public String africaItem = "Brandværn";

    public String getLocationName() {
        return name;
    }

    @Override
    public String getLocationInformation() {
        return "Information om Sydafrika";
    }

    @Override // fordi den ikke har nogen body
    public String addItem() {
        return africaItem;
    }

}
