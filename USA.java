public class USA extends Location {

    final String name = "USA";
    public String usaItem = "Brandhelikopter";

    public String getLocationName() {
        return name;
    }

    @Override
    public String getLocationInformation() {
        return "Information om USA";
    }

    @Override // fordi den ikke har nogen body
    public String addItem() {
        return usaItem;
    }

}