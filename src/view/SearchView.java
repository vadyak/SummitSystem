package view;

public class SearchView {
    public void showSearchResult(String resultCountry, String resultMonth, StringBuffer resultDays){
        System.out.print("Всех устраивает " + resultCountry);
        System.out.print(resultMonth + " месяц, даты: ");
        System.out.println(resultDays);
    }
}
