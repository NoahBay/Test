public class Brazil extends Location {
    final String name = "Brasilien";
    public String brazilItem = "Brandværn";

    public String getLocationName() {
        return name;
    }

    @Override
    public String getLocationInformation() {
        return "Information om Brasilien";
    }

    @Override // fordi den ikke har nogen body
    public String addItem() {
        return brazilItem;
    }
}
