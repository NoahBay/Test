public class Greece extends Location {
    final String name = "Grækenland";
    public String greeceItem = "Brandværn";

    public String getLocationName() {
        return name;
    }

    @Override
    public String getLocationInformation() {
        return "Information om Grækenland";
    }

    @Override // fordi den ikke har nogen body
    public String addItem() {
        return greeceItem;
    }
}
