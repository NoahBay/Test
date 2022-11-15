public class Portugal extends Location{
    final String name = "Portugal";
    public String portugalItem = "Brandværn";

    public String getLocationName() {
        return name;
    }

    @Override
    public String getLocationInformation() {
        return "Information om Portugal";
    }

    @Override // fordi den ikke har nogen body
    public String addItem() {
        return portugalItem;
    }
}
