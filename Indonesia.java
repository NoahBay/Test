public class Indonesia extends Location {
    final String name = "Indonesien";
    public String indonesiaItem = "Brandværn";

    public String getLocationName() {
        return name;
    }

    @Override
    public String getLocationInformation() {
        return "Information om Indonesien";
    }

    @Override // fordi den ikke har nogen body
    public String addItem() {
        return indonesiaItem;
    }
}
