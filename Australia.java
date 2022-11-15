public class Australia extends Location {
    final String name = "Australien";
    public String australiaItem = "Brandværn";

    public String getLocationName() {
        return name;
    }

    @Override
    public String getLocationInformation() {
        return "Information om Australien";
    }

    @Override // fordi den ikke har nogen body
    public String addItem() {
        return australiaItem;
    }
}
